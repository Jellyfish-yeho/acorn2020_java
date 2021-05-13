package test.study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//프레임을 만들 JFrame, 버튼에 동작을 등록할 ActionListener, 키보드 입력을 받을 KeyListener 
public class ClientMain extends JFrame implements ActionListener, KeyListener{
	//텍스트 입력창, 소켓, 데이터 줄단위 보내기, 텍스트 출력창,대화명,리스트
	JTextField tf_msg;
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	String chatName;
	JList<String> jList;
	//기본생성자
	public ClientMain() {
		//레이아웃 - 보더레이아웃
		setLayout(new BorderLayout());
		//패널생성, 색깔정함
		JPanel panel=new JPanel();
		panel.setBackground(Color.YELLOW);
		//텍스트입력필드
		tf_msg=new JTextField(10);
		//전송버튼, 커맨드설정
		JButton sendBtn=new JButton("send");
		sendBtn.setActionCommand("send");
		//프레임에 텍스트입력창, 전송버튼 추가 후 아래로 배치
		panel.add(tf_msg);
		panel.add(sendBtn);
		add(panel, BorderLayout.SOUTH);
		//버튼에 리스너 등록
		sendBtn.addActionListener(this);
		//텍스트출력창 생성후 편집불가능, 배경, 스크롤 설정
		area=new JTextArea();
		area.setEditable(false);
		area.setBackground(Color.pink);
		JScrollPane scroll=new JScrollPane(area,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//프레임의 가운데에 텍스트창 배치
		add(scroll,BorderLayout.CENTER);
		//엔터키로 메시지 전송- 키리스너
		tf_msg.addKeyListener(this);
		//리스트 생성하여 패널에 넣고 프레임의 오른쪽에 배치
		JPanel rightPanel=new JPanel();
		rightPanel.add(jList);
		add(rightPanel, BorderLayout.EAST);
		//대화명 입력받아서 필드에 저장
		chatName=JOptionPane.showInputDialog(this, "Enter your id");
		setTitle("대화명: "+chatName);
		//서버에 소켓으로 접속
		try {
			//접속되면 소켓 객체의 참조값 반환, 값을 필드에 저장
			socket=new Socket("129.0.0.1",5000);
			//서버에 문자열 출력할 bufferedWriter 참조값을 필드에 저장
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
			//서버로부터 메시지를 받을 스레드 시작
			new ClientThread().start();
			//입장메시지를 서버에 전송 : JSONOBJ
			// "{"type":"enter", "name":"대화명"}"
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg=jsonObj.toString();
			//bw로 string 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}catch(Exception e) { //접속 실패 시 예외처리
			e.printStackTrace();
		}
	}//생성자 끝...........
	
	//메인메소드에 프레임 생성
	public static void main(String[] args) {
		ClientMain f=new ClientMain();
		f.setTitle("chat room");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);		
	}
	//액션이벤트 오버라이드 : 메시지 전송메소드 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		sendMessage();		
	}
	//메시지 전송메소드
	public void sendMessage() {
		//입력한 문자열 가지고 옴
		String msg=tf_msg.getText();
		try {
			//JSONObject로 정보 구성 후 문자열 참조값 가져옴
			//{"type":"msg","name":"김구라", "content":"안녕하세요"}
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "msg");
			jsonObj.put("name", chatName);
			jsonObj.put("content", msg);
			String json=jsonObj.toString();
			//bw로 문자열 서버에 전송
			bw.write(json);
			bw.newLine();
			bw.flush();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		//채팅창비우기
		tf_msg.setText("");
	}
	//서버에게 메시지 받아올 스레드 - 반복해서 받아오고 textArea에 출력
	public class ClientThread extends Thread{
		public void run() {
			try {
				//서버로부터 입력받을 개체 참조값 가져오기
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				while(true) { //무한 반복+대기할 반복문
					//문자열 읽어오기
					String msg=br.readLine();
					updateTextArea(msg);
					//추가된 글 내용이 보이게
					//입력한 글의 타입>길이 가져옴
					int docLength=area.getDocument().getLength();
					//텍스트 위치 설정-0과 텍스트 길이 사이
					area.setCaretPosition(docLength);
					//만약 메시지 없으면 null값 반환하므로 반복문 끝내도록 if문 설정
					if(msg==null) {
						break;
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//문자열을 TextArea에 출력할 메소드
		public void updateTextArea(String msg) {
			try {
				//JSONObj의 type으로 입장/대화/퇴장 판별
				JSONObject jsonObj=new JSONObject(msg);
				String type=jsonObj.getString("type");
				if(type.equals("enter")) { //입장메시지
					//누가 입장했는가
					String name=jsonObj.getString("name");
					//출력
					area.append("["+name+"] 님이 입장했습니다.");
					area.append("\r\n");
				}else if(type.equals("msg")) { //대화메시지
					//누가보냈는지
					String name=jsonObj.getString("name");
					//내용
					String content=jsonObj.getString("content");
					//출력
					area.append(name+" : "+content);
					area.append("\r\n");
				}else if(type.equals("out")) {//퇴장메시지
					//누구
					String name=jsonObj.getString("name");
					//출력
					area.append("[[ "+name+" ]] 님이 퇴장했습니다.");
					area.append("\r\n");
				}else if(type.equals("members")) {//참여자 목록
					//목록의 내용인 list 키값으로 JSONArray 객체 가져옴
					JSONArray arr=jsonObj.getJSONArray("list");
					//참여자 목록을 저장할 vector 배열
					Vector<String> list=new Vector<>();
					//첫줄에 넣을 텍스트
					list.add("참여자 목록");
					//반복문으로 참여자 목록을 넣어준다
//					for(int i=0; i<arr.length(); i++) {
//						String tmp=arr.getString(i);
//						list.add(tmp);
//					}
					for(String tmp:list) {
						list.add(tmp);
					};
					//list에 참여자 목록 연결
					jList.setListData(list);
				}				
			}catch(JSONException je) {
				je.printStackTrace();
			}
		}
	}	
	@Override
	public void keyPressed(KeyEvent e) {
		//엔터키 눌렀을 때도 sendMessage 작동
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_ENTER) {
			sendMessage();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}

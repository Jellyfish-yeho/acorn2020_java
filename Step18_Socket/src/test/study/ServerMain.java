package test.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServerMain {
	//static main 안에서 List<ServerThread> 를 사용하기 위해 static 필드 생성
	//스레드 객체를 사용할 클래스를 사용
	static List<ServerThread> threadList=new ArrayList<>();
	
	public static void main(String[] args) {
		//서버용 소켓 객체를 저장할 지역변수
		ServerSocket serverSocket=null;
		try {
			//클라이언트 접속을 기다릴 서버소켓 생성하여 참조값을 필드에
			serverSocket=new ServerSocket(5000);
			//무한반복문으로 클라이언트 접속 기다림
			while(true) {
				//소켓 생성, 클라이언트 접속 기다림
				Socket socket=serverSocket.accept();
				//접속한 클라이언트를 대응할 스레드 시작
				ServerThread thread=new ServerThread(socket);
				thread.start();
				//시작한 스레드의 참조값을 리스트에 저장
				threadList.add(thread);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//서버소켓값이 없을 경우 닫아줌
				if(serverSocket!=null)serverSocket.close();
			}catch(Exception e) {}
		}
	}
	//내부 클래스로 스레드 객체를 생성할 클래스 정의
	//main 에서 사용하기 위해 static으로 정의함.
	public static class ServerThread extends Thread{
		//필드에 소켓 정의 
		Socket socket;
		//클라이언트에게 문자열을 출력해 줄 객체
		BufferedWriter bw;
		//클라이언트 대화명 저장 필드
		String chatName;
		//생성자의 인자로 socket 객체
		public ServerThread(Socket socket) {
			//참조값을필드에 저장
			this.socket=socket;
		}
		//전달된 문자열을 소켓으로 출력
		public void sendMessage(String msg) throws IOException {
			//반복문으로 모든 스레드의 bufferedWriter 객체로 문자열 전송
//			for (int i = 0; i < threadList.size(); i++) {
//				ServerThread tmp=threadList.get(i);
//				tmp.bw.write(msg);//문자열 출력
//				tmp.bw.newLine();
//				tmp.bw.flush();
//			}
			for (ServerThread tmp : threadList) {
				tmp.bw.write(msg);//문자열 출력
				tmp.bw.newLine();
				tmp.bw.flush();
			}
		}
		//참여자 목록을 client에게 출력
		public void sendChatNameList() {
			//JSONOBject 에서 참여자 목록 가져오기-Array로
			JSONObject jsonObj=new JSONObject();
			JSONArray jsonArr=new JSONArray();
			//스레드 리스트에서 대화명을 순서대로 객체에 넣기
			for (int i = 0; i < threadList.size(); i++) {
				ServerThread tmp = threadList.get(i);
				jsonArr.put(i, tmp.chatName);				
			}
//			for (ServerThread tmp : threadList) {
//				jsonArr.put(threadList.size(), tmp.chatName); ???
//			}
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonArr);
			try {
				//읽어온 스트링을 인자로 전달
				sendMessage(jsonObj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//새로운 작업단위를 시작할 run() , thread를 override
		public void run() {
			//클라이언트로부터 읽어올 input 객체 참조값
			try {
				//클라이언트로부터 읽어올 input 객체 참조값
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				//클라이언트에게 출력할 객체
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				//bw 참조값을 필드에 저장
				bw=new BufferedWriter(osw);
				//무한 반복문으로 전송받은 문자열 읽고 필드에 저장
				while(true) {
					//클라이언트가 전송하는 문자열 읽기
					String msg=br.readLine();
					//json 문자열을 사용할 준비
					JSONObject jsonObj=new JSONObject(msg);
					//타입을 읽어서 입장이면 이름을 필드에 저장
					String type=jsonObj.getString("type");
					if(type.equals("enter")) {
						String chatName=jsonObj.getString("name");
						this.chatName=chatName;
						//목록을 보낸다
						sendChatNameList();
					}
					//클라이언트에게도 목록메시지를 보냄
					sendMessage(msg);
					if(msg==null) {
						//만약 받은 문자열이 없으면 반복문 끝
						break;
					}
				}
				
			} catch (IOException e) { //여기서 모든 예외를 처리했으므로
				//위에 throw 한 것이 회수됨
				e.printStackTrace();
			}finally {
				//종료된 스레드는 list 에서 제거
				threadList.remove(this);
				//이 스레드에 해당하는 사람에 대한 퇴장 메시지 json으로 보내고 
				try {
					JSONObject jsonObj=new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", this.chatName);
					sendMessage(jsonObj.toString());
					//대화명 목록을 보낸다
					sendChatNameList();
					//만약 소켓이 비어있지 않으면 닫는다
					if(socket!=null)socket.close();
			}catch(Exception e) {}
			
			}
		}
	}	
}
	
















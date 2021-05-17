package test.study01;
//jframe, actionlistener, propertychangelistener 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.study.MemoDao;

public class FoodFrame extends JFrame
				implements ActionListener, PropertyChangeListener{
	//필드 : 텍스트 입력 1개, 테이블모델 1개, 테이블 1개
	JTextField inputName;
	DefaultTableModel model;
	JTable table;	
	//생성자 : 레이아웃 보더, 라벨1개, 텍스트필드1개, 버튼2개 (커맨드,리스너)
	// => 판넬에 붙이기
	//테이블 - 칼럼명을 배열에, 디폴트테이블모델 생성+수정가능여부
	//모델을 테이블에 연결, 테이블을 스크롤판넬로 감싸기
	//스크롤을 프레임 가운데에 배치
	//테이블에 회원 목록 출력(별도method)
	//테이블에 이벤트리스너 등록-propertychange..
	public FoodFrame() {
		setLayout(new BorderLayout());
		JLabel label=new JLabel("Enter what you want to eat");
		inputName=new JTextField(10);
		JButton saveBtn=new JButton("save");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		JButton deleteBtn=new JButton("delete");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(inputName);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		add(panel,BorderLayout.NORTH);
		
		table=new JTable();
		String[] colNames={"number","Food Name","Registration Date"};
		model=new DefaultTableModel(colNames,0) {
			public boolean isCellEditable(int row, int column) {
				if(column==0||column==2) {
					return false;
				}return true;
			}
		};
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		displayFood();
		table.addPropertyChangeListener(this);
	}
	//회원목록 출력 method
	//row 개수 삭제>회원목록 > 반복문으로 정보를 배열에 담기
	public void displayFood() {
		model.setRowCount(0);
		FoodDao dao=FoodDao.getInstance();
		List<FoodDto> list=dao.getList();
		for(FoodDto tmp:list) {
			Object[] row={tmp.getNum(), tmp.getName(),tmp.getRegdate()};
			model.addRow(row);
		}	
	}	
	//메인메소드 : 프레임 생성
	public static void main(String[] args) {
		FoodFrame frame=new FoodFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 500);
		frame.setBackground(Color.pink);
		frame.setVisible(true);		
	}	
	//액션커맨드 설정 - 입력 문자열 읽어와서 dto에 담고 dao로 저장	
	@Override
	public void actionPerformed(ActionEvent e) {	
		String command =e.getActionCommand();
		if(command.equals("save")) {
			String name=inputName.getText();
			FoodDto dto=new FoodDto();
			dto.setName(name);
			FoodDao dao=FoodDao.getInstance();
			boolean isSuccess=dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name+" is added");
				inputName.setText("");
			}else {
				JOptionPane.showMessageDialog(this, "add failed");
			}
			displayFood();
		}else if(command.equals("delete")) {
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1) {
				return;
			}
			int selection=JOptionPane.showConfirmDialog(this, "are you sure you want to delete this row?");
			if(selection!= JOptionPane.YES_OPTION) {
				return;
			}
			int num=(int)model.getValueAt(selectedIndex, 0);
			FoodDao dao=FoodDao.getInstance();
			dao.delete(num);
			displayFood();
		}
	}
	boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {	
		System.out.println("property change");
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String name=(String)model.getValueAt(selectedIndex, 1);
				String regdate=(String)model.getValueAt(selectedIndex, 2);
				FoodDto dto=new FoodDto(num,name,regdate);
				FoodDao.getInstance().update(dto);
				isEditing=false;
			}isEditing=true;
		}
	}
}

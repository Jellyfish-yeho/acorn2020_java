package test.study;

import java.awt.BorderLayout;
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

import test.dao.BirthDao;
import test.dto.BirthDto;

public class BirthFrame extends JFrame 
	implements ActionListener, PropertyChangeListener{
	
	JTextField inputContent1, inputContent2;
	DefaultTableModel model;
	JTable table;
	
	public BirthFrame() {
		setLayout(new BorderLayout());
		JLabel label1=new JLabel("name");
		JLabel label2=new JLabel("birthday");
		inputContent1=new JTextField(10);
		inputContent2=new JTextField(10);
		JButton saveBtn=new JButton("save");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		JButton deleteBtn=new JButton("delete");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputContent1);
		panel.add(label2);
		panel.add(inputContent2);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		add(panel, BorderLayout.NORTH);
		
		table=new JTable();
		String[] colNames={"num","name","birth"};
		model=new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0||column==2) {
					return false;
				}
				return true;
			}			
		};
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		displayBirth();
		table.addPropertyChangeListener(this);
	}
	public void displayBirth() {
		model.setRowCount(0);
		BirthDao dao=BirthDao.getInstance();
		List<BirthDto> list =dao.getList();
		for(BirthDto tmp:list) {
			Object[] row= {tmp.getNum(),tmp.getName(),tmp.getBirth()};
			model.addRow(row);
		}
	}
	public static void main(String[] args) {
		BirthFrame f=new BirthFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("save")) {
			String name=inputContent1.getText();
			String birth=inputContent2.getText();
			BirthDto dto=new BirthDto();
			dto.setName(name);
			dto.setBirth(birth);
			BirthDao dao=BirthDao.getInstance();
			boolean isSuccess=dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name+", "+birth+" added");
				inputContent1.setText("");
				inputContent2.setText("");
			}else {
				JOptionPane.showMessageDialog(this, "add failed");
			}
			displayBirth();
		}else if(command.equals("delete")) {
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1) {
				return;
			}
			int selection=JOptionPane.showConfirmDialog(this, "are you sure to delete this row?");
			if(selection !=JOptionPane.YES_OPTION) {
				return;
			}
			int num=(int) model.getValueAt(selectedIndex, 0);
			BirthDao dao=BirthDao.getInstance();
			dao.delete(num);
			displayBirth();		
		}
		
	}
	boolean isEditing=false;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("property change");
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")){
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				int num=(int) model.getValueAt(selectedIndex, 0);
				String name=(String) model.getValueAt(selectedIndex, 1);
				BirthDto dto=new BirthDto();
				dto.setNum(num);
				dto.setName(name);
				//db에 저장하기
				BirthDao.getInstance().update(dto);			
				isEditing=false; //수정중이 아니라고 표시한다
			}else {
				isEditing=true; //수정중이라고 표시한다
			}
		}
	}

}

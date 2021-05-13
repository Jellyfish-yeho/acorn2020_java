package test.study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame 
					implements ActionListener, KeyListener{

	JTextField inputMsg;
	JLabel lab1;
	DefaultListModel<String> model;
	JList<String> list;
	
	static final String COMMAND_SEND="send";
	static final String COMMAND_REMOVE="remove";
	
	public MyFrame() {
		setLayout(new BorderLayout());
		inputMsg=new JTextField(10);
		inputMsg.addKeyListener(this);
		
		JButton sendBtn=new JButton("send");
		sendBtn.setActionCommand(COMMAND_SEND);
		sendBtn.addActionListener(this);
				
		JButton removeBtn=new JButton("delete");
		removeBtn.setActionCommand(COMMAND_REMOVE);
		removeBtn.addActionListener(this);
		add(removeBtn,BorderLayout.SOUTH);
		
		lab1=new JLabel("label.");
		
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(inputMsg);
		panel.add(sendBtn);
		panel.add(lab1);
		panel.setBackground(Color.orange);
		add(panel, BorderLayout.NORTH);
		list=new JList<String>();
		
		model=new DefaultListModel<String>();
		model.addElement("me");
		model.addElement("you");
		model.addElement("us");
		
		list.setModel(model);
		
		JScrollPane sc=new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(sc, BorderLayout.CENTER);
				
	}
	
	public static void main(String[] args) {
		MyFrame frame=new MyFrame();
		frame.setTitle("my frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,200,500,500);
		frame.setVisible(true);
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	
}

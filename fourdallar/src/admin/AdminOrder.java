package admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminOrder extends JFrame{
	AdminPageMain adminPage;
	JPanel jp, jp_tf, jp_funtion, jp_title, jp_select;
	DefaultTableModel tableModel;
	JTable table;
	Object ob[][] = new Object[0][6];				
	String[] title = {"회원번호","주문제품","제품수량","주문번호","가격","주문시간"};
	JScrollPane sc;
	JButton jb_insert, jb_delete, jb_update, jb_search, jb_eraser, jb_all;
	JTextField jtf_id, jtf_name, jtf_phone, jtf_addr, jtf_birth, jtf_select;
	String[] select = {"회원번호","주문제품","제품수량","주문번호","가격","주문시간"};
	JComboBox<String> jcomb;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public AdminOrder() {
		super("주문관리");
		
		JPanel jpMember = new JPanel();
		JButton btnAdmin = new JButton("돌아가기");
		
		jpMember.add(btnAdmin);
		
		add(jpMember, BorderLayout.NORTH);
		
	
		jp_select = new JPanel();
		tableModel = new DefaultTableModel(ob, title);
		table = new JTable(tableModel);
		sc = new JScrollPane(table);
		jp_select.add(sc);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false); 
		
		jp_funtion = new JPanel(new GridLayout(2,1));
		jb_insert = new JButton("주문확인");
		jb_delete = new JButton("삭 제");
		jb_update = new JButton("수 정");
		jcomb = new JComboBox<>(select);
		jtf_select = new JTextField(10);
		jb_search = new JButton("검 색");
		jb_eraser = new JButton("테이블 초기화");
		jb_all = new JButton("전체보기");
		
		jp_funtion.add(jb_insert);
		jp_funtion.add(jb_delete);
		jp_funtion.add(jb_update);
		jp_funtion.add(jb_all);
		jp_funtion.add(jcomb);
		jp_funtion.add(jtf_select);
		jp_funtion.add(jb_search);
		jp_funtion.add(jb_eraser);
		
		add(jp_select, BorderLayout.CENTER);
		add(jp_funtion, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		

		
		btnAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				adminPage = new AdminPageMain();
				adminPage.setVisible(true);
			}
		});
	}
	

	public static void main(String[] args) {
		new AdminOrder();
	}
}

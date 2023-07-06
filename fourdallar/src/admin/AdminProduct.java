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

public class AdminProduct extends JFrame{
	AdminPageMain adminPage;
	JPanel jp, jp_tf, jp_funtion, jp_title, jp_select;
	DefaultTableModel tableModel;
	JTable table;
	Object ob[][] = new Object[0][9];				
	String[] title = {"제품코드","제품명", "재고량","구매가격","주문일자","주문수량","입고일자","입고수량","총재고량"};
	JScrollPane sc;
	JButton jb_insert, jb_delete, jb_update, jb_search, jb_eraser, jb_all;
	JTextField jtf_id, jtf_name, jtf_phone, jtf_addr, jtf_birth, jtf_select;
	String[] select = {"제품코드","제품명", "재고량","구매가격","주문일자","주문수량","입고일자","입고수량","총재고량"}; 
	JComboBox<String> jcomb;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public AdminProduct() {
		super("발주관리");
		
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
		jb_insert = new JButton("제품 추가");
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
		new AdminProduct();
	}
	
}

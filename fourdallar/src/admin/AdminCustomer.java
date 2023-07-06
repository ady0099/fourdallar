package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminCustomer extends JFrame implements Runnable{
	AdminPageMain adminPage;
	AdminPointPage adminPointPage;
	
	JPanel jp, jp_tf, jp_funtion, jp_title, jp_select;
	DefaultTableModel tableModel;
	JTable table;
	Object ob[][] = new Object[0][4];				
	String[] title = {"회원번호","이름", "주소","전화"};
	JScrollPane sc;
	JButton jb_insert, jb_delete, jb_update, jb_search, jb_eraser, jb_all;
	JTextField jtf_id, jtf_name, jtf_phone, jtf_addr, jtf_birth, jtf_select;
	String[] select = {"회원번호", "전화", "주소"}; 
	JComboBox<String> jcomb;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	
	public AdminCustomer() {
		super("회원관리");
		
		JPanel jpMember = new JPanel();
		JButton btnPnt = new JButton("포인트 사용내역보기");
		JButton btnAdmin = new JButton("돌아가기");
		
		
		jpMember.add(btnPnt);
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
		jb_insert = new JButton("관리자 권한 추가");
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
		
		connected();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) {
					try {
						Protocol p = new Protocol();
						p.setCmd(0);
						out.writeObject(p);
						out.flush();
					} catch (Exception e2) {
					}
				} else {
					closed();
				}
			}
		});
		
		jb_all.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       try {
				Protocol p = new Protocol();
				p.setCmd(601);
				System.out.println("601확인");
				out.writeObject(p);
				out.flush();
			} catch (Exception e2) {
			}
		    }
		});
		
		btnPnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminPointPage = new AdminPointPage();
			}
	
		});
		btnAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				adminPage = new AdminPageMain();
				adminPage.setVisible(true);
			}
		});
	}
	//접속
		public void connected() {
			try {
				s = new Socket("192.168.0.22", 7780);
				out = new ObjectOutputStream(s.getOutputStream());
				in = new ObjectInputStream(s.getInputStream());
				new Thread(this).start();
				System.out.println("서버와 연결 완료");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	
	// 끝내기
	public void closed() {
		try {
			out.close();
			in.close();
			System.exit(0);
		} catch (Exception e) {
		}
	}
	
	@Override
	public void run() {
	    while (true) {
	        try {
	            Object obj = in.readObject();
	            System.out.println("서버로부터 프로토콜을 받았습니다.");

	            if (obj != null && obj instanceof Protocol) {
	                Protocol p = (Protocol) obj;

	                switch (p.getCmd()) {
	                    case 0:
	                        break;
	                    case 601: // 고객정보 전체보기
	                        List<CustomerVO> customerList = p.getList();
	                        System.out.println("고객정보 전체보기 프로토콜을 받았습니다.");
	                        // JTable에 고객 정보 출력하는 메서드 호출
	                        prn(customerList);
	                        break;
	                    case 602: break;
	                    
	                    default:
	                        System.out.println("알 수 없는 커맨드입니다: " + p.getCmd());
	                        break;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            break;
	        }
	    }

	    closed();
	}

	
	private void prn(List<CustomerVO> list) {
		for (CustomerVO k : list) {
			Object data[] = {k.getCustid(),k.getName(),k.getAddress(),k.getPhone()};
			tableModel.addRow(data);
		}
	   
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new AdminCustomer();
				
			}
		});
	}

}

package admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AdminMovie extends JFrame{
	AdminPageMain adminPage;
	JPanel jp, jp_tf, jp_funtion, jp_title, jp_select;
	DefaultTableModel tableModel;
	JTable table;
	Object ob[][] = new Object[0][6];				
	String[] title = {"영화ID","영화제목","상영날짜","시작시간","종료시간", "상영관"};
	JScrollPane sc;
	JButton jb_insert, jb_delete, jb_update, jb_search, jb_all;
	JTextField jtf_id, jtf_name, jtf_phone, jtf_addr, jtf_birth, jtf_select;
	String[] select = {"영화ID", "영화제목", "상영날짜","시작시간","종료시간", "상영관"}; 
	JComboBox<String> jcomb;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	public AdminMovie() {
		super("영화관리");

		jp_select = new JPanel();
		tableModel = new DefaultTableModel(ob, title);
		table = new JTable(tableModel);
		sc = new JScrollPane(table);
		table.setEnabled(false);
		jp_select.add(sc);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false); 
		 
		jp_funtion = new JPanel(new GridLayout(2,1));
		jb_insert = new JButton("영화 추가");
		jb_delete = new JButton("삭 제");
		jb_update = new JButton("수 정");
		jcomb = new JComboBox<>(select);
		jtf_select = new JTextField(10);
		jb_search = new JButton("검 색");
		jb_all = new JButton("전체보기");
		
		jp_funtion.add(jb_insert);
		jp_funtion.add(jb_delete);
		jp_funtion.add(jb_update);
		
		jp_funtion.add(jcomb);
		jp_funtion.add(jtf_select);
		jp_funtion.add(jb_search);

		add(jp_select, BorderLayout.CENTER);
		add(jp_funtion, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		JPanel jpMovie = new JPanel();
		JButton btnAdmin = new JButton("돌아가기");
		jpMovie.add(jb_all);
		jpMovie.add(btnAdmin);
		

		add(jpMovie, BorderLayout.NORTH);
		
		jb_all.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       try {
				Protocol p = new Protocol();
				p.setCmd(611);
				
				out.writeObject(p);
				out.flush();
			} catch (Exception e2) {
			}
		    }
		});
		
		//connected();
		
		jb_insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminMovieAdd();
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
	
	
	
//	public void connected() {
//		try {
//			s = new Socket("192.168.0.22", 7780);
//			out = new ObjectOutputStream(s.getOutputStream());
//			in = new ObjectInputStream(s.getInputStream());
//			new Thread(this).start();
//			System.out.println("서버와 연결 완료");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//		
//		// 끝내기
//		public void closed() {
//			try {
//				out.close();
//				in.close();
//				System.exit(0);
//			} catch (Exception e) {
//			}
//		}
//		
//		@Override
//		public void run() {
//		    while (true) {
//		        try {
//		            Object obj = in.readObject();
//		            System.out.println("서버로부터 프로토콜을 받았습니다.");
//
//		            if (obj != null && obj instanceof Protocol) {
//		                Protocol p = (Protocol) obj;
//
//		                switch (p.getCmd()) {
//		                    case 0:
//		                        break;
//		                    case 601: // 고객정보 전체보기
//		                        break;
//		                    case 602: break;
//		                    
//		                    case 611: //영화 정보 전체보기
//		                    	List<MovieScheduleVO> MovieScheduleList = p.getList2();
//		                    	 System.out.println("영화정보 전체보기 프로토콜을 받았습니다.");
//		                    	    prn(MovieScheduleList);
//		                    	    System.out.println("611확인");
//		                    	    break;
//		                    default:
//		                        System.out.println("알 수 없는 커맨드입니다: " + p.getCmd());
//		                        break;
//		                }
//		            }
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		            break;
//		        }
//		    }
//
//		    closed();
//		}	
//	
//		private void prn(List<MovieScheduleVO> list2) {
//			for (MovieScheduleVO k : list2) {
//				Object data[] = {k.getMovie_id(),k.getMovie_name(),k.getMovie_date(),k.getStart_time(),
//						k.getEnd_time(), k.getTheater_id()};
//				tableModel.addRow(data);
//			}
//	
//	}
	
	public static void main(String[] args) {
		new AdminMovie();
	}
}

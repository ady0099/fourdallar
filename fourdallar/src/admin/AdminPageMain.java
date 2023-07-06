package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPageMain extends JFrame{
	JPanel jp, jp2;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, bt_login, bt_exit;
	ImageIcon img1, img2, img3, img4;
	/*
	ImageIcon img1 = new ImageIcon("../img/img1.png");
	 * ImageIcon img2 = new ImageIcon("../img/img2.png"); ImageIcon img3 = new
	 * ImageIcon("../img/img3.png"); ImageIcon img4 = new
	 * ImageIcon("../img/img4.png");
	 */
	

	
	public AdminPageMain() {
		super("admin 첫페이지");
		
		
		
		img1 = new ImageIcon(getClass().getResource("../img/img1.png"));
		img2 = new ImageIcon(getClass().getResource("../img/img2.png"));
		img3 = new ImageIcon(getClass().getResource("../img/img3.jpg"));
		img4 = new ImageIcon(getClass().getResource("../img/img4.jpg"));
		
		Image c_img1 = img1.getImage().getScaledInstance(250, 600, Image.SCALE_SMOOTH);
		ImageIcon changeimg1 = new ImageIcon(c_img1);
		
		Image c_img2 = img2.getImage().getScaledInstance(250, 600, Image.SCALE_SMOOTH);
		ImageIcon changeimg2 = new ImageIcon(c_img2);
		
		Image c_img3 = img3.getImage().getScaledInstance(250, 600, Image.SCALE_SMOOTH);
		ImageIcon changeimg3 = new ImageIcon(c_img3);
		
		Image c_img4 = img4.getImage().getScaledInstance(250, 600, Image.SCALE_SMOOTH);
		ImageIcon changeimg4 = new ImageIcon(c_img4);
		
		
		
		// 회원관리, 영화관리, 주문관리, 발주관리
		jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jb1 = new JButton("회원관리", changeimg1);
		jb2 = new JButton("영화관리", changeimg2);
		jb3 = new JButton("주문관리", changeimg3);
		jb4 = new JButton("발주관리", changeimg4);
		
	
		// 버튼 텍스트 폰트
		jb1.setFont(new Font("바탕",	 Font.BOLD, 50));
		jb1.setForeground(Color.BLUE);
		jb1.setHorizontalTextPosition(JButton.CENTER);
		
		jb2.setFont(new Font("바탕",	 Font.BOLD, 50));
		jb2.setForeground(Color.BLUE);
		jb2.setHorizontalTextPosition(JButton.CENTER);
		
		jb3.setFont(new Font("바탕",	 Font.BOLD, 50));
		jb3.setForeground(Color.BLUE);
		jb3.setHorizontalTextPosition(JButton.CENTER);
		
		jb4.setFont(new Font("바탕",	 Font.BOLD, 50));
		jb4.setForeground(Color.BLUE);
		jb4.setHorizontalTextPosition(JButton.CENTER);
		
		
		// 버튼 외곽선 삭제
		jb1.setBorderPainted(false);
		jb2.setBorderPainted(false);
		jb3.setBorderPainted(false);
		jb4.setBorderPainted(false);
		
		// 이미지 외엔 투명?
		jb1.setOpaque(false);

		
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		
		jp2 = new JPanel();
		bt_login = new JButton("로그인 화면으로");
		bt_exit = new JButton("종료");
		
		bt_login.setPreferredSize(new Dimension(300, 35));
		bt_exit.setPreferredSize(new Dimension(300, 35));
		
		jp2.add(bt_login);
		jp2.add(bt_exit);

		
		
		add(jp,BorderLayout.CENTER);
		add(jp2,BorderLayout.SOUTH);
		
	
		
		
		
		
		
		
		
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 500, ds.height / 2 - 300, 1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminCustomer();
			}
		});
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminMovie();
			}
		});
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminOrder();
			}
		});
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminProduct();
			}
		});
		
		bt_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	
	public static void main(String[] args) {
		new AdminPageMain();
	}


}

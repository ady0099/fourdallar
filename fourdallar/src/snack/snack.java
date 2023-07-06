package snack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class snack extends JFrame {
	JPanel jp1, jp11, jp12, jp2, jp21,jp211,jp212,jp22,jp23, jp3;
	JButton jb1, jb2, jb21,jb22,jb23,jb4,jb5,jb6,jb7,jb8,jb9,
	jb10,jb11,jb12,jb13,jb14,jb15,jb16,jb17,jb18, jb30;
	JLabel jlb1,jlb2, jlb3, jlb4;
	JScrollPane jsp,jsp1;
	JTextArea jta;
		public snack() {
	// 패널 만들기
	jp1 = new JPanel();
	jp1.setPreferredSize(new Dimension(800, 160));
	jp11 = new JPanel();
	jp11.setPreferredSize(new Dimension(800, 80));
	jp11.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 0));
	jp12 = new JPanel();
	jp12.setPreferredSize(new Dimension(800, 80));
	jp2 = new JPanel();
	jp2.setPreferredSize(new Dimension(600, 550));
	jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
	jp21 = new JPanel();
	jp21.setPreferredSize(new Dimension(550, 500));
	jp211 = new JPanel();
	jp211.setLayout(new GridLayout(0, 3));
	jp211.setPreferredSize(new Dimension(510, 60));
	jp212 = new JPanel();
	jp212.setLayout(new FlowLayout());
	jp212.setPreferredSize(new Dimension(500, 500));
	jsp = new JScrollPane(jp212, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	jsp.setPreferredSize(new Dimension(500, 400));
	
	jp22 = new JPanel(); //200,550
	jp22.setPreferredSize(new Dimension(200,500));
	jp3 = new JPanel();
	
	// 버튼 만들기
	jb1 = new JButton("뒤로가기");
	jb2 = new JButton("포인트 충전");
	
	jb21 = new JButton("주전부리");
	jb22 = new JButton("음료");
	jb23 = new JButton("양념");
	
	jb4 = new JButton("찹쌀떡");
	jb5 = new JButton("메밀묵"); 
	jb6 = new JButton("인절미"); 
	jb7 = new JButton("메밀전병"); 
	jb8 = new JButton("호떡"); 
	jb9 = new JButton("찰떡"); 
	jb10 = new JButton("가래떡"); 
	jb11 = new JButton("감자떡"); 
	
	jb12 = new JButton("수정과"); 
	jb13 = new JButton("식혜"); 
	jb14 = new JButton("소쥬"); 
	jb15 = new JButton("삐루"); 
	
	jb16 = new JButton("조청"); 
	jb17 = new JButton("콩고물"); 
	jb18 = new JButton("고추장"); 

	jb30 = new JButton("결제 하기");
	
	
	
	
	//라벨 만들기
	jlb1 = new JLabel("잔여포인트");
	jlb2 = new JLabel("4딸_라 매점");
	jlb2.setFont(new Font("돋움",	 Font.BOLD, 40));
	jlb3 = new JLabel("장바구니");
	jlb3.setFont(new Font("굴림",	 Font.BOLD, 25));
	jlb4= new JLabel("총 금액은");
	jlb4.setFont(new Font("굴림",	 Font.BOLD, 25));
	
	jta = new JTextArea();
	jta.setPreferredSize(new Dimension(180,370));
	jsp1 = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	//버튼 붙이기
	jp11.add(jb1);
	jp11.add(jlb1);
	jp11.add(jb2);
	
	jp12.add(jlb2);
	
	jp211.add(jb21);
	jp211.add(jb22);
	jp211.add(jb23);
	
	jp22.add(jlb3, BorderLayout.NORTH);
	jp22.add(jsp1, BorderLayout.CENTER);
	jp22.add(jlb4, BorderLayout.SOUTH);
	
	jp212.add(jb4);
	jb4.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb5);
	jb5.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb6);
	jb6.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb7);
	jb7.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb8);
	jb8.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb9);
	jb9.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb10);
	jb10.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb11);
	jb11.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb12);
	jb12.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb13);
	jb13.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb14);
	jb14.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb15);
	jb15.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb16);
	jb16.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb17);
	jb17.setPreferredSize(new Dimension(240, 240));
	jp212.add(jb18);
	jb18.setPreferredSize(new Dimension(240, 240));
	
	jp3.add(jb30);
	jb30.setPreferredSize(new Dimension(240, 80));
	
	// 패널 붙이기
	jp1.add(jp11, BorderLayout.NORTH);
	jp1.add(jp12, BorderLayout.CENTER);
	jp2.add(jp21);
	jp2.add(jp22);
	jp21.add(jp211, BorderLayout.NORTH);
	jp21.add(jsp, BorderLayout.CENTER);
	
		
	add(jp1, BorderLayout.NORTH);
	add(jp2, BorderLayout.CENTER);
	add(jp3, BorderLayout.SOUTH);
			
	setSize(800, 800);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null); // 화면 가운데에 표시
	setVisible(true);

	}
public static void main(String[] args) {
	new snack();
}
}

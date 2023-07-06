package admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Snack extends JFrame  {
	JPanel pTop, pTitle, pCenter, centerGrid, jp22, jpCategory;
	JLabel labelPnt, labelTitle;
	JButton jbtnBack, jbtnPnt;
	JButton[] jbtn_cate, jbtn_menu; 
	JTextArea jtaSide;
	JScrollPane jspCenter, jspSide;
	
	
	public Snack() {
		super("키오스크");
		
		pTop = new JPanel();
	
		jbtnBack = new JButton("뒤로가기");
		jbtnPnt = new JButton("포인트 충전");
		labelPnt = new JLabel("잔여포인트 : ");
		
		pTop.setLayout(new GridLayout(1,3));
		
		pTop.add(jbtnBack);
		pTop.add(labelPnt);
		pTop.add(jbtnPnt);
		
		
		labelTitle = new JLabel("4딸_라 매점");
		labelTitle.setFont(new Font("돋움",	 Font.BOLD, 40));
		
		
		pTitle = new JPanel();
		pTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		labelTitle.setSize(600,200);
		
		
		pTitle.add(labelTitle);
		
		pCenter = new JPanel();
		
		centerGrid = new JPanel();
		
		String[] cate = {"주전부리", "음료", "양념"};
		jbtn_cate = new JButton[cate.length];
		
		//centerGrid.setLayout(new GridLayout(1,cate.length));

		for(int i = 0; i<cate.length; i++) {
			jbtn_cate[i] = new JButton(cate[i]);
			
			pCenter.add(jbtn_cate[i]);
		}
			
		
		String[] menu = {"찹쌀떡", "메밀묵", "인절미", "메밀전병", "호떡", "찰떡", "가래떡", "감자떡"};
		int price[] = {1000,2000,3000,4000,5000,6000,7000,8000};
				
		
		jbtn_menu = new JButton[menu.length];
		
		
		
//		for (int i = 0; i<menu.length; i++) {
//			centerGrid.setLayout(new GridLayout(2,menu.length/2));
//			
//			jbtn_menu[i] = new JButton(menu[i]);
//			
//			
//			if(i%2==1) {
//				jbtn_menu[i].setBounds(25 + i * 150, 50, 100, 100);				
//			}
//			
//			
//			
//			
//			pCenter.add(jbtn_menu[i]);
//		}
		
		jp22 = new JPanel();
		jp22.setPreferredSize(new Dimension(200,500));
		
		jpCategory = new JPanel();
		
		jtaSide = new JTextArea();
		jtaSide.setPreferredSize(new Dimension(180,370));
		jspSide = new JScrollPane(jtaSide, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//jp22.add(jlb3, BorderLayout.NORTH);
		jp22.add(jspSide, BorderLayout.CENTER);
		//jp22.add(jlb4, BorderLayout.SOUTH);
		
		
		
		
		add(pTop,BorderLayout.NORTH);
		add(pTitle, BorderLayout.CENTER);
		add(pCenter, BorderLayout.CENTER);
		
		
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 가운데에 표시
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Snack();
	}
}

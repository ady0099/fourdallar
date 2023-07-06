package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Snack2 extends JFrame {
	JPanel jpNorth, jp2, jp11, jp12, space2, btnJp, jpSouth;
	
	JButton backBtn, pntBtn, botBtn1, botBtn2, botBtn3;
	JLabel jlb1, jlb2;
	
	JScrollPane jsp;
	JTextArea jta;
	
	JButton[] jbtn_cate, jbtn_menu; 

	
	JPanel jp21;
	
	PointCharge pointCharge;
	
	public Snack2() {
		super("매점 주문");
		
		
		
		jpNorth = new JPanel();
		jpNorth.setPreferredSize(new Dimension(800, 160));
		
		jp11 = new JPanel();
		jp11.setPreferredSize(new Dimension(800, 80));
		jp11.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 0));
		
		jp12 = new JPanel();
		jp12.setPreferredSize(new Dimension(800, 80));
		
		jlb1 = new JLabel("잔여포인트 : ");
		backBtn = new JButton("뒤로가기");
		pntBtn = new JButton("포인트 충전");
		

		jp11.add(backBtn);
		jp11.add(jlb1);
		jp11.add(pntBtn);
		
		jpNorth.add(jp11, BorderLayout.NORTH);
		jpNorth.add(jp12, BorderLayout.CENTER);
		
		// 위가 탑
		
		
		// 센터 시작
		
//		jlb2 = new JLabel("4딸_라 매점");
//		jlb2.setFont(new Font("돋움",	 Font.BOLD, 40));
		
		jp2 = new JPanel();
		jp2.setPreferredSize(new Dimension(600, 550));
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		space2 = new JPanel(); //200,550
		space2.setPreferredSize(new Dimension(200,500));
		jp2.add(space2);
		
		jp21 = new JPanel();
		jp21.setPreferredSize(new Dimension(550, 500));
		
		
		String[] cate = {"주전부리", "음료", "양념"};
		jbtn_cate = new JButton[cate.length];
		  
		  
		for(int i =0; i<cate.length; i++) {
			jbtn_cate[i] = new JButton(cate[i]);
			
			jbtn_cate[i].setBounds(25 + i * 150, 50, 100, 100);
			
			jbtn_cate[i].setPreferredSize(new Dimension(200,50));
			
			jp12.add(jbtn_cate[i]);
		}
		
		//jp12.add(jlb2);
		
		
		// 하단변경


        
        
        
        jta = new JTextArea(5,30);
        
    	jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		jta.setEditable(false);
		jta.setText("    주문내역\t 수량(개)\t 금액(원) \n");
	    jta.setFont(new Font("고딕",	 Font.BOLD, 20));

        
        
        
        
    
	    
	    jpSouth = new JPanel();
	    jpSouth.setBackground(new Color(133, 138, 215, 33));
 
        btnJp = new JPanel();
        btnJp.setLayout(new GridLayout(3,1));
        
		botBtn1 = new JButton("결제하기");
        botBtn2 = new JButton("초기화");
        botBtn3 = new JButton("종료");
        botBtn1.setPreferredSize(new Dimension(200,50));

        
        btnJp.add(botBtn1);
        btnJp.add(botBtn2);
        btnJp.add(botBtn3);
       

        jpSouth.add(jsp,BorderLayout.CENTER);
        jpSouth.add(btnJp,BorderLayout.SOUTH);
      
        
	
		
		String[] menu = {"찹쌀떡", "메밀묵", "인절미", "메밀전병", "호떡", "찰떡", "가래떡", "감자떡"};
		int price[] = {1000,2000,3000,4000,5000,6000,7000,8000};
				
		
		jbtn_menu = new JButton[menu.length];
		
		for(int i =0; i<menu.length; i++) {
			jbtn_menu[i] = new JButton(menu[i]);
			
			 if (i < 4) {
					jbtn_menu[i].setBounds(25 + i * 150, 50, 100, 100);
					
	            } else {
	            	jbtn_menu[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
	            }
			
		
			jbtn_menu[i].setPreferredSize(new Dimension(200,50));
			
			
			jp2.add(jbtn_menu[i]);
		}
		
		
		add(jpNorth, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);
		

		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 가운데에 표시
		setVisible(true);
	
		
		// 뒤로가기 버튼 임시로 종료로 구현 
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		// 포인트 충전 버튼
		pntBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pointCharge = new PointCharge();
			}
		});
		
		// 주문 다이얼로그 botBtn1
		botBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showConfirmDialog(jp2, "주문하시겠습니까?", "확인창", JOptionPane.YES_NO_OPTION);
				
			}
		});
		
		// 초기화 botBtn2
		botBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jta.setText("                  주문내역\t 수량(개)\t 금액(원) \n");
         	   
            }
        });
		
        // 종료 botBtn3
        botBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
	}

	public static void main(String[] args) {
		new Snack2();

	}
}

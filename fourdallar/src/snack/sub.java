package snack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class sub extends JFrame{
	JPanel s_menujp, s_jp1,s_jp2,s_jp3;
	JButton s_jb1,s_jb2,s_jb3;
	JLabel s_jlb1,s_jlb2,s_jlb3;
		
	public sub() {
		// 패널만들기
		s_menujp = new JPanel();
		s_menujp.setPreferredSize(new Dimension(185, 90));
		s_jp1 = new JPanel();
		s_jp1.setPreferredSize(new Dimension(180, 30));
		s_jp2 = new JPanel();
		s_jp2.setPreferredSize(new Dimension(180, 30));
		s_jp3 = new JPanel();
		s_jp3.setPreferredSize(new Dimension(180, 30));
		//버튼 만들기
		s_jb1 = new JButton("+");
		s_jb2 = new JButton("-");
		s_jb3 = new JButton("X");
		
		//라벨 만들기
		s_jlb1 = new JLabel("메뉴이름");
		s_jlb1.setPreferredSize(new Dimension(150, 30));
		s_jlb2 = new JLabel("11");
		s_jlb2.setPreferredSize(new Dimension(50, 30));
		s_jlb3 = new JLabel("10,000원");
		s_jlb3.setPreferredSize(new Dimension(140, 30));
		
		// 버튼 붙이기
		s_jp1.add(s_jlb1);
		
		s_jp2.add(s_jb1);
		s_jp2.add(s_jlb2);
		s_jp2.add(s_jb2);
		
		s_jp3.add(s_jlb3);
		s_jp3.add(s_jb3);
		
		// 패널에 붙이기
		s_menujp.add(s_jp1, BorderLayout.NORTH);
		s_menujp.add(s_jp2, BorderLayout.CENTER);
		s_menujp.add(s_jp3, BorderLayout.SOUTH);
		
				
		
		//add(menujp);
	
		setSize(190, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 가운데에 표시
		setVisible(true);
	}
public static void main(String[] args) {
	new sub();
	
}
}

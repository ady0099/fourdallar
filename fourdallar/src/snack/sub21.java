package snack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class sub21 extends JFrame{
	JPanel menujp, jp1,jp2,jp3;
	JButton jb1,jb2,jb3;
	JLabel jlb1,jlb2,jlb3;
		
	public sub21() {
		// 패널만들기
		menujp = new JPanel();
		menujp.setPreferredSize(new Dimension(185, 90));
		jp1 = new JPanel();
		jp1.setPreferredSize(new Dimension(180, 30));
		jp2 = new JPanel();
		jp2.setPreferredSize(new Dimension(180, 30));
		jp3 = new JPanel();
		jp3.setPreferredSize(new Dimension(180, 30));
		//버튼 만들기
		jb1 = new JButton("+");
		jb2 = new JButton("-");
		jb3 = new JButton("X");
		
		//라벨 만들기
		jlb1 = new JLabel("메뉴이름");
		jlb1.setPreferredSize(new Dimension(150, 30));
		jlb2 = new JLabel("11");
		jlb2.setPreferredSize(new Dimension(50, 30));
		jlb3 = new JLabel("10,000원");
		jlb3.setPreferredSize(new Dimension(140, 30));
		
		// 버튼 붙이기
		jp1.add(jlb1);
		
		jp2.add(jb1);
		jp2.add(jlb2);
		jp2.add(jb2);
		
		jp3.add(jlb3);
		jp3.add(jb3);
		
		// 패널에 붙이기
		menujp.add(jp1, BorderLayout.NORTH);
		menujp.add(jp2, BorderLayout.CENTER);
		menujp.add(jp3, BorderLayout.SOUTH);
		
				
		
		//add(menujp);
	
		setSize(190, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 가운데에 표시
		setVisible(true);
	}
public static void main(String[] args) {
	new sub21();
	
}
public JPanel getMenuPanel() {
	// TODO Auto-generated method stub
	return null;
}
}

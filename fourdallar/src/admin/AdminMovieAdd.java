package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminMovieAdd extends JFrame {
	AdminMovie adminBtnMovie;
	
	JPanel formPanel, datePanel, timePanel, theaterPanel, namePanel, contentPanel, northPanel;
	JLabel title, semi1, semi2, semi3, semi4, dateLabel, timeLabel, theaterLabel, nameLabel;
	JButton join, cancel;
	
	String[] dateSelect = {"0705", "0706", "0707"};
	String[] timeSelect = {"11:00", "13:00", "15:00"};
	String[] theaterSelect = {"1상영관", "2상영관", "3상영관"};
	String[] nameSelect = {"범죄도시3", "춘향뎐", "타이타닉"};
	
	JComboBox<String> dateComb;
	JComboBox<String> timeComb;
	JComboBox<String> theaterComb;
	JComboBox<String> nameComb;
	
	
	public AdminMovieAdd() {
		setTitle("영화관리 화면");
	
		// 상단
		title = new JLabel("영화추가", JLabel.CENTER);
		title.setForeground(new Color(5, 0, 153));
		title.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		
		
		// 중단
		formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 1, 40, 30));
		
		datePanel = new JPanel();
		datePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		dateLabel = new JLabel("날   짜");
		semi1 = new JLabel(" : ");
		
		datePanel.add(dateLabel);
		datePanel.add(semi1);
		
		
		dateComb = new JComboBox<>(dateSelect);
		datePanel.add(dateComb);
		dateComb.setPreferredSize(new Dimension(200,30));
		
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		timeLabel = new JLabel("시작시간");
		semi2 = new JLabel(" : ");
		
		timePanel.add(timeLabel);
		timePanel.add(semi2);
		
		
		timeComb = new JComboBox<>(timeSelect);
		timePanel.add(timeComb);
		
		
		theaterPanel = new JPanel();
		theaterPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		theaterLabel = new JLabel("상영관");
		semi3 = new JLabel(" : ");
		
		theaterPanel.add(theaterLabel);
		theaterPanel.add(semi3);
		
		theaterComb = new JComboBox<>(theaterSelect);
		theaterPanel.add(theaterComb);
		
		namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		nameLabel = new JLabel("영화제목");
		semi4 = new JLabel(" : ");
		
		namePanel.add(nameLabel);
		namePanel.add(semi4);
		
		nameComb = new JComboBox<>(nameSelect);
		namePanel.add(nameComb);
		
		nameComb.setPreferredSize(new Dimension(200,30));
		theaterComb.setPreferredSize(new Dimension(200,30));
		timeComb.setPreferredSize(new Dimension(200,30));
		
		
		
		timeComb.setEnabled(false);
		theaterComb.setEnabled(false);
		nameComb.setEnabled(false);
		timePanel.setVisible(false);
		theaterPanel.setVisible(false);
		namePanel.setVisible(false);
		
		formPanel.add(datePanel);
		formPanel.add(timePanel);
		formPanel.add(theaterPanel);
		formPanel.add(namePanel);
		
		dateLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		dateLabel.setForeground(Color.BLUE);
		semi1.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		semi1.setForeground(Color.BLUE);
		
		timeLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		timeLabel.setForeground(Color.BLUE);
		semi2.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		semi2.setForeground(Color.BLUE);
		
		theaterLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		theaterLabel.setForeground(Color.BLUE);
		semi3.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		semi3.setForeground(Color.BLUE);
		
		nameLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		nameLabel.setForeground(Color.BLUE);
		semi4.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		semi4.setForeground(Color.BLUE);
		
		dateLabel.setPreferredSize(new Dimension(80, 30));
		timeLabel.setPreferredSize(new Dimension(80, 30));
		theaterLabel.setPreferredSize(new Dimension(80, 30));
		nameLabel.setPreferredSize(new Dimension(80, 30));

		datePanel.setPreferredSize(new Dimension(150, 30));
		timePanel.setPreferredSize(new Dimension(150, 30));
		theaterPanel.setPreferredSize(new Dimension(150, 30));
		namePanel.setPreferredSize(new Dimension(150, 30));
		
		
		// 하단 버튼
		northPanel = new JPanel();

		join = new JButton("추가");
		cancel = new JButton("취소");
		
		northPanel.add(join);
		northPanel.add(cancel);
		
		
		
		add(title, BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.SOUTH);
		
		

		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 100, ds.height / 2 - 300, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		dateComb.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				timeComb.setEnabled(true);
				timePanel.setVisible(true);
				
				dateComb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						theaterComb.setEnabled(false);
						theaterPanel.setVisible(false);
						nameComb.setEnabled(false);
						namePanel.setVisible(false);
					}
				});
			}
		});
		timeComb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				theaterComb.setEnabled(true);
				theaterPanel.setVisible(true);
				
				timeComb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						nameComb.setEnabled(false);
						namePanel.setVisible(false);
					}
				});
			}
		});
		theaterComb.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				nameComb.setEnabled(true);
				namePanel.setVisible(true);
			}
		});
		

		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				int answer = JOptionPane.showConfirmDialog(join, "등록하시겠습니까?", "확인창", JOptionPane.YES_NO_OPTION);
				
				String dateStr =  dateComb.getSelectedItem().toString();
				String timeStr = timeComb.getSelectedItem().toString();
				String theaterStr = theaterComb.getSelectedItem().toString();
				String nameStr = nameComb.getSelectedItem().toString();

				// 중복 검사도 해야함 
				
				if(answer==JOptionPane.YES_OPTION) {
					if(timeComb.isEnabled() && theaterComb.isEnabled() && nameComb.isEnabled()) {
						JOptionPane.showMessageDialog(getParent(), 
								"날짜 : "+ dateStr 
								+ ", 시작시간 : "+timeStr
								+ ", 상영관 : "+theaterStr
								+ ", 영화제목 : "+nameStr							
								+ " 저장되었습니다.", 
								"저장완료", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						
					}else if(!(timePanel.isVisible())){
						JOptionPane.showMessageDialog(getParent(), "날짜를 선택해주세요");
					}else if(!(theaterPanel.isVisible())){
						JOptionPane.showMessageDialog(getParent(), "시작시간을 선택해주세요");
					}else if(!(namePanel.isVisible())){
						JOptionPane.showMessageDialog(getParent(), "상영관을 선택해주세요");
					}					
				}else {
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new AdminMovieAdd();
	}
}

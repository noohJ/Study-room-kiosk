package teamProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class basic_screen extends JFrame implements ActionListener{
	JButton b1, b2, b3;
	
	public basic_screen() { // 기본 페이지 설정
		
		setSize(800, 1000);
		setTitle("기본 페이지");
		
		Container ct = getContentPane(); // 배경 색 설정
		ct.setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		// JButton 설정 ( 위치 , 색상, 배경)
		b1 = new JButton("회원 로그인");
		b2 = new JButton("비회원 로그인");
		b3 = new JButton("회원 가입");
		b1.setBounds(200, 150, 400, 200);
		b2.setBounds(200, 400, 400, 200);
		b3.setBounds(200, 650, 400, 200);
		b1.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 40 ));
		b1.setBackground(new Color(0xF2F0F1));
		b2.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 40 ));
		b2.setBackground(new Color(0xF2F0F1));
		b3.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 40 ));
		b3.setBackground(new Color(0xF2F0F1));
		
		
		add(b1);add(b2);add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
		
		b1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part(); 여기에 메서드만 들어가면 끝
				setVisible(false);
			}
		});
		b2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part();
				setVisible(false);
			}
		});
		b3.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//new Part();
				setVisible(false);
			}
		});
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void main(String[] args) {
		new basic_screen();
	}
}

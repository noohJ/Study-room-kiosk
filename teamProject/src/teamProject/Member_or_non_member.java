package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Member_or_non_member extends JPanel {
	
	private JButton member,non_member,previous;
	private Start F;
	
	public Member_or_non_member(Start f) {
		
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel("  회원/비회원 로그인 선택");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		member = new JButton("회원 로그인");
		member.setBounds(100,230,600,200);
		member.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 60 ));
		member.setForeground(new Color(0xffffff));
		member.setBackground(new Color(0x5777ff));
		member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.member_login_Panel();
				
			}
		});
		add(member);
		
		
		non_member = new JButton("비회원 로그인");
		non_member.setBounds(100,510,600,200);
		non_member.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 60 ));
		non_member.setForeground(new Color(0xffffff));
		non_member.setBackground(new Color(0x5777ff));
		non_member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.Non_member_login2_Panel();
				
			}
		});
		add(non_member);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.base_screen_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("MapoDPP", Font.PLAIN, 35));
		previous.setForeground(new Color(0x222222));
		previous.setOpaque(true);
		previous.setBackground(new Color(0xd0d0d0));
		previous.setBounds(530, 810, 200, 90);
	}
}

package teamProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Base_screen extends JPanel {
	
	private JButton member_btn,non_member_btn,sign_up_btn;
	private Start F;
	
	public Base_screen(Start f) { 
		
		setSize(800, 1000);
		setLayout(null);
		F = f;		
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/스터디카페.jpg"));
		member_btn = new JButton("회원/비회원 로그인");
		non_member_btn = new JButton("비회원 이용");
		sign_up_btn = new JButton("회원 가입");
		
		member_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				F.member_or_non_member_Panel();
			}
		});
		
		non_member_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				F.non_member_login_Panel();
			}
		});
		
		member_btn.setBounds(100,190,600,200);
		member_btn.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 60 ));
		member_btn.setForeground(new Color(0xffffff));
		member_btn.setBackground(new Color(0x5777ff));
		non_member_btn.setBounds(100,440,600,200);
		non_member_btn.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 60 ));
		non_member_btn.setForeground(new Color(0xffffff));
		non_member_btn.setBackground(new Color(0x5777ff));
		sign_up_btn.setBounds(100,690,600,200);
		sign_up_btn.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 60 ));
		sign_up_btn.setForeground(new Color(0xffffff));
		sign_up_btn.setBackground(new Color(0x5777ff));
		
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		add(member_btn);
		add(non_member_btn);
		add(sign_up_btn);
		
		setVisible(true);
	} 
}

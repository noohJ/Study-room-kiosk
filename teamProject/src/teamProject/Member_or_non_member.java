package teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Member_or_non_member extends JPanel {
	
	private JButton member,non_member;
	private Start F;
	
	public Member_or_non_member(Start f) {
		
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		member = new JButton("회원 로그인");
		member.setBounds(100,200,250,600);
		member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.member_login_Panel();
				
			}
		});
		add(member);
		
		
		non_member = new JButton("비회원 로그인");
		non_member.setBounds(450,200,250,600);
		non_member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.Non_member_login2_Panel();
				
			}
		});
		add(non_member);
	}
}

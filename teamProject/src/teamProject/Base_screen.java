package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Base_screen extends JPanel {
	
	private JButton member_btn,non_member_btn,sign_up_btn;
	private Start F;
	
	public Base_screen(Start f) { 
		
		setSize(800, 1000);
		setLayout(null);
		F = f;		

		member_btn = new JButton("로그인");
		non_member_btn = new JButton("비회원 로그인");
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
		
		member_btn.setBounds(100,100,600,200);
		non_member_btn.setBounds(100,380,600,200);
		sign_up_btn.setBounds(100,650,600,200);
		
		add(member_btn);
		add(non_member_btn);
		add(sign_up_btn);
		
		setVisible(true);
	} 
}

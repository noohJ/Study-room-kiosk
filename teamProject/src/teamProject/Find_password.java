package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Find_password extends JPanel {
	
	private Start F;
	private JTextField id,ph;
	private JButton confirm,previous;
	private JLabel look_pw;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Find_password(Start f) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		JLabel string1 = new JLabel("비밀번호 찾기");
		add(string1);
		string1.setFont(new Font("NanumBarunGothic", Font.BOLD, 50));
		string1.setForeground(new Color(0x222222));
		string1.setBounds(0, 230, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		
		look_pw = new JLabel("");
		look_pw.setBounds(115,540,600,100);
		add(look_pw);
		
		id = new JTextField("아이디");
		id.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				id.setText("");
				id.setForeground(new Color(0x000000));
			}
		});	
		add(id);
		id.setFont(new Font("NanumGothic", Font.PLAIN, 40));
//		name.setForeground(new Color(0xd0d0d0));
		id.setBounds(115, 400, 560, 70);

		ph = new JTextField("핸드폰 번호");
		ph.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ph.setText("");
				ph.setForeground(new Color(0x000000));
			}
		});	
		add(ph);
		ph.setFont(new Font("NanumGothic", Font.PLAIN, 40));
//		ph.setForeground(new Color(0xd0d0d0));
		ph.setBounds(115, 500, 560, 70);
		
		confirm = new JButton("확인");
		confirm.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@127.0.0.1:1521:XE",
							"hr",
							"1234");
					System.out.println("연결 생성 완료.");
					
					PreparedStatement find_id = conn.prepareStatement("SELECT * FROM MEMBERS");
					boolean fpw = false;
					ResultSet rs = find_id.executeQuery();
				
					
					while (rs.next()){
						if(rs.getString("MEMBER_ID").equals(id.getText())&&rs.getString("MEMBER_PHONE").equals(ph.getText())) {
							System.out.println(rs.getString("MEMBER_ID"));
							look_pw.setText("고객님의 비밀번호는 : "+rs.getString("MEMBER_PW") +" 입니다.");		
							fpw = true;
							break;
						}						
					}	
					if (fpw == false) {
						look_pw.setText("아이디 혹은 전화번호가 올바르지 않습니다.");
					}
					fpw =false;
					
					rs.close();
					find_id.close();
					conn.close();
					
				} catch (SQLException a) {
					a.printStackTrace();
				}
				
				
			}
		});
		add(confirm);
		confirm.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		confirm.setForeground(new Color(0xffffff));
		confirm.setOpaque(true);
		confirm.setBackground(new Color(0x00c850));
		confirm.setBounds(115, 610, 560, 94);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("아이디");
				ph.setText("핸드폰 번호");
				look_pw.setText("");
				f.member_login_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 20));
		previous.setForeground(new Color(0xf5f6f7));
		previous.setOpaque(true);
		previous.setBackground(new Color(0x34D40B));
		previous.setBounds(580, 880, 150, 50);
		
		setVisible(true);
	}

}

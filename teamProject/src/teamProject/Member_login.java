package teamProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Member_login extends JPanel {
	private JTextField id;
	private JButton confirm,previous,f_id,f_pw;
	private Start F;
	private JLabel chk,pw2;
	private JPasswordField pw;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Member_login(Start f) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		JLabel string1 = new JLabel("회원 로그인");
		add(string1);
		string1.setFont(new Font("NanumBarunGothic", Font.BOLD, 50));
		string1.setForeground(new Color(0x222222));
		string1.setBounds(0, 230, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		
		id = new JTextField("아이디");
		id.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				id.setText("");
			}
		});
		add(id);
		id.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		id.setForeground(new Color(0xd0d0d0));
		id.setBounds(115, 400, 560, 70);
		id.setText("아이디 입력");
		id.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				id.setText("");
				id.setForeground(new Color(0x000000));
			}
		});	
		
		
		pw = new JPasswordField("비밀번호");
		pw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pw.setText("");
				pw.setForeground(new Color(0x000000));
			}
		});
		add(pw);
		pw.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		pw.setForeground(new Color(0xd0d0d0));
		pw.setBounds(115, 500, 560, 70);
		
		chk = new JLabel("");
		chk.setBounds(115,540,600,100);
		add(chk);
	
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
					boolean chk_member = false;
					ResultSet rs = find_id.executeQuery();
				
					
					while (rs.next()){
						if(rs.getString("MEMBER_ID").equals(id.getText())&&rs.getString("MEMBER_PW").equals(pw.getText())) {

							chk_member = true;
							
							System.out.println("성공");
							f.add("main_screen",new Main_screen(f,id.getText(),0)); // 회원 = 0 비회원 = 1
							f.main_screen_Panel();	

							id.setText("아이디");
							pw.setText("패스워드");
							break;
						}						
					}	
					if (chk_member == false) {
						chk.setText("아이디 혹은 비밀번호가 올바르지 않습니다.");
					}
					chk_member =false;
					
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
		confirm.setForeground(new Color(0xf5f6f7));
		confirm.setOpaque(true);
		confirm.setBackground(new Color(0x00c850));
		confirm.setBounds(115, 610, 560, 94);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("아아디");
				pw.setText("비밀번호");
				chk.setText("");
				id.setForeground(new Color(0xd0d0d0));
				pw.setForeground(new Color(0xd0d0d0));
				f.member_or_non_member_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 20));
		previous.setForeground(new Color(0xf5f6f7));
		previous.setOpaque(true);
		previous.setBackground(new Color(0x34D40B));
		previous.setBounds(580, 880, 150, 50);
		
		f_id = new JButton("아이디 찾기");
		f_id.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("아아디");
				pw.setText("비밀번호");
				chk.setText("");
				F.find_id_Panel();
			}
		});
		add(f_id);
		f_id.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD , 18));
		f_id.setForeground(new Color(0xf5f6f7));
		f_id.setOpaque(true);
		f_id.setBackground(new Color(0x5bb91b));
		f_id.setBounds(355, 735, 150, 50);
		
		f_pw = new JButton("비밀번호 찾기");
		f_pw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("아아디");
				pw.setText("비밀번호");
				chk.setText("");
				F.find_pw_Panel();
			}
		});
		add(f_pw);
		f_pw.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD , 18));
		f_pw.setForeground(new Color(0xf5f6f7));
		f_pw.setOpaque(true);
		f_pw.setBackground(new Color(0x5bb91b));
		f_pw.setBounds(525, 735, 150, 50);
		
		
		setVisible(true);
	}
	public static String idm(String idd) {
		return idd;
	}
}

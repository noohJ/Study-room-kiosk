package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Member_login extends JPanel {
	private JTextField id;
	private JButton confirm,previous,f_id,f_pw;
	private Start F;
	private JLabel chk;
	private JPasswordField pw;
	
	
	public Member_login(Start f) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		id = new JTextField("아이디");
		id.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				id.setText("");
			}
		});
		id.setBounds(100,100,600,100);
		add(id);
				
		
		
		pw = new JPasswordField("비밀번호");
		pw.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				pw.setText("");
			}
		});

		pw.setBounds(100,250,600,100);
		add(pw);
		
		chk = new JLabel("");
		chk.setBounds(100,350,600,100);
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
							f.add("main_screen",new Main_screen(f,id.getText()));
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
		
		confirm.setBounds(100,450,270,200);
		add(confirm);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("아아디");
				pw.setText("비밀번호");
				chk.setText("");
				F.base_screen_Panel();
			}
		});
		previous.setBounds(430,450,270,200);
		add(previous);
		
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
		f_id.setBounds(100,700,270,200);
		add(f_id);
		
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
		f_pw.setBounds(430,700,270,200);
		add(f_pw);
		
		
		setVisible(true);
	}
	public static String idm(String idd) {
		return idd;
	}
}

package teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;

public class Find_password extends JPanel {
	
	private Start F;
	private JTextField id,ph;
	private JButton confirm,previous;
	private JLabel look_pw;
	
	public Find_password(Start f) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		look_pw = new JLabel("");
		look_pw.setBounds(100,350,600,100);
		look_pw.setHorizontalAlignment(JLabel.CENTER);
		add(look_pw);
		
		id = new JTextField("아이디");
		id.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				id.setText("");
			}
		});
		id.setBounds(100,100,600,100);
		add(id);

		ph = new JTextField("핸드폰 번호");
		ph.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				ph.setText("");
			}
		});
		ph.setBounds(100,250,600,100);
		add(ph);
		
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
							look_pw.setText("고객님의 비밀번호는 : "+rs.getString("MEMBER_ID") +" 입니다.");		
							fpw = true;
							break;
						}						
					}	
					if (fpw == false) {
						look_pw.setText("이름 혹은 전화번호가 올바르지 않습니다.");
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
		confirm.setBounds(100,450,270,200);
		add(confirm);
		
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
		previous.setBounds(430,450,270,200);
		add(previous);
		
		setVisible(true);
	}

}

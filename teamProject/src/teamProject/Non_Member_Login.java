package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Non_Member_Login extends JPanel {
	
	private Start start;
	
	public Non_Member_Login(Start f) {
		start = f;
		
		JLabel header = new JLabel("  비회원 로그인");
		JLabel string1 = new JLabel("비회원 로그인");
		JTextField nmb_phone = new JTextField();
		JPasswordField nmb_pw = new JPasswordField();
		JLabel string2 = new JLabel(" 임시비밀번호를 입력해주세요.");
		JPasswordField nmb_pw_chk = new JPasswordField();
		JLabel string3 = new JLabel(" 임시비밀번호를 확인해주세요.");
		JButton chk_btn = new JButton("확인");
		JLabel chk_str = new JLabel("123123123qqq");
		JButton prev_btn = new JButton("이전 화면");
		JLabel null1 = new JLabel("");
		
		nmb_login_ml(nmb_phone);
		nmb_login_ph_fl(nmb_phone);
		nmb_login_ml(nmb_pw);
		nmb_login_pw_fl(nmb_pw, string2);
		nmb_login_ml(nmb_pw_chk);
		nmb_login_pw_fl(nmb_pw_chk, string3);

		chk_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ph_val = nmb_phone.getText();
				int ph_err = 0;
				// DB_Non_Members 클래스에서 논멤버의 번호를 가져와서 비교함. 번호가 없으면 true 
				if(DB_Non_Members.nmb_phone_arr(ph_val)) {					
					if(ph_val.length() == 10 || ph_val.length() == 11) {
						for(int i = 0; i < ph_val.length(); i++) {
							if(!(ph_val.charAt(i) >= '0' &&
									ph_val.charAt(i) <= '9')) {
								ph_err++;
							}
						}
						if(ph_err != 0) {
							chk_str.setVisible(true);
							chk_str.setText("휴대폰 번호는 숫자로만 입력해주세요.");
						} else {
							String pw_val = nmb_pw.getText();
							String pw_chk_val = nmb_pw_chk.getText();
							int pw_err = 0;
							if(pw_val.length() == pw_chk_val.length() && pw_val.length() != 0) {
								for(int i = 0; i < pw_val.length(); i++) {
									if(pw_val.charAt(i) != pw_chk_val.charAt(i)) {
										pw_err++;
									}
								}
								if(pw_err != 0) {
									chk_str.setVisible(true);
									chk_str.setText("비밀번호를 다시 확인해주세요.");
								}
								if(ph_err == 0 && pw_err == 0) {
									DB_Non_Members_Add.nmb_phone_add(ph_val, pw_val);
									chk_str.setVisible(true);
									chk_str.setText("DB에 추가되었습니다.");
									JOptionPane.showMessageDialog(null, "비회원 ID가 생성되었습니다.", "회원가입", JOptionPane.PLAIN_MESSAGE);
									f.main_screen_Panel();
								}					
							} else {
								chk_str.setVisible(true);
								chk_str.setText("비밀번호를 다시 확인해주세요.");
							}
						}				
					} else {
						chk_str.setVisible(true);
						chk_str.setText("휴대폰 번호는 10자리 또는 11자리 입니다.");
					}
				} else {
					chk_str.setVisible(true);
					chk_str.setText("이미 존재하는 휴대폰 번호입니다.");
				}
			}
		});
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.base_screen_Panel();
			};
		});
		
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		add(string1);
		string1.setFont(new Font("MapoDPP", Font.BOLD, 90));
		string1.setBounds(0, 200, 800, 100);
		string1.setHorizontalAlignment(JLabel.CENTER);
		add(nmb_phone);
		nmb_phone.setFont(new Font("MapoDPP", Font.PLAIN, 40));
		nmb_phone.setForeground(new Color(0xd0d0d0));
		nmb_phone.setBounds(115, 370, 560, 70);
		nmb_phone.setText(" 휴대폰 번호를 입력해주세요.");
		add(string2);
		string2.setFont(new Font("MapoDPP", Font.PLAIN, 40));
		string2.setForeground(new Color(0xd0d0d0));
		string2.setBounds(115, 470, 560, 70);
		add(nmb_pw);
		nmb_pw.setFont(new Font("MapoDPP", Font.PLAIN, 40));
		nmb_pw.setForeground(new Color(0xd0d0d0));
		nmb_pw.setBounds(115, 470, 560, 70);
		add(string3);
		string3.setFont(new Font("MapoDPP", Font.PLAIN, 40));
		string3.setForeground(new Color(0xd0d0d0));
		string3.setBounds(115, 570, 560, 70);
		add(nmb_pw_chk);
		nmb_pw_chk.setFont(new Font("MapoDPP", Font.PLAIN, 40));
		nmb_pw_chk.setForeground(new Color(0xd0d0d0));
		nmb_pw_chk.setBounds(115, 570, 560, 70);
		add(chk_btn);
		chk_btn.setFont(new Font("MapoDPP", Font.PLAIN, 46));
		chk_btn.setForeground(new Color(0xffffff));
		chk_btn.setOpaque(true);
		chk_btn.setBackground(new Color(0x5777ff));
		chk_btn.setBounds(115, 670, 560, 94);
		add(chk_str);
		chk_str.setFont(new Font("MapoDPP", Font.PLAIN, 15));
		chk_str.setForeground(new Color(0x444444));
		chk_str.setBounds(115, 770, 800, 30);
		chk_str.setVisible(false);
		add(prev_btn);
		prev_btn.setFont(new Font("MapoDPP", Font.PLAIN, 35));
		prev_btn.setForeground(new Color(0x222222));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0xd0d0d0));
		prev_btn.setBounds(530, 810, 200, 90);
		
		add(null1);
		
		setSize(800, 1000);
		setVisible(true);
		setLayout(null);
	}
	public static void nmb_login_ml(JTextField jtf) {
		jtf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtf.setText("");
				jtf.setForeground(new Color(0x222222));
			}
		});		
	}
	public static void nmb_login_ph_fl(JTextField jtf) {	
		jtf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if((jtf.getText()).equals("")) {
					jtf.setText(" 휴대폰 번호를 입력해주세요.");
					jtf.setForeground(new Color(0xd0d0d0));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jtf.setText("");
				jtf.setForeground(new Color(0x222222));
			}
		});
	}
	public static void nmb_login_pw_fl(JTextField jtf, JLabel string) {	
		jtf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if((jtf.getText()).equals("")) {
					
					string.setVisible(true);
				} else {
					string.setVisible(false);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jtf.setText("");
				jtf.setForeground(new Color(0x222222));
				string.setVisible(false);
			}
		});
	}
}

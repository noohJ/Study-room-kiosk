package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Payment extends JPanel{
	private JLabel voucher_type, voucher_price,Voucher_con;
	private JButton confirm,previous,main;
	private boolean chk = false;
	private Start F;
	private String id,type,time;
	
	public Payment(Start f, String id, int voucher_code) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel("  결제하기");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		String code = String.valueOf(voucher_code);
		
		Voucher_con = new JLabel("");
		Voucher_con.setBounds(100,250,600,150);
		add(Voucher_con);
		
		voucher_type = new JLabel();
		voucher_type.setBounds(100, 100,600,150);
		add(voucher_type);
		voucher_type.setHorizontalAlignment(JLabel.CENTER);
		
		voucher_price = new JLabel();
		voucher_price.setBounds(100, 200, 600,150);
		add(voucher_price);
		voucher_price.setHorizontalAlignment(JLabel.CENTER);
		
		confirm = new JButton("확인");
		confirm.addActionListener(new ActionListener() {
			int vochk;
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@127.0.0.1:1521:XE",
							"hr",
							"1234");
					System.out.println("연결 생성 완료.");
					
					PreparedStatement memtble = conn.prepareStatement("SELECT * FROM members Where member_id = '"+id+"'");
					ResultSet rs = memtble.executeQuery();
					while(rs.next()) {
						vochk = rs.getInt("VOUCHER_CODE");
					}
					rs.close();
					memtble.close();
					conn.close();
					
				} catch (SQLException a) {
					a.printStackTrace();
				}
				if(vochk >= 5 && vochk <= 11) {
					Voucher_con.setText("이미 보유하신 이용권이 있습니다.");
				}else {
					try {
						Connection conn = DriverManager.getConnection(
								"jdbc:oracle:thin:@127.0.0.1:1521:XE",
								"hr",
								"1234");
						System.out.println("연결 생성 완료.");
						
						PreparedStatement voucher_tp_t = conn.prepareStatement("SELECT * FROM Voucher Where voucher_code = "+code);
						ResultSet rs = voucher_tp_t.executeQuery();
						
						while(rs.next()) {
							time = rs.getString("VOUCHER_NAME").replaceAll("[^0-9]", "");
						}
						
						
						rs.close();
						voucher_tp_t.close();
						conn.close();

					} catch (SQLException a) {
						a.printStackTrace();
					}
					
					String ptt = "UPDATE MEMBERS SET VOUCHER_CODE = ?, END_DATE = ? WHERE MEMBER_ID = ?";

					String stt = "UPDATE MEMBERS SET VOUCHER_CODE = ?, REMAINING_DAYS  = ? WHERE MEMBER_ID = ?";
					
					if (voucher_code >= 5 && voucher_code <= 8) {
						try (
								Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
								PreparedStatement pstmt = conn.prepareStatement(ptt);
						){
							pstmt.setInt(1, voucher_code);
							pstmt.setString(2, Integer.toString(Integer.parseInt(time)*60));
							pstmt.setString(3, id);
							int cnt = pstmt.executeUpdate(); 

							System.out.println(cnt + "건이 실행되었습니다.");	

						} catch (SQLException e2) {
							e2.printStackTrace();
						}
					}else if (voucher_code >= 9 && voucher_code <= 11) {
						try (
								Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
								PreparedStatement pstmt = conn.prepareStatement(stt);
						){
							
							LocalDate today= LocalDate.now();
							LocalDate period = today.plusDays(Integer.parseInt(time));
							DateTimeFormatter my_format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
							
							pstmt.setInt(1, voucher_code);
							pstmt.setString(2, my_format.format(period));
							pstmt.setString(3, id);
							int cnt = pstmt.executeUpdate(); 
							
							System.out.println(cnt + "건이 실행되었습니다.");	

						} catch (SQLException e2) {
							e2.printStackTrace();
						}
					}
					Voucher_con.setText("");		
					f.main_screen_Panel();
				}

			}
		});
		confirm.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		confirm.setForeground(new Color(0x222222));
		confirm.setOpaque(true);
		confirm.setBackground(new Color(0xd0d0d0));
		confirm.setBounds(90,810,200,90);
		add(confirm);
		
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Voucher_con.setText("");
				f.Buy_a_voucher_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		previous.setForeground(new Color(0x222222));
		previous.setOpaque(true);
		previous.setBackground(new Color(0xd0d0d0));
		previous.setBounds(530, 810, 200, 90);
		
		main = new JButton("메인 화면");
		main.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Voucher_con.setText("");
				f.main_screen_Panel();
			}
		});
		main.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		main.setForeground(new Color(0x222222));
		main.setOpaque(true);
		main.setBackground(new Color(0xd0d0d0));
		main.setBounds(310,810,200,90);
		add(main);
				
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"hr",
					"1234");
			System.out.println("연결 생성 완료.");
			
			PreparedStatement voucher_tp_t = conn.prepareStatement("SELECT * FROM Voucher Where voucher_code = "+code);
			ResultSet rs = voucher_tp_t.executeQuery();
			
			while(rs.next()) {
				type = rs.getString("VOUCHER_TYPE");
				if(type.equals("daily_ticket")) {
					voucher_type.setText("당일 "+rs.getString("VOUCHER_NAME"));
				}else if (type.equals("pass_ticket")) {
					voucher_type.setText("정액 "+rs.getString("VOUCHER_NAME"));
				}else {
					voucher_type.setText("기간 "+rs.getString("VOUCHER_NAME"));
				}
				voucher_price.setText(rs.getString("VOUCHER_PRICE")+"원");
			}
			
			
			rs.close();
			voucher_tp_t.close();
			conn.close();
			
		} catch (SQLException a) {
			a.printStackTrace();
		}
	}
}

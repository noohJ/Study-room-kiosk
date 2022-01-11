package teamProject;

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
	private JButton confirm,previous,main,exit;
	private boolean chk = false;
	private Start F;
	private String id,type,time;
	
	public Payment(Start f, String id, int voucher_code) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
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
		confirm.setBounds(100,450,270,100);
		add(confirm);
		
		previous = new JButton("이전");
		previous.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Voucher_con.setText("");
				f.Buy_a_voucher_Panel();
			}
		});
		previous.setBounds(430,450,270,100);
		add(previous);
		
		main = new JButton("메인 화면");
		main.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Voucher_con.setText("");
				f.main_screen_Panel();
			}
		});
		main.setBounds(100,600,270,100);
		add(main);
		
		exit = new JButton("나가기");
		exit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Voucher_con.setText("");
				f.base_screen_Panel();
			}
		});
		exit.setBounds(430,600,270,100);
		add(exit);
		
		
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

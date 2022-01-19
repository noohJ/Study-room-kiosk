package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Extend_payment extends JPanel {
	private JLabel voucher_type, voucher_price,Voucher_con;
	private JButton confirm,previous,main;
	private boolean chk = false;
	private Start F;
	private String id,type,time,date_col,tr,gtr,dayr,g_date_col;
	private int vochk;
	private String[] split_day = new String[3];
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
	
	public Extend_payment(Start f, String id, int voucher_code, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		String code = String.valueOf(voucher_code);
		
		Voucher_con = new JLabel("");
		Voucher_con.setBounds(100,250,600,150);
		add(Voucher_con);
		
		voucher_type = new JLabel();
		add(voucher_type);
		voucher_type.setFont(new Font("NanumGothic", Font.BOLD, 50));
		voucher_type.setBounds(0, 200, 800, 200);
		voucher_type.setHorizontalAlignment(JLabel.CENTER);
		voucher_type.setVerticalAlignment(JLabel.CENTER);
		
		voucher_price = new JLabel();
		add(voucher_price);
		voucher_price.setFont(new Font("NanumGothic", Font.BOLD, 50));
		voucher_price.setBounds(0, 400, 800, 200);
		voucher_price.setHorizontalAlignment(JLabel.CENTER);
		voucher_price.setVerticalAlignment(JLabel.CENTER);
		

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
		String tn="";
		if (m_or_nm ==0) {
			tn = "SELECT * FROM members Where member_id = '";
			date_col = "UPDATE MEMBERS SET  END_DATE = ? WHERE MEMBER_ID = ?";
			g_date_col = "UPDATE MEMBERS SET G_END_DATE = ? WHERE MEMBER_ID = ?";
		}else {
			tn = "SELECT * FROM non_members Where NON_MEMBER_PHONE = '";
			date_col = "UPDATE NON_MEMBERS SET  END_DATE = ? WHERE NON_MEMBER_PHONE = ?";
			g_date_col = "UPDATE non_members SET G_END_DATE = ? WHERE NON_MEMBER_PHONE = ?";
		}
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"hr",
					"1234");
			
			PreparedStatement memtble = conn.prepareStatement(tn+id+"'");
			ResultSet rs = memtble.executeQuery();
			while(rs.next()) {
				vochk = rs.getInt("VOUCHER_CODE");
				tr = rs.getString("END_DATE");
				gtr = rs.getString("G_END_DATE");
				if(m_or_nm ==0) {
					if(rs.getString("REMAINING_DAYS") != null) {
						split_day =rs.getString("REMAINING_DAYS").split("/");								
					}					
				}

			}
			rs.close();
			memtble.close();
			conn.close();
			
		} catch (SQLException a) {
			a.printStackTrace();
		}
		
		confirm = new JButton("확인");
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				String day_col = "UPDATE MEMBERS SET REMAINING_DAYS  = ? WHERE MEMBER_ID = ?";
				if(voucher_code >= 1 && voucher_code <= 4) { // 당일권 연장
					try (
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
							PreparedStatement pstmt = conn.prepareStatement(date_col);
					){
						pstmt.setString(1, Integer.toString(Integer.parseInt(tr)+Integer.parseInt(time)*60));
						pstmt.setString(2, id);
						int cnt = pstmt.executeUpdate(); 

						System.out.println("선택하신 정액권 : "+cnt + "건이 실행되었습니다.");	

					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else if (voucher_code >= 5 && voucher_code <= 8) {  //정액권 연장
					try (
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
							PreparedStatement pstmt = conn.prepareStatement(date_col);
					){
						pstmt.setString(1, Integer.toString(Integer.parseInt(tr)+Integer.parseInt(time)*60));
						pstmt.setString(2, id);
						int cnt = pstmt.executeUpdate(); 

						System.out.println("선택하신 정액권 : "+cnt + "건이 실행되었습니다.");	

					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else if (voucher_code >= 9 && voucher_code <= 11) {  //정기권 연장
					try (
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
							PreparedStatement pstmt = conn.prepareStatement(day_col);
					){
						LocalDate today= LocalDate.of(Integer.parseInt(split_day[0]), Integer.parseInt(split_day[1]), Integer.parseInt(split_day[2]));

						LocalDate period = today.plusDays(Integer.parseInt(time));

						DateTimeFormatter my_format = DateTimeFormatter.ofPattern("yyyy/MM/dd");

						pstmt.setString(1, my_format.format(period));
						pstmt.setString(2, id);
						int cnt = pstmt.executeUpdate(); 
						
						System.out.println("선택하신 정기권 :"+cnt + "건이 실행되었습니다.");	

					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else {  //그룹룸 연장
					try (
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
							PreparedStatement pstmt = conn.prepareStatement(g_date_col);
					){
						pstmt.setString(1, Integer.toString(Integer.parseInt(gtr)+Integer.parseInt(time)*60));
						pstmt.setString(2, id);
						int cnt = pstmt.executeUpdate(); 

						System.out.println("선택하신 정액권 : "+cnt + "건이 실행되었습니다.");	

					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				Voucher_con.setText("");		
				f.main_screen_Panel();
				

			}
		});
		confirm.setFont(new Font("NanumGothic", Font.PLAIN, 40));
		confirm.setForeground(new Color(0xf5f6f7));
		confirm.setOpaque(true);
		confirm.setBackground(new Color(0x00c850));
		confirm.setBounds(115, 660, 560, 94);
		add(confirm);
		System.out.println(vochk);
		previous = new JButton("이전 화면");
		previous.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(vochk);
				Voucher_con.setText("");
				if(vochk >= 1 && vochk <= 4) {
					f.daily_ticket_extend_Panel();
				}else if (vochk >= 5 && vochk <= 8) {
					f.pass_ticket_extend_Panel();
				}else if (vochk >= 9 && vochk <= 11) {
					f.season_ticket_extend_Panel();
				}else {					
					f.group_room_extend_Panel();
				}
			
			}
		});
		add(previous);
		previous.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 20));
		previous.setForeground(new Color(0xf5f6f7));
		previous.setOpaque(true);
		previous.setBackground(new Color(0x34D40B));
		previous.setBounds(580, 880, 150, 50);
		
		main = new JButton("메인 화면");
		main.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Voucher_con.setText("");
				f.main_screen_Panel();
			}
		});
		main.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 20));
		main.setForeground(new Color(0xf5f6f7));
		main.setOpaque(true);
		main.setBackground(new Color(0x34D40B));
		main.setBounds(410,880,150,50);
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
				String money = String.format("%,d", rs.getInt("VOUCHER_PRICE"));
				if(type.equals("season_ticket")) {
					voucher_type.setText("<html><body style='text-align:center;'>"
							+"연장할 기간 :<br>"+time+" 일</html>");
				}else {
					voucher_type.setText("<html><body style='text-align:center;'>"
							+"연장할 시간 :<br>"+time+" 시간</html>");
				}
				voucher_price.setText("<html><body style='text-align:center;'>"
						+"결제하실 금액 :<br>"+money+"원"+"</html>");
			}
			
			
			rs.close();
			voucher_tp_t.close();
			conn.close();
			
		} catch (SQLException a) {
			a.printStackTrace();
		}
	}
}

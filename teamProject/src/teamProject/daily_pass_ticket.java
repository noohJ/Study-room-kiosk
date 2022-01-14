package teamProject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class daily_pass_ticket extends JPanel{
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	
	private Start F;
	
	ImageIcon icon = new ImageIcon("teamProject/src/icons/back3.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
		
	static {
		try {
			
			Class.forName(driverName);
			System.out.println("driver loaded");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	 // 패널 생성
	 JPanel panel1 = new JPanel();
//	 JPanel panel2 = new JPanel();
	 JPanel null1 = new JPanel();
	 
	 // 버튼 생성
	 JButton btn3 = new JButton();
	 JButton btn4 = new JButton();
	 JButton btn5 = new JButton();
	 JButton btn6 = new JButton();
	 JButton btn7 = new JButton();
	 JButton btn8 = new JButton();
	 JButton btn9 = new JButton();
	//--------------------------------------------------------------------------------
	 
	 

	

	public daily_pass_ticket(Start f , String id , int m_or_nm){
	//프레임 레이아웃 설정, 사이즈 설정
		F = f;
		setSize(800, 1000);
		setLayout(null);
		
		JLabel header = new JLabel(new ImageIcon("teamProject/src/header/당일권_구입.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
		
		JLabel string1 = new JLabel("정액권 구매 선택");
		string1.setBounds(100,160,300,50);
		string1.setFont(new Font("맑은 고딕", Font.PLAIN | Font.BOLD, 30));
		add(string1);
		
		JLabel string2 = new JLabel("<html>xxxx를 선택하셨습니다.<br>사용하실 좌석타입을 선택해주세요.</html>");
		string2.setBounds(100,670,500,60);
		string2.setFont(new Font("MapoDPP", Font.PLAIN , 25));
		add(string2);
	  
	  
	// 라벨 설정  
	  JLabel label = new JLabel("시간을 선택해주세요");
	  add(label);
	  label.setHorizontalAlignment(JLabel.CENTER);
	  label.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
	  
	  add(btn3);
	  btn3.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 35));
	  btn3.setForeground(new Color(0x444444));
	  btn3.setOpaque(true);
	  btn3.setBackground(new Color(0xc8d77f));
	  btn3.setBounds(100, 240, 250, 150);
	  add(btn4);
	  btn4.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 35));
	  btn4.setForeground(new Color(0x444444));
	  btn4.setOpaque(true);
	  btn4.setBackground(new Color(0xc8d77f));
	  btn4.setBounds(450, 240, 250, 150);
	  add(btn5);
	  btn5.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 35));
	  btn5.setForeground(new Color(0x444444));
	  btn5.setOpaque(true);
	  btn5.setBackground(new Color(0xc8d77f));
	  btn5.setBounds(100, 490, 250, 150);
	  add(btn6);
	  btn6.setFont(new Font("MapoDPP", Font.PLAIN | Font.BOLD, 35));
	  btn6.setForeground(new Color(0x444444));
	  btn6.setOpaque(true);
	  btn6.setBackground(new Color(0xc8d77f));
	  btn6.setBounds(450, 490, 250, 150);
	  add(btn7);
	  btn7.setFont(new Font("MapoDPP", Font.PLAIN, 35));
	  btn7.setForeground(new Color(0x222222));
	  btn7.setOpaque(true);
	  btn7.setBackground(new Color(0xd0d0d0));
	  btn7.setBounds(530, 810, 200, 90);
	  add(btn8);
	  btn8.setFont(new Font("MapoDPP", Font.PLAIN, 30));
	  btn8.setForeground(new Color(0x222222));
	  btn8.setOpaque(true);
	  btn8.setBackground(new Color(0xd0d0d0));
	  btn8.setBounds(70, 810, 200, 90);
	  add(btn9);
	  btn9.setFont(new Font("MapoDPP", Font.PLAIN, 30));
	  btn9.setForeground(new Color(0x222222));
	  btn9.setOpaque(true);
	  btn9.setBackground(new Color(0xd0d0d0));
	  btn9.setBounds(300, 810, 200, 90);
	  
	 // 버튼 텍스트 입력 및 폰트 설정
	  btn3.setText("<html>" + "<div style='text-align:center'>" + "1시간" + "<br>" + "3,000원");
	  btn4.setText("<html>" + "<div style='text-align:center'>" + "3시간" + "<br>" + "8,000원");
	  btn5.setText("<html>" + "<div style='text-align:center'>" + "6시간" + "<br>" + "15,000원");
	  btn6.setText("<html>" + "<div style='text-align:center'>" + "12시간" + "<br>" + "25,000원");
	  btn7.setText("이전 화면");
	  btn8.setText("개인실 선택");
	  btn9.setText("단체실 선택");

	  String SQL = "UPDATE  members SET VOUCHER_CODE = ? , END_DATE = ? WHERE MEMBER_ID = ?";
	  
	  // 버튼 클릭시 반응
	  btn3.addActionListener(new ActionListener() {
		  
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 btn3.setBackground(new Color(227,227,227));
			 btn4.setBackground(new Color(0xc8d77f));
			 btn5.setBackground(new Color(0xc8d77f));
			 btn6.setBackground(new Color(0xc8d77f));
			 
//			try (
//					Connection conn = DriverManager.getConnection(url, user, password);
//					PreparedStatement pstmt = conn.prepareStatement(SQL);	
//					){
//				pstmt.setInt(1, 1);
//				pstmt.setString(2, "60");
//				pstmt.setString(3, id);
//				System.out.println("값 들어감");
//				
//				
//				int cnt = pstmt.executeUpdate();
//				
//				System.out.println(cnt + "건 실행");
//				
//		}catch (SQLException ex) {
//			ex.printStackTrace();
//		}catch (Exception e1) {	
//			e1.printStackTrace();
//		}
		}
	  });
	  btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn4.setBackground(new Color(227,227,227));
				btn3.setBackground(new Color(0xc8d77f));
				btn5.setBackground(new Color(0xc8d77f));
				btn6.setBackground(new Color(0xc8d77f));
			
				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(SQL);	
						){
					pstmt.setInt(1, 2);
					pstmt.setString(2, "180");
					pstmt.setString(3, id);
					System.out.println("값 들어감");	
					int cnt = pstmt.executeUpdate();		
				}catch (SQLException ex) {
					ex.printStackTrace();
				}catch (Exception e1) {	
					e1.printStackTrace();
				}
			}
		  });
	  btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 btn5.setBackground(new Color(227,227,227));
				 btn3.setBackground(new Color(0xc8d77f));
				 btn4.setBackground(new Color(0xc8d77f));
				 btn6.setBackground(new Color(0xc8d77f));
				 
				
				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(SQL);	
						){
					pstmt.setInt(1, 3);
					pstmt.setString(2, "360");
					pstmt.setString(3, id);
					System.out.println("값 들어감");	
					int cnt = pstmt.executeUpdate();		
			}catch (SQLException ex) {
				ex.printStackTrace();
			}catch (Exception e1) {	
				e1.printStackTrace();
			}
			}
		  });
	  btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn6.setBackground(new Color(227,227,227));
				 btn3.setBackground(new Color(0xc8d77f));
				 btn4.setBackground(new Color(0xc8d77f));
				 btn5.setBackground(new Color(0xc8d77f));
				
				
				
				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(SQL);	
						){
					pstmt.setInt(1, 3);
					pstmt.setString(2, "720");
					pstmt.setString(3, id);
					System.out.println("값 들어감");	
					int cnt = pstmt.executeUpdate();		
			}catch (SQLException ex) {
				ex.printStackTrace();
			}catch (Exception e1) {	
				e1.printStackTrace();
			}
			}
		  });
	  btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn7.setBackground(new Color(227,227,249));
				f.main_screen_Panel();
			}
		  });
	  btn8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn8.setBackground(new Color(227,227,249));
				
				
				f.add("Private_Seat_Selection", new Private_Seat_Selection(f,id,m_or_nm));
				f.Private_Seat_Selection_Panel();
				btn8.setBackground(new Color(255,255,255));
			}
		  });
	  btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn9.setBackground(new Color(227,227,249));
				f.add("Meeting_Room_Selection", new Meeting_Room_Selection(f,id,m_or_nm));
				f.Meeting_Room_Selection_Panel();
				btn9.setBackground(new Color(255,255,255));
			}
		  });
	  
	  
	
	  setVisible(true);
	  
	  }





	
}
	
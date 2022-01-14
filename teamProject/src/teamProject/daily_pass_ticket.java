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
	
		
	static {
		try {
			
			Class.forName(driverName);
			System.out.println("driver loaded");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	static // 이미지 삽입
	File f = new File("teamProject/src/icons/로고.jpg");
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img = tk.getImage("teamProject/src/icons/로고.jpg");
	
	 
	// 이미지 삽입
	 JPanel panel = new JPanel() {
		 @Override
		 public void paint(Graphics g) {
			 g.drawImage(img, 0, 0, this);
			 g.drawImage(img, 100, 0, this);
			 g.drawImage(img, 200, 0, this);
			 g.drawImage(img, 300, 0, this);
			 g.drawImage(img, 400, 0, this);
			 g.drawImage(img, 500, 0, this);
			 g.drawImage(img, 600, 0, this);
			 g.drawImage(img, 700, 0, this);
		 }
	 };
	 // 패널 생성
	 JPanel panel3 = new JPanel();
	 JPanel panel1 = new JPanel();
	 JPanel panel2 = new JPanel();
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
		 setLayout(null);
		 
		 
			
	 
	  
	  
	// 라벨 설정  
	  JLabel label = new JLabel("시간을 선택해주세요");
	  panel3.add(label);
	  label.setHorizontalAlignment(JLabel.CENTER);
	  label.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
	  
	  
	  
	  
	// 패널 위치 및 여백 설정
	  panel.setBounds(0, 0, 800, 100);
	  panel3.setBounds(0, 100, 800, 50);
	  panel1.setBounds(0, 150, 800, 700);
	  panel2.setBounds(0, 850, 800, 110);
	  panel1.setBorder(BorderFactory.createEmptyBorder(100 , 100, 100 , 100));
	  panel2.setBorder(BorderFactory.createEmptyBorder(0 , 0, 0 , 0));
	  
	// 버튼 색상  
	  btn3.setBackground(new Color(255,255,255));
	  btn4.setBackground(new Color(255,255,255));
	  btn5.setBackground(new Color(255,255,255));
	  btn6.setBackground(new Color(255,255,255));
	  btn7.setBackground(new Color(255,255,255));
	  btn8.setBackground(new Color(255,255,255));
	  btn9.setBackground(new Color(255,255,255));
	// 패널에 추가  
	  panel1.add(btn3);
	  panel1.add(btn4);
	  panel1.add(btn5);
	  panel1.add(btn6);
	  panel2.add(btn7);
	  panel2.add(btn8);
	  panel2.add(btn9);
	  
	 // 버튼 텍스트 입력 및 폰트 설정
	  btn3.setText("<html>" + "<div style='text-align:center'>" + "1시간" + "<br>" + "3000￦");
	  btn4.setText("<html>" + "<div style='text-align:center'>" + "3시간" + "<br>" + "8000￦");
	  btn5.setText("<html>" + "<div style='text-align:center'>" + "6시간" + "<br>" + "15000￦");
	  btn6.setText("<html>" + "<div style='text-align:center'>" + "12시간" + "<br>" + "25000￦");
	  btn7.setText("이전으로");
	  btn8.setText("개인실선택");
	  btn9.setText("단체실선택");
	  btn3.setFont(new Font("맑은 고딕" , Font.BOLD, 30));
	  btn4.setFont(new Font("맑은 고딕" , Font.BOLD, 30));
	  btn5.setFont(new Font("맑은 고딕" , Font.BOLD, 30));
	  btn6.setFont(new Font("맑은 고딕" , Font.BOLD, 30));
	  btn7.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
	  btn8.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
	  btn9.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
	  
	  // 패널 레이아웃 설정 및 배경색 설정
	  panel1.setLayout(new GridLayout(2, 2,100,100));
	  panel2.setLayout(new GridLayout(1, 3,50,50));
	  panel.setBackground(new Color(204,255,255));
	  panel3.setBackground(new Color(255,255,255));
	  panel1.setBackground(new Color(255,255,255));
	  panel2.setBackground(new Color(64,64,64));
	  
	  // 프레임에 패널 추가
	  add(panel);
	  add(panel3);
	  add(panel1);
	  add(panel2);
	  String SQL = "UPDATE  members SET VOUCHER_CODE = ? , END_DATE = ? WHERE MEMBER_ID = ?";
	  
	  // 버튼 클릭시 반응
	  btn3.addActionListener(new ActionListener() {
		  
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 btn3.setBackground(new Color(227,227,227));
			 btn4.setBackground(new Color(255,255,255));
			 btn5.setBackground(new Color(255,255,255));
			 btn6.setBackground(new Color(255,255,255));
			 
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
				btn3.setBackground(new Color(255,255,255));
				btn5.setBackground(new Color(255,255,255));
				btn6.setBackground(new Color(255,255,255));
			
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
				 btn3.setBackground(new Color(255,255,255));
				 btn4.setBackground(new Color(255,255,255));
				 btn6.setBackground(new Color(255,255,255));
				 
				
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
				 btn3.setBackground(new Color(255,255,255));
				 btn4.setBackground(new Color(255,255,255));
				 btn5.setBackground(new Color(255,255,255));
				
				
				
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
	
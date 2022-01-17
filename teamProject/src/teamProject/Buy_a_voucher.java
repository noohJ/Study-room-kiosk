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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Buy_a_voucher extends JPanel {
	private JLabel pass, season_ticket;
	private JButton exit,previous,ffh,ohh,thfh,fhh,od,sd,td;
	private Start F;
	private String id;
	private String[] price = new String[7];
	
	public Buy_a_voucher(Start f, String id){
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		for(int i = 0,j=5;i<price.length;++i,++j) {
			try {
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:XE",
						"hr",
						"1234");
				System.out.println("ø¨∞· ª˝º∫ øœ∑·.");
				
				PreparedStatement voucher_tp_t = conn.prepareStatement("SELECT * FROM Voucher Where voucher_code = "+String.valueOf(j));

				ResultSet rs = voucher_tp_t.executeQuery();
				
				while(rs.next()) {
					String money = String.format("%,d", rs.getInt("VOUCHER_PRICE"));
					price[i] = money+"ø¯";
				}
				
				
				rs.close();
				voucher_tp_t.close();
				conn.close();
				
			} catch (SQLException a) {
				a.printStackTrace();
			}
		}
	
		JLabel header = new JLabel("  ¡§æ◊±«/¡§±‚±« ±∏¿‘");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		pass = new JLabel("¡§æ◊±« ±∏∏≈ º±≈√");
		pass.setBounds(80,160,300,50);
		pass.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 30));
		add(pass);
		
		ffh = new JButton("<html><body style='text-align:center;'>50Ω√∞£<br>"+price[0]+"</html>");		
		ffh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,5));
				f.Payment_Panel();
			}
		});
		add(ffh);
		ffh.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		ffh.setForeground(new Color(0x444444));
		ffh.setOpaque(true);
		ffh.setBackground(new Color(0xc4ccf1));
		ffh.setBounds(80, 220, 300, 130);
		
		ohh = new JButton("<html><body style='text-align:center;'>100Ω√∞£<br>"+price[1]+"</html>");
		ohh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,6));
				f.Payment_Panel();
			}
		});
		add(ohh);
		ohh.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		ohh.setForeground(new Color(0x444444));
		ohh.setOpaque(true);
		ohh.setBackground(new Color(0xc4ccf1));
		ohh.setBounds(420, 220, 300, 130);
		
		thfh = new JButton("<html><body style='text-align:center;'>250Ω√∞£<br>"+price[2]+"</html>");
		thfh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,7));
				f.Payment_Panel();
			}
		});
		add(thfh);
		thfh.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		thfh.setForeground(new Color(0x444444));
		thfh.setOpaque(true);
		thfh.setBackground(new Color(0xc4ccf1));
		thfh.setBounds(80, 380, 300, 130);
		
		fhh = new JButton("<html><body style='text-align:center;'>500Ω√∞£<br>"+price[3]+"</html>");
		fhh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,8));
				f.Payment_Panel();
			}
		});
		add(fhh);
		fhh.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		fhh.setForeground(new Color(0x444444));
		fhh.setOpaque(true);
		fhh.setBackground(new Color(0xc4ccf1));
		fhh.setBounds(420, 380, 300, 130);
		
		
		
		season_ticket = new JLabel("¡§±‚±« ±∏∏≈ º±≈√");
		add(season_ticket);
		season_ticket.setBounds(80,550,300,50);
		season_ticket.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 30));
		
		od = new JButton("<html><body style='text-align:center;'>1¿œ±«<br>"+price[4]+"</html>");
		od.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,9));
				f.Payment_Panel();
			}
		});
		add(od);
		od.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		od.setForeground(new Color(0x444444));
		od.setOpaque(true);
		od.setBackground(new Color(0xc4ccf1));
		od.setBounds(80, 610, 200, 160);
		
		sd = new JButton("<html><body style='text-align:center;'>7¿œ±«<br>"+price[5]+"</html>");
		sd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,10));
				f.Payment_Panel();
			}
		});
		add(sd);
		sd.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		sd.setForeground(new Color(0x444444));
		sd.setOpaque(true);
		sd.setBackground(new Color(0xc4ccf1));
		sd.setBounds(300, 610, 200, 160);
		
		td = new JButton("<html><body style='text-align:center;'>30¿œ±«<br>"+price[6]+"</html>");
		td.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,11));
				f.Payment_Panel();
			}
		});
		add(td);
		td.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		td.setForeground(new Color(0x444444));
		td.setOpaque(true);
		td.setBackground(new Color(0xc4ccf1));
		td.setBounds(520, 610, 200, 160);
		
		previous = new JButton("¿Ã¿¸ »≠∏È");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 35));
		previous.setForeground(new Color(0x222222));
		previous.setOpaque(true);
		previous.setBackground(new Color(0xd0d0d0));
		previous.setBounds(530, 810, 200, 90);
		
		exit = new JButton("≥™∞°±‚");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.base_screen_Panel();
			}
		});
		add(exit);
		exit.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 35));
		exit.setForeground(new Color(0x222222));
		exit.setOpaque(true);
		exit.setBackground(new Color(0xd0d0d0));
		exit.setBounds(310, 810, 200, 90);
	}
}

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

public class Extend_daily_ticket extends JPanel {
	
	private JLabel pass;
	private Start F;
	private JButton ohb,thb,shb,twehb,previous;
	private String[] price = new String[4];
	
	public Extend_daily_ticket(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		setBackground(new Color(0xFFFFFF));
		F = f;
		
		for(int i = 0,j=1;i<price.length;++i,++j) {
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
		
		JLabel header = new JLabel("  ¥Á¿œ±« ø¨¿Â ±∏¿‘");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		ohb = new JButton("<html><body style='text-align:center;'>1Ω√∞£<br>"+price[0]+"</html>");		
		ohb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,1,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(ohb);
		ohb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		ohb.setForeground(new Color(0x444444));
		ohb.setOpaque(true);
		ohb.setBackground(new Color(0xc4ccf1));
		ohb.setBounds(80, 220, 300, 130);
		
		thb = new JButton("<html><body style='text-align:center;'>3Ω√∞£<br>"+price[1]+"</html>");
		thb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,2,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(thb);
		thb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		thb.setForeground(new Color(0x444444));
		thb.setOpaque(true);
		thb.setBackground(new Color(0xc4ccf1));
		thb.setBounds(420, 220, 300, 130);
		
		shb = new JButton("<html><body style='text-align:center;'>6Ω√∞£<br>"+price[2]+"</html>");
		shb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,3,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(shb);
		shb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		shb.setForeground(new Color(0x444444));
		shb.setOpaque(true);
		shb.setBackground(new Color(0xc4ccf1));
		shb.setBounds(80, 380, 300, 130);
		
		twehb = new JButton("<html><body style='text-align:center;'>12Ω√∞£<br>"+price[3]+"</html>");
		twehb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,4,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(twehb);
		twehb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		twehb.setForeground(new Color(0x444444));
		twehb.setOpaque(true);
		twehb.setBackground(new Color(0xc4ccf1));
		twehb.setBounds(420, 380, 300, 130);
				
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
	}
	
}

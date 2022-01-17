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

public class Extend_pass_ticket extends JPanel {
	
	private JLabel pass;
	private Start F;
	private JButton fhb,ohhb,thhb,fhhb,previous;
	private String[] price = new String[4];
	
	public Extend_pass_ticket(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		setBackground(new Color(0xFFFFFF));
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
		
		JLabel header = new JLabel("  ¡§æ◊±« ø¨¿Â ±∏¿‘");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		pass = new JLabel("ø¨¿Â Ω√∞£ º±≈√");
		pass.setBounds(80,160,300,50);
		pass.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 30));
		add(pass);
		
		fhb = new JButton("<html><body style='text-align:center;'>50Ω√∞£<br>"+price[0]+"</html>");		
		fhb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,5,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(fhb);
		fhb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		fhb.setForeground(new Color(0x444444));
		fhb.setOpaque(true);
		fhb.setBackground(new Color(0xc4ccf1));
		fhb.setBounds(80, 220, 300, 130);
		
		ohhb = new JButton("<html><body style='text-align:center;'>100Ω√∞£<br>"+price[1]+"</html>");
		ohhb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,6,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(ohhb);
		ohhb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		ohhb.setForeground(new Color(0x444444));
		ohhb.setOpaque(true);
		ohhb.setBackground(new Color(0xc4ccf1));
		ohhb.setBounds(420, 220, 300, 130);
		
		thhb = new JButton("<html><body style='text-align:center;'>250Ω√∞£<br>"+price[2]+"</html>");
		thhb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,7,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(thhb);
		thhb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		thhb.setForeground(new Color(0x444444));
		thhb.setOpaque(true);
		thhb.setBackground(new Color(0xc4ccf1));
		thhb.setBounds(80, 380, 300, 130);
		
		fhhb = new JButton("<html><body style='text-align:center;'>500Ω√∞£<br>"+price[3]+"</html>");
		fhhb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,8,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(fhhb);
		fhhb.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN | Font.BOLD, 35));
		fhhb.setForeground(new Color(0x444444));
		fhhb.setOpaque(true);
		fhhb.setBackground(new Color(0xc4ccf1));
		fhhb.setBounds(420, 380, 300, 130);
		
		
		
		
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

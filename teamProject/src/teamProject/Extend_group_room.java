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

public class Extend_group_room extends JPanel {
	
	private JLabel pass,time_remaining;
	private Start F;
	private JButton ohb,thb,shb,twehb,previous;
	private String[] price = new String[4];
	private String tr;
	
	public Extend_group_room(Start f,String id, int m_or_nm) {
		setSize(800, 1000);
		setLayout(null);
		setBackground(new Color(0xFFFFFF));
		F = f;
		
		for(int i = 0,j=12;i<price.length;++i,++j) {
			try {
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:XE",
						"hr",
						"1234");
				System.out.println("���� ���� �Ϸ�.");
				
				PreparedStatement voucher_tp_t = conn.prepareStatement("SELECT * FROM Voucher Where voucher_code = "+String.valueOf(j));

				ResultSet rs = voucher_tp_t.executeQuery();
				
				while(rs.next()) {
					String money = String.format("%,d", rs.getInt("VOUCHER_PRICE"));
					price[i] = money+"��";
				}
				
				
				rs.close();
				voucher_tp_t.close();
				conn.close();
				
			} catch (SQLException a) {
				a.printStackTrace();
			}
		}
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"hr",
					"1234");
			System.out.println("���� ���� �Ϸ�.");
			String lt ="";
			if(m_or_nm == 0) {
				lt = "SELECT * FROM MEMBERS WHERE member_id = '"+id+"'";
			}else {
				lt = "SELECT * FROM non_members WHERE non_member_phone = '"+id+"'";
			}
			PreparedStatement trt = conn.prepareStatement(lt);

			ResultSet rs = trt.executeQuery();
			
			while(rs.next()) {
				int t_hour = rs.getInt("g_end_date") / 60;
				int t_minute = rs.getInt("g_end_date") % 60;
				tr = "���� �ð� : "+t_hour+"�ð� "+t_minute+"��";
			}					
			rs.close();
			trt.close();
			conn.close();
			
		} catch (SQLException a) {
			a.printStackTrace();
		}
		
		JLabel header = new JLabel("  ��ü�� ���� ����");
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("���� ����", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		
		pass = new JLabel("��ü�� ���� �ð� ����");
		add(pass);
		pass.setBounds(80,160,400,50);
		pass.setFont(new Font("���� ����", Font.PLAIN | Font.BOLD, 30));
		
		ohb = new JButton("<html><body style='text-align:center;'>1�ð�<br>"+price[0]+"</html>");		
		ohb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,12,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(ohb);
		ohb.setFont(new Font("���� ����", Font.PLAIN | Font.BOLD, 35));
		ohb.setForeground(new Color(0x444444));
		ohb.setOpaque(true);
		ohb.setBackground(new Color(0xc4ccf1));
		ohb.setBounds(80, 220, 300, 130);
		
		thb = new JButton("<html><body style='text-align:center;'>2�ð�<br>"+price[1]+"</html>");
		thb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,13,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(thb);
		thb.setFont(new Font("���� ����", Font.PLAIN | Font.BOLD, 35));
		thb.setForeground(new Color(0x444444));
		thb.setOpaque(true);
		thb.setBackground(new Color(0xc4ccf1));
		thb.setBounds(420, 220, 300, 130);
		
		shb = new JButton("<html><body style='text-align:center;'>4�ð�<br>"+price[2]+"</html>");
		shb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,14,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(shb);
		shb.setFont(new Font("���� ����", Font.PLAIN | Font.BOLD, 35));
		shb.setForeground(new Color(0x444444));
		shb.setOpaque(true);
		shb.setBackground(new Color(0xc4ccf1));
		shb.setBounds(80, 380, 300, 130);
		
		twehb = new JButton("<html><body style='text-align:center;'>8�ð�<br>"+price[3]+"</html>");
		twehb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("extend_payment",new Extend_payment(f,id,15,m_or_nm));
				f.Extend_payment_Panel();
			}
		});
		add(twehb);
		twehb.setFont(new Font("���� ����", Font.PLAIN | Font.BOLD, 35));
		twehb.setForeground(new Color(0x444444));
		twehb.setOpaque(true);
		twehb.setBackground(new Color(0xc4ccf1));
		twehb.setBounds(420, 380, 300, 130);
		
		time_remaining = new JLabel(tr);
		add(time_remaining);
		time_remaining.setFont(new Font("NanumGothic", Font.BOLD, 50));
		time_remaining.setBounds(0, 550, 800, 200);
		time_remaining.setHorizontalAlignment(JLabel.CENTER);
		time_remaining.setVerticalAlignment(JLabel.CENTER);
				
		previous = new JButton("���� ȭ��");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			}
		});
		add(previous);
		previous.setFont(new Font("���� ����", Font.PLAIN, 35));
		previous.setForeground(new Color(0x222222));
		previous.setOpaque(true);
		previous.setBackground(new Color(0xd0d0d0));
		previous.setBounds(530, 810, 200, 90);
	}
}

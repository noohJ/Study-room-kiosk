package project_lsk;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class Start extends JFrame {
	
	private CardLayout layout = new CardLayout();
	
	public Start() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		getContentPane().setLayout(layout);
		
		getContentPane().add("base_screen", new Base_screen(this));
		getContentPane().add("non_member_login", new Non_Member_Login(this));
		
//		panel_s.setLayout(layout);
//		add(panel_s);
//		panel_s.add("base_scrren", new Base_screen());
//		panel_s.add("non_member_Login", new Non_Member_Login());
		
		
		
		
		setBounds(1000, 100, 800, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		
	}
	public void base_screen_panel() {
		layout.show(this.getContentPane(), "base_screen");
	}
	public void non_member_login_panel() {
		layout.show(this.getContentPane(), "non_member_login");
	}
	
	public static void main(String[] args) {
		new Start();
	}
}

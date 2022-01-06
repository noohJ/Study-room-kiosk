package teamProject;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class Start extends JFrame{
	
	private CardLayout cards = new CardLayout();
	
	public Start() { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		setBounds(600,20,800, 1000);
		
		getContentPane().setLayout(cards);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().add("base_screen", new Base_screen(this));
		getContentPane().add("member_login", new Member_login(this));
		getContentPane().add("find_id", new Find_id(this));
		getContentPane().add("find_pw", new Find_password(this));
		getContentPane().add("non_member_login", new Non_Member_Login(this));
		
		setVisible(true);
	} 
	public void base_screen_Panel() {
		cards.show(this.getContentPane(),"base_screen"); 
	} 
	public void main_screen_Panel() {
		cards.show(this.getContentPane(),"main_screen"); 
	}
	public void member_login_Panel() {
		cards.show(this.getContentPane(),"member_login"); 
	} 
	public void find_id_Panel() {
		cards.show(this.getContentPane(), "find_id");
	}
	public void find_pw_Panel() {
		cards.show(this.getContentPane(), "find_pw");
	}
	public void non_member_login_Panel() {
		cards.show(this.getContentPane(),"non_member_login"); 
	}
	public void use_post_Panel() {
		cards.show(this.getContentPane(),"use_pass_or_seasn_ticket"); 
	}


	
	public static void main(String[] args) {
		
		
		new Start();
	}
}
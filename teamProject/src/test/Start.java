package test;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class Start extends JFrame {

    private CardLayout layout = new CardLayout();

    public Start() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("로딩완료");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        setBounds(1000, 100, 800, 1000);
        getContentPane().setLayout(layout);
        setResizable(false);

        getContentPane().add("base_screen", new Base_screen(this));
        getContentPane().add("non_member_login", new Non_Member_Login(this));


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


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
package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Private_Seat_Selection extends JPanel {
	
   private Start F;
   
   ImageIcon icon = new ImageIcon("teamProject/src/icons/back4.jpg");
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
   
   public Private_Seat_Selection(Start f,String id, int n_or_nm) {
      setSize(800, 1000);
      setLayout(null);
      F = f;
      
      JLabel header = new JLabel(new ImageIcon("teamProject/src/header/헤더.jpg"));
		add(header);
		header.setFocusable(true);
		header.setBounds(0, 0, 800, 130);
      JLabel string0 = new JLabel("입구↓");
      JLabel string1 = new JLabel(": 선택 가능");
      JLabel string1_square = new JLabel();
      JLabel string2 = new JLabel(": 선택 불가능");
      JLabel string2_square = new JLabel();
      JButton seat1 = new Private_SeatButton(10, 155, "1", F, id,n_or_nm);
      JButton seat2 = new Private_SeatButton(10, 235, "2", F, id,n_or_nm);
      JButton seat3 = new Private_SeatButton(10, 315, "3", F, id,n_or_nm);
      JButton seat4 = new Private_SeatButton(10, 395, "4", F, id,n_or_nm);
      JButton seat5 = new Private_SeatButton(10, 475, "5", F, id,n_or_nm);
      JButton seat6 = new Private_SeatButton(10, 555, "6", F, id,n_or_nm);
      JButton seat7 = new Private_SeatButton(10, 635, "7", F, id,n_or_nm);
      JButton seat8 = new Private_SeatButton(10, 715, "8", F, id,n_or_nm);
      JButton seat9 = new Private_SeatButton(150, 155, "9", F, id,n_or_nm);
      JButton seat10 = new Private_SeatButton(220, 155, "10", F, id,n_or_nm);
      JButton seat11 = new Private_SeatButton(290, 155, "11", F, id,n_or_nm);
      JButton seat12 = new Private_SeatButton(360, 155, "12", F, id,n_or_nm);
      JButton seat13 = new Private_SeatButton(430, 155, "13", F, id,n_or_nm);
      JButton seat14 = new Private_SeatButton(500, 155, "14", F, id,n_or_nm);
      JButton seat15 = new Private_SeatButton(570, 155, "15", F, id,n_or_nm);
      JButton seat16 = new Private_SeatButton(150, 295, "16", F, id,n_or_nm);
      JButton seat17 = new Private_SeatButton(220, 295, "17", F, id,n_or_nm);
      JButton seat18 = new Private_SeatButton(290, 295, "18", F, id,n_or_nm);
      JButton seat19 = new Private_SeatButton(360, 295, "19", F, id,n_or_nm);
      JButton seat20 = new Private_SeatButton(430, 295, "20", F, id,n_or_nm);
      JButton seat21 = new Private_SeatButton(500, 295, "21", F, id,n_or_nm);
      JButton seat22 = new Private_SeatButton(570, 295, "22", F, id,n_or_nm);
      JButton seat23 = new Private_SeatButton(150, 365, "23", F, id,n_or_nm);
      JButton seat24 = new Private_SeatButton(220, 365, "24", F, id,n_or_nm);
      JButton seat25 = new Private_SeatButton(290, 365, "25", F, id,n_or_nm);
      JButton seat26 = new Private_SeatButton(360, 365, "26", F, id,n_or_nm);
      JButton seat27 = new Private_SeatButton(430, 365, "27", F, id,n_or_nm);
      JButton seat28 = new Private_SeatButton(500, 365, "28", F, id,n_or_nm);
      JButton seat29 = new Private_SeatButton(570, 365, "29", F, id,n_or_nm);
      JButton seat30 = new Private_SeatButton(150, 505, "30", F, id,n_or_nm);
      JButton seat31 = new Private_SeatButton(220, 505, "31", F, id,n_or_nm);
      JButton seat32 = new Private_SeatButton(290, 505, "32", F, id,n_or_nm);
      JButton seat33 = new Private_SeatButton(360, 505, "33", F, id,n_or_nm);
      JButton seat34 = new Private_SeatButton(430, 505, "34", F, id,n_or_nm);
      JButton seat35 = new Private_SeatButton(500, 505, "35", F, id,n_or_nm);
      JButton seat36 = new Private_SeatButton(570, 505, "36", F, id,n_or_nm);
      JButton seat37 = new Private_SeatButton(150, 575, "37", F, id,n_or_nm);
      JButton seat38 = new Private_SeatButton(220, 575, "38", F, id,n_or_nm);
      JButton seat39 = new Private_SeatButton(290, 575, "39", F, id,n_or_nm);
      JButton seat40 = new Private_SeatButton(360, 575, "40", F, id,n_or_nm);
      JButton seat41 = new Private_SeatButton(430, 575, "41", F, id,n_or_nm);
      JButton seat42 = new Private_SeatButton(500, 575, "42", F, id,n_or_nm);
      JButton seat43 = new Private_SeatButton(570, 575, "43", F, id,n_or_nm);
      JButton seat44 = new Private_SeatButton(150, 715, "44", F, id,n_or_nm);
      JButton seat45 = new Private_SeatButton(220, 715, "45", F, id,n_or_nm);
      JButton seat46 = new Private_SeatButton(290, 715, "46", F, id,n_or_nm);
      JButton seat47 = new Private_SeatButton(360, 715, "47", F, id,n_or_nm);
      JButton seat48 = new Private_SeatButton(430, 715, "48", F, id,n_or_nm);
      JButton seat49 = new Private_SeatButton(500, 715, "49", F, id,n_or_nm);
      JButton seat50 = new Private_SeatButton(570, 715, "50", F, id,n_or_nm);
      JButton seat51 = new Private_SeatButton(710, 155, "51", F, id,n_or_nm);
      JButton seat52 = new Private_SeatButton(710, 235, "52", F, id,n_or_nm);
      JButton seat53 = new Private_SeatButton(710, 315, "53", F, id,n_or_nm);
      JButton seat54 = new Private_SeatButton(710, 395, "54", F, id,n_or_nm);
      JButton seat55 = new Private_SeatButton(710, 475, "55", F, id,n_or_nm);
      JButton seat56 = new Private_SeatButton(710, 555, "56", F, id,n_or_nm);
      JButton seat57 = new Private_SeatButton(710, 635, "57", F, id,n_or_nm);
      JButton seat58 = new Private_SeatButton(710, 715, "58", F, id,n_or_nm);
      JButton prev_btn = new JButton("이전 화면");
      
      prev_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				f.daily_pass_ticket_Panel();
			}
		  });
      
      
      add(string0);
      string0.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 20));
      string0.setForeground(new Color(0x545454));
      string0.setBounds(85, 155, 100, 30);
      add(string1);
      string1.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
      string1.setForeground(new Color(0x545454));
      string1.setBounds(100, 810, 200, 40);
      add(string1_square);
      string1_square.setOpaque(true);
      string1_square.setBounds(50, 820, 25, 25);
      string1_square.setBackground(new Color(0xcccccc));
      add(string2);
      string2.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
      string2.setForeground(new Color(0x545454));
      string2.setBounds(100, 850, 200, 40);
      add(string2_square);
      string2_square.setOpaque(true);
      string2_square.setBounds(50, 860, 25, 25);
      string2_square.setBackground(new Color(0x545454));
      add(seat1);
      add(seat2);
      add(seat3);
      add(seat4);
      add(seat5);
      add(seat6);
      add(seat7);
      add(seat8);
      add(seat9);
      add(seat10);
      add(seat11);
      add(seat12);
      add(seat13);
      add(seat14);
      add(seat15);
      add(seat16);
      add(seat17);
      add(seat18);
      add(seat19);
      add(seat20);
      add(seat21);
      add(seat22);
      add(seat23);
      add(seat24);
      add(seat25);
      add(seat26);
      add(seat27);
      add(seat28);
      add(seat29);
      add(seat30);
      add(seat31);
      add(seat32);
      add(seat33);
      add(seat34);
      add(seat35);
      add(seat36);
      add(seat37);
      add(seat38);
      add(seat39);
      add(seat40);
      add(seat41);
      add(seat42);
      add(seat43);
      add(seat44);
      add(seat45);
      add(seat46);
      add(seat47);
      add(seat48);
      add(seat49);
      add(seat50);
      add(seat51);
      add(seat52);
      add(seat53);
      add(seat54);
      add(seat55);
      add(seat56);
      add(seat57);
      add(seat58);
      add(prev_btn);
      prev_btn.setFont(new Font("NanumGothic", Font.PLAIN | Font.BOLD, 25));
		prev_btn.setForeground(new Color(0xf5f6f7));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0x8e8e8e));
		prev_btn.setBounds(530, 810, 200, 90);
   }
}

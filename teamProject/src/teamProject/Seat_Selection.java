package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import seatSection_component.SeatButton;

public class Seat_Selection extends JPanel {

	private Start F;
	
	public Seat_Selection(Start f,String id) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		
		JLabel header = new JLabel(" ¡¬ºÆ º±≈√");
		JButton seat1 = new SeatButton(10, 155, "1");
		JButton seat2 = new SeatButton(10, 225, "2");
		JButton seat3 = new SeatButton(10, 295, "3");
		JButton seat4 = new SeatButton(10, 365, "4");
		JButton seat5 = new SeatButton(10, 435, "5");
		JButton seat6 = new SeatButton(10, 505, "6");
		JButton seat7 = new SeatButton(10, 575, "7");
		JButton seat8 = new SeatButton(10, 645, "8");
		JButton seat9 = new SeatButton(10, 715, "9");
		JButton seat10 = new SeatButton(150, 155, "10");
		JButton seat11 = new SeatButton(220, 155, "11");
		JButton seat12 = new SeatButton(290, 155, "12");
		JButton seat13 = new SeatButton(360, 155, "13");
		JButton seat14 = new SeatButton(430, 155, "14");
		JButton seat15 = new SeatButton(500, 155, "15");
		JButton seat16 = new SeatButton(570, 155, "16");
		JButton seat17 = new SeatButton(150, 295, "17");
		JButton seat18 = new SeatButton(220, 295, "18");
		JButton seat19 = new SeatButton(290, 295, "19");
		JButton seat20 = new SeatButton(360, 295, "20");
		JButton seat21 = new SeatButton(430, 295, "21");
		JButton seat22 = new SeatButton(500, 295, "22");
		JButton seat23 = new SeatButton(570, 295, "23");
		JButton seat24 = new SeatButton(150, 365, "24");
		JButton seat25 = new SeatButton(220, 365, "25");
		JButton seat26 = new SeatButton(290, 365, "26");
		JButton seat27 = new SeatButton(360, 365, "27");
		JButton seat28 = new SeatButton(430, 365, "28");
		JButton seat29 = new SeatButton(500, 365, "29");
		JButton seat30 = new SeatButton(570, 365, "30");
		JButton seat31 = new SeatButton(150, 505, "31");
		JButton seat32 = new SeatButton(220, 505, "32");
		JButton seat33 = new SeatButton(290, 505, "33");
		JButton seat34 = new SeatButton(360, 505, "34");
		JButton seat35 = new SeatButton(430, 505, "35");
		JButton seat36 = new SeatButton(500, 505, "36");
		JButton seat37 = new SeatButton(570, 505, "37");
		JButton seat38 = new SeatButton(150, 575, "38");
		JButton seat39 = new SeatButton(220, 575, "39");
		JButton seat40 = new SeatButton(290, 575, "40");
		JButton seat41 = new SeatButton(360, 575, "41");
		JButton seat42 = new SeatButton(430, 575, "42");
		JButton seat43 = new SeatButton(500, 575, "43");
		JButton seat44 = new SeatButton(570, 575, "44");
		JButton seat45 = new SeatButton(150, 715, "45");
		JButton seat46 = new SeatButton(220, 715, "46");
		JButton seat47 = new SeatButton(290, 715, "47");
		JButton seat48 = new SeatButton(360, 715, "48");
		JButton seat49 = new SeatButton(430, 715, "49");
		JButton seat50 = new SeatButton(500, 715, "50");
		JButton seat51 = new SeatButton(570, 715, "51");
		JButton seat52 = new SeatButton(710, 155, "52");
		JButton seat53 = new SeatButton(710, 225, "53");
		JButton seat54 = new SeatButton(710, 295, "54");
		JButton seat55 = new SeatButton(710, 365, "55");
		JButton seat56 = new SeatButton(710, 435, "56");
		JButton seat57 = new SeatButton(710, 505, "57");
		JButton seat58 = new SeatButton(710, 575, "58");
		JButton seat59 = new SeatButton(710, 645, "59");
		JButton seat60 = new SeatButton(710, 715, "60");
		JButton prev_btn = new JButton("¿Ã¿¸ »≠∏È");
		
		
		
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.use_post_Panel();
			};
		});
		
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
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
		add(seat59);
		add(seat60);
		add(prev_btn);
		prev_btn.setFont(new Font("MapoDPP", Font.PLAIN, 35));
		prev_btn.setForeground(new Color(0x222222));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0xd0d0d0));
		prev_btn.setBounds(530, 810, 200, 90);
	}
}

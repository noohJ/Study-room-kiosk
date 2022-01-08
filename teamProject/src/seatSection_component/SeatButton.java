package seatSection_component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import teamProject.Start;

public class SeatButton extends JButton {	
	
	public SeatButton(int x, int y, String z) {
		if(DB_Seats.seats_num_arr(z)) {
			setText(z);
			setLocation(x, y);
			setSize(60, 60);		
			setFont(new Font("MapoDPP", Font.PLAIN, 18));
			setForeground(new Color(0x545454));
			setOpaque(true);
			setBackground(new Color(0xdedede));
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);	
		} else {
			setText(z);
			setLocation(x, y);
			setSize(60, 60);		
			setFont(new Font("MapoDPP", Font.PLAIN, 18));
			setForeground(new Color(0xdedede));
			setOpaque(true);
			setBackground(new Color(0x545454));
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);
			setEnabled(false);
		}
		
	};
	
}

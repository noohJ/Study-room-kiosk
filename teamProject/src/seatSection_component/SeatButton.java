package seatSection_component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SeatButton extends JButton {
	
	public SeatButton(int x, int y, String z) {
		setText(z);
		setLocation(x, y);
		setSize(60, 60);		
		setFont(new Font("MapoDPP", Font.PLAIN, 18));
		setForeground(new Color(0xdedede));
		setOpaque(true);
		setBackground(new Color(0x545454));
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	};
	
}

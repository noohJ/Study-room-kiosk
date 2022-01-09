package seatSection_component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import teamProject.Start;

public class SeatButton extends JButton {
	
	public SeatButton(int x, int y, String seat_number) {
		
		if(DB_Seats.seats_num_arr(seat_number)) {
			setText(seat_number);
			setLocation(x, y);
			setSize(60, 60);		
			setFont(new Font("MapoDPP", Font.PLAIN, 18));
			setForeground(new Color(0x545454));
			setOpaque(true);
			setBackground(new Color(0xdedede));
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);
			
			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int answer = JOptionPane.showConfirmDialog(null, ""+seat_number+"번 자리를 사용하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION );
					if(answer==JOptionPane.YES_OPTION) {
						Start start = new Start();
						// 초기화하면서 재시작 되는건 좋은데 전에게 꺼지지 않음
						// 하나만 끄는 메소드로는 dispose가 있음
						// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 이런식으로 사용
					}					
				}
			});
			
		} else {
			setText(seat_number);
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

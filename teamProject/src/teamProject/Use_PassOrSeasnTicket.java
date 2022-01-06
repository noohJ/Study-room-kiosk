package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Use_PassOrSeasnTicket extends JPanel {
	
	private Start F;
	
	public Use_PassOrSeasnTicket(Start f,String id) {
		setSize(800, 1000);
		setLayout(null);
		F = f;
		String ticket = DB_Members.mb_code_arr(id); // 티켓 종류 + 티켓 이름
		String remaining_days = DB_Members.mb_rd_arr(id);
		JLabel header = new JLabel(" 정액권/정기권 사용");
		JLabel string1 = new JLabel("<html><body style='text-align:center;'>"
				+ "현재 사용 중인 티켓 :<br>"+ticket+"</html>");
		JLabel string2 = new JLabel("남은 시간 : "+remaining_days);
		JButton seat_selection = new JButton("입실 : 좌석 선택하기");
		JButton prev_btn = new JButton("이전 화면");
		
		prev_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			};
		});
		
		add(header);
		header.setFocusable(true);
		header.setFont(new Font("맑은 고딕", Font.ITALIC | Font.BOLD, 35));
		header.setForeground(new Color(0xdedede));
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 130);
		header.setBackground(new Color(0x545454));
		add(string1);
		string1.setFont(new Font("MapoDPP", Font.BOLD, 50));
		string1.setBounds(0, 200, 800, 200);
		string1.setHorizontalAlignment(JLabel.CENTER);
		string1.setVerticalAlignment(JLabel.CENTER);
		add(string2);
		string2.setFont(new Font("MapoDPP", Font.BOLD, 50));
		string2.setBounds(0, 450, 800, 100);
		string2.setHorizontalAlignment(JLabel.CENTER);
		add(seat_selection);
		seat_selection.setFont(new Font("MapoDPP", Font.PLAIN, 46));
		seat_selection.setForeground(new Color(0xffffff));
		seat_selection.setOpaque(true);
		seat_selection.setBackground(new Color(0x5777ff));
		seat_selection.setBounds(115, 670, 560, 94);
		add(prev_btn);
		prev_btn.setFont(new Font("MapoDPP", Font.PLAIN, 35));
		prev_btn.setForeground(new Color(0x222222));
		prev_btn.setOpaque(true);
		prev_btn.setBackground(new Color(0xd0d0d0));
		prev_btn.setBounds(530, 810, 200, 90);
	}
}

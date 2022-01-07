package teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Buy_a_voucher extends JPanel {
	private JLabel pass, season_ticket;
	private JButton exit,previous,ffh,ohh,thfh,fhh,od,sd,td;
	private Start F;
	private String id;
	
	public Buy_a_voucher(Start f, String id){
		setSize(800, 1000);
		setLayout(null);
		F = f;

		pass = new JLabel("정액권");
		pass.setBounds(80,180,200,50);
		add(pass);
		
		ffh = new JButton("50시간");
		ffh.setBounds(80, 240, 300, 100);
		ffh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,5));
				f.Payment_Panel();
			}
		});
		add(ffh);
		
		ohh = new JButton("100시간");
		ohh.setBounds(420, 240, 300, 100);
		ohh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,6));
				f.Payment_Panel();
			}
		});
		add(ohh);
		
		thfh = new JButton("250시간");
		thfh.setBounds(80, 375, 300, 100);
		thfh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,7));
				f.Payment_Panel();
			}
		});
		add(thfh);
		
		fhh = new JButton("500시간");
		fhh.setBounds(420, 375, 300, 100);
		fhh.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,8));
				f.Payment_Panel();
			}
		});
		add(fhh);
		
		
		
		season_ticket = new JLabel("정기권");
		season_ticket.setBounds(80,500,200,50);
		add(season_ticket);
		
		od = new JButton("1일권");
		od.setBounds(80, 560, 200, 300);
		od.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,9));
				f.Payment_Panel();
			}
		});
		add(od);
		
		sd = new JButton("7일권");
		sd.setBounds(300, 560, 200, 300);
		sd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,10));
				f.Payment_Panel();
			}
		});
		add(sd);
		
		td = new JButton("30일권");
		td.setBounds(520, 560, 200, 300);
		td.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.add("payment",new Payment(f,id,11));
				f.Payment_Panel();
			}
		});
		add(td);
		
		previous = new JButton("이전 화면");
		previous.setBounds(80,100,100,30);
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.main_screen_Panel();
			}
		});
		add(previous);
		
		exit = new JButton("나가기");
		exit.setBounds(210,100,100,30);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.base_screen_Panel();
			}
		});
		add(exit);
	}
}

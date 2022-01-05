package teamProject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chk_id extends JPanel {
	
	private Start F;
	private JLabel look_id;
	private JButton confirm;
	
	public Chk_id(Start f,String id) {
		setBounds(150,250,500,500);
		setLayout(null);
		F=f;
		
		look_id = new JLabel(id);
		look_id.setBounds(100,100,300,150);
		look_id.setHorizontalAlignment(JLabel.CENTER);
		add(look_id);
		
		confirm = new JButton("»Æ¿Œ");
		
		setVisible(true);
		
	}
}

//JPanel fid_card = new JPanel();
//add(fid_card);
//fid_card.setVisible(false);
//fid_card.setBounds(150,200,500,500);
//fid_card.setVisible(true);
//fid_card.setBackground(new Color(0x9ab1db));
//JLabel look_id = new JLabel(rs.getString("MEMBER_ID"));
//JButton id_confirm = new JButton();
//fid_card.add(look_id);
//fid_card.add(id_confirm);
//
//look_id.setHorizontalAlignment(JLabel.CENTER);
//look_id.setBounds(100,100,300,150);
//fid_card.setBounds(200,400,100,50);
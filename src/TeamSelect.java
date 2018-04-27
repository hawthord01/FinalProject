import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamSelect extends JPanel {

	/**
	 * Create the panel.
	 */
	public TeamSelect() {
		setLayout(null);
		
		JLabel lblSelectYourTeam = new JLabel("Select Your Team!");
		lblSelectYourTeam.setBounds(166, 6, 112, 16);
		add(lblSelectYourTeam);
		
		JButton btnNewButton = new JButton("Raptors");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(44, 64, 101, 22);
		add(btnNewButton);
		
		JLabel lblEasternConference = new JLabel("Eastern Conference");
		lblEasternConference.setBounds(34, 36, 131, 16);
		add(lblEasternConference);
		
		JLabel label = new JLabel("__________________");
		label.setBounds(33, 36, 131, 16);
		add(label);
		
		JButton btnNewButton_1 = new JButton("Celtics");
		btnNewButton_1.setBounds(44, 94, 101, 22);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("76ers");
		btnNewButton_2.setBounds(44, 124, 101, 22);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cavaliers");
		btnNewButton_3.setBounds(44, 155, 101, 22);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Pacers");
		btnNewButton_4.setBounds(44, 183, 101, 22);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Miami");
		btnNewButton_5.setBounds(44, 212, 101, 22);
		add(btnNewButton_5);
		
		JLabel lblWesternConference = new JLabel("Western Conference");
		lblWesternConference.setBounds(281, 36, 150, 16);
		add(lblWesternConference);
		
		JLabel lblNewLabel = new JLabel("__________________");
		lblNewLabel.setBounds(269, 34, 61, 16);
		add(lblNewLabel);

	}
}

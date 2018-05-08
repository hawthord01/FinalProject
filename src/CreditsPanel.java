import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreditsPanel extends JPanel {

	private PanelChangeListener listener;
	
	/**
	 * Create the panel.
	 */
	public CreditsPanel(PanelChangeListener listener) {
		setLayout(null);
		this.listener = listener;
		
		JLabel lblMadeBy = new JLabel("Made By");
		lblMadeBy.setBounds(420, 100, 51, 16);
		add(lblMadeBy);
		
		JLabel lblTerryDunbar = new JLabel("Terry Dunbar");
		lblTerryDunbar.setBounds(405, 149, 91, 16);
		add(lblTerryDunbar);
		
		JLabel lblNewLabel = new JLabel("Daylen Hawthorne");
		lblNewLabel.setBounds(391, 164, 126, 21);
		add(lblNewLabel);
		
		JButton button = new JButton("< Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("TitlePanel");
			}
		});
		button.setBounds(390, 209, 117, 29);
		add(button);
		
	}

}

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Font;

public class TitlePanel extends JPanel {

	private PanelChangeListener listener;
	
	/**
	 * Create the panel.
	 */
	public TitlePanel(PanelChangeListener listener) {
		setLayout(null);
		this.listener = listener;
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("TeamSelect");
			}
		});
		btnNewButton.setBounds(155, 152, 117, 29);
		add(btnNewButton);
		
		JLabel lblMazeGame = new JLabel("NBA Playoff Maze");
		lblMazeGame.setFont(new Font("KufiStandardGK", Font.BOLD, 29));
		lblMazeGame.setBounds(98, 90, 314, 35);
		add(lblMazeGame);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(155, 187, 117, 29);
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("CreditsPanel");
			}
		});	
		add(btnCredits);

	}
}

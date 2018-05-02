import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import com.sun.medialib.mlib.Image;

public class TitlePanel extends JPanel {

	private PanelChangeListener listener;
	
	private java.awt.Image backgroundImage;
	
	/**
	 * Create the panel.
	 */
	public TitlePanel(PanelChangeListener listener) {
		setLayout(null);
		this.listener = listener;
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setBounds(155, 152, 117, 29);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("TeamSelect");
				
			}
			
		});
				
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

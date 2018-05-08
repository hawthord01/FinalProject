import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import com.sun.medialib.mlib.Image;
import java.awt.Color;

public class TitlePanel extends JPanel {

	private PanelChangeListener listener;
	
	private java.awt.Image backgroundImage;
	
	/**
	 * Create the panel.
	 */
	public TitlePanel(PanelChangeListener listener) {
		setBackground(Color.WHITE);
		setLayout(null);
		this.listener = listener;
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setBounds(405, 152, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("TeamSelect");
			}
		});	
		add(btnNewButton);
		
		JLabel lblMazeGame = new JLabel("NBA Playoff Maze");
		lblMazeGame.setForeground(Color.BLACK);
		lblMazeGame.setFont(new Font("KufiStandardGK", Font.BOLD, 29));
		lblMazeGame.setBounds(340, 90, 414, 35);
		
		add(lblMazeGame);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(405, 187, 117, 29);
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("CreditsPanel");
			}
		});	
		add(btnCredits);

		try{
			backgroundImage = ImageIO.read(new File("NBAPlayoffs.jpg"));
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 50, 125, this);
}
	
}

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.medialib.mlib.Image;
import java.awt.Color;

public class TeamSelect extends JPanel {
	

	private PanelChangeListener listener;
	private java.awt.Image backgroundImage;
	/**
	 * Create the panel.
	 */
	String[][] teams = {{"Raptors", "Celtics", "76ers", "Cavs", "Pacers", "Heat", "Bucks", "Wizards"},
			{"Rockets", "Warriors", "TrailBlazers", "Thunder", "Jazz", "Pelicans", "Spurs", "Wolves"}};
	
	public TeamSelect(PanelChangeListener listener) {
		setLayout(null); 
		this.listener = listener;
		
		//
		
		List<JButton> buttons = new ArrayList<>();
		JLabel label = new JLabel("Select a team");
		label.setBounds(350, 0, 300, 100);
		label.setForeground(Color.WHITE);
		add(label);
		
		JButton btnGoBack = new JButton("Back to main screen");
		btnGoBack.setBounds(365, 414, 170, 29);
		btnGoBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("TitlePanel");				
			}
			
		}
				);
		add(btnGoBack);
		for(int r = 0; r < teams.length; r++){
			for(int c = 0; c < teams[0].length; c++){
				int x = 250 + 300 * r;
				int y = 120 + 35 * c;
				JButton current = new JButton(teams[r][c]);
				current.setBounds(x, y, 100, 25);
				current.addActionListener(new AbstractAction(){

					@Override
					public void actionPerformed(ActionEvent e) {
						label.setText("You selected the team: " + e.getActionCommand() );	
					}
					
				});
				add(current);
			}
		}

		try{
			backgroundImage = ImageIO.read(new File("TitleBG.jpg"));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, this);
	}
}

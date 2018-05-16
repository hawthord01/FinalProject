import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;

public class FirstLevell extends JPanel {

	private int ulx = 40, uly = 420;
	private int currentDirection = 1;
	private final int SIDE_LENGTH = 40, UP = 0, RIGHT = 1, DOWN = 2, LEFT= 3;
	private int amt = 10;
	private java.awt.Image backgroundImage;
	private PanelChangeListener listener;

	/**
	 * Create the panel.
	 */
	public FirstLevell(PanelChangeListener listener) {
		this.setBackground(Color.WHITE);
		setLayout(null);
		this.listener = listener;
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setForeground(Color.BLACK);
		horizontalBox.setBackground(Color.BLACK);
		horizontalBox.setBounds(67, 158, 25, -60);
		add(horizontalBox);

		//Left
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		getActionMap().put("moveLeft", new MoveAction(-amt, 0));

		//Right
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		getActionMap().put("moveRight", new MoveAction(amt, 0));

		//Up
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
		getActionMap().put("moveUp", new MoveAction(0, -amt));

		//Down
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
		getActionMap().put("moveDown", new MoveAction(0, amt));

	}

	//player area (not the look of player)
	private Rectangle player = new Rectangle(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
	private Rectangle r2 = new Rectangle(100, 0, 40, 420);
	private Rectangle dub = new Rectangle(790, 40, 70, 70);
	//outside border area
	private Rectangle r30 = new Rectangle(0, 0, 900, 40);
	private Rectangle r31 = new Rectangle(0, 0, 40, 460);
	private Rectangle r32 = new Rectangle(0, 460, 900, 40);
	private Rectangle r33 = new Rectangle(860, 0, 40, 460);
	//rest of rectangle
	private Rectangle r3 = new Rectangle(40, 410, 490, 5);
	private Rectangle r4 = new Rectangle(40, 360, 490, 5);
	private Rectangle r5 = new Rectangle(580, 410, 210, 5);
	private Rectangle r6 = new Rectangle(110, 400, 150, 5);
	private Rectangle r7 = new Rectangle(785, 320, 5, 115);
	


	public void paint(Graphics g) {
		super.paint(g);

		//Player
		g.setColor(Color.RED);
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);

		//Outside Borders
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 40);
		g.fillRect(0, 0, 40, 460);
		g.fillRect(0, 460, 900, 40);
		g.fillRect(860, 0, 40, 900);
		//Creating the maze
		g.setColor(Color.BLACK);
		g.fillRect(40, 410, 490, 5);
		g.fillRect(40, 360, 490, 5);
		g.fillRect(580, 410, 210, 5);
		g.fillRect(785, 320, 5, 115);
		g.fillRect(785, 40, 5, 200);
		g.fillRect(525, 290, 5, 70);
		g.fillRect(425, 320, 210, 5);
		//g.fillRect(0, 860, 40, 40);

	}
	//Swept
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageObserver paintingChild = null;
		g.drawImage(backgroundImage, 790, 40, 70, 70, paintingChild);
	}
	private class MoveAction extends AbstractAction {
		private int dx, dy;
		public MoveAction(int dx, int dy){
			this.dx = dx;
			this.dy = dy;
		}
		@Override
		public void actionPerformed(ActionEvent e){
			ulx += dx;
			uly += dy;
			repaint();
			player.setBounds(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
			if(player.intersects(r30) || player.intersects(r31) || player.intersects(r32) || player.intersects(r33) 
					|| player.intersects(r31) || player.intersects(r3) || player.intersects(r4) || player.intersects(r5) 
					|| player.intersects(r6) || player.intersects(r7)){
				ulx -= dx;
				uly -= dy;
				repaint();
				//System.out.println("intersect");
				player.setBounds(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
			}
			if(dub.contains(player)){ 
				listener.changePanel("LevelTwo");
				//System.out.println("finish");
			}
		}
	}
	{try{
		backgroundImage = ImageIO.read(new File("Swept.jpg"));
	}catch (IOException e){
		e.printStackTrace();
	}
	}

}

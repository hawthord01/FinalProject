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

public class LevelTwo extends JPanel {

	private int ulx = 40, uly = 420;
	private int currentDirection = 1;
	private final int SIDE_LENGTH = 40, UP = 0, RIGHT = 1, DOWN = 2, LEFT= 3;
	private int amt = 40;
	private java.awt.Image backgroundImage;
	private PanelChangeListener listener;



	/**
	 * Create the panel.
	 */
	public LevelTwo(PanelChangeListener listener) {
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

	private Rectangle r21 = new Rectangle(100, 0, 40, 420);
	private Rectangle dub = new Rectangle(790, 40, 70, 70);


	//outside border area
	private Rectangle r30 = new Rectangle(0, 0, 900, 20);
	private Rectangle r31 = new Rectangle(0, 0, 40, 460);
	private Rectangle r32 = new Rectangle(0, 460, 900, 40);
	private Rectangle r33 = new Rectangle(860, 0, 40, 460);

	private Rectangle r1 = new Rectangle(0, 380, 160, 40);;
	private Rectangle r2 = new Rectangle(0, 0, 40, 460);
	private Rectangle r3 = new Rectangle(160, 340, 40, 80);
	private Rectangle r4 = new Rectangle(240, 380, 80, 40);
	private Rectangle r5 = new Rectangle(280, 260, 40, 120);
	private Rectangle r6 = new Rectangle(200, 180, 40, 120);
	private Rectangle r7 = new Rectangle(160, 60, 120, 40);
	private Rectangle r8 = new Rectangle(160, 140, 120, 40);
	private Rectangle r9 = new Rectangle(200, 20, 40, 40);
	private Rectangle r10 = new Rectangle(120, 220, 40, 80);
	private Rectangle r11 = new Rectangle(240, 340, 40, 40);
	private Rectangle r12 = new Rectangle(280, 220, 40, 120);
	private Rectangle r13 = new Rectangle(280, 60, 40, 120);
	private Rectangle r14 = new Rectangle(560, 20, 40, 80);
	private Rectangle r15 = new Rectangle(640, 60, 40, 120);
	private Rectangle r16 = new Rectangle(360, 140, 320, 40);
	private Rectangle r17 = new Rectangle(480, 60, 40, 120);
	private Rectangle r18 = new Rectangle(360, 60, 120, 40);
	private Rectangle r19 = new Rectangle(640, 60, 150, 40);
	private Rectangle r20 = new Rectangle(790, 90, 70, 10);

	public void paint(Graphics g) {
		super.paint(g);

		//Player
		g.setColor(Color.RED);
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);

		//Outside Borders
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 20);
		g.fillRect(0, 0, 40, 460);
		g.fillRect(0, 460, 900, 40);
		g.fillRect(860, 0, 40, 460);
		
		//Creating the maze
		g.setColor(Color.BLACK);
		g.fillRect(0, 380, 160, 40);
		g.fillRect(80, 0, 40, 340);
		g.fillRect(160, 340, 40, 80);
		g.fillRect(240, 380, 80, 40);
		g.fillRect(280, 260, 40, 120);
		g.fillRect(200, 180, 40, 120);
		g.fillRect(160, 60, 120, 40);
		g.fillRect(160, 140, 120, 40);
		g.fillRect(200, 20, 40, 40);
		g.fillRect(120, 220, 40, 80);
		g.fillRect(240, 340, 40, 40);
		g.fillRect(280, 220, 40, 120);
		g.fillRect(280, 60, 40, 120);
		g.fillRect(560, 20, 40, 80);
		g.fillRect(640, 60, 40, 120);
		g.fillRect(360, 140, 320, 40);
		g.fillRect(480, 60, 40, 120);
		g.fillRect(360, 60, 120, 40);
		g.fillRect(640, 60, 150, 40);
		g.fillRect(790, 90, 70, 10);
		
	}

	//Swept
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageObserver paintingChild = null;
		g.drawImage(backgroundImage, 790, 20, 70, 70, paintingChild);
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
					|| player.intersects(r1) || player.intersects(r3) || player.intersects(r4) || player.intersects(r5) 
					|| player.intersects(r6) || player.intersects(r7) || player.intersects(r8) || player.intersects(r9)  
					|| player.intersects(r10) || player.intersects(r11) || player.intersects(r12) || player.intersects(r13) 
					|| player.intersects(r14) || player.intersects(r15) || player.intersects(r16) || player.intersects(r17) 
					|| player.intersects(r18) || player.intersects(r19) || player.intersects(r20) || player.intersects(r21) 
					|| player.intersects(r2)){
				ulx -= dx;
				uly -= dy;
				repaint();
				//System.out.println("intersect");
				player.setBounds(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
			}
			if(dub.contains(player)){ 
				listener.changePanel("TitlePanel");
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

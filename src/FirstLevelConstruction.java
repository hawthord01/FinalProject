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

public class FirstLevelConstruction extends JPanel {

	private int ulx = 40, uly = 420;
	private int currentDirection = 1;
	private final int SIDE_LENGTH = 40, UP = 0, RIGHT = 1, DOWN = 2, LEFT= 3;
	private int amt = 5;
	private java.awt.Image backgroundImage;
	private PanelChangeListener listener;



	/**
	 * Create the panel.
	 */
	public FirstLevelConstruction(PanelChangeListener listener) {
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


	private Rectangle r3 = new Rectangle(100, 40, 12, 146);
	private Rectangle r4 = new Rectangle(100, 250, 12, 50);
	private Rectangle r5 = new Rectangle(100, 350, 12, 120);
	private Rectangle r6 = new Rectangle(110, 400, 150, 12);
	private Rectangle r7 = new Rectangle(110, 274, 420, 12);
	private Rectangle r9 = new Rectangle(400, 334, 12, 130);
	private Rectangle r10 = new Rectangle(520, 175, 12, 160);
	private Rectangle r11 = new Rectangle(520, 40, 12, 80);
	private Rectangle r12 = new Rectangle(295, 40, 12, 65);
	private Rectangle r13 = new Rectangle(420, 40, 12, 100);
	private Rectangle r14 = new Rectangle(200, 40, 12, 130);
	private Rectangle r15 = new Rectangle(200, 224, 12, 60);
	private Rectangle r16 = new Rectangle(333, 204, 12, 78);
	private Rectangle r17 = new Rectangle(640, 40, 12, 230);
	private Rectangle r18 = new Rectangle(720, 250, 150, 12);
	private Rectangle r19 = new Rectangle(700, 400, 160, 12);
	private Rectangle r20 = new Rectangle(770, 320, 12, 85);
	private Rectangle r21 = new Rectangle(620, 350, 12, 160);
	private Rectangle r22 = new Rectangle(517, 390, 12, 90);
	private Rectangle r23 = new Rectangle(780, 40, 12, 100);
	private Rectangle r24 = new Rectangle(700, 100, 80, 12);
	//private Rectangle r25 = new Rectangle(0, 460, 900, 40);
	private Rectangle r26 = new Rectangle(860, 0, 40, 900);


	public void paint(Graphics g) {
		super.paint(g);

		//Player
		g.setColor(Color.RED);
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);

		//Outside Borders
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 40);
		g.fillRect(0, 0, 40, 460);
		//Creating the maze
		g.setColor(Color.BLACK);
		g.fillRect(100, 40, 12, 146);
		g.fillRect(100, 250, 12, 50);
		g.fillRect(100, 350, 12, 120);
		g.fillRect(110, 400, 150, 12);
		g.fillRect(110, 274, 420, 12);
		g.fillRect(320, 274, 12, 140);
		g.fillRect(400, 334, 12, 130);
		g.fillRect(520, 175, 12, 160);
		g.fillRect(520, 40, 12, 80);
		g.fillRect(295, 40, 12, 65);
		g.fillRect(420, 40, 12, 100);
		g.fillRect(200, 40, 12, 130);
		g.fillRect(200, 224, 12, 60);
		g.fillRect(333, 204, 12, 78);
		g.fillRect(640, 40, 12, 230);
		g.fillRect(720, 250, 150, 12);
		g.fillRect(700, 400, 160, 12);
		g.fillRect(770, 320, 12, 85);
		g.fillRect(620, 350, 12, 160);
		g.fillRect(517, 390, 12, 90);
		g.fillRect(780, 40, 12, 100);
		g.fillRect(700, 100, 80, 12);
		//g.fillRect(0, 860, 40, 40);
		g.fillRect(0, 460, 900, 40);
		g.fillRect(860, 0, 40, 900);
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
					|| player.intersects(r6) || player.intersects(r7) || player.intersects(r9)  
					|| player.intersects(r10) || player.intersects(r11) || player.intersects(r12) || player.intersects(r13) 
					|| player.intersects(r14) || player.intersects(r15) || player.intersects(r16) || player.intersects(r17) 
					|| player.intersects(r18) || player.intersects(r19) || player.intersects(r20) || player.intersects(r21) 
					|| player.intersects(r22) || player.intersects(r23) || player.intersects(r24)){
				ulx -= dx;
				uly -= dy;
				repaint();
				//System.out.println("intersect");
				player.setBounds(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
			}
			if(dub.contains(player)){ 
				listener.changePanel("FirstLevell");
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

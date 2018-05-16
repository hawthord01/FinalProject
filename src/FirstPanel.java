import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class FirstPanel extends JPanel {

	private PanelChangeListener listener;
	private int ulx = 40, uly = 420;
	private int currentDirection = 1;
	private final int SIDE_LENGTH = 40, UP = 0, RIGHT = 1, DOWN = 2, LEFT= 3;
	private int amt = 10;
	
	//player area (not the look of player)
	private Rectangle player = new Rectangle(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
	
	private Rectangle r2 = new Rectangle(100, 0, 40, 420);
	
	//outside border area
	private Rectangle r3 = new Rectangle(0, 0, 900, 40);
	private Rectangle r4 = new Rectangle(0, 0, 40, 460);
	private Rectangle r5 = new Rectangle(0, 460, 900, 40);
	private Rectangle r6 = new Rectangle(860, 0, 40, 460);
	
	//Winning Area
	private Rectangle win = new Rectangle(860, 40, 40, 40);
	
	/**
	 * Create the panel.
	 */
	public FirstPanel(PanelChangeListener listener) {
		this.listener = listener;
		this.setBackground(Color.WHITE);
		
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
		
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//Player
		g.setColor(Color.RED);
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
		
		//Outside Borders
		g.setColor(Color.BLACK);
		//top
		g.fillRect(0, 0, 900, 40);
		//left
		g.fillRect(0, 0, 40, 460);
		//bottom
		g.fillRect(0, 460, 900, 40);
		//right
		g.fillRect(860, 0, 40, 460);
		
		//random
		g.fillRect(100, 0, 40, 420);
		g.setColor(Color.RED);
		g.fillRect(0, 0, 900, 40);
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
				if(player.intersects(r2) || player.intersects(r3) || player.intersects(r4) || player.intersects(r5) || player.intersects(r6)){
					ulx -= dx;
					uly -= dy;
					repaint();
					System.out.println("intersect");
					player.setBounds(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
				}
				if(player.intersects(win)){
					System.out.println("Win");
				}
		}
		
		
	}

}

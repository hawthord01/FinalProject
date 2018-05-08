import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class FirstPanel extends JPanel {

	private int ulx = 200, uly = 400;
	private int currentDirection = 1;
	private final int SIDE_LENGTH = 40, UP = 0, RIGHT = 1, DOWN = 2, LEFT= 3;
	private int amt = 5;
	/**
	 * Create the panel.
	 */
	public FirstPanel() {
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
		g.fillRect(0, 0, 900, 40);
		g.fillRect(0, 0, 40, 420);
		//g.fillRect(0, 860, 40, 40);
		g.fillRect(0, 460, 900, 40);
		g.fillRect(860, 0, 40, 900);
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
			
		}
		
		
	}

}

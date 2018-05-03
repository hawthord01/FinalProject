import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class FirstPanel extends JPanel {

	private int ulx = 10, uly = 10;
	private int currentDirection = 1;
	private final int SIDE_LENGTH = 50, UP = 0, RIGHT = 1, DOWN = 2, LEFT= 3;
	/**
	 * Create the panel.
	 */
	public FirstPanel() {
		this.setBackground(Color.WHITE);
		
		//Left
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		getActionMap().put("moveLeft", new MoveAction(LEFT));
		
		//Right
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		getActionMap().put("moveRight", new MoveAction(RIGHT));
		
		//Up
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
		getActionMap().put("moveUp", new MoveAction(UP));
		
		//Down
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
		getActionMap().put("moveDown", new MoveAction(DOWN));
		
	}
		
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
	}
	
	private class MoveAction extends AbstractAction {
		
		private int direction;
		
		public MoveAction(int direction){
			this.direction = direction;
		}
		
		@Override
		
		public void actionPerformed(ActionEvent e){
		
			
			currentDirection = direction;
			
		}
		
		
	}

}

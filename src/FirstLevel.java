import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class FirstLevel extends JPanel implements PanelChangeListener {

	private PanelChangeListener listener;
	/**
	 * Create the panel.
	 */
	public FirstLevel(PanelChangeListener listener) {
		setLayout(null);
		this.listener = listener;
		
		JLabel lblToStartMove = new JLabel("To Start Move");
		lblToStartMove.setBounds(302, 16, 107, 16);
		add(lblToStartMove);
		
	}
	public void paint(Graphics g){
		g.drawRect(20, 400, 200, 15);
	}
	public static void main(String[] args){
		
	}
	@Override
	public void changePanel(String panelName) {
		// TODO Auto-generated method stub
		
	}
}

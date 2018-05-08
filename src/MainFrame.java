import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame implements PanelChangeListener{

	private PanelChangeListener listener;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 520);

		contentPane = new FirstPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void changePanel(String panelName) {
		// TODO Auto-generated method stub
		JPanel newPanel = null;
		
		if(panelName.equals("TeamSelect")){
			newPanel = new TeamSelect(this);
		}else if(panelName.equals("CreditsPanel")){
			newPanel = new CreditsPanel(this);
		}else if(panelName.equals("TitlePanel")){
			newPanel = new TitlePanel(this);
		}else if(panelName.equals("FirstPanel")){
				newPanel = new FirstPanel();

		}/*else if(panelName.equals("SomeOtherPanel"){
		}else if(panelName.equals("Some other other panel"{
		}*/
		
		
		
		if(newPanel != null){
			setContentPane(newPanel);
			validate();
		}

	}	
}

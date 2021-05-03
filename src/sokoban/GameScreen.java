package sokoban;

import javax.swing.JPanel;
/**
 * This class holds the control panel and gamepanel which are essential for in game interface.
 * @author SoKool
 *
 */
public class GameScreen extends JPanel{

	GamePanel gamePanel;
	GameControlPanel controlPanel;
	public GameScreen(JPanel contentPane,String mappath)
	{
		setBounds(0,0,1000,600);
		setLayout(null);
		
		gamePanel=new GamePanel(this,mappath);
		controlPanel=new GameControlPanel(gamePanel);
		add(controlPanel);
		add(gamePanel);

	}
}

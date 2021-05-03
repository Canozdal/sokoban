package sokoban;
//imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Level;
/*
 * This class shows the levels and lets you choose one to play.
 * @author SoKool
 */
public class LevelsScreen  extends JPanel implements ActionListener{

	//Properties
	//static because we want to access them from every class
	static ArrayList<Level> levels;
	static int currentLevel=0;
	static JPanel contentPane=GameFrame.contentPane;
	JButton back;
	//Constructor
	public LevelsScreen(JPanel contentPane)
	{
		//Setting  bounds
		setBounds(0,0,900,700);
		setLayout(new GridLayout(4,4));
		//ArrayList to hold the levels
		levels=new ArrayList<Level>();
		loadLevels();
		//Back button
		back=new JButton("BACK");
		back.setBackground(new Color(255,100,0));
		back.addActionListener(this);

		for(Level l:levels)
		{
			l.button.addActionListener(this);
			add(l.button);
		}
		for(int a=levels.size();a<15;a++)
			add(new JLabel());
		
		add(back);

	}
	//Controls whether the level is the last level or not
	public static boolean isLastLevel()
	{
		if(currentLevel==levels.size()-1)
			return true;
		return false;
	}
	//this method paint the background
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon("PNG/bg2.jpg").getImage(),0, 0,getWidth(),getHeight(), this);
	}
	//this method loads the selected level.
	public static void loadLevels()
	{
		File path=new File("Levels/");
		File[] files=path.listFiles();
		for(File f:files)
		{
			levels.add(new Level(f.getPath()));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==back) {
			setVisible(false);
			backToMenu();
		}
		for(int a=0;a<levels.size();a++)
		{
			Level l=levels.get(a);
			if(e.getSource()==l.button)
			{
				currentLevel=a;
				setVisible(false);
				GameScreen g=new GameScreen(contentPane,l.path);
				contentPane.add(g);
				contentPane.repaint();
			}
		}
	
		
	}
	//This method makes the level re-playable
	public static void repeatLevel() {
		// TODO Auto-generated method stub
		GameScreen g=new GameScreen(contentPane,levels.get(currentLevel).path);
		contentPane.add(g);
		contentPane.repaint();
		contentPane.revalidate();
		
	}
	//This method returns the user to the mainScreen
	public static void backToLevelScreen() {
		// TODO Auto-generated method stub
		currentLevel=0;
		contentPane.add(new LevelsScreen(contentPane));
		contentPane.repaint();
		contentPane.revalidate();
		
	}
	public static void backToMenu() {
		currentLevel = 0;
		contentPane.add(new MainScreen(contentPane));
		contentPane.repaint();
		contentPane.revalidate();
	}
	//This method leads to the next level.
	public static void nextLevel() {
		// TODO Auto-generated method stub
		GameScreen g=new GameScreen(contentPane,levels.get(++currentLevel).path);
		contentPane.add(g);
		contentPane.repaint();
		contentPane.revalidate();
	}
}

package sokoban;
//imports
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Models.DropArea;
import Models.Box;
import Models.Wall;

/**
 * This class allows us to create a level. It contains buttons for elements of the game and a blank field to create the game.
 * @author SoKool
 *
 */

public class LevelCreatorControlPanel extends JPanel implements ActionListener {

	//Properties
	
	JButton back;

	
	JButton redBox,blueBox,yellowBox;
	JButton redBubble,blueBubble,yellowBubble;
	JButton wallButton;
	JButton playerButton;
	JButton create;
	JButton rotateButton;
	CreatorPanel creatorPanel;
	LevelCreatorPanel levelCreatorPanel;
	//Constructor
	public LevelCreatorControlPanel(CreatorPanel creatorPanel,LevelCreatorPanel levelCreatorPanel)
	{
		//Setting operations
		this.creatorPanel=creatorPanel;
		this.levelCreatorPanel=levelCreatorPanel;
		setBounds(0,600,700,100);
		GridLayout gl=new GridLayout(2, 5);
		setLayout(gl);
		//initializing buttons
		back=new JButton("BACK");
		back.addActionListener(this);

		redBox=new JButton(new ImageIcon("PNG/Crate_Red.png"));
		blueBox=new JButton(new ImageIcon("PNG/Crate_Blue.png"));
		yellowBox=new JButton(new ImageIcon("PNG/Crate_Yellow.png"));
		redBubble=new JButton(new ImageIcon("PNG/EndPoint_Red.png"));
		blueBubble=new JButton(new ImageIcon("PNG/EndPoint_Blue.png"));
		yellowBubble=new JButton(new ImageIcon("PNG/EndPoint_Yellow.png"));	
		wallButton=new JButton(new ImageIcon("PNG/Wall_Black.png"));

		playerButton=new JButton(new ImageIcon("PNG/Character1.png"));
		create=new JButton("CREATE");
		rotateButton=new JButton(new ImageIcon("img/ROTATE.png"));

		redBox.addActionListener(this);
		blueBox.addActionListener(this);
		yellowBox.addActionListener(this);
		redBubble.addActionListener(this);
		blueBubble.addActionListener(this);
		yellowBubble.addActionListener(this);
		wallButton.addActionListener(this);
		playerButton.addActionListener(this);
		create.addActionListener(this);

		add(redBox);
		add(blueBox);
		add(yellowBox);
		add(wallButton);

		add(playerButton);

		add(redBubble);
		add(blueBubble);
		add(yellowBubble);

		add(create);
		add(back);
		
		
		
	
	}
	@Override
	//matches actions and the buttons
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==back) {
			levelCreatorPanel.setVisible(false);
			LevelsScreen.backToMenu();
		}
		if(e.getSource()==playerButton) {
			creatorPanel.addPlayer();
		}
		if(e.getSource()==create)
		{
			levelCreatorPanel.save();
		}
		if(e.getSource()==redBox) {
			
			creatorPanel.addObject(new Box(3));
		}
		if(e.getSource()==yellowBox) {
			
			creatorPanel.addObject(new Box(2));
		}
		if(e.getSource()==blueBox) {
			
			creatorPanel.addObject(new Box(1));
		}
		if(e.getSource()==blueBubble) {
			
			creatorPanel.addObject(new DropArea(1));
		}
		if(e.getSource()==redBubble) {
			
			creatorPanel.addObject(new DropArea(3));
		}
		if(e.getSource()==yellowBubble) {
			
			creatorPanel.addObject(new DropArea(2));
		}
		if(e.getSource()==wallButton) {
			creatorPanel.addObject(new Wall());

		}
		
		

		
	}
	
	
}

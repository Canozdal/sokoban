package sokoban;
//imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This class is a panel which holds elements of the main screen.
 * @author SoKool
 */
public class MainScreen  extends JPanel implements ActionListener{
	
	//Properties
	JPanel buttonPanel;
	JButton play,create,help,exit;
	JPanel labelPanel;
	JPanel contentPane;
	JLabel label;
	
	//Constructor
	public MainScreen(JPanel contentPane)
	{
		//Setting bounds
		setBounds(0,0,900,700);
		setLayout(null);
		//initializing the content pane
		this.contentPane=contentPane;
		//initializing a label panel
		labelPanel = new JPanel();
		labelPanel.setBounds(100,10,700,95);
		labelPanel.setBackground(new Color(0,0,182,155));
		//initializing a button panel
		buttonPanel=new JPanel();
		buttonPanel.setBounds(525,225, 250, 400);
		
		//initializing the title
		label = new JLabel();
		label.setSize(240,500);
		label.setText("SOKOBAN by SoKool");
		label.setFont(new Font("Serif",Font.BOLD,72));
		label.setForeground(Color.BLACK);
		label.setBackground(Color.CYAN);
		//initializing buttons
		play=new JButton("Play");
		play.setBackground(new Color(100,225,200));
		play.setForeground(Color.BLACK);
		create=new JButton("Create a new game");
		create.setBackground(new Color(155,0,200));
		help=new JButton("Help");
		help.setBackground(new Color(150,150,255));
		help.setForeground(Color.BLACK);
		exit=new JButton("Exit");
		exit.setBackground(Color.ORANGE);
		exit.setForeground(Color.BLACK);
		
		
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(play);
		buttonPanel.add(create);
		buttonPanel.add(help);
		buttonPanel.add(exit);
		
		play.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);
		create.addActionListener(this);
		
		labelPanel.add(label);
		add(buttonPanel);
		add(labelPanel);
		
		requestFocusInWindow();//Calls the focus on the window.

		
	}
	//This method paints the background image.
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon("PNG/bg2.jpg").getImage(),0, 0,getWidth(),getHeight(), this);
	}
	@Override
	//This method associates events and actions to buttons.
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		if(e.getSource()==play)
		{
			setVisible(false);
			LevelsScreen g=new LevelsScreen(contentPane);
			contentPane.add(g);
		}
		if(e.getSource()==create)
		{
			setVisible(false);
			contentPane.add(new LevelCreatorPanel(contentPane));

		}
		if(e.getSource()==help)
		{
			setVisible(false);
			contentPane.add(new HelpPanel(contentPane));

		}
		
	}
}

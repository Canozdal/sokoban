	/**
	 * This class is responsible for the events that happen when youclick "HELP" button in MainScreen
	 *@author SoKool
	 */
	package sokoban;
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
	
	public class HelpPanel  extends JPanel implements ActionListener{
		
		//Properties
		JButton back;
		JLabel helpLabel;
		JLabel helpLabel2;
		JLabel helpLabel3;
		
		//Constructor
		public HelpPanel(JPanel contentPane)
		{	
			//Setting bounds
			setBounds(0,0,900,700);
			setLayout(null);
			
			//Initializing a button
			back=new JButton("BACK");
			back.addActionListener(this);
			back.setBounds(800,600,100,100);
			//Initializing JLabels
			helpLabel=new JLabel();
			helpLabel2 = new JLabel();
			helpLabel3 = new JLabel();
			
			
			helpLabel.setBounds(300,100,400,300);
			helpLabel2.setBounds(300,150,400,300);
			helpLabel3.setBounds(300,200,400,300);
			
			helpLabel.setForeground(Color.BLACK);
			helpLabel2.setForeground(Color.BLACK);
			helpLabel3.setForeground(Color.BLACK);
			
			helpLabel.setText("PUSH BOXES TO THE DROP AREAS WITH SAME COLOR." + "\n" );
			helpLabel2.setText(" YOU W�LL DO YOUR MOVES IN A LIST.");
			helpLabel3.setText("WHEN YOU START THE GAME IT WILL EXECUTE YOUR ORDERS");

			//Adding everything to the panel(Class in this case)
			add(helpLabel);
			add(helpLabel2);
			add(helpLabel3);
			add(back);
			
			
			
		}
		//This method paints the background of the screen
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("PNG/bg2.jpg").getImage(),0, 0,getWidth(),getHeight(), this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==back) {
				setVisible(false);
				LevelsScreen.backToMenu();
			}
			
		}
	
	}

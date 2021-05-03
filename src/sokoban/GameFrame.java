package sokoban;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame {
	
	public static JPanel contentPane;
	
	public  static void main(String[] args)
	{
		JFrame frame=new JFrame("SOKOBAN");
		frame.setBounds(0,0,900,700);
		 contentPane=new JPanel();
		contentPane.setBounds(0, 0, 900, 700);
		contentPane.setLayout(null);
		contentPane.add(new MainScreen(contentPane));
		
		
		frame.setContentPane(contentPane);
		frame.setVisible(true);
		
	}
	

	
	

}

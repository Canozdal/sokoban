package sokoban;
//imports
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Models.DropArea;
import Models.SokobanObject;
import Models.Box;
import sokoban.LevelCreatorControlPanel;
/**
 * This class uses the things done with the control panel  makes it posiible to save the level you created.
 * @author SoKool
 *
 */
public class LevelCreatorPanel extends JPanel  {

		//properties
		CreatorPanel creatorPanel;
		LevelCreatorControlPanel controlPanel;
		
		JPanel contentPane;
		
		String username;
		
		//Constructor
		public LevelCreatorPanel(JPanel contentPane)
		{
			//setting bounds
			setBounds(0,0,750,750);
			setLayout(null);
			//adding panels
			this.contentPane=contentPane;
			creatorPanel=new CreatorPanel();
			controlPanel=new LevelCreatorControlPanel(creatorPanel,this);
			
			add(creatorPanel);
			add(controlPanel);
	
			
			
		}
	
		//This method lets you save the level you create
		public void save() {
	
			username=JOptionPane.showInputDialog(this, "Save");
	
			System.out.println("Save:"+username);
			

	       //ArrayList holding objects
			ArrayList<SokobanObject> objects=creatorPanel.objects;
			
			String name=username+ ".txt";
		    PrintWriter writer;//we need this to write to a file
		    
		    //Handling unsuccessful paths.
			try {
				writer = new PrintWriter("Levels/"+name);
				writer.println(creatorPanel.robot.getX()+" "+creatorPanel.robot.getY());
			
				for(int a=0;a<objects.size();a++)
				{
			
						SokobanObject m=objects.get(a);
						if(m instanceof DropArea) {
						    writer.println(m.getX()+" "+m.getY()+" "+m+" "+((DropArea)m).getColor());
						}
						else if(m instanceof Box){
						    writer.println(m.getX()+" "+m.getY()+" "+m+" "+((Box)m).getColor());
						}
	
						else
						    writer.println(m.getX()+" "+m.getY()+" "+m);
	
				}
			    writer.close();
	
			} catch (IOException e1) {
				
			} 
			
		}
		
		


}

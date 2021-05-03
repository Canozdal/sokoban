package sokoban;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Models.SokobanObject;
import Models.Robot;


/**
 * This class makes it possible to create levels.
 * @author SoKool
 *
 */
public class CreatorPanel extends JPanel implements MouseMotionListener,MouseListener {
	
	
	
	  //properties
    ArrayList<SokobanObject> objects;
    
    Robot robot;
    
    boolean addingObject=false;
    boolean addingPlayer=false;
    boolean playerAdded=false;
    
    SokobanObject tempObject;//candidate object
    
    //constructor
    public CreatorPanel()
    {
            addMouseMotionListener(this);
            addMouseListener(this);
            setBounds(0,0,900,600);
            setLayout(null);
            objects = new ArrayList<SokobanObject>();
    }
    
    /**
     * Takes the given object and change addingObject to true
     * @param ob
     */
    public void addObject(SokobanObject ob)
    {
            tempObject = ob;
            addingObject = true;
    }

    /**
     * Creates robot object and change addingPlayer true;
     */
    public void addPlayer() 
    {
            addingPlayer = true;
            robot = new Robot(0, 0);        
    }
    
    /**
     * Paint method for create level page
     */
    public void paintComponent(Graphics g)
    {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.black);
            
            for(int a = 0; a <= getHeight(); a = a + 50)
            {
                    g.drawLine(0, a, getWidth(), a);
            }
            
            for(int a = 0; a <= getWidth(); a = a + 50)
            {
                    g.drawLine(a, 0, a, getHeight());
            }

            //when addingObject gets true, given object is drawn
            if(addingObject) 
            {
                    tempObject.draw(g);
            }
            
            //when addingPlayer gets true, player is drawn
            if(addingPlayer)
            {
                    robot.draw(g);
            }
            
            //checks if the player is added draw last time
            if(playerAdded)
            {
                    robot.draw(g);
            }

            for(int a = 0; a < objects.size(); a++)
            {
                    objects.get(a).draw(g);
            }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            
    }
    @Override
    public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
            //when the mouse moved, player follow the mouse
            if(addingPlayer)
            {
                    
                    robot.setPosition(((int)e.getX()/50), ((int)e.getY()/50));

                    repaint();
            }
            
            //when the mouse moved, objects follow the mouse
            if(addingObject)
            {
                    
                    tempObject.setPosition(((int)e.getX()/50), ((int)e.getY()/50));
            
                    repaint();
            }
            
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
            //when the mouse clicked, allow mouse to get another object
            if( addingPlayer == true && playerAdded == false)
            {
                    playerAdded=true;
                    addingPlayer=false;
            }
            if( addingObject )
            {
                    addingObject=false;
                    objects.add(tempObject);
            }
            repaint();
            
    }
    @Override
    public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
    }
    @Override
    public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
    }
    @Override
    public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
    }
    @Override
    public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
    }

}

package sokoban;

//All the imports
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Models.DropArea;
import Models.SokobanObject;
import Models.Robot;
import Models.Box;
import Models.Wall;
import java.util.Timer;
import java.util.TimerTask;
/*
 * This class creates the inGame things.
 */
public class GamePanel extends JPanel {

	 public static int[][] map;
     Robot robot;
     static ArrayList<DropArea> dropAreas;
     static ArrayList<Box> boxs;


     int width = 800;
     int height = 600;
     
     Image bg;
     GameScreen screen;
     
     //constructor
     public GamePanel(GameScreen sc, String mapPath) 
     {
             // TODO Auto-generated constructor stub
             screen = sc;
             boxs = new ArrayList<Box>();
             dropAreas = new ArrayList<DropArea>();
             walls = new ArrayList<Wall>();
             setBounds(0,0,700,600);
             setLayout(null);
             bg = new ImageIcon("PNG/bg.png").getImage();
             map = new int[width/50][height/50];
             for(int a = 0; a < map.length; a++)
             {
                     for(int b = 0; b < height/50; b++)
                     {
                             map[a][b] = 0;
                     }
             }
             
             loadMap(mapPath);
     }
     
     public void paintComponent(Graphics g)
     {
             //We paint the background and draw an image
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
             
             //We draw the SokobanObjects
             robot.draw(g);
             
             for(int a = 0; a<walls.size(); a++)
             {
                     walls.get(a).draw(g);
             }
             for(int a = 0; a<dropAreas.size(); a++)
             {
                     dropAreas.get(a).draw(g);
             }
             for(int a = 0; a < boxs.size(); a++)
             {
            	 boxs.get(a).draw(g);
             }
             
             
     }
     
     /**
      * This method returns the tile at the given position
      * @param x
      * @param y
      * @return
      */
     public static Box getTileAt(int x,int y)
     {
             for(int a = 0; a < boxs.size(); a++)
             {
                     SokobanObject o = boxs.get(a);
                     if(o.getX() == x && o.getY() == y)
                     {
                             return (Box)o;
                     }
             }
             return null;
             
     }
     /**
      * This method loads the map at the given route.
      * @param mapPath
      */
     public void loadMap(String mapPath)
     {
             File mapp = new File(mapPath);
             Scanner fileScan;
             Scanner strScan;
             
             //We want to catch the errors if the path is useless.
             try {
                     //We have two scanners here. 1 reads each line and the other reads each element in the lines and uses it.
                     fileScan = new Scanner(mapp);
                     String line = fileScan.nextLine();
                     strScan = new Scanner(line);
                     int x = Integer.parseInt(strScan.next());
                     int y = Integer.parseInt(strScan.next());
                     
                     robot=new Robot(x,y);
                     map[x][y] = 1000;
                     
                     while(fileScan.hasNextLine())
                     {
                             line = fileScan.nextLine();
                             System.out.println(line);
                             strScan=new Scanner(line);
                             x = Integer.parseInt(strScan.next());
                             y = Integer.parseInt(strScan.next());
                             String type = strScan.next();
                             
                             if(type.equals("Wall")) 
                             {
                                     walls.add(new Wall(x,y));
                                     map[x][y]=2000;

                             }
                             else if(type.equals("EndPoint")) 
                             {
                                     int color = Integer.parseInt(strScan.next());
                                     dropAreas.add(new DropArea(x,y,color));
                                     map[x][y]=color;
                             }
                             else if(type.equals("Box")) 
                             {
                                     int color = Integer.parseInt(strScan.next());
                                     boxs.add(new Box(x,y,color));
                                     map[x][y] = -color;
                             }
                     }
             } catch (FileNotFoundException e) {
                     
             }
             
     }

     /**
      * Checks if the game is finished or not.
      * @return
      */
     public boolean checkGameFinished() 
     {
             boolean finished = true;
             
             for(Box t:boxs)
             {
                     if(t.isDone() == false)
                             finished = false;
             }
             return finished;
             
     }
     public void start(DefaultListModel model) 
     {
             // TODO Auto-generated method stub
             
              Timer myTimer = new Timer();
      TimerTask gorev = new TimerTask() 
      {
             @Override
             public void run() 
             {
                   if(model.isEmpty() == false)
                   {
                                String move = model.get(0).toString();
                                model.remove(0);
                                switch( move ) 
                                { 
                      case "UP":
                        // handle up 
                          robot.move(3);
                          
                          break;
                      case "DOWN":
                          // handle down 
                          robot.move(4);

                          break;
                      case "LEFT":
                          robot.move(1);

                          // handle left
                          break;
                      case "RIGHT" :
                          robot.move(2);

                          // handle right
                          break;
                   }           
                                
                   }
                   else
                   {
                       myTimer.cancel();
                       if(!checkGameFinished()) 
                       {
                        JOptionPane.showMessageDialog(null, "YOU LOST. REPEAT THE LEVEL"); 
                        setVisible(false);
                        screen.setVisible(false);
                        LevelsScreen.repeatLevel();
                       }
                   }  
              
                   repaint();
                   
                   if(checkGameFinished()) 
                   {
                        
                        if(LevelsScreen.isLastLevel())
                        {
                        JOptionPane.showMessageDialog(null, "YOU HAVE FINISHED THE GAME."); 
                        screen.setVisible(false);
                           myTimer.cancel();
                        LevelsScreen.backToMenu();


                        }
                        else 
                        {
                                
                           myTimer.cancel();

                        JOptionPane.showMessageDialog(null, "YOU WON THE LEVEL..GOING NEXT");   
                        screen.setVisible(false);
                        LevelsScreen.nextLevel();
                        
                        }
                        setVisible(false);
                        
                        }
             }
      };

      myTimer.schedule(gorev,0,500);

     }
}

	


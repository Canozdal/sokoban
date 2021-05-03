/*,
 * 
 */
package Models;

import javax.swing.ImageIcon;

import sokoban.GamePanel;

public class Box extends SokobanObject implements Moveable{

	private boolean done;
	public Box(int color)
	{
		super(0,0);
		setDone(false);
		this.setColor(color);
		if(color==2)
		{
			image=new ImageIcon("PNG/Crate_Yellow.png").getImage();
		}
		else if(color==1)
		{
			image=new ImageIcon("PNG/Crate_Blue.png").getImage();
		}
		else {
			image=new ImageIcon("PNG/Crate_Red.png").getImage();

		}
	}
	private int color;//0 red 1 blue 2 yellow
	public Box(int x,int y,int color) {
		super(x,y);
		setDone(false);

		this.setColor(color);
		if(color==2)
		{
			image=new ImageIcon("PNG/Crate_Yellow.png").getImage();
		}
		else if(color==1)
		{
			image=new ImageIcon("PNG/Crate_Blue.png").getImage();
		}
		else {
			image=new ImageIcon("PNG/Crate_Red.png").getImage();

		}
		
	}
	
	public void setDone()
	{
		image=new ImageIcon("PNG/CrateDark_Yellow.png").getImage();
		done=true;
	}
	public String toString()
	{
		return "Box";
	}

	public boolean move(int direction) {
		if(isDone())
			return false;
		int[][] map=GamePanel.map;
		//1 left,2right 3 up 4 down
		int targetX=-1,targetY=-1;
		if(direction==1)
		{
			targetX=getX()-1;
			targetY=getY();
		}
		if(direction==2)
		{
			targetX=getX()+1;
			targetY=getY();
		}
		if(direction==3)
		{
			targetX=getX();
			targetY=getY()-1;
		}
		if(direction==4)
		{
			targetX=getX();
			targetY=getY()+1;
		}
		if(targetX<0||targetY<0||targetX>900/50||targetY>600/50)
		{
			return false;
		}
		if(map[targetX][targetY]==0)
		{
			map[x][y]=0;
			map[targetX][targetY]=-getColor();
			setPosition(targetX,targetY);
			return true;
		}
		else if(map[targetX][targetY]==getColor()) {
			
			setPosition(targetX,targetY);
			setDone();
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}

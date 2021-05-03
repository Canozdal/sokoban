package Models;

import java.awt.Image;

import javax.swing.ImageIcon;

import sokoban.GamePanel;

public class Robot extends SokobanObject implements Moveable {
	Image left,right,up,down;
	public Robot(int i, int j) {
		// TODO Auto-generated constructor stub
		super(i,j);
		left=new ImageIcon("PNG/Character1.png").getImage();
		right=new ImageIcon("PNG/Character2.png").getImage();
		up=new ImageIcon("PNG/Character7.png").getImage();
		down=new ImageIcon("PNG/Character4.png").getImage();
		
		image=down;
	}
	
	public String toString()
	{
		return "Player";
	}

	@Override
	public boolean move(int direction) {
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
			System.out.println("empty");
			map[x][y]=0;
			map[targetX][targetY]=1000;
			setPosition(targetX,targetY);
			return true;
		}
		else if(map[targetX][targetY]==2000) {
			return false;
		}
		else if(map[targetX][targetY]==3000) {
			map[x][y]=0;
			map[targetX][targetY]=1000;
			setPosition(targetX,targetY);
			return true;		}
		else if((map[targetX][targetY]<0))
		{
			boolean isPushed=GamePanel.getTileAt(targetX, targetY).move(direction);
			System.out.println(isPushed);
			if(isPushed)
			{
				map[x][y]=0;
				map[targetX][targetY]=1000;
				setPosition(targetX,targetY);
				return true;
			}
			else
				return false;
		}
		return false;
		
	}
}

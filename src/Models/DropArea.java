package Models;

import javax.swing.ImageIcon;

public class DropArea extends SokobanObject{

	boolean done;
	public DropArea(int color)
	{
		super(0,0);
		done=false;
		this.setColor(color);
		if(color==2)
		{
			image=new ImageIcon("PNG/EndPoint_Yellow.png").getImage();
		}
		else if(color==1)
		{
			image=new ImageIcon("PNG/EndPoint_Blue.png").getImage();
		}
		else {
			image=new ImageIcon("PNG/EndPoint_Red.png").getImage();

		}
	}
	private int color;//0 red 1 blue 2 yellow
	public DropArea(int x,int y,int color) {
		super(x,y);
		done=false;
		this.setColor(color);
		if(color==2)
		{
			image=new ImageIcon("PNG/EndPoint_Yellow.png").getImage();
		}
		else if(color==1)
		{
			image=new ImageIcon("PNG/EndPoint_Blue.png").getImage();
		}
		else {
			image=new ImageIcon("PNG/EndPoint_Red.png").getImage();

		}
		
	}
	public void setDone()
	{
		image=new ImageIcon("PNG/CrateDark_Yellow.png").getImage();
		done=true;
	}
	public String toString()
	{
		return "EndPoint";
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}

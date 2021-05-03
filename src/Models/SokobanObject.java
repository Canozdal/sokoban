package Models;

import java.awt.Graphics;
import java.awt.Image;

public  class SokobanObject {
	
	
	Image image;
	int x;
	int y;
	
	public SokobanObject() {
		
	}
	public SokobanObject(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void setPosition(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	
	
	public void draw(Graphics g) {
		g.drawImage(image, x*50, y*50, 50, 50, null);
	}
	

}

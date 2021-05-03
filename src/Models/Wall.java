package Models;

import javax.swing.ImageIcon;

public class Wall extends SokobanObject {

	public Wall() {
		image=new ImageIcon("PNG/Wall_Black.png").getImage();

	}
	public Wall(int x,int y) {
		super(x,y);
		image=new ImageIcon("PNG/Wall_Black.png").getImage();
	}
	public String toString()
	{
		return "Wall";
	}
}

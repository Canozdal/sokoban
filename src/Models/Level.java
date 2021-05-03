package Models;

import javax.swing.JButton;

public class Level {
	
	String name;
	public String path;
	public JButton button;
	public Level(String path)
	{
		this.path=path;
		this.name=path.substring(path.lastIndexOf('/')+1, path.lastIndexOf('.'));
		button=new JButton(name);
	}

}

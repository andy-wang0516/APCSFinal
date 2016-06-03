package Final;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;


public class Mushroom extends MovingThing {

	private int speed;
	private Image image;

	public Mushroom()
	{
		this(0,0,0);
	}

	public Mushroom(int x, int y)
	{
		this(x,y,0);
	}

	public Mushroom(int x, int y,int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/Final/ghost.png"));
		}
		catch(Exception e)
		{
		
		}
	}

	//does not move
	
	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub
		s=0;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics window) {
		// TODO Auto-generated method stub
		window.drawImage(image,getX(),getY(),60,60,null);
	}
	
	
	public String toString()
	{
		return super.toString() + getSpeed();
	}
	
	public void collide(Mushroom a)
	{
	

		
		
		
	}
	

	

}

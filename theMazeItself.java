package Final;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pixLab.Pixel;

import java.awt.image.BufferedImage;

public class theMazeItself extends MovingThing {
	
	private Image image;
	private boolean[][] mazwall = new boolean[800][600];;
	private BufferedImage bufferedImage;

	public theMazeItself() {
		this(0, 0);
	}

	public theMazeItself(int x, int y) {
		
		super(x, y);

		try {
			image = ImageIO.read(new File("src/Final/maze.png"));
		} catch (Exception e) {
			// feel free to do something here
		}
	}
	
	 public void createSimplePicture(int width, int height)
	 {
	   bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	 }
	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), 800, 600, null);
	}

	public boolean GetPixelColor(int x, int y) throws IOException {

		File file = new File("src/Final/maze.png");
		BufferedImage image = ImageIO.read(file);
		// Getting pixel color by position x and y
		int clr = image.getRGB(x, y);
		int red = (clr & 0x00ff0000) >> 16;
		int green = (clr & 0x0000ff00) >> 8;
		int blue = clr & 0x000000ff;
		if (red > 105 && green > 105 && blue > 105) {
			System.out.println(red + "" + green + "" + blue);
			return false;
		}
		System.out.println(red + "" + green + "" + blue);
		return true;
	}
public void createMazwall(){
	for (int row = 0; row < 800; row++) {
		for (int col = 0; col < 600; col++) {
			try {
				mazwall[row][col] =  GetPixelColor(row, col);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
			}
		}
	}
}
public boolean getMW(int x, int y){
	return mazwall[x][y];
}
	public String toString() {
		return super.toString();
	}

	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

}

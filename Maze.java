package Final;

import javax.swing.JFrame;
import java.awt.Component;

public class Maze extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Maze()
	{
		super("MAZE");
		setSize(WIDTH,HEIGHT);

		background theGame = new background();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		Maze run = new Maze();
	}

}

package Final;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


import unit17.Alien;
import unit17.Ammo;


public class background extends Canvas implements KeyListener, Runnable, MouseListener
{	
	private byte[][] w = {
			{ 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 },
			{ 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0,0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
			{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
			{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },//
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1 },
		};
	//scale 50 by 25
		private tes Mwalls = new tes(w);
		private boolean t; 
		private boolean a; 
		byte[][] walls = Mwalls.stretch(25, 50);
		private Person ship;
		private theMazeItself m;
		private Mushroom m1, m2,m3,m4,m5,m6;
		private boolean alive1, alive2, alive3,alive4,alive5,alive6;
		private boolean left, right, top, bot;
		private boolean fired = false;
		private int lr = 0;
		private ArrayList<Mushroom> aliens;
		
		

		private boolean[] keys;
		private BufferedImage back;

		public background()
		{
			setBackground(Color.BLACK);
			t = true;
			a = true;
			keys = new boolean[5];

			//
			
			aliens = new ArrayList<Mushroom>();
			aliens.add(new Mushroom(740, 0, 2));
			aliens.add(new Mushroom(100, 245, 2));
			aliens.add(new Mushroom(600, 245, 2));
			aliens.add(new Mushroom(650, 245, 2));
			aliens.add(new Mushroom(400, 125, 2));
			aliens.add(new Mushroom(250, 80, 2));
			aliens.add(new Mushroom(425, 425, 2));
			aliens.add(new Mushroom(475, 425, 2));
			aliens.add(new Mushroom(525, 425, 2));
			aliens.add(new Mushroom(525, 320, 2));
			aliens.add(new Mushroom(575, 320, 2));
	
			m = new theMazeItself(0,0);

			ship = new Person(40,0,5);
			
			this.addKeyListener(this);
			this.addMouseListener(this);
			new Thread(this).start();

			setVisible(true);
		}

	   public void update(Graphics window)
	   {
		   paint(window);
	   }

		public void paint( Graphics window )
		{
			if(t){
				window.setColor(Color.BLUE);
				window.fillRect(0,0,800,600);
				
				window.setColor(Color.YELLOW);
				Font welcome = new Font("Welcome to Pac-Man's Perlious Journey", Font.BOLD, 36);
				window.setFont(welcome);
				String welcomeMessage = "Welcome to Pac-Man's Perlious Journey!";
				window.drawString(welcomeMessage, 50, 100);
				String welcomeMessag = "By Andy Wang";
				window.drawString(welcomeMessag, 50, 150);
				Font welcom = new Font("Welcome to Pac-Man's Perlious Journey", Font.BOLD, 23);
				window.setFont(welcom);
				String welcomeMessa = "Objective: Make it to the right bottom shelter ";
				window.drawString(welcomeMessa, 50, 350);
				String welcomeMess = "without getting killed by the spooky ghosts";
				window.drawString(welcomeMess, 50, 400);
			}

			if(!a){
				window.setColor(Color.BLUE);
				window.fillRect(0,0,800,600);
				
				window.setColor(Color.YELLOW);
				Font welcome = new Font("Congrats, You Made It!", Font.BOLD, 30);
				window.setFont(welcome);
				String welcomeMessage = "Congrats, You Made It!";
				window.drawString(welcomeMessage, 50, 100);
			}
			else if(!t){
				Graphics2D twoDGraph = (Graphics2D)window;
				if(back==null)
				   back = (BufferedImage)(createImage(getWidth(),getHeight()));
				Graphics graphToBack = back.createGraphics();
				//m.draw(graphToBack);
				graphToBack.setColor(Color.BLACK);
				graphToBack.fillRect(0,0,800,600);
				graphToBack.setColor(Color.BLUE);
				for (int i = 0; i < walls.length; i++) {
					for (int j = 0; j < walls[0].length; j++) {
						if (walls[i][j] == 1){ 
						graphToBack.fillRect(i, j, 1, 1);
					
						}
					}
				
				}
				int xP = ship.getX();
				int yP = ship.getY();
					left = false;
					right = false;
					top = false;
					bot = false;
					if (xP > 0 && yP > 0) {

				if (walls[xP][yP+15] == 1) {
					left = true;
				}
				if (walls[xP+30][yP+15] == 1) {
					right = true;
				}
				if (walls[xP+15][yP] == 1) {
					top = true;
				}
				if (walls[xP+15][yP+30] == 1) {
					bot = true;
				}

					}
			//  
					if(ship.getX()>700 && ship.getY()>450){
						a = false;
					}
					for (int q = 0; q < aliens.size(); q++) {
						aliens.get(q).draw(graphToBack);
					
	
					}
					
					
						
				
					try {
						for (int q = 0; q < aliens.size(); q++) {
								if (ship.getX() > aliens.get(q).getX()
										&& ship.getX() + 4 < aliens.get(q).getX() + 80
										&& ship.getY() > aliens.get(q).getY()
										&& ship.getY() + 4 < aliens.get(q).getY() + 80) {
									ship = new Person(0,0,10);
								}
							}
						
					} catch (Exception e) {
					}
					
					if (ship.getX() > -5 && left == false)
						if(keys[0] == true)
						{
							ship.move("LEFT");
						}
					if (ship.getX() < 736 && right == false )
						if(keys[1] == true)
						{
							ship.move("RIGHT");
						}
					if (ship.getY() > -15 && top == false)
						if(keys[2] == true)
						{
							ship.move("UP");
						}
					if (ship.getY() < 490 && bot == false )
						if(keys[3] == true)
						{
							ship.move("DOWN");
						}
						ship.draw(graphToBack);
						twoDGraph.drawImage(back, null, 0, 0);
			}
			
			
	

		}


		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				keys[0] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				keys[1] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				keys[2] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				keys[3] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keys[4] = true;
			}
			repaint();
		}

		public void keyReleased(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				keys[0] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				keys[1] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				keys[2] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				keys[3] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keys[4] = false;
			}
			repaint();
		}

		public void keyTyped(KeyEvent e)
		{

		}

	   public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		t = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	


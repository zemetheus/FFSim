/** 
     * Cogan Shimizu
     * CS-1180L-90
     * Kurtis Glendenning
     * Michael Ondrasek
     * 
     * PURPOSE:
     * This class is the workhorse of the game.
     * 
     * Herein are updated the positions, speeds, existence, removal,
     * drawing, and gamestates of all objects, score, and the game itself.
     * 
     * KeyListeners handle player movement, game exit and replay.
     * 
     * 0: start menu
     * 1: game action!
     * 2: victory screen!
     * 3: loss screen D:
     * 99: newGame catcher/flagger
     */

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePanel extends JPanel
{
	private final int w, h;
	private int gameState;
	
	private Menu menu = new Menu();
	
	private ArrayList<Employee> employees = new ArrayList<>();
	
	Grid grid;
	
	public GamePanel(final int w, final int h)
	{
		super();
		
		this.w = w;
		this.h = h;		
		
		this.grid = new Grid(w,h);
		
		employees.add(new Employee(1,2,grid));
		employees.add(new Employee(7,3,grid));
		
		
	}
	/**
	 * move method handles the position, speed, existence, and removal
	 * of all objects on the screen during gamestate 1.
	 * 
	 * That is, objects flagged for removal are removed, positions  and speed
	 * are updated according to the boundaries.
	 * 
	 * move method returns gameState 1 is !allEnemiesDestroyed, 2 if allEnemiesDestroyed
	 * or 3 is player.getIsDestroyed() == true;
	 * @param gamePanel
	 * @return
	 */
	public int move(GamePanel gamePanel)
	  {
		
		for(Employee e : employees)
		{
			e.move(grid);
		}
		
		repaint();
		
		return gameState;
	  }
	/**
	 * startMenu method extends the KeyAdapter functionality so that
	 * enter will start the game, and left and right, during gameStates 
	 * 2 and 3 will move the highlight box.
	 * 
	 * @param gamePanel
	 * @return
	 */
	public int startMenu(final GamePanel gamePanel)
	{
		
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_ENTER:
					{
						if(gamePanel.getGameState() == 0)
							gamePanel.setGameState(1);
						/*if(gamePanel.getGameState() == 2 ||
						   gamePanel.getGameState() == 3)
						{
							switch(highlight)
							{
								case 0:
								{
									gamePanel.setGameState(99);
									break;
								}
								case 1:
								{
									System.exit(0);
									break;
								}
								default:
								{
									System.out.println("Highlight Enter Error");
									System.exit(1);
								}
							}
						}*/
						break;
					}
					case KeyEvent.VK_ESCAPE:
					{
						System.exit(0);
					}
					default:
					{
						break;
					}
				}
			}
		}
		);
		
		repaint();
		
		return gameState;
		
	}
	/**
	 * lossScreen method is a dummy method for handling the loss screen during gameState 3
	 * @param gamePanel
	 * @return
	 */
	public int lossScreen(GamePanel gamePanel)
	{
		repaint();
		
		return gameState;
	}
	/**
	 * paintComponent method updates the drawings of all the objects on the screen
	 * with respect to the gameState. Menuscreens are handled by the Scorebar class.
	 */
	public void paintComponent(Graphics g)
  	{
		super.paintComponent(g);
  		
		//set color black
        g.setColor(Color.black);
        //paint background
        g.fillRect(0, 0, getWidth(), getHeight());
        
       
        
        switch(gameState)
        {
	        case 0:
	        {
	        	menu.drawStartMenu(g);
	        	break;
	        }
	        case 1:
	        {
	        	//paint employees
	            for(Employee e : employees)
	            {
	            	e.draw(g);
	            }
		        break;
	        }
	        case 99:
	        {
	        	//restart game code
	        	break;
	        }
	        default:
	        {
	        	System.out.println("gameState paint error");
	        	System.exit(1);
	        }
        }
    }
	/**
	 * setGameState method sets gameState (see Game documentation for details)
	 * @param gameState
	 */
	public void setGameState(int gameState)
	{
		this.gameState = gameState;
	}
	/**
	 * getGameState method returns the gameState
	 * @return
	 */
	public int getGameState()
	{
		return gameState;
	}
}

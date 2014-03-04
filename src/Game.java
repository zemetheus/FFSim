/** 
     * Cogan Shimizu
     * 
     * 0: start menu
     * 1: game action!
     * 99: newGame catcher/flagger
     */

import java.awt.*;

import javax.swing.*;

public class Game extends JFrame
{
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 700;
	
	private GamePanel gamePanel;
	private boolean startNewGame = false; //needs to be false to start FIRST new game
	private int gameState = 0;
	/**
     * Creates a new instance of Game
     */
    public Game()
    {
    	super("FF Simulator");
    	
    	//frame name
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        
	    gamePanel = new GamePanel(WINDOW_WIDTH,WINDOW_HEIGHT);
	    add(gamePanel);
	    center(this);
	    setVisible(true);
	    gamePanel.setFocusable(true);
		
	   	System.out.println("New Game Starting");
	  	//reset startNewGame
	   	startNewGame = false;
	    gamePanel.setGameState(0);
	   	
	    //main game loop, close to halt
	    while(!startNewGame)
	    {
	    	Pauser.pause(10);
	    	switch(gameState)
	    	{
		   		case 0:
		   		{
		   			gameState = gamePanel.startMenu(gamePanel);
		   			break;
		   		}
		   		case 1:
		   		{
		   			gameState = gamePanel.move(gamePanel);
		   			break;
		   		}
	    		case 99:
	    		{
	    			startNewGame = true;
	    			setVisible(false);
	    			break;
	    		}
	    		default:
	    		{
	    			System.out.println(gameState);
	    			System.out.println("gameState errorasdf");
	    			System.exit(1);
	    		}
	    	}
    	}
   	}
	
    /**
     * getStartNewGame returns boolean startNewGame
     * @return
     */
    public boolean getStartNewGame()
    {
    	return startNewGame;
    }
    
    /**
     * Helper routine to center a frame on the screen (causes problems if
     * frame is bigger than the screen)
     */
    public static void center(JFrame frame)
    {
    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	Point center = ge.getCenterPoint();

    	int w = frame.getWidth();
    	int h = frame.getHeight();

    	int x = center.x - w / 2, y = center.y - h / 2;
    	frame.setBounds(x, y, w, h);
    	frame.validate();
    }
}

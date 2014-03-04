import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Menu extends JPanel
{
	/**
	 * default constructor
	 */
	public Menu()
	{
		
	}
	
	public void drawStartMenu(Graphics g)
	{
		g.setColor(Color.white);
    	
    	centerString("Welcome to",g,0);
    	centerString("Fast Food Simulator",g,1);
    	
    	g.drawLine(301,125,396,125);
    	
    	centerString("ENTER - start the game",g,3);
    	centerString("ESCAPE - exit the game",g,4);
    	
	}
	
	/**
	 * centerString prints a msg centered on a "line."
	 * line 0 starts at 100px y plane. one line is 20px.
	 * line = 100 + 20n
	 * @param msg
	 * @param g
	 * @param nLine
	 */
	public void centerString(String msg, Graphics g, int nLine)
	{
		int center, length;
		FontMetrics fm = g.getFontMetrics();
		
		length = fm.stringWidth(msg);
    	center = (700 - length) / 2;
    	g.drawString(msg, center, 100+(nLine * 20));
	}
}

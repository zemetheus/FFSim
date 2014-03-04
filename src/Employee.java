import java.awt.*;

public class Employee
{
	Coordinate<Integer> position,
						gridPosition;
	public Employee()
	{
		
	}
	
	public Employee(int posX, int posY,Grid grid)
	{
		this.gridPosition = new Coordinate<>(posX,posY);
		this.position = grid.getCellCenter(posX, posY);
	}
	
	public void move(Grid grid)
	{
		int direction = (int)(Math.random() * 10);
		
		switch(direction)
		{
		case 1:
		{
			gridPosition.setRow(gridPosition.getRow()+1);
			break;
		}
		default:
		{
			break;
		}
		}
		
		position = grid.getCellCenter(gridPosition);
	}
	
	public void draw(Graphics g)
	{
		int x = position.getRow(),
			y = position.getCol();
		
		g.setColor(Color.RED);
		g.fillOval(x, y, 10, 10);
	}
	
	public void setPosX(int posX)
	{
		position.setRow(posX);
	}
	
	public int getPosX()
	{
		return position.getRow();
	}
	
	public void setPosY(int posY)
	{
		position.setCol(posY);
	}
	
	public int getPosY()
	{
		return position.getCol();
	}
}

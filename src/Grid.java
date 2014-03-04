public class Grid
{
	private int rows, cols,
				cellHeight, cellWidth;
	boolean occupiedArray[][];
	
	public Grid()
	{
		this.rows = 10;
		this.cols = 10;
		
		occupiedArray = new boolean[rows][cols];
	}
	public Grid(int height, int width)
	{
		this.rows = 10;
		this.cols = 10;
		
		this.cellHeight = height / rows;
		this.cellWidth = width / cols;
		
		occupiedArray = new boolean[rows][cols];
	}
	
	public Coordinate<Integer> getCellCenter(int row, int col)
	{
		int x, y;
		
		x = (cellWidth * col)+cellWidth/2;
		
		y = (cellHeight * row)-cellHeight/2;
		
		return new Coordinate<>(x,y);
		
	}
	public Coordinate<Integer> getCellCenter(Coordinate<Integer> coord)
	{
		int x, y,
			row = coord.getRow(),
			col = coord.getCol();
		
		x = (cellWidth * col)+cellWidth/2;
		
		y = (cellHeight * row)-cellHeight/2;
		
		return new Coordinate<>(x,y);
		
	}
	public void setOccupied(int row, int col, boolean occupied)
	{
		occupiedArray[row][col] = occupied;
	}
	public boolean getOccupied(int row, int col)
	{
		return occupiedArray[row][col];
	}
}

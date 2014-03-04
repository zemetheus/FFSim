
public class Coordinate<T> {

	T r,c;
	
	public Coordinate(T r, T c)
	{
		//r is row or X
		//c is col or Y
		
		this.r = r;
		this.c = c;
	}
	
	public T getRow()
	{
		return r;
	}
	
	public T getCol()
	{
		return c;
	}
	
	public void setRow(T r)
	{
		this.r = r;
	}
	
	public void setCol(T c)
	{
		this.c = c;
	}
	
	public String toString()
	{
		return "["+r+","+c+"]";
	}
	
	public void print()
	{
		System.out.println("["+r+","+c+"]");
	}
}

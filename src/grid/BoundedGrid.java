package grid;

import block.Location;
import java.util.ArrayList;
import java.util.List;

public class BoundedGrid<E> extends RectTriGrid<E>
{
    protected Object[][] occupantArray; // the array storing the grid elements

    public BoundedGrid(int rows, int cols)
    {
        if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        occupantArray = new Object[rows][cols];
    }

    public int getNumRows()
    {
        return occupantArray.length;
    }

    public int getNumCols()
    {
        return occupantArray[0].length;
    }

    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    public List<Location> getOccupiedLocations()
    {
        List<Location> theLocations = new ArrayList<Location>();
        for (int r = 0; r < getNumRows(); r++)
        {
            for (int c = 0; c < getNumCols(); c++)
            {
                Location loc = new Location(r, c);
                if (get(loc) != null)
                    theLocations.add(loc);
            }
        }
        return theLocations;
    }


    @SuppressWarnings("unchecked")
	public E get(Location loc)
    {
        notValidException(loc);
        return (E) occupantArray[loc.getRow()][loc.getCol()];
    }

    public E put(Location loc, E obj)
    {
        notValidException(loc);
        if (obj == null)
            throw new NullPointerException("obj == null");
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        notValidException(loc);
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }

    private void notValidException(Location loc) {
    	if (!isValid(loc))
    		throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
    }

}

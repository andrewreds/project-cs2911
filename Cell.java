// Cell Class
// Authours:	Taylor Bertie (tcbe803),
//		Andrew Reimers (andrewr),
//		Esther Mosad (emos958)

/**
    This is a Cell class that is the different cells that the maze is
    constructed out of.
*/
public class Cell implements GridCell { 
    /**
        Constructs a new cell with two child walls to the south
        and east.
    */
    public Cell() {
        south = new Wall(false,this);
        east = new Wall(false,this);
        north = null;
        west = null;
    }
    /**
        Gets a wall given a direction.
        @param dir The direction of the wall.
        @return Returns the Wall in the direction dir.
    */
    public Wall getWall(Direction dir) {
        if (dir == Direction.NORTH) {
            return north;
        } else if (dir == Direction.EAST) {
            return east;
        } else if (dir == Direction.SOUTH) {
            return south;
        } else if (dir == Direction.WEST) {
            return west;
        }
        return null; // Error case
    }
    /**
        Gets a Cell Neighbour given a direction.
        @param dir The direction of the cell.
        @return Returns the Cell in the direction dir.
        @throws CannotFindCellException if there is no cell in the
                direction dir.
    */
    public Cell getNeighbour(Direction dir)
           throws CannotFindCellException {
       return getWall(dir).getOtherCell(this);
    }
    /**
        Gets the passable state of the wall given a direction
        @param dir The direction of the wall
        @return Returns true if the wall is passable
    */
    public boolean getWallPassable(Direction dir) {
        Wall wall = getWall(dir);
        try {
            wall.getOtherCell(this);
        }
        catch (CannotFindCellException e) {
            return false; // Force non passable wall if there is
                          // no cell to travel to
        }
        return wall.getPassable();
    }
    /**
        Sets a wall given a direction as the parent of the wall.
        @param dir The direction of the wall to set.
        @param aWall The wall to set to.
    */
    public void setWallAsParent(Direction dir, Wall aWall) {
        if (setWall(dir,aWall)) {
            aWall.setParent(this);
        }
    }
    /**
        Sets a wall given a direction as the child of the wall.
        @param dir The direction of the wall to set.
        @param aWall The wall to set to.
    */
    public void setWallAsChild(Direction dir, Wall aWall) {
        if (setWall(dir,aWall)) {
            aWall.setChild(this);
        }
    }
    /**
        Sets a wall passable state given a direction.
        @param dir The direction of the wall
        @param aPassable The passable state to set.
    */
    public void setWallPassable(Direction dir,boolean aPassable) {
        getWall(dir).setPassable(aPassable);
    }

    //Privates
    private boolean setWall(Direction dir, Wall aWall) {
        if (dir == Direction.NORTH) {
            north = aWall;
        } else if (dir == Direction.EAST) {
            east = aWall;
        } else if (dir == Direction.SOUTH) {
            south = aWall;
        } else if (dir == Direction.WEST) {
            west = aWall;
        } else {
            return false;
        }
        return true; // If any of the four cases execute
    }
    private Wall north;
    private Wall east;
    private Wall south;
    private Wall west; 
}

// Wall Class
// Authours:	Taylor Bertie (tcbe803),
//		Andrew Reimers (andrewr),
//		Esther Mosad (emos958)

/**
    This call provides a wall object which the state of can modified
*/   
public class Wall {
    /**
        This function constructs a new wall.
        @param aPassable The state of the wall. If the wall is
               passible, i.e. invisible, this parameter is true.
        @param aParent The cell which this wall is depdendent on
    */
    public Wall(boolean aPassable, Cell aParent) {
        passable = aPassable;
        parent = aParent;
    }
    /**
        This function returns the passable state of the wall.
        @return Returns true of the wall is passable.
    */
    public boolean getPassable() {
        return passable; 
    }
    /**
        This function, given either the parent or the child Cell will
        return the child or parent Cell respectively.
        @param aCell Takes in the parent or child Cell.
        @return The other Cell linked to this wall.
        @throws CannotFindCellException if there is no Cell to return
                (for an edge) or if the inputed Cell is not either the
                parent or child.
    */
    public Cell getOtherCell(Cell aCell)
           throws CannotFindCellException {
        if (parent == aCell && child != null) {
            return child;
        } else if (child == aCell && parent != null) {
            return parent;
        } else {
            throw new CannotFindCellException();
        }
    }
    /**
        This function allows you to change the state of the wall.
        @param aPassable The state of the wall. If the wall is
               passible, i.e. invisible, this parameter is true. 
    */
    public void setPassable(boolean aPassable) {
        passable = aPassable;
    }
    /**
        This function allows you to set the parent of the wall.
        @param aParent The cell which this wall is dependent on. This
               will be the cell to the NORTH or WEST of the wall.
   */
   public void setParent(Cell aParent) {
        parent = aParent;
   }
   /**
        This function allows you to set the child of the wall.
        @param aChild The cell which depends on this wall. This will
               be the cell to the SOUTH or EAST of the wall.
    */
    public void setChild(Cell aChild) {
        child = aChild;
    }

    // Privates
    private boolean passable;
    private Cell parent;
    private Cell child;
}

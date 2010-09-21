// GirdCell Interface
// Authours:	Taylor Bertie (tcbe803),
//		Andrew Reimers (andrewr),
//		Esther Mosad (emos958)

/**
    This interface is for the GridCell, which is an abstract
    reference to a Cell.
*/
public interface GridCell {
    /**
        Gets a wall given a direction.
        @param dir The direction of the wall.
        @return Returns the Wall in the direction dir.
    */
    public Wall getWall(Direction dir);
    /**
        Gets a Cell Neighbour given a direction.
        @param dir The direction of the cell.
        @return Returns the Cell in the direction dir.
        @throws CannotFindCellException if there is no cell in the
                direction dir.
    */
    public Cell getNeighbour(Direction dir)
           throws CannotFindCellException;
}

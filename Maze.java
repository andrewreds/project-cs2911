// Maze Class
// Authours:	Taylor Bertie (tcbe803),
//		Andrew Reimers (andrewr),
//		Esther Mosad (emos958)

/**
    The is the Maze class which contains a 2D array of cells for use
    in the maze game.
*/
public class Maze {
    /**
        This is the Maze constructor. It creates a new maze of given
        width and height.
        @param width Width of Maze.
        @param height Height of Maze.
    */
    public Maze (int width, int height) {
        cells = new Cell[width][height];
        int i,j;
        for (i = 0; i < height;i++) {
            for (j = 0; j < width;j++) {
                cells[i][j] = new Cell();
                if (i == 0) {
                    cells[i][j].setWallAsChild(Direction.NORTH,
                                             new Wall(false,null));
                } else {
                    cells[i][j].setWallAsChild(Direction.NORTH,
                           cells[i-1][j].getWall(Direction.SOUTH));
                }
                if (j == 0) {
                    cells[i][j].setWallAsChild(Direction.EAST,
                                            new Wall(false,null));
                } else {
                    cells[i][j].setWallAsChild(Direction.EAST,
                           cells[i][j-1].getWall(Direction.WEST));
                }
            }
        }
    }
    /**
        This is the Maze constructor. It creates a new maze given a
        difficulty.
        @param diff Diffculty of maze.
    */
    public Maze (Difficulty diff) {
        this(diff.getWidth(),diff.getHeight());
    }
    // Privates
    private Cell cells[][];
    private Cell start;
    private Cell finish;
}

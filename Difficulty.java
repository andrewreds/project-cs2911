/**
    This is the Difficulty E Number.
    It contains the various difficulities.
*/
public enum Difficulty {
    /** For the lazy **/LAZY(5,5),
    /** A walk in the park */ EASY(40,30),
    /** The normal difficulty */ NORMAL(80,60),
    /** This gets a little tricky */ HARD(160,120),
    /** Tread here if you dare */ INSANE(320,240),
    /** Oh god no! */ BRUTAL(640,480);


    /**
        This constucts a new a difficulty object
        @param width Width of maze
        @param height Height of maze
    */
    private Difficulty(int width, int height) {
        this.width = width;
        this.height = height;
    }
    /**
        Gets the width of the maze
        @return Width of maze
    */
    public int getWidth() {
        return this.width;
    }
    /**
        Gets the height of the maze
        @return Height of maze
    */
    public int getHeight() {
        return this.height;
    }

    // Privates
    private int width;
    private int height;
}

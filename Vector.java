public class Vector {
    public Vector(int x_co, int y_co) {
        x = x_co;
        y = x_yo;
    }
    public boolean equals(Vector other) {
        return this.x == other.x && this.y == other.y;
    }
    public Vector getRelative(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }
    public Vector getRelative(int x_co, int y_co) {
        return new Vector (this.x + x_co, this.y + y_co);
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    // Privates
    private int x;
    private int y;
}

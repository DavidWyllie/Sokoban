package sokoban;

/**
 *
 * @author 16005310
 */
public class Coordinate {

    int x; 
    int y;
    
    public Coordinate(int newX, int newY) {
        
        x = newX;
        y = newY;
    }
    
    public void setX(int newX) {
        
        x = newX;
    }

    public void setY(int newY) {
        
        y = newY;
    }

    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }

}


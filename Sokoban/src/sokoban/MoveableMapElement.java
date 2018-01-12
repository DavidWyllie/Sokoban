package sokoban;

/**
 *
 * @author 16005310
 */
public class MoveableMapElement extends MapElement {
    
    Coordinate currentLocation;
    Coordinate startingLocation;
    
    public MoveableMapElement(int newX, int newY) {
        
        currentLocation     =   new Coordinate(newX,newY);
        startingLocation    =   new Coordinate(newX, newY);   
    }
    
    public void setCurrentLocation(int newX, int newY) {
        
       currentLocation.setX(newX);
       currentLocation.setY(newY);
       setBounds(newX * 32, newY * 32, 32, 32);
       
    }
    
    
    public void setCurrentLocation(Coordinate c)    {
        
        currentLocation.setX(c.getX());
        currentLocation.setY(c.getY());
        setBounds(c.getX() * 32, c.getY() * 32, 32, 32);
        
    }
    
    
    public Coordinate getCurrentLocation() {
        
        return currentLocation;
        
    }
    
    public int getXPosition() {
        
        return currentLocation.getX();
        
    }
    public int getYPosition() {
        
        return currentLocation.getY();
        
    }
    
    public void setStartingLocation(int newX, int newY){
        
        startingLocation.setX(newX);
        startingLocation.setY(newY);
        setBounds(newX * 32, newY * 32, 32, 32);
        
    }
    
    public void setStartingLocation(Coordinate c)   {
        
        startingLocation.setX(c.getX());
        startingLocation.setY(c.getY());
        setBounds(c.getX() * 32, c.getY() * 32, 32, 32);
        
    }

    public Coordinate getStartingLocation() {
        
        return startingLocation;
    }
    
    public int getStartingXLocation()    {
        
        return startingLocation.getX();
        
    }
    
    public int getStartingYLocation()  {
        
        return startingLocation.getY();
        
    }
    
    public void resetLocation() {
        
        currentLocation.setX(startingLocation.getX());
        
        currentLocation.setY(startingLocation.getY());
        
        setBounds(startingLocation.getX() * 32, startingLocation.getY() * 32, 32, 32);
        
    }
}

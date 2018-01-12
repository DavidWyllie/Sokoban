package sokoban;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 16005310
 */
public class Level extends JComponent {

    
    
    private MapElement map[][];
    public WarehouseKeeper warehouseKeeper;
    private Crate crates[];
    private int moveNumber;
    private int levelNumber;
    private int mapWidth;
    private int mapHeight;
    private int crateNumber;
    private JLabel  gameWinLabel;
    public  JLabel  moveNumberLabel;
    
    
    
    public Level(int levelNumber)   {
        
        try {
            drawLevel(levelNumber);
        }  catch (FileNotFoundException ex) {
            System.out.println("Level not found message:" + ex.getMessage());
        }
        
        
    }
    
    
    
   
    
    public void drawLevel (int levelNumber) throws FileNotFoundException {
       
        
        String levelFile = "resources/SokobanMaps/level" + levelNumber + ".txt";
        File levelMap = new File(levelFile);
        Scanner scanLevel = new Scanner(levelMap);
        
        moveNumber = 0;
        
        mapWidth    =   scanLevel.nextInt();
        mapHeight   =   scanLevel.nextInt();
        crateNumber =   scanLevel.nextInt();
        
        scanLevel.nextLine();
        
        map =   new MapElement[mapHeight][mapWidth];
        crates  =   new Crate [crateNumber];
        
        this.setBounds(5, 5, 1000, 500);
        this.setVisible(true);
        
        int row         =   0;
        int newCrates   =   0;
        
        while (row < mapHeight)   {
            String currentLine = scanLevel.nextLine();
            char character[]   = currentLine.toCharArray();
            
            int coloum = 0;
            
            while (coloum < character.length) {
                if (character[coloum] == ' ') {
                    map[row][coloum] = new Floor();
                }else if (character[coloum] == 'X'){
                    map[row][coloum] = new Wall();
                }else if (character[coloum] == '.') {
                    map[row][coloum] = new Diamond();
                }else if (character[coloum] == '*') {
                    map[row][coloum] = new Floor();
                    crates[newCrates] = new Crate (coloum, row);
                    this.add(crates[newCrates]);
                    crates[newCrates].setStartingLocation(coloum, row);
                    newCrates++;
                }else if (character[coloum] == '@') {
                    map[row][coloum] = new Floor();
                    warehouseKeeper = new WarehouseKeeper(coloum, row);
                    this.add(warehouseKeeper);
                    warehouseKeeper.setStartingLocation(coloum, row);
                    
                }
                coloum++;
            }
            row++;
        }
        
        row = 0;
        while (row < mapHeight) {
            int coloum = 0;
            while (coloum < mapWidth) {
                this.add(map[row][coloum]);
                map[row][coloum].setBounds(coloum * 32, row * 32, 32, 32);
                coloum++;
            }
            row++;
        }
             
    }
    
    public void resetLevel()    {
        
        
        int i = 0;
        while (i < crates.length) {
            crates[i].crateOnFloor();
            crates[i].resetLocation();
            i++;
        }
        warehouseKeeper.resetLocation();
        moveNumber = 0;
        SokobanGame.moveNumberLabel.setText("Move Number: " + moveNumber);
    }
    

    
    public boolean moveElement(WarehouseKeeper whk, String moveDirection) {          //Checks if the warehousekeeper is moveable
        Coordinate newLocation;
        boolean isMovable = true;
       
        
        if (moveDirection.equals("up"))  {
            newLocation = new Coordinate(whk.getXPosition(), whk.getYPosition() - 1);
        } else if (moveDirection.equals("down")) {
            newLocation = new Coordinate(whk.getXPosition(), whk.getYPosition() + 1);
        }else if (moveDirection.equals("right")) {
            newLocation = new Coordinate(whk.getXPosition() + 1, whk.getYPosition());
        }else {
            newLocation = new Coordinate(whk.getXPosition() - 1, whk.getYPosition());
        }
      
      
        if (map[newLocation.getX()][newLocation.getY()].getNameOfElement().equals("Wall")) {
            
            isMovable = false;  
        } else{
            for(int i = 0; i < crateNumber; i++)   {
                if (crates[i].getXPosition() == newLocation.getX() && crates[i].getYPosition() == newLocation.getY()); {
                
                isMovable = moveElement(i, moveDirection);

            }
        }
       
        }
        
        if (isMovable == true) {
            warehouseKeeper.setCurrentLocation(newLocation);
            moveNumber++;
            SokobanGame.moveNumberLabel.setText("Move Number " + moveNumber);
        }
        
        return isMovable;
         
    }
    
    private boolean moveElement(int c, String moveDirection)  {
        Coordinate newLocation;
        boolean isMoveable = true;
        
         
        
        if (moveDirection.equals("up"))  {
            newLocation = new Coordinate(crates[c].getXPosition(), crates[c].getYPosition() - 1);
        } else if (moveDirection.equals("down")) {
            newLocation = new Coordinate(crates[c].getXPosition(), crates[c].getYPosition() + 1);
        }else if (moveDirection.equals("right")) {
           newLocation = new Coordinate(crates[c].getXPosition() + 1, crates[c].getYPosition()); 
        }else {
            newLocation = new Coordinate(crates[c].getXPosition() - 1, crates[c].getYPosition());
        }
        
        if (map[newLocation.getY()][newLocation.getX()].getNameOfElement().equals("Wall")) {
            isMoveable = false;
        } else {
            
            for (int i = 0; i < crateNumber; i++) {
                if (crates[i].getXPosition() == newLocation.getX() && crates[i].getYPosition() == newLocation.getY())   {
                    isMoveable = false;
                }
            }
        }
    if (isMoveable == true) {
        
        if (map[newLocation.getY()][newLocation.getX()].getNameOfElement().equals("Diamond")){
            crates[c].crateInPlace();
        }
        crates[c].setCurrentLocation(newLocation);
        hasWon();
    }
    return isMoveable;
       
    }
    
    private boolean hasWon() {
        
        boolean win = true;
        int i = 0;
        while (i < crates.length) {
            
            if (map[crates[i].getYPosition()][crates[i].getXPosition()].getNameOfElement().equals("Diamond")){
                win = false;
            }
            i++;
        }
        if (win ==true) {
            levelNumber++;
            
            if (levelNumber > 5){
                removeAll();
                repaint();
                gameWinLabel = new JLabel("Win!");
                add(gameWinLabel);
                gameWinLabel.setFont(new Font("Calibri", Font.BOLD, 300));
                gameWinLabel.setForeground (Color.BLUE);
                gameWinLabel.setBounds(0, 0, 970, 320);
                gameWinLabel.setVisible(true);
                
                 
            }   else {
                    SokobanGame.nextLevelButton.setEnabled(true);
                    SokobanGame.nextLevelButton.setVisible(true);
            }
        }
        return win;
    }
}

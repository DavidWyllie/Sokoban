package sokoban;

import javax.swing.ImageIcon;

/**
 * //Map elements Crate
 * @author 16005310
 */
public class Crate extends MoveableMapElement   {   //Map elements Crate
    
    public Crate(int newX, int newY) {
        
        super(newX, newY);
        nameOfElement   =   "Crate";
        elementInText   =   "*";
        fileOfImage     =   "resources/SokobanImages/Crate.png";
        this.setIcon(new ImageIcon(fileOfImage));
        
    }
    
    
    public void crateInPlace() {
        
        fileOfImage =   "resources/SokobanImages/CrateInPlace.png";
        this.setIcon(new ImageIcon(fileOfImage));
        
    }


    public void crateOnFloor()  {
        
        fileOfImage =   "resources/SokobanImages/Crate.png";
        this.setIcon(new ImageIcon(fileOfImage));
    }
}

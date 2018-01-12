package sokoban;

import javax.swing.ImageIcon;

/**
 *
 * @author 16005310
 */
public class Floor extends MapElement {
    
    
    public Floor()  {
        
        nameOfElement   =   "Floor";
        elementInText   =   " ";
        fileOfImage     =   "resources/SokobanImages/Floor.png";
        this.setIcon(new ImageIcon(fileOfImage));
    }
    
}

package sokoban;

import javax.swing.ImageIcon;

/**
 *
 * @author 16005310
 */
public class Diamond extends MapElement {
    
    public Diamond()    {
        
        nameOfElement   =   "Diamond";
        elementInText   =   ".";
        fileOfImage     =   "resources/SokobanImages/Diamond.png";
        this.setIcon(new ImageIcon(fileOfImage)); 
    }
    
}

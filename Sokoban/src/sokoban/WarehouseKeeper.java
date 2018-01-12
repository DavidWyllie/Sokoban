package sokoban;

import javax.swing.ImageIcon;

/**
 * WarehouseKeeper - player character
 * @author 16005310
 */
public class WarehouseKeeper extends MoveableMapElement {
    
    public WarehouseKeeper (int newX, int newY)  {
        
        super(newX, newY);
        nameOfElement   =   "warehouseKeeper";
        elementInText   =   "@";
        fileOfImage     =   "resources/SokobanImages/WarehouseKeeper.png";
        this.setIcon(new ImageIcon(fileOfImage));
        
    }
    
}

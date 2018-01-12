package sokoban;

import javax.swing.ImageIcon;

/**
 *
 * @author 16005310
 */
public class Wall extends MapElement {
    
   public Wall() {
       
       nameOfElement    = "Wall";
       elementInText    = "X";
       fileOfImage      = "resources/SokobanImages/Wall.png";
       this.setIcon(new ImageIcon(fileOfImage));
   }
}

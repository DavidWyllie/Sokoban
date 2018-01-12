package sokoban;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;



/**
 *
 * @author 16005310
 */
public class SokobanGame extends JComponent implements ActionListener{
    
    private final JFrame gameWindow;
    private JButton gameStartButton;
    private JLabel  titleLabel;
    public int levelNumber;
    public int moveNumber;
    public Level startingLevel;

    public JButton charaterUpButton;
    public JButton charaterDownButton;
    public JButton charaterLeftButton;
    public JButton charaterRightButton;
    public JButton levelRestartButton;
    public static JButton nextLevelButton;
    public static JLabel  moveNumberLabel;
    
    

    
    
    public SokobanGame() {
        
        gameWindow  =   new JFrame();
        gameWindow.setSize(1000, 500);
        gameWindow.getContentPane().setBackground(Color.GRAY);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartScreen();
        
    }
    
    private void StartScreen()  {
        
        titleLabel  =   new JLabel("Sokoban");
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 150));
        titleLabel.setForeground(Color.BLUE);
        add(titleLabel);
        titleLabel.setBounds(200, 10, 1000, 300);
        titleLabel.setVisible(true);
        
        gameStartButton =   new JButton("Start Game");
        gameStartButton.setForeground(Color.BLUE);
        add(gameStartButton);
        gameStartButton.setBounds(350, 250, 300, 100);
        gameStartButton.setVisible(true);
        gameStartButton.addActionListener(this);
        
        
    
        
        gameWindow.add(this);
        this.setBounds(0, 0, 1000, 500);
        this.setVisible(true);
        
    }
    
        public void loadLevel(int levelNumber) {
        
        startingLevel = new Level(levelNumber);
        gameWindow.add(startingLevel);
        startingLevel.repaint();
        createUserInterface();
        
        }
        
      public void createUserInterface()   {
        
        moveNumberLabel  =   new JLabel("Number of Moves" + moveNumber);
        add(moveNumberLabel);
        moveNumberLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        moveNumberLabel.setForeground(Color.BLUE);        
        moveNumberLabel.setBounds(600, 250, 120, 40);
        moveNumberLabel.setVisible(true);
        
       levelRestartButton  =   new JButton("Restart Level");
        add(levelRestartButton);
        levelRestartButton.setFont(new Font("Calibri", Font.BOLD, 18));
        levelRestartButton.setForeground(Color.BLUE);        
        levelRestartButton.setBounds(800, 50, 150, 40);
        levelRestartButton.setVisible(true);
        levelRestartButton.addActionListener(this);
 
        
        charaterUpButton  =   new JButton("Up");
        add(charaterUpButton);
        charaterUpButton.setFont(new Font("Calibri", Font.BOLD, 18));
        charaterUpButton.setForeground(Color.BLUE);        
        charaterUpButton.setBounds(480, 300, 120, 40);
        charaterUpButton.setVisible(true);
        charaterUpButton.addActionListener(this);
        
        charaterDownButton  =   new JButton("Down");
        add(charaterDownButton);
        charaterDownButton.setFont(new Font("Calibri", Font.BOLD, 18));
        charaterDownButton.setForeground(Color.BLUE);        
        charaterDownButton.setBounds(480, 350, 120, 40);
        charaterDownButton.setVisible(true);
        charaterDownButton.addActionListener(this);
        
        
        charaterLeftButton  =   new JButton("Left");
        add(charaterLeftButton);
        charaterLeftButton.setFont(new Font("Calibri", Font.BOLD, 18));
        charaterLeftButton.setForeground(Color.BLUE);        
        charaterLeftButton.setBounds(360, 325, 120, 40);
        charaterLeftButton.setVisible(true);
        charaterLeftButton.addActionListener(this);
        
        
        charaterRightButton  =   new JButton("Right");
        add(charaterRightButton);
        charaterRightButton.setFont(new Font("Calibri", Font.BOLD, 18));
        charaterRightButton.setForeground(Color.BLUE);        
        charaterRightButton.setBounds(600, 325, 120, 40);
        charaterRightButton.setVisible(true);
        charaterRightButton.addActionListener(this);
        
        nextLevelButton  =   new JButton("Next Level");
        add(nextLevelButton);
        nextLevelButton.setFont(new Font("Calibri", Font.BOLD, 18));
        nextLevelButton.setForeground(Color.BLUE);        
        nextLevelButton.setBounds(800, 100, 150, 40);
        nextLevelButton.setVisible(true);
       nextLevelButton.addActionListener(this);
        nextLevelButton.setEnabled(false);                                      
        nextLevelButton.setVisible(false);
    
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.gameStartButton) {
            removeAll();
            repaint();
            loadLevel(0);
        
        } else if (e.getSource().equals(charaterUpButton)) {
                    startingLevel.moveElement(startingLevel.warehouseKeeper, "up");
        
        } else if (e.getSource().equals(charaterDownButton)) {
                    startingLevel.moveElement(startingLevel.warehouseKeeper, "down");
        
        } else if (e.getSource().equals(charaterLeftButton)) {
                    startingLevel.moveElement(startingLevel.warehouseKeeper, "left");
        
        } else if (e.getSource().equals(charaterRightButton)) {
                    startingLevel.moveElement(startingLevel.warehouseKeeper, "right");
        }else if (e.getSource().equals(levelRestartButton)) {
            startingLevel.resetLevel();
        }else if (e.getSource().equals(nextLevelButton)) {
            nextLevelButton.setEnabled(false);
            nextLevelButton.setVisible(false);
            levelNumber++;
            moveNumber = 0;
            moveNumberLabel.setText("Move Number " + moveNumber);
            startingLevel.removeAll();
            startingLevel.repaint();
            try { 
                startingLevel.drawLevel(levelNumber);
                
            }catch (FileNotFoundException ex) {
                System.out.println("Level not found message:" + ex.getMessage());
            }
        }
        
        
        
    }
    
}

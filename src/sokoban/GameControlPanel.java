package sokoban;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * This class controls the actions you can perform in the game.
 * @author SoKool
 *
 */

public class GameControlPanel extends JPanel implements ActionListener {

	
	
	   //properties
    DefaultListModel model;
    JList list;
    JButton up;
    JButton down; 
    JButton left;
    JButton right;
    JButton start;
    JButton back;

    GamePanel gamePanel;
    
    //constructor
    public GameControlPanel(GamePanel gamePanel)
    {
            this.gamePanel = gamePanel;
            setBounds(700,0,200,600);
            GridLayout gl = new GridLayout(2, 1);
            setLayout(gl);
            
            model = new DefaultListModel();
        list = new JList(model);
        JScrollPane pane = new JScrollPane(list);
        
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        start = new JButton("START");
        start.setBackground(Color.red);
            up = new JButton("UP");
            up.setBackground(Color.GREEN);
            down = new JButton("DOWN");
            down.setBackground(Color.GREEN);
            left = new JButton("LEFT");
            left.setBackground(Color.GREEN);
            right = new JButton("RIGHT");
            right.setBackground(Color.GREEN);
            back = new JButton("BACK");

            up.addActionListener(this);
            down.addActionListener(this);
            left.addActionListener(this);
            right.addActionListener(this);
            start.addActionListener(this);
            back.addActionListener(this);
            
            JPanel buttons = new JPanel(new GridLayout(3,2));
            buttons.add(up);
            buttons.add(down);
            buttons.add(left);
            buttons.add(right);
            buttons.add(start);
            buttons.add(back);
            add(pane);
            add(buttons);
    
    }
    /**
     * Paints the panel
     */
    public void paintComponent(Graphics g)
    {
            g.setColor(Color.blue);
            g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            //adding commands to the list when user clicks button
            if(e.getSource() == up) 
            {
                    model.addElement("UP");
            }
            if(e.getSource() == left) 
            {
                    model.addElement("LEFT");

            }
            if(e.getSource() == down) 
            {
                    model.addElement("DOWN");

            }
            if(e.getSource() == right) 
            {
                    model.addElement("RIGHT");

            }
            if(e.getSource() == back) 
            {
                    LevelsScreen.backToLevelScreen();
            }
            if(e.getSource() == start)
            {
                    start.setEnabled(false);
                    gamePanel.start(model);
            }
            repaint();
    }
}

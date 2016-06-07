
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fjy8029
 */
public class GamePanel extends JPanel implements ActionListener{
    private JPanel main;
    private final int WIDTH = 720;
    private final int HEIGHT = 1280;
    private final int delay = 30;
    private int time;
    public Timer t1;
    public Timer t2;
    public Timer t3;
    DrawingBlock draw;
    private List<Block> blockList;
    private int scoreNum;
    private JPanel playerInfo;
    private JLabel playerInfoLabel;
    
    public GamePanel(){
        super();
        setLayout(new BorderLayout());
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
        }
        time = 0;
        blockList = new ArrayList<Block>();
        blockList = Collections.synchronizedList(blockList);
        t1 = new Timer(delay,this);
        t2 = new Timer(1800,this);
        t3 = new Timer(1000,this);
        draw = new DrawingBlock();
        draw.setBackground(Color.WHITE);
        draw.setPreferredSize(new Dimension(720,1280));
        addBlock();
        playerInfo = new JPanel();
        scoreNum = 0;
        playerInfo.setPreferredSize(new Dimension(720,50));
        playerInfo.setBackground(Color.WHITE);
        playerInfoLabel = new JLabel("Score: " + this.scoreNum + "                            Time: " + this.time + "  Seconds");
        playerInfo.add(playerInfoLabel,BorderLayout.BEFORE_FIRST_LINE);
        draw.add(playerInfo);
        add(draw);
        t1.start();
        t2.start();
        t3.start();
    }
    
    public void addBlock(){
        Block block = new Block(WIDTH, HEIGHT);
        Thread thread = new Thread(block);
        blockList.add(block);
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == t1){
            repaint();
        }
        if(e.getSource() == t2){
            addBlock();
            this.scoreNum += 5;
            playerInfo.remove(playerInfoLabel);
            validate();
            playerInfoLabel = new JLabel("Score: " + this.scoreNum + "                            Time: " + this.time+ "  Seconds");
            playerInfo.add(playerInfoLabel,BorderLayout.BEFORE_FIRST_LINE);
            validate();
        }
        if(e.getSource() == t3){
            this.time += 1;
            playerInfo.remove(playerInfoLabel);
            validate();
            playerInfoLabel = new JLabel("Score: " + this.scoreNum + "                            Time: " + this.time+ "  Seconds");
            playerInfo.add(playerInfoLabel,BorderLayout.BEFORE_FIRST_LINE);
            validate();
        }
    }
    
    private class DrawingBlock extends JPanel
    {
        public DrawingBlock()
        {
            setPreferredSize(new Dimension(WIDTH,HEIGHT));
            setBackground(Color.WHITE);
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for(Block block:blockList){
                block.draw(g);
            }
        }
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Block Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GamePanel());
        frame.pack();                                      //pack frame
        frame.setVisible(true);
    }
    
}

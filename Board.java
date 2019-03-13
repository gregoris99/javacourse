import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board
{
    JFrame frame = new JFrame("Java Coursework");
    JPanel panel= new JPanel();
    GridLayout layout = new GridLayout(8,8,0,0);

    public Board()
    {
        
        frame.setSize(500,500);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setContentPane(panel);
        frame.setVisible(true);

        JButton[] blocks={};
        blocks= new JButton[64];
        int n=0;

        for (int i=0; i<8; i++)
         for (int j=0; j<8; j++)
         {
             Square s = new Square(i,j);
             blocks[n]= s.getBlock();
             n++;
         }

         panel.setLayout(layout);
         
         for (n=0; n<64; n++)         
          panel.add(blocks[n]);          

         frame.setVisible(true);


    }


    public static void main(String[] args)
    {
        Board b = new Board();
    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board {
    JFrame frame = new JFrame("Java Coursework");
    JPanel panel = new JPanel();
    GridLayout layout = new GridLayout(8, 8, 0, 0);
    ImageIcon red = new ImageIcon("red.png");
    ImageIcon white = new ImageIcon("white.png");
    

    public Board()
    {
        
        frame.setSize(800,800);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setContentPane(panel);
        frame.setVisible(true);
        panel.setLayout(layout); 

        Square[] squares = new Square[65]; //array of instances created
        
        JButton[][] blocks= new JButton[65][2]; //2D ARRAY OF JBUTTONS        
        
        int n=1;      


        for (int i=0; i<8; i++)
         for (int j=0; j<8; j++)
         {
            if (((((i+1)%2==0) && ((j+1)%2==0)) || (!((i+1)%2==0) && !((j+1)%2==0))))
            {            
             squares[n] = new Square(n,"blacks","none");
             blocks[n][0]=squares[n].getBlock();
             blocks[n][1]=squares[n].getBlock();
             panel.add(blocks[n][1]);
             n++;             
            }                        
          else  
            if((n>24) && (n<41)  )         
            {    
             squares[n] = new Square(n,"whites","none");
             blocks[n][0]= squares[n].getBlock();
             blocks[n][1]= squares[n].getBlock();
             panel.add(blocks[n][1]);
             n++;
            }
          else
            if (n<=24)
            {
             squares[n] = new Square(n,"whites","red");
             blocks[n][0]= squares[n].getBlock();               
             blocks[n][1]= new JButton(red);
             panel.add(blocks[n][1]);
             n++;
            } 
          else   
            if (n>=41)
            {
              squares[n] = new Square(n,"whites","white");
              blocks[n][0]= squares[n].getBlock();               
              blocks[n][1]= new JButton(white);
              panel.add(blocks[n][1]);
              n++;
            }                   
            
         }         

        frame.setVisible(true);

    }


    public static void main(String[] args)
    {
        Board b = new Board();
    }

}
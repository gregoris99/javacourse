import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{
    JFrame frame = new JFrame("Java Coursework");
    JPanel panel = new JPanel();
    GridLayout layout = new GridLayout(8, 8, 0, 0);
    ImageIcon red = new ImageIcon("red.png");
    ImageIcon white = new ImageIcon("white.png");
    ImageIcon valid = new ImageIcon("selected.png");

     //ARRAY OF INSTANCES CREATED

     Square[] squares = new Square[65]; 

     //2D ARRAY OF BUTTONS

     JButton[][] blocks= new JButton[65][2];   

    public void setSelected(JButton x)
    {
      x.setIcon(valid);
    }
    
    //CONSTRUCTOR
    //ADDING ACTIONLISTENERS TO ALL WHITE BUTTONS    

    public Board()
    {
        
        frame.setSize(800,800);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setContentPane(panel);
        frame.setVisible(true);
        panel.setLayout(layout); 
       
        int n=1;      

        //CREATING 2D BUTTONS AND ADDING THEM TO BOARD

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
             blocks[n][0].addActionListener(this);
             blocks[n][1]= squares[n].getBlock();
             blocks[n][1].addActionListener(this);
             panel.add(blocks[n][1]);
             n++;
            }
          else
            if (n<=24)
            {
             squares[n] = new Square(n,"whites","red");
             blocks[n][0]= squares[n].getBlock();
             blocks[n][0].addActionListener(this);       
             blocks[n][1]= new JButton(red);
             blocks[n][1].addActionListener(this);
             panel.add(blocks[n][1]);
             n++;
            } 
          else   
            if (n>=41)
            {
              squares[n] = new Square(n,"whites","white");
              blocks[n][0]= squares[n].getBlock(); 
              blocks[n][0].addActionListener(this);             
              blocks[n][1]= new JButton(white);
              blocks[n][1].addActionListener(this);
              panel.add(blocks[n][1]);
              n++;
            }              
         }  
        frame.setVisible(true);
    }

    //ACTION PERFORMED (HIGHLIGHTING VALID MOVES)

    public void actionPerformed(ActionEvent e)
    {
      for (int x=1; x<65; x++)
       if (e.getSource()==blocks[x][1])
       {
          String color = squares[x].getCont();

          String maybeMove= squares[x+7].getCont();
          String background=squares[x+7].getbackgroung();
          String maybeMove2= squares[x+9].getCont();
          String background2=squares[x+9].getbackgroung();


          if (color=="red")
          {

          if (!(x%8==1))
            if(((maybeMove=="white") || (maybeMove=="none") && !(background=="black")))
            {
              blocks[x+7][1].setIcon(valid);
            }

          if (!(x%8==0))   
            if(((maybeMove2=="white") || (maybeMove2=="none") && !(background2=="black")))
            {
              blocks[x+9][1].setIcon(valid);
            }

          }

          String MaybeMove= squares[x-7].getCont();
          String Background=squares[x-7].getbackgroung();
          String MaybeMove2= squares[x-9].getCont();
          String Background2=squares[x-9].getbackgroung();

          if (color=="white")
          {

           if (!(x%8==0)) 
            if(((MaybeMove=="red") || (MaybeMove=="none") && !(Background=="black")))
            {
              blocks[x-7][1].setIcon(valid);
            }

           if (!(x%8==1))   
            if(((MaybeMove2=="red") || (MaybeMove2=="none") && !(Background2=="black")))
            {
              blocks[x-9][1].setIcon(valid);
            }               

          }
       }      
    }
      
    public static void main(String[] args)
    {
        Board b = new Board();
    }

}
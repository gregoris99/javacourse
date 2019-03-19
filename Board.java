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

     public Square getSquares(int a)
     {
       return squares[a];
     }

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
    
    int xSource=0,yDest=0;   

    boolean firstclick = true;
    
    public void actionPerformed(ActionEvent e)
    {     
      
     ////// x stores the location of the first button pressed 
     if (firstclick==true) 
     {  
      for (xSource=1; xSource<65; xSource++)
       if (e.getSource()==blocks[xSource][1]){
        firstclick=false;
        //System.out.println("first clickS x="+xSource);
        break;
        }
     }
     else{   
    /////// y stores the location for the second button pressed
        
      for (yDest=1; yDest<65; yDest++)
       if (e.getSource()==blocks[yDest][1])
      {  
        //we want to move square x to square y
        //System.out.println("y="+yDest+" x="+xSource);
        squares[yDest].moveTo(squares[xSource]); //invokes moveTo method in Square

        blocks[yDest][1]=squares[yDest].getBlock(); //putting the new modified key in the array   
        blocks[xSource][1]=squares[xSource].getBlock(); //putting the new empty square in the arrayjava 
               
        firstclick=true;        

      }   
      } 

  }         


   

	public static void main(String[] args)
    {
        Board b = new Board();
    }

}
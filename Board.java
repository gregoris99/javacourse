import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{
    JFrame frame = new JFrame("Java Coursework");
    JPanel panel = new JPanel();
    GridLayout layout = new GridLayout(8, 8, 0, 0);    

     //ARRAY OF SQUARE INSTANCES 

     Square[] Squares = new Square[65];    

     public Square[] getSquares()
     {
       return Squares;
     }
    
    //CONSTRUCTOR
    //ADDING ACTIONLISTENERS TO ALL BUTTONS    

    public Board()
    {
        
        frame.setSize(800,800);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setContentPane(panel);
        frame.setVisible(true);
        panel.setLayout(layout); 
       
        int n=1;              

        for (int i=0; i<8; i++)
         for (int j=0; j<8; j++)
         {
            if (((((i+1)%2==0) && ((j+1)%2==0)) || (!((i+1)%2==0) && !((j+1)%2==0))))
            {            
             Squares[n] = new Square(n,"blacks","none");            
             Squares[n].getButton().addActionListener(this);
             panel.add(Squares[n].getButton());
             n++;             
            }                        
          else  
            if((n>24) && (n<41)  )         
            {    
             Squares[n] = new Square(n,"whites","none");
             Squares[n].getButton().addActionListener(this);
             panel.add(Squares[n].getButton());
             n++;     
            }
          else
            if (n<=24)
            {
             Squares[n] = new Square(n,"whites","red");            
             Squares[n].getButton().addActionListener(this);
             panel.add(Squares[n].getButton());
             n++;                  } 
          else   
            if (n>=41)
            {
              Squares[n] = new Square(n,"whites","white");
              Squares[n].getButton().addActionListener(this);
              panel.add(Squares[n].getButton());
              n++;      
            }              
         }  
        frame.setVisible(true);
    }

    //ACTION PERFORMED
    
    int x=0,y=0;   

    boolean isItFirstclick = true;
    
    public void actionPerformed(ActionEvent e)
    {     
      
     ////// x stores the location of the first button pressed 
     if (isItFirstclick==true) 
     {  
      for (x=1; x<65; x++)
       if (e.getSource()==Squares[x].getButton())
       {
        isItFirstclick=false;        
        break;
        }
     }
     else      
    /////// y stores the location for the second button pressed
     if (isItFirstclick==false)   
      for (y=1; y<65; y++)
       if (e.getSource()==Squares[y].getButton())
      {  
        //we want to move square x to square y        
        Squares[y].moveTo(Squares[x]); //invokes moveTo method in Square        
               
        isItFirstclick=true; 

      }        
    

  }         

   

	public static void main(String[] args)
    {
        Board b = new Board();
    }

}
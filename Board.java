import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   * The Board class represents the board of the game.
   * It models the board.
   * It places the red and white pieces on the board.
   * It highlights the valid moves when a piece is clicked.
   * It moves the piece only if the move is valid. 
   **/      

public class Board implements ActionListener{

  private JFrame frame = new JFrame("Java Coursework");
  private JPanel panel = new JPanel();
  private GridLayout layout = new GridLayout(8, 8, 0, 0);     
    
  private ImageIcon valid = new ImageIcon("selected.png");
  private ImageIcon whites = new ImageIcon("empty.png");      

  private Square[] Squares = new Square[65];   

  /**
   * Creates a Window.
   * Creates a 8x8 grid draughts board.
   * Adds the red and white pieces on the board. 
   * Saves each instance of Square created in Squares array.
   **/           

  private Board(){
        
    frame.setSize(800,800);        
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    frame.setContentPane(panel);
    frame.setVisible(true);
    panel.setLayout(layout); 
       
    int n=1;              

    for (int i=0; i<8; i++)
      for (int j=0; j<8; j++){

        if (((((i+1)%2==0) && ((j+1)%2==0)) || (!((i+1)%2==0) && !((j+1)%2==0)))){

          Squares[n] = new Square(n,"blacks","none");            
          Squares[n].getButton().addActionListener(this);
          panel.add(Squares[n].getButton());
          n++;        

        }  

    else  

        if((n>24) && (n<41)){

          Squares[n] = new Square(n,"whites","none");
          Squares[n].getButton().addActionListener(this);
          panel.add(Squares[n].getButton());
          n++;  

        }

    else

        if (n<=24){

          Squares[n] = new Square(n,"whites","red");            
          Squares[n].getButton().addActionListener(this);
          panel.add(Squares[n].getButton());
          n++;  

        } 

    else   

        if (n>=41){

          Squares[n] = new Square(n,"whites","white");
          Squares[n].getButton().addActionListener(this);
          panel.add(Squares[n].getButton());
          n++;      

        }  

      }  

    frame.setVisible(true);

  }    
    
    private int x=0,y=0;   

    private boolean isItFirstclick = true;
  
  public void actionPerformed(ActionEvent e){          
      
     if (isItFirstclick==true){
      for (x=1; x<65; x++)
       if (e.getSource()==Squares[x].getButton()){          

         for (int n=1;n<65;n++)
          if(Squares[x].canMoveTo(Squares[n])==true)
           Squares[n].getButton().setIcon(valid);

         isItFirstclick=false;   

         break;           

        }      
      }

   else  
    
     if (isItFirstclick==false)   
      for (y=1; y<65; y++)
       if (e.getSource()==Squares[y].getButton()){        
        
        if(Squares[x].canMoveTo(Squares[y])==true){

          Squares[y].moveTo(Squares[x]);         

          for(int h=1;h<65;h++)
            if (Squares[h].getButton().getIcon()==valid)
             Squares[h].getButton().setIcon(whites);      
          
          isItFirstclick=true; 
          break; 
        }   

     isItFirstclick=true;   
            
     }         
  }          

	public static void main(String[] args){

      Board b = new Board();

    }

}
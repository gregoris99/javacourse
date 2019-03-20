import javax.swing.*;
import javax.swing.ImageIcon;

/**
   * The Square class represents a square on the board.
   * It puts a JButton on the Square.
   * It models the button.   
   **/      

public class Square{    
    
  private ImageIcon blacks = new ImageIcon("empty2.png");
  private ImageIcon whites = new ImageIcon("empty.png"); 
  private ImageIcon red = new ImageIcon("red.png");
  private ImageIcon white = new ImageIcon("white.png");    

  private JButton button= new JButton();

  private int location;    
  private String contains;
  private String BackgroundColor;
  
  /**
   * Returns a String containing the Background Color of the Square.
   * @return the Background Color of the Square.
   **/

  public String getBackgroundColor(){

    return BackgroundColor;
  }
  
  /**
   * Returns a String containing what is contained on the Square, red piece, white piece or nothing.
   * @return whats is contained on the Square.
   **/

  public String getContains(){

        return contains;
  }
  
  /**
   * Returns an Integer containing the location of the Square on the board.
   * @return the location of the Square on the board.
   **/

  public int getLocation(){

        return location;
  }
  
  /**
   * Returns a JButton containing the button of the Square.
   * @return button on this Square.
   **/

  public JButton getButton(){

        return button;    
  }
  
  /**
   * Moves the Square provided as a parameter to this Square.
   * @param firstClick the Square to be moved.
   **/

  public void moveTo(Square firstClick){       
       
    String before=firstClick.getContains(); 

    if (before=="white")
      button.setIcon(white);
        
    if (before=="red")
      button.setIcon(red);    


    String retainbackground =firstClick.getBackgroundColor();

    if (retainbackground=="whites")
      firstClick.getButton().setIcon(whites);
        
    if(retainbackground=="blacks")
      firstClick.getButton().setIcon(blacks);

    contains=before; 

    firstClick.contains="none";
        
  } 

  /**
   * Decides if the Square provided as a parameter can be legally moved to this Square.
   * @return true if the Square can legally moved and false if not.
   * @param examinedSquare Square to be moved.
   * 
   **/

  public boolean canMoveTo(Square examinedSquare){

    boolean able=false;      
      
    if ((contains=="white") && (examinedSquare.getContains()=="none") && (examinedSquare.getBackgroundColor()=="whites") && ((examinedSquare.getLocation()==(location-7)) || (examinedSquare.getLocation()==(location-9))))
      able=true;

    if ((contains=="red") && (examinedSquare.getContains()=="none") && (examinedSquare.getBackgroundColor()=="whites") && ((examinedSquare.getLocation()==(location+7)) || (examinedSquare.getLocation()==(location+9))))
      able=true;            

    return able;

  }  
   
  /**
   * Creates a Square.
   * Puts the right ImageIcon on the button.
   * @param loc the location of the Square in the board.
   * @param backcol the background color of the Square.
   * @param cont what is contained on the Square.
   * 
   **/

  public Square(int loc, String backcol,String cont){

    location=loc;
    contains=cont;   
    BackgroundColor=backcol;

    if(backcol=="blacks")
      button.setIcon(blacks);

    if((backcol=="whites")&&(cont=="none"))
      button.setIcon(whites);

    if((backcol=="whites")&&(cont=="white"))
      button.setIcon(white);

    if((backcol=="whites")&&(cont=="red"))
      button.setIcon(red);

  }

  public static void main(String[] args){

  }

}
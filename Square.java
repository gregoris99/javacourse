import javax.swing.ImageIcon;
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square 
{
    //IMAGES USED TO MAKE BUTTONS
    
    ImageIcon blacks = new ImageIcon("empty2.png");
    ImageIcon whites = new ImageIcon("empty.png"); 
    ImageIcon red = new ImageIcon("red.png");
    ImageIcon white = new ImageIcon("white.png");
    ImageIcon valid = new ImageIcon("selected.png");
    
    //INSTANCE VARIABLES
    JButton button= new JButton();

    int location;    
    String contains;
    String BackgroundColor;   

    public String getBackgroungColor()
    {
        return BackgroundColor;
    }   

    public String getContains()
    {
        return contains;
    }    
   

    public int getLocation()
    {
        return location;
    }   
   

    public JButton getButton()
    {
        return button;    
    } 

///////////////////////////////

    

    //This method takes as a parameter the x button and it flips it with this square

    public void moveTo(Square firstClick)
    {       
       
        String before=firstClick.getContains(); //before stores what was contained on the first key pressed

        contains=before; //stores what is now containd on the square

        if (before=="white")
         button.setIcon(white);
        
        if (before=="red")
         button.setIcon(red);         

         //setting the right background on the first key pressed

         String retainbackground =firstClick.getBackgroungColor();

         if (retainbackground=="whites")
          firstClick.getButton().setIcon(whites);
        
         if(retainbackground=="blacks")
          firstClick.getButton().setIcon(blacks);
        
    } 

    //CONSTRUCTOR

    public Square(int a, String c,String b)
    {
        location=a;
        contains=b;   
        BackgroundColor=c;

      if(c=="blacks")
       button.setIcon(blacks);

      if((c=="whites")&&(b=="none"))
       button.setIcon(whites);

      if((c=="whites")&&(b=="white"))
       button.setIcon(white);

      if((c=="whites")&&(b=="red"))
       button.setIcon(red);

    }

    public static void main(String[] args)
    {

    }

}
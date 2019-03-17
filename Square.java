import javax.swing.ImageIcon;
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square 
{
    //USED TO MAKE BUTTONS

    JButton block= new JButton();
    ImageIcon blacks = new ImageIcon("empty2.png");
    ImageIcon whites = new ImageIcon("empty.png"); 
    
    //INSTANCE VARIABLES

    int index;    
    String cont;
    String backgroundcolor;

    public void setbackground(String c)
    {
        backgroundcolor=c;
    }

    public String getbackgroung()
    {
        return backgroundcolor;
    }   

    public String getCont()
    {
        return cont;
    }    

    public void setcont(String c)
    {
        cont=c;
    }    

    public void setIndex(int x)
    {
        index=x;
    }

    public int getIndex()
    {
        return index;
    }   

    public void setKey(ImageIcon c)
    {
        block.setIcon(c);
    }

    public JButton getBlock()
    {
        return block;    
    } 

    boolean able=false;

    public boolean canMoveTo(Square x)
    {        
        String cont2=x.getCont();
        int index2=x.getIndex();
        String background2=x.getbackgroung();       

        if(cont=="white")        
         if(((index2==(index-7))||(index2==(index-9)))&&(cont2=="none")&&(background2=="whites"))
          able=true;  
         
        if(cont=="red")
         if(((index2==(index+7))||(index2==(index+9)))&&(cont2=="none")&&(background2=="whites")) 
          able=true;              

        return able;
    }

    //CONSTRUCTOR

    public Square(int a, String c,String b)
    {
       if(c=="blacks")
        this.setKey(blacks);
       else 
        this.setKey(whites);
                
        this.setIndex(a);
        this.setcont(b);    
        this.setbackground(c);   

    }

    public static void main(String[] args)
    {

    }

}
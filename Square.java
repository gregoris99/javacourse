import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JPanel
{
    
    int index;    
    String cont;    

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

    JButton block= new JButton();

    public void setKey(ImageIcon c)
    {
        block.setIcon(c);
    }

    public JButton getBlock()
    {
        return block;
    
    }

    ImageIcon blacks = new ImageIcon("empty2.png");
    ImageIcon whites = new ImageIcon("empty.png");         

    public Square(int a, String c,String b)
    {
       if(c=="blacks")
        this.setKey(blacks);
       else 
        this.setKey(whites);
                
        this.setIndex(a);
        this.setcont(b);              

    }


    public static void main(String[] args)
    {

    }

}
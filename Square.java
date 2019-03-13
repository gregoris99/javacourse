import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JPanel
{
    int x,y;

    public void setx(int a)
    {
        x=a;
    }

    public void sety(int b)
    {
        y=b;
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

    ImageIcon black = new ImageIcon("empty2.png");
    ImageIcon white = new ImageIcon("empty.png");
        

    public Square(int a, int b)
    {
       if ((((a+1)%2==0) && ((b+1)%2==0)))
        this.setKey(black);
      
       if ((!((a+1)%2==0) && !((b+1)%2==0)))
        this.setKey(black);

       if ((!((a+1)%2==0) && ((b+1)%2==0)))
        this.setKey(white);

       if ((((a+1)%2==0) && !((b+1)%2==0)))
        this.setKey(white);
        
        this.setx(a+1);
        this.sety(b+1);

    }


    public static void main(String[] args)
    {

    }

}
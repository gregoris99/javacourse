import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JPanel
{
    int index;
    int times=0;

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
        
        this.setIndex(times);
        times++;
       

    }


    public static void main(String[] args)
    {

    }

}
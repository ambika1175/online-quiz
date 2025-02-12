import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class about extends JPanel 
{
  	JButton back;
	ImageIcon i,i2;
	Image im,im2;
	int radius = 20;
	about()
	{
		setLayout(null);
		i=new ImageIcon("logo.png");
	    im=i.getImage();
		i2=new ImageIcon("aboutim.png");
	    im2=i2.getImage();
		setBackground(new Color(64,128,128));
		back=new JButton("Back");
		back.setSize(110,50);
		back.setLocation(100,500);
		back.setForeground(Color.BLACK);
	    back.setBackground(new Color(77,187,247));
	    back.setFont(new Font("Arial", Font.BOLD, 22));
	    back.setIcon(new ImageIcon("backig.png")); 		
		back.setFocusPainted(false);  // No focus border
		add(back);
		back.addMouseListener(new MouseAdapter()
	   {
          public void mouseEntered(MouseEvent e) 
		  {	
			back.setBackground(new Color(64,128,128)); 
            back.setForeground(Color.BLACK);      
		  }
          public void mouseExited(MouseEvent e) 
		  {
			back.setBackground(new Color(77,187,247)); 
            back.setForeground(Color.BLACK); 		
		  }
        });
		
	}
      public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1300,85);
		g.drawImage(im,0,1,this);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(new Color(191,191,191));
		g.drawString("An Online Examination System For Secure And Seamless Online Exams !!",145,50);
		g.drawImage(im2,800,200,this);
		
	}
}
 
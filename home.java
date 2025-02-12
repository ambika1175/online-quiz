import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
class home extends JPanel
{	
	ImageIcon i,i2;
	Image im,im2;
	JButton about,next;
	JLabel text;
	String text1 = "Test your knowledge with inner glow"; 
    int x=0; 
  home()
  {
	  setLayout(null);
	  Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
	  i=new ImageIcon("bg9.png");
	  im=i.getImage();
	  i2=new ImageIcon("logo.png");
	  im2=i2.getImage();
	  about=new JButton("About");
	  about.setSize(60,30);
	  about.setLocation(450,380);
	  about.setForeground(Color.WHITE);
	  about.setFont(new Font("Arial", Font.PLAIN, 22));
      about.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      about.setContentAreaFilled(false); // No button background
      about.setOpaque(false);
	  about.setBorder(bottomLineBorder); 	  
	  about.setFocusPainted(false);
	  add(about);
	   about.addMouseListener(new MouseAdapter()
	   {
		  public void mouseEntered(MouseEvent e)
		  {
            about.setBorderPainted(false); 
		  }
		  public void mouseExited(MouseEvent e)
		  {		  
            about.setBorderPainted(true); 
          }
        });
		
	  
	  next=new JButton("Next");
	  next.setSize(60,30);
	  next.setLocation(530,380);
	  next.setFocusPainted(false);  // No focus border
      next.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      next.setContentAreaFilled(false); // No button background
      next.setOpaque(false);
	  next.setBackground(Color.DARK_GRAY);
	  next.setForeground(Color.WHITE);
	  next.setFont(new Font("Arial", Font.PLAIN, 22));
	  next.setBorder(bottomLineBorder); 	  
	  add(next);
	  next.addMouseListener(new MouseAdapter()
	   {
          public void mouseEntered(MouseEvent e) 
		  {
            next.setBorderPainted(false); // for removig line bg 
		  }
          public void mouseExited(MouseEvent e) 
		  {
           next.setBorderPainted(true); // for removig line bg     
		  }
        });
		
		
	 text=new JLabel();
	 text.setBounds(350, 332, 1500, 60);
	 text.setHorizontalAlignment(SwingConstants.LEFT); //text ko left ki trf dipaly krwane hetu
	 text.setVerticalAlignment(SwingConstants.TOP);
	 text.setFont(new Font("Arial", Font.PLAIN, 40));
	 text.setForeground(Color.WHITE);
     add(text);	 
	startanimation();

    }  
	
   public void startanimation() 
   {
     Timer timer = new Timer(100, new ActionListener() 
	 {
       public void actionPerformed(ActionEvent e) 
	   {
		if (x<text1.length()) 
		{
           text.setText(text1.substring(0,x+1)); 
           x++;
        } 
		else 
		{
          ((Timer) e.getSource()).stop(); // Stop timer when done
        }
      }
   });
        timer.start();
    }
  public void paintComponent(Graphics g)
  {
	super.paintComponent(g);
	g.setColor(Color.BLACK);
	g.drawImage(im,0,80,this);
	g.fillRect(0,0,1300,85);
	g.drawImage(im2,0,1,this);	
	g.setFont(new Font("Arial", Font.BOLD, 40));
	g.setColor(Color.white);
    g.drawString("Welcome to",420,55);
	g.setColor(new Color(77,187,247));
	g.drawString(" Inner Glow!!",640,55);
		
	g.setColor(Color.white);
	g.setFont(new Font("Arial", Font.PLAIN, 35));
	g.drawString("/",520,410);
	g.drawString("/",600,410);
	g.setFont(new Font("Arial", Font.PLAIN, 22));
	g.drawString("Online Examination System",613,405);
	
  }
}

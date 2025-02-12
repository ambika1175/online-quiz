import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
class managequestions extends JPanel
{
	JButton backk,insert,delete,update,view,about;
	ImageIcon i;
	Image im;
	 insert in;
	 delete del;
	 update up;
	 view vi;
	managequestions()
	{
	  setLayout(null);
	  Border boxborder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
	  in=new insert();
      in.setBounds(200, 110, 860, 530);
	  in.setOpaque(false);
	  in.setBorder(boxborder);
      in.setBackground(new Color(0, 50, 74));
	  in.setVisible(false);
      add(in);
	  
	  del=new delete();
      del.setBounds(200, 110, 860, 530);
	  del.setOpaque(false);
	  del.setBorder(boxborder);
      del.setBackground(new Color(0, 50, 74));
	  del.setVisible(false);
      add(del);
	  
	  up=new update();
      up.setBounds(200, 110, 860, 530);
	  up.setOpaque(false);
	  up.setBorder(boxborder);
      up.setBackground(new Color(0, 50, 74));
	  up.setVisible(false);
      add(up);
	  
	  vi=new view();
      vi.setBounds(200, 110, 860, 530);
	  vi.setOpaque(false);
	  vi.setBorder(boxborder);
      vi.setBackground(new Color(0, 50, 74));
	  vi.setVisible(false);
      add(vi);
	  
	  i=new ImageIcon("bg5.jpg");
	  im=i.getImage();
	  Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
      Border border = BorderFactory.createLineBorder(Color.WHITE);
	  
	  backk=new JButton("Back");
	  backk.setSize(60,30);
	  backk.setLocation(1170,70);
	  backk.setFocusPainted(false);  // No focus border
      backk.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      backk.setContentAreaFilled(false); // No button background
      backk.setOpaque(false);
	  backk.setForeground(Color.WHITE);
	  backk.setFont(new Font("Arial", Font.PLAIN, 22));
      backk.setBorderPainted(false); // for removig line bg 
	  backk.setBorder(bottomLineBorder); 	  
	  add(backk);
	  // backk.addMouseListener(new MouseAdapter()
	   // {
          // public void mouseEntered(MouseEvent e) 
		  // {
           // backk.setBorderPainted(true); // for removig line bg     
		  // }
          // public void mouseExited(MouseEvent e) 
		  // {
            // backk.setBorderPainted(false); // for removig line bg 
		  // }
        // });

	  insert=new JButton("Insert");
	  insert.setSize(60,30);
	  insert.setLocation(710,70);
	  insert.setFocusPainted(false);  // No focus border
      insert.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      insert.setContentAreaFilled(false); // No button background
      insert.setOpaque(false);
	  insert.setForeground(Color.WHITE);
	  insert.setFont(new Font("Arial", Font.PLAIN, 22));
      insert.setBorderPainted(false); // for removig line bg 
	  insert.setBorder(bottomLineBorder); 	  
	  add(insert);
	  // insert.addMouseListener(new MouseAdapter()
	   // {
          // public void mouseEntered(MouseEvent e) 
		  // {
           // insert.setBorderPainted(true); // for removig line bg     
		  // }
          // public void mouseExited(MouseEvent e) 
		  // {
            // insert.setBorderPainted(false); // for removig line bg 
		  // }
        // });
		
	  delete=new JButton("Delete");
	  delete.setSize(80,30);
	  delete.setLocation(800,70);
	  delete.setFocusPainted(false);  // No focus border
      delete.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      delete.setContentAreaFilled(false); // No button background
      delete.setOpaque(false);
	  delete.setForeground(Color.WHITE);
	  delete.setFont(new Font("Arial", Font.PLAIN, 22));
	  delete.setBorder(bottomLineBorder); 	  
      delete.setBorderPainted(false); // for removig line bg 
	  add(delete);
	  // delete.addMouseListener(new MouseAdapter()
	   // {
          // public void mouseEntered(MouseEvent e) 
		  // {
           // delete.setBorderPainted(true); // for removig line bg     
		  // }
          // public void mouseExited(MouseEvent e) 
		  // {
            // delete.setBorderPainted(false); // for removig line bg 
		  // }
        // });
		
	  update=new JButton("Update");
	  update.setSize(80,30);
	  update.setLocation(900,70);
	  update.setFocusPainted(false);  // No focus border
      update.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      update.setContentAreaFilled(false); // No button background
      update.setOpaque(false);
	  update.setForeground(Color.WHITE);
	  update.setFont(new Font("Arial", Font.PLAIN, 22));
	  update.setBorder(bottomLineBorder); 	  
      update.setBorderPainted(false); // for removig line bg 
	  add(update);
	  // update.addMouseListener(new MouseAdapter()
	   // {
          // public void mouseEntered(MouseEvent e) 
		  // {
           // update.setBorderPainted(true); // for removig line bg     
		  // }
          // public void mouseExited(MouseEvent e) 
		  // {
            // update.setBorderPainted(false); // for removig line bg 
		  // }
        // });
		
	  view=new JButton("View");
	  view.setSize(60,30);
	  view.setLocation(1000,70);
	  view.setFocusPainted(false);  // No focus border
      view.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      view.setContentAreaFilled(false); // No button background
      view.setOpaque(false);
	  view.setForeground(Color.WHITE);
	  view.setFont(new Font("Arial", Font.PLAIN, 22));
	  view.setBorder(bottomLineBorder); 	  
      view.setBorderPainted(false); // for removig line bg 
	  add(view);
	  // view.addMouseListener(new MouseAdapter()
	   // {
          // public void mouseEntered(MouseEvent e) 
		  // {
           // view.setBorderPainted(true); // for removig line bg     
		  // }
          // public void mouseExited(MouseEvent e) 
		  // {
            // view.setBorderPainted(false); // for removig line bg 
		  // }
        // });	
		
	  about=new JButton("About");
	  about.setSize(60,30);
	  about.setLocation(1080,70);
	  about.setFocusPainted(false);  // No focus border
      about.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      about.setContentAreaFilled(false); // No button background
      about.setOpaque(false);
	  about.setForeground(Color.WHITE);
	  about.setFont(new Font("Arial", Font.PLAIN, 22));
	  about.setBorder(bottomLineBorder); 	  
      about.setBorderPainted(false); // for removig line bg 
	  add(about);
	  about.addMouseListener(new MouseAdapter()
	   {
          public void mouseEntered(MouseEvent e) 
		  {
           about.setBorderPainted(true); // for removig line bg     
		  }
          public void mouseExited(MouseEvent e) 
		  {
            about.setBorderPainted(false); // for removig line bg 
		  }
        });	
	  
	}
   public void paintComponent(Graphics g)
   {
	super.paintComponent(g);
	g.drawImage(im,0,0,this);
   }
}
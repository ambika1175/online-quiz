import javax.swing.*;
import java.awt.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.geom.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
class registration extends JPanel 
{
	JButton back,eye1,eye2;
	JButton register;
	JLabel firstname,lastname,email,password,contact;
	JTextField fn,ln,emailf,contactf;
	JPasswordField passwordf;
	JCheckBox rb1;
	ImageIcon i1,i2;
	Image im1,im2;
	
	registration()
	{
		Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);  // Only bott
		setLayout(null);
		i1=new ImageIcon("regisbg1.png");//cartoon
		im1=i1.getImage();
		i2=new ImageIcon("bg2.jpg");//bg
		im2=i2.getImage();
		setBackground(new Color(0,34,68));
		firstname=new JLabel("First Name");
		firstname.setBounds(660,100,200,100); //x,y,w,h
		firstname.setFont(new Font("Arial", Font.BOLD, 15));
		firstname.setForeground(Color.DARK_GRAY);
		add(firstname);
		
		fn=new JTextField(25);
		fn.setBorder(bottomLineBorder);
		fn.setFont(new Font("Arial", Font.PLAIN, 15));
		fn.setBounds(660,170,140,40);	//(x,y,w,h)
		add(fn);
		fn.setForeground(new Color(153,153,153));
		fn.setText("Enter Firstname");   
        fn.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(fn.getText().equals("Enter Firstname"))
	        {
		      fn.setText("");
		      fn.setForeground(Color.BLACK);
		      fn.setFont(new Font("Arial", Font.PLAIN, 20));
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(fn.getText().equals(""))
	       {
		     fn.setText("Enter Firstname");
		     fn.setForeground(new Color(153,153,153));
		     fn.setFont(new Font("Arial", Font.PLAIN, 15));
	       }
          }
  	    });
		
		lastname=new JLabel("Last Name");
		lastname.setBounds(865,100,200,100);
		lastname.setFont(new Font("Arial", Font.BOLD, 15));
		lastname.setForeground(Color.DARK_GRAY);
		add(lastname);
		
		ln=new JTextField(25);
		ln.setBorder(bottomLineBorder);
		ln.setFont(new Font("Arial", Font.PLAIN, 15));
		ln.setBounds(865,170,140,40);	//(x,y,w,h)
		ln.setForeground(new Color(153,153,153));
		add(ln);
		ln.setText("Enter Lastname");   
        ln.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(ln.getText().equals("Enter Lastname"))
	        {
		      ln.setText("");
		      ln.setForeground(Color.BLACK);
		      ln.setFont(new Font("Arial", Font.PLAIN, 20));
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(ln.getText().equals(""))
	       {
		     ln.setText("Enter Lastname");
		     ln.setForeground(new Color(153,153,153));
		     ln.setFont(new Font("Arial", Font.PLAIN, 15));
	       }
          }
  	    });
		
		
		email=new JLabel("Your Email");
		email.setBounds(660,190,200,100); 
		email.setFont(new Font("Arial", Font.BOLD, 15));
		email.setForeground(Color.DARK_GRAY);
		add(email);
		
		emailf=new JTextField(25);
		emailf.setBorder(bottomLineBorder);
		emailf.setFont(new Font("Arial", Font.PLAIN, 15));
		emailf.setBounds(660,260,340,39);	//(x,y,w,h)
		emailf.setForeground(new Color(153,153,153));
		add(emailf);	
		emailf.setText("Enter Email");   
        emailf.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(emailf.getText().equals("Enter Email"))
	        {
		      emailf.setText("");
		      emailf.setForeground(Color.BLACK);
		      emailf.setFont(new Font("Arial", Font.PLAIN, 20));
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(emailf.getText().equals(""))
	       {
		     emailf.setText("Enter Email");
		     emailf.setForeground(new Color(153,153,153));
		     emailf.setFont(new Font("Arial", Font.PLAIN, 15));
	       }
          }
  	    });
		
	    password=new JLabel("Password");
		password.setBounds(660,280,200,100); 
		password.setFont(new Font("Arial", Font.BOLD, 15));
		password.setForeground(Color.DARK_GRAY);
		add(password); 
		
		passwordf=new JPasswordField(25);
		passwordf.setBorder(bottomLineBorder);
		passwordf.setBounds(660,350,135,40);	//(x,y,w,h)
		passwordf.setOpaque(false);
        passwordf.setEchoChar((char) 0);
        passwordf.setForeground(new Color(153, 153, 153));
		passwordf.setText("Enter password");
		passwordf.setFont(new Font("Arial", Font.PLAIN, 15));
		add(passwordf);
        passwordf.addFocusListener(new FocusListener()
		{
           public void focusGained(FocusEvent e) 
			{
               if (String.valueOf(passwordf.getPassword()).equals("Enter password")) 
			   {
                    passwordf.setText("");
                    passwordf.setForeground(Color.BLACK);
                    passwordf.setEchoChar('*'); 
		            passwordf.setFont(new Font("Arial", Font.PLAIN, 20));
                }
            }
           public void focusLost(FocusEvent e) 
		    {
                if (String.valueOf(passwordf.getPassword()).isEmpty()) 
				{
                    passwordf.setText("Enter password");
                    passwordf.setForeground(new Color(153, 153, 153));
                    passwordf.setEchoChar((char) 0);
		            passwordf.setFont(new Font("Arial", Font.PLAIN, 15));
                }
            }
        });		
		
		contact=new JLabel("Contact");
		contact.setBounds(865,280,200,100); 
		contact.setFont(new Font("Arial", Font.BOLD, 15));
		contact.setForeground(Color.DARK_GRAY);
		add(contact);
		
		contactf=new JTextField(25);
		contactf.setBorder(bottomLineBorder);
		contactf.setBounds(865,350,135,40);
        contactf.setOpaque(false);
		contactf.setFont(new Font("Arial", Font.PLAIN, 15));
		contactf.setForeground(new Color(153,153,153));
		add(contactf);	
		contactf.setText("Enter Contact");   
        contactf.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(contactf.getText().equals("Enter Contact"))
	        {
		      contactf.setText("");
		      contactf.setForeground(Color.BLACK);
		      contactf.setFont(new Font("Arial", Font.PLAIN, 20));
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(contactf.getText().equals(""))
	       {
		     contactf.setText("Enter Contact");
		     contactf.setForeground(new Color(153,153,153));
		     contactf.setFont(new Font("Arial", Font.PLAIN, 15));
	       }
          }
  	    });
		
        rb1=new JCheckBox("I agree to the");
        rb1.setLocation(660,380);
		rb1.setSize(120,80);
		rb1.setForeground(Color.DARK_GRAY);
		rb1.setFont(new Font("Arial", Font.BOLD, 15));
		rb1.setFocusPainted(false);  // 
		rb1.setContentAreaFilled(false); // No button background
        rb1.setOpaque(false);
        add(rb1);		 
		
		register = new JButton("Register");
		register.setBounds(800,460,110,45);
		register.setFont(new Font("Arial", Font.BOLD, 15));
		register.setBackground(new Color(0,135,200));
		register.setForeground(Color.WHITE);
		register.setFocusPainted(false);  // No focus border
		add(register);
	
		back=new JButton();
		back.setSize(55,50);
		back.setLocation(0,0);
	    back.setIcon(new ImageIcon("backk.png")); 		
		back.setFocusPainted(false);  // No focus border
        back.setBorderPainted(false); // for removig line bg
	    back.setForeground(Color.WHITE); // Text color
        back.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        back.setContentAreaFilled(false); // No button background
        back.setOpaque(false);     
		add(back);
		
		eye1=new JButton();
		eye1.setSize(16,16);
		eye1.setLocation(795,374);
	    eye1.setIcon(new ImageIcon("blackeye.png")); 		
		eye1.setFocusPainted(false);  // No focus border
        eye1.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        eye1.setContentAreaFilled(false); // No button background  
        eye1.setBorder(bottomLineBorder);		
		add(eye1);
		eye1.addActionListener(new ActionListener() 
		 {
            public void actionPerformed(ActionEvent e) 
			{
                if (passwordf.getEchoChar()==(char)0) 
				{
                    passwordf.setEchoChar('*');
                } 
				else 
				{
                    passwordf.setEchoChar((char)0); 
                }
            }
        });
	}
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
        g.drawImage(im2,0,0,this);
		g.setColor(new Color(0,135,200));
        g.fillRect(230, 46, 410, 560);//x,y,w,h
        g.drawImage(im1,300,100,this);
		g.setColor(Color.WHITE);
        g.fillRect(640, 46, 410, 560);//x,y,w,h
	
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(new Color(0,135,200));
		g.drawString("REGISTRATION FORM",687,100);
		

		g.setFont(new Font("@Yu Gothic UI Semibold", Font.BOLD, 15));
		g.setColor(new Color(0,120,240));
		g.drawString("Terms and Condition",780,425);
		
	
		
	}
}
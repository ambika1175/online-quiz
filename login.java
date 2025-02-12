import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.Border;
class login extends JPanel 
{
	JButton signin;
	JButton login,back,eye,forgetpassword;
	JLabel un,up,login1;
	JTextField username;
	JPasswordField userpassword;
	ImageIcon i,i2;
	Image im,im2;
	login()
	{
		setLayout(null);
		i=new ImageIcon("menlg.png");
	    im=i.getImage();
		i2=new ImageIcon("bg3.jpg");
	    im2=i2.getImage();
		
		Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		login1=new JLabel("Login");
		login1.setBounds(580,120,200,100);
		login1.setFont(new Font("Arial", Font.BOLD,25));
		login1.setForeground(Color.WHITE);
		add(login1);
		
		un=new JLabel("Username");
		un.setBounds(420,185,200,100);
		un.setFont(new Font("Shrikhand", Font.PLAIN,18));
		un.setForeground(Color.CYAN);
		add(un);
		
		username=new JTextField(25);
		username.setBounds(420,250,370,35);	//(x,y,w,h)
		username.setBorder(bottomLineBorder);
		username.setOpaque(false);
		username.setForeground(new Color(153,153,153));
		username.setCaretColor(Color.WHITE);
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		add(username);
		username.setText("Enter Username");   
        username.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(username.getText().equals("Enter Username"))
	        {
		      // Ei#pbjdXUcJpK7x.......password of migration portal
			  username.setFont(new Font("Arial", Font.PLAIN, 21));
		      username.setText("");
		      username.setForeground(Color.WHITE);
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(username.getText().equals(""))
	       {
		     username.setFont(new Font("Arial", Font.PLAIN, 15));
		     username.setText("Enter Username");
		     username.setForeground(new Color(153,153,153));
	       }
          }
  	    });
			
		up=new JLabel("Enter Password");
		up.setBounds(420,265,200,100);
		up.setFont(new Font("Shrikhand", Font.PLAIN, 18));
		up.setForeground(Color.CYAN);
		add(up);
		
		userpassword=new JPasswordField(25);
		userpassword.setBounds(420,330,330,35);	//(x,y,w,h)
		userpassword.setBorder(bottomLineBorder);
		userpassword.setOpaque(false);
		userpassword.setForeground(new Color(153,153,153));
		userpassword.setCaretColor(Color.WHITE);
		userpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        userpassword.setEchoChar((char) 0); // Disable echo char
		userpassword.setText("Enter password");
		add(userpassword);
	    userpassword.addFocusListener(new FocusListener()
		{
           public void focusGained(FocusEvent e) 
			{
               if (String.valueOf(userpassword.getPassword()).equals("Enter password")) 
			   {
		            userpassword.setFont(new Font("Arial", Font.PLAIN, 21));
                    userpassword.setText("");
                    userpassword.setForeground(Color.WHITE);
                    userpassword.setEchoChar('*'); 
                }
            }
           public void focusLost(FocusEvent e) 
		    {
                if (String.valueOf(userpassword.getPassword()).isEmpty()) 
				{
		            userpassword.setFont(new Font("Arial", Font.PLAIN, 15));
                    userpassword.setText("Enter password");
                    userpassword.setForeground(new Color(153, 153, 153));
                    userpassword.setEchoChar((char) 0);
                }
            }
        });
       
		forgetpassword= new JButton("Forget Password?");
		forgetpassword.setBounds(632,370,150,30);	//(x,y,w,h)
		forgetpassword.setFocusPainted(false);  // No focus border
        forgetpassword.setBorderPainted(false); // for removig line bg
		forgetpassword.setForeground(new Color(0,128,255)); // Text color
        forgetpassword.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        forgetpassword.setContentAreaFilled(false); // No button background
        forgetpassword.setOpaque(false); 
        forgetpassword.setFont(new Font("Arial", Font.PLAIN, 14));		// Transparent background
		add(forgetpassword);
		
		login = new JButton("Login");
		login.setBounds(530,398,130,47);		
		login.setFont(new Font("Lemon", Font.PLAIN, 25));
		login.setFocusPainted(false);  // No focus border
		login.setBackground(new Color(0,106,157));
		login.setForeground(Color.BLACK);
		login.setContentAreaFilled(false);
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		login.setBorderPainted(false);
		add(login);
		
		
		signin = new JButton("Sign in");
		signin.setBounds(632,446,90,30);	//(x,y,w,h)
		signin.setFocusPainted(false);  // No focus border
        signin.setBorderPainted(false); // for removig line bg
		signin.setForeground(Color.CYAN); // Text color
        signin.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        signin.setContentAreaFilled(false); // No button background
        signin.setOpaque(false); 
        signin.setFont(new Font("Arial", Font.PLAIN, 13));		// Transparent background
		add(signin);
		
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
		
		eye=new JButton();
		eye.setSize(30,30);
		eye.setLocation(750,335);
		eye.setForeground(Color.WHITE);
	    eye.setIcon(new ImageIcon("eye.png")); 		
		eye.setFocusPainted(false);  // No focus border
        eye.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        eye.setContentAreaFilled(false); // No button background  
        eye.setBorder(bottomLineBorder);		
		add(eye);
		eye.addActionListener(new ActionListener() 
		 {
            public void actionPerformed(ActionEvent e) 
			{
                if (userpassword.getEchoChar()==(char)0) 
				{
                    userpassword.setEchoChar('*');
                } 
				else 
				{
                   userpassword.setEchoChar((char)0); 
                }
            }
        });
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
        g.drawImage(im2,0,0,this);
        g.drawImage(im,762,80,this);
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.setColor(Color.DARK_GRAY);  
        g2d.fillRoundRect(380 + 5, 140 + 5, 440, 400, 30, 30);//x,shadow size,y,shadow size,w,h,shaowborder size
		g.setColor(new Color(0,18,36));
        g.fillRoundRect(380, 140, 440, 400,20,20);//x,y,w,h
        g2d.setColor(Color.DARK_GRAY);  
        g2d.setStroke(new BasicStroke(3)); //line width
        g.drawRoundRect(380, 140, 440, 400,20,20);//x,y,w,h
        
		g.setColor(new Color(0,132,196));
		g.fillRoundRect(530,398,130,47,20,20);
		
		g.setColor(Color.WHITE);
		g.drawString("Don,t have an account ?",520,465);
	}
}






class forgetpass extends JPanel
{
	JLabel username,otp;
	JTextField username1 ,otp1;
	JTextField contactinfo;
	forgetpass()
	{
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		username=new JLabel("Username");
		username.setBounds(420,185,200,100);
	    username.setFont(new Font("Arial", Font.PLAIN,17));
		username.setForeground(Color.CYAN);
		add(username);
		
		username1=new JTextField(25);
		username1.setBounds(420,250,370,35);	//(x,y,w,h)
		username1.setBorder(bottomLineBorder);
		username1.setOpaque(false);
		username1.setForeground(Color.WHITE);
		username1.setFont(new Font("Arial", Font.PLAIN, 21));
		add(username1);
		
		otp=new JLabel("Enter Code");
		otp.setBounds(420,265,200,100);
		otp.setFont(new Font("Arial", Font.PLAIN, 17));
		otp.setForeground(Color.CYAN);
		add(otp);
		
		otp1=new JTextField(25);
		otp1.setBounds(420,330,370,35);	//(x,y,w,h)
		otp1.setBorder(bottomLineBorder);
		otp1.setOpaque(false);
		otp1.setForeground(Color.WHITE);
		otp1.setFont(new Font("Arial", Font.PLAIN, 21));
		add(otp1);	
		
	}
}
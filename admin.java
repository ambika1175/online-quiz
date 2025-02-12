import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class admin extends JPanel 
{
    adminchild adcp;
	manageadmin ma;
	managestudent ms;
	managecourse mcourse;
	addcourse addcourse;
	changepass cpass;
	request req;
    ImageIcon i,i2;
	Image im,im2;
    JLabel jl;  
    int x=0;    
    Timer timer; 
    admin() 
	{
        setLayout(null);
		setBackground(Color.YELLOW);
		i=new ImageIcon("bg4.jpg");
	    im=i.getImage();
		setBackground(new Color(208,218,255));
        jl = new JLabel(new ImageIcon("details.png"));
        jl.setBounds(1, 0, 38, 38);
        add(jl);
		
		adcp = new adminchild();
        adcp.setBounds(0, 0, 0, 690);
        adcp.setBackground(new Color(0, 50, 74));
        add(adcp);
		
		ma=new manageadmin();
		ma.setBounds(330, 52, 860, 550);
		ma.setVisible(false);
        ma.setBackground(new Color(0, 50, 74));
        add(ma);
		
		ms=new managestudent();
		ms.setBounds(330, 52, 860, 550);
		ms.setVisible(false);
        ms.setBackground(new Color(0, 50, 74));
        add(ms);
		
		mcourse=new managecourse();
		mcourse.setBounds(330, 52, 860, 550);
		mcourse.setVisible(false);
        mcourse.setBackground(new Color(0, 50, 74));
        add(mcourse);
		
		addcourse=new addcourse();
		addcourse.setBounds(330, 52, 860, 550);
		addcourse.setVisible(false);
        addcourse.setBackground(new Color(0, 50, 74));
        add(addcourse);
		
    	req=new request();
		req.setBounds(330, 52, 860, 550);
		req.setVisible(false);
        req.setBackground(new Color(0, 50, 74));
        add(req);
		
		cpass=new changepass();
		cpass.setBounds(330,52,860,550);
		cpass.setVisible(false);
		cpass.setBackground(new Color(0,50,74));
		add(cpass);
		
		// changep=new changepassword();
		// changep.setBounds(330, 52, 860, 550);
		// changep.setVisible(false);
        // changep.setBackground(new Color(0, 50, 74));
        // add(changep);
		
		
		
        jl.addMouseListener(new MouseAdapter() 
		{
            public void mouseClicked(MouseEvent e) {newPanel();}
        });
    }
    public void newPanel() 
	{
        if (x==0) 
		{
            animatePanel(247);
        }
		else 
		{
            animatePanel(0);
        }
    }
    public void animatePanel(int Width)
	{
        timer=new Timer(10,new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
			{    
                if(x<Width) 
				{
                    x+=10;  
                    if(x>=Width) 
					{
                        x=Width;  
                        timer.stop(); 
                    }
                } 
				else if (x>Width) 
				{
                    x-=10;  
                    if(x<=Width) 
					{
                        x=Width; 
                        timer.stop(); 
                    }
                }
               adcp.setSize(x,690);
            }
        });
        timer.start();  
    }
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(im,0,0,this);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("*Inner Glow presented*",400,90);
		g.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		
	}	
}



   
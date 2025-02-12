import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class usermenu extends JPanel 
{
    ChildPanel cp;
	editprofile ep;
	course c;
	viewresult vr;
	exam ex;
	certificate cf;
	help hp;
    JLabel jl;  
    int x=0;    
    Timer timer; 
    usermenu() 
	{
        setLayout(null);
		setBackground(Color.GRAY);
        jl = new JLabel(new ImageIcon("details.png"));
        jl.setBounds(1, 0, 38, 38);
        add(jl);
		
		cp = new ChildPanel();
        cp.setBounds(0, 0, 0, 690);
        cp.setBackground(new Color(50, 70, 78));
        add(cp);
		
		ep=new editprofile();
		ep.setBounds(290, 50, 860, 550);
		ep.setVisible(false);
        ep.setBackground(new Color(50, 70, 78));
        add(ep);
		
		c=new course();
		c.setBounds(290, 50, 860, 550);
		c.setVisible(false);
        c.setBackground(new Color(50,70,78));
        add(c);
		
		ex=new exam();
		ex.setBounds(290, 50, 860, 550);
		ex.setVisible(false);
        ex.setBackground(new Color(50,70,78));
        add(ex);
		
		vr=new viewresult();
		vr.setBounds(290, 50, 860, 550);
		vr.setVisible(false);
        vr.setBackground(new Color(50,70,78));
        add(vr);
		
		cf=new certificate();
		cf.setBounds(290, 50, 860, 550);
		cf.setVisible(false);
        cf.setBackground(new Color(50,70,78));
        add(cf);
		
		
		
		hp=new help();
		hp.setBounds(230, 0, 1500, 690);
		hp.setVisible(false);
        hp.setBackground(new Color(207,230,239));
        add(hp);
		
        jl.addMouseListener(new MouseAdapter() 
		{
            public void mouseClicked(MouseEvent e) {newPanel();}
        });
    }
    public void newPanel() 
	{
        if (x==0) 
		{
            animatePanel(230);
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
               cp.setSize(x,690);
            }
        });
        timer.start();  
    }
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("*Online Examination System*",290,90);
		g.setFont(new Font("Georgia", Font.PLAIN, 20));
		g.drawString("Online Examination System is a technology-driven way to simplify examination activities like",290,170);
		g.drawString("defining exam patterns with question banks, defining exam timers, subjective question section,",290,195);
		g.drawString("and conducting exams using a computer or mobile devices in a paperless manner.",290,220);
		g.drawString("Online Examination System is a cost-effective, scalable way to convert traditional pen and",290,245);
		g.drawString("paper-based exams to online and paperless mode.Candidates can appear for the exam using",290,275);
		g.drawString(" any desktop, laptop, or mobile device with a browser.",290,300);
		
		
	}	
}



   
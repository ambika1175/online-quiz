import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
class certificate extends JPanel
{
	JButton backk;
	ImageIcon i;
	Image im;
	JTextField sname;
	
	certificate()
	{
		setLayout(null);
		Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.YELLOW);  // Only display bottom border 
        i=new ImageIcon("certificate1.png");
	    im=i.getImage();
		backk=new JButton();
		backk.setSize(55,50);
		backk.setLocation(0,0);
	    backk.setIcon(new ImageIcon("backk.png")); 		
		backk.setFocusPainted(false);  // No focus border
        backk.setBorderPainted(false); // for removig line bg
	    backk.setForeground(Color.WHITE); // Text color
        backk.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        backk.setContentAreaFilled(false); // No button background
        backk.setOpaque(false);     
		add(backk);
		
		
		sname=new JTextField();
		sname.setSize(380,45);
		sname.setLocation(350,272);	//(x,y,w,h)
		sname.setBorder(bottomLineBorder);
	    sname.setOpaque(false);
		sname.setEditable(false);
		sname.setForeground(new Color(0,45,45));
		sname.setFont(new Font("Great Vibes", Font.PLAIN, 40));
		add(sname);
		
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im,0,0,this);
	}
}
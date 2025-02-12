import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
class ChildPanel extends JPanel
{
	JButton editprofile,course,exam,result,certificate,help,logout;
    ImageIcon i1,i2,i3,i4,i5,i6;
	Image im1,im2,im3,im4,im5,im6;
    JTextField name;	
	ChildPanel()
	{
		setLayout(null);
		
		i1=new ImageIcon("editprofile.png");
	    im1=i1.getImage();
		i2=new ImageIcon("course.png");
	    im2=i2.getImage();
		i6=new ImageIcon("help1.png");
	    im6=i6.getImage();
		i4=new ImageIcon("result.png");
	    im4=i4.getImage();
		i5=new ImageIcon("certificate.png");
	    im5=i5.getImage();
		i3=new ImageIcon("exam.png");
	    im3=i3.getImage();
		
		name=new JTextField();
		name.setSize(190,38);
		name.setFont(new Font("Arial", Font.PLAIN, 25));
		name.setLocation(50,5);
		name.setEditable(false);
		name.setOpaque(false);
		name.setBorder(null);
		name.setForeground(Color.BLACK);
		add(name);
		
		editprofile=new JButton("edit profile");
		editprofile.setSize(200,40);
		editprofile.setLocation(10,152);
		editprofile.setFont(new Font("Arial", Font.PLAIN, 22));
		editprofile.setFocusPainted(false);  // No focus border
        editprofile.setBorderPainted(false); // for removig line bg
		editprofile.setForeground(Color.WHITE); // Text color
        editprofile.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        editprofile.setContentAreaFilled(false); // No button background
        editprofile.setOpaque(false);        // Transparent background
		add(editprofile);
		
		course=new JButton("Courses");
		course.setSize(200,40);
		course.setLocation(10,200);
		course.setFont(new Font("Arial", Font.PLAIN, 22));
		course.setFocusPainted(false);  // No focus border
        course.setBorderPainted(false); // for removig line bg
		course.setForeground(Color.WHITE); // Text color
        course.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        course.setContentAreaFilled(false); // No button background
        course.setOpaque(false);        // Transparent background
		add(course);
		
		exam=new JButton("Exam");
		exam.setSize(200,40);
		exam.setLocation(10,248);
		exam.setFont(new Font("Arial", Font.PLAIN, 22));
		exam.setFocusPainted(false);  // No focus border
        exam.setBorderPainted(false); // for removig line bg
		exam.setForeground(Color.WHITE); // Text color
        exam.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        exam.setContentAreaFilled(false); // No button background
        exam.setOpaque(false);        // Transparent background
		add(exam);
		 
		result=new JButton(" View Result");
		result.setSize(200,40);
		result.setLocation(10,298);
		result.setFont(new Font("Arial", Font.PLAIN, 22));
		result.setFocusPainted(false);  // No focus border
        result.setBorderPainted(false); // for removig line bg
		result.setForeground(Color.WHITE); // Text color
        result.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        result.setContentAreaFilled(false); // No button background
        result.setOpaque(false);        // Transparent background
		add(result);
		
		certificate=new JButton("Certificate");
		certificate.setSize(200,40);
		certificate.setLocation(10,348);
		certificate.setFont(new Font("Arial", Font.PLAIN, 22));
		certificate.setFocusPainted(false);  // No focus border
        certificate.setBorderPainted(false); // for removig line bg
	    certificate.setForeground(Color.WHITE); // Text color
        certificate.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        certificate.setContentAreaFilled(false); // No button background
        certificate.setOpaque(false);        // Transparent background
		add(certificate);
		
		help=new JButton("Need Help?");
		help.setSize(200,40);
		help.setLocation(10,402);
		help.setFont(new Font("Arial", Font.PLAIN,22));	
		help.setFocusPainted(false);  // No focus border
        help.setBorderPainted(false); // for removig line bg
	    help.setForeground(Color.WHITE); // Text color
        help.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        help.setContentAreaFilled(false); // No button background
        help.setOpaque(false);        // Transparent background
		add(help);
		
		logout=new JButton("Log Out");
		logout.setSize(200,40);
		logout.setLocation(3,472);
		logout.setFont(new Font("Arial", Font.PLAIN,20));
	    logout.setIcon(new ImageIcon("logout2.png")); 		
		logout.setFocusPainted(false);  // No focus border
        logout.setBorderPainted(false); // for removig line bg
	    logout.setForeground(Color.RED); // Text color
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        logout.setContentAreaFilled(false); // No button background
        logout.setOpaque(false);        // Transparent background
		add(logout);
	}
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		// g.drawString("Hello User !!",50,30);
		g.drawImage(im1,5,150,this);
		g.drawImage(im2,10,203,this);
		g.drawImage(im3,9,250,this);
		g.drawImage(im6,10,404,this);
		g.drawImage(im4,10,302,this);
		g.drawImage(im5,10,353,this);
		// g.drawOval(1,65,50,50);
	}
	
	
}
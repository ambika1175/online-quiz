import javax.swing.*;
import java.awt.*;
class adminchild extends JPanel
{
	
	JButton logout,manageadmin,managecourse,managestudent,request,changepass;
	ImageIcon i,i2,i3,i4,i5,i6;
	Image im,im2,im3,im4,im5,im6;

	adminchild()
	{
		setLayout(null);
		i=new ImageIcon("manageadmins.png");
	    im=i.getImage();
		i2=new ImageIcon("managecourses.png");
	    im2=i2.getImage();
		i3=new ImageIcon("managestudents.png");
	    im3=i3.getImage();
		i4=new ImageIcon("request.png");
	    im4=i4.getImage();
		i5=new ImageIcon("changepass.png");
	    im5=i5.getImage();
		
		
	    logout=new JButton("Log Out");
		logout.setSize(200,40);
		logout.setLocation(3,422);
		logout.setFont(new Font("Arial", Font.PLAIN,20));
	    logout.setIcon(new ImageIcon("logout2.png")); 		
		logout.setFocusPainted(false);  // No focus border
        logout.setBorderPainted(false); // for removig line bg
	    logout.setForeground(Color.RED); // Text color
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        logout.setContentAreaFilled(false); // No button background
        logout.setOpaque(false);        // Transparent background
		add(logout);

        manageadmin=new JButton("Manage Admins");
		manageadmin.setSize(200,40);
		manageadmin.setLocation(25,102);
		manageadmin.setFont(new Font("Arial", Font.PLAIN, 22));
		manageadmin.setFocusPainted(false);  // No focus border
        manageadmin.setBorderPainted(false); // for removig line bg
		manageadmin.setForeground(Color.WHITE); // Text color
        manageadmin.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        manageadmin.setContentAreaFilled(false); // No button background
        manageadmin.setOpaque(false);        // Transparent background
		add(manageadmin);
 
        managecourse=new JButton(" Manage Courses");
		managecourse.setSize(210,40);
		managecourse.setLocation(25,150);
		managecourse.setFont(new Font("Arial", Font.PLAIN, 22));
		managecourse.setFocusPainted(false);  // No focus border
        managecourse.setBorderPainted(false); // for removig line bg
		managecourse.setForeground(Color.WHITE); // Text color
        managecourse.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        managecourse.setContentAreaFilled(false); // No button background
        managecourse.setOpaque(false);        // Transparent background
		add(managecourse);
		
		managestudent=new JButton("Manage Students");
		managestudent.setSize(210,40);
		managestudent.setLocation(25,202);
		managestudent.setFont(new Font("Arial", Font.PLAIN, 22));
		managestudent.setFocusPainted(false);  // No focus border
        managestudent.setBorderPainted(false); // for removig line bg
		managestudent.setForeground(Color.WHITE); // Text color
        managestudent.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        managestudent.setContentAreaFilled(false); // No button background
        managestudent.setOpaque(false);        // Transparent background
		add(managestudent);
		
		request=new JButton("View Requests");
		request.setSize(210,40);
		request.setLocation(25,258);
		request.setFont(new Font("Arial", Font.PLAIN, 22));
		request.setFocusPainted(false);  // No focus border
        request.setBorderPainted(false); // for removig line bg
		request.setForeground(Color.WHITE); // Text color
        request.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        request.setContentAreaFilled(false); // No button background
        request.setOpaque(false);        // Transparent background
		add(request);
		
		changepass=new JButton("Change Password");
		changepass.setSize(210,40);
		changepass.setLocation(26,312);
		changepass.setFont(new Font("Arial", Font.PLAIN, 22));
		changepass.setFocusPainted(false);  // No focus border
        changepass.setBorderPainted(false); // for removig line bg
		changepass.setForeground(Color.WHITE); // Text color
        changepass.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        changepass.setContentAreaFilled(false); // No button background
        changepass.setOpaque(false);        // Transparent background
		add(changepass);

		
		
	}
   public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Ms.Ambika ",50,30);
		g.drawImage(im,5,100,this);
		g.drawImage(im2,5,153,this);
		g.drawImage(im3,5,203,this);
		g.drawImage(im4,5,253,this);
		g.drawImage(im5,5,305,this);
		
		
	}
		
}

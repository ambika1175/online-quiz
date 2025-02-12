import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
class manageadmin extends JPanel
{
	 JLabel un,up,admin;
   JTextField name,password,changepass;
   JButton add,backk;
       
	manageadmin()
	{
		setLayout(null);
        Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
	    Border border = BorderFactory.createLineBorder(new Color(0,50,74));
		
        admin=new JLabel("Save As Admin");
		admin.setBounds(70,20,200,100);
		admin.setFont(new Font("Arial", Font.BOLD,25));
		admin.setForeground(Color.WHITE);
		add(admin);        
		
		backk = new JButton();
        backk.setSize(55, 50);
        backk.setLocation(0, 0);
        backk.setIcon(new ImageIcon("backk.png"));
        backk.setFocusPainted(false); // No focus border
        backk.setBorderPainted(false); // for removing line bg
        backk.setForeground(Color.WHITE); // Text color
        backk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backk.setContentAreaFilled(false); // No button background
        backk.setOpaque(false);
        add(backk);
		
		un=new JLabel("Username");
		un.setBounds(250,150,200,100);
		un.setFont(new Font("Arial", Font.PLAIN,17));
		un.setForeground(Color.WHITE);
		add(un);
		
		name=new JTextField(25);
		name.setBounds(250,215,370,35);	//(x,y,w,h)
		name.setBorder(bottomLineBorder);
		name.setOpaque(false);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Arial", Font.PLAIN, 21));
		name.setCaretColor(Color.WHITE);
		add(name);
		
		up=new JLabel("Enter Password");
		up.setBounds(250,230,200,100);
		up.setFont(new Font("Arial", Font.PLAIN, 17));
		up.setForeground(Color.WHITE);
		add(up);
		
		password=new JTextField(25);
		password.setBounds(250,295,370,35);	//(x,y,w,h)
		password.setBorder(bottomLineBorder);
		password.setOpaque(false);
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Arial", Font.PLAIN, 21));
		password.setCaretColor(Color.WHITE);
		add(password);

        add = new JButton("Save");
	    add.setBounds(360,370,180,40);
		add.setFont(new Font("Arial", Font.BOLD, 19));
		add.setFocusPainted(false);  // No focus border
		add.setOpaque(false);
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLUE);
		add.setBorder(border);
		add(add);
				

	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.sql.*;
class changepass extends JPanel
{
	 JLabel oldp,newp,admin;
   JTextField oldpassword,newpassword,changepass;
   JButton add,backk;
       
	changepass()
	{
		setLayout(null);
        Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
	    Border border = BorderFactory.createLineBorder(new Color(0,50,74));
		
        admin=new JLabel("Change Password");
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
		
		oldp=new JLabel("old password");
		oldp.setBounds(250,150,200,100);
		oldp.setFont(new Font("Arial", Font.PLAIN,17));
		oldp.setForeground(Color.WHITE);
		add(oldp);
		
		oldpassword=new JTextField(25);
		oldpassword.setBounds(250,215,370,35);	//(x,y,w,h)
		oldpassword.setBorder(bottomLineBorder);
		oldpassword.setOpaque(false);
		oldpassword.setForeground(Color.WHITE);
		oldpassword.setFont(new Font("Arial", Font.PLAIN, 21));
		oldpassword.setCaretColor(Color.WHITE);
		add(oldpassword);
		
		newp=new JLabel("Enter Password");
		newp.setBounds(250,230,200,100);
		newp.setFont(new Font("Arial", Font.PLAIN, 17));
		newp.setForeground(Color.WHITE);
		add(newp);
		
		newpassword=new JTextField(25);
		newpassword.setBounds(250,295,370,35);	//(x,y,w,h)
		newpassword.setBorder(bottomLineBorder);
		newpassword.setOpaque(false);
		newpassword.setForeground(Color.WHITE);
		newpassword.setFont(new Font("Arial", Font.PLAIN, 21));
		newpassword.setCaretColor(Color.WHITE);
		add(newpassword);

        add = new JButton("Save");
	    add.setBounds(360,370,180,40);
		add.setFont(new Font("Arial", Font.BOLD, 19));
		add.setFocusPainted(false);  // No focus border
		add.setOpaque(false);
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLUE);
		add.setBorder(border);
		add(add);	
      add.addActionListener(e -> updatepassword());
		
	}
	
	void updatepassword()
	{
		String s1=oldpassword.getText();
		String s2=newpassword.getText();
		 try
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
			  String db_uname="root";
			  String db_upass="root";
			  Connection con= DriverManager.getConnection(db_url,db_uname,db_upass); 
              Statement st=con.createStatement();			  
			  String s11="update registration SET password='"+s2+"' WHERE password='"+s1+"'";
			  st.executeUpdate(s11);
			ImageIcon icon = new ImageIcon("done.png");
            JOptionPane.showMessageDialog(null, "Data Update Successfully!" ,"Update Status", JOptionPane.ERROR_MESSAGE,icon);
		  } 
		  catch (Exception ex) 
		  {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
	}
	
}

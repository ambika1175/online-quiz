import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class editprofile extends JPanel {
    JLabel firstname, lastname, password, newpass, contact, email;
    JTextField newname, newlastname, oldpassword, newcontact, newemail;
	JPasswordField newconfirmpass;
    JButton backk, profile, change;
    Border bottomLineBorder;

    editprofile() {
        Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK); // Only bottom
        setLayout(null);
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

        profile = new JButton();
        profile.setSize(75, 75);
        profile.setLocation(370, 40);
        profile.setIcon(new ImageIcon("changeimage.png"));
        profile.setFocusPainted(false); // No focus border
        profile.setBorderPainted(false); // for removing line bg
        profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profile.setContentAreaFilled(false); // No button background
        profile.setOpaque(false);
        add(profile);

        profile.addActionListener(e -> uploadProfilePhoto());

        firstname = new JLabel("First Name");
        firstname.setBounds(100, 100, 200, 100);
        firstname.setFont(new Font("Arial", Font.PLAIN, 20));
        firstname.setForeground(Color.WHITE);
        add(firstname);

        newname = new JTextField(25);
        newname.setBounds(100, 175, 250, 30); //(x,y,w,h)
        newname.setBorder(bottomLineBorder);
        newname.setOpaque(false);
        newname.setFont(new Font("Arial", Font.PLAIN, 15));
		newname.setForeground(new Color(153,153,153));
        add(newname);
		newname.setText("Enter Username");   
        newname.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(newname.getText().equals("Enter Username"))
	        {
		      newname.setText("");
		      newname.setForeground(Color.WHITE);
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(newname.getText().equals(""))
	       {
		     newname.setText("Enter Username");
		     newname.setForeground(new Color(153,153,153));
	       }
          }
  	    });

        lastname = new JLabel("Last Name");
        lastname.setBounds(540, 100, 200, 100);//pehla coordinate width ka hai.
        lastname.setFont(new Font("Arial", Font.PLAIN, 20));
        lastname.setForeground(Color.WHITE);
        add(lastname);

        newlastname = new JTextField(25);
        newlastname.setBounds(540, 175, 250, 30); //(x,y,w,h)
        newlastname.setBorder(bottomLineBorder);
        newlastname.setFont(new Font("Arial", Font.PLAIN, 15));
        newlastname.setOpaque(false);
        add(newlastname);
		newlastname.setForeground(new Color(153,153,153));
		newlastname.setText("Enter lastname");   
        newlastname.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(newlastname.getText().equals("Enter lastname"))
	        {
		      newlastname.setText("");
		      newlastname.setForeground(Color.WHITE);
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(newlastname.getText().equals(""))
	       {
		     newlastname.setText("Enter lastname");
		     newlastname.setForeground(new Color(153,153,153));
	       }
          }
  	    });

        password = new JLabel("Old Password");
        password.setBounds(100, 210, 200, 100);//pehla coordinate width ka hai.
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setForeground(Color.WHITE);
        add(password);

        oldpassword = new JTextField(25);
        oldpassword.setBounds(100, 285, 250, 30); //(x,y,w,h)
        oldpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        oldpassword.setBorder(bottomLineBorder);
        oldpassword.setOpaque(false);
		oldpassword.setForeground(new Color(153,153,153));
        add(oldpassword);
		oldpassword.setText("Enter old password");   
        oldpassword.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(oldpassword.getText().equals("Enter old password"))
	        {
		      oldpassword.setText("");
		      oldpassword.setForeground(Color.WHITE);
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(oldpassword.getText().equals(""))
	       {
		     oldpassword.setText("Enter old password");
		     oldpassword.setForeground(new Color(153,153,153));
	       }
          }
  	    });

        newpass = new JLabel("New Password");
        newpass.setBounds(540, 210, 200, 100);//pehla coordinate width ka hai.
        newpass.setFont(new Font("Arial", Font.PLAIN, 20));
        newpass.setForeground(Color.WHITE);
        add(newpass);

        newconfirmpass = new JPasswordField(25);
        newconfirmpass.setBounds(540, 285, 250, 30); //(x,y,w,h)
        newconfirmpass.setBorder(bottomLineBorder);
        newconfirmpass.setOpaque(false);
        newconfirmpass.setFont(new Font("Arial", Font.PLAIN, 20));
        add(newconfirmpass);
        newconfirmpass.setEchoChar((char) 0);
		newconfirmpass.setText("Enter new password");
		newconfirmpass.setFont(new Font("Arial", Font.PLAIN, 15));
        newconfirmpass.addFocusListener(new FocusListener()
		{
           public void focusGained(FocusEvent e) 
			{
               if (String.valueOf(newconfirmpass.getPassword()).equals("Enter new password")) 
			   {
                    newconfirmpass.setText("");
                    newconfirmpass.setForeground(Color.BLACK);
                    newconfirmpass.setEchoChar('*'); 
		            newconfirmpass.setFont(new Font("Arial", Font.PLAIN, 20));
                }
            }
           public void focusLost(FocusEvent e) 
		    {
                if (String.valueOf(newconfirmpass.getPassword()).isEmpty()) 
				{
                    newconfirmpass.setText("Enter new password");
                    newconfirmpass.setForeground(new Color(153, 153, 153));
                    newconfirmpass.setEchoChar((char) 0);
		            newconfirmpass.setFont(new Font("Arial", Font.PLAIN, 15));
                }
            }
        });		
		

        contact = new JLabel("Contact Info");
        contact.setBounds(100, 320, 200, 100);//pehla coordinate width ka hai.
        contact.setFont(new Font("Arial", Font.PLAIN, 20));
        contact.setForeground(Color.WHITE);
        add(contact);

        newcontact = new JTextField(25);
        newcontact.setBounds(100, 395, 250, 30); //(x,y,w,h)
        newcontact.setBorder(bottomLineBorder);
        newcontact.setFont(new Font("Arial", Font.PLAIN, 15));
        newcontact.setOpaque(false);
		newcontact.setForeground(new Color(153,153,153));
        add(newcontact);
		newcontact.setText("Enter contact");   
        newcontact.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(newcontact.getText().equals("Enter contact"))
	        {
		      newcontact.setText("");
		      newcontact.setForeground(Color.WHITE);
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(newcontact.getText().equals(""))
	       {
		     newcontact.setText("Enter contact");
		     newcontact.setForeground(new Color(153,153,153));
	       }
          }
  	    });

        email = new JLabel("Enter Email");
        email.setBounds(540, 320, 200, 100);//pehla coordinate width ka hai.
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setForeground(Color.WHITE);
        add(email);

        newemail = new JTextField(25);
        newemail.setBounds(540, 395, 250, 30); //(x,y,w,h)
        newemail.setBorder(bottomLineBorder);
        newemail.setOpaque(false);
        newemail.setFont(new Font("Arial", Font.PLAIN, 15));
		newemail.setForeground(new Color(153,153,153));
        add(newemail);
		newemail.setText("Enter your email");   
        newemail.addFocusListener(new FocusListener() 
	    {
          public void  focusGained(FocusEvent e)
          {
	        if(newemail.getText().equals("Enter your email"))
	        {
		      newemail.setText("");
		      newemail.setForeground(Color.WHITE);
	        }
          }
          public void focusLost(FocusEvent e)
          {
	       if(newemail.getText().equals(""))
	       {
		     newemail.setText("Enter your email");
		     newemail.setForeground(new Color(153,153,153));
	       }
          }
  	    });

        change = new JButton("Change");
        change.setBounds(370, 462, 110, 45);
        change.setFont(new Font("Arial", Font.BOLD, 15));
        change.setBackground(new Color(0, 135, 200));
        change.setForeground(Color.WHITE);
        change.setFocusPainted(false); // No focus border
        add(change);
    }

    private void uploadProfilePhoto() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setPreferredSize(new Dimension(800, 600)); // Larger size
        fileChooser.setDialogTitle("Select a File");

        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File file) {
                String name = file.getName().toLowerCase();
                return file.isDirectory() || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png");
            }

            public String getDescription() {
                return "Image Files (*.jpg, *.jpeg, *.png)";
            }
        });

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(selectedFile)) {
                // Connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
				String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
				String db_uname="root";
				String db_upass="root";
				Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
                String sql = "INSERT INTO images (email, profile_photo) VALUES (?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, selectedFile.getName());
                pstmt.setBinaryStream(2, fis, (int) selectedFile.length());
                pstmt.executeUpdate();

                con.close();

                JOptionPane.showMessageDialog(this, "Photo uploaded successfully to database!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to upload image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawOval(368, 42, 80, 80);
    }
}
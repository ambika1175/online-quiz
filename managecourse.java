import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
class managecourse extends JPanel implements ListSelectionListener 
{
    JList<String> jl1; // Changed to JList<String>
    JButton backk, delete,addbutton,managequestions;
    JScrollPane scrollPane;
    DefaultListModel<String> listModel; // To hold data from database
    JTextArea textarea;
	static String selectedValue;
  managecourse() 
  {
     setLayout(null);
     Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
     Border border = BorderFactory.createLineBorder(Color.BLACK);
    
     backk = new JButton();
     backk.setSize(55, 50);
     backk.setLocation(0, 0);
     backk.setIcon(new ImageIcon("backk.png"));
     backk.setFocusPainted(false);
     backk.setBorderPainted(false);
     backk.setForeground(Color.WHITE);
     backk.setCursor(new Cursor(Cursor.HAND_CURSOR));
     backk.setContentAreaFilled(false);
     backk.setOpaque(false);
     add(backk);

     addbutton=new JButton("Add course");
     addbutton.setSize(130, 40);
     addbutton.setLocation(500, 200);
     addbutton.setBackground(new Color(0,132,196));
	 addbutton.setForeground(Color.BLACK);
     addbutton.setFont(new Font("Arial", Font.BOLD, 16));
     addbutton.setFocusPainted(false);
     add(addbutton);
	 addbutton.addMouseListener(new MouseAdapter()
	 {
          public void mouseEntered(MouseEvent e) 
		  {
            addbutton.setOpaque(false);
			addbutton.setForeground(Color.WHITE);
		  }
          public void mouseExited(MouseEvent e) 
		  {
            addbutton.setOpaque(true);
			addbutton.setForeground(Color.BLACK);
		  }
     });
		
	 delete=new JButton("Delete");
     delete.setBounds(700, 200, 130, 40);
     delete.setFont(new Font("Arial", Font.BOLD, 16));
	 delete.setFocusPainted(false);  // No focus border
     delete.setBackground(new Color(0,50,74));
	 delete.setForeground(Color.WHITE);
     add(delete);
	 delete.addMouseListener(new MouseAdapter()
	 {
          public void mouseEntered(MouseEvent e) 
		  {
            delete.setBackground(new Color(0,132,196));
			delete.setForeground(Color.BLACK);
		  }
          public void mouseExited(MouseEvent e) 
		  {
            delete.setBackground(new Color(0,50,74));
			delete.setForeground(Color.WHITE);
		  }
     });
	 delete.addActionListener(e -> deletebutton());

	 managequestions= new JButton("Manage questions");
     managequestions.setSize(200, 40);
     managequestions.setLocation(570, 280);
     managequestions.setFont(new Font("Arial", Font.BOLD, 15));
     managequestions.setFocusPainted(false	);
     managequestions.setOpaque(false);
     add(managequestions);
     
	 listModel = new DefaultListModel<>(); 
     jl1 = new JList<>(listModel); 
     jl1.setFont(new Font("Arial", Font.BOLD, 20));
     jl1.setOpaque(false);
     jl1.setLocation(50, 50);
     jl1.setBorder(bottomLineBorder);
     jl1.setVisibleRowCount(3);
     add(new JScrollPane(jl1));
     add(jl1);
     jl1.addListSelectionListener(this);
     
	 jl1.setCellRenderer(new DefaultListCellRenderer() 
	 {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
		{
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setOpaque(false);
                label.setForeground(Color.BLACK);
				label.setBackground(Color.WHITE);
				label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
				label.setOpaque(isSelected); // Only selected items will appear with background color
                label.setBackground(isSelected ? new Color(227,222,243) : list.getBackground());
                label.setForeground(isSelected ? Color.BLACK : Color.BLACK);

                return label;
        }
     });
	 
     scrollPane = new JScrollPane(jl1);
     scrollPane.setBounds(30, 30, 300, 500);
     scrollPane.setOpaque(false);
     scrollPane.getViewport().setOpaque(false);
     scrollPane.setBorder(null);
     scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
     scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
     add(scrollPane);

     fetchDataFromDatabase();
    }
   public void fetchDataFromDatabase() 
   {
      try 
	  {
        String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false"; 
        String username = "root"; 
        String password = "root"; 
        Connection connection = DriverManager.getConnection(url, username, password);
        String query = "SELECT subjects FROM course"; 
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
		listModel.clear();
        while (resultSet.next()) 
		{
           listModel.addElement(resultSet.getString("subjects"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        }
		catch (Exception e) 
		{
           System.out.println(e);
        }
    }
  public void valueChanged(ListSelectionEvent e) 
  {
     if (!e.getValueIsAdjusting()) 
     { 
        selectedValue = jl1.getSelectedValue();
        if (selectedValue != null)
		{
        }
     }
  }
  public void deletebutton()
	{
	   String selectedValue = jl1.getSelectedValue();
       if (selectedValue != null) 
	   {
          int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + selectedValue + "\"?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
         if (confirmation == JOptionPane.YES_OPTION)
		 {
		  try 
		  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String db_uname = "root";
            String db_upass = "root";
            Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			String s11="delete from course WHERE subjects=?";
			PreparedStatement st = con.prepareStatement(s11);
            st.setString(1, selectedValue);
			int rowsAffected=st.executeUpdate();
            if (rowsAffected > 0) 
			{
                JOptionPane.showMessageDialog(this, "Record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                listModel.removeElement(selectedValue);
            } 
			else
			{
                JOptionPane.showMessageDialog(this, "Error deleting record. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            con.close();
          }
		  catch(Exception e)
		  {
			JOptionPane.showMessageDialog(this, "Error 1175: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		  }
	     }
       }
	}
}



class addcourse extends JPanel
{
   JTextField tx1;
   JButton save,backk;
   JTextField text,year,author,lab;
   JTextArea desciption;
   
  addcourse()
   {
     setLayout(null);
	 Border border = BorderFactory.createLineBorder(Color.BLACK);
   
	 backk = new JButton();
     backk.setSize(55, 50);
     backk.setLocation(0, 0);
     backk.setIcon(new ImageIcon("backk.png"));
     backk.setFocusPainted(false);
     backk.setBorderPainted(false);
     backk.setForeground(Color.WHITE);
     backk.setCursor(new Cursor(Cursor.HAND_CURSOR));
     backk.setContentAreaFilled(false);
     backk.setOpaque(false);
     add(backk);
	 
     tx1 = new JTextField(20);
     tx1.setSize(400, 50);
	 tx1.setCaretColor(Color.WHITE);
     tx1.setLocation(400, 103);
     tx1.setOpaque(false);
     tx1.setForeground(Color.WHITE);
     tx1.setFont(new Font("Arial", Font.PLAIN, 25));
	 tx1.setBorder(border);
     add(tx1);
	 tx1.setText("Enter Subject");   
     tx1.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(tx1.getText().equals("Enter Subject"))
	     {
		   tx1.setText("");
		   tx1.setForeground(new Color(153,153,153));
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(tx1.getText().equals(""))
	     {
		   tx1.setText("Enter Subject");
		   tx1.setForeground(new Color(153,153,153));
	     }
       }
  	 });
 
	  save = new JButton("Save");
      save.setSize(90, 40);
      save.setLocation(740, 285);
      save.setFont(new Font("Arial", Font.BOLD, 15));
      save.setFocusPainted(false	);
      save.setOpaque(false);
      add(save);
	 
	 
	   
	   year=new JTextField();
	   year.setCaretColor(Color.WHITE);
	   year.setSize(200,50);
       year.setFont(new Font("Arial", Font.BOLD, 20));
	   year.setLocation(10,120);
	   year.setForeground(new Color(153,153,153));
	   year.setOpaque(false);
	   year.setBorder(border);
	   add(year);
	   year.setText("Enter Year");   
       year.addFocusListener(new FocusListener() 
	   {
         public void  focusGained(FocusEvent e)
         {
	       if(year.getText().equals("Enter Year"))
	       {
		     year.setText("");
	         year.setForeground(Color.WHITE);
	       }
         }
         public void focusLost(FocusEvent e)
         {
	       if(year.getText().equals(""))
	       {
		     year.setText("Enter Year");
		     year.setForeground(new Color(153,153,153));
	       }
         }
	   });
  
	   author=new JTextField();
	   author.setCaretColor(Color.WHITE);
	   author.setSize(200,50);
       author.setFont(new Font("Arial", Font.BOLD, 20));
	   author.setLocation(10,190);
	   author.setForeground(new Color(153,153,153));
	   author.setOpaque(false);
	   author.setBorder(border);
	   add(author);
	   author.setText("Enter Devloper name");   
       author.addFocusListener(new FocusListener() 
	   {
         public void  focusGained(FocusEvent e)
         {
	       if(author.getText().equals("Enter Devloper name"))
	       {
		     author.setText("");
	         author.setForeground(Color.WHITE);
	       }
       }
         public void focusLost(FocusEvent e)
         {
	       if(author.getText().equals(""))
 	       {
		   author.setText("Enter Devloper name");
		   author.setForeground(new Color(153,153,153));
	       }
         }
	   });
 
	   lab=new JTextField();
	   lab.setCaretColor(Color.WHITE);
	   lab.setSize(200,50);
       lab.setFont(new Font("Arial", Font.BOLD, 20));
	   lab.setForeground(new Color(153,153,153));
	   lab.setLocation(10,260);
	   lab.setOpaque(false);
	   lab.setBorder(border);
	   add(lab);
	   lab.setText("Enter lab");   
       lab.addFocusListener(new FocusListener() 
	   {
         public void  focusGained(FocusEvent e)
         {
	       if(lab.getText().equals("Enter lab"))
	       {
		      lab.setText("");
	          lab.setForeground(Color.WHITE);
	       }
         }
         public void focusLost(FocusEvent e)
         {
	       if(lab.getText().equals(""))
	       {
		     lab.setText("Enter lab");
		     lab.setForeground(new Color(153,153,153));
	       }
         }
	   });

	   desciption=new JTextArea();
	   desciption.setCaretColor(Color.WHITE);
	   desciption.setSize(550,150);
       desciption.setFont(new Font("Arial", Font.PLAIN, 20));
	   desciption.setLocation(10,330);
	   desciption.setForeground(new Color(153,153,153));
	   desciption.setOpaque(false);
	   desciption.setBorder(border);
	   add(desciption);
	   desciption.setText("Enter Details");   
       desciption.addFocusListener(new FocusListener() 
	   {
         public void  focusGained(FocusEvent e)
         {
	        if(desciption.getText().equals("Enter Details"))
	        {
		      desciption.setText("");
	          desciption.setForeground(Color.WHITE);
	        }
         }
         public void focusLost(FocusEvent e)
         {
	        if(desciption.getText().equals(""))
	        {
		      desciption.setText("Enter Details");
		      desciption.setForeground(new Color(153,153,153));
	        }
         }
	   });
  

	   

  }
}
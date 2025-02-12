import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import javax.swing.event.*;
import java.awt.event.FocusListener;
import java.sql.*;
class insert extends JPanel
{
	JTextArea textarea;
	JButton submit;
	JTextField option1, option2, option3, option4,option5;
  insert()
  {
	 setLayout(null);
	 Border boxBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK); 
	 Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
     Border border = BorderFactory.createLineBorder(Color.BLACK);
	  
	 textarea = new JTextArea();
     textarea.setLineWrap(true);
     textarea.setFont(new Font("Arial", Font.BOLD, 26));
     textarea.setWrapStyleWord(true);
     textarea.setBounds(10, 10, 840, 110);
	 textarea.setBorder(boxBorder);
     add(textarea);
	 textarea.setForeground(Color.GRAY);
	 textarea.setText("Enter Question");   
     textarea.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(textarea.getText().equals("Enter Question"))
	     {
		    textarea.setText("");
		    textarea.setForeground(Color.BLACK);
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(textarea.getText().equals(""))
	     {
		    textarea.setText("Enter Question");
		    textarea.setForeground(Color.GRAY);
	     }
       }
  	 });
	  
	 option1=new JTextField();
	 option1.setSize(200,50);
	 option1.setLocation(50,155);
     option1.setFont(new Font("Arial", Font.BOLD, 20));
     add(option1);
     option1.setForeground(Color.GRAY);
	 option1.setText("Enter Option 1");   
     option1.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(option1.getText().equals("Enter Option 1"))
	     {
		    option1.setText("");
		    option1.setForeground(Color.BLACK);
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(option1.getText().equals(""))
	     {
		    option1.setText("Enter Option 1");
		    option1.setForeground(Color.GRAY);
	     }
       }
  	 });	  
	  
	 option2=new JTextField();
	 option2.setSize(200,50);
     option2.setLocation(50,225);
     option2.setFont(new Font("Arial", Font.BOLD, 20));
	 add(option2);
     option2.setForeground(Color.GRAY);
	 option2.setText("Enter Option 2");   
     option2.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(option2.getText().equals("Enter Option 2"))
	     {
		    option2.setText("");
		    option2.setForeground(Color.BLACK);
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(option2.getText().equals(""))
	     {
		    option2.setText("Enter Option 2");
		    option2.setForeground(Color.GRAY);
	     }
       }
  	 });	 
	  
	  
	 option3=new JTextField();
	 option3.setSize(200,50);
	 option3.setLocation(50,295);
     option3.setFont(new Font("Arial", Font.BOLD, 20));
	 add(option3);
     option3.setForeground(Color.GRAY);
     option3.setText("Enter Option 3");   
     option3.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(option3.getText().equals("Enter Option 3"))
	     {
		    option3.setText("");
		    option3.setForeground(Color.BLACK);
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(option3.getText().equals(""))
	     {
		    option3.setText("Enter Option 3");
		    option3.setForeground(Color.GRAY);
	     }
       }
  	 });	 	  
	  
	 option4=new JTextField();
	 option4.setSize(200,50);
     option4.setLocation(50,365);
     option4.setFont(new Font("Arial", Font.BOLD, 20));
	 add(option4);
	 option4.setForeground(Color.GRAY);
	 option4.setText("Enter Option 4");   
     option4.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(option4.getText().equals("Enter Option 4"))
	     {
		    option4.setText("");
		    option4.setForeground(Color.BLACK);
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(option4.getText().equals(""))
	     {
		    option4.setText("Enter Option 4");
		    option4.setForeground(Color.GRAY);
	     }
       }
  	 });
	 
	 option5=new JTextField();
	 option5.setSize(200,50);
     option5.setLocation(50,435);
     option5.setFont(new Font("Arial", Font.BOLD, 20));
	 add(option5);
	 option5.setForeground(Color.GRAY);
	 option5.setText("Enter Correct_Option");   
     option5.addFocusListener(new FocusListener() 
	 {
       public void  focusGained(FocusEvent e)
       {
	     if(option5.getText().equals("Enter Correct_Option"))
	     {
		    option5.setText("");
		    option5.setForeground(Color.BLACK);
	     }
       }
       public void focusLost(FocusEvent e)
       {
	     if(option5.getText().equals(""))
	     {
		    option5.setText("Enter Correct_Option");
		    option5.setForeground(Color.GRAY);
	     }
       }
  	 });

	 submit=new JButton("Insert");
	 submit.setSize(150,50);
	 submit.setLocation(400,470);
	 submit.setForeground(Color.WHITE);
	 submit.setFont(new Font("Bahnschrift SemiBold Condensed",Font.BOLD,25));
	 submit.setOpaque(false);
	 submit.setFocusPainted(false);
	 submit.setBorderPainted(false);
	 submit.setContentAreaFilled(false);
	 submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 add(submit);
	 submit.addMouseListener(new MouseAdapter()
	 {
        public void mouseEntered(MouseEvent e) 
		{
			submit.setForeground(Color.BLACK);
		}
        public void mouseExited(MouseEvent e) 
		{
			submit.setForeground(Color.WHITE);
		}
     });
  }
  public void paintComponent(Graphics g)
  {
	 super.paintComponent(g);
	 g.setColor(new Color(0,96,114));
     g.fillRoundRect(400,470,150,50,20,20);  
 }
}





// 2.Delete






class delete extends JPanel implements ListSelectionListener 
{
	DefaultListModel<String> listModel;
	JList<String> jl1;
    JScrollPane scrollPane;
    JButton delete;
    managecourse mcourse;	
  delete()
  {
	  setLayout(null);  
	  Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
	  delete=new JButton("Delete");
      delete.setBounds(700, 470, 150, 50);
      delete.setFont(new Font("Arial", Font.BOLD, 25));
	  delete.setFocusPainted(false);  // No focus border
	  delete.setOpaque(false);
	  delete.setContentAreaFilled(false);
	  delete.setFocusPainted(false);
	  delete.setBorderPainted(false);
	  delete.setForeground(Color.WHITE);
      add(delete);
	  delete.addMouseListener(new MouseAdapter()
	  {
          public void mouseEntered(MouseEvent e) 
		  {
			delete.setForeground(Color.BLACK);
		  }
          public void mouseExited(MouseEvent e) 
		  {
			delete.setForeground(Color.WHITE);
		  }
      });
	  delete.addActionListener(e -> deletebutton()); 
	  listModel=new DefaultListModel<>();
	  jl1 = new JList<>(listModel); 
	  jl1.setFont(new Font("Arial", Font.BOLD, 20));
      jl1.setOpaque(false);
      jl1.setLocation(50, 50);
      jl1.setBorder(bottomLineBorder);
      jl1.setVisibleRowCount(3);
	  jl1.setForeground(Color.WHITE);
      add(new JScrollPane(jl1));
      add(jl1);
      jl1.addListSelectionListener(this);     
	 jl1.setCellRenderer(new DefaultListCellRenderer() 
	 {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
		{
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setOpaque(false);
                label.setForeground(Color.WHITE);
				label.setBackground(Color.WHITE);
				label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
				label.setOpaque(isSelected); // Only selected items will appear with background color
                label.setBackground(isSelected ? new Color(227,222,243) : list.getBackground());
                label.setForeground(isSelected ? Color.BLACK : Color.WHITE);
                return label;
        }
     });
	 
     scrollPane = new JScrollPane(jl1);
     scrollPane.setBounds(30, 30, 650, 500);
     scrollPane.setOpaque(false);
     scrollPane.getViewport().setOpaque(false);
     scrollPane.setBorder(null);
     scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
     scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
     add(scrollPane);

     // fetchDataFromDatabase();
    }
   public void fetchDataFromDatabase() 
   {
	   String s1=managecourse.selectedValue;
	  
      try 
	  {
        String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false"; 
        String username = "root"; 
        String password = "root"; 
        Connection connection = DriverManager.getConnection(url, username, password);
        String query = "SELECT question FROM questions WHERE subject='"+s1+"'"; 
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
		listModel.clear();
        while (resultSet.next()) 
		{
           listModel.addElement(resultSet.getString("question"));
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
        String selectedValue = jl1.getSelectedValue();
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
			String s11="delete from questions WHERE question=?";
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
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   g.setColor(new Color(0,96,114));
       g.fillRoundRect(700,470,150,50,20,20);  
   }
}






// 3.update






class update extends JPanel 
{
    DefaultListModel<String> listModel;
    JList<String> jl1;
    JScrollPane scrollPane;
    popuppanel pp;
    managecourse mcourse;	
  update()
  {
	setLayout(null);
	
	mcourse=new managecourse();
	
     listModel = new DefaultListModel<>();
     jl1 = new JList<>(listModel);
     jl1.setFont(new Font("Arial", Font.BOLD, 20));
	 jl1.setOpaque(false);
     jl1.setLocation(50, 50);
     jl1.setVisibleRowCount(3);
     jl1.setForeground(Color.WHITE);
     add(new JScrollPane(jl1));
     add(jl1);
	 
	 pp=new popuppanel();
	 pp.setSize(650,400);
	 pp.setLocation(100,120);
	 pp.setVisible(false);
	 pp.setBackground(Color.BLACK);
	 add(pp);
      
	 scrollPane=new JScrollPane(jl1);
     scrollPane.setBounds(30, 30, 650, 500);
     scrollPane.setOpaque(false);
     scrollPane.getViewport().setOpaque(false);
     scrollPane.setBorder(null);
     scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
     scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
     add(scrollPane);

     jl1.setCellRenderer(new DefaultListCellRenderer() 
	 {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
		{
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setOpaque(false);
            label.setForeground(Color.WHITE);
            label.setBackground(Color.WHITE);
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
            label.setOpaque(isSelected); 
            label.setBackground(isSelected ? new Color(227, 222, 243) : list.getBackground());
            label.setForeground(isSelected ? Color.BLACK : Color.WHITE);
            return label;
        }
    });	
	jl1.addMouseListener(new java.awt.event.MouseAdapter() 
	{
      public void mouseClicked(java.awt.event.MouseEvent evt) 
	  {
        if (evt.getClickCount()==2) 
		{  
            int index = jl1.locationToIndex(evt.getPoint());
            if (index != -1) 
			{ 
                String currentQuestion = listModel.getElementAt(index);
                pp.tx1.setText(currentQuestion);
                pp.options(currentQuestion);    
                pp.setVisible(true);
            }
        }
      }
    });
	
  }
   public void valueChanged(ListSelectionEvent e) 
  {
     if (!e.getValueIsAdjusting()) 
     { 
        String selectedValue = jl1.getSelectedValue();
        if (selectedValue != null)
		{
        }
     }
  }
   public void data() 
   {
	   String s2=mcourse.selectedValue;
        try 
		{
            String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT question FROM questions WHERE subject='"+s2+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            listModel.clear();
            while (resultSet.next()) 
			{
                listModel.addElement(resultSet.getString("question"));
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
}

class popuppanel extends JPanel 
{
    JTextField option1,option2,option3,option4,option5;
    JTextArea tx1;
    JButton update;

    popuppanel() 
    {
        setLayout(null);

        tx1=new JTextArea();
        tx1.setSize(630, 60);
        tx1.setLocation(10, 10);
        tx1.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tx1);

        option1=new JTextField();
        option1.setSize(200, 40);
        option1.setLocation(10, 90);
        add(option1);

        option2=new JTextField();
        option2.setSize(200, 40);
        option2.setLocation(10, 140);
        add(option2);

        option3=new JTextField();
        option3.setSize(200, 40);
        option3.setLocation(10, 190);
        add(option3);

        option4=new JTextField();
        option4.setSize(200, 40);
        option4.setLocation(10, 240);
        add(option4);
        option5=new JTextField();
        option5.setSize(200, 40);
        option5.setLocation(10, 290);
        add(option5);

        update=new JButton("Update");
        update.setSize(150, 50);
        update.setLocation(280, 330);
        update.setFont(new Font("Arial", Font.PLAIN, 25));
		update.setBorderPainted(false);
		update.setFocusPainted(false);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setForeground(Color.WHITE);
        add(update);
		update.addMouseListener(new MouseAdapter()
	    {
          public void mouseEntered(MouseEvent e) 
		  {
			update.setForeground(Color.BLACK);
		  }
          public void mouseExited(MouseEvent e) 
		  {
			update.setForeground(Color.WHITE);
		  }
        });
        update.addActionListener(e -> updateDatabase());
    }

    public void options(String question) 
	{
        try 
		{
            String url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username="root";
            String password="root";
            Connection connection=DriverManager.getConnection(url, username, password);

            String query="SELECT option_a, option_b, option_c, option_d, correct_option FROM questions WHERE question = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, question);
            ResultSet resultSet=statement.executeQuery();

            if(resultSet.next()) 
			{
                option1.setText(resultSet.getString("option_a"));
                option2.setText(resultSet.getString("option_b"));
                option3.setText(resultSet.getString("option_c"));
                option4.setText(resultSet.getString("option_d"));
                option5.setText(resultSet.getString("correct_option"));
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "No options found for the given question.");
            }
            connection.close();
        } 
		catch(Exception e) 
		{
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    private void updateDatabase() 
	{
        try 
		{
            String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "update questions set option_a = ?, option_b = ?, option_c = ?, option_d = ?, correct_option = ? where question = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, option1.getText().trim());
            statement.setString(2, option2.getText().trim());
            statement.setString(3, option3.getText().trim());
            statement.setString(4, option4.getText().trim());
            statement.setString(5, option5.getText().trim());
            statement.setString(6, tx1.getText().trim()); 
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated>0) 
			{
                JOptionPane.showMessageDialog(this, "Options updated successfully!");
				
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "No matching question found to update.");
            }
            connection.close();
        } 
		catch (Exception e) 
		{
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
	public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   g.setColor(new Color(0,96,114));
       g.fillRoundRect(280,330,150,50,20,20);  
   }
}






// 4.view





class view extends JPanel 
{
    DefaultListModel<String> listModel;
    JList<String> jl1;
    JScrollPane scrollPane;
    JLayeredPane layeredPane; // Layered pane to manage stacking
    JPanel popupPanel;
	managecourse mcourse;
  view() 
  {
        setLayout(null);
		
		mcourse=new managecourse();

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600); // Set size to match parent panel
        add(layeredPane);

        listModel = new DefaultListModel<>();
        jl1 = new JList<>(listModel);
        jl1.setFont(new Font("Arial", Font.BOLD, 20));
        jl1.setOpaque(false);
        jl1.setVisibleRowCount(3);
        jl1.setForeground(Color.WHITE);

        scrollPane = new JScrollPane(jl1);
        scrollPane.setBounds(30, 30, 650, 500);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER); // Add scroll pane to the base layer

        jl1.setCellRenderer(new DefaultListCellRenderer() 
		{
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
			{
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setOpaque(false);
                label.setForeground(Color.WHITE);
                label.setBackground(Color.WHITE);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
                label.setOpaque(isSelected);
                label.setBackground(isSelected ? new Color(227, 222, 243) : list.getBackground());
                label.setForeground(isSelected ? Color.BLACK : Color.WHITE);
                return label;
            }
        });

        jl1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
            public void mouseClicked(java.awt.event.MouseEvent evt) 
			{
                int index = jl1.locationToIndex(evt.getPoint());
                if (index != -1) 
				{
                    String question = listModel.getElementAt(index);
                    showPopupPanel(question, evt.getXOnScreen(), evt.getYOnScreen());
                }
            }
        });
		
        
   }
    public void data() 
	{
		String s3=mcourse.selectedValue;
        try 
		{
            String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT question FROM questions WHERE subject='"+s3+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            listModel.clear();
            while (resultSet.next()) 
			{
                listModel.addElement(resultSet.getString("question"));
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
	
    public void showPopupPanel(String question, int x, int y) 
	{
        if (popupPanel != null) 
		{
            layeredPane.remove(popupPanel); // Remove any existing popup
        }
        popupPanel = new JPanel();
        popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.Y_AXIS));
        popupPanel.setBackground(new Color(255, 255, 255, 255)); // Semi-transparent white
        popupPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        popupPanel.setBounds(x - layeredPane.getLocationOnScreen().x, y - layeredPane.getLocationOnScreen().y, 400, 300);

        JLabel questionLabel = new JLabel("<html><b>Question:</b> " + question + "</html>");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setForeground(Color.BLACK);
        popupPanel.add(questionLabel);
        String	[] options = fetchOptionsAndAnswer(question);
        for (int i = 0; i <options.length-1 ; i++) 
		{
            JLabel optionLabel = new JLabel((char) ('A' + i) + ". " + options[i]);
            optionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            optionLabel.setForeground(options[i].equals(options[4]) ? Color.GREEN : Color.BLACK); // Highlight correct option
            popupPanel.add(optionLabel);
        }
        layeredPane.add(popupPanel, JLayeredPane.POPUP_LAYER); // Add popup to the top layer
        layeredPane.revalidate();
        layeredPane.repaint();
		
    }
    public String[] fetchOptionsAndAnswer(String question) 
	{
        String[] options = new String[5]; // 0: A, 1: B, 2: C, 3: D, 4: Correct Answer
        try 
		{
            String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT option_a, option_b, option_c, option_d, correct_option FROM questions WHERE question = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, question);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) 
			{
                options[0] = resultSet.getString("option_a");
                options[1] = resultSet.getString("option_b");
                options[2] = resultSet.getString("option_c");
                options[3] = resultSet.getString("option_d");
                options[4] = resultSet.getString("correct_option");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
        return options;
    }
}

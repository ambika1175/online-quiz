import java.util.ArrayList;
import java.time.Duration;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class course extends JPanel implements ListSelectionListener 
{
    JButton backk, apply, image;
    JLabel text, year, author, lab;
    JTextArea description;
    JScrollPane scrollPane;
    JList<String> jl1; 
    DefaultListModel<String> listModel;

    course() 
	{
        setLayout(null);
        Border bottomLineBorder = BorderFactory.createMatteBorder(0, 1, 0, 1, Color.GRAY);

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
        backk.setToolTipText("Go Back");
        add(backk);

        text = new JLabel();
        text.setSize(700, 100);
        text.setFont(new Font("Arial", Font.BOLD, 34));
        text.setLocation(450, 0);
        text.setForeground(new Color(57, 206, 255));
        add(text);

        year = new JLabel();
        year.setSize(700, 100);
        year.setFont(new Font("Arial", Font.BOLD, 20));
        year.setLocation(340, 90);
        year.setForeground(new Color(255, 94, 174));
        add(year);

        author = new JLabel();
        author.setSize(700, 100);
        author.setFont(new Font("Arial", Font.BOLD, 20));
        author.setLocation(340, 145);
        author.setForeground(new Color(108, 182, 255));
        add(author);

        lab = new JLabel();
        lab.setSize(700, 100);
        lab.setFont(new Font("Arial", Font.BOLD, 20));
        lab.setLocation(340, 205);
        lab.setForeground(Color.WHITE);
        add(lab);

        description = new JTextArea();
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setSize(540, 100);
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setLocation(345, 285);
        description.setForeground(Color.WHITE);
        description.setOpaque(false);
        description.setEditable(false);
        add(description);

        image = new JButton();
        image.setSize(250, 530);
        image.setLocation(465, 27);
        image.setIcon(new ImageIcon("cartoon.png"));
        image.setFocusPainted(false);
        image.setBorderPainted(false);
        image.setForeground(Color.WHITE);
        image.setContentAreaFilled(false);
        image.setOpaque(false);
        image.setToolTipText("Go Back");
        image.setVisible(true);
        add(image);

        apply = new JButton("Apply");
        apply.setBounds(720, 475, 110, 45);
        apply.setBackground(new Color(77, 187, 247));
        apply.setFont(new Font("Arial", Font.BOLD, 20));
        apply.setVisible(false);
        add(apply);

        listModel = new DefaultListModel<>();
        jl1 = new JList<>(listModel);
        jl1.setFont(new Font("Arial", Font.BOLD, 20));
        jl1.setOpaque(false);
        jl1.setSize(300, 500);
        jl1.setLocation(50, 50);
        jl1.setBorder(bottomLineBorder);
        jl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jl1.setVisibleRowCount(3);
        add(new JScrollPane(jl1));
        add(jl1);
        jl1.addListSelectionListener(this);

        jl1.setCellRenderer(new DefaultListCellRenderer() 
		{
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setOpaque(false);
                label.setForeground(Color.BLACK);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
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

        apply.addActionListener(e -> 
	    {
            String subject = text.getText();
            if (!subject.isEmpty()) 
			{
                RequestManager.getInstance().addRequest(subject);
                JOptionPane.showMessageDialog(this, "Request Submitted for: " + subject);
            }
        });
    }
    public void fetchDataFromDatabase()
	{
        try 
		{
            String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username = "root";
            String password = "root";
            Connection con= DriverManager.getConnection(url, username, password);
            String query = "SELECT subjects FROM course";
            PreparedStatement st=con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            listModel.clear();
            while (rs.next()) 
			{
                listModel.addElement(rs.getString("subjects"));
            }
            rs.close();
            st.close();
            con.close();
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
            String selectedSubject = jl1.getSelectedValue();
            if (selectedSubject != null) 
			{
                handleSelection(selectedSubject);
                text.setText(selectedSubject);
                apply.setVisible(true);
                image.setVisible(false);
            }
        }
    }
    public void handleSelection(String selectedSubject) 
	{
        try 
		{
            String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT year, lab, author,details FROM course WHERE subjects = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, selectedSubject);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) 
			{
                year.setText("Year: " + resultSet.getString("year"));
                lab.setText("Lab: " + resultSet.getString("lab"));
                author.setText("Author: " + resultSet.getString("author"));
                description.setText("" + resultSet.getString("details"));
            } 
			else 
			{
                year.setText("Year: ");
                lab.setText("Lab: ");
                author.setText("Author: ");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } 
		catch (Exception e) 
		{
            System.out.println("Error fetching details: " + e.getMessage());
        }
    }
}






class RequestManager 
{
    private static RequestManager instance;
    private ArrayList<RequestItem> requests;

    private RequestManager() 
	{
        requests = new ArrayList<>();
    }

    public static RequestManager getInstance() 
	{
        if (instance == null) 
		{
            instance = new RequestManager();
        }
        return instance;
    }

    public void addRequest(String userName) 
	{
        requests.add(new RequestItem(userName));
    }

    public ArrayList<RequestItem> getRequests() 
	{
        return requests;
    }

    public void removeRequest(RequestItem requestItem) 
	{
        requests.remove(requestItem);
    }
}

 
 
 
 
 
 

class RequestItem 
{
    private String userName;
    private LocalDateTime timestamp;

    public RequestItem(String userName) 
	{
        this.userName = userName;
        this.timestamp = LocalDateTime.now();
    }

    public String getUserName()
	{
        return userName;
    }

    public LocalDateTime getTimestamp() 
	{
        return timestamp;
    }

    public String getTimeAgo() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(timestamp, now);

        long seconds = duration.getSeconds();
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (seconds < 60) {
            return seconds + " seconds ago";
        } else if (minutes < 60) {
            return minutes + " minutes ago";
        } else if (hours < 24) {
            return hours + " hours ago";
        } else {
            return days + " days ago";
        }
    }

    @Override
    public String toString() 
	{
        return userName + " - " + getTimeAgo();
    }
}


 
 
 
 
 

		   // text.setText(" C PROGRAMING !");  
		   // year.setText("Year :- 1972");  
		   // author.setText("Devloper :- Dennis Ritchie");  
		   // lab.setText("Lab :- Bell Laboratories");  
		  // The C programming language is a highly efficient versatile, and powerful language that has shaped  modern software development. 
		   
           // text.setText(" C plus plus");
           // year.setText("Year :- 1979");
		   // author.setText("Devloper :- Bjarne Stroustrup");  
		   // lab.setText("Lab :- AT&T Bell Labs");  
		   // it was only in 1983, that the first version of C++ was released to public It quickly gained popularity among programmers worldwide and was adopted by many.  
		   
    
           // text.setText(" Core Java!");
           // year.setText("Year :- 1995");
		   // author.setText("Devloper :- James Gosling");  
		   // lab.setText("Lab :- Sun Microsystems"); 		    
           // Java was designed with the principle of *Write Once,Run Anywhere*.Java is a widely used object-oriented,Java is known for its simplicity and security features.");  
		  
           // text.setText("Advanced Java!");
		   // year.setText("Java EE (Enterprise Edition)");
		   // author.setText("Spring Framework");
		   // lab.setText("Hibernate Framework");
		   // Java Web Technologies Advanced Java involves a deeper understanding of the language and ecosystem, Dive deeper into Java.");
		  
           // text.setText("Data Structure!");
		   // year.setText("Year :- 1950-1960");
		   // lab.setText("Learn Algorithm");
		   // author.setText("Father :- Don Knuth");
           // The history of data structures is rich and spans many decades.From the early mathematical foundations in 18th century to the modern specialized structures.
          
           // text.setLocation(370,0);
           // text.setText("HyperText Markup Language");
		   // year.setText("Year :- 1989");
		   // author.setText("Devloper :-Tim Berners-Lee");
		   // lab.setText("European Organization");
           // From its humble beginnings in the early 1990s with simple text documents to the feature-rich and powerful HTML5 standard HTML5 standard that we use today.
          
           // text.setText("Cascading Style Sheets");
		   // year.setText("Year :- 1994");
		   // author.setText("Devloper :-Hakon Wium Lie ");
		   // lab.setText("World Wide Web Consortium"); 
           // CSS3 was introduced and developed as a modular different CSS features were broken down into modules CSS will remain a central part of web development.");
         
           // text.setText("JavaScript");
		   // year.setText("Year :- 1995");
		   // author.setText("Devloper :- Brendan Eich ");
		   // lab.setText("Netscape Communications");
		   // JavaScript is a high-level, dynamic programming language that is one of the core technologies of the World Wide Web features like animations, form validation and realtime updates.
         
           // text.setText("Collection Framework");
           // year.setText("Year :- java 1.2 1998");
		   // author.setText("Introduced by :- Java SE");
		   // lab.setText("Lab:- Sun Microsystems");
           // JCF is a unified architecture for storing and manipulating a group of objects.It provides a set of interfaces,classes and algorithms that make it easier to work with data structures.
          
           // text.setText("MySQL");
           // year.setText("Year :- 1995");
		   // author.setText("Devloper :- Michael Widenius");
		   // lab.setText("Company :- MySQL AB"); 
           // MySQL is an open-source Relational Database Management System that use Structured Query Language (SQL) for accessing and managing data.
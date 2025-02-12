import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.border.Border;
class viewresult extends JPanel
{
	JButton backk;
	JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;
	login lg;
	 String email;
	viewresult()
	{
		setLayout(null);
		Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);  // Only display bottom border 
		setLayout(null);
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
		
		tableModel=new DefaultTableModel(); 
		table = new JTable(tableModel);
        table.setRowHeight(35);
	    table.setOpaque(false);
	    table.setBackground(new Color(0,50,74));
	    table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 50, 860, 650); // Set the position and size
	    scrollPane.setBackground(new Color(0,50,74));
	    add(scrollPane);
	
		fetchDataFromDatabase(tableModel);
	}
	public void fetchemail()
	{
		String s1=lg.username.getText();
		try
		{
	    Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject?useSSL=false&user=root&password=root");
        String query = "SELECT email FROM registration WHERE  Name='"+s1+"'";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) 
		{
			   email=rs.getString("email");
		}
		}
	    catch(Exception e1)
		{
			System.out.println(e1);
	    }	
	}
	 public void fetchDataFromDatabase(DefaultTableModel tableModel) 
    {
	  try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
		   String db_uname="root";
		   String db_upass="root";
		   Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
		   Statement st=con.createStatement();
		   
		   String s11="select subject ,totalQ , rightQ , wrongQ from result where uemail='"+email+"' ";
		   ResultSet rs=st.executeQuery(s11);
	       ResultSetMetaData metaData = rs.getMetaData();//isse colomn ke name display horhe
           int columnCount = metaData.getColumnCount();
           String[] columnNames = new String[columnCount];
            for (int i=1;i<=columnCount;i++) 
			{
                columnNames[i-1]=metaData.getColumnName(i);
            }
            tableModel.setColumnIdentifiers(columnNames);
			DefaultTableModel model = new DefaultTableModel(columnNames, 4) 
			{
                public boolean isCellEditable(int row, int column) //ye method table ko non-editable bnati hai
				{
                    return false;
                }
            };
			
			while(rs.next())
			{
				Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) 
				{
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
			}
        }
		catch (Exception e) 
		{
            JOptionPane.showMessageDialog(this, "Error 1175: "+e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class managestudent extends JPanel
{
	JButton backk,delete,view;
	JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;
  managestudent()
  {
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
	
	delete=new JButton("Delete");
	delete.setBounds(700, 10, 130, 40);
    delete.setFont(new Font("Arial", Font.BOLD, 16));
	delete.setFocusPainted(false);  // No focus border
	delete.setBackground(new Color(0,132,196));
	delete.setForeground(Color.WHITE);
    add(delete);
	
	view=new JButton("View Details");
	view.setBounds(540, 10, 130, 40);
    view.setFont(new Font("Arial", Font.BOLD, 16));
	view.setFocusPainted(false);  // No focus border
	view.setBackground(new Color(0,132,196));
	view.setForeground(Color.WHITE);
    add(view);
	
	tableModel=new DefaultTableModel(); 
	// tableModel = new DefaultTableModel(rowData,columnCount) 
	// {
      // public boolean isCellEditable(int row, int column) 
	  // {
        // return false; 
      // }
    // };

    fetchDataFromDatabase(tableModel);
	
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
	
	delete.addActionListener(e -> deletebutton());
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
		   String s11="select Name,contact,email from registration where role='user' ";
		   ResultSet rs=st.executeQuery(s11);
	       ResultSetMetaData metaData = rs.getMetaData();//isse colomn ke name display horhe
           int columnCount = metaData.getColumnCount();
           String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) 
			{
                columnNames[i - 1] = metaData.getColumnName(i);
            }
            tableModel.setColumnIdentifiers(columnNames);
			DefaultTableModel model = new DefaultTableModel(columnNames, 4) 
			{
                public boolean isCellEditable(int row, int column) //ye method table ko noneditanle bnati hai
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
            JOptionPane.showMessageDialog(this, "Error 1175: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	public void deletebutton()
	{
		int selectedRow = table.getSelectedRow();
		if (selectedRow==-1) 
		{
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
	    String email = (String) tableModel.getValueAt(selectedRow, 2); //select colomn se last tk mtlb 3 colom tk sara dat select 
	    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) 
		{
            return;
        }
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
            String db_uname = "root";
            String db_upass = "root";
            Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			String s11="delete from registration WHERE email=?";
			PreparedStatement st = con.prepareStatement(s11);
            st.setString(1, email);
			int rowsAffected=st.executeUpdate();
            if (rowsAffected > 0) 
			{
                JOptionPane.showMessageDialog(this, "Record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                tableModel.removeRow(selectedRow); // apne table se bhi remove krna
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
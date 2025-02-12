import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class request extends JPanel 
{
    JButton backk;
    DefaultListModel<RequestItem> requestModel;
    JList<RequestItem> requestList;
    JScrollPane scrollPane;

    request() 
	{
        setLayout(null);

        backk = new JButton();
        backk.setBounds(0, 0, 55, 40);
        backk.setIcon(new ImageIcon("backk.png"));
        backk.setFocusPainted(false);
        backk.setBorderPainted(false);
        backk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backk.setContentAreaFilled(false);
        backk.setOpaque(false);
        add(backk);

        requestModel = new DefaultListModel<>();
        requestList = new JList<>(requestModel);
        requestList.setCellRenderer(new RequestCellRenderer());
        requestList.setFont(new Font("Arial", Font.PLAIN, 18));
        requestList.setForeground(Color.BLACK);

        scrollPane = new JScrollPane(requestList);
        scrollPane.setBounds(0, 40, 860, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        loadRequests();
    }
   public void loadRequests() 
   {
        requestModel.clear();
        ArrayList<RequestItem> requests = RequestManager.getInstance().getRequests();
        for (RequestItem request : requests) 
		{
            requestModel.addElement(request);
        }
        revalidate();
        repaint();
    }
}

class RequestCellRenderer extends JPanel implements ListCellRenderer<RequestItem> 
{
    JLabel requestLabel;
    JButton acceptButton, ignoreButton;

    public RequestCellRenderer() 
	{
        setLayout(new BorderLayout(10, 10));
        setOpaque(true);

        requestLabel = new JLabel();
        requestLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(requestLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        acceptButton = new JButton("Accept");
        acceptButton.setFont(new Font("Arial", Font.BOLD, 14));
        acceptButton.setBackground(new Color(77, 187, 247));
        acceptButton.setForeground(Color.WHITE);
        buttonPanel.add(acceptButton);

        ignoreButton = new JButton("Ignore");
        ignoreButton.setFont(new Font("Arial", Font.BOLD, 14));
        ignoreButton.setBackground(new Color(255, 94, 94));
        ignoreButton.setForeground(Color.WHITE);
        buttonPanel.add(ignoreButton);

        add(buttonPanel, BorderLayout.EAST);
    }
  public Component getListCellRendererComponent(JList<? extends RequestItem> list, RequestItem value, int index, boolean isSelected, boolean cellHasFocus) 
  {
        requestLabel.setText(value.toString());
        acceptButton.addActionListener(e -> 
		{
            JOptionPane.showMessageDialog(list, "Request Accepted: " + value.getUserName());
            RequestManager.getInstance().removeRequest(value);
            ((DefaultListModel<RequestItem>) list.getModel()).remove(index);
        });

        ignoreButton.addActionListener(e ->
		{
            JOptionPane.showMessageDialog(list, "Request Ignored: " + value.getUserName());
            RequestManager.getInstance().removeRequest(value);
            ((DefaultListModel<RequestItem>) list.getModel()).remove(index);
        });

        setBackground(isSelected ? new Color(230, 230, 250) : Color.WHITE);
        return this;
 }
}

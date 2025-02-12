import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.io.*;
import javax.swing.border.Border;
import java.time.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class help extends JPanel 
{
    JButton backk, send,more;
    JLabel text, uppertext;
    JButton[] questionButtons = new JButton[11];
    JTextField message;
    ImageIcon i,i2;
    Image im,im2;
    JPanel chatPanel;
    JScrollPane chatScrollPane;
    HashMap<String, String> chatbotData;
    String text1 = "How Can I Help With?";
    int x = 0;
	JPopupMenu popupMenu;
	JMenuItem clearchat,report;
	ChildPanel child;
	Timer timer;
    help() 
	{
        setLayout(null);
        setBackground(Color.WHITE);
        i = new ImageIcon("dp.png");
        im = i.getImage();
		
		child=new ChildPanel();

        backk = new JButton();
        backk.setSize(55, 50);
        backk.setLocation(450, 0);
        backk.setIcon(new ImageIcon("backk.png"));
        backk.setFocusPainted(false);
        backk.setBorderPainted(false);
        backk.setForeground(Color.WHITE);
        backk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backk.setContentAreaFilled(false);
        backk.setOpaque(false);
        add(backk);
		
		more=new JButton();
        more.setSize(38, 38);
        more.setLocation(1230, 0);
        more.setIcon(new ImageIcon("more.png"));
        more.setFocusPainted(false);
        more.setBorderPainted(false);
        more.setCursor(new Cursor(Cursor.HAND_CURSOR));
        more.setContentAreaFilled(false);
        more.setOpaque(false);
        add(more);


        uppertext = new JLabel("Mr.Helper");
        uppertext.setBounds(510, 1, 200, 30);
        uppertext.setHorizontalAlignment(SwingConstants.LEFT);
        uppertext.setVerticalAlignment(SwingConstants.TOP);
        uppertext.setFont(new Font("Arial", Font.PLAIN, 30));
        uppertext.setForeground(Color.WHITE);
        add(uppertext);

        text = new JLabel();
        text.setBounds(550, 295, 1500, 60);
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.TOP);
        text.setFont(new Font("Arial", Font.PLAIN, 40));
        text.setForeground(Color.BLACK);
        add(text);
		
		popupMenu = new JPopupMenu();
		popupMenu.setBackground(new Color(0,26,51));
        
		clearchat= new JMenuItem("Clear Chat");
		clearchat.setBackground(new Color(0,26,51));
		clearchat.setSize(100,100);
		clearchat.setForeground(Color.WHITE);
		
		report= new JMenuItem("Report");
		report.setBackground(new Color(0,26,51));
		report.setForeground(Color.WHITE);
		report.setSize(100,100);
		popupMenu.setSize(400,400);
		
		popupMenu.add(clearchat);
		popupMenu.add(report);
		more.addActionListener(e -> 
		{
            popupMenu.show(more, more.getWidth() / 2, more.getHeight());
        });
        clearchat.addActionListener(e -> 
		{
          chatPanel.removeAll(); // Remove all chat messages from the panel
          chatPanel.revalidate(); // Revalidate to update the UI
          chatPanel.repaint(); // Repaint to reflect changes visually
		  timer.start();
        });
		 
		String[] questions= 
		{
            "Exam page is not open", 
            "How to reset password", 
            "Can I change my password?", 
            "How do I start an examination?", 
            "Can I pause the exam and continue later?", 
            "How is my time monitored during the exam?", 
            "Can I review or change my answers before submitting?", 
            "The exam page is not loading. What should I do?", 
            "How can I view my exam results?", 
            "Is there a technical support team?",
			"what's time now?"
        };
		for (int i = 0; i < questionButtons.length; i++) 
		{
            questionButtons[i] = new JButton(questions[i]);
            questionButtons[i].setSize(400, 40);
            questionButtons[i].setLocation(10, 10 + (i*55));
            questionButtons[i].setBackground(Color.BLACK);
            questionButtons[i].setFont(new Font("Arial", Font.PLAIN, 15));
            questionButtons[i].setForeground(Color.WHITE);
            int bindex = i; 
            questionButtons[i].addActionListener(e -> handlePredefinedQuestion(questions[bindex]));
            add(questionButtons[i]);
        }

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBackground(new Color(184, 184, 184));

        chatScrollPane = new JScrollPane(chatPanel);
        chatScrollPane.setBounds(450, 40, 837, 555);
        chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        chatScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        chatScrollPane.setOpaque(false);
        add(chatScrollPane);

        message = new RoundedTextField(50,50);
        message.setBackground(new Color(207, 230, 239));
        message.setBounds(455, 593,750, 50);
        message.setFont(new Font("Arial", Font.PLAIN, 18));
        add(message);

        send = new JButton();
        send.setBounds(1211, 596, 50, 50);
        send.setFont(new Font("Arial", Font.BOLD, 18));
        send.setForeground(Color.WHITE);
        send.setCursor(new Cursor(Cursor.HAND_CURSOR));
        send.setIcon(new ImageIcon("send.png"));
        send.setFocusPainted(false);
        send.setBorderPainted(false);
		send.setOpaque(false);
		send.setContentAreaFilled(false);
        add(send);

        loadChatbotData("chatbot_data.csv");

        send.addActionListener(e -> handleUserInput());
        message.addActionListener(e -> handleUserInput());
    }
   private void loadChatbotData(String filePath) 
	{
        chatbotData=new HashMap<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))) 
		 {
            String line;
            br.readLine(); // Skip first line
            while ((line = br.readLine())!=null) 
			{
                String[] parts = line.split(",", 2);
                if (parts.length == 2) 
				{
                    chatbotData.put(parts[0].toLowerCase().trim(), parts[1].trim());
                }
            }
         } 
		catch(IOException e) 
		 {
            JOptionPane.showMessageDialog(this, "Error loading chatbot data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
    }
   private void handlePredefinedQuestion(String question)
	{
        addMessage("You: " + question, true);
		String response;
       if (question.equalsIgnoreCase("what's time now?") || question.equalsIgnoreCase("what is the time now?")) 
	   {
          java.time.LocalDateTime currentTime = java.time.LocalDateTime.now();
          java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("hh:mm a");
          response = "The current time is " + currentTime.format(formatter) + ".";
       } 
	   else 
	   {
          response = chatbotData.getOrDefault(question.toLowerCase(), "Sorry, I don't understand that.");
       }
       addMessage("Bot: " + response, false);
    }
   private void handleUserInput() 
   {
      String userText = message.getText().trim();
      if (!userText.isEmpty()) 
	  {
        addMessage("You: " + userText, true); // User message
        text.setVisible(false);
        String response;
        if (userText.equalsIgnoreCase("what's time now?") || userText.equalsIgnoreCase("what is the time now?")) 
		{
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            response = "The current time is " + currentTime.format(timeFormatter) + ".";
        } 
		else if (userText.equalsIgnoreCase("what is the date today?") || userText.equalsIgnoreCase("what's the date?")) 
		{
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            response = "Today's date is " + currentDate.format(dateFormatter) + ".";
        } 
		else 
		{
            response = chatbotData.getOrDefault(userText.toLowerCase(), "Sorry, I don't understand that.");
        }
        addMessage("Bot: " + response, false); // Bot response
        message.setText(""); // Clear input field
      }
   }
   private void addMessage(String messageText, boolean isUser) 
   {
		JLabel messageLabel = new JLabel();
		messageLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		messageLabel.setOpaque(true);
		messageLabel.setBackground(isUser ? new Color(0, 202, 101) : new Color(64, 64, 64));
		messageLabel.setForeground(isUser ? Color.BLACK : Color.WHITE);
		messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 10));

		JPanel messagedisplay = new JPanel();
		messagedisplay.setLayout(new BoxLayout(messagedisplay, BoxLayout.X_AXIS));
		messagedisplay.setOpaque(false);

		if (isUser) 
		{              
			messagedisplay.setAlignmentX(Component.LEFT_ALIGNMENT);
			messagedisplay.add(Box.createHorizontalGlue());
			messagedisplay.add(messageLabel);
			messageLabel.setText("<html><p style='width:300px;'>" + messageText + "</p></html>");
            text.setVisible(false);	
		} 
		else 
		{
			messagedisplay.setAlignmentX(Component.RIGHT_ALIGNMENT);
			messagedisplay.add(Box.createHorizontalGlue());
			messagedisplay.add(messageLabel);
		}
          timer=new Timer(30,new ActionListener() 
		 {
            int index=0;
            public void actionPerformed(ActionEvent e) 
			{
                if (index<messageText.length()) 
				{
                    messageLabel.setText("<html><p style='width: 300px;'>" +messageText.substring(0, index + 1)+ "</p></html>");
                    index++;
                } 
				else 
				{
                    ((Timer)e.getSource()).stop();
                }
            }
         });
         timer.start();
        
	   	chatPanel.add(messagedisplay);
		chatPanel.add(Box.createVerticalStrut(5)); // message ke bich space
		chatPanel.revalidate();
		SwingUtilities.invokeLater(() -> chatScrollPane.getVerticalScrollBar().setValue(chatScrollPane.getVerticalScrollBar().getMaximum()));
    }
   public void startAnimation() //ye how can i help you bale ka timer hai
	{
        Timer timer = new Timer(100, new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
			{
                if (x < text1.length()) 
				{
                    text.setText(text1.substring(0, x + 1));
                    x++;
                } 
				else 
				{
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
   public void paintComponent(Graphics g) 
   {
	   super.paintComponent(g);
	   g.drawImage(im,550,1,this);
       g.setColor(Color.DARK_GRAY);
       g.fillRect(0, 0, 1500, 1100);
       g.setColor(new Color(0,26,51));
       g.fillRect(445,0,850,850);
	   g.setColor(new Color(0,202,101));
	   g.fillOval(1210,595,50,50);
    }
}

class RoundedTextField extends JTextField {
    private int arcWidth;
    private int arcHeight;

    public RoundedTextField(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Enable custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill background with rounded rectangle
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Draw border
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void setBorder(Border border) {
        // Override to prevent external border setting
    }
}

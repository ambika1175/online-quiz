import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.Timer.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.HashMap;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Map;
class exam extends JPanel implements ListSelectionListener
{
    JTextField tx1;
	JButton select,backk;
	ImageIcon i;
	Image im;
	JScrollPane scrollPane;
	JList<String> jl1; // Changed to JList<String>
    DefaultListModel<String> listModel; // To hold data from database

	
   exam()
   {
	    
      setLayout(null);
	  i=new ImageIcon("examcartoon.png");
	  im=i.getImage();
	  Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK); 
      Border border = BorderFactory.createLineBorder(Color.BLACK);	  
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
	  
	  select= new JButton("Select");
	  select.setSize(90,40);
	  select.setLocation(740,285);
	  select.setFont(new Font("Arial", Font.BOLD, 15));
	  select.setFocusPainted(false);  // No focus border
	  select.setOpaque(false);
	  select.setBorder(border);
	  add(select);
	  
	  tx1=new JTextField(20);
	  tx1.setSize(400,50);
	  tx1.setLocation(400,203);
	  tx1.setOpaque(false);
	  tx1.setForeground(Color.GRAY);
	  tx1.setFont(new Font("Arial", Font.PLAIN, 25));
	  tx1.setBorder(border);
      add(tx1);	
	  
	 listModel = new DefaultListModel<>(); 
     jl1 = new JList<>(listModel); 
     jl1.setFont(new Font("Arial", Font.BOLD, 20));
     jl1.setOpaque(false);
     jl1.setSize(300, 500);
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
    }
   public void fetchDataFromDatabase() 
   {
	   String s =tx1.getText(); 
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
        String selectedValue = jl1.getSelectedValue();
        if (selectedValue != null)
		{
			tx1.setText(selectedValue);
        }
     }
  }
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im,345,0,this);
	    g.setFont(new Font("Arial", Font.PLAIN, 40));
	    g.setColor(Color.WHITE);
		g.drawString("Select Subject !",510,160);
	}
}






class exam2 extends JPanel ////rules
{
   JButton backk,examstart;
   JLabel hinditext;
   ImageIcon i;
	Image im;
  exam2() 
  {	
	setLayout(null);
    JPanel rulesPanel = new JPanel() 
	{
		{
		setLayout(null);
		setBackground(new Color(225,239,242));
		backk = new JButton();
        backk.setSize(55, 50);
        backk.setLocation(0, 0);
		backk.setIcon(new ImageIcon("backk.png"));
		backk.setFocusPainted(false);  // No focus border
		backk.setBorderPainted(false); // Remove line bg
		backk.setForeground(Color.WHITE); // Text color
		backk.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		backk.setContentAreaFilled(false); // No button background
		backk.setOpaque(false);
		add(backk);
		
	    examstart=new JButton("Start Exam");
	    examstart.setSize(150,50);
	    examstart.setLocation(1080,900);
	    examstart.setBackground(Color.DARK_GRAY);
	    examstart.setForeground(new Color(77,187,247));
	    examstart.setFont(new Font("Arial", Font.BOLD, 22));
        examstart.setFocusPainted(false);	
	    add(examstart);
		
		
		}
     public void paintComponent(Graphics g) 
	 {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Rules of exam", 500, 90);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Time Limit :", 5, 150);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("The exam is typically timed, and students must complete the test within the allocated duration.", 106, 150);
        g.drawString("There will be a countdown timer or other indicators showing how much time is remaining.", 5, 180);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Disabling of Navigation :", 5, 230);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Some exams may restrict navigation (e.g., preventing going back to a previous question once it's submitted)", 235, 230);
        g.drawString("or disable copy-paste functionality.", 5, 260);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Secure Browser :", 5, 310);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("In some cases, the online exam may use a secure browser that prevents opening other applications, tabs, or websites ", 170, 310);
        g.drawString("during the exam.", 5, 340);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Proctoring :", 5, 390);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Some online exams may involve proctoring (either live or recorded) to monitor candidates. This can include:", 116, 390);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(".", 14, 427);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Webcam Monitoring:", 30, 430);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("A webcam may be used to monitor the student during the exam, ensuring that no unauthorized materials or persons ", 230, 430);
        g.drawString("are present.",14,460);
		
		g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(".", 14, 487);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Screen Recording :", 30, 490);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Some exams use screen recording software to track what is happening on the student's device during the exam.", 200, 490);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(".", 14, 527);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Microphone Monitoring:", 30, 530);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("In some cases, audio is recorded to detect any suspicious sounds (e.g., multiple people talking.)", 260, 530);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(".", 14, 567);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("AI Monitoring:", 30, 570);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Some exams use AI-based monitoring tools to detect suspicious behavior (e.g., frequent head movements, multiple faces in", 171, 570);
        g.drawString(" the frame).",30,600);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("No Communication:", 5, 650);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Candidates must not communicate with others during the exam. Use of any external devices (phones, tablets, etc.) for", 195, 650);
        g.drawString("communication is prohibited.", 5, 680);
		
        g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Flagged Responses :",5,730);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("The system may flag irregularities, such as rapid switching between tabs or copying/pasting answers, which could lead to",200,730);
	    g.drawString("disqualification.",5,760);
		
        g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Honesty in Responses :",5,810);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
	    g.drawString("You must answer questions based on your own knowledge and avoid any form of dishonest assistance.",230,810);
	  
	    g.setFont(new Font("Arial", Font.BOLD, 26));
        g.drawString("Your honesty is reflected in your actions.",380,870);
	  
	  }
      public Dimension getPreferredSize() 
	  {
        return new Dimension(1500, 1200);  
      }};
      JScrollPane scrollPane = new JScrollPane(rulesPanel);
      scrollPane.setBounds(0, 0, 1300, 900);
	  add(scrollPane);
	}
}






class exam3 extends JPanel //exam page where question option displayed
{
    JButton next, previous, submit,back;
    JButton[] buttons = new JButton[30];
    JLabel qn1, timer1;
    JTextArea textarea;
    JRadioButton option1, option2, option3, option4;
    Timer timer;
    int currentQuestionIndex = 1; // Start with question 1
    Connection conn;
    int time[] = {0, 0, 0};
    int x1 = 851, y1 = 100, buttonW = 84, buttonH = 64;
	static StringBuilder examcourse=new StringBuilder();
	static StringBuilder examcourse1=new StringBuilder();
	static int score=0;
	
	String correctans="";
    exam3() 
	{
        setLayout(null);
        setBackground(Color.GRAY);

        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setFont(new Font("Arial", Font.BOLD, 26));
        textarea.setWrapStyleWord(true);
        textarea.setBounds(10, 45, 840, 130);
        textarea.setEditable(false);
        textarea.setOpaque(false);
        add(textarea);

        timer1 = new JLabel("00:00:00");
        timer1.setFont(new Font("Arial", Font.BOLD, 26));
        timer1.setSize(150, 30);
        timer1.setLocation(1035, 10);
        timer1.setForeground(Color.GRAY);
        add(timer1);

        qn1 = new JLabel("Question 1");
        qn1.setSize(200, 40);
        qn1.setLocation(10, 1);
        qn1.setForeground(Color.GRAY);
        qn1.setFont(new Font("Arial", Font.BOLD, 24));
        add(qn1);

        option1 = createOptionButton("Option A", 50, 200);
        option2 = createOptionButton("Option B", 50, 250);
        option4 = createOptionButton("Option D", 50, 350);
        option3 = createOptionButton("Option C", 50, 300);
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);
		
		back = new JButton();
        back.setSize(55, 50);
        back.setLocation(850, 1);
        back.setIcon(new ImageIcon("backk.png"));
        back.setFocusPainted(false); // No focus border
        back.setBorderPainted(false); // for removing line bg
        back.setForeground(Color.WHITE); // Text color
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false); // No button background
        back.setOpaque(false);
        add(back);	

        submit=new JButton("Submit");
        submit.setSize(100,40);
        submit.setLocation(1150,600);
        submit.setFocusPainted(false);
        add(submit);		

        next = new JButton();
        next.setSize(90, 90);
        next.setLocation(680, 500);
        next.setFocusPainted(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setContentAreaFilled(false);
        next.setOpaque(false);
        next.setIcon(new ImageIcon("nextimg.png"));
        next.setBorderPainted(false);
        add(next);
        next.addActionListener(e -> {
            loadQuestion(++currentQuestionIndex);
            updateButtonBackground();
			String selectedAnswer = getSelectedOptionText();
			if(selectedAnswer!=null&&selectedAnswer.equals(correctans))
			{
				score++;
				System.out.println(score);
			}
        });

        previous = new JButton();
        previous.setSize(90, 90);
        previous.setLocation(30, 500);
        previous.setFocusPainted(false);
        previous.setBorderPainted(false);
        previous.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previous.setContentAreaFilled(false);
        previous.setOpaque(false);
        previous.setIcon(new ImageIcon("priviousimg.png"));
        add(previous);
        previous.addActionListener(e -> {
            loadQuestion(--currentQuestionIndex);
            updateButtonBackground();
        });

        for (int i = 0; i < buttons.length; i++) 
		{
            buttons[i] = new JButton("" + (i + 1));
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setFocusPainted(false);
            int row = i / 5;
            int col = i % 5;
            int x = x1 + col * buttonW;
            int y = y1 + row * buttonH;
            buttons[i].setBounds(x, y, buttonW, buttonH);
            add(buttons[i]);
            final int index = i + 1;
            buttons[i].addActionListener(e -> {
                JButton bt = (JButton) e.getSource();
                bt.setBackground(Color.GREEN);
                loadQuestion(index);
                updateButtonBackground();
                bt.setContentAreaFilled(true);
            });
        }

        ActionListener actionListener = e -> 
		{
            time[2]++;
            if (time[2] == 60)
			{
                time[2] = 0;
                time[1]++;
            }
            if (time[1] == 60) 
			{
                time[1] = 0;
                time[0]++;
            }
            if (time[1] >= 10) 
			{
                JOptionPane.showMessageDialog(null, "Time out", "Information", JOptionPane.WARNING_MESSAGE);
                time[0] = 0;
                time[1] = 0;
                time[2] = 0;
            }
            String formattedTime = String.format("%02d:%02d:%02d", time[0], time[1], time[2]);
            timer1.setText(formattedTime);
        };
        timer = new Timer(1000, actionListener);
        timer.start();
    }

    private JRadioButton createOptionButton(String text, int x, int y) 
	{
        JRadioButton button = new JRadioButton(text);
        button.setSize(300, 50);
        button.setFont(new Font("Arial", Font.PLAIN, 25));
        button.setLocation(x, y);
        button.setFocusPainted(false);
        button.setOpaque(false);
        add(button);
        return button;
    }
    String getSelectedOptionText() 
	{
    if (option1.isSelected()) {
        return option1.getText();
    } else if (option2.isSelected()) {
        return option2.getText();
    } else if (option3.isSelected()) {
        return option3.getText();
    } else if (option4.isSelected()) {
        return option4.getText();
    } else {
        return null; // No option selected
    }
}
      void loadQuestion(int index) 
		{
		try 
		{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject?useSSL=false&user=root&password=root");
            if (index <= 0) 
			{
                currentQuestionIndex=index= 1;
                JOptionPane.showMessageDialog(this, "This is the first question!", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String query = "SELECT * FROM questions WHERE id=? AND subject=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
			FDemo.examsubject.delete(0,FDemo.examsubject.toString().length());
			FDemo.examsubject.append(examcourse.toString());
            pstmt.setInt(1, index);
            pstmt.setString(2,examcourse.toString()); // Replace with dynamic subject if needed
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) 
			{
                qn1.setText("Question " + index);
                textarea.setText(rs.getString("question"));
                option1.setText(rs.getString("option_a"));
                option2.setText(rs.getString("option_b"));
                option3.setText(rs.getString("option_c"));
                option4.setText(rs.getString("option_d"));
			    correctans=rs.getString("correct_option");
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "No more questions!", "Info", JOptionPane.INFORMATION_MESSAGE);
                if (index >= currentQuestionIndex) currentQuestionIndex--;
                else currentQuestionIndex++;
            }
            pstmt.close();
            updateButtonBackground();
        } 
		catch (SQLException e)
		{
            e.printStackTrace();
        }
    }
	

    private void updateButtonBackground() 
	{
        for (int i = 0; i < buttons.length; i++) 
		{
            if (i + 1 == currentQuestionIndex)
			{
                buttons[i].setBackground(Color.GREEN); // Highlight the active button
            } 
			else 
			{
                buttons[i].setBackground(null); // Reset other buttons
            }
        }
    }

    public void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        g.setColor(new Color(230, 241, 242));
        g.fillRoundRect(1, 1, 850, 653, 20, 20);
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, 850, 40);
        g.setColor(Color.BLACK);
        g.fillRect(1021, 6, 128, 38); // Timer box
    }
}



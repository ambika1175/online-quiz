import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

class forgetpass extends JPanel {
    JLabel username, otp, statusLabel;
    JTextField username1, otp1;
    JButton sendOtpButton, verifyOtpButton;
    String generatedOtp;

    forgetpass() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        Border bottomLineBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);

        // Username Label and Field
        username = new JLabel("Username");
        username.setBounds(420, 185, 200, 100);
        username.setFont(new Font("Arial", Font.PLAIN, 17));
        username.setForeground(Color.CYAN);
        add(username);

        username1 = new JTextField(25);
        username1.setBounds(420, 250, 370, 35); // (x, y, w, h)
        username1.setBorder(bottomLineBorder);
        username1.setOpaque(false);
        username1.setForeground(Color.WHITE);
        username1.setFont(new Font("Arial", Font.PLAIN, 21));
        add(username1);

        // OTP Label and Field
        otp = new JLabel("Enter Code");
        otp.setBounds(420, 265, 200, 100);
        otp.setFont(new Font("Arial", Font.PLAIN, 17));
        otp.setForeground(Color.CYAN);
        add(otp);

        otp1 = new JTextField(25);
        otp1.setBounds(420, 330, 370, 35); // (x, y, w, h)
        otp1.setBorder(bottomLineBorder);
        otp1.setOpaque(false);
        otp1.setForeground(Color.WHITE);
        otp1.setFont(new Font("Arial", Font.PLAIN, 21));
        add(otp1);

        // Send OTP Button
        sendOtpButton = new JButton("Send OTP");
        sendOtpButton.setBounds(420, 400, 150, 35);
        sendOtpButton.setBackground(Color.CYAN);
        sendOtpButton.setForeground(Color.BLACK);
        sendOtpButton.setFont(new Font("Arial", Font.BOLD, 15));
        add(sendOtpButton);

        // Verify OTP Button
        verifyOtpButton = new JButton("Verify OTP");
        verifyOtpButton.setBounds(620, 400, 150, 35);
        verifyOtpButton.setBackground(Color.GREEN);
        verifyOtpButton.setForeground(Color.BLACK);
        verifyOtpButton.setFont(new Font("Arial", Font.BOLD, 15));
        add(verifyOtpButton);

        // Status Label
        statusLabel = new JLabel("");
        statusLabel.setBounds(420, 450, 400, 50);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        statusLabel.setForeground(Color.RED);
        add(statusLabel);

        // Button Actions
        sendOtpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernameText = username1.getText();
                if (usernameText.isEmpty()) {
                    statusLabel.setText("Username cannot be empty!");
                    return;
                }

                String email = getEmailForUsername(usernameText); // Replace with real DB logic
                if (email != null) {
                    generatedOtp = generateOtp(6);
                    sendOtpToEmail(email, generatedOtp);
                    statusLabel.setText("OTP sent to registered email!");
                } else {
                    statusLabel.setText("Username not found!");
                }
            }
        });

        verifyOtpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredOtp = otp1.getText();
                if (generatedOtp != null && generatedOtp.equals(enteredOtp)) {
                    statusLabel.setText("OTP verified! You can reset your password.");
                } else {
                    statusLabel.setText("Invalid OTP. Please try again.");
                }
            }
        });
    }

    // Method to Generate OTP
    private String generateOtp(int length) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    // Simulated Database Query for Email Retrieval
    private String getEmailForUsername(String username) {
        // Simulate a database lookup (Replace this with real database code)
        if (username.equalsIgnoreCase("testuser")) {
            return "testuser@example.com";
        }
        return null;
    }

    // Method to Send OTP via Email
    private void sendOtpToEmail(String toEmail, String otp) {
        final String fromEmail = "your_email@gmail.com"; // Replace with your email
        final String password = "your_password";        // Replace with your app password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your OTP Code");
            message.setText("Your OTP code is: " + otp);

            Transport.send(message);
            System.out.println("OTP sent successfully to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
            statusLabel.setText("Failed to send OTP. Check email settings.");
        }
    }

}
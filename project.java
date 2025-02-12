import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
class FDemo extends JFrame implements ActionListener
{
	        JPanel panel = new JPanel();
			ImageIcon customIcon = new ImageIcon("about.png");
	Container cn=getContentPane();
	CardLayout card;
	about ab;
	home hm;
	login lg;
	registration rg;
	usermenu um;
	ChildPanel cp;
    editprofile ep;
	course c;
	viewresult vr;
	exam ex;
	certificate cf;
	changepass cpass;
	help hp;
	exam2 ex2;
	exam3 ex3;
	adminchild adcp;
	admin ad;
	forgetpass fp;
	manageadmin ma;
	managestudent ms;
	managecourse mcourse;
	managequestions mq;
	addcourse addcourse;
	insert in;
	delete del;
	update up;
	view vi;
	request req;
	popuppanel pp;
  static String email;
	static StringBuilder examsubject=new StringBuilder();
	FDemo()
	{
		card= new CardLayout();

		setLayout(card);
		hm=new home();
		add("hm",hm);
		hm.about.addActionListener(this);
		hm.next.addActionListener(this);
		ab=new about();
		add("ab",ab);
		ab.back.addActionListener(this);
		lg=new login();
		add("lg",lg);
		lg.signin.addActionListener(this);
		lg.login.addActionListener(this);
		rg=new registration();
		add("rg",rg);
		ad=new admin();
		add("ad",ad);
		fp=new forgetpass();
		add("fp",fp);
		mq=new managequestions();
		add("mq",mq);
		rg.back.addActionListener(this);
		lg.back.addActionListener(this);
		rg.register.addActionListener(this);
		um=new usermenu();
		add("um",um);	
		ex2=new exam2();
		add("ex2",ex2);
		ex3=new exam3();
		add("ex3",ex3);
		cp=um.cp;
		vr=um.vr;
		ex=um.ex;
		cf=um.cf;
		hp=new help();
		add("hp",hp);
		ep=um.ep;
		c=um.c;
		
		adcp=ad.adcp;
		ma=ad.ma;
		ms=ad.ms;
		cpass=ad.cpass;
		mcourse=ad.mcourse;
		req=ad.req;
		addcourse=ad.addcourse;
		in=mq.in;
		del=mq.del;
		up=mq.up;
		vi=mq.vi;
		pp=up.pp;
		
	    lg.forgetpassword.addActionListener(this);
		cp.editprofile.addActionListener(this);
		cp.course.addActionListener(this);
		cp.exam.addActionListener(this);
		cp.result.addActionListener(this);
		cp.certificate.addActionListener(this);
		cp.help.addActionListener(this);
		cp.logout.addActionListener(this);
		vr.backk.addActionListener(this);
		ep.backk.addActionListener(this);
		ep.change.addActionListener(this);
		c.backk.addActionListener(this);
		c.apply.addActionListener(this);
		ex.backk.addActionListener(this);
		ex.select.addActionListener(this);
		cf.backk.addActionListener(this);
		hp.backk.addActionListener(this);
		cpass.backk.addActionListener(this);
		cpass.add.addActionListener(this);
		ex2.backk.addActionListener(this);
		ex3.back.addActionListener(this);
		ex3.submit.addActionListener(this);
		ex2.examstart.addActionListener(this);
		ep.profile.addActionListener(this);
		adcp.logout.addActionListener(this);
		adcp.manageadmin.addActionListener(this);
		adcp.managestudent.addActionListener(this);
		adcp.managecourse.addActionListener(this);
		adcp.request.addActionListener(this);
		adcp.changepass.addActionListener(this);
		
	    ma.backk.addActionListener(this);
	    ma.add.addActionListener(this);
	    ms.backk.addActionListener(this);
	    mcourse.managequestions.addActionListener(this);
	    mcourse.backk.addActionListener(this);
	    req.backk.addActionListener(this);
	    addcourse.save.addActionListener(this);
	    addcourse.backk.addActionListener(this);
		mcourse.addbutton.addActionListener(this);
		mq.backk.addActionListener(this);
		mq.insert.addActionListener(this);
		mq.delete.addActionListener(this);
		mq.update.addActionListener(this);
		mq.view.addActionListener(this);
		
		in.submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==hm.about)
		{
			card.show(cn,"ab");
		}
		if(e.getSource()==hm.next)
		{
			card.show(cn,"lg");
		}
		if(e.getSource()==ab.back)
		{
			card.show(cn,"hm");
		}
		if(e.getSource()==lg.signin)
		{
			card.show(cn,"rg");
		}
		if(e.getSource()==rg.back)
		{
			card.show(cn,"lg");
		}
		if(e.getSource()==lg.back)
		{
			card.show(cn,"hm");
		}
		
		if(e.getSource()==rg.register)
		{
			String s1=rg.fn.getText();
			String s2=rg.ln.getText();
			String s=s1+" "+s2;
			char[] s33=rg.passwordf.getPassword(); // Get password as char[]
            String s3=new String(s33);// Convert char[] to String if necessary
            String s4=rg.contactf.getText();
			String s5=rg.emailf.getText();
		   if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
		 {
			UIManager.put("OptionPane.background", new Color(0,135,200));
            UIManager.put("Panel.background",Color.WHITE); 
            UIManager.put("OptionPane.messageForeground", new Color(57,57,57)); 
			JLabel label = new JLabel("Field is empty", JLabel.CENTER);
            label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
          JOptionPane.showMessageDialog(null,label,"Oops!",JOptionPane.WARNING_MESSAGE);
		 }	
		 else
		 {
		  try
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
			  String db_uname="root";
			  String db_upass="root";
			  Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
			  Statement st=con.createStatement();
			  String s11="insert into registration values('"+s+"','"+s3+"','"+s4+"','"+s5+"')";
			  st.executeUpdate(s11);
			  ImageIcon icon = new ImageIcon("done.png");
              JOptionPane.showMessageDialog(null, "Data Update Successfully!" ,"Update Status", JOptionPane.ERROR_MESSAGE,icon);
			  rg.fn.setText(" ");
			  rg.ln.setText(" ");
			  rg.passwordf.setText(" ");
			  rg.contactf.setText(" ");
			  rg.emailf.setText(" ");
			  con.close();
		  }
          catch(Exception e1)	
          {
			 JOptionPane.showMessageDialog(null,"insert unique data!!","ERROR",JOptionPane.ERROR_MESSAGE);
             card.show(cn,"rg");			 
		  }		  
			  card.show(cn,"lg");
		}
	    }
	 	
		if(e.getSource()==lg.login)
		{
			String s1=lg.username.getText();
			char[] s22=lg.userpassword.getPassword();
			String s2=new String(s22);
		 if(s1.equals("")||s2.equals(""))
		 {
			UIManager.put("OptionPane.background", new Color(0,135,200));
            UIManager.put("Panel.background",Color.WHITE); 
            UIManager.put("OptionPane.messageForeground", new Color(57,57,57)); 
			JLabel label1 = new JLabel("Enter Username & Password ", JLabel.CENTER);
            label1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
          JOptionPane.showMessageDialog(null,label1,"Ohh!!",JOptionPane.WARNING_MESSAGE);
		 
		 }
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
				String db_uname="root";
				String db_upass="root";
				Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
				Statement st=con.createStatement();
				String s11="select * from registration where Name='"+s1+"'and password='"+s2+"' ";
				ResultSet rs=st.executeQuery(s11);
				if(rs.next())
				{
				  String role=rs.getString("role");
				  if(role.equalsIgnoreCase("admin"))
				  {
					card.show(cn,"ad");  
				  }
				  else
				  {
				  card.show(cn,"um");
				  }
                  um.cp.name.setText(lg.username.getText());				  
				}
				else
				{
				  JOptionPane.showMessageDialog(null,"Wrong ID & PASSWORD");
				}
			}	
            catch(Exception e1)
		    {
			   System.out.println(e1);
		    } 		  
		}
        if(e.getSource()==lg.forgetpassword)
		{
			card.show(cn,"fp");
		}

        		  
		if(e.getSource()==cp.logout)
		{
			card.show(cn,"lg");
		}			
		if(e.getSource()==cp.editprofile)
		{
			um.ep.setVisible(true);
			um.c.setVisible(false);
			um.vr.setVisible(false);
			um.cf.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		  card.show(cn,"ed");
		}
		if(e.getSource()==cp.course)
		{
			um.c.setVisible(true);
			um.ep.setVisible(false);
			um.vr.setVisible(false);
			um.cf.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		  card.show(cn,"c");
		}
		if(e.getSource()==cp.exam)
		{
			um.ex.setVisible(true);
			um.ep.setVisible(false);
			um.vr.setVisible(false);
			um.c.setVisible(false);
			um.cf.setVisible(false);
			um.hp.setVisible(false);
		  card.show(cn,"c");
		}
		if(e.getSource()==cp.result)
		{
			um.vr.setVisible(true);
			um.ep.setVisible(false);
			um.c.setVisible(false);
			um.ex.setVisible(false);
			um.cf.setVisible(false);
			um.hp.setVisible(false);
		  card.show(cn,"vr");
		}
		if(e.getSource()==cp.certificate)
		{
			um.cf.setVisible(true);
			um.vr.setVisible(false);
			um.ep.setVisible(false);
			um.c.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		  card.show(cn,"cf");
		  um.cf.sname.setText(lg.username.getText());		
		}
		if(e.getSource()==cp.help)
		{
		  card.show(cn,"hp");
		  hp.startAnimation();
		}	
		if(e.getSource()==hp.clearchat)
		  {
			  hp.timer.start();
		  }
		if(e.getSource()==ep.backk)
		{
		  card.show(cn,"um");
			um.ep.setVisible(false);
			um.c.setVisible(false);
		}
		if(e.getSource()==ep.change)
		{
			String s1=ep.newname.getText();
			String s2=ep.newlastname.getText();
			String s=s1+" "+s2;
			String s3=ep.oldpassword.getText();
			char[] s21=ep.newconfirmpass.getPassword();
			String s4=new String(s21);
			String s5=ep.newcontact.getText();
			String s6=ep.newemail.getText();
		  try
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
			  String db_uname="root";
			  String db_upass="root";
			  Connection con= DriverManager.getConnection(db_url,db_uname,db_upass); 
              Statement st=con.createStatement();			  
			  String s11="update registration SET Name='"+s+"', password='"+s4+"',contact='"+s5+"',email='"+s6+"' WHERE password='"+s3+"'";
			  st.executeUpdate(s11);
			ImageIcon icon = new ImageIcon("done.png");
            JOptionPane.showMessageDialog(null, "Data Update Successfully!" ,"Update Status", JOptionPane.ERROR_MESSAGE,icon);
		  } 
		  catch (Exception ex) 
		  {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
		}
		if(e.getSource()==c.backk)
		{
		  card.show(cn,"um");
			um.ep.setVisible(false);
			um.c.setVisible(false);
			um.vr.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		}
		if(e.getSource()==c.apply)
		{
			
		}
		if(e.getSource()==vr.backk)
		{
		  card.show(cn,"um");
			um.ep.setVisible(false);
			um.c.setVisible(false);
			um.vr.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		}
		if(e.getSource()==hp.backk)
		{
			card.show(cn,"um");
			um.ep.setVisible(false);
			um.c.setVisible(false);
			um.vr.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		}
		if(e.getSource()==ex.backk)
		{
		  card.show(cn,"um");
			um.ep.setVisible(false);
			um.c.setVisible(false);
			um.vr.setVisible(false);
			um.ex.setVisible(false);
			um.hp.setVisible(false);
		}
		if(e.getSource()==ex2.backk)
		{
		  card.show(cn,"um");
		  ex.tx1.setText("");
		}
		if(e.getSource()==ex.select)
		{
			String s1=ex.tx1.getText();
			ex3.examcourse.delete(0,ex3.examcourse.toString().length());
			ex3.examcourse.append(s1);
			System.out.println();
			 ex3.loadQuestion(1);
			if(s1.equals(""))
			{
				 JOptionPane.showMessageDialog(null, "Please select subject first ", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				card.show(cn,"ex2");
			}
		}
		if(e.getSource()==ex3.back)
		{
			card.show(cn,"um");
		}
		if(e.getSource()==ex2.examstart)
		{
			card.show(cn,"ex3");
			ex3.timer.start();
		}
		if(e.getSource()==ex3.submit)
		{
			String selectedAnswer = ex3.getSelectedOptionText();
			if(selectedAnswer!=null&&selectedAnswer.equals(ex3.correctans))
			{
				ex3.score++;
			}
		  JOptionPane.showMessageDialog(null,"Your Score is="+ex3.score,"",JOptionPane.INFORMATION_MESSAGE);	
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
		 String s5=examsubject.toString();
		 System.out.println("subject =>  "+s5);
		  try
		  {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
				String db_uname="root";
				String db_upass="root";
				Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
				Statement st=con.createStatement();
				ResultSet rs= st.executeQuery("select Count(subject) from questions where subject='"+s5+"'group by subject");
				int s2=0;
				if(rs.next())
				{
					s2=new Integer(rs.getString(1));
				}
				int s3=ex3.score;
				int s4=s2-s3;
				String s11="insert into result values('"+email+"','"+s5+"','"+s2+"','"+s3+"','"+s4+"')";
				st.executeUpdate(s11);
				ImageIcon icon = new ImageIcon("done.png");
				JOptionPane.showMessageDialog(null, "Result saved Successfully!" ,"Update Status", JOptionPane.ERROR_MESSAGE,icon);
				con.close();
				card.show(cn,"um");
		  }
		  catch(Exception e1)
		  {
			  System.out.println(e1);
		  }
		  ex3.score=0;
		}
		if(e.getSource()==adcp.logout)
		{
			card.show(cn,"lg");
		}
		if(e.getSource()==adcp.manageadmin)
		{
			card.show(cn,"ma");
			ma.setVisible(true);
			ms.setVisible(false);
			mcourse.setVisible(false);
			req.setVisible(false);
		}
		if(e.getSource()==ma.add)
		{
			String s1=ma.name.getText();
			String s2=ma.password.getText();
			try
			{
			   String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false";
               String username = "root";
               String password = "root";
               Connection connection = DriverManager.getConnection(url, username, password);
               String query = "UPDATE registration SET role = 'admin' WHERE Name = '" + s1 + "' AND password = '" + s2 + "'";
               PreparedStatement statement = connection.prepareStatement(query);
               int rowsUpdated = statement.executeUpdate();
			   if (rowsUpdated>0) 
			   {
                 JOptionPane.showMessageDialog(this, "admin updated successfully!");
               }
			}
			catch(Exception e2)
			{
				System.out.println(e2);
				JOptionPane.showMessageDialog(this,"User not found!");
			}
		}
		if(e.getSource()==ma.backk)
		{
			card.show(cn,"ad");
			ma.setVisible(false);
            ms.setVisible(false);			
			mcourse.setVisible(false);	
            req.setVisible(false);			
		}
		if(e.getSource()==adcp.managestudent)
		{
			ms.setVisible(true);	
			ma.setVisible(false);	
			mcourse.setVisible(false);
            req.setVisible(false);			
			card.show(cn,"ms");
		}
		if(e.getSource()==ms.backk)
		{
			card.show(cn,"ad");
			ma.setVisible(false);	
			ms.setVisible(false);
			mcourse.setVisible(false);	
            req.setVisible(false);	
		}
		if(e.getSource()==adcp.managecourse)
		{
			mcourse.setVisible(true);	
			ms.setVisible(false);	
			ma.setVisible(false);	
            req.setVisible(false);			
			card.show(cn,"mcourse");
		}
		if(e.getSource()==adcp.changepass)
		{
			cpass.setVisible(true);
			mcourse.setVisible(false);	
			ms.setVisible(false);	
			ma.setVisible(false);	
            req.setVisible(false);			
			card.show(cn,"cpass");
		}
		if(e.getSource()==cpass.backk)
		{
			card.show(cn,"ad");
			ma.setVisible(false);	
			ms.setVisible(false);
			mcourse.setVisible(false);	
            req.setVisible(false);
            cpass.setVisible(false);			
		}
		if(e.getSource()==mcourse.backk)
		{
			card.show(cn,"ad");
			ma.setVisible(false);	
			ms.setVisible(false);
			mcourse.setVisible(false);	
            req.setVisible(false);		
		}
		if(e.getSource()==mcourse.addbutton)
		{
			card.show(cn,"addcourse");
			ma.setVisible(false);	
			ms.setVisible(false);
			mcourse.setVisible(false);	
            req.setVisible(false);
            addcourse.setVisible(true);
            addcourse.save.setVisible(true);			
		}
		if(e.getSource()==mcourse.backk)
		{
			card.show(cn,"ad");
			ma.setVisible(false);	
			ms.setVisible(false);
			mcourse.setVisible(false);	
            req.setVisible(false);
            addcourse.setVisible(false);			
		}
		if(e.getSource()==mcourse.managequestions)
		{
			mcourse.selectedValue=mcourse.jl1.getSelectedValue();
			del.fetchDataFromDatabase();
			up.data();
			vi.data();
			card.show(cn,"mq");		
		}
		if(e.getSource()==mq.backk)
		{
			card.show(cn,"ad");
            mq.setVisible(false);						
            mcourse.setVisible(false);
            in.setVisible(false);			
            del.setVisible(false);
            up.setVisible(false);			
            vi.setVisible(false);	
		}
		if(e.getSource()==mq.insert)
		{
			card.show(cn,"in");
			mq.insert.addMouseListener(new MouseAdapter()
	        {
              public void mouseEntered(MouseEvent e) 
		      {
               mq.insert.setBorderPainted(true); // for removig line bg 
		      }
              public void mouseExited(MouseEvent e) 
		      {
              mq.insert.setBorderPainted(true); // for removig line bg     
              mq.delete.setBorderPainted(false);// for removig line bg
              mq.update.setBorderPainted(false);// for removig line bg
              mq.view.setBorderPainted(false);// for removig line bg
			  
		      }
           });
			mcourse.setVisible(false);
            in.setVisible(true);			
            del.setVisible(false);
            up.setVisible(false);			
            vi.setVisible(false);		
		}
		if(e.getSource()==mq.delete)
		{
			card.show(cn,"del");
			mq.delete.addMouseListener(new MouseAdapter()
	        {
              public void mouseEntered(MouseEvent e) 
		      {
               mq.delete.setBorderPainted(true); // for removig line bg 
		      }
              public void mouseExited(MouseEvent e) 
		      {
              mq.delete.setBorderPainted(true);			  // for removig line bg  
              mq.insert.setBorderPainted(false);			  
              mq.update.setBorderPainted(false);			  
              mq.view.setBorderPainted(false);			  
		      }
           });
            del.setVisible(true);			
            mcourse.setVisible(false);			
            in.setVisible(false);			
			up.setVisible(false);			
            vi.setVisible(false);		
		}
		if(e.getSource()==mq.update)
		{
			card.show(cn,"up");
			mq.update.addMouseListener(new MouseAdapter()
	        {
              public void mouseEntered(MouseEvent e) 
		      {
               mq.update.setBorderPainted(true); // for removig line bg 
		      }
              public void mouseExited(MouseEvent e) 
		      {
              mq.delete.setBorderPainted(false);			  // for removig line bg  
              mq.insert.setBorderPainted(false);			  
              mq.update.setBorderPainted(true);			  
              mq.view.setBorderPainted(false);			  
		      }
           });
            del.setVisible(false);			
            mcourse.setVisible(false);			
            in.setVisible(false);			
			up.setVisible(true);			
            vi.setVisible(false);
          up.addMouseListener(new MouseAdapter() 
		  {
            public void mouseClicked(MouseEvent e) 
			{
                if (!up.pp.getBounds().contains(e.getPoint())) 
                    up.pp.setVisible(false); 
            }
         });
 			
		}
		if(e.getSource()==in.submit)
		{
			String s1=in.textarea.getText();
			String s2=in.option1.getText();
			String s3=in.option2.getText();
			String s4=in.option3.getText();
			String s5=in.option4.getText();
			String s6=in.option5.getText();
			String s7=mcourse.selectedValue;
			examsubject.delete(0,examsubject.length());
			examsubject.append(exam3.examcourse.toString());
			
			
			try
		    {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
			  String db_uname="root";
			  String db_upass="root";
			  Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
			  Statement st=con.createStatement();
			  ResultSet qw=st.executeQuery("select Count(subject) from questions where subject='"+s7+"'group by subject");
			  int qid=0;
			  if(qw.next())
			  {
				  qid=Integer.parseInt(qw.getString(1));
			  }
			  String s11="insert into questions (id,question,option_a,option_b,option_c,option_d,correct_option,subject) values('"+(qid+1)+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
			  st.executeUpdate(s11);
			  ImageIcon icon = new ImageIcon("done.png");
              JOptionPane.showMessageDialog(null, "Question Saved Successfully!" ,"Update Status", JOptionPane.ERROR_MESSAGE,icon);
			  in.textarea.setText("");
			  in.option1.setText("");
			  in.option2.setText("");
			  in.option3.setText("");
			  in.option4.setText("");
			  in.option5.setText("");
			  con.close();
		  }
          catch(Exception e1)	
          {
			  System.out.println(e1);
			 JOptionPane.showMessageDialog(null,"Could not insert data!!","ERROR",JOptionPane.ERROR_MESSAGE);		 
		  }		  
		}
		
		if(e.getSource()==mq.view)
		{
			card.show(cn,"vi");
			mq.view.addMouseListener(new MouseAdapter()
	        {
              public void mouseEntered(MouseEvent e) 
		      {
               mq.view.setBorderPainted(true); // for removig line bg 
		      }
              public void mouseExited(MouseEvent e) 
		      {
              mq.delete.setBorderPainted(false);			  // for removig line bg  
              mq.insert.setBorderPainted(false);			  
              mq.update.setBorderPainted(false);			  
              mq.view.setBorderPainted(true);			  
		      }
           });
            del.setVisible(false);			
            mcourse.setVisible(false);			
            in.setVisible(false);			
			up.setVisible(false);			
            vi.setVisible(true);
           vi.addMouseListener(new MouseAdapter() 
		    {
             public void mouseClicked(MouseEvent e) 
			 {
                if (!vi.popupPanel.getBounds().contains(e.getPoint())) 
                    vi.popupPanel.setVisible(false); 
             }
            });				
		}
       
		if(e.getSource()==addcourse.save)
		{
			String s1=addcourse.tx1.getText();
			String s2=addcourse.year.getText();
			String s3=addcourse.lab.getText();
			String s4=addcourse.author.getText();

			String s5=addcourse.desciption.getText();
			try
		    {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  String db_url="jdbc:mysql://localhost:3306/myproject?useSSL=false";
			  String db_uname="root";
			  String db_upass="root";
			  Connection con= DriverManager.getConnection(db_url,db_uname,db_upass);
			  Statement st=con.createStatement();
			  String s11="insert into course values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
              int rowsAffected = st.executeUpdate(s11);
              if (rowsAffected > 0) 
			  {
                mcourse.listModel.addElement(s1); 
                addcourse.tx1.setText("Enter Subject");	
                addcourse.year.setText("Enter Year");
                addcourse.lab.setText("Enter lab");
                addcourse.author.setText("Enter Devloper name");
                addcourse.desciption.setText("Enter Details");				
              }
			  JOptionPane.showMessageDialog(null,"Subject Successfully added!!");
			  card.show(cn,"mcourse");
			  mcourse.setVisible(true);
			  addcourse.save.setVisible(false);
			  con.close();
		    }
            catch(Exception e1)	
            {
			  System.out.println(e1); 
	   	    }		  
		}
		if(e.getSource()==addcourse.backk)
		{
			card.show(cn,"mcourse");
			ma.setVisible(false);	
			ms.setVisible(false);	
            req.setVisible(false);
            addcourse.setVisible(false);
			mcourse.setVisible(true);
		}
		if(e.getSource()==adcp.request)
		{
			ms.setVisible(false);	
			ma.setVisible(false);	
			mcourse.setVisible(false);
            req.setVisible(true);			
			card.show(cn,"req");
			req.loadRequests();
		}
		if(e.getSource()==req.backk)
		{
			ms.setVisible(false);	
			ma.setVisible(false);	
			mcourse.setVisible(false);
            req.setVisible(false);			
			card.show(cn,"ad");
			
		}
		
	}
}
	
class project
{
  public static void main(String ar[])
  {
	  FDemo f=new FDemo();
	  f.setVisible(true);
	  f.setSize(1450,1450);
	  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
  }
}
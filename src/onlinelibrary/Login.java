import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class Login extends Frame implements ActionListener
{

	TextField tf,tf1;
	Button b,b1;
	Panel p,p1,p2,p3;
	Label tl,l1;
	public static String s,s1,s2,s3="",s4,s5,s6,str;
	boolean bo1,bo2;
	String ll;
	int ln=0;
	public Login() throws Exception
	{
		setVisible(true);
		setLayout(null);
		setSize(1500,1500);
		setTitle("LOGIN");
		b=new Button("Login");
		b1=new Button("Signup"); 

		p=new Panel(new FlowLayout(FlowLayout.CENTER));
		p1=new Panel(new GridLayout(3,1));
		p2=new Panel(new FlowLayout(FlowLayout.LEFT));
		p3=new Panel(new FlowLayout(FlowLayout.LEFT));

		tf=new TextField(15);
		tf1=new TextField(15);

		tl=new Label("Username");
		Label tll=new Label("Password");
		Label tl1=new Label("MINI LIBRARY");
		
		tl1.setBounds(600,30,200,30);
		tl1.setFont(new Font("TimesNewRoman",Font.BOLD,20));

		add(tl1);
		p2.add(tl);
		p2.add(tf);
		p1.add(p2);

		p3.add(tll);
		p3.add(tf1);
		p1.add(p3);
		
		p.add(b);
		p.add(b1);
		p1.add(p);
		p1.setBounds(550,200,300,250);
		add(p1);

		
		
		tf1.setEchoChar('*');
		b.addActionListener(this);
		b1.addActionListener(this);

		tf.addActionListener(this);
		tf1.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
		
	}
	public void actionPerformed(ActionEvent ae)
	{
	try
	{
		s=ae.getActionCommand();
		if(s=="Login")
		{
			int count=0;
			s1=tf.getText();
			s2=tf1.getText();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","first","first");   
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select count(*) from library"); 
			while(rs1.next())
			{
				count=rs1.getInt(1);
				ResultSet rs=stmt.executeQuery("select username,password from library");
			 	while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2));
					System.out.println(s1+" "+s2);
					if((s1.equals(rs.getString(1))) && (s2.equals(rs.getString(2))))
					{
						System.out.println("registered");
						ln++;	
						new Home();
						this.dispose();
						break;
					}
					else if(rs.getString(1)==s1||rs.getString(2)==s2)		
					{
						System.out.println("not registered");
						l1=new Label("InCorrect UserName or Password");
						add(l1);
						l1.setForeground(Color.RED);
						l1.setBounds(480,430,200,50);
						ln++;	
						new Login();
						this.dispose();
						break;
					}
					ln++;
				}
				if(ln==count)
				{		
					l1=new Label("You are not registered go for signup");
					add(l1);
					l1.setForeground(Color.RED);
					l1.setBounds(530,430,200,50);
				}
			}	
			con.close(); 			
		}
		else if(s=="Signup")
		{
			try
			{
			new Signup();
			this.dispose();
			}
			catch(IOException v)
			{
			}
		}
	}
	catch(Exception t)
	{
		System.out.println(t);
	}
	}
	public void paint(Graphics g)
	{
		g.drawRect(500,100,350,400);
		g.setColor(Color.RED);
		
	}
	public static void main(String args[]) throws Exception
	{
		new Login();
	}
}	
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Signup extends Frame implements ActionListener,ItemListener 
{
	TextField t[];
	Choice c[];
	Button b1;
	Panel p1,p2;
	Label l[],l1;
	String s1[]={"Name","Roll No","E-mail ID","Mobile No.","Password","Branch","Year","Date Of Birth","Gender"},
	       s2[]={"BIO-TECH","CHEMICAL","CIVIL","CSE","ECE","EEE","IT","MCA","MECH","ME CAD/CAM","ME ECE","ME THERMAL","MTECH CSE","MTECH IT","PROD"},
	       s3[]={"January","February","March","April","May","June","July","August","September","October","November","December"},
	       s4[]={"Female","Male"},s;
	public static String str[]=new String[11];
	
	Choice ch;

	

	


	public Signup() throws IOException
	{
		setVisible(true);
		setSize(1500,1500);
		setLayout(null);
		setTitle("Signup");

		l1=new Label("MINI LIBRARY");
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		add(l1);
		l1.setBounds(600,20,150,40);

		l=new Label[9];
		for(int i=0;i<s1.length;i++)
			l[i]=new Label(s1[i]);
		t=new TextField[5];
		for(int i=0;i<5;i++)
			t[i]=new TextField(50);
		p1=new Panel();
		
		p1.setLayout(new GridLayout(10,1));
		for(int i=0;i<5;i++)
		{
			p1.add(l[i]);
			p1.add(t[i]);
		}
		t[4].setEchoChar('*');
		c=new Choice[6];
		for(int i=0;i<6;i++)
			c[i]=new Choice();
		c[0].add(" ");
		c[1].add(" ");
		c[2].add(" ");
		c[3].add(" ");
		c[4].add(" ");
		c[5].add(" ");
		for(int i=0;i<s2.length;i++)
			c[0].add(s2[i]);
		for(int i=1;i<=3;i++)
			c[1].add(Integer.toString(i));
		
		for(int i=1;i<=31;i++)
			c[2].add(Integer.toString(i));//date
		
		for(int i=0;i<s3.length;i++)
			c[3].add(s3[i]);//month
		
		for(int i=1980;i<=2016;i++)
			c[4].add(Integer.toString(i));//year
		
		for(int i=0;i<s4.length;i++)
			c[5].add(s4[i]);

		p2=new Panel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		for(int i=2;i<=4;i++)
			p2.add(c[i]);
			
		p1.add(l[5]);
		p1.add(c[0]);
		p1.add(l[6]);
		p1.add(c[1]);
		p1.add(l[7]);
		p1.add(p2);
		p1.add(l[8]);
		p1.add(c[5]);
		
		add(p1);
		p1.setBounds(380,150,600,500);
		

		b1=new Button("Submit");
		add(b1);
		b1.setBounds(650,650,50,30);


		b1.addActionListener(this);
		for(int i=0;i<6;i++)
		{
			c[i].addItemListener(this);
		}



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
		s=ae.getActionCommand();
		str[6]=t[0].getText();
		str[7]=t[1].getText();
		str[8]=t[2].getText();
		str[9]=t[3].getText();
		str[10]=t[4].getText();
		if(s=="Submit")
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","first","first");
			Statement stmt=con.createStatement();
				String str1="INSERT INTO library(username,rollnumber,email,mobilenum,password,branch,year,dob,gender) values("
				 +"'"+str[6]+"',"+str[7]+",'"+str[8]+"',"+str[9]+","+"'"+str[10]+"','"+str[0]+"',"+str[1]+",'"+str[2]+"-"+str[3]+"-"+str[4]+"','"+str[5]+"')";
				
							
				stmt.executeUpdate(str1);
				String str2="insert into bookinfo(username) values(" + "'"+str[6]+"')";
				stmt.executeUpdate(str2);
				con.close();

			}
			catch(Exception e)
			{
				System.out.println(e);
			}

			new Home();
			this.dispose();
		}
		
	}
	public void itemStateChanged(ItemEvent ie)
	{
		ch=(Choice)ie.getSource();
		
		if(ch==c[0])
			str[0]=c[0].getSelectedItem();
		else if(ch==c[1])
			str[1]=c[1].getSelectedItem();
		else if(ch==c[2])
			str[2]=c[2].getSelectedItem();
		else if(ch==c[3])
			str[3]=c[3].getSelectedItem();
		else if(ch==c[4])
			str[4]=c[4].getSelectedItem();
		else if(ch==c[5])
			str[5]=c[5].getSelectedItem();
	}
	public void paint(Graphics g)
	{
		g.drawRect(330,100,700,600);
	}
	public static void main(String args[]) throws IOException
	{
		new Signup();
	}
}
		
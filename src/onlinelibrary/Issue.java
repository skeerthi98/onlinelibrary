import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class Issue extends Frame implements ActionListener
{
	Label l[],l0[],l1[];
	String s,s1[]={"Issue","Name : ","Branch : ","Year : ","Rollnumber : ","Books Selected : "},s2,a1[];
	Panel p,p1;
	Button b,b1[],b2;
	
	Login x;
	Signup y;
	
	int ln=0;
	java.sql.Date sqlDate;
	String str1,u;
	ResultSet rs1,rs2;
	ResultSetMetaData rsmd;
	public Issue()
	{
		try
		{	
			setVisible(true);
			setSize(1500,1500);
			setLayout(null);
			setTitle("Issue");

			x=new Login();
			x.setVisible(false);
			if(x.s1==null)
				u=y.str[6];
			else
				u=x.s1;
			

			
			l=new Label[6];
			l0=new Label[4];
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","first","first");   
			Statement stmt=con.createStatement(); 
			str1="select username,branch,year,rollnumber from library where username="+"'"+u+"'";
			rs1=stmt.executeQuery(str1);
			
			while(rs1.next())
			{
				System.out.println(rs1.getString(1));
				l0[0]=new Label(rs1.getString(1));
				l0[1]=new Label(rs1.getString(2));
				l0[2]=new Label(rs1.getString(3));
				l0[3]=new Label(rs1.getString(4));
			}
			con.close();
		
		}catch(Exception e){ System.out.println(e);} 
		
			for(int i=0;i<l.length;i++)
				l[i]=new Label(s1[i]);
			l[0].setFont(new Font("TimesNewRoman",Font.BOLD,20));
			l[0].setBounds(600,50,150,30);
			add(l[0]);
		
			p=new Panel();

			p.setLayout(new GridLayout(5,1));
			for(int i=1;i<l.length;i++)
			{
				p.add(l[i]);
			
			}
			p.add(l[1]);
			p.add(l0[0]);
			p.add(l[2]);
			p.add(l0[1]);
			p.add(l[3]);
			p.add(l0[2]);
			p.add(l[4]);
			p.add(l0[3]);
			p.add(l[5]);
			add(p);
			p.setBounds(30,100,300,150);

			b=new Button("Submit");
			add(b);
			b.setBounds(650,600,50,30);
			b.addActionListener(this);

			l1=new Label[4];
			b1=new Button[4];
			


			p1=new Panel();
			p1.setLayout(new FlowLayout(FlowLayout.LEFT));

			sqlDate = new java.sql.Date(new java.util.Date().getTime());
			
			
			

			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","first","first");   
			Statement stmt=con.createStatement(); 
			str1="select * from bookinfo where username="+"'"+u+"'";
			rs1=stmt.executeQuery(str1);	
			rsmd = rs1.getMetaData();
			
				while(rs1.next())
				{
					System.out.println("entered outer loop");
					for(int i=3;i<=9;i=i+2)
					{
						System.out.println(ln+" "+i);
						String a1=rs1.getString(i-1);
						System.out.println(a1);
						String a="select to_char(" +rsmd.getColumnName(i)+ ",'yyyy-mm-dd') from bookinfo where username="+"'"+u+"'";
						rs2=stmt.executeQuery(a);
						
						while(rs2.next())
						{
						System.out.println("entered");
							if(rs2.getString(1).equals(sqlDate.toString()))
							{
								
								ln++;
								
								l1[ln]=new Label(a1);
								p1.add(l1[ln]);
								b1[ln]=new Button("Cancel");
								p1.add(b1[ln]);
								b1[ln].addActionListener(this);
							
							}
						}
					}
				}
			con.close();
		
		}catch(Exception e){ System.out.println(e);} 
			

			
			p1.setBounds(30,300,600,300);
			add(p1);
			
			
		}
		catch(Exception d)
		{
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
		b2=(Button)ae.getSource();
		if(b2==b)
		{
			try	
			{
				
				this.dispose();
			}
			catch(Exception y)
			{
			}
		}
		else
		{
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","first","first");   
			Statement stmt=con.createStatement(); 
			str1="select * from bookinfo where username="+"'"+u+"'";
			rs1=stmt.executeQuery(str1);
			rsmd = rs1.getMetaData();
			
			outer:
			for(int j=0;j<ln;j++)
			{
				if(b2==b1[j])
				{
					l1[j].setVisible(false);
					b1[j].setVisible(false);
					try
					{


						while(rs1.next())
						{
							for(int i=2;i<=8;i=i+2)
							{
								System.out.println("hello");
								if(rs1.getString(i).equals(l1[j].toString()))
								{
									String str2="update bookinfo set "+rsmd.getColumnName(i)+"=null,"+rsmd.getColumnName(i+1)+"=null "
									+"where username='"+u+"'";
									stmt.executeUpdate(str2); 
									break outer;	
								}
							}
						}
					}
					catch(Exception g)
					{}
				}
			}
			con.close();
		
		}catch(Exception e){ System.out.println(e);} 	
		}
								 
						

						
					
					
		
	}
	public void paint(Graphics g)
	{
	}	
	public static void main(String args[]) throws IOException
	{
		new Issue();
	}
}

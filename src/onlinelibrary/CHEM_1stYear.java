import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;
public class CHEM_1stYear extends Frame implements ActionListener,ItemListener
{
	Label l1,l2,l3,l4[],l5;

	Panel p1,p2,p3,p4;

	CheckboxGroup cg1,cg2;

	Checkbox c1[]=new Checkbox[7],c2[]=new Checkbox[7];
	Checkbox c3,c4;

	Button b[],b1,b2;

	String s="",s1[]={"Home","Borrow","UG","CHEM 1st YEAR"}
	,s2[]={"English - I","Mathematics - I","Physics - I","Inorganic Chemistry","Programming and MATLAB Computing","Environmental Studies","English - II","Mathematics - II","Physics - II","Organic Chemistry","Object Oriented Programming through C++","Introduction to Chemical Engineering"};
	String 
	s3[]={"E Suresh Kumar","Kanti.B.Datta","M.N. Avadhanulu","P.C.Jain and Monica Jain","Amos Gilat","Y. Anjaneyulu","E Suresh Kumar","BS. Grewal","M.N. Avadhanulu","Morrison and Boyd","E. Balagurusamy","Pushpavanam"},
	s4[]={"Michael McCarthy","Michael Greenburg","S.L. Gupta","Puri & Sharma","Rajaraman.V","S.S.Dara","Michael McCarthy","Michael Greenburg","S.L. Gupta","I L Finar","Bjarne Stroustrup ","S N Saha"};

	
	
	CardLayout c=new CardLayout();
	Login x;
	Signup y;
	 int ln,i;
	String u;

	CHEM_1stYear()
	{
		setVisible(true);
		setSize(1500,1500);
		setLayout(null);
		setTitle("CHEM 1st YEAR");
		

		l1=new Label("CHEM 1st YEAR");
		l2=new Label("I SEMESTER :");
		l3=new Label("II SEMESTER :");
		
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		add(l1);		
		l1.setBounds(700,40,200,40);




		l2.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		l3.setFont(new Font("TimesNewRoman",Font.BOLD,15));
		
		p1=new Panel();
		p2=new Panel();
		p1.setLayout(new GridLayout(16,1));
		p1.add(l2);
		cg1=new CheckboxGroup();
		cg2=new CheckboxGroup();
		for(int i=0;i<6;i++)
		{
			
			c1[i]=new Checkbox(s2[i],false,cg1);
			p1.add(c1[i]);
		}
		p1.add(l3);
		for(int i=0,j=6;i<6||j<12;i++,j++)
		{
			
			c2[i]=new Checkbox(s2[j],false,cg1);
			p1.add(c2[i]);
		}
		add(p1);
		p1.setBounds(20,150,300,500);
		p2.setLayout(c);
		
		
		p2.setBounds(700,300,500,100);
		for(int i=0;i<6;i++)
		{
			c1[i].addItemListener(this);
			c2[i].addItemListener(this);
		}



		l4=new Label[3];
		for(int i=0;i<3;i++)
			l4[i]=new Label(">");
		p3=new Panel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		

		
		b=new Button[s1.length];
		for(int i=0;i<s1.length;i++)
		{
			b[i]=new Button(s1[i]);
		}
		for(int i=0,j=0;i<4;i++,j++)
		{
			p3.add(b[i]);
			if(j<3)
				p3.add(l4[j]);
		}
		add(p3);
		p3.setBounds(20,95,600,100);
		for(int i=0;i<4;i++)
			b[i].addActionListener(this);
		
		b1=new Button("Done");
		b2=new Button("Next");
		add(b1);
		add(b2);
		b1.setBounds(500,670,50,30);
		b2.setBounds(800,670,50,30);

		b1.addActionListener(this);
		b2.addActionListener(this);

		try
		{
			y=new Signup();
			x=new Login();
			x.setVisible(false);
			y.setVisible(false);
		}
		catch(Exception d)
		{}
		

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		s=((Checkbox)ie.getSource()).getLabel();
		
		p4=new Panel();
		p4.setLayout(new GridLayout(2,0));
		
		
		for(int i=0;i<12;i++)
		{
			if(s==s2[i])
			{
				c3=new Checkbox(s+"  "+s3[i],false,cg2);
				c4=new Checkbox(s+"  "+s4[i],false,cg2);
				p4.add(c3);
				p4.add(c4);
				p2.add(p4,"a1");
				this.add(p2);
				c.show(p2,"a1");
				c3.addItemListener(this);
				c4.addItemListener(this);
				setVisible(true);
				break;
			}
			
		}
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","first","first");   
			Statement stmt=con.createStatement(); 
				if(x.s1==null)
				u=y.str[6];
				else
				u=x.s1;
				String str1="select * from bookinfo where username="+"'"+u+"'";
				ln=0;
				ResultSet rs1=stmt.executeQuery(str1);	
				while(rs1.next())
				{
					
					for(i=2;i<=8;i=i+2)
					{
						if(rs1.getString(i)==null)
						{
						
						ln=i;
						break;
						}
					
					}
				}
			
			
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			if(c3.getState()&&(ln!=0))
			{
				
				String a="update bookinfo set "+rsmd.getColumnName(ln)+"='"+c3.getLabel()+"',"+rsmd.getColumnName(ln+1)+"=to_char(to_date('"+sqlDate+"','yyyy-mm-dd'),'dd-mon-yy') where username="+"'"+u+"'";


				stmt.executeUpdate(a);
				

			}
			else if(c4.getState()&&(ln!=0))
			{
				
				String a1="update bookinfo set "+rsmd.getColumnName(ln)+"='"+c4.getLabel()+"',"+rsmd.getColumnName(ln+1)+"=to_char(to_date('"+sqlDate+"','yyyy-mm-dd'),'dd-mon-yy') where username="+"'"+u+"'";

				stmt.executeUpdate(a1);

			}
			else if(ln==0)
			{
				l5=new Label("Maximum number of books to be taken is 4");
				l5.setForeground(Color.red);
				l5.setFont(new Font("TimesNewRoman",Font.BOLD,20));
				add(l5);
				l5.setBounds(600,500,600,50);
			}
		
			
		con.close();
		
		}catch(Exception e){ System.out.println(e);}
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		s=ae.getActionCommand();
		if(s=="Done")
		{
			//new Issue();
			this.dispose();
		}
		else if(s=="Next")
		{
			new UG();
			this.dispose();
		}

		else if(s=="Home")
		{
			new Home();
			this.dispose();
		}
		else if(s=="Borrow")
		{
			new Borrow();
			this.dispose();
		}
		else if(s=="UG")
		{
			new UG();
			this.dispose();
		}
	}
	
	public void paint(Graphics g)
	{

		g.drawRect(650,250,550,200);
		g.drawString("AUTHORS",900,270);
		

	}
	public static void main(String args[])throws ArrayIndexOutOfBoundsException
	{
		new CHEM_1stYear();
	}
}	
		


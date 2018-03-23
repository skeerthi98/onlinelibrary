import java.awt.event.*;
import java.awt.*;
public class UG extends Frame implements ActionListener,ItemListener
{
	Button b1[],b2[];
	String s,s1[]={"Home","Borrow","UG"},s2[]={"BIO-TECH","CHEMICAL","CIVIL","CSE","ECE","EEE","IT","MECH","PROD"},s3[]={"BIO-TECH 1st year","CHEMICAL 1st year","CIVIL 1st year","CSE 1st year","ECE 1st year","EEE 1st year","IT 1st year","MECH 1st year","PROD 1st year"},s4[]={"BIO-TECH 2nd year","CHEMICAL 2nd year","CIVIL 2nd year","CSE 2nd year","ECE 2nd year","EEE 2nd year","IT 2nd year","MECH 2nd year","PROD 2nd year"},s5[]={"BIO-TECH 3rd year","CHEMICAL 3rd year","CIVIL 3rd year","CSE 3rd year","ECE 3rd year","EEE 3rd year","IT 3rd year","MECH 3rd year","PROD 3rd year"};
	Label l[],l1;
	Panel p,p1,p2,p3;
	Checkbox c1,c2,c3;
	CheckboxGroup cg1;
	CardLayout c;
	UG()
	{
		setVisible(true);
		setSize(1500,1500);
		setLayout(null);
		setTitle("UG");

		cg1=new CheckboxGroup();
		


		b1=new Button[3];
		l=new Label[2];
		p1=new Panel();
		l1=new Label("UNDER GRADUATION");
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		add(l1);
		l1.setBounds(600,40,250,40);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.setBounds(20,95,300,80);
		for(int i=0;i<s1.length;i++)
		{
			b1[i]=new Button(s1[i]);
			p1.add(b1[i]);
			if(i<2)
			{
				l[i]=new Label(">");
				p1.add(l[i]);
			}
		}
		add(p1);
		b2=new Button[9];
		p=new Panel();
		p.setLayout(new GridLayout(10,1,3,20));
		for(int i=0;i<s2.length;i++)
		{
			b2[i]=new Button(s2[i]);
			p.add(b2[i]);
		}
		add(p);
		p.setBounds(100,180,100,500);


		p3=new Panel();
		c=new CardLayout();
		p3.setLayout(c);
		p3.setBounds(700,300,200,100);

		
		for(int i=0;i<s2.length;i++)
		{
			if(i<3)
				b1[i].addActionListener(this);
			b2[i].addActionListener(this);	
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
		p2=new Panel();
		
		p2.setLayout(new GridLayout(3,0));
		for(int i=0;i<s2.length;i++)
		{
			if(s==s2[i])
			{
				c1=new Checkbox(s3[i],false,cg1);
				c2=new Checkbox(s4[i],false,cg1);
				c3=new Checkbox(s5[i],false,cg1);
				p2.add(c1);
				p2.add(c2);
				p2.add(c3);
				p3.add(p2,"a1");
				this.add(p3);
				c.show(p3,"a1");
				setVisible(true);

				c1.addItemListener(this);
				c2.addItemListener(this);
				c3.addItemListener(this);

				break;
				
			}
		}


			
		if(s=="Home")
		{
			new Home();
			this.dispose();
		}
		else if(s=="Borrow")
		{
			new Borrow();
			this.dispose();
		}
				
	}
	public void itemStateChanged(ItemEvent ie)
	{
		s=((Checkbox)ie.getSource()).getLabel();
		if(s=="BIO-TECH 1st year")
		{
			new Biotech_1stYear();
			this.dispose();
		}
		else if(s=="BIO-TECH 2nd year")
		{
			new BIOTECH_2ndYear();
			this.dispose();
		}
		else if(s=="BIO-TECH 3rd year")
		{
			//new Biotech_3rdYear();
			this.dispose();
		}
		else if(s=="CHEMICAL 1st year")
		{
			//new CHEM_1stYear();
			this.dispose();
		}
		else if(s=="CHEMICAL 2nd year")
		{
			//new CHEM_2ndYear();
			this.dispose();
		}
		else if(s=="CHEMICAL 3rd year")
		{
			//new CHEM_3rdYear();
			this.dispose();
		}
		else if(s=="CIVIL 1st year")
		{
			//new CIVIL_1stYear();
			this.dispose();
		}
		else if(s=="CIVIL 2nd year")
		{
			//new CIVIL_2ndYear();
			this.dispose();
		}
		else if(s=="CIVIL 3rd year")
		{
			//new CIVIL_3rdYear();
			this.dispose();
		}
		else if(s=="CSE 1st year")
		{
			//new CSE_1stYear();
			this.dispose();
		}
		else if(s=="CSE 2nd year")
		{
			//new CSE_2ndYear();
			this.dispose();
		}
		else if(s=="CSE 3rd year")
		{
			//new CSE_3rdYear();
			this.dispose();
		}
		else if(s=="ECE 1st year")
		{
			//new ECE_1stYear();
			this.dispose();
		}
		else if(s=="ECE 2nd year")
		{
			//new ECE_2ndYear();
			this.dispose();
		}
		else if(s=="ECE 3rd year")
		{
			//new ECE_3rdYear();
			this.dispose();
		}
		if(s=="EEE 1st year")
		{
			//new EEE_1stYear();
			this.dispose();
		}
		else if(s=="EEE 2nd year")
		{
			//new EEE_2ndYear();
			this.dispose();
		}
		else if(s=="EEE 3rd year")
		{
			//new EEE_3rdYear();
			this.dispose();
		}
		else if(s=="IT 1st year")
		{
			//new IT_1stYear();
			this.dispose();
		}
		else if(s=="IT 2nd year")
		{
			//new IT_2ndYear();
			this.dispose();
		}
		else if(s=="IT 3rd year")
		{
			//new IT_3rdYear();
			this.dispose();
		}
		else if(s=="MECH 1st year")
		{
			//new MECH_1stYear();
			this.dispose();
		}
		else if(s=="MECH 2nd year")
		{
			//new MECH_2ndYear();
			this.dispose();
		}
		else if(s=="MECH 3rd year")
		{
			//new MECH_3rdYear();
			this.dispose();
		}
		else if(s=="PROD 1st year")
		{
			//new PROD_1stYear();
			this.dispose();
		}
		else if(s=="PROD 2nd year")
		{
			//new PROD_2ndYear();
			this.dispose();
		}
		else if(s=="PROD 3rd year")
		{
			//new PROD_3rdYear();
			this.dispose();
		}
			
		
	}
	public void paint(Graphics g)
	{
		g.drawRect(650,250,300,200);
	}
	public static void main(String args[])
	{
		new UG();
	}
}
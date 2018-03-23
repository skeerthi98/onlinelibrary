import java.awt.*;
import java.awt.event.*;

public class Borrow extends Frame implements ActionListener
{
	Button b[];
	Label l1,l2;
	String s1,s2[]={"Home","Borrow","UG","PG"};
	Panel p1;
	Borrow()
	{	
		setLayout(null);
		setTitle("BORROW");
		setSize(1500,1500);
		setVisible(true);
		
		l1=new Label("MINI LIBRARY ");
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		l1.setBounds(600,20,150,50);
		add(l1);
		b=new Button[4];
		for(int i=0;i<s2.length;i++)
			b[i]=new Button(s2[i]);
		l2=new Label(">");
		
		p1=new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(b[0]);
		p1.add(l2);
		p1.add(b[1]);
		add(p1);
		
		p1.setBounds(500,180,200,50);

		add(b[2]);
		add(b[3]);
		b[2].setBounds(550,300,70,40);
		b[3].setBounds(700,300,70,40);
	
		for(int i=0;i<s2.length;i++)
			b[i].addActionListener(this);
	
		
		
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
		s1=ae.getActionCommand();
		if(s1=="Home")
		{
			new Home();
			this.dispose();
		}
		else if(s1=="UG")
		{
			new UG();
			this.dispose();
		}
		else if(s1=="PG")
		{
			//new PG();
			this.dispose();
		}		
	}
	public void paint(Graphics g)
	{
		g.drawRect(490,150,350,350);
	}
	public static void main(String args[])
	{
		new Borrow();
	}
}
				

import java.awt.*;
import java.awt.event.*;

public class Home extends Frame implements ActionListener
 {
	Button b1,b2,b3;
	Label l1;
	String s,st="vani";

	Home ()
	{
		setLayout(null);
		setTitle ("Home Page");
		setSize (1500,1500);
		setVisible(true);
		setBackground(Color.cyan);
		l1=new Label("MINI LIBRARY");
		l1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		add(l1);		
		l1.setBounds(600,20,200,70);
		b1=new Button("Details"); 
		b2=new Button("Borrow");
		b3=new Button("Return");

		b1.setBounds(630,250,60,30);
		b2.setBounds(565,350,60,30);
		b3.setBounds(700,350,60,30);

		this.add(b1);
		this.add(b2);
		this.add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);


		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

	}
	 public void actionPerformed(ActionEvent ae)
	{
		s=ae.getActionCommand();
		if(s=="Details")
		{
			//new Details();
			this.dispose();
		}
		else if(s=="Borrow")
		{
			new Borrow();
			this.dispose();
		}
		else if(s=="Return")
		{
			//new Return();
			this.dispose();
		}
	}
	public void paint(Graphics g)
	{

		g.drawRect(490,150,350,350);
		
		

	}



	public static void main(String args[])
	{
		new Home();
	}
}

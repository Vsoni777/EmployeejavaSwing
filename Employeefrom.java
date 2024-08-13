package Employee;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Employeefrom extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5,b6,b7;
	Employeefrom() 
	{
		l1 = new JLabel("Empid                   ");
		l2 = new JLabel("Name                     ");
		l3 = new JLabel("Salary                    ");
		
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		
		b1 = new JButton("Insert");
		b2 = new JButton("Modify");
		b3 = new JButton("Delete");
		b4 = new JButton("Display");
		b5 = new JButton("Reset");
		b6 = new JButton("Close");
		b7 = new JButton("Display All");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		setSize(320, 300);
		setTitle("Employee Form");
		setLayout(new FlowLayout());//center
		//setLayout(new FlowLayout(FlowLayout.LEFT));
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		Employee s = new Employee();
		try {
			s.setEmpid(Integer.parseInt(t1.getText()));	
		}
		catch (NumberFormatException e) 
		{
			t1.setText("Invalid Input");
		}
		s.setEmpname(t2.getText());
		try {
			s.setSalary(Integer.parseInt(t3.getText()));	
		}
		catch (NumberFormatException e) 
		{
			t2.setText("Invalid Input");
		}
		int x=0;
		DBService db = new DBService();
		if(ae.getSource()==b1)
		{
			x = db.addEmployee(s);
			if(x>=1)
			{
				t2.setText("Record Inserted");
			}
			else
			{
				t2.setText("Record Not Inserted");
			}
		}
		if(ae.getSource()==b2)
		{
			x = db.modifyEmployee(s);
			if(x>=1)
			{
				t2.setText("Record Updated");
			}
			else
			{
				t2.setText("Record Not Updated");
			}
		}
		if(ae.getSource()==b3)
		{
			x = db.deleteEmployee(s);
			if(x>=1)
			{
				t2.setText("Record Deleted");
			}
			else
			{
				t2.setText("Record Not Deleted");
			}
		}
		if(ae.getSource()==b4)
		{
			Employee s1 = db.getEmployee(s);
			System.out.println("s1.getEmpname():"+s1.getEmpname());
			if(s1.getEmpname()!=null)
			{
				t1.setText(String.valueOf(s1.getEmpid()));
				t2.setText(s1.getEmpname());
				t3.setText(String.valueOf(s1.getSalary()));
			}
			else
			{
				t2.setText("Record Not Found");
			}
		}
		
		if(ae.getSource()==b5)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(ae.getSource()==b6)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args) 
	{
		Employeefrom clc = new Employeefrom();
		clc.setVisible(true);
		clc.setLocation(300, 300);
	}

}

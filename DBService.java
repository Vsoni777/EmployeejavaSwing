package Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBService 
{
	Connection con=null;
	DBService() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/vivek1","vivek","Vi_soni777@&");
		}
		catch (Exception e) 
		{
		
		}
	}
	
	public int addEmployee(Employee s)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
		
		ps.setInt(1, s.getEmpid());
		ps.setString(2, s.getEmpname());
		ps.setInt(3, s.getSalary());
		x = ps.executeUpdate();
		
		}
		catch (Exception e) 
		{
		
		}
		return x;
	}
	public int modifyEmployee(Employee s)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("update employee set empname = ?,salary = ? where empid = ?");
		ps.setString(1, s.getEmpname());
		ps.setInt(2, s.getSalary());
		ps.setInt(3, s.getEmpid());
		x = ps.executeUpdate();
		}
		catch (Exception e) 
		{
		
		}
		return x;
	}
	public int deleteEmployee(Employee s)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("delete from employee where empid= ?");
		ps.setInt(1, s.getEmpid());
		x = ps.executeUpdate();
		}
		catch (Exception e) 
		{
		
		}
		return x;
	}
	public Employee getEmployee(Employee s)
	{
		Employee s1 = new Employee();
		try 
		{
		PreparedStatement ps = con.prepareStatement("select * from employee  where empid= ?");
		ps.setInt(1, s.getEmpid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()==true)
		{
			s1.setEmpid(rs.getInt("empid"));
			s1.setEmpname(rs.getString("empname"));
			s1.setSalary(rs.getInt("salary"));
		}
		}
		catch (Exception e) 
		{
		
		}
		return s1;
	}
	
}

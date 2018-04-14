package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import entities.User;
@Component
public class UserDao {

	//Dependency of the UserDao
	private DataSource dataSource;
	
	//Setter method to get the dependency injected
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	
	}
	//Method to save a user in the database
	public void save(User user) throws Exception
	{
		Connection con=dataSource.getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"insert into UserMaster (name,mailId,password) values(?,?,?)");
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getMailId());
		stmt.setString(3, user.getPassword());
		stmt.executeUpdate();
		con.close();
	}
	
	//Method to update a user in the database
		public void update(User user) throws Exception
		{
			Connection con=dataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(
			"update UserMaster set name=?,mailId=?,password=? where id=?");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getMailId());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getId());
			stmt.executeUpdate();
			con.close();
		}
	//Method to search a user using Mailid & password
		public boolean find(User user) throws Exception
		{
			boolean flag=false;
			Connection con=dataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(
			"select id, name from UserMaster where mailId=? and password=?");
			stmt.setString(1, user.getMailId());
			stmt.setString(2, user.getPassword());
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				flag=true;
				//Id & name are stored in the user object
				user.setId(rset.getInt(1));
				user.setName(rset.getString(2));
			}
			con.close();
			return flag;
		}
		
		//Method to search a mailId
				public boolean exists(String mailId) throws Exception
				{
					boolean flag=false;
					Connection con=dataSource.getConnection();
					PreparedStatement stmt=con.prepareStatement(
					"select * from UserMaster where mailId=?");
					stmt.setString(1, mailId);
					ResultSet rset=stmt.executeQuery();
					if(rset.next())
					{
						flag=true;
						
					}
					con.close();
					return flag;
				}	
		
}











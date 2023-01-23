import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
int insert(Student s) throws ClassNotFoundException, SQLException {
	Connection con=DbUtil.dbConn();
	String sql="insert into student values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1,s.getName());
	ps.setString(2, s.getEmail());
	ps.setString(3, s.getPassword());
	ps.setLong(4, s.getPhno());
	 
	int row=ps.executeUpdate();
	return row;
}

int update(Student s) throws ClassNotFoundException, SQLException {
	Connection con=DbUtil.dbConn();
	String sql="update Student set Email=?,Phno=? where Name=?";
	PreparedStatement ps=con.prepareStatement(sql);

	ps.setString(1, s.getEmail());
	ps.setLong(2, s.getPhno());
	ps.setString(3,s.getName());
	 
	int row=ps.executeUpdate();
	return row;
}

int delete(Student s) throws ClassNotFoundException, SQLException {
	Connection con=DbUtil.dbConn();
	String sql="delete from Student where Name=?";
	PreparedStatement ps=con.prepareStatement(sql);
	
	ps.setString(1,s.getName());
	 
	int row=ps.executeUpdate();
	return row;
}

public List<Student> getall() throws ClassNotFoundException, SQLException{
	List<Student> list=new ArrayList<>();
 	Connection con=DbUtil.dbConn();
	String sql="select * from student";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		Student s=new Student();
		s.setName(rs.getString(1));
		s.setEmail(rs.getString(2));
		s.setPassword(rs.getString(3));
		s.setPhno(rs.getLong(4));
		list.add(s);
		
	}
	return list;
}
}
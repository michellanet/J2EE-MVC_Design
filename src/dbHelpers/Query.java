package dbHelpers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.istack.internal.logging.Logger;

import model.M_56_Friend;
import sun.util.logging.PlatformLogger.Level;

import java.sql.Connection;

public class Query {
	private Connection conn;
	ResultSet rs;
	public ArrayList<M_56_Friend> friends = new ArrayList<M_56_Friend>();
	
public Query() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_design","root", "anetor");
}

public void doRead() {
	String sql = "select * from friends";
	try {
	PreparedStatement st = conn.prepareStatement(sql);		
	rs = st.executeQuery();
    } catch (SQLException e) {
        Logger.getLogger(Query.class.getName(), null).log(null, sql, Level.SEVERE);
    }
}

// doRead method overload
public void doRead(int id) {
	M_56_Friend friend = null;
	String sql = "select * from friends WHERE id = ?";
	try {
	PreparedStatement st = conn.prepareStatement(sql);	
    st.setInt(1, id);	
	rs = st.executeQuery();
    } catch (SQLException e) {
        Logger.getLogger(Query.class.getName(), null).log(null, sql, Level.SEVERE);
    }
}

public void doAdd(M_56_Friend f) {
	String sql = "INSERT INTO friends (name, email, age, favoriteColor)"
            + " VALUES (?, ?, ?, ?)";
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
        //step 2
        pst.setString(1, f.getName());
        pst.setString(2, f.getEmail());
        pst.setInt(3, f.getAge());
        pst.setString(4, f.getColor());
        pst.executeUpdate();
    } catch (SQLException e) {
        Logger.getLogger(Query.class.getName(), null).log(null, sql, Level.SEVERE);
    }
}


public void doUpdate(M_56_Friend f) {
	String sql = "UPDATE friends SET name=?, email=?, age=?, favoriteColor=?"
            + " WHERE id = ?";
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
        //step 2
        pst.setString(1, f.getName());
        pst.setString(2, f.getEmail());
        pst.setInt(3, f.getAge());
        pst.setString(4, f.getColor());
        pst.setInt(5, f.getId());
        pst.executeUpdate();
    } catch (SQLException e) {
        Logger.getLogger(Query.class.getName(), null).log(null, sql, Level.SEVERE);
    }
}

public void doDelete(int id) {
	String sql = "DELETE FROM friends WHERE id=?";
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
        //step 2
        pst.setInt(1, id);
        pst.executeUpdate();
    } catch (SQLException e) {
        Logger.getLogger(Query.class.getName(), null).log(null, sql, Level.SEVERE);
    }
}

	public ArrayList<M_56_Friend> getHTMLTable() throws Exception {
		M_56_Friend friend;
		while(rs.next()){
			friend = new M_56_Friend(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            friend.setId(rs.getInt(1));
            friends.add(friend);
        }
	    return friends;
	}
}

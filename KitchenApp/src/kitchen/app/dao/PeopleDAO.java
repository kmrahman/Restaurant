package kitchen.app.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kitchen.app.exception.AppException;
import kitchen.app.model.Person;
import kitchen.app.model.Contact;
import kitchen.app.model.Reservation;
import kitchen.app.util.DBConnector;

public class PeopleDAO {
public String cancelReservation(String CNF) throws AppException {
		
		Connection con = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = con.prepareStatement("select * FROM people_db.reservation WHERE people_db.reservation.CNF = ?");
			ps.setString(1, CNF);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				
			}
			else {
				throw new AppException("No reservation with confirmation=" + CNF + " found in the system.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally {
			DBConnector.closeResources(ps, rs, con);
		}
		return "Success";
	}
	


	public Reservation getReservation(String CNF) throws AppException {
		
		Reservation person = new Reservation();
		
		Connection con = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = con.prepareStatement("select FIRST_NAME, PDATE, PTIME, EMAIL, PHONE, PARTYSIZE, COMMENT FROM people_db.reservation, people_db.people WHERE people_db.reservation.CNF = ? and people_db.people.ID=people_db.reservation.Person");
			ps.setString(1, CNF);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				person.setName(rs.getString("FIRST_NAME"));
				person.setDate(rs.getString("PDATE"));
				person.setTime(rs.getString("PTIME"));
				person.setEmail(rs.getString("EMAIL"));
				person.setPhone(rs.getString("PHONE"));
				person.setPartySize(rs.getString("PARTYSIZE"));
				person.setComments(rs.getString("COMMENT"));
			}
			else {
				throw new AppException("No reservation with confirmation=" + CNF + " found in the system.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally {
			DBConnector.closeResources(ps, rs, con);
		}
		return person;
	}
	
	
public Reservation addReservation(Reservation person) throws AppException {
		
		Connection con = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int newId=0;
		try {
			
			ps = con.prepareStatement("INSERT INTO people (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, CITY, ZIP, PHONE, STATE) VALUES (?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, person.getName());
			ps.setString(2, "");
			ps.setString(3,  person.getEmail());
			ps.setString(4, "");
			ps.setString(5, "");
			ps.setString(6,  "");
			ps.setInt(7,  0);
			ps.setString(8,  person.getPhone());
			ps.setString(9,  "");
			
			ps.executeUpdate();
			
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
			{
				newId= rs.getInt(1);
			}
			ps = null;
			rs= null;
			
			String localCNF = getRandomHexString(6).toUpperCase();
			
			ps = con.prepareStatement("INSERT INTO reservation (PDATE, PTIME, PARTYSIZE, COMMENT, PERSON, CNF) VALUES (?,?,?,?,?,?)");
			ps.setString(1, person.getDate());
			ps.setString(2, person.getTime());
			ps.setString(3, person.getPartySize());
			ps.setString(4, person.getComments());
			ps.setInt(5,  newId);
			ps.setString(6, localCNF);
			
			ps.executeUpdate();
			
			person.setCNF(localCNF);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally {
			DBConnector.closeResources(ps, rs, con);
		}
		return person;
	}


public List<Contact> getContactList() throws AppException {
		
		List<Contact> contactList = new ArrayList<Contact>();
		
		Connection con = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = con.prepareStatement("select CNF, FIRST_NAME, PDATE, PHONE FROM people_db.reservation, people_db.people WHERE people_db.people.ID=people_db.reservation.Person");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Contact person = new Contact();
				person.setCNF(rs.getString("CNF"));
				person.setName(rs.getString("FIRST_NAME"));
				person.setDate(rs.getString("PDATE"));
				person.setPhone(rs.getString("PHONE"));
				
				contactList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally {
			DBConnector.closeResources(ps, rs, con);
		}
		return contactList;
	}
	

	private String getRandomHexString(int numchars){
	    Random r = new Random();
	    StringBuffer sb = new StringBuffer();
	    while(sb.length() < numchars){
	        sb.append(Integer.toHexString(r.nextInt()));
	    }
	
	    return sb.toString().substring(0, numchars);
	}
	
}

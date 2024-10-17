package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.SpeedingTickets;

public class SpeedingTicketsDAO {
	public static SpeedingTickets getById(int id) throws SQLException
	{
		List<SpeedingTickets> tickets = SpeedingTicketsDAO.getAll();
		for(SpeedingTickets s : tickets)
		{
			if(s.getId()==id)
			{
				return s;
			}
		}
		return null;
	}
	public static List<SpeedingTickets> getAll() throws SQLException
	{
		List<SpeedingTickets> tickets = new ArrayList<SpeedingTickets>();
		Connection conn = DBHelper.getConnection();
		String query = "Select * from SpeedingTickets";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt("id");
			String driver = rs.getString("driver");
			String licensePlate = rs.getString("licensePlate");
			int kmOverLimit = rs.getInt("kmOverLimit");
			SpeedingTickets ticket = new SpeedingTickets(id,driver,licensePlate,kmOverLimit);
			tickets.add(ticket);
		}
		DBHelper.closeConnection();
		return tickets;
	}
	public static int create(SpeedingTickets ticket) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "Insert into SpeedingTickets (driver, licensePlate, kmOverLimit) values (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, ticket.getDriver());
		ps.setString(2, ticket.getLicensePlate());
		ps.setInt(3, ticket.getKmOverLimit());
		int affectedRows = ps.executeUpdate();
		DBHelper.closeConnection();
		return affectedRows;
	}
	public static int delete(int id) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "delete from SpeedingTickets where id = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, id);
		int affectedRows = ps.executeUpdate();
		DBHelper.closeConnection();
		return affectedRows;
	}
	public static int update(SpeedingTickets ticket) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "update SpeedingTickets set driver = ?, licensePlate = ?, kmOverLimit = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, ticket.getDriver());
		ps.setString(2, ticket.getDriver());
		ps.setInt(3, ticket.getKmOverLimit());
		ps.setInt(4, ticket.getId());
		int affectedRows = ps.executeUpdate();
		DBHelper.closeConnection();
		return affectedRows;
	}
}

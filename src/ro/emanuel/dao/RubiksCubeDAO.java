package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.RubiksCube;

public class RubiksCubeDAO {
	public static RubiksCube getById(int id) throws SQLException
	{
		List<RubiksCube> cubes = RubiksCubeDAO.getAll();
		for(RubiksCube r:cubes)
		{
			if(r.getId()==id)
			{
				return r;
			}
		}
		return null;
	}
	public static List<RubiksCube> getAll() throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String query = "select * from RubiksCube";
		List<RubiksCube> cubes = new ArrayList<RubiksCube>();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			String brand = rs.getString("brand");
			double weight = rs.getDouble("weight");
			int sides = rs.getInt("sides");
			RubiksCube cube = new RubiksCube(id,brand,weight,sides);
			cubes.add(cube);
		}
		DBHelper.closeConnection();
		return cubes;
	}
	public static void create(RubiksCube cube) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "INSERT INTO RubiksCube (brand, weight, sides)\n"
				+ "VALUES (?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, cube.getBrand());
		ps.setDouble(2, cube.getWeight());
		ps.setInt(3, cube.getSides());
		ps.executeUpdate();
		DBHelper.closeConnection();
	}
	public static void delete(int id) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "Delete from RubiksCube where id = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBHelper.closeConnection();
	}
	public static int update(RubiksCube cube) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "Update RubiksCube set brand = ?, weight = ?, sides = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, cube.getBrand());
		ps.setDouble(2, cube.getWeight());
		ps.setInt(3, cube.getSides());
		ps.setInt(4, cube.getId());
		int affectedRow = ps.executeUpdate();
		return affectedRow;
	}
}

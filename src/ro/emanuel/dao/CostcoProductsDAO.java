package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.CostcoProducts;

public class CostcoProductsDAO {
	public static CostcoProducts getById(int id) throws SQLException
	{
		List<CostcoProducts> products = CostcoProductsDAO.getAll();
		for(CostcoProducts p : products)
		{
			if(p.getId()==id)
			{
				return p;
			}
		}
		return null;
	}
	public static List<CostcoProducts> getAll() throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String query = "select * from CostcoProducts";
		List<CostcoProducts> products = new ArrayList<CostcoProducts>();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String location = rs.getString("location");
			int price = rs.getInt("price");
			CostcoProducts product = new CostcoProducts(id,name,location,price);
			products.add(product);
		}
		DBHelper.closeConnection();
		return products;
	}
	public static int create(CostcoProducts product) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "Insert into CostcoProducts (name, location, price) values (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, product.getName());
		ps.setString(2, product.getLocation());
		ps.setInt(3, product.getPrice());
		int affectedRows = ps.executeUpdate();
		DBHelper.closeConnection();
		return affectedRows;
	}
	public static int update(CostcoProducts product) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "update CostcoProducts set name = ?, location = ?, price = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, product.getName());
		ps.setString(2, product.getLocation());
		ps.setInt(3, product.getPrice());
		ps.setInt(4, product.getId());
		int affectedRows = ps.executeUpdate();
		DBHelper.closeConnection();
		return affectedRows;
	}
	public static int delete(int id) throws SQLException
	{
		Connection conn = DBHelper.getConnection();
		String update = "Delete from CostcoProducts where id = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, id);
		int affectedRows = ps.executeUpdate();
		DBHelper.closeConnection();
		return affectedRows;
	}
}

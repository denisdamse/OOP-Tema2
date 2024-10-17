package ro.emanuel.project;

import java.sql.SQLException;

import ro.emanuel.dao.CostcoProductsDAO;
import ro.emanuel.dao.RubiksCubeDAO;
import ro.emanuel.dao.SpeedingTicketsDAO;
import ro.emanuel.pojo.CostcoProducts;
import ro.emanuel.pojo.RubiksCube;
import ro.emanuel.pojo.SpeedingTickets;

public class Main {
	public static void main(String[] args) throws SQLException
	{
		SpeedingTickets t = new SpeedingTickets("Denis","AB79GHT",34);
		SpeedingTickets t1 = new SpeedingTickets("Florin","BC79SHT",14);
		SpeedingTicketsDAO.create(t);
		SpeedingTicketsDAO.create(t1);
		SpeedingTicketsDAO.getAll();
		SpeedingTicketsDAO.getById(3);
		SpeedingTicketsDAO.delete(9);
		SpeedingTicketsDAO.update(t);
		
		CostcoProducts p = new CostcoProducts("shavingCream","Flagstaff",34);
		CostcoProductsDAO.create(p);
		CostcoProductsDAO.delete(5);
		CostcoProductsDAO.getById(2);
		CostcoProductsDAO.getAll();
		
		RubiksCube c = new RubiksCube("da best", 4.09, 6);
		RubiksCube cPtUpdate = new RubiksCube(3,"da ce nu", 4.9, 699);
		RubiksCubeDAO.create(c);
		RubiksCubeDAO.delete(9);
		RubiksCubeDAO.getById(4);
		System.out.println(RubiksCubeDAO.update(cPtUpdate));
		
	}
}

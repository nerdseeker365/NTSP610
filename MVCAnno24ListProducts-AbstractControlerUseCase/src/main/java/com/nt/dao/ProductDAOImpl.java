package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.ProductBO;

@Repository("prodDAO")
public class ProductDAOImpl implements ProductDAO {
	private static final String  GET_ALL_PRODUCTS="SELECT  PID,PNAME,PRICE,STOCKQTY,MFGDATE,EXPIRYDATE FROM MVC_PRODUCT ORDER BY PRICE";
	@Autowired	
	private  JdbcTemplate  jt;

	

	@Override
	public List<ProductBO> getAllProducts() {
		List<ProductBO> listBO=null;
		listBO=jt.query(GET_ALL_PRODUCTS, new ProductsExtractor());
		return listBO;
	}
	
	
	private  class  ProductsExtractor implements ResultSetExtractor<List<ProductBO>>{

		@Override
		public List<ProductBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			 List<ProductBO> listBO=null;
			 ProductBO bo=null;
			 //copy ResultSet obj records ListBO objs
			 listBO=new ArrayList();
			 while(rs.next()) {
				 //copy each record to BO class object
				 bo=new ProductBO();
				 bo.setPid(rs.getInt(1));
				 bo.setPname(rs.getString(2));
				 bo.setPrice(rs.getFloat(3));
				 bo.setStockQty(rs.getFloat(4));
				 bo.setMfgDate(rs.getDate(5));
				 bo.setExpiryDate(rs.getDate(6));
				 //add BO to List Collection
				 listBO.add(bo);
			 }
			
			return listBO;
		}//method
		
	}//inner class
}//outer class

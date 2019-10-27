package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.HotelInfoBO;

@Repository
public class HotelInfoDAOImpl implements HotelInfoDAO {
	private static  final String  GET_ALL_HOTELS="SELECT HNO,HNAME,LOCATION,TYPE,RATING,COSTFOR2 FROM HOTEL_INFO";
	private static final String  GET_HOTEL_BY_NO="SELECT HNO,HNAME,LOCATION,TYPE,RATING,COSTFOR2 FROM HOTEL_INFO WHERE HNO=?";
	private static final String UPDATE_HOTEL_INFO_BY_ID="UPDATE HOTEL_INFO SET RATING=?,COSTFOR2=? WHERE HNO=?";
	private AllHotelInfoSelector selector1;
	private HotelSelector2  selector2;
	private  HotelUpdator  updator1;
	
	@Autowired
	public HotelInfoDAOImpl(DataSource ds) {
		selector1=new AllHotelInfoSelector(ds, GET_ALL_HOTELS);
		selector2=new HotelSelector2(ds, GET_HOTEL_BY_NO);
		updator1=new HotelUpdator(ds, UPDATE_HOTEL_INFO_BY_ID);
	}

	@Override
	public List<HotelInfoBO> getAllHotelDetails() {
		List<HotelInfoBO> listBO=null;
		listBO=selector1.execute();
		return listBO;
	}
	
	@Override
	public HotelInfoBO getHotelDetailsById(int no) {
		HotelInfoBO bo=null;
		bo=selector2.findObject(no);
		return bo;
	}
	
	@Override
	public int updateHotelInfoByNo(int newrating, int newCost, int hno) {
		int count=0;
		count=updator1.update(newrating,newCost,hno);
		return count;
	}
	
	//..............................................................................................
	  //inner class1
	private static   class  AllHotelInfoSelector extends MappingSqlQuery<HotelInfoBO>{

		public AllHotelInfoSelector(DataSource ds,String query) {
			super(ds,query);
			super.compile();
		}
		
		@Override
		public HotelInfoBO mapRow(ResultSet rs, int index) throws SQLException {
			System.out.println("HotelInfoDAOImpl.AllHotelInfoSelector.mapRow(-,-)");
			  HotelInfoBO bo=null;
			  bo=new HotelInfoBO();
			  bo.setHno(rs.getInt(1));
			  bo.setHname(rs.getString(2));
			  bo.setLocation(rs.getString(3));
			  bo.setType(rs.getString(4));
			  bo.setRating(rs.getInt(5));
			  bo.setCostfor2(rs.getFloat(6));
			return bo;
		}//method
		
	}//inner class1
	
	//inner class2
	private static class HotelSelector2 extends MappingSqlQuery<HotelInfoBO>{

		  public HotelSelector2(DataSource ds,String query) {
		     super(ds,query);
		     declareParameter(new SqlParameter(Types.INTEGER));
		     compile();
		}
		  
		@Override
		public HotelInfoBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("HotelInfoDAOImpl.HotelSelector2.mapRow(-,-)");
			  HotelInfoBO bo=null;
			  bo=new HotelInfoBO();
			  bo.setHno(rs.getInt(1));
			  bo.setHname(rs.getString(2));
			  bo.setLocation(rs.getString(3));
			  bo.setType(rs.getString(4));
			  bo.setRating(rs.getInt(5));
			  bo.setCostfor2(rs.getFloat(6));
			return bo;
		}//method
	}//inner class2
	//inner class3
	private static class HotelUpdator  extends SqlUpdate {
		
		public HotelUpdator(DataSource ds,String query) {
			super(ds,query);
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			compile();
		}
	}//inner class3
	
}//outer class

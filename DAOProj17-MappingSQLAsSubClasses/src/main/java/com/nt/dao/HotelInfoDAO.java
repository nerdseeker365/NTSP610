package com.nt.dao;

import java.util.List;

import com.nt.bo.HotelInfoBO;

public interface HotelInfoDAO {
	public List<HotelInfoBO>  getAllHotelDetails();
	public  HotelInfoBO  getHotelDetailsById(int no);
	public  int updateHotelInfoByNo(int newrating,int newCost,int hno);

}

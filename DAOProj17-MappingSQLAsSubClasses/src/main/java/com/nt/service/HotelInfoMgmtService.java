package com.nt.service;

import java.util.List;

import com.nt.dto.HotelInfoDTO;

public interface HotelInfoMgmtService {
	
	public  List<HotelInfoDTO>  searchAllHotels();
	public  HotelInfoDTO  searchHotelByNo(int hno);
	public  String  modifyHoteInfoByNo(int newRating,int newCost,int hno);

}

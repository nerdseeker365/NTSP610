package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.HotelInfoBO;
import com.nt.dao.HotelInfoDAO;
import com.nt.dto.HotelInfoDTO;

@Service("hotelService")
public class HoteInfoMgmtServiceImpl implements HotelInfoMgmtService {
   @Autowired
	private HotelInfoDAO dao;
   
	@Override
	public List<HotelInfoDTO> searchAllHotels() {
		List<HotelInfoBO> listBO=null;
		List<HotelInfoDTO> listDTO=new ArrayList();
		
		//use DAO
		listBO=dao.getAllHotelDetails();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			HotelInfoDTO dto=new HotelInfoDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	public HotelInfoDTO searchHotelByNo(int hno) {
		HotelInfoBO bo=null;
		HotelInfoDTO dto=null;
		//use DAO
		bo=dao.getHotelDetailsById(hno);
		//Convert BO to DTO
		dto=new HotelInfoDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	@Override
		public String modifyHoteInfoByNo(int newRating, int newCost, int hno) {
		int count=0;
		//use DAO
		count=dao.updateHotelInfoByNo(newRating, newCost, hno);
		if(count==0)
			return hno+"  Hotel not found to update";
		else
			return hno+"  Hotel  new rating="+newRating+" new Cost="+newCost;
		}//method
}

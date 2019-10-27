package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.PassengerBO;
import com.nt.dao.TravelAgentDAO;
import com.nt.dto.PassengerDTO;

@Service("agentService")
public class TravelAgenServiceImpl implements TravelAgentService {
	@Autowired
	 private  TravelAgentDAO  dao;

	@Override
	public String doGroupReservation(List<PassengerDTO> listDTO) {
		List<PassengerBO> listBO=new ArrayList<>();
		int result[]=null;
		   //covert listDTO to listBO
		listDTO.forEach(dto->{
			PassengerBO bo=new PassengerBO();
			BeanUtils.copyProperties(dto, bo);
			listBO.add(bo);
		});
		//use DAO
		result=dao.insertBatch(listBO);
		if(result!=null)
		     return "Group Reservation Succeded";
		else
			 return "Group Reservation Failed";
	}

}

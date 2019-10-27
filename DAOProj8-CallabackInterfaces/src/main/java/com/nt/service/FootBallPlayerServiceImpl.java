package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.FootBallPlayerBO;
import com.nt.dao.FootBallPlayerDAO;
import com.nt.dto.FootBallPlayerDTO;

public class FootBallPlayerServiceImpl implements FootBallPlayerService {
	private FootBallPlayerDAO dao;

	public FootBallPlayerServiceImpl(FootBallPlayerDAO dao) {
		this.dao = dao;
	}

	@Override
	public FootBallPlayerDTO searchPlayerById(int id) {
		FootBallPlayerBO bo=null;
		FootBallPlayerDTO dto=null;
          //use DAO
		bo=dao.findPlayerById(id);
		//convert BO to DTO
		dto=new FootBallPlayerDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	@Override
	public List<FootBallPlayerDTO> searchPlayerRole(String role) {
		List<FootBallPlayerBO> listBO=null;
		List<FootBallPlayerDTO> listDTO=new ArrayList();
		
	    //use DAO
		listBO=dao.findPlayersByRole(role);
		//convert ListBO to ListDTO
		listBO.forEach(bo->{
			FootBallPlayerDTO dto=new FootBallPlayerDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class

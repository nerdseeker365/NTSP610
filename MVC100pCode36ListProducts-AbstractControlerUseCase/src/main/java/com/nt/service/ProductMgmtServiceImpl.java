package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.ProductBO;
import com.nt.dao.ProductDAO;
import com.nt.dto.ProductDTO;

@Service("prodService")
public class ProductMgmtServiceImpl implements ProductMgmtService {
	@Autowired
	private ProductDAO dao;
	

	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,transactionManager="dsTxMgmr")
	public List<ProductDTO> fetchAllProducts() {
		List<ProductBO> listBO=null;
		List<ProductDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllProducts();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			ProductDTO dto=new ProductDTO();
			//Copy each BO to each DTO
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method
}//class

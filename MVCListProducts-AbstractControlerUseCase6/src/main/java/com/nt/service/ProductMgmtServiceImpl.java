package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.ProductBO;
import com.nt.dao.ProductDAO;
import com.nt.dto.ProductDTO;

public class ProductMgmtServiceImpl implements ProductMgmtService {
	private ProductDAO dao;
	

	public ProductMgmtServiceImpl(ProductDAO dao) {
		this.dao = dao;
	}


	@Override
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

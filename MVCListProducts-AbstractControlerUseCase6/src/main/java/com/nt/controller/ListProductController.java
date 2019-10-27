package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.ProductDTO;
import com.nt.service.ProductMgmtService;

public class ListProductController extends AbstractController {
	private ProductMgmtService  service;

	public ListProductController(ProductMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
      List<ProductDTO> listDTO=null;
      ModelAndView mav=null;
		//use Service
      listDTO=service.fetchAllProducts();
      //create and return MAV
      mav=new ModelAndView();
      mav.addObject("listProds",listDTO);
      mav.setViewName("list_prods");
		return mav;
	}

}

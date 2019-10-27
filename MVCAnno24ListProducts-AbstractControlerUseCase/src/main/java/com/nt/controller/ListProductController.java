package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.dto.ProductDTO;
import com.nt.service.ProductMgmtService;

@Controller
public class ListProductController {
  @Autowired
	private ProductMgmtService  service;
  
  
  @RequestMapping("/welcome.htm")
  public  String  showHome() {
	  return "home";
  }
	
  @RequestMapping("/prod.htm")
	public String fetchProducts(Map<String,Object> map) {
      List<ProductDTO> listDTO=null;
 		//use Service
      listDTO=service.fetchAllProducts();
      //put model data
      map.put("listProds",listDTO);
 		return "list_prods";
	}

}

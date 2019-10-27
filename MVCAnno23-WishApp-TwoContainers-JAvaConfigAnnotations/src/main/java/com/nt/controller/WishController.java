package com.nt.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Resource
	private WishService service;
	
	@RequestMapping("/welcome.htm")
	public   String showHome() {
		return "home";
	}
	
	/*@RequestMapping("/wish.htm")
	public   ModelAndView   process() {
		String msg=null;
		//use service
		msg=service.generate();
		return  new ModelAndView("result","msg",msg);
	} */
	
	/*@RequestMapping("/wish.htm")
	public   String   process(Model model) {
		String msg=null;
		//use service
		msg=service.generate();
		//put model data
		model.addAttribute("msg",msg);
		System.out.println(model.getClass());
		return "result";
	}  */
	
	/*@RequestMapping("/wish.htm")
	public   String   process(ModelMap map) {
		String msg=null;
		//use service
		msg=service.generate();
		//put model data
		map.addAttribute("msg",msg);
		return "result";
	} */
	
@RequestMapping("/wish.htm")
	public   String   process(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generate();
		//put model data
		map.put("msg",msg);
		return "result";
	}
	
	/*@RequestMapping("/wish.htm")
	public   void   process(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generate();
		//put model data
		map.put("msg",msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  Model   process() {
		String msg=null;
		Model model=null;
		//use service
		msg=service.generate();
		//put model data
		model=new ExtendedModelMap();
		model.addAttribute("msg", msg);
		return model;
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  ModelMap   process() {
		String msg=null;
		ModelMap map=null;
		//use service
		msg=service.generate();
		//put model data
		map=new ModelMap();
		map.addAttribute("msg", msg);
		return map;
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public Map<String,Object>   process() {
		String msg=null;
		Map<String,Object> map=null;
		//use service
		msg=service.generate();
		//put model data
		map=new HashMap();
		map.put("msg",msg);
		return map;
	} */
	
	/*@RequestMapping("/wish.htm")
	public Map<String,Object>   process(HttpServletRequest req,
			                                                                HttpServletResponse res) {
		String msg=null;
		Map<String,Object> map=null;
		//use service
		msg=service.generate();
		//put model data
		map=new HashMap();
		map.put("msg",msg);
		return map;
	} */

}

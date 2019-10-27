package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.HotelInfoMgmtService;

public class MappingSQLOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		HotelInfoMgmtService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class  object
		service=ctx.getBean("hotelService",HotelInfoMgmtService.class);
		//invoke method
		try {
			System.out.println("All Hotel Details"+service.searchAllHotels());
			System.out.println("........................................");
			System.out.println("Hotel 3 details are::"+service.searchHotelByNo(3));
			System.out.println("...........................................");
			System.out.println(service.modifyHoteInfoByNo(5,1500, 2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class

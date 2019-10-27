package com.nt.test;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.PassengerDTO;
import com.nt.service.TravelAgentService;

public class BatchProcessingTest {

	public static void main(String[] args) {
		Scanner sc=null;
	      int  groupSize=0;
	      String boardingPlace=null;
	      String destPlace=null;
	      List<PassengerDTO> listDTO=null;
	      PassengerDTO dto=null;
	      ApplicationContext ctx=null;
	      TravelAgentService service=null;
	      //read inputs
	      sc=new Scanner(System.in);
	      if(sc!=null) {
	    	  System.out.println("Enter group Size");
	    	  groupSize=sc.nextInt();
	    	  System.out.println("Enter Borading Place::");
	    	  boardingPlace=sc.next();
	    	  System.out.println("Enter Destination Place::");
	    	  destPlace=sc.next();
	      }
	      //gather Details and put them in LISTDTO objects
	      listDTO=new ArrayList(groupSize);
	      for(int i=0;i<groupSize;++i) {
	    	  dto=new PassengerDTO();
	    	  dto.setBoardingPlace(boardingPlace);
	    	  dto.setDestPlace(destPlace);
	    	  if(sc!=null) {
	    		  System.out.println("Enter "+ (i+1) +" passenger name::");
	    		  dto.setPsngrName(sc.next());
	    		  System.out.println("Enter "+(i+1)+" passenger Gender::");
	    		  dto.setGender(sc.next());
	    	  }
	    	  listDTO.add(dto);
	      }
	      
	      //create IOC Container
	      ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	      //get Bean
	      service=ctx.getBean("agentService",TravelAgentService.class);
	      //invoke method
	      try {
	    	  System.out.println(service.doGroupReservation(listDTO));
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      
	      
	      //close container
	      ((AbstractApplicationContext) ctx).close();
	      

	}//main
}//class

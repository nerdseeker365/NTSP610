package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		BeanFactory pFactory=null,cFactory=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		//create Parent Container
		pFactory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/business-beans.xml"));
		//create Child Container
		cFactory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/presentation-beans.xml"),pFactory);
				                                                     
		//get Controller
		controller=cFactory.getBean("controller",MainController.class);
		//invoke methods
		try {
			listVO=controller.getEmpsByDesg("CLERK");
			//display results
			for(EmployeeVO vo:listVO) {
				System.out.println(vo);
			}
		}
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
		}
		

	}//main
}//class

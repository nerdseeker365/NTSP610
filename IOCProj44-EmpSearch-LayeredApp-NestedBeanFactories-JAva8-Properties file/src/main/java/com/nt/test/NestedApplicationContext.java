package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.TestBean;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedApplicationContext {

	public static void main(String[] args) {
		ApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		TestBean tb=null;
		//create Parent Container
		pCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create Child Container
		cCtx=new ClassPathXmlApplicationContext(new String[]{"com/nt/cfgs/presentation-beans.xml"},
				                                                                         pCtx);
		//get Controller
		controller=cCtx.getBean("controller",MainController.class);
		//invoke methods
		try {
			listVO=controller.getEmpsByDesg("CLERK");
			//display results
			listVO.forEach(vo->{
				System.out.println(vo);
			});
			System.out.println(".....................................");
			tb=cCtx.getBean("tb",TestBean.class);
			System.out.println(tb);
			
		}
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
		}
		

	}//main
}//class

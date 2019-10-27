package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.nt.config.BusinessConfig;
import com.nt.config.PresentationConfig;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedBeanFactoryTest1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		//create Parent Container
		pCtx=new AnnotationConfigApplicationContext(BusinessConfig.class);
		//create Child Container
		cCtx=new AnnotationConfigApplicationContext(PresentationConfig.class);
		cCtx.setParent(pCtx);
		//get Controller
		controller=cCtx.getBean("controller",MainController.class);
		//invoke methods
		try {
			listVO=controller.getEmpsByDesg("CLERK");
			//display results
			listVO.forEach(vo->{
				System.out.println(vo);
			});
		}
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
		}
		

	}//main
}//class

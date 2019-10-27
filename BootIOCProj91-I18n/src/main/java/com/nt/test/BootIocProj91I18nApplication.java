package com.nt.test;

import java.awt.FlowLayout;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class BootIocProj91I18nApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Locale l=null;
		String l1=null,l2=null,l3=null,l4=null;
		JFrame frame=null;
		JButton btn1=null,btn2=null,btn3=null,btn4=null;
		//get Container
		ctx=SpringApplication.run(BootIocProj91I18nApplication.class, args);
         //prepare Locale obj
		l=new Locale("h","y");
		l1=ctx.getMessage("btn.cap1",new Object[]{}, l);
		l2=ctx.getMessage("btn.cap2",new Object[]{}, l);
		l3=ctx.getMessage("btn.cap3",new Object[]{}, l);
		l4=ctx.getMessage("btn.cap4",new Object[]{}, l);
		System.out.println(l1+  "  "+l2+"  "+l3+"  "+l4);
		//create Frame
				//create JFrame and Buttions
				 frame=new JFrame();
				 btn1=new JButton(l1);
				 btn2=new JButton(l2);
				 btn3=new JButton(l3);
				 btn4=new JButton(l4);
				 frame.add(btn1);
				 frame.add(btn2);
				 frame.add(btn3);
				 frame.add(btn4);
				 
				 frame.setVisible(true);
				 frame.setTitle("I18nApp");
				 frame.setLayout(new FlowLayout());
				 frame.pack();
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
		
	}//main
}//class


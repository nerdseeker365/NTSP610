package com.nt.service;

import java.util.Date;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("purchase")
public class PurchaseOrderImpl implements PurchaseOrder {
	@Autowired
	private JavaMailSender sender;

	@Override
	public String purchase(String[] items,String ToEmail)throws Exception {
		Random rad=null;
		float billAmt=0.0f;
		int orderId=0;
		String msg=null;
		rad=new Random();
		billAmt=items.length*1000;
		orderId=rad.nextInt(10000);
		msg=orderId+" order is confirmed -->bill Amount::"+billAmt;
		 sendEmail(ToEmail,msg);
		return msg;
	}
	
	private  void sendEmail(String ToEmail,String msg)throws Exception {
		MimeMessageHelper helper=null;
		MimeMessage message=null;
		//prepare Email messages
		message=sender.createMimeMessage();
		helper=new MimeMessageHelper(message,true);
		helper.setFrom(new InternetAddress("aimsarbaj@gmail.com"));
		helper.setTo(new InternetAddress(ToEmail));
		helper.setSubject("open it to know it");
		helper.setText(msg);
		helper.setSentDate(new Date());
		helper.addAttachment("ford.jpg", new ClassPathResource("ford-mustang.jpg"));
		sender.send(message);
	  System.out.println("mail has been delivered"); 
	}
}

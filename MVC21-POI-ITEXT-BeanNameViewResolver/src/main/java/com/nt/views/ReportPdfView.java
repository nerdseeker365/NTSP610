package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.EmployeeDTO;

public class ReportPdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<EmployeeDTO> listDTO=null;
		Paragraph p=null;
		Table t=null;
		//get Model Attribute data
		listDTO=(List<EmployeeDTO>) model.get("listDTO");
		//add paragraph
		p=new Paragraph("Employees Report",new Font(Font.BOLD));
		doc.add(p);
		// add table
		t=new Table(5,listDTO.size());
		for(EmployeeDTO dto:listDTO){
			t.addCell(String.valueOf(dto.getEno()));
			t.addCell(dto.getEname());
			t.addCell(dto.getDesg());
			t.addCell(String.valueOf(dto.getSalary()));
			t.addCell(dto.getAddrs());
		}
	  doc.add(t);
		
		
	}//method
}//class

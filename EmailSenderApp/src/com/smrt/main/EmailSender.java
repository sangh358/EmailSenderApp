package com.smrt.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.smrt.util.EmailServletResponse;
import com.smrt.util.EmailUtil;
@WebServlet("/emailsender")
public class EmailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		/*String subject=request.getParameter("subject");*/
		/*String message=request.getParameter("desciption");*/
		String fromemail=request.getParameter("fromemail");
		String pass=request.getParameter("pass");
		String smtpnum=request.getParameter("smtpnum");
		String path="/home/tushar/newsvn/EmailSenderApp/WebContent/resources/subject.txt";
		/*String path="C:\\data\\subject.txt";*/
		String subject=readFile(path);
		System.out.println("this is sub"+subject);
		ArrayList<String> emaillist=new ArrayList<String>();
		ArrayList<String> elist=new ArrayList<String>();
		try {
			OPCPackage pkg = OPCPackage.open(new File("/home/tushar/newsvn/EmailSenderApp/WebContent/resources/Email.xls"));
			/*OPCPackage pkg = OPCPackage.open(new File("C:\\data\\Email.xls"));*/
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			XSSFSheet sheet=wb.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;

			Iterator rows = sheet.rowIterator();

			while (rows.hasNext())
			{
				row=(XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				
				while (cells.hasNext())
				{
					cell=(XSSFCell) cells.next();
					/*System.out.println(cell.getStringCellValue()+" ");*/
					emaillist.add(cell.getStringCellValue());
					/*if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
					{
						
					}
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
					{
						System.out.print(cell.getNumericCellValue()+" ");
					}
					else
					{
						//U Can Handel Boolean, Formula, Errors
					}*/
				}
				System.out.println();
	   }
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String st : emaillist) {
			/*try {*/
				//RequestDispatcher s=request.getRequestDispatcher("/SmartLeaven Technologies.jsp");
				/*request.setAttribute("text",message );*/
				
				
				/*if(st.contains(".com") || st.contains(".in") || st.contains(".org" )|| st.contains(".net") ){
					String cname[]=st.split(".");
					System.out.println(cname[0]);
					System.out.println(cname[1]);
				}*/
				
				if(st.contains("@") && st.contains(".") ){
					elist.add(st);
					System.out.println("elist"+elist);
					/*EmailUtil.sendEmail(fromemail,pass,st, subject, emailServletResponse.toString());*/
					

				}
				
			/*} catch (AddressException e) {
				request.getRequestDispatcher("/fail.jsp").forward(request,
						response);
				e.printStackTrace();
			} catch (MessagingException e) {
				request.getRequestDispatcher("/fail.jsp").forward(request,
						response);
				e.printStackTrace();
			}*/
		}
		RequestDispatcher s=request.getRequestDispatcher("/smartleaven.jsp");
		EmailServletResponse emailServletResponse=new EmailServletResponse();
		s.forward(request,emailServletResponse);
		try {
			EmailUtil.sendEmail(fromemail,pass,elist, subject, emailServletResponse.toString());
			request.getRequestDispatcher("/success.jsp").forward(request,
					response);
		} catch (MessagingException e) {
			request.getRequestDispatcher("/fail.jsp").forward(request,
					response);
			e.printStackTrace();
		}

	}
	private String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}

}

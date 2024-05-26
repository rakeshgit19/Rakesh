package Run_Factory;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Constant_Functions.PbConstant;
import Function_Library.Library;

public class DataDriven_Framework extends PbConstant
{

	@Test
	public void dataDriven() throws IOException
	{
		
		Library l = new Library();
		
		
		FileInputStream fis = new FileInputStream("D://Framework_Rakesh//Maven_Project//Input_File//Logindata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh = wb.getSheet("Login");
		  XSSFRow r = sh.getRow(0);
		  
		  //get no of rows
		  int rc = sh.getLastRowNum();
		  System.out.println("no of rows are :" +rc);
		  
		  //get no of cells
		  int cc = r.getLastCellNum();
		  System.out.println("no of coloumns are :" +cc);
		  
		  //for iteration
		  for (int i = 0; i < rc; i++) 
		  {
			//get row
			  XSSFRow r1 = sh.getRow(i);
			  //get cell
			  XSSFCell c1 = r1.getCell(0);
			  XSSFCell c2 = r1.getCell(1);
			  //get cell value
			  String username = c1.getStringCellValue();
			  
			  String password = c2.getStringCellValue();
			  
			  //for writing in excel i have to create cell
			  //XSSFCell c3 = r.createCell(2);
			  
			  //verify multiple data for admin login
			  l.login(username, password);
			  
			 
		  }
		

	}

}

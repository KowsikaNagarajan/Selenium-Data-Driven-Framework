package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadersample {
	
	public static void main(String[] args) throws Exception{
		//specify the path of the Excel file
		File src= new File("C:\\kowsika\\LEARNING\\Projects\\Selenium\\Data driven\\src\\resources\\Excel\\AccountCreation.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis); // this is class from ApachePOI, used to load the Excel workbook
		//HSSFworkbook can be used instead if the excel file is stored as .xsl file
		XSSFSheet sheet1=wb.getSheetAt(0);//load the specific sheet from excel file
		String data=sheet1.getRow(1).getCell(0).getStringCellValue();
		//.getrow(0) getting the 1st row value which is at index 0
		//.getcell(0) getting the 1st column value which is at index 0
		//.getStringcellvalue() getting the values of the cell in string format if it is string
		System.out.println("data from Excel is" +data);
		
	
	}
}

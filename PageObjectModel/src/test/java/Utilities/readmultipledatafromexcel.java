package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readmultipledatafromexcel {
	public static void main(String[] args) throws Exception{
		//specify the path of the Excel file
		File src= new File("C:\\kowsika\\LEARNING\\Projects\\Selenium\\Data driven\\src\\resources\\Excel\\AccountCreation.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis); // this is class from ApachePOI, used to load the Excel workbook
		//HSSFworkbook can be used instead if the excel file is stored as .xsl file
		XSSFSheet sheet1=wb.getSheetAt(0);
		int rowcount=sheet1.getLastRowNum();
		for(int i=0;i<=rowcount;i++)
		{
			String data=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from excel is" +data);
		}
	}
}


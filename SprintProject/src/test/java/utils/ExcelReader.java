package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class ExcelReader {

	public static String getCellData(String xlpath,String sheet,int row,int cell){ 
		String value="";
		try
		{
			FileInputStream file=new FileInputStream(xlpath);

			Workbook workbook=WorkbookFactory.create(file); 
			value=workbook.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			Reporter.log(e.getMessage());
		}
		return value;
	}


	public static int getRowCount(String xlpath,String sheet){
		int row_count=0;
		try
		{
			FileInputStream file=new FileInputStream(xlpath);

			Workbook wb=WorkbookFactory.create(file);
			row_count=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			Reporter.log(e.getMessage());
		}
		return row_count;
	}
}

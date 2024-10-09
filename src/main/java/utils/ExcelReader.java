package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demoshop.Context.Constants;

public class ExcelReader {
	
	public static String getCellValue(int row,int column) throws IOException {
		
		FileInputStream fis=new FileInputStream(Constants.EXCELFILEPATH);
		XSSFWorkbook b = new XSSFWorkbook(fis);
		XSSFSheet s = b.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c=r.getCell(column);
		return c.toString();
		
		
	}

}

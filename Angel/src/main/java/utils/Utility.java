package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
private WebDriver driver;
	public static void capture(WebDriver driver,int testId) throws IOException {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss");
		Date date=new Date();
		String dm= format.format(date);
		
		TakesScreenshot take=(TakesScreenshot)driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		File dest=new File("test-output\\Fail Test Screenshots"+testId+" " +dm+".jpg");
		FileHandler.copy(src, dest);
		
	}
	
	public static String excelSheet(String sheet,int Row,int Cell) throws EncryptedDocumentException, IOException {
		
		String path =("src\\test\\resources\\Data Sheets\\Data Sheet.xlsx");
		FileInputStream file=new FileInputStream(path);
		
		Cell cell =WorkbookFactory.create(file).getSheet(sheet).getRow(Row).getCell(Cell);
		try {
		String value=cell.getStringCellValue();
    	System.out.print (value);
		return value;
		}
		catch(IllegalStateException e) {
			long value1=(long) cell.getNumericCellValue();
			String str = String.valueOf(value1);
		    System.out.print (str);
			
			return str;
			
		}
	
	}
	
}

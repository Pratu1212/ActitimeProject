package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.j2objc.annotations.Property;

public class A2_FileLibrary {
	
	
	String	path="./Testdata/commondata.property";
		public String readDataFromePropertyFile(String key) throws IOException
		{
			
			FileInputStream fis=new FileInputStream(path);
			Properties p=new Properties();
			p.load(fis);
			String value = p.getProperty(key);//key give the value
			return value;
			
			
		}
	String path1="./Testdata/Testdata.xlsx";
		public String readDataFromExcelSheet(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream f=new FileInputStream(path1);
			Workbook wb = WorkbookFactory.create(f);
			String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			
			return data;
		}
	
}

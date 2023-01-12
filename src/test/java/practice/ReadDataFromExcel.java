package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtiger.GenericUtility.ExcelFileUtility;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		ExcelFileUtility eLib = new ExcelFileUtility();
		String ln = eLib.readDataFromExcel("Organization", 4, 2);
		System.out.println(ln);
	}

}

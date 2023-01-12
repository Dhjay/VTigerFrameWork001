package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcel(String sheet,int row,int cel) throws EncryptedDocumentException, IOException {
		
		FileInputStream fise = new FileInputStream(IConstantsUtilities.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cel);
		String value = c.getStringCellValue();
		return value;
	}
	
	public int getLastRowNumber(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fise = new FileInputStream(IConstantsUtilities.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		int value = wb.createSheet(sheet).getLastRowNum();
		return value;
	}
	
	public Object[][] readMultipleDataFromexcel(String sheet) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis = new FileInputStream(IConstantsUtilities.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MultilpleOrg");
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++){
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}

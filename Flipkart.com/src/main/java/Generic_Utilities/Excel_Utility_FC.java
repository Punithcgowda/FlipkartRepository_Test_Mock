package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility_FC 
{
	/**
	 * this method is used to insert data into excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
public void insertDataIntoExcel(String SheetName, int rowNum,int cellNum, String data) throws Throwable
{
	System.out.println("control come insert data to excel "+ data +" "+rowNum+" "+cellNum);
	FileInputStream fileInputStream =new FileInputStream(IPathConstants.excelPath);   //excelPath2
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(SheetName);
	//Row row = sheet.createRow(rowNum);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.createCell(cellNum);
	cell.setCellValue(data);
    FileOutputStream fileOututStream = new FileOutputStream(IPathConstants.excelPath);
	workbook.write(fileOututStream);
	fileOututStream.flush();	
	workbook.close();
	
	
}
/**
 * This method is used to fetch data from the excel sheet
 * @param SheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @return
 * @throws Throwable
 */
public String getoExcelData(String SheetName,int rowNum, int cellNum) throws Throwable
{
	System.out.println("control come to get data fron excel "+SheetName+" "+ rowNum+" "+cellNum);
	FileInputStream fileInputStream =new FileInputStream(IPathConstants.excelPath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(SheetName);
	
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	DataFormatter dataFormatter= new DataFormatter();
	String data = dataFormatter.formatCellValue(cell);
	System.out.println("data in excel before return  :"+data);
	return data;
}
/**
 * This method is used to get count of rowa created in excel sheet
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getRowNumber(String SheetName) throws EncryptedDocumentException, IOException 
{
	FileInputStream fileInputStream =new FileInputStream(IPathConstants.excelPath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(SheetName);
	int row = sheet.getLastRowNum();
	return row;
	
}

/**
 * 
 */
public void insertMutipleDataIntoExcel(String SheetName,int rowNum, int cellNum, String data) throws Throwable
{
	System.out.println("control come insert data to excel "+ data +" "+ rowNum+" "+cellNum);
	FileInputStream fileInputStream =new FileInputStream(IPathConstants.excelPath);   //excelPath2
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(SheetName);
	//Row row = sheet.createRow(rowNum);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.createCell(cellNum);
	cell.setCellValue(data);
    FileOutputStream fileOututStream = new FileOutputStream(IPathConstants.excelPath);
	workbook.write(fileOututStream);
	fileOututStream.flush();	
	workbook.close();

}
}

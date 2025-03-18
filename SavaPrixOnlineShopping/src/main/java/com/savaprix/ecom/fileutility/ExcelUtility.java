package com.savaprix.ecom.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {
	public static String excelPath = ".\\src\\main\\resources\\Products.xlsx";
	/**
	 * Returns the data present in the cell
	 * @param sheetName name of the sheet
	 * @param rowNum row number
	 * @param cellNum cell number
	 * @return the data present in the cell in form of String 
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) {
		
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		} catch (IOException e) {}
		return "-999";
	}
	
	
	/**
	 * Returns the row count of the sheet
	 * @param sheetName  name of teh sheet
	 * @return row count in int
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	
	/**
	 * Writes the data back into the sheet
	 * @param sheetName name of the sheet
	 * @param rowNum row number to write data into
	 * @param cellNum cell number to write data into
	 * @param data the actual `data` to write it into
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
	    // Get the sheet by its name
	   Sheet sheet = wb.getSheet(sheetName);
	    // If the row does not exist, create it
	    Row row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }
	    // If the cell does not exist, create it
	    Cell cell = row.getCell(cellNum);
	    if (cell == null) {
	        cell = row.createCell(cellNum);
	    }
	    // Set the value of the cell
	    cell.setCellValue(data);
	    // Close the FileInputStream as it is no longer needed
	    fis.close();
	    // Create a FileOutputStream to save the changes
	    FileOutputStream fos = new FileOutputStream(excelPath);
	    // Write the changes back to the file
	    wb.write(fos);
	    // Close the FileOutputStream
	    fos.close();
	    // Close the workbook
	    wb.close();
	}
}

package org.emp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcell {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\nandh\\OneDrive\\Desktop\\Excels\\Nandhini.xlsx");
		FileOutputStream out = new FileOutputStream(f);
		Workbook book = new XSSFWorkbook();
		Sheet createSheet = book.createSheet("NameSheet");
		
		Row createRow = createSheet.createRow(0);
		Cell createCell = createRow.createCell(0);
		
		createCell.setCellValue("Nandhini");
	
		book.write(out);
//		Row createRow2 = createSheet.createRow(0);
//		Cell createCell2 = createRow2.createCell(1);
//		
//		createCell2.setCellValue("nandhini123@gmail.com");
//		book.write(out);
//		
//		Row createRow3 = createSheet.createRow(0);
//		Cell createCell3 = createRow3.createCell(2);
//		
//		createCell3.setCellValue(30/01/1992);
//		book.write(out);
//		
//		Row createRow4 = createSheet.createRow(0);
//		Cell createCell4 = createRow4.createCell(3);
//		
//		createCell4.setCellValue(91.7708117999);
//		book.write(out);
	}

}

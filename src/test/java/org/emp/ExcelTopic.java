package org.emp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTopic {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\nandh\\OneDrive\\Desktop\\Excels\\LoginData.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook bk = new XSSFWorkbook(stream);
		Sheet st1 = bk.getSheet("Sheet1");
		for (int i=0; i<st1.getPhysicalNumberOfRows(); i++) {
		Row row = st1.getRow(i);
		for(int j=0; j<row.getPhysicalNumberOfCells(); j++) {
		Cell cell = row.getCell(j);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			String stringCellValue = cell.getStringCellValue();
			System.out.print(stringCellValue+"\t");
			break;
		case NUMERIC: 
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				String fmat = date.format(dateCellValue);
				System.out.print("\t"+fmat);
				
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal bd = BigDecimal.valueOf(numericCellValue);
				String st = bd.toString();
				System.out.print("\t"+st);
			}
			break;
			default:
				System.out.println("Invaild");
				break;
		}
		
		}
		System.out.println();
	}}}

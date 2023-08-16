package Utils;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelFile {
public static String[][] ReadExcel(String excelName) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook("data/"+excelName+".xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		//  Check Here 
		int rowNum = sheet.getLastRowNum();
		short columnNum = sheet.getRow(rowNum).getLastCellNum();
		
		String [] [] data = new String [rowNum] [columnNum];
		// Not getting inside Loop
		
		for(int i=1;i<=rowNum;i++) {
		XSSFRow row = sheet.getRow(i);
			for(int j=0;j<columnNum;j++) {
				XSSFCell cell = row.getCell(j);
				//System.out.println(cell.getStringCellValue());
				data[i-1][j]=cell.getStringCellValue();
				
							}
		}
		
		workbook.close();
        return data;

	}

}

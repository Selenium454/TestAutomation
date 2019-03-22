package testData;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import genericFunctions.Constants_Global;

public class ReadData {
	
	public static String key = null;
	public static String value = null;

	public void mapEx() {

		Map<String, String> data = new HashMap<String, String>();

		data.put("01", "Selenium");
		data.put("02", "Webdriver");

		System.out.println(data.get("01"));

		System.out.println(data.get("02"));

		data.put("TestCaseName", "Registration");

		data.put("TestCaseName", "YourOrders");

		System.out.println(data.get("TestCaseName"));
	}

	/*
	 * public static void main(String[] args) { getTestData("Sheet1",
	 * "Registration"); }
	 */
	
	public static Map<String, String> getTestData(String sheet,String testCaseName) {
		Map<String, String> data = null;
		try {
			 data = new HashMap<String, String>();
			
			// Interface Map -- HashMap Class
			// Pass the File Location
			File path = new File(Constants_Global.excelPath);
			// Read the File
			FileInputStream fin = new FileInputStream(path);
			// Open Workbook
			XSSFWorkbook wb = new XSSFWorkbook(fin);

			// Get the shhet
			XSSFSheet sh = wb.getSheet(sheet);

			int rows = sh.getLastRowNum() - sh.getFirstRowNum();

			int cols = sh.getRow(0).getLastCellNum();

			System.out.println(rows);

			System.out.println(cols);
			
			for(int i=1;i<=rows;i++) {
				
				if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
					
					for(int j=1;j<cols;j++) {
						
						 key = sh.getRow(0).getCell(j).getStringCellValue();
						
						if (sh.getRow(i).getCell(j).getCellType() == CellType.STRING) {
							
							value = sh.getRow(i).getCell(j).getStringCellValue();
							
						}else {
							
							value = sh.getRow(i).getCell(j).getRawValue();
						}
						
						/*
						 * System.out.print(key); System.out.print(" "+value); System.out.println("  ");
						 */
						
						data.put(key, value);
					}
				}
			}

			//System.out.println(data);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;

	}

}

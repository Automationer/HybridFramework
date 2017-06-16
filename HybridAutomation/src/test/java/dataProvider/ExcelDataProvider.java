package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	FileInputStream fis;

	public ExcelDataProvider() {

		File file = new File("./ApplicationTestData/AppData.xlsx");

		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getData(int sheetIndex, int row, int cell) {

		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();

		return data;
	}

	public String getData(String sheetName, int row, int cell) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();

		return data;
	}

}

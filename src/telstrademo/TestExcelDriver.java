package telstrademo;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestExcelDriver {

	Workbook excelWorkbook;
	Sheet oSheet;

	public void openWorkbook(String filename) {
		try {
			FileInputStream myStream = new FileInputStream(filename);
			excelWorkbook = WorkbookFactory.create(myStream);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public int getRowCountOfSheet(String sheetname) {

		oSheet = excelWorkbook.getSheet(sheetname);

		System.out.println("Number of Rows " + oSheet.getPhysicalNumberOfRows());
		return oSheet.getPhysicalNumberOfRows();
	}

	public String getCellData(String sSheetName, int rowNo, int cellNo) {
		oSheet = excelWorkbook.getSheet(sSheetName);

		Row oRow;

		oRow = oSheet.getRow(rowNo - 1);

		Cell oCell;
		oCell = oRow.getCell(cellNo - 1);
		
		if(oCell==null) {
			return "Cell is Null";
		}

		if (oCell.getCellType() == CellType.NUMERIC) {
			System.out.println("Cell Value " + String.valueOf((long) oCell.getNumericCellValue()));
			return String.valueOf((long) oCell.getNumericCellValue());
		} else {
			System.out.println("String Cell Value:" + oCell.getStringCellValue());
			return oCell.getStringCellValue();
		}

	}
}

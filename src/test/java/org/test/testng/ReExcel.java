package org.test.testng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReExcel {

	//读excel
	@SuppressWarnings("resource")
	public static List<Map<String, String>> readXlsx(String fileName) throws IOException {

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileName);
		xssfWorkbook = new XSSFWorkbook(fileName);

		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		XSSFRow rowTitleRow = xssfSheet.getRow(0);

		for (int rowNum = xssfSheet.getFirstRowNum()+1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow == null) {
				continue;
			}

			Map<String, String> map = new HashMap<String, String>();

			for (int cellNum = 0; cellNum < rowTitleRow.getLastCellNum(); cellNum++) {

				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				XSSFCell xssfCellTitleCell = rowTitleRow.getCell(cellNum);
				map.put(getValue(xssfCellTitleCell), getValue(xssfCell));
			}
			list.add(map);

		}

		return null;

	}

	@SuppressWarnings("static-access")
	private static String getValue(XSSFCell xssfCell) {
		if (xssfCell == null){
//			throw new NullPointerException("参数不能为空"); 
			return "";
		}

		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfCell.getNumericCellValue());
		} else {
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}

}

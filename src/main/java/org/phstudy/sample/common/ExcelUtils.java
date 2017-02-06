package org.phstudy.sample.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.phstudy.sample.model.vo.ExcelSheet;

public class ExcelUtils {

	/**
	 * This method is used to read excel sheet from specify File.
	 * 
	 * @param excel
	 * @throws InventoryException
	 */
	public Map<String,Object> readExcelData(File excel) throws Exception {
		Map<String, Object> excelMap = new LinkedHashMap<String, Object>();	
		try {			
			InputStream input = new FileInputStream(excel);
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);			
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				HSSFSheet sheet = wb.getSheetAt(i);
				ExcelSheet sheetData = readSheet(excelMap, sheet);
				if(sheetData==null)
					continue;
				excelMap.put(sheetData.getSheetName(),sheetData.getData());
			}

		} catch (Exception ex) {
			throw new Exception("error in readExcelData", ex);
		}
		return excelMap;
	}
	
	private ExcelSheet readSheet(Map<String, Object> excelMap, HSSFSheet sheet)
			throws IllegalAccessException, InvocationTargetException {
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		Iterator<Row> rowIterator = sheet.rowIterator();
		String sheetName = sheet.getSheetName();
		ExcelSheet excelSheet = new ExcelSheet();
		excelSheet.setSheetName(sheetName);

		List<String> headers = getHeader(rowIterator.next());
		if(headers==null)
			return null;

		if (sheetName.startsWith("VechicleType")) { 
				while (rowIterator.hasNext()) {
					//Load Application server tomcat's information
					Row row = rowIterator.next();
					HashMap<String, String> rowMap = new LinkedHashMap<String, String>();
					List<String> rowData = getRowInList(headers, row);
					if(rowData == null)
						continue;
					int index = 0;
					for (String cellData : rowData) {
						rowMap.put(headers.get(index), cellData);					
						index++;
					}
					mapList.add(rowMap);

				}

		excelSheet.setData(mapList);
		return excelSheet;

		}

		return null;

	}
	
	private List<String> getHeader(Row headerRow) {
		Boolean emptyRow = true;
		List<String> rowData = new ArrayList<String>();
		Iterator<Cell> cellIterator = headerRow.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			cell.setCellType(Cell.CELL_TYPE_STRING);
			rowData.add(cell.getStringCellValue());
			if(emptyRow == true && StringUtils.isNotBlank(cell.getStringCellValue())){
				emptyRow=false;
			}
		}		
		return emptyRow?null:rowData;

	}
	
	/**
	 * This method is used to get Rows from excel sheet.
	 * 
	 * @param headerRow
	 * @return
	 */
	private List<String> getRowInList(List<String> headers, Row row) {
		Boolean emptyRow = true;
		List<String> rowData = new ArrayList<String>();

		for (int cn = 0; cn < headers.size(); cn++) {
			Cell c = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
			if (c == null) {
				rowData.add("");
			} else {
				c.setCellType(Cell.CELL_TYPE_STRING);
				rowData.add(c.getStringCellValue());
				if(emptyRow==true && StringUtils.isNotBlank(c.getStringCellValue())){
					emptyRow = false;
				}
			}
		}		

		return emptyRow?null:rowData;
	}
}

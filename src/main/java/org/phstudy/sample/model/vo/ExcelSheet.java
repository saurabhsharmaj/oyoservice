package org.phstudy.sample.model.vo;

/**
 * 
 * @author Saurabh
 *
 */
public class ExcelSheet {
	
	private String sheetName;
	private Object data;

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

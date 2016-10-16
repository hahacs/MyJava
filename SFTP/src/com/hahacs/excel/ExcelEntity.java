package com.hahacs.excel;

import java.util.List;

/**
 * ����Ҫ��ӡ��Excel���,���ڴ��Ҫ����ΪExcel���������
 * 
 * @author wuhaopeng
 *
 * @param <T>
 *            ����Ҫ��ӡ������ʵ�壬��UserInfo��
 */
public class ExcelEntity<T> {
	private String sheetName = "Sheet1";// Ĭ�����ɵ�sheet����
	private String header = "";// ��ͷ
	private String footer = "";// ��ע
	// �����Ǳ���߱�������
	private String fileName;
	private String[] columnNames;// ����
	private String[] methodNames;// ��������Ӧ�ķ�����
	private List<T> entities;// ����ʵ��

	public ExcelEntity(String fileName, String[] columnNames,
			String[] methodNames, List<T> entities) {
		this("sheet1", "", "", fileName, columnNames, methodNames, entities);
	}

	public ExcelEntity(String sheetName, String header, String footer,
			String fileName, String[] columnNames, String[] methodNames,
			List<T> entities) {

		this.sheetName = sheetName;
		this.header = header;
		this.footer = footer;
		this.fileName = fileName;
		this.columnNames = columnNames;
		this.methodNames = methodNames;
		this.entities = entities;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public List<T> getEntities() {
		return entities;
	}

	/**
	 *
	 * @param entities
	 *            ���ڵ���Excel��ʵ�弯��
	 */
	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getMethodNames() {
		return methodNames;
	}

	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}

}


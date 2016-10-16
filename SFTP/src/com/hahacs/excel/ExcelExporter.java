package com.hahacs.excel;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * һ��ͨ�õĽ�List<T>�����ݵ���ΪExcel�ĵ��Ĺ�����
 * 
 * @author wuhaopeng
 */
public class ExcelExporter {
	
	private static Logger logger = Logger.getLogger(ExcelExporter.class);

	/**
	 * ����ExcelEntity�Ȳ�������Workbook
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static <T> Workbook export2Excel(ExcelEntity<T> entity)
			throws Exception {
		Workbook workbook = export2Excel(entity.getHeader(),
				entity.getFooter(), entity.getSheetName(),
				entity.getColumnNames(), entity.getMethodNames(),
				entity.getEntities());
		return workbook;
	}

	/**
	 * ���ݸ�����������Excel�ĵ�
	 *
	 * @param headerTitle
	 *            ��ͷ
	 * @param footer
	 *            ��ע
	 * @param sheetName
	 * @param columnNames
	 *            ��ͷ����
	 * @param methodNames
	 * @param entities
	 * @return
	 * @throws Exception
	 */
	public static <T> Workbook export2Excel(String headerTitle,
			String footerTitle, String sheetName, String[] columnNames,
			String[] methodNames, List<T> entities) throws Exception {
		if (methodNames.length != columnNames.length)
			throw new IllegalArgumentException(
					"methodNames.length should be equal to columnNames.length:"
							+ columnNames.length + "" + methodNames.length);
		Workbook newWorkBook2007 = new XSSFWorkbook();
		Sheet sheet = newWorkBook2007.createSheet(sheetName);
		sheet.setDisplayGridlines(false);

		// ������ͷ
		Header header = sheet.getHeader();
		header.setCenter(headerTitle);
		// ���ý�ע
		Footer footer = sheet.getFooter();
		footer.setCenter(footerTitle);

		int[] columnWidths = new int[columnNames.length];
		// ������ͷ
		createTableHeader(sheet, 0, headerTitle, columnNames, columnWidths);
		// ��������
		createTableContent(sheet, 1, methodNames, columnWidths, entities);

		return newWorkBook2007;

	}

	/**
	 * ������ͷ
	 *
	 * @param sheet
	 * @param index
	 *            ��ͷ��ʼ������
	 * @param headerTitle
	 *            ��ͷ
	 * @param columnNames
	 * @param columnWidths
	 */
	private static void createTableHeader(Sheet sheet, int index,
			String headerTitle, String[] columnNames, int[] columnWidths) {

		Row headerRow = sheet.createRow(index);

		// ��������
		Font font = sheet.getWorkbook().createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);// ������ʾ
		font.setFontName("΢���ź�");
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.WHITE.index); 
		// ���ñ���ɫ
		CellStyle style = sheet.getWorkbook().createCellStyle();
//		style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
		style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����   

		for (int i = 0; i < columnNames.length; i++) {
			Cell headerCell = headerRow.createCell(i);
			headerCell.setCellStyle(style);
			headerCell.setCellValue(columnNames[i]);
		}

		for (int i = 0; i < columnNames.length; i++) {
			columnWidths[i] = (columnNames[i].getBytes().length + 2) * 256;
			sheet.setColumnWidth(i, columnWidths[i]);
		}

	}

	/**
	 * �����������
	 *
	 * @param sheet
	 * @param rowIndexBegin
	 *            �����ݿ�ʼ������
	 * @param methodNames
	 *            T����ķ�����
	 * @param columnWidths
	 * @param entities
	 * @throws Exception
	 */
	private static <T> void createTableContent(Sheet sheet, int rowIndexBegin,
			String[] methodNames, int[] columnWidths, List<T> entities)
			throws Exception {
		
		// ��������
		Font font = sheet.getWorkbook().createFont();
//		font.setBoldweight(Font.BOLDWEIGHT_BOLD);// ������ʾ
		font.setFontName("΢���ź�");
		font.setFontHeightInPoints((short) 9);
		// ���ñ���ɫ
		CellStyle style = sheet.getWorkbook().createCellStyle();
//		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		
		//���ñ߿�
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //�±߿�    
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//��߿�    
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//�ϱ߿�    
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//�ұ߿�  
		
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����   
		
		Class<? extends Object> clazz = null;
		if (entities.size() > 0)
			clazz = entities.get(0).getClass();

		String content = null;
		for (T t : entities) {
			Row row = sheet.createRow(rowIndexBegin++);
			for (int i = 0; i < methodNames.length; i++) {
				Cell cell = row.createCell(i);
				Method method = clazz.getMethod(methodNames[i], null);
				Object object = method.invoke(t, null);
				object = object == null ? "" : object;
				if (object.getClass().equals(Date.class)) {// �����ڸ�ʽ�������⴦��
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					content = sdf.format((Date) object);
					cell.setCellValue(content);
				} else {
					content = object.toString();
					cell.setCellValue(content);
				}
				cell.setCellStyle(style);
				int columnWidth = (content.getBytes().length + 2) * 256;
				if (columnWidth > columnWidths[i]) {// ���ʵ�����ݿ�ȴ��ڶ�Ӧ�ı�ͷ��ȣ�������Ϊʵ�����ݿ��
					columnWidths[i] = columnWidth;
					sheet.setColumnWidth(i, columnWidths[i]);
				}

			}
		}
	}

	public static <T> void testPOI(String[] columnNames, String[] methodNames,
			List<T> entities) throws Exception {
		String sheetName = "Test";
		String title = "������";
		String dstFile = "d:/temp/test.xlsx";
		Workbook newWorkBook2007 = new XSSFWorkbook();
		Sheet sheet = newWorkBook2007.createSheet(sheetName);
		int[] columnWidths = new int[columnNames.length];
		// ������ͷ
		createTableHeader(sheet, 0, title, columnNames, columnWidths);
		// ��������
		createTableContent(sheet, 1, methodNames, columnWidths, entities);
		// ����Ϊ�ļ�
		saveWorkBook2007(newWorkBook2007, dstFile);
		System.out.println("end");

	}

	/**
	 * ��workbook2007ֱ�ӱ��浽�ն�
	 *
	 * @param workbook2007
	 * @param dstFile
	 */
	public static void saveWorkBook2007(Workbook workbook2007, String dstFile) {
		File file = new File(dstFile);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			workbook2007.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	/**
	 * ͨ����ҳ��������workbook2007
	 *
	 * @param workbook2007
	 * @param response
	 */
//	public static void saveWorkBookWeb2007(Workbook workbook2007,
//			HttpServletResponse response, String fileName) {
//
//		try {
////			String fileName = "ComputersReport.xlsx";
//			fileName = fileName + MyDateUtil.getDateStrByDate(MyDateUtil.getCurrentDateTime(),"yyyyMMdd_HHmmss")+".xlsx";
//			response.setHeader("Content-Disposition", "inline; filename="
//					+ toUtf8String(fileName));
//			response.setContentType("application/vnd.ms-excel");
//
//			ServletOutputStream outputStream = response.getOutputStream();
//			// Write to the output stream
//			workbook2007.write(outputStream);
//			// �������
//			outputStream.flush();
//
//		} catch (Exception e) {
//			 logger.error("����Excelʧ�ܣ�");
//		}
//
//	}
	
	/**
	 * �������Excel����������ʾ����
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s){  
	     StringBuffer sb = new StringBuffer();  
	       for (int i=0;i<s.length();i++){  
	          char c = s.charAt(i);  
	          if (c >= 0 && c <= 255){sb.append(c);}  
	        else{  
	        byte[] b;  
	         try { b = Character.toString(c).getBytes("utf-8");}  
	         catch (Exception ex) {  
	             System.out.println(ex);  
	                  b = new byte[0];  
	         }  
	            for (int j = 0; j < b.length; j++) {  
	             int k = b[j];  
	              if (k < 0) k += 256;  
	              sb.append("%" + Integer.toHexString(k).toUpperCase());  
	              }  
	     }  
	  }  
	  return sb.toString();  
	}
}

package utilityFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlutilityData {
	public FileInputStream file;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	public String path=null;
	
	public XlutilityData(String path)
	{
		this.path=path;
	}
	public int getRowCount(String sheetName) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int numberOfRow=sheet.getLastRowNum();
		workbook.close();
		file.close();
		return numberOfRow;
		
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int numberOfCell=sheet.getRow(0).getLastCellNum();
		workbook.close();
		file.close();
		return numberOfCell;
	}
	public String getCellData(String sheetName,int rownum,int column) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		
		DataFormatter format=new DataFormatter();
		String Data;
		try
		{
		Data=format.formatCellValue(cell);
		}
		catch(Exception e)
		{
			Data="";
		}
		workbook.close();
		file.close();
		return Data;
				
		
	}
	public void setCellData(String sheetName,int rownum,int column,String data) throws IOException
	{

		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.createCell(column);
		cell.setCellValue(data);
		
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		file.close();
		fo.close();
		
		
	}
	

}





















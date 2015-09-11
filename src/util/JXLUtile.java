package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.junit.Test;

/**
 * XLS文件读写工具类
 * @author 杨志
 *
 */
public class JXLUtile {

	/**
	 * 读取xls文件
	 * @param readXLS 文件名（包括路径）
	 * @param sheetIndex 读取第几个工作簿（0~N）
	 * @return ArrayList<Object[]>
	 */
	public static ArrayList<Object[]> ReadExcel(String readXLS, int sheetIndex) {
		// 1、构造excel文件输入流对象
		InputStream is = null;
		Workbook rwb = null;
		ArrayList<Object[]> list = null;
		try {
			is = new FileInputStream(readXLS);
			// 2、声明工作簿对象
			rwb = Workbook.getWorkbook(is);
			// 3、获得工作簿的个数,对应于一个excel中的工作表个数
			int sheetNum = rwb.getNumberOfSheets();
			// 工作簿是否存在
			if (sheetIndex <= sheetNum) {
				Sheet oFirstSheet = rwb.getSheet(sheetIndex);// 使用索引形式获取第一个工作表，也可以使用rwb.getSheet(sheetName);其中sheetName表示的是工作表的名称
				//System.out.println("正在读取工作表：" + oFirstSheet.getName() + " ...");

				int rows = oFirstSheet.getRows();// 获取工作表中的总行数
				int columns = oFirstSheet.getColumns();// 获取工作表中的总列数

				list = new ArrayList<Object[]>();
				Object[] obj =null;
				for (int i = 0; i < rows; i++) {
					obj = new Object[columns];
					for (int j = 0; j < columns; j++) {
						Cell oCell = oFirstSheet.getCell(j, i);// 需要注意的是这里的getCell方法的参数，第一个是指定第几列，第二个参数才是指定第几行
						String temp = oCell.getContents();
						obj[j] = temp != "" ? temp : null;
					}
					list.add(obj);
				}
			}
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rwb.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 写入xls文件
	 * @param createXLS 创建XLS的文件名（包括路径）
	 * @param ArrayList<Object[]> 写入的list数据 
	 */
	public static void WriteExcel(String createXLS,ArrayList<Object[]> list){
		// 1、创建工作簿(WritableWorkbook)对象，打开excel文件，若文件不存在，则创建文件
		WritableWorkbook writeBook=null;
		// 2、新建工作表(sheet)对象，并声明其属于第几页
		WritableSheet sheet =null;
		//新建工作簿ID
		int sheetIndex=1;
		try {
			writeBook = Workbook.createWorkbook(new File(createXLS));
			sheet = writeBook.createSheet("sheet"+sheetIndex, 0);// 第一个参数为工作簿的名称，第二个参数为页数
			// 3、创建单元格(Label)对象，
			int rows = list.size();
			int columns = list.get(0).length;//初值，之后修改
			Label[][] labels=new Label[rows][columns];
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).length; j++) {
					Object obj=list.get(i)[j];
					// 第一个参数指定单元格的列数、第二个参数指定单元格的行数，第三个指定写的字符串内容
					Label label = new Label(j, i,obj!=null?obj.toString():"");
					sheet.addCell(label);				
				}
			}
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 4、打开流，开始写文件
				writeBook.write();
				// 5、关闭流
				writeBook.close();
			} catch (IOException | WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void read() {
		ArrayList<Object[]> list = ReadExcel("E:/test.xls", 0);
		for (Object[] objects : list) {
			for (Object obj : objects) {
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
	}
	
	@Test
	public void write() {
		WriteExcel("E:/write.xls",ReadExcel("E:/test.xls", 0));
	}
}

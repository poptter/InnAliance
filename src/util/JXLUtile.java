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
 * XLS�ļ���д������
 * @author ��־
 *
 */
public class JXLUtile {

	/**
	 * ��ȡxls�ļ�
	 * @param readXLS �ļ���������·����
	 * @param sheetIndex ��ȡ�ڼ�����������0~N��
	 * @return ArrayList<Object[]>
	 */
	public static ArrayList<Object[]> ReadExcel(String readXLS, int sheetIndex) {
		// 1������excel�ļ�����������
		InputStream is = null;
		Workbook rwb = null;
		ArrayList<Object[]> list = null;
		try {
			is = new FileInputStream(readXLS);
			// 2����������������
			rwb = Workbook.getWorkbook(is);
			// 3����ù������ĸ���,��Ӧ��һ��excel�еĹ��������
			int sheetNum = rwb.getNumberOfSheets();
			// �������Ƿ����
			if (sheetIndex <= sheetNum) {
				Sheet oFirstSheet = rwb.getSheet(sheetIndex);// ʹ��������ʽ��ȡ��һ��������Ҳ����ʹ��rwb.getSheet(sheetName);����sheetName��ʾ���ǹ����������
				//System.out.println("���ڶ�ȡ������" + oFirstSheet.getName() + " ...");

				int rows = oFirstSheet.getRows();// ��ȡ�������е�������
				int columns = oFirstSheet.getColumns();// ��ȡ�������е�������

				list = new ArrayList<Object[]>();
				Object[] obj =null;
				for (int i = 0; i < rows; i++) {
					obj = new Object[columns];
					for (int j = 0; j < columns; j++) {
						Cell oCell = oFirstSheet.getCell(j, i);// ��Ҫע����������getCell�����Ĳ�������һ����ָ���ڼ��У��ڶ�����������ָ���ڼ���
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
	 * д��xls�ļ�
	 * @param createXLS ����XLS���ļ���������·����
	 * @param ArrayList<Object[]> д���list���� 
	 */
	public static void WriteExcel(String createXLS,ArrayList<Object[]> list){
		// 1������������(WritableWorkbook)���󣬴�excel�ļ������ļ������ڣ��򴴽��ļ�
		WritableWorkbook writeBook=null;
		// 2���½�������(sheet)���󣬲����������ڵڼ�ҳ
		WritableSheet sheet =null;
		//�½�������ID
		int sheetIndex=1;
		try {
			writeBook = Workbook.createWorkbook(new File(createXLS));
			sheet = writeBook.createSheet("sheet"+sheetIndex, 0);// ��һ������Ϊ�����������ƣ��ڶ�������Ϊҳ��
			// 3��������Ԫ��(Label)����
			int rows = list.size();
			int columns = list.get(0).length;//��ֵ��֮���޸�
			Label[][] labels=new Label[rows][columns];
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).length; j++) {
					Object obj=list.get(i)[j];
					// ��һ������ָ����Ԫ����������ڶ�������ָ����Ԫ���������������ָ��д���ַ�������
					Label label = new Label(j, i,obj!=null?obj.toString():"");
					sheet.addCell(label);				
				}
			}
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 4����������ʼд�ļ�
				writeBook.write();
				// 5���ر���
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

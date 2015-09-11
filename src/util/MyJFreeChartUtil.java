package util;

import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class MyJFreeChartUtil {

	public static void getPieChart(String[] part,int[] value,String title,String fileDir){
		//��ͼ
		DefaultPieDataset dataset = new DefaultPieDataset();
		if(part.length==value.length){
			//��ֵ
			for (int i = 0; i < part.length; i++) {
				dataset.setValue(part[i],value[i]);
			}
			JFreeChart chart =JFreeChartUtil2.createPieChart(dataset, title, true);
			JFreeChartUtil2.drawToOutputStream(fileDir, chart, 640, 480);	
		}else{
			System.err.println("��������������ƥ�䣡");
		}
	}
	
	public static void getPieChart(String[] part,double[] value,String title,String fileDir){
		//��ͼ
		DefaultPieDataset dataset = new DefaultPieDataset();
		if(part.length==value.length){
			//��ֵ
			for (int i = 0; i < part.length; i++) {
				dataset.setValue(part[i],value[i]);
			}
			JFreeChart chart =JFreeChartUtil2.createPieChart(dataset, title, true);
			JFreeChartUtil2.drawToOutputStream(fileDir, chart, 640, 480);	
		}else{
			System.err.println("��������������ƥ�䣡");
		}
	}
	
	public static void getBarChart3D(List<Map<String, Object>> list,String fileDir){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(list!=null&&list.size()>0){
			//��������
			for(Map<String, Object> map:list){
				dataset.addValue(Integer.valueOf(map.get("value").toString()), (String) map.get("month"), "");
			}
			//���Ʊ���
			JFreeChartUtil1.getBarChart3D(dataset, fileDir,"ÿ��Ԥ��ͳ��","�·�","Ԥ���˴�");
		}else{
			System.out.println("���ݴ���");
		}
	}
	
	public static void getLineChart(List<Map<String, Object>> list,String fileDir,String innName){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(list!=null&&list.size()>0){
			//��������
			for(Map<String, Object> map:list){
				dataset.addValue(Integer.valueOf(map.get("value").toString()),innName,(String) map.get("month"));
			}
			//���Ʊ���
			JFreeChartUtil1.getLineChart(dataset, fileDir);
		}else{
			System.out.println("���ݴ���");
		}
	}
	
	public static void main(String[] args) {
		String title="��ջ���״̬�ֲ�ͼ";
		String fileDir="E:/innPie.png";
		String[] part={"���ύ","�����","������","��ͣ"};
		int[] value={20,30,30,1};
		getPieChart(part, value, title, fileDir);
	}
}

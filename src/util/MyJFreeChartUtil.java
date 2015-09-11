package util;

import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class MyJFreeChartUtil {

	public static void getPieChart(String[] part,int[] value,String title,String fileDir){
		//饼图
		DefaultPieDataset dataset = new DefaultPieDataset();
		if(part.length==value.length){
			//赋值
			for (int i = 0; i < part.length; i++) {
				dataset.setValue(part[i],value[i]);
			}
			JFreeChart chart =JFreeChartUtil2.createPieChart(dataset, title, true);
			JFreeChartUtil2.drawToOutputStream(fileDir, chart, 640, 480);	
		}else{
			System.err.println("输入数据数量不匹配！");
		}
	}
	
	public static void getPieChart(String[] part,double[] value,String title,String fileDir){
		//饼图
		DefaultPieDataset dataset = new DefaultPieDataset();
		if(part.length==value.length){
			//赋值
			for (int i = 0; i < part.length; i++) {
				dataset.setValue(part[i],value[i]);
			}
			JFreeChart chart =JFreeChartUtil2.createPieChart(dataset, title, true);
			JFreeChartUtil2.drawToOutputStream(fileDir, chart, 640, 480);	
		}else{
			System.err.println("输入数据数量不匹配！");
		}
	}
	
	public static void getBarChart3D(List<Map<String, Object>> list,String fileDir){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(list!=null&&list.size()>0){
			//插入数据
			for(Map<String, Object> map:list){
				dataset.addValue(Integer.valueOf(map.get("value").toString()), (String) map.get("month"), "");
			}
			//绘制报表
			JFreeChartUtil1.getBarChart3D(dataset, fileDir,"每月预定统计","月份","预定人次");
		}else{
			System.out.println("数据错误！");
		}
	}
	
	public static void getLineChart(List<Map<String, Object>> list,String fileDir,String innName){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(list!=null&&list.size()>0){
			//插入数据
			for(Map<String, Object> map:list){
				dataset.addValue(Integer.valueOf(map.get("value").toString()),innName,(String) map.get("month"));
			}
			//绘制报表
			JFreeChartUtil1.getLineChart(dataset, fileDir);
		}else{
			System.out.println("数据错误！");
		}
	}
	
	public static void main(String[] args) {
		String title="客栈店家状态分布图";
		String fileDir="E:/innPie.png";
		String[] part={"已提交","已审核","黑名单","报停"};
		int[] value={20,30,30,1};
		getPieChart(part, value, title, fileDir);
	}
}

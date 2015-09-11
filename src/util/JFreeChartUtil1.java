package util;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Ignore;
import org.junit.Test;

public class JFreeChartUtil1 {

	/**
	 * 生成3D折线图
	 * @param dataset DefaultCategoryDataset数据源
	 * @param fileDir 生成文件路径
	 */
	public static void getLineChart(DefaultCategoryDataset dataset,String fileDir) {
		// 生成3D折线图（柱状图只改方法名createLineChart3D就可以了）
		JFreeChart chart = ChartFactory.createLineChart3D("客房预定统计图", // 图表标题
				"月份", // 目录轴的显示标签
				"客房预定人次", // 数值轴的显示标签
				dataset, // 数据
				// PlotOrientation.HORIZONTAL, //图表方向水平
				PlotOrientation.VERTICAL, // 图表方向垂直
				true, // 是否显示图例
				false, // 是否显示工具提示
				false // 是否生成URL
				);
		// 设置标题及标题字体
		chart.setTitle(new TextTitle("客房预定统计图", new Font("黑体", Font.ITALIC, 22)));
		// 建一个图例
		LegendTitle legendTitle = chart.getLegend(0);
		// 设置图例字体
		legendTitle.setItemFont(new Font("宋体", Font.BOLD, 14));
		// 获取折线图plot对象
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 设置折线的颜色
		plot.getRenderer().setSeriesPaint(0, Color.RED);
		plot.getRenderer().setSeriesPaint(1, Color.GREEN);
		plot.getRenderer().setSeriesPaint(2, Color.ORANGE);
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		// 设置分类标签以45度倾斜
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// 设置分类标签字体
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 22));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		// 设置背景透明度（0~1）
		plot.setBackgroundAlpha(0.9f);
		// 设置前景色透明度（0~1）
		plot.setForegroundAlpha(0.5f);
		try {
			// 输出文件
			FileOutputStream fos = new FileOutputStream(fileDir);
			// 用ChartUtilities工具输出
			ChartUtilities.writeChartAsJPEG(fos, chart, 640, 480);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成饼图
	 * @param dataset DefaultPieDataset数据源
	 * @param fileDir 生成文件路径
	 */
	public static void getPieChart(DefaultPieDataset dataset,String fileDir) {
		JFreeChart chart = ChartFactory.createPieChart3D("水果产量图", // 图表标题
				dataset, // 数据集
				true, // 是否显示图例(对于简单的柱状图必须是 false)
				false, // 是否生成工具
				false // 是否生成 URL 链接
				);
		// 中文乱码
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelFont(new Font("黑体", Font.PLAIN, 20));
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

		// 写图表对象到文件，参照柱状图生成源码
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream(fileDir);
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300,
					null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos_jpg.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 生成柱状图
	 * @param dataset DefaultCategoryDataset数据源
	 * @param fileDir 生成文件路径
	 */
	public static void getBarChart(DefaultCategoryDataset dataset,String fileDir) {
		JFreeChart chart = ChartFactory.createBarChart3D("客房使用情况", // 图表标题
				"客房类型", // 目录轴的显示标签
				"数量", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是 false)
				false, // 是否生成工具
				false // 是否生成 URL 链接
				);
		// 中文乱码
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
		numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
		numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream(fileDir);
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 640, 480,
					null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * 生成3D柱状图
	 * @param dataset DefaultCategoryDataset数据源
	 * @param fileDir 生成文件路径
	 */
	public static void getBarChart3D(DefaultCategoryDataset dataset,String fileDir,String title,String strX,String strY){
		JFreeChart chart = ChartFactory.createBarChart3D(
				title, // 图表标题
				strX, // 目录轴的显示标签
				strY, // 数值轴的显示标签
				dataset, // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		// 重新设置图标标题，改变字体
		chart.setTitle(new TextTitle(title, new Font("黑体", Font.ITALIC, 18)));
		// 取得统计图标的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 设置柱状图到图片上端的距离
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setUpperMargin(0.1);
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴显示标签的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		// 分类标签以45度角倾斜
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 14));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		// 在柱体的上面显示数据
		BarRenderer custombarrenderer3d = new BarRenderer();
		custombarrenderer3d.setBaseItemLabelPaint(Color.BLACK);// 数据字体的颜色
		custombarrenderer3d
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		custombarrenderer3d.setBaseItemLabelsVisible(true);
		plot.setRenderer(custombarrenderer3d);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileDir);
			// 将统计图标输出成JPG文件
			ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
					1, // JPEG图片的质量，0~1之间
					chart, // 统计图标对象
					640, // 宽
					480,// 宽
					null // ChartRenderingInfo 信息
					);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test1(){
		String fileDir = "E:/lineChart.jpg";
		// 提供生成折线图的数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 生成复杂带图例的柱状图
		for (int i = 1; i <= 12; i++) {
			dataset.addValue((int) (Math.random() * 1000), "龙门客栈", i + "月");
		}
		getLineChart(dataset, fileDir);
	}
	
	@Ignore
	@Test
	public void test2(){
		String fileDir="E:/pieChar.jpg";
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		getPieChart(dataset, fileDir);
	}
	
	@Ignore
	@Test
	public void test3(){
		String fileDir="E:/barChart1.jpg";
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		dataset1.addValue(100, "", "苹果");
		dataset1.addValue(200, "", "梨子");
		dataset1.addValue(300, "", "葡萄");
		dataset1.addValue(400, "", "香蕉");
		dataset1.addValue(500, "", "荔枝");
		getBarChart(dataset1, fileDir);
		fileDir="E:/barChart2.jpg";
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		dataset2.addValue(100, "北京", "苹果");
		dataset2.addValue(100, "上海", "苹果");
		dataset2.addValue(100, "广州", "苹果");
		dataset2.addValue(200, "北京", "梨子");
		dataset2.addValue(200, "上海", "梨子");
		dataset2.addValue(200, "广州", "梨子");
		dataset2.addValue(300, "北京", "葡萄");
		dataset2.addValue(300, "上海", "葡萄");
		dataset2.addValue(300, "广州", "葡萄");
		dataset2.addValue(400, "北京", "香蕉");
		dataset2.addValue(400, "上海", "香蕉");
		dataset2.addValue(400, "广州", "香蕉");
		dataset2.addValue(500, "北京", "荔枝");
		dataset2.addValue(500, "上海", "荔枝");
		dataset2.addValue(500, "广州", "荔枝");
		getBarChart(dataset2, fileDir);
	}
	
	@Ignore
	@Test
	public void test4(){
		String fileDir="E:/berChart3D.jpg";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int i = 0; i <2; i++) {
			dataset.addValue((int)(Math.random()*1000), "2014年"+(i+1)+"月", "");
		}
		getBarChart3D(dataset, fileDir,"标题","X轴","Y轴");
	}
	
	@Ignore
	@Test
	public void test(){
		String fileDir="E:/barChart2.jpg";
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		dataset2.addValue(100, "北京", "苹果");
		dataset2.addValue(100, "上海", "苹果");
		dataset2.addValue(100, "广州", "苹果");
		dataset2.addValue(200, "北京", "梨子");
		dataset2.addValue(200, "上海", "梨子");
		dataset2.addValue(200, "广州", "梨子");
		dataset2.addValue(300, "北京", "葡萄");
		dataset2.addValue(300, "上海", "葡萄");
		dataset2.addValue(300, "广州", "葡萄");
		dataset2.addValue(400, "北京", "香蕉");
		dataset2.addValue(400, "上海", "香蕉");
		dataset2.addValue(400, "广州", "香蕉");
		dataset2.addValue(500, "北京", "荔枝");
		dataset2.addValue(500, "上海", "荔枝");
		dataset2.addValue(500, "广州", "荔枝");
		getBarChart(dataset2, fileDir);
	}
}

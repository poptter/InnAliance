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
	 * ����3D����ͼ
	 * @param dataset DefaultCategoryDataset����Դ
	 * @param fileDir �����ļ�·��
	 */
	public static void getLineChart(DefaultCategoryDataset dataset,String fileDir) {
		// ����3D����ͼ����״ͼֻ�ķ�����createLineChart3D�Ϳ����ˣ�
		JFreeChart chart = ChartFactory.createLineChart3D("�ͷ�Ԥ��ͳ��ͼ", // ͼ�����
				"�·�", // Ŀ¼�����ʾ��ǩ
				"�ͷ�Ԥ���˴�", // ��ֵ�����ʾ��ǩ
				dataset, // ����
				// PlotOrientation.HORIZONTAL, //ͼ����ˮƽ
				PlotOrientation.VERTICAL, // ͼ����ֱ
				true, // �Ƿ���ʾͼ��
				false, // �Ƿ���ʾ������ʾ
				false // �Ƿ�����URL
				);
		// ���ñ��⼰��������
		chart.setTitle(new TextTitle("�ͷ�Ԥ��ͳ��ͼ", new Font("����", Font.ITALIC, 22)));
		// ��һ��ͼ��
		LegendTitle legendTitle = chart.getLegend(0);
		// ����ͼ������
		legendTitle.setItemFont(new Font("����", Font.BOLD, 14));
		// ��ȡ����ͼplot����
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// �������ߵ���ɫ
		plot.getRenderer().setSeriesPaint(0, Color.RED);
		plot.getRenderer().setSeriesPaint(1, Color.GREEN);
		plot.getRenderer().setSeriesPaint(2, Color.ORANGE);
		// ȡ�ú���
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// ���ú��������
		categoryAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// ���÷����ǩ��45����б
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// ���÷����ǩ����
		categoryAxis.setTickLabelFont(new Font("����", Font.BOLD, 22));
		// ȡ������
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// �������������
		numberAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// ���ñ���͸���ȣ�0~1��
		plot.setBackgroundAlpha(0.9f);
		// ����ǰ��ɫ͸���ȣ�0~1��
		plot.setForegroundAlpha(0.5f);
		try {
			// ����ļ�
			FileOutputStream fos = new FileOutputStream(fileDir);
			// ��ChartUtilities�������
			ChartUtilities.writeChartAsJPEG(fos, chart, 640, 480);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ɱ�ͼ
	 * @param dataset DefaultPieDataset����Դ
	 * @param fileDir �����ļ�·��
	 */
	public static void getPieChart(DefaultPieDataset dataset,String fileDir) {
		JFreeChart chart = ChartFactory.createPieChart3D("ˮ������ͼ", // ͼ�����
				dataset, // ���ݼ�
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
				false, // �Ƿ����ɹ���
				false // �Ƿ����� URL ����
				);
		// ��������
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelFont(new Font("����", Font.PLAIN, 20));
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));

		// дͼ������ļ���������״ͼ����Դ��
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
	 * ������״ͼ
	 * @param dataset DefaultCategoryDataset����Դ
	 * @param fileDir �����ļ�·��
	 */
	public static void getBarChart(DefaultCategoryDataset dataset,String fileDir) {
		JFreeChart chart = ChartFactory.createBarChart3D("�ͷ�ʹ�����", // ͼ�����
				"�ͷ�����", // Ŀ¼�����ʾ��ǩ
				"����", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
				false, // �Ƿ����ɹ���
				false // �Ƿ����� URL ����
				);
		// ��������
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.PLAIN, 20));
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));
		numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
		numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));

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
	 * ����3D��״ͼ
	 * @param dataset DefaultCategoryDataset����Դ
	 * @param fileDir �����ļ�·��
	 */
	public static void getBarChart3D(DefaultCategoryDataset dataset,String fileDir,String title,String strX,String strY){
		JFreeChart chart = ChartFactory.createBarChart3D(
				title, // ͼ�����
				strX, // Ŀ¼�����ʾ��ǩ
				strY, // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				// PlotOrientation.HORIZONTAL , // ͼ����ˮƽ
				PlotOrientation.VERTICAL, // ͼ���򣺴�ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		// ��������ͼ����⣬�ı�����
		chart.setTitle(new TextTitle(title, new Font("����", Font.ITALIC, 18)));
		// ȡ��ͳ��ͼ��ĵ�һ��ͼ��
		LegendTitle legend = chart.getLegend(0);
		// �޸�ͼ��������
		legend.setItemFont(new Font("����", Font.BOLD, 14));
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// ������״ͼ��ͼƬ�϶˵ľ���
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setUpperMargin(0.1);
		// ȡ�ú���
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// ���ú�����ʾ��ǩ������
		categoryAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// �����ǩ��45�Ƚ���б
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
		categoryAxis.setTickLabelFont(new Font("����", Font.BOLD, 14));
		// ȡ������
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// ����������ʾ��ǩ������
		numberAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// �������������ʾ����
		BarRenderer custombarrenderer3d = new BarRenderer();
		custombarrenderer3d.setBaseItemLabelPaint(Color.BLACK);// �����������ɫ
		custombarrenderer3d
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		custombarrenderer3d.setBaseItemLabelsVisible(true);
		plot.setRenderer(custombarrenderer3d);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileDir);
			// ��ͳ��ͼ�������JPG�ļ�
			ChartUtilities.writeChartAsJPEG(fos, // ������ĸ������
					1, // JPEGͼƬ��������0~1֮��
					chart, // ͳ��ͼ�����
					640, // ��
					480,// ��
					null // ChartRenderingInfo ��Ϣ
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
		// �ṩ��������ͼ������
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// ���ɸ��Ӵ�ͼ������״ͼ
		for (int i = 1; i <= 12; i++) {
			dataset.addValue((int) (Math.random() * 1000), "���ſ�ջ", i + "��");
		}
		getLineChart(dataset, fileDir);
	}
	
	@Ignore
	@Test
	public void test2(){
		String fileDir="E:/pieChar.jpg";
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("ƻ��", 100);
		dataset.setValue("����", 200);
		dataset.setValue("����", 300);
		dataset.setValue("�㽶", 400);
		dataset.setValue("��֦", 500);
		dataset.setValue("ƻ��", 100);
		dataset.setValue("����", 200);
		dataset.setValue("����", 300);
		dataset.setValue("�㽶", 400);
		dataset.setValue("��֦", 500);
		getPieChart(dataset, fileDir);
	}
	
	@Ignore
	@Test
	public void test3(){
		String fileDir="E:/barChart1.jpg";
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		dataset1.addValue(100, "", "ƻ��");
		dataset1.addValue(200, "", "����");
		dataset1.addValue(300, "", "����");
		dataset1.addValue(400, "", "�㽶");
		dataset1.addValue(500, "", "��֦");
		getBarChart(dataset1, fileDir);
		fileDir="E:/barChart2.jpg";
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		dataset2.addValue(100, "����", "ƻ��");
		dataset2.addValue(100, "�Ϻ�", "ƻ��");
		dataset2.addValue(100, "����", "ƻ��");
		dataset2.addValue(200, "����", "����");
		dataset2.addValue(200, "�Ϻ�", "����");
		dataset2.addValue(200, "����", "����");
		dataset2.addValue(300, "����", "����");
		dataset2.addValue(300, "�Ϻ�", "����");
		dataset2.addValue(300, "����", "����");
		dataset2.addValue(400, "����", "�㽶");
		dataset2.addValue(400, "�Ϻ�", "�㽶");
		dataset2.addValue(400, "����", "�㽶");
		dataset2.addValue(500, "����", "��֦");
		dataset2.addValue(500, "�Ϻ�", "��֦");
		dataset2.addValue(500, "����", "��֦");
		getBarChart(dataset2, fileDir);
	}
	
	@Ignore
	@Test
	public void test4(){
		String fileDir="E:/berChart3D.jpg";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int i = 0; i <2; i++) {
			dataset.addValue((int)(Math.random()*1000), "2014��"+(i+1)+"��", "");
		}
		getBarChart3D(dataset, fileDir,"����","X��","Y��");
	}
	
	@Ignore
	@Test
	public void test(){
		String fileDir="E:/barChart2.jpg";
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		dataset2.addValue(100, "����", "ƻ��");
		dataset2.addValue(100, "�Ϻ�", "ƻ��");
		dataset2.addValue(100, "����", "ƻ��");
		dataset2.addValue(200, "����", "����");
		dataset2.addValue(200, "�Ϻ�", "����");
		dataset2.addValue(200, "����", "����");
		dataset2.addValue(300, "����", "����");
		dataset2.addValue(300, "�Ϻ�", "����");
		dataset2.addValue(300, "����", "����");
		dataset2.addValue(400, "����", "�㽶");
		dataset2.addValue(400, "�Ϻ�", "�㽶");
		dataset2.addValue(400, "����", "�㽶");
		dataset2.addValue(500, "����", "��֦");
		dataset2.addValue(500, "�Ϻ�", "��֦");
		dataset2.addValue(500, "����", "��֦");
		getBarChart(dataset2, fileDir);
	}
}

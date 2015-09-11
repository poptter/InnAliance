package util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import org.junit.Ignore;
import org.junit.Test;

public class JFreeChartUtil2 {

	/**
	 * ������ͼ
	 * @param dataset DefaultPieDataset ����Դ
	 * @param title ����
	 * @param is3D	3Dģʽ[ture/false]
	 * @return
	 */
	public static JFreeChart createPieChart(DefaultPieDataset dataset,String title, boolean is3D) {
		JFreeChart chart = null;
		if (is3D) {
			chart = ChartFactory.createPieChart3D(title, // ͼ�����
					dataset, // ���ݼ�
					true, // �Ƿ���ʾͼ��
					true, // �Ƿ���ʾ������ʾ
					true // �Ƿ�����URL
					);
		} else {
			chart = ChartFactory.createPieChart(title, // ͼ�����
					dataset, // ���ݼ�
					true, // �Ƿ���ʾͼ��
					true, // �Ƿ���ʾ������ʾ
					true // �Ƿ�����URL
					);
		}
		// ���ñ�������==Ϊ�˷�ֹ�������룺������������
		chart.setTitle(new TextTitle(title, new Font("����", Font.ITALIC, 22)));
		// ����ͼ��������==Ϊ�˷�ֹ�������룺������������
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 18));
		// ��ȡ��ͼ��Plot����(ʵ��ͼ��)
		PiePlot plot = (PiePlot) chart.getPlot();
		// ͼ�α߿���ɫ
		plot.setBaseSectionOutlinePaint(Color.GRAY);
		// ͼ�α߿��ϸ
		plot.setBaseSectionOutlineStroke(new BasicStroke(0.0f));
		// ���ñ�״ͼ�Ļ��Ʒ��򣬿��԰�˳ʱ�뷽����ƣ�Ҳ���԰���ʱ�뷽�����
		plot.setDirection(Rotation.ANTICLOCKWISE);
		// ���û��ƽǶ�(ͼ����ת�Ƕ�)
		plot.setStartAngle(70);
		// ����ͻ����ʾ�����ݿ�
		// plot.setExplodePercent("One", 0.1D);
		// ���ñ���ɫ͸����
		plot.setBackgroundAlpha(0.7F);
		// ����ǰ��ɫ͸����
		plot.setForegroundAlpha(0.65F);
		// ���������ǩ������==Ϊ�˷�ֹ�������룺������������
		plot.setLabelFont(new Font("����", Font.PLAIN, 18));
		// ����������ʾ,��3Dͼ����Ч
		if (is3D)
			plot.setExplodePercent(dataset.getKey(3), 0.1D);
		// ͼ����ʾ�ٷֱ�:�Զ��巽ʽ��{0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ���� ,С�������λ
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}\r\n({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));
		// ͼ����ʾ�ٷֱ�
		// plot.setLegendLabelGenerator(new
		// StandardPieSectionLabelGenerator("{0}={1}({2})"));
		// ָ����ʾ�ı�ͼΪ��Բ��(true) ������Բ��(false)
		plot.setCircular(true);
		// û�����ݵ�ʱ����ʾ������
		plot.setNoDataMessage("�Ҳ�����������...");

		// ���������ͣ��ʾ
		plot.setToolTipGenerator(new StandardPieToolTipGenerator());
		// �����ȵ�����
		// plot.setURLGenerator(new StandardPieURLGenerator("detail.jsp"));
		return chart;
	}

	/**
	 * ��������ͼ
	 * @param dataset CategoryDataset����Դ
	 * @param title ����
	 * @param x	X��
	 * @param y Y��
	 * @param is3D 3Dģʽ[ture/false]
	 * @return
	 */
	public static JFreeChart createBarChart(CategoryDataset dataset,String title, String x, String y, boolean is3D) {
		JFreeChart chart = null;
		if (is3D) {
			chart = ChartFactory.createBarChart3D( // 3D��״ͼ
					// JFreeChart chart = ChartFactory.createLineChart3D(
					// //3D����ͼ
					title, // ͼ��ı���
					x, // Ŀ¼�����ʾ��ǩ
					y, // ��ֵ�����ʾ��ǩ
					dataset, // ���ݼ�
					PlotOrientation.VERTICAL, // ͼ��ʽ��V��ֱ;Hˮƽ
					true, // �Ƿ���ʾͼ��
					false, // �Ƿ���ʾ������ʾ
					false // �Ƿ�����URL
					);
		} else {
			chart = ChartFactory.createBarChart( // ��״ͼ
					// JFreeChart chart = ChartFactory.createLineChart3D(
					// //3D����ͼ
					title, // ͼ��ı���
					x, // Ŀ¼�����ʾ��ǩ
					y, // ��ֵ�����ʾ��ǩ
					dataset, // ���ݼ�
					PlotOrientation.VERTICAL, // ͼ��ʽ��V��ֱ;Hˮƽ
					true, // �Ƿ���ʾͼ��
					false, // �Ƿ���ʾ������ʾ
					false // �Ƿ�����URL
					);
		}

		// ===============Ϊ�˷�ֹ�������룺������������
		chart.setTitle(new TextTitle(title, new Font("����", Font.ITALIC, 22)));

		LegendTitle legend = chart.getLegend(); // ��ȡͼ��
		legend.setItemFont(new Font("����", Font.BOLD, 12)); // ����ͼ�������壬��ֹ��������

		CategoryPlot plot = (CategoryPlot) chart.getPlot(); // ��ȡ��ͼ��Plot����(ʵ��ͼ��)
		// ������ͼ����ɫ��ע�⣬ϵͳȡɫ��ʱ��Ҫʹ��16λ��ģʽ���鿴��ɫ���룬�����Ƚ�׼ȷ��
		plot.setBackgroundPaint(new Color(255, 255, 204));
		plot.setForegroundAlpha(0.65F); // ����ǰ��ɫ͸����

		// ���ú����߿ɼ�
		plot.setRangeGridlinesVisible(true);
		// ����ɫ��
		plot.setRangeGridlinePaint(Color.gray);

		CategoryAxis h = plot.getDomainAxis(); // ��ȡx��
		h.setMaximumCategoryLabelWidthRatio(1.0f);// �����ϵ� Lable �Ƿ�������ʾ
		h.setLabelFont(new Font("����", Font.BOLD, 12));// �������壬��ֹ��������
		h.setTickLabelFont(new Font("����", Font.BOLD, 12));// ����ֵ
		// h.setCategoryLabelPositions(CategoryLabelPositions.UP_45);//45����б

		plot.getRangeAxis().setLabelFont(new Font("����", Font.BOLD, 12)); // Y���������壬��ֹ��������

		// ��ͼ�ĳ�����
		BarRenderer renderer = new BarRenderer();
		// �������ӿ��
		// renderer.setMaximumBarWidth(0.05);
		// �������Ӹ߶�
		// renderer.setMinimumBarLength(0.2);
		// �������ӱ߿���ɫ
		renderer.setBaseOutlinePaint(Color.BLACK);
		// �������ӱ߿�ɼ�
		renderer.setDrawBarOutline(true);
		// ����ÿ��������ɫ
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.RED);
		// ����ÿ��������������ƽ������֮�����
		renderer.setItemMargin(0.05);
		// ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
		renderer.setIncludeBaseInRange(true);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		// ��������͸����
		plot.setForegroundAlpha(1.0f);
		// ����ͼ��ӳ�����
		plot.setRenderer(renderer);

		// û�����ݵ�ʱ����ʾ������
		plot.setNoDataMessage("�Ҳ�����������...");
		return chart;
	}

	/**
	 * 
	 * @param data
	 * @param title
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 * @param request
	 * @return
	 */
	public static String generateBarChart(List<Object[]> data, String title,
			String x, String y, int width, int heigth, boolean is3D,
			HttpServletRequest request) {
		boolean returnValue = false;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Iterator<Object[]> iterator = data.iterator(); iterator.hasNext();) {
			Object[] o = (Object[]) iterator.next();
			dataset.setValue(((Long) o[1]).intValue(), o[0] + ":" + o[1],
					o[2].toString());
		}
		JFreeChart chart = createBarChart(dataset, title, x, y, is3D);

		SimpleDateFormat df = new SimpleDateFormat("/yyyy/MM/dd/");
		String subPath = df.format(new Timestamp(System.currentTimeMillis()))
				+ ".jpg";
		String returnPath = "/images/itv/chart/" + subPath;

		File f = new File(request.getSession().getServletContext()
				.getRealPath("/")
				+ returnPath);
		f.getParentFile().mkdirs();
		returnValue = drawToOutputStream(f.getAbsolutePath(), chart, width,
				heigth);
		return returnPath;
	}

	public static String generatePieChart(List<Object[]> data, String title,int width, int heigth, HttpServletRequest request, boolean is3D) {
		boolean returnValue = false;
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Iterator<Object[]> iterator = data.iterator(); iterator.hasNext();) {
			Object[] o = (Object[]) iterator.next();
			dataset.setValue(o[0].toString(), ((Long) o[1]).doubleValue());
		}
		JFreeChart chart = createPieChart(dataset, title, is3D);
		SimpleDateFormat df = new SimpleDateFormat("/yyyy/MM/dd/");
		String subPath = df.format(new Timestamp(System.currentTimeMillis()))+ ".jpg";
		String returnPath = "/images/itv/chart/" + subPath;

		File f = new File(request.getSession().getServletContext().getRealPath("/")+ returnPath);
		f.getParentFile().mkdirs();
		returnValue = drawToOutputStream(f.getAbsolutePath(), chart, width,heigth);
		return returnPath;
	}

	/**
	 * ���ͼ��ָ���Ĵ���
	 * @param destPath ����ļ�·��
	 * @param chart JFreeChart����Դ
	 * @param width ����ļ����
	 * @param heigth ����ļ��߶�
	 * @return boolean �Ƿ�����ɹ�[true/false]
	 */
	public static boolean drawToOutputStream(String destPath,JFreeChart chart, int width, int heigth) {
		FileOutputStream fos = null;
		boolean returnValue = true;
		try {
			fos = new FileOutputStream(destPath);
			ChartUtilities.writeChartAsPNG(fos, // ָ��Ŀ�������
					chart, // ͼ�����
					width, // ��
					heigth, // ��
					null); // ChartRenderingInfo��Ϣ
		} catch (IOException e) {
			e.printStackTrace();
			returnValue = false;
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}

	@Ignore
	@Test
	public void test1(){
		//��״ͼ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(10000, "", "Corejava");
		dataset.setValue(20000, "", "JavaWeb");
		dataset.setValue(30000, "", "����struts");
		dataset.setValue(40000, "", "��ͨJSF");
		
		JFreeChart chart = createBarChart(dataset, "ͳ��ͼ","x��", "y��", false);
		drawToOutputStream("E:/bar1.png", chart, 640, 480);
	}
	
	@Ignore
	@Test
	public void test2(){
		//��״ͼ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(10000, "", "Corejava");
		dataset.setValue(20000, "", "JavaWeb");
		dataset.setValue(30000, "", "����struts");
		dataset.setValue(40000, "", "��ͨJSF");
		
		JFreeChart chart = createBarChart(dataset, "ͳ��ͼ","x��", "y��", true);
		drawToOutputStream("E:/bar2.png", chart, 640, 480);
	}
	
	@Ignore
	@Test
	public void test3(){
		//��״ͼ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(5000, "����", "Corejava");
		dataset.setValue(3000, "�Ϻ�", "Corejava");
		dataset.setValue(2000, "����", "Corejava");

		dataset.setValue(10000, "����", "JavaWeb");
		dataset.setValue(6000, "�Ϻ�", "JavaWeb");
		dataset.setValue(4000, "����", "JavaWeb");

		dataset.setValue(15000, "����", "����struts");
		dataset.setValue(5000, "�Ϻ�", "����struts");
		dataset.setValue(10000, "����", "����struts");

		dataset.setValue(20000, "����", "��ͨJSF");
		dataset.setValue(10000, "�Ϻ�", "��ͨJSF");
		dataset.setValue(10000, "����", "��ͨJSF");
		
		JFreeChart chart = createBarChart(dataset, "ͳ��ͼ","x��", "y��", false);
		drawToOutputStream("E:/bar3.png", chart, 640, 480);
	}
	
	@Ignore
	@Test
	public void test4(){
		//��״ͼ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(5000, "����", "Corejava");
		dataset.setValue(3000, "�Ϻ�", "Corejava");
		dataset.setValue(2000, "����", "Corejava");

		dataset.setValue(10000, "����", "JavaWeb");
		dataset.setValue(6000, "�Ϻ�", "JavaWeb");
		dataset.setValue(4000, "����", "JavaWeb");

		dataset.setValue(15000, "����", "����struts");
		dataset.setValue(5000, "�Ϻ�", "����struts");
		dataset.setValue(10000, "����", "����struts");

		dataset.setValue(20000, "����", "��ͨJSF");
		dataset.setValue(10000, "�Ϻ�", "��ͨJSF");
		dataset.setValue(10000, "����", "��ͨJSF");
		
		JFreeChart chart = createBarChart(dataset, "ͳ��ͼ","x��", "y��", true);
		drawToOutputStream("E:/bar4.png", chart, 640, 480);
	}
	
	@Ignore
	@Test
	public void test5(){
		//��ͼ
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("java�����������", 10000);
		dataset.setValue("JSP�����밸���������", 20000);
		dataset.setValue("struts�����밸���������", 30000);
		dataset.setValue("��ͨJSF", 40000);
		
		JFreeChart chart =createPieChart(dataset, "ͳ��ͼ", false);
		drawToOutputStream("E:/pie1.png", chart, 640, 480);
	}
	
	@Ignore
	@Test
	public void test6(){
		//��ͼ
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("java�����������", 10000);
		dataset.setValue("JSP�����밸���������", 20000);
		dataset.setValue("struts�����밸���������", 30000);
		dataset.setValue("��ͨJSF", 40000);
		
		JFreeChart chart =createPieChart(dataset, "ͳ��ͼ", true);
		drawToOutputStream("E:/pie2.png", chart, 640, 480);		
	}
	
	@Ignore
	@Test
	public void test7(){
		//��ͼ
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue(" �г�ǰ��", new Double(10));
		dataset.setValue(" ����", new Double(15));
		dataset.setValue(" �ƻ�", new Double(10));
		dataset.setValue(" ���������", new Double(10));
		dataset.setValue(" ִ�п���", new Double(35));
		dataset.setValue(" ��β", new Double(10));
		dataset.setValue(" ��ά", new Double(10));
		
		JFreeChart chart =createPieChart(dataset, "ͳ��ͼ", false);
		drawToOutputStream("E:/pie3.png", chart, 640, 480);		
	}
	
	@Test
	public void test8(){
		//��ͼ
		int count=0;
		DefaultPieDataset dataset = new DefaultPieDataset();
		String[] str={" �г�ǰ��"," �г�ǰ��"," ����"," �ƻ�"," ���������"," ִ�п���"," ��β"," ��ά"};
		int[] src={10,10,15,10,10,35,10,10};
		//��ֵ
		for (int i = 0; i < str.length; i++) {
			dataset.setValue(str[i],src[i]);
		}
		JFreeChart chart =createPieChart(dataset, "ͳ��ͼ", true);
		drawToOutputStream("E:/pie4.png", chart, 640, 480);	
	}
}
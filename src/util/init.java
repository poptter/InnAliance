package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.adakoda.android.asm.AndroidScreenMonitor;

public class init implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sec) {
		System.err.println("����䣬����ͨ��ͨ���֮ ��");
	}

	@Override
	public void contextInitialized(ServletContextEvent sec) {
		System.err.println("��ʼ��...");
		AndroidScreenMonitor.main(null);
		System.err.println("start : Android-Screen-Monitor ...");
	}
}

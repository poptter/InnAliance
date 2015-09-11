package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.adakoda.android.asm.AndroidScreenMonitor;

public class init implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sec) {
		System.err.println("穷则变，变则通，通则久之 ！");
	}

	@Override
	public void contextInitialized(ServletContextEvent sec) {
		System.err.println("初始化...");
		AndroidScreenMonitor.main(null);
		System.err.println("start : Android-Screen-Monitor ...");
	}
}

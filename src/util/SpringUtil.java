package util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	public static Object getBean(String name){
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		return factory.getBean(name);
	}
}

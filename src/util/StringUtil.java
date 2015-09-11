package util;

import java.util.Random;

/**
 * 产生随机字符串
 * @author Lenovo
 *
 */
public class StringUtil {

	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }   
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(StringUtil.getRandomString(6));	
		}
	}

}

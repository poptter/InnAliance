package util;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.junit.Test;

/**
 * MD5加密
 * @author Administrator
 */
public class Md5Util {

	/**
	 * MD5算法
	 * @param str
	 * @return
	 */
	public static String enCode1(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = str.getBytes();
			//java.security.MessageDigest类用于为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
			MessageDigest mdTemp = MessageDigest.getInstance("md5");
			mdTemp.update(strTemp);//使用指定的字节更新摘要
			byte[] md = mdTemp.digest();//通过执行诸如填充之类的最终操作完成哈希计算
			int j = md.length;
			char c[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				c[k++] = hexDigits[byte0 >>> 4 & 0xf];
				c[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(c);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * JAVA自带MD5
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String enCode2(String str) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
					i += 256;					
				}
				if (i < 1){
					sb.append("0");					
				}
				//转16进制数
				sb.append(Integer.toHexString(i));
			}
		} catch (Exception e) {
			return null;
			// e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}

	@Test
	public void Test(){
		System.out.println(enCode1("1230").toUpperCase());
		System.out.println(enCode2("1230").toUpperCase());
	}
}
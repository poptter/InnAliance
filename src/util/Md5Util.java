package util;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.junit.Test;

/**
 * MD5����
 * @author Administrator
 */
public class Md5Util {

	/**
	 * MD5�㷨
	 * @param str
	 * @return
	 */
	public static String enCode1(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = str.getBytes();
			//java.security.MessageDigest������ΪӦ�ó����ṩ��ϢժҪ�㷨�Ĺ��ܣ��� MD5 �� SHA �㷨��
			MessageDigest mdTemp = MessageDigest.getInstance("md5");
			mdTemp.update(strTemp);//ʹ��ָ�����ֽڸ���ժҪ
			byte[] md = mdTemp.digest();//ͨ��ִ���������֮������ղ�����ɹ�ϣ����
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
	 * JAVA�Դ�MD5
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
				//ת16������
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
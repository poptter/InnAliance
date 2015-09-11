package util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import po.OrderRoom;

/**
 * ͨ������Android�ֻ����Ͷ���
 * @author ��־
 * vrsion �� 1.0 
 * Bag ��������������������� 
 */
public class SmsUtil{

	/**
	 * ִ�ж��CMD����
	 * @param cmds ����������
	 */
	public static void executes(String[] cmds) {
		try {
			for (String str : cmds) {
				new SmsUtil().execute(str);
			}
		} finally{//�ָ��ֻ�״̬
			try{
				Thread.sleep(2000);
				String endCmd = "adb shell input tap 200 200";//����ָ����
				new SmsUtil().execute(endCmd);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ִ��CMD
	 * @param sendStr ִ�е�CMD����
	 */
	public synchronized static void execute(String sendStr) {
		Process process = null;
		try {
			System.err.println("���"+sendStr);
			sendStr = new String(sendStr.getBytes("UTF-8"),"GBK");
			process = Runtime.getRuntime().exec(sendStr);
			//����0.5��
			//Thread.sleep(500);
			process.waitFor();
			InputStreamReader isr = new InputStreamReader(process.getInputStream());
			Scanner sc = new Scanner(isr);
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			process.destroy();
		}
	}
	
	/**
	 * ���ͼ�����/��֤��
	 * @param number ���պ���
	 * @param activationCode ��������
	 */
	//*ע����Amdroid�ֻ�UI��ͬ�������ͷ�����������Sony st26i 4.04 ����
	public static void send(String number,String contents) {
		String[] sendStr = {
				//"adb shell input keyevent 83",//����
				"adb shell am start -a android.intent.action.SENDTO -d sms:" + number + " --es sms_body '" + contents + "' --ez exit_on_sent true",
				//ģ�ⰴ��
				"adb shell input keyevent 22",//��������
				"adb shell input keyevent 23",//ȷ�ϼ�
				"adb shell input keyevent 4",//���ؼ�
				//"adb shell input keyevent 66",//�س���
				"adb shell input keyevent 4",//���ؼ�
				"adb shell input keyevent 4"//���ؼ�
				};
		executes(sendStr);
		
	}
	//�һ�����
	public static void sendNewPwd(String phoneNumber ,String newPwd){
		String contents="�ף�����������Ϊ" +newPwd+ "���꣡���������ܸ��߱���Ŷ��[��ջ����^_^]";
		SmsUtil.send(phoneNumber, contents);
	}
	
	//ͨ�����
	public static void sendPassExamine(String phoneNumber,String innName){
		String contents="�ף���ϲ������"+innName+"����ջ��ͨ���˹������ˣ�������¼@��ջ����@ϵͳ���������ջ�ķ��䡣[��ջ����^_^]";
		SmsUtil.send(phoneNumber, contents);
	}
	
	//��������
	public static void sendOrderMsg(String phoneNumber,OrderRoom orderRoom){
		//���ڸ�ʽ����
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String contents="�𾴵��û�"+orderRoom.getGuest().getUserInfo().getUserName()+
				"�����ѳɹ�Ԥ��"+orderRoom.getInn().getInnName()+
				"(��ջ) "+orderRoom.getRoom().getRoomName()+
				"(�ͷ�)��������ţ�"+orderRoom.getOrderRoomId()+
				"��Ԥ��ʱ��Ϊ��"+formatter.format(orderRoom.getOrderRoomBeginTime()).toString()+
				" - "+formatter.format(orderRoom.getOrderRoomEndTime()).toString()+
				" ��ף��������죡[��ջ����^_^]";
		SmsUtil.send(phoneNumber, contents);
	} 

	//����
	public static void main(String[] args) {
		String number="18788114096";
		String activationCode="9527";
		String contents="�ף�������֤��Ϊ" +activationCode+ "���꣡���������ܸ��߱���Ŷ��";
		SmsUtil.send(number, contents);
	}
}
package util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import po.OrderRoom;

/**
 * 通过调用Android手机发送短信
 * @author 杨志
 * vrsion ： 1.0 
 * Bag ：还存在中文乱码的问题 
 */
public class SmsUtil{

	/**
	 * 执行多个CMD命令
	 * @param cmds 发送命令组
	 */
	public static void executes(String[] cmds) {
		try {
			for (String str : cmds) {
				new SmsUtil().execute(str);
			}
		} finally{//恢复手机状态
			try{
				Thread.sleep(2000);
				String endCmd = "adb shell input tap 200 200";//触摸指定点
				new SmsUtil().execute(endCmd);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行CMD
	 * @param sendStr 执行的CMD命令
	 */
	public synchronized static void execute(String sendStr) {
		Process process = null;
		try {
			System.err.println("命令："+sendStr);
			sendStr = new String(sendStr.getBytes("UTF-8"),"GBK");
			process = Runtime.getRuntime().exec(sendStr);
			//休眠0.5秒
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
	 * 发送激活码/验证码
	 * @param number 接收号码
	 * @param activationCode 发送内容
	 */
	//*注：因Amdroid手机UI不同，本发送方法仅适用于Sony st26i 4.04 机型
	public static void send(String number,String contents) {
		String[] sendStr = {
				//"adb shell input keyevent 83",//解锁
				"adb shell am start -a android.intent.action.SENDTO -d sms:" + number + " --es sms_body '" + contents + "' --ez exit_on_sent true",
				//模拟按键
				"adb shell input keyevent 22",//导航向右
				"adb shell input keyevent 23",//确认键
				"adb shell input keyevent 4",//返回键
				//"adb shell input keyevent 66",//回车键
				"adb shell input keyevent 4",//返回键
				"adb shell input keyevent 4"//返回键
				};
		executes(sendStr);
		
	}
	//找回密码
	public static void sendNewPwd(String phoneNumber ,String newPwd){
		String contents="亲！您的新密码为" +newPwd+ "。嘘！打死都不能告诉别人哦！[客栈联盟^_^]";
		SmsUtil.send(phoneNumber, contents);
	}
	
	//通过审核
	public static void sendPassExamine(String phoneNumber,String innName){
		String contents="亲！恭喜！您的"+innName+"（客栈）通过了管理的审核！请您登录@客栈联盟@系统，添加您客栈的房间。[客栈联盟^_^]";
		SmsUtil.send(phoneNumber, contents);
	}
	
	//订单短信
	public static void sendOrderMsg(String phoneNumber,OrderRoom orderRoom){
		//日期格式处理
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String contents="尊敬的用户"+orderRoom.getGuest().getUserInfo().getUserName()+
				"，您已成功预定"+orderRoom.getInn().getInnName()+
				"(客栈) "+orderRoom.getRoom().getRoomName()+
				"(客房)。订单编号："+orderRoom.getOrderRoomId()+
				"，预定时间为："+formatter.format(orderRoom.getOrderRoomBeginTime()).toString()+
				" - "+formatter.format(orderRoom.getOrderRoomEndTime()).toString()+
				" ，祝您生活愉快！[客栈联盟^_^]";
		SmsUtil.send(phoneNumber, contents);
	} 

	//测试
	public static void main(String[] args) {
		String number="18788114096";
		String activationCode="9527";
		String contents="亲！您的验证码为" +activationCode+ "。嘘！打死都不能告诉别人哦！";
		SmsUtil.send(number, contents);
	}
}
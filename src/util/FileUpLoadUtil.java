package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpLoadUtil extends HttpServlet{
    
	@SuppressWarnings("unchecked")
	public static int upLoad(HttpServletRequest request,String uploadPath)throws ServletException, UnsupportedEncodingException {
		String tempPath = uploadPath+"/buffer/"; // 临时文件目录
		File tempPathFile=null;
		int result=0;
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			// 设置缓冲区大小，这里是4kb
			factory.setSizeThreshold(4096); 
			
			// 设置缓冲区目录
			factory.setRepository(tempPathFile);

			ServletFileUpload upload = new ServletFileUpload(factory);

			// 设置最大文件尺寸，这里是4MB
			upload.setSizeMax(4194304); 

			// 得到所有的文件
			List<FileItem> list = upload.parseRequest(request);
			Iterator<FileItem> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				FileItem fi = (FileItem) iterator.next();
				String fileName = fi.getName();
				if (fileName != null) {
					//写入的文件数量
					result++;
					
					File fullFile = new File(fi.getName());
					
					//文件路径不存在就创建
					File uploadFile = new File(uploadPath);
					if (!uploadFile.exists()) {
						uploadFile.mkdirs();
					}
					//缓存路径不存在就创建
					tempPathFile = new File(tempPath);
					if (!tempPathFile.exists()) {
						tempPathFile.mkdirs();
					}
					File savedFile = new File(uploadPath, fullFile.getName());
					fi.write(savedFile);
				}
			}
		} catch (Exception e) {
			// 可以跳转出错页面
			e.printStackTrace();
		}
		return result; 
	}
	
    public static int upLoad(String fileDir,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int result=0;
    	//容器相对路径（Tomcat服务器）
        //String filepath = request.getRealPath(fileDir);
        
        //容器绝对路径
        String filepath =fileDir;
        //缓存文件路径
        File temp = new File(filepath+"/bufer");
        if(! temp.exists()) {
            temp.mkdirs();
        }
        
        //创建磁盘工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //文件缓存路径
        factory.setRepository(temp);
        factory.setSizeThreshold(10 * 4096 );
        //创建处理工具
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //服务器端可以接收的最大文件大小，-1表示无上限
        sfu.setSizeMax(10*1024*1024);
        String filename = null;
        try {
        	//解析
            List<FileItem> list = sfu.parseRequest(request);
            FileItem item= list.get(0);
            filename = item.getName();
            if(filename.equals("")) {
                return result;
            }
            /*
            //取文件文件格式
            int pos = filename.lastIndexOf(".");
            if(pos > 0) {
            	//按上传的时间（毫秒数）命名
                Date date = new Date();
                filename =filepath+'/'+ date.getTime()+filename.substring(pos);
            }*/
            
            filename =filepath+'/'+filename;
            //写到磁盘
            item.write(new File(filename));
            result++;
        } catch(Exception e) {
            e.printStackTrace();
        }finally{
        	return result;
        }
    }

    public static int downLoad(String filename,HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        
    	int result=0;
        if (filename == null){
        	filename = "";        	
        }
        
        filename = filename.trim();

        InputStream inStream = null;
        String attchname = "";

        byte[] b = new byte[1024];
        int len = 0;
        try {            
        	//取得附件的名称
            attchname = getAttachName(filename);
            //取得附件的全路径
            filename = getRealName(filename);
            if (filename == null) {
                System.out.println("文件不存在,或者禁止下载");
                return len;
            }
            //将文件转码 UTF-8
			//attchname = toUtf8String(attchname);
            inStream = new FileInputStream(filename+attchname);
            //必须reset，否则会出现文件不完整
            response.reset();
            //
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment; filename=\""+ attchname + "\"");
            
            //循环取出流中的数据 
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	try {
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return result;
        }
    }

    //取得附件的名称
    public static String getAttachName(String filename) {
        if (filename == null)
            return "";
        filename = filename.trim();
        int pos = 0;
        
        pos = filename.lastIndexOf("\\");        
        if (pos > -1) {
            filename = filename.substring(pos + 1);
        }        
        
        pos = filename.lastIndexOf("/");        
        if (pos > -1) {
            filename = filename.substring(pos + 1);
        }
        
        pos = filename.lastIndexOf(File.separator);        
        if (pos > -1) {
            filename = filename.substring(pos + 1);
        }
        
        return filename;
    }

    //UTF8转码
    public static String toUtf8String(String string) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("UTF-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0){
                    	k += 256;                    	
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        String s_utf8 = sb.toString();
        sb.delete(0, sb.length());
        sb.setLength(0);
        sb = null;
        return s_utf8;
    }

    //取得下载文件的真实全路径名称
	private static String getRealName(String filename) {

        filename = filename.trim();
        if (filename.equals("")){
        	return null;        	
        }
        int pos1=filename.lastIndexOf("/");
        int pos2=filename.lastIndexOf("\\");
        String filepath = filename.substring(0, (pos1>pos2?pos1:pos2)+1);
        File file = new File(filepath);
        if (!file.exists()){
        	return null;        	
        }
        return filepath;
    }
}
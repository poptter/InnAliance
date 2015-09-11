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
		String tempPath = uploadPath+"/buffer/"; // ��ʱ�ļ�Ŀ¼
		File tempPathFile=null;
		int result=0;
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			// ���û�������С��������4kb
			factory.setSizeThreshold(4096); 
			
			// ���û�����Ŀ¼
			factory.setRepository(tempPathFile);

			ServletFileUpload upload = new ServletFileUpload(factory);

			// ��������ļ��ߴ磬������4MB
			upload.setSizeMax(4194304); 

			// �õ����е��ļ�
			List<FileItem> list = upload.parseRequest(request);
			Iterator<FileItem> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				FileItem fi = (FileItem) iterator.next();
				String fileName = fi.getName();
				if (fileName != null) {
					//д����ļ�����
					result++;
					
					File fullFile = new File(fi.getName());
					
					//�ļ�·�������ھʹ���
					File uploadFile = new File(uploadPath);
					if (!uploadFile.exists()) {
						uploadFile.mkdirs();
					}
					//����·�������ھʹ���
					tempPathFile = new File(tempPath);
					if (!tempPathFile.exists()) {
						tempPathFile.mkdirs();
					}
					File savedFile = new File(uploadPath, fullFile.getName());
					fi.write(savedFile);
				}
			}
		} catch (Exception e) {
			// ������ת����ҳ��
			e.printStackTrace();
		}
		return result; 
	}
	
    public static int upLoad(String fileDir,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int result=0;
    	//�������·����Tomcat��������
        //String filepath = request.getRealPath(fileDir);
        
        //��������·��
        String filepath =fileDir;
        //�����ļ�·��
        File temp = new File(filepath+"/bufer");
        if(! temp.exists()) {
            temp.mkdirs();
        }
        
        //�������̹���
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //�ļ�����·��
        factory.setRepository(temp);
        factory.setSizeThreshold(10 * 4096 );
        //����������
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //�������˿��Խ��յ�����ļ���С��-1��ʾ������
        sfu.setSizeMax(10*1024*1024);
        String filename = null;
        try {
        	//����
            List<FileItem> list = sfu.parseRequest(request);
            FileItem item= list.get(0);
            filename = item.getName();
            if(filename.equals("")) {
                return result;
            }
            /*
            //ȡ�ļ��ļ���ʽ
            int pos = filename.lastIndexOf(".");
            if(pos > 0) {
            	//���ϴ���ʱ�䣨������������
                Date date = new Date();
                filename =filepath+'/'+ date.getTime()+filename.substring(pos);
            }*/
            
            filename =filepath+'/'+filename;
            //д������
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
        	//ȡ�ø���������
            attchname = getAttachName(filename);
            //ȡ�ø�����ȫ·��
            filename = getRealName(filename);
            if (filename == null) {
                System.out.println("�ļ�������,���߽�ֹ����");
                return len;
            }
            //���ļ�ת�� UTF-8
			//attchname = toUtf8String(attchname);
            inStream = new FileInputStream(filename+attchname);
            //����reset�����������ļ�������
            response.reset();
            //
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment; filename=\""+ attchname + "\"");
            
            //ѭ��ȡ�����е����� 
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

    //ȡ�ø���������
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

    //UTF8ת��
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

    //ȡ�������ļ�����ʵȫ·������
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
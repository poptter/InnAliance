package util;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * ���������ݱ�
 * @author Administrator
 *
 */
public class CreateTable {
	public static void main(String[] args) {
		//��ȡ�������ļ�
		Configuration cfg = new Configuration().configure();
		//����Schema
		SchemaExport export = new SchemaExport(cfg);
		//������
		export.create(true, true);
	}
}

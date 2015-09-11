package util;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 正向导入数据表
 * @author Administrator
 *
 */
public class CreateTable {
	public static void main(String[] args) {
		//读取主配置文件
		Configuration cfg = new Configuration().configure();
		//创建Schema
		SchemaExport export = new SchemaExport(cfg);
		//导出表
		export.create(true, true);
	}
}

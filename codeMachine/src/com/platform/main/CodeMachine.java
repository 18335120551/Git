package com.platform.main;

import java.sql.SQLException;
import java.util.Map;

import com.platform.tool.data.DataService;
import com.platform.tool.data.DataServiceImpl;
import com.platform.tool.freeMaker.FreeMakerUtil;
import com.platform.tool.util.ConvertUtil;

public class CodeMachine {

	// 默认生成文件的路径
	private static String generatePath = "E:\\黑马51期\\KLH_Code\\SSH\\templete";
	private static String packageName = "cn.itheima.domain";

	private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();
	private static DataService dataService = new DataServiceImpl();

	// 生成VO文件
	public static void generateVoFile(String tableName, String packageName, String classPre, String fileName)
			throws SQLException {
		generateFileWithDb("voModel.ftl", tableName, packageName, classPre, fileName);
	}

	// 根据不同模板生成文件 (包含列数据)
	public static void generateFileWithDb(String templateName, String tableName, String packageName, String classPre,
			String fileName) throws SQLException {
		Map<String, Object> templateData = dataService.getDbTemplateData(tableName, packageName, classPre);
		freeMakerUtil.generateFile(templateName, templateData, generatePath + fileName);
	}

	// 生成Dao文件
	public static void generateDaoFile(String tableName, String packageName, String classPre, String fileName) {
		generateFileWithOutDb("daoModel.ftl", tableName, packageName, classPre, fileName);
	}

	// 根据不同模板生成文件 (无需操作数据库，没有列数据)
	public static void generateFileWithOutDb(String templateName, String tableName, String packageName, String classPre,
			String fileName) {
		Map<String, Object> templateData = dataService.getTemplateDataWithOutDb(tableName, packageName, classPre);
		freeMakerUtil.generateFile(templateName, templateData, generatePath + fileName);
	}

	public static void generateFileWithDb(String templateName, String tableName, String fileNameSuffix)
			throws SQLException {
		String className = ConvertUtil.getClassName(tableName);
		System.out.println(className);
		Map<String, Object> templateData = dataService.getDbTemplateData(tableName, packageName, className);

		String fileNamePrefix = ConvertUtil.formatAaa(className);
		System.out.println(fileNamePrefix);
		if (fileNameSuffix.endsWith(".jsp")) {
			fileNamePrefix = ConvertUtil.formatLower(className);
			fileNamePrefix = fileNamePrefix + ""; // 如果是jsp文件按modelList.jsp命名规则
		}
		freeMakerUtil.generateFile(templateName, templateData, generatePath + fileNamePrefix + fileNameSuffix);
	}

	// 设置文件生成目录
	public static void setGeneratePath(String generatePath) {
		CodeMachine.generatePath = generatePath;
	}

	// 设置包路径
	public static void setPackageName(String packageName) {
		CodeMachine.packageName = packageName;
	}

}

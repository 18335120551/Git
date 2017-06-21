package execute;

import java.sql.SQLException;
import com.platform.main.CodeMachine;

public class RunEntrance {

	public static void main(String[] args) throws SQLException {
		String tableName = "FACTORY_C";

		CodeMachine.setGeneratePath("E:\\黑马51期\\KLH_Code\\SSH\\");
		CodeMachine.setPackageName("com.itheima");

		// CodeMachine.generateFileWithDb("demo.ftl", tableName, "Demo.java");

		CodeMachine.generateFileWithDb("config.ftl", tableName, "Config.txt");
		CodeMachine.generateFileWithDb("poModel.ftl", tableName, ".java");
		CodeMachine.generateFileWithDb("mapper.hbm.ftl", tableName, ".hbm.xml");
		CodeMachine.generateFileWithDb("ServiceInterface.ftl", tableName, "Service.java");
		CodeMachine.generateFileWithDb("ServiceImpl.ftl", tableName, "ServiceImpl.java");
		CodeMachine.generateFileWithDb("Action.ftl", tableName, "Action.java");

		// 生成页面
		CodeMachine.generateFileWithDb("modelList.jsp", tableName, "List.jsp");
		CodeMachine.generateFileWithDb("modelCreate.jsp", tableName, "Create.jsp");
		CodeMachine.generateFileWithDb("modelUpdate.jsp", tableName, "Update.jsp");
		CodeMachine.generateFileWithDb("modelView.jsp", tableName, "View.jsp");

		System.out.println("Generate success...");
	}

}

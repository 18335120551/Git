package ${package}.action.cargo;

import java.util.List;

import ${package}.action.BaseAction;
import ${package}.domain.${className};
import ${package}.utils.PageBean;
import ${package}.service.${className}Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>
@SuppressWarnings("all")
public class ${className}Action extends BaseAction implements ModelDriven<${className}> {
	
	private static final long serialVersionUID = 1L;
	private ${className} model = new ${className}();
	//注入service
	private ${className}Service ${className?uncap_first}Service;
	//属性驱动,接收并封装页面参数
	private PageBean pageBean = new PageBean();

	//分页查询
	public String list() throws Exception{
		//拼接SQL语句
		String hql = " from ${className} ";
		pageBean = ${className?uncap_first}Service.findPageBean(hql, pageBean, ${className}.class, null);
		//设置url参数,配置分页按钮的转向链接
		pageBean.setUrl("${className?uncap_first}Action_list");		
		super.push(pageBean);
		
		return "list";
	}
	
	//跳转到新增页面
	public String tocreate() throws Exception{
		//准备数据
		List<${className}> ${className?uncap_first}List = ${className?uncap_first}Service.find(" from ${className} ",${className}.class,null);
		super.put("${className?uncap_first}List", ${className?uncap_first}List);	
		
		return "tocreate";
	}
	
	//添加数据
	public String insert() throws Exception{
		${className?uncap_first}Service.saveOrUpdate(model);
		
		return "tolist";
	}

	//跳转到修改页面
	public String toupdate() throws Exception{
		//准备数据
		List<${className}> ${className?uncap_first}List = ${className?uncap_first}Service.find(" from ${className} ",${className}.class,null);
		super.put("${className?uncap_first}List", ${className?uncap_first}List);		
		//准备修改的数据
		${className} obj = ${className?uncap_first}Service.get(${className}.class,model.getId());
		super.push(obj);
		
		return "toupdate";
	}
	
	//修改保存
	public String update() throws Exception{
		${className} ${className?uncap_first} = ${className?uncap_first}Service.get(${className}.class, model.getId());
		//设置修改的属性,根据业务去掉自动生成多余的属性
		<#list properties as pro>  
			${className?uncap_first}.set${pro.proName?cap_first}(model.get${pro.proName?cap_first}());
		</#list>
		${className?uncap_first}Service.saveOrUpdate(${className?uncap_first});
		
		return "tolist";
	}
	
	//删除单个数据
	public String deleteById() throws Exception{
		${className?uncap_first}Service.deleteById(${className}.class,model.getId());
		
		return "tolist";
	}
	
	
	//删除多条数据
	public String delete() throws Exception{
		${className?uncap_first}Service.delete(${className}.class,model.getId().split(", "));
		
		return "tolist";
	}
	
	//查看
	public String toview() throws Exception{
		${className} ${className?uncap_first}List = ${className?uncap_first}Service.get(${className}.class, model.getId());
		super.push(${className?uncap_first}List);
		
		return "toview";
	}
	
	public void set${className}Service(${className}Service ${className?uncap_first}Service) {
		this.${className?uncap_first}Service = ${className?uncap_first}Service;
	}

	public ${className} getModel() {
		return this.model;
	}
	
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}

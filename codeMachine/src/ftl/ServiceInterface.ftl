package ${package}.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ${package}.domain.${className};
import ${package}.utils.PageBean;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>
public interface ${className}Service {

	public List<${className}> find(String hql, Class<${className}> entityClass, Object[] params);
	
	public ${className} get(Class<${className}> entityClass, Serializable id);
	
	public PageBean<${className}> findPageBean(String hql, PageBean<${className}> pageBean, Class<${className}> entityClass, Object[] params);
	
	public void saveOrUpdate(${className} entity);
	
	public void saveOrUpdateAll(Collection<${className}> entitys);
	
	public void deleteById(Class<${className}> entityClass, Serializable id);
	
	public void delete(Class<${className}> entityClass, Serializable[] ids);
}

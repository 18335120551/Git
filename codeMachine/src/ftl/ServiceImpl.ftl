package ${ package }.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ${package}.dao.BaseDao;
import ${package}.domain.${className};
import ${package}.utils.PageBean;
import ${package}.service.${className}Service;
import ${package}.util.UtilFuns;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>
public class ${className}ServiceImpl implements ${className}Service {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<${className}> find(String hql, Class<${className}> entityClass, Object[] params) {
		return baseDao.find(hql, ${className}.class, params);
	}

	public ${className} get(Class<${className}> entityClass, Serializable id) {
		return baseDao.get(${className}.class, id);
	}

	public PageBean<${className}> findPageBean(String hql, PageBean<${className}> pageBean, Class<${className}> entityClass, Object[] params) {
		return baseDao.findPage(hql, pageBean, ${className}.class, params);
	}

	public void saveOrUpdate(${className} entity) {
		if(UtilFuns.isEmpty(entity.getId())){	
		
		}
		baseDao.saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<${className}> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<${className}> entityClass, Serializable id) {
		baseDao.deleteById(${className}.class, id);
	}

	public void delete(Class<${className}> entityClass, Serializable[] ids) {
		baseDao.delete(${className}.class, ids);
	}

}

package com.itheima.mapper;

import java.util.List;

import com.itheima.domain.BaseDict;

public interface BaseDictMapper {

	// 查询字典表
	public List<BaseDict> findBaseDictByCode(String code);
}

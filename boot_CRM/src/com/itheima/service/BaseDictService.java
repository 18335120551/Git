package com.itheima.service;

import java.util.List;

import com.itheima.domain.BaseDict;

public interface BaseDictService {
	// 查询字典表
		public List<BaseDict> findBaseDictByCode(String code);
}

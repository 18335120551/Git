package com.itheima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.domain.BaseDict;
import com.itheima.mapper.BaseDictMapper;

@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper basedictMapper;

	@Override
	public List<BaseDict> findBaseDictByCode(String code) {

		return basedictMapper.findBaseDictByCode(code);
	}

}

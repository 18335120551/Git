package com.itheima.mapper;

import java.util.List;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;

public interface CustomerMapper {

	// 根据QueryVo查询总记录数
	public Integer findTotalCount(QueryVo vo);

	// 根据QueryVo根据条件查询
	public List<Customer> findCustomer(QueryVo vo);

	public Customer findCustomerById(Integer id);

	public void updateCustomerById(Customer customer);

	public void deleteCustomerById(Integer id);
}

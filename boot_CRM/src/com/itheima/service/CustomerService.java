package com.itheima.service;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.utils.Page;

public interface CustomerService {

	// 根据QueryVo查询分页数据
	public Page<Customer> findPageByQueryVo(QueryVo vo);

	// 根据id查询客户
	public Customer findCustomerById(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteCustomerById(Integer id);
}

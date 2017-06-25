package com.itheima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.mapper.CustomerMapper;
import com.itheima.utils.Page;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	// 根据QueryVo查询分页数据
	@Override
	public Page<Customer> findPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();

		// 设置开始索引
		vo.setStart((vo.getPage() - 1) * vo.getRows());
		// 根据分页条件查询数据
		List<Customer> list = customerMapper.findCustomer(vo);
		// 封装当前页
		page.setPage(vo.getPage());
		// 封装每页显示条数
		page.setSize(vo.getRows());
		// 查询总记录数
		Integer totalCount = customerMapper.findTotalCount(vo);
		// 封装总记录数
		page.setTotal(totalCount);
		// 封装list集合
		page.setRows(list);

		return page;
	}

	// 根据id查询客户
	@Override
	public Customer findCustomerById(Integer id) {

		return customerMapper.findCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}
}

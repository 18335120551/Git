package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {

	// 客户来源
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	// 客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	// 客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	// 显示用户列表
	@RequestMapping("list")
	public String findCustomers(QueryVo vo, Model model) {
		// 客户来源
		List<BaseDict> fromType = baseDictService.findBaseDictByCode(CUSTOMER_FROM_TYPE);
		// 客户行业
		List<BaseDict> industryType = baseDictService.findBaseDictByCode(CUSTOMER_INDUSTRY_TYPE);
		// 客户级别
		List<BaseDict> levelType = baseDictService.findBaseDictByCode(CUSTOMER_LEVEL_TYPE);

		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		Page<Customer> page = customerService.findPageByQueryVo(vo);
		model.addAttribute("page", page);

		return "customer";
	}

	// 跳转到修改页面
	@RequestMapping("edit.action")
	public @ResponseBody Customer edit(Integer id) {
		Customer customer = customerService.findCustomerById(id);

		return customer;
	}

	// 修改客户信息
	@RequestMapping("update.action")
	public @ResponseBody String update(Customer customer) {
		customerService.updateCustomer(customer);

		return "OK";
	}

	// 根据id删除客户信息
	@RequestMapping("delete.action")
	public @ResponseBody String delete(Integer id) {
		customerService.deleteCustomerById(id);

		return "OK";
	}
}

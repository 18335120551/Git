package com.itheima.domain;

public class QueryVo {

	private String custName;
	private String custSource;
	private String custIndustry;

	private String custLevel;
	private Integer page = 1;// 当前页
	private Integer start;// 开始索引

	private Integer rows = 6;// 每页显示条数

	public String getCustName() {
		return custName;
	}

	public String getCustSource() {
		return custSource;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getRows() {
		return rows;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}

package com.platform.model;

/**
 * 
 * @Describetion 列对象 <br/>
 *               待改进:<br/>
 *               1.默认值<br/>
 *               2.主键 po id ok<br/>
 *               3.关联关系<br/>
 *               4.注释<br/>
 *               5.BaseEntity 是否继承<br/>
 *               6.文件包路径及目录<br/>
 * @author KLH
 * @createDate 2017年6月6日
 */
public class FieldBean {

	private String fieldName; // 数据库原字段名
	private String proName; // 变量名
	private String proType; // 变量的类型
	private String columnName; // 数据库表字段名
	private String proComment; // 备注
	private Boolean primary; // 是否主键
	private Boolean mandatory; // 是否必填

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getProComment() {
		return proComment;
	}

	public void setProComment(String proComment) {
		this.proComment = proComment;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

}

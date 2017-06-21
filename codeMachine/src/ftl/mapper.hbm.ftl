<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="${package}.domain">
	<class name="${className}" table="${tableName?upper_case}">
		<#list properties as pro>  
			<#if pro.primary>
				<id name="id" column="${pro.columnName}" type="${pro.proType?uncap_first}">
					<generator class="uuid"/>
				</id>
			</#if>
		</#list>
		
		<#list properties as pro>  
			<property name="${pro.proName?uncap_first}" column="${pro.columnName?upper_case}" type="${pro.proType?lower_case}"/>
		</#list>
	</class>
</hibernate-mapping>
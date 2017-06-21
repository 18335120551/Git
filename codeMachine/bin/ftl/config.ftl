<-- hibernate.cfg.xml --> 
	<mapping resource="${package?replace(".","/")}/domain/${className}.hbm.xml"/>

<-- applicationContext-service.xml --> 

	<bean id="${className?uncap_first}Service" class="${package}.service.impl.${className}ServiceImpl">
		<property name="baseDao" ref="baseDao"/>
	</bean>

<-- applicationContext-action.xml --> 

	<bean id="${className?uncap_first}Action" class="${package}.action.cargo.${className}Action" scope="prototype">
		<property name="${className?uncap_first}Service" ref="${className?uncap_first}Service"/>
	</bean>

<-- struts-xxx.xml --> 

	<action name="${className?uncap_first}Action_*" method="{1}" class="${className?uncap_first}Action">
		<result name="tolist" type="redirect">${className?uncap_first}Action_list</result>
		<result name="list">/WEB-INF/pages/cargo/${className?lower_case}/${className?lower_case}List.jsp</result>
		<result name="tocreate">/WEB-INF/pages/cargo/${className?lower_case}/${className?lower_case}Create.jsp</result>
		<result name="toupdate">/WEB-INF/pages/cargo/${className?lower_case}/${className?lower_case}Update.jsp</result>
		<result name="toview">/WEB-INF/pages/cargo/${className?lower_case}/${className?lower_case}View.jsp</result>
	</action>
	
		
		
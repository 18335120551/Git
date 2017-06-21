<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<script type="text/javascript">
			//更新数据
			function update() {
				formSubmit('${className?uncap_first}Action_update', '_self');
			}
			//返回列表
			function goBack() {
				formSubmit('${className?uncap_first}Action_list', '_self');
			}
		</script>
	</head>
	<body>
		<form name="icform" method="post">
			<input type="hidden" name="id" value="${'$'}{id}" />
			<div id="menubar">
				<div id="middleMenubar">
					<div id="innerMenubar">
						<div id="navMenubar">
							<ul>
								<li id="save">
									<a href="#" onclick="javascript:update()" style="text-decoration: none;">保存</a>
								</li>
								<li id="back">
									<a href="#" onclick="javascript:goBack()" style="text-decoration: none;">返回</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="textbox-title">
				<img src="${'$'}{KLH}/skin/default/images/icon/currency_yen.png" /> 修改XX
			</div>
			<div>
				<table class="commonTable" cellspacing="1">
					<#list properties as pro>
						<tr>
							<td class="columnTitle">
								<#if pro.proComment ??>${pro.proComment}</#if>
							</td>
							<td class="tableContent">
								<input type="text" name="${pro.proName}" value="${'$'}{${pro.proName}}" />
							</td>
						</tr>
					</#list>
				</table>
			</div>
		</form>
	</body>
</html>
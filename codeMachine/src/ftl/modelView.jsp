<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<script type="text/javascript">
		//返回列表
		function goBack() {
			formSubmit('${className?uncap_first}Action_list', '_self');
		}
		</script>
	</head>
	<body>
		<form name="icform" method="post">
			<div id="menubar">
				<div id="middleMenubar">
					<div id="innerMenubar">
						<div id="navMenubar">
							<ul>
								<li id="back">
									<a href="#" onclick="javascript:goBack()" style="text-decoration: none;">返回</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="textbox-title">
				<img src="${'$'}{KLH}/skin/default/images/icon/currency_yen.png" /> 浏览
			</div>
			<div>
				<table class="commonTable" cellspacing="1">
					<#list properties as pro>
						<tr>
							<td class="columnTitle">
								<#if pro.proComment ??>${pro.proComment}</#if></td>
							<td class="tableContent">${'$'}{${pro.proName}}</td>
						</tr>
					</#list>
				</table>
			</div>
		</form>
	</body>
</html>
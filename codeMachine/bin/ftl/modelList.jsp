<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<script>
			function isOnlyChecked() {
				var checkBoxArray = document.getElementsByName('id');
				var count = 0;
				for(var index = 0; index < checkBoxArray.length; index++) {
					if(checkBoxArray[index].checked) {
						count++;
					}
				}
				if(count == 1)
					return true;
				else
					return false;
			}
			//查看信息
			function toView() {
				if(isOnlyChecked()) {
					formSubmit('${className?uncap_first}Action_toview', '_self');
				} else {
					alert("请先选择一项并且只能选择一项，再进行操作！");
				}
			}
			//新增信息
			function toCreate() {
				formSubmit('${className?uncap_first}Action_tocreate', '_self');
			}
			//实现更新
			function toUpdate() {
				if(isOnlyChecked()) {
					formSubmit('${className?uncap_first}Action_toupdate', '_self');
				} else {
					alert("请先选择一项并且只能选择一项，再进行操作！");
				}
			}
			//实现删除
			function toDelete() {
				var checkBoxArray = document.getElementsByName('id');
				var count = 0;
				for(var index = 0; index < checkBoxArray.length; index++) {
					if(checkBoxArray[index].checked) {
						count++;
					}
				}
				if(count > 0) {
					if(confirm("确认删除这些数据吗?")) {
						formSubmit('${className?uncap_first}Action_delete', '_self');
					}
				} else {
					alert("请先选择要删除的数据，再进行操作！");
				}
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
								<shiro:hasPermission name="查看XX">
									<li id="view">
										<a href="#" onclick="javascript:toView()" style="text-decoration: none;">查看</a>
									</li>
								</shiro:hasPermission>
								<shiro:hasPermission name="新增XX">
									<li id="new">
										<a href="#" onclick="javascript:toCreate()" style="text-decoration: none;">新增</a>
									</li>
								</shiro:hasPermission>
								<shiro:hasPermission name="修改XX">
									<li id="update">
										<a href="#" onclick="javascript:toUpdate()" style="text-decoration: none;">修改</a>
									</li>
								</shiro:hasPermission>
								<shiro:hasPermission name="删除XX">
									<li id="delete">
										<a href="#" onclick="javascript:toDelete()" style="text-decoration: none;">删除</a>
									</li>
								</shiro:hasPermission>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="textbox-title">
				<img src="${'$'}{KLH}/skin/default/images/icon/currency_yen.png" />XX列表
			</div>
			<div>
				<div class="eXtremeTable">
					<table id="ec_table" class="tableRegion" width="98%">
						<thead>
							<tr>
								<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
								<td class="tableHeader">序号</td>
								<td class="tableHeader">编号</td>
								<#list properties as pro>
									<td class="tableHeader">${pro.proComment!}</td>
								</#list>
							</tr>
						</thead>
						<tbody class="tableBody">
							${'$'}{links}
							<c:forEach items="${'$'}{results}" var="object" varStatus="status">
								<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
									<td><input type="checkbox" name="id" value="${'$'}{object.id}" /></td>
									<td>${'$'}{status.index+1}</td>
									<td>
										<a href="${className?uncap_first}Action_toview?id=${'$'}{object.id}">${'$'}{object.name}</a>
									</td>
									<#list properties as pro>
										<td>${'$'}{object.${pro.proName}}</td>
									</#list>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</body>
</html>
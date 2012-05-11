<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fieldset>
	<table id="table">
			<thead id="thead">
				<tr>
					<td>
						<div class="cellHead">管理员</div>
					</td>
					<td>
						<div class="cellHead">权限&信息</div>
					</td>
					<td>
						<div class="cellHead">时间状态</div>
					</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}">
						<tr>
							<td colspan="5">暂无管理员。</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list}" var="one" varStatus="i">
								<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if>>
										<td>
											<div class="cellAdmin">
												<a href="/TimeBank/admin/AdminManager_viewOne?aid=${one.adminId}#header">
													<span class="emphasized">${one.username}</span><br />
													<c:if test="${!empty one.name}">
														<span class="gray">[${one.name}]</span>
													</c:if>
												</a>
											</div>
										</td>
										<td>
											<div class="cellInfo">
												<div class="cellBig">
													<a href="/TimeBank/admin/AdminManager_viewOne?aid=${one.adminId}#header">
														<c:choose>
															<c:when test="${empty one.level || one.level == 0}">
																（未定）
															</c:when>
															<c:when test="${one.level == 1}">
																普通管理员
															</c:when>
															<c:when test="${one.level == 2}">
																<span class="warn">超级管理员</span>
															</c:when>
															<c:otherwise>
																读取出错！
															</c:otherwise>
														</c:choose>
													</a>
												</div>
												<div class="cellSmall">
													对用户显示名为：${one.nameToUser}
													<c:if test="${one.linkedUserId != 0}">
														|
														已绑定用户账号
														[
															<a class="emphasized" href="SearchUser_viewOne?uid=${one.linkedUserId}#header">
																${one.linkedName}
															</a>
														]
													</c:if>
												</div>
											</div>
										</td>
										<td>
											<div class="cellTime tips">于<span class="emphasized">${one.createTime}</span>注册</div>
											<div class="cellZone tips">
													于<span class="emphasized">${one.updateTime}</span>更新
											</div>
										</td>
									</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
</fieldset>
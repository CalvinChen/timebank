<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="tableHelp">
	<thead id="thead">
		<tr>
			<td>
				<div class="cellHead">求助者</div>
			</td>
			<td>
				<div class="cellHead">帮助者</div>
			</td>
			<td>
				<div class="cellHead">互助内容</div>
			</td>
			<td>
				<div class="cellHead">时间地点</div>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty unhandleRecordList}">
				<tr>
					<td colspan="5">暂无数据。</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${unhandleRecordList}" var="one" varStatus="i">
							<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if>>
								<td>
									<div class="cellUser">
										<img class="userPicture60" src="${one.helpedPicture}" alt="${one.helpedUsername}" /><br />
										<span class="emphasized">${one.helpedUsername}</span>
									</div>
								</td>
								<td>
									<div class="cellUser">
										<img class="userPicture60" src="${one.toHelpPicture}" alt="${one.toHelpUsername}" /><br />
										<span class="emphasized">${one.toHelpUsername}</span>
									</div>
								</td>
								<td>
									<div class="cellRecord">
										<span id="message">
											<c:choose>
												<c:when test="${one.statusHelp == 1}">
													申请中，待审核
												</c:when>
												<c:when test="${one.statusHelp == 2}">
													已确认，并通过（可查看双方联系方式）
												</c:when>
												<c:when test="${one.statusHelp == 3}">
													已确认，不通过
												</c:when>
												<c:when test="${one.statusHelp == 4}">
													互助成功
												</c:when>
												<c:when test="${one.statusHelp == 5}">
													互助失败
												</c:when>
												<c:otherwise>状态获取出错！</c:otherwise>
											</c:choose>
										</span>
										<div class="cellDesc">
											<a href="HomepageAdmin_singleRecord?helpRecordId=${one.helpRecordId}">
												${one.range}
											</a>
										</div>
										<div class="cellRange tips">
											<c:choose>
												<c:when test="${one.requireBy == 1}">
													（由
													<span class="emphasized">
														<c:choose>
															<c:when test="${one.toHelpUserId == user.userId}">
																我
															</c:when>
															<c:otherwise>
																${one.toHelpUsername}
															</c:otherwise>
														</c:choose>
													</span>
													申请于${one.createTime}）
												</c:when>
												<c:when test="${one.requireBy == 2}">
													（由
													<span class="emphasized">
														<c:choose>
															<c:when test="${one.helpedUserId == user.userId}">
																我
															</c:when>
															<c:otherwise>
																${one.helpedUsername}
															</c:otherwise>
														</c:choose>
													</span>
													申请于${one.createTime}）
												</c:when>
											</c:choose>
										</div>
									</div>
								</td>
								<td>
									<div class="cellTime tips">于<span class="emphasized">${one.theDate}</span></div>
																<div class="cellTime tips">
																	的
																	<span class="emphasized">
																		<c:choose>
																			<c:when test="${one.theTime == 1}">第1、2节</c:when>
																			<c:when test="${one.theTime == 2}">第3、4节</c:when>
																			<c:when test="${one.theTime == 3}">整个上午</c:when>
																			<c:when test="${one.theTime == 4}">第5、6节</c:when>
																			<c:when test="${one.theTime == 5}">第7、8节</c:when>
																			<c:when test="${one.theTime == 6}">第9、10节</c:when>
																			<c:when test="${one.theTime == 7}">整个下午</c:when>
																			<c:when test="${one.theTime == 8}">第11、12节</c:when>
																			<c:when test="${one.theTime == 9}">整个白天</c:when>
																			<c:when test="${one.theTime == 10}">整个晚上</c:when>
																			<c:when test="${one.theTime == 11}">一整天</c:when>
																			<c:when test="${one.theTime == 12}">其它</c:when>
																		</c:choose>
																	</span>
																</div>
																<div class="cellZone tips">
																	在
																	<span class="emphasized">
																		<c:choose>
																			<c:when test="${one.zone == 1}">启林南</c:when>
																			<c:when test="${one.zone == 2}">启林北</c:when>
																			<c:when test="${one.zone == 3}">五山</c:when>
																			<c:when test="${one.zone == 4}">华山</c:when>
																			<c:when test="${one.zone == 5}">其它</c:when>
																			<c:otherwise>状态获取出错！</c:otherwise>
																		</c:choose>
																	</span>
																</div>
								</td>
							</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
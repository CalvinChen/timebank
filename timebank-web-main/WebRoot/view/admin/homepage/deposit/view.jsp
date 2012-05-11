<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>查看存储 - 业务中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
	<script type="text/javascript" src="/TimeBank/JS/nicEdit/nicEdit.js"></script>
	<script type="text/javascript" src="/TimeBank/JS/nicEdit/custom.js"></script>
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleMessageBoard.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title">
					<a href="#">
						查看提供帮助信息
					</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<div class="entry">
					<form action="HomepageAdmin_modifyD" method="post">
						<fieldset>
							<input type="hidden" name="depositRecord.depositId" value="${depositRecord.depositId}"/>
							<input type="hidden" name="depositRecord.userId" value="${depositRecord.userId}"/>
							<div class="oneRow clear">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${depositRecord.userId}#header">
										<img class="userPicture120" src="${depositRecord.picture }"/>
									</a>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">提供帮助者：</div>
								<div class="rowRight">
									<span class="emphasized">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${depositRecord.userId}#header">
											${depositRecord.username}
										</a>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">帮助时间：</div>
								<div class="rowRight">
									<span class="emphasized">
										<input type="text"
											   title="时间格式" class="tipFocus" rel="#liukong" 
											   name="depositRecord.theDate" value="${depositRecord.theDate}"/>
										的
										<select name="depositRecord.theTime">
											<option value="1" <c:if test="${depositRecord.theTime == 1}">selected="selected"</c:if>>第01、02节[大约08:00-09:35]</option>
											<option value="2" <c:if test="${depositRecord.theTime == 2}">selected="selected"</c:if>>第03、04节[大约10:05-11:40]</option>
											<option value="3" <c:if test="${depositRecord.theTime == 3}">selected="selected"</c:if>>整个上午</option>
											<option value="4" <c:if test="${depositRecord.theTime == 4}">selected="selected"</c:if>>第05、06节[大约12:30-14:05]</option>
											<option value="5" <c:if test="${depositRecord.theTime == 5}">selected="selected"</c:if>>第07、08节[大约14:30-16:05]</option>
											<option value="6" <c:if test="${depositRecord.theTime == 6}">selected="selected"</c:if>>第09、10节[大约16:35-18:10]</option>
											<option value="7" <c:if test="${depositRecord.theTime == 7}">selected="selected"</c:if>>整个下午</option>
											<option value="8" <c:if test="${depositRecord.theTime == 8}">selected="selected"</c:if>>第11、12节[大约19:30-21:05]</option>
											<option value="9" <c:if test="${depositRecord.theTime == 9}">selected="selected"</c:if>>整个白天</option>
											<option value="10" <c:if test="${depositRecord.theTime == 10}">selected="selected"</c:if>>整个晚上</option>
											<option value="11" <c:if test="${depositRecord.theTime == 11}">selected="selected"</c:if>>一整天</option>
											<option value="12" <c:if test="${depositRecord.theTime == 12}">selected="selected"</c:if>>其它[在详细说明中描述]</option>
											<option value="13" <c:if test="${depositRecord.theTime == 13}">selected="selected"</c:if>>双方协商时间段</option>
										</select>
									</span>
									<div id="liukong" style="display: none;">
										请以“2011-04-01”的格式输入日期，
										留空则表示“
										<span class="warn">
											双方协商
										</span>
										”！
									</div>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">帮助区域：</div>
								<div class="rowRight">
									<select name="depositRecord.zoneDeposit" id="L8">
										<option value="1" <c:if test="${depositRecord.zoneDeposit == 1}">selected="selected"</c:if>>启林南</option>
										<option value="2" <c:if test="${depositRecord.zoneDeposit == 2}">selected="selected"</c:if>>启林北</option>
										<option value="3" <c:if test="${depositRecord.zoneDeposit == 3}">selected="selected"</c:if>>五山</option>
										<option value="4" <c:if test="${depositRecord.zoneDeposit == 4}">selected="selected"</c:if>>华山</option>
										<option value="5" <c:if test="${depositRecord.zoneDeposit == 5}">selected="selected"</c:if>>其它</option>
									</select>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">帮助范围：</div>
								<div class="rowRight">
									<span class="emphasized">
										<select name="depositRecord.rangeDeposit" id="L8">
											<option value="1" <c:if test="${depositRecord.rangeDeposit == 1}">selected="selected"</c:if>>知识技能类</option>
											<option value="2" <c:if test="${depositRecord.rangeDeposit == 2}">selected="selected"</c:if>>休闲娱乐类</option>
											<option value="3" <c:if test="${depositRecord.rangeDeposit == 3}">selected="selected"</c:if>>体育运动类</option>
											<option value="4" <c:if test="${depositRecord.rangeDeposit == 4}">selected="selected"</c:if>>劳动修缮类</option>
											<option value="5" <c:if test="${depositRecord.rangeDeposit == 5}">selected="selected"</c:if>>其它[在详细说明中描述]</option>
										</select>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">
									详细说明：
								</div>
								<div class="rowRight">
									<textarea id="area1" rows="5" cols="65" name="depositRecord.description">${depositRecord.description}</textarea>
									<br />
									（
									<c:choose>
										<c:when test="${depositRecord.mode == 1}">
											Ta还可以提供
											<span class="bigNum">
												${depositRecord.seekLeft}
											</span>
											人次这样的帮助
										</c:when>
										<c:when test="${depositRecord.mode == 2}">
											在
											<span class="bigNum">
												${depositRecord.expireDate}
											</span>
											过期
										</c:when>
										<c:when test="${depositRecord.mode == 3}">
											Ta还可以提供
											<span class="bigNum">
												${depositRecord.seekLeft}
											</span>
											人次这样的帮助，并在
											<span class="bigNum">
												${depositRecord.expireDate}
											</span>
											过期
										</c:when>
									</c:choose>
									）
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft">匹配模式：</div>
								<div class="rowRight">
									<input type="radio" name="depositRecord.mode" value="1" id="ra1"
											<c:if test="${depositRecord.mode == 1}">checked="checked"</c:if>/>
										<label>
											1，匹配
											<%--
											<input type="text" <c:if test="${empty adminLogined}">maxLength="1"</c:if> size="1"
											onkeypress="if(event.keyCode<48||event.keyCode>57) return false;"
											style="ime-mode: disabled;"
											name="depositRecord.seekNumber"
											value="${depositRecord.seekNumber}"/>
											--%>
											<span class="bigNum">${depositRecord.seekNumber}</span>
											次后结束，剩余匹配次数为
											<input type="text" name="depositRecord.seekLeft" value="${depositRecord.seekLeft}"
												size="1"/>
											<input type="hidden" name="depositRecord.seekNumber" value="${depositRecord.seekNumber}"/>
											；
										</label>
										<br />
									<input type="radio" name="depositRecord.mode" value="2" id="ra2"
											<c:if test="${depositRecord.mode == 2}">checked="checked"</c:if>/>
										<label>
											2，到达
											<input type="text" name="depositRecord.expireDate" value="${depositRecord.expireDate}"
												size="8"/>
											时结束；
										</label>
										<br />
									<input type="radio" name="depositRecord.mode" value="3" id="ra3"
											<c:if test="${depositRecord.mode == 3}">checked="checked"</c:if>/>
										<label>
											3，综合模式，以上两项任意一项达到条件则结束。
										</label>
										<br />
										<hr />
									已有
									<span class="bigNum">
									${depositRecord.seekNumber - depositRecord.seekLeft}
									</span>
									人次申请匹配了这条记录，
									<br />
									当前记录状态为
									<span class="bigNum">
										<c:choose>
											<c:when test="${depositRecord.status == 6}">
												尚未配对完
											</c:when>
											<c:when test="${depositRecord.status == 7}">
												已过期
												（
												于
												<span class="bigNum">
													${depositRecord.expireDate}
												</span>
												时
												）
											</c:when>
											<c:when test="${depositRecord.status == 8}">
												已达匹配次数
												（
												共
												<span class="bigNum">
													${depositRecord.seekNumber}
												</span>
												次
												）
											</c:when>
											<c:otherwise>状态获取出错！</c:otherwise>
										</c:choose>
									</span>
									。
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft">
									<span>
										显示选项：
									</span>
								</div>
								<div class="rowRight">
									<span class="warn">以下两个选项用于发起会员活动时，平时请慎用！</span>
									<br />
									<input type="checkbox" name="depositRecord.toTop" value="1" id="toTop" 
										<c:if test="${depositRecord.toTop == 1}">checked="checked"</c:if>/>
									<label for="toTop">
										在列表中显示时置顶
									</label>
									<br />
									<input type="checkbox" name="depositRecord.detailed" value="1" id="detailed"
										<c:if test="${depositRecord.detailed == 1}">checked="checked"</c:if>/>
									<label for="detailed">
										在列表中显示时不省略篇幅
									</label>
								</div>
							</div>
							<hr/>
							<div class="oneRow clear">
								<div class="rowLeft">
									常规操作
								</div>
								<div class="rowRight">
									<input type="submit" value="修改完毕，提交！" class="button" onclick="return confirm('确认要执行这项操作吗？');"/>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft tips">其它操作</div>
								<div class="rowRight">
									<a href="HomepageAdmin_deleteD?did=${depositRecord.depositId}" class="button tips" onclick="return confirm('确认要执行这项操作吗？');">删除这条记录(慎用)</a>
								</div>
							</div>
						</fieldset>
						<fieldset id="messageBoard">
							<legend>留言板</legend>
							<p id="close">留言功能暂不开放，敬请期待。</p>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/homepage.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>
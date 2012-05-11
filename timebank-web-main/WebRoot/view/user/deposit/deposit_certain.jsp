<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>存储时间</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<c:if test="${!empty adminLogined}">
	<script type="text/javascript" src="/TimeBank/JS/nicEdit/nicEdit.js"></script>
	<script type="text/javascript" src="/TimeBank/JS/nicEdit/custom.js"></script>
</c:if>
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleFeedback.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">存入时间</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						每存入一个有效的、帮助到别人的时间，你便获得一枚时间币！
						<span id="tip_info">
							温馨提示：您可以在存入时间界面填写完整的描述信息，填写得越完整越有可能帮助到别人。
						</span>
					</a>
				</p>
				<div class="entry">
					<form action="Deposit_submit" method="post">
						<fieldset>
							<div class="oneRow clear">
								<div class="rowLeft"></div>
								<div class="rowRight"><span id="message">${message}<s:fielderror/></span></div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized"><label for="gettedTime">1，可帮助时间</label></div>
								<div class="rowRight">
									<select name="one.theDate">
										<c:forEach items="${days}" var="one" varStatus="i">
											<option value="${one}" <c:if test="${i.count == 5}">selected="selected"</c:if>>${one}</option>
										</c:forEach>
										<option value="">双方协商日期</option>
									</select>
									<select name="one.theTime">
										<option value="1">第01、02节[大约08:00-09:35]</option>
										<option value="2">第03、04节[大约10:05-11:40]</option>
										<option value="3">整个上午</option>
										<option value="4">第05、06节[大约12:30-14:05]</option>
										<option value="5">第07、08节[大约14:30-16:05]</option>
										<option value="6">第09、10节[大约16:35-18:10]</option>
										<option value="7">整个下午</option>
										<option value="8">第11、12节[大约19:30-21:05]</option>
										<option value="9">整个白天</option>
										<option value="10">整个晚上</option>
										<option value="11">一整天</option>
										<option value="12">其它[在详细说明中描述]</option>
										<option value="13">双方协商时间段</option>
									</select>
								</div>
							</div>
							<hr/>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">2，可帮助区域</div>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L1-1" type="radio" name="one.zoneDeposit" value="1" checked="checked"/>
											<label for="L1-1">启林南</label>
										</span>
										<span  class="radio">
											<input id="L1-2" type="radio" name="one.zoneDeposit" value="2"/>
											<label for="L1-2">启林北</label>
										</span>
										<span  class="radio">
											<input id="L1-4" type="radio" name="one.zoneDeposit" value="3"/>
											<label for="L1-4">五山</label>
										</span>
										<span  class="radio">
											<input id="L1-3" type="radio" name="one.zoneDeposit" value="4"/>
											<label for="L1-3">华山</label>
										</span>
										<br /><br />
										<span  class="radio">
											<input id="L1-5" type="radio" name="one.zoneDeposit" value="5"/>
											<label for="L1-5">其它<span class="tips">[在详细说明中描述]</span></label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">3，可帮助范围</div>
								<div class="rowRight">
									<span class="emphasized">
										<span  class="radio">
											<input id="L2-1" type="radio" name="one.rangeDeposit" value="1" checked="checked"/>
											<label for="L2-1">知识技能类</label>
										</span>
										<span  class="radio">
											<input id="L2-2" type="radio" name="one.rangeDeposit" value="2"/>
											<label for="L2-2">休闲娱乐类</label>
										</span>
										<span  class="radio">
											<input id="L2-3" type="radio" name="one.rangeDeposit" value="3"/>
											<label for="L2-3">体育运动类</label>
										</span>
										<span  class="radio">
											<input id="L2-4" type="radio" name="one.rangeDeposit" value="4"/>
											<label for="L2-4">劳动修缮类</label>
										</span>
										<br /><br />
										<span  class="radio">
											<input id="L2-5" type="radio" name="one.rangeDeposit" value="5"/>
											<label for="L2-5">其它<span class="tips">[在详细说明中描述]</span></label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized"><label for="area1">4，详细说明</label></div>
								<div class="rowRight">
									<textarea name="one.description" cols="60" rows="10" class="tipFocus"
											  rel="#text1" title="详细说明" id="area1"></textarea>
								</div>
							</div>
							<div id="text1" style="display: none;">
								<span class="emphasized">为了让其他人理解你所能提供帮助的内容，请尽量详细说明，例如：</span>
								<hr />
								<span class="tips">
									“我是广州本地人，看到很多人不会白话，但是又没有机会好好去学。
									而我之前有过教一个外地人学会白话的经验，所以觉得自己教白话的能力还可以吧。
									所以现在为了推广粤语！欢迎前来交流！”
								</span>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">5，匹配模式</div>
								<div class="rowRight">
									<input type="radio" name="one.mode" value="1" id="ra1" checked="checked"/>
										<label>
											1，匹配
											<input type="text" <c:if test="${empty adminLogined}">maxLength="1"</c:if> size="1"
											onkeypress="if(event.keyCode<48||event.keyCode>57) return false;"
											style="ime-mode: disabled;"
											name="one.seekNumber"
											value="1"/>
											次后结束；
										</label>
										<br />
									<input type="radio" name="one.mode" value="2" id="ra2"/>
										<label>
											2，到达
											<select name="one.expireDate">
												<c:forEach items="${days}" var="one" varStatus="i">
													<option value="${one}" <c:if test="${i.count == 15}">selected="selected"</c:if>>${one}</option>
												</c:forEach>
											</select>
											时结束；
										</label>
										<br />
									<input type="radio" name="one.mode" value="3" id="ra3"/>
										<label>
											3，综合模式，以上两项任意一项达到条件则结束。
										</label>
								</div>
							</div>
							<hr />
							<c:if test="${!empty adminLogined}">
								<div class="oneRow clear">
									<div class="rowLeft">
										<span class="emphasized">
											特殊选项
										</span>
										<br />
										<span class="tips">
											（管理员可见）
										</span>
									</div>
									<div class="rowRight">
										<span class="warn">以下两个选项用于发起会员活动时，平时请慎用！</span>
										<br />
										<input type="checkbox" name="one.toTop" value="1" id="toTop"/>
										<label for="toTop">
											在列表中显示时置顶
										</label>
										<br />
										<input type="checkbox" name="one.detailed" value="1" id="detailed"/>
										<label for="detailed">
											在列表中显示时不省略篇幅
										</label>
									</div>
								</div>
								<hr/>
							</c:if>
							<div class="oneRow clear">
								<div class="rowLeft">
								</div>
								<div class="rowRight">
									<input type="submit" value="嗯，填写完整了，发布吧！" class="button"/><br/>
									<span class="tips">(点击此按钮之后需要帮助的人将可以看到您此条帮助信息。)</span>
								</div>
							</div>
						</fieldset>					
					</form>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/deposit.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/view/common/header.jsp"%>
<%@ include file="/view/common/part/user/nav.jsp"%>

<div class="row">
	<div class="span8">
		<%@ include file="/view/user/login/photo_slide.jsp"%>
		<div class="row">
			<span class="span3">
				<h2>我们是……</h2>
				<p>我们是<strong>华南农业大学时间银行</strong>。
					时间银行是由启林南社区服务站成立的爱心互助项目，
					旨在为我校本科生提供一个爱心交换的互助平台。
				</p>
				<p><a href="#" class="btn">了解更多 »</a></p>
			</span>
			<span class="span3">
				<h2>为什么？</h2>
				<p>为什么会有这样一个项目？此项目可以帮助大学生促进自我价值的实现，
				营造一种积极向上、温馨和谐、互助友爱的校园社区氛围。
				总而言之一句话，它可以帮到你！</p>
				<p><a href="#" class="btn">了解更多 »</a></p>
			</span>
			<span class="span2">
				<h2>怎么开始？</h2>
				<p>你问我怎么开始？还能怎样，就跟你平时上微博、人人、开心网等社交网站一样，
				没账号的注册个账号，有账号的登录个账号，进去一看，你很快就可以熟悉的！
				<i class="icon-music" id="funny-tip" title="开发人员说不行的话他请吃宵夜！"></i></p>
				<p><a href="#" class="btn">了解更多 »</a></p>
			</span>
		</div>
	</div>
	<div class="span4">
		<%@ include file="/view/user/login/login.jsp"%>
	</div>
</div>

<script src="${statics}/script/module/index.js" type="text/javascript"></script>
<%@ include file="/view/common/footer.jsp"%>
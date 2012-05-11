<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>技能储备 - 个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
				<h2 class="title"><a href="#">技能储备</a><span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span></h2>
				<jsp:include page="${path}/view/common/part/user/tips/tipSkill.jsp"/>
				<div class="entry">
					<form action="Skill_update" method="post">
						<fieldset>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">基础课程</div>
								<input type="hidden" name="range1.class1" value="基础课程"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L1-1" type="checkbox" name="range1.class2" value="高等数学"/>
											<label for="L1-1">高等数学</label>
										</span>
										<span class="radio">
											<input id="L1-11" type="checkbox" name="range1.class2" value="大学数学"/>
											<label for="L1-11">大学数学</label>
										</span>
										<span class="radio">
											<input id="L1-12" type="checkbox" name="range1.class2" value="大学物理"/>
											<label for="L1-12">大学物理</label>
										</span>
										<span  class="radio">
											<input id="L1-2" type="checkbox" name="range1.class2" value="计算机基础"/>
											<label for="L1-2">计算机基础</label>
										</span>
										<span  class="radio">
											<input id="L1-3" type="checkbox" name="range1.class2" value="数据库"/>
											<label for="L1-3">数据库</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">专业课程</div>
								<input type="hidden" name="range2.class1" value="专业课程"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L2-1" type="checkbox" name="range2.class2" value="学院专业课"/>
											<label for="L2-1">学院专业课</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">语言交流</div>
								<input type="hidden" name="range3.class1" value="语言交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L3-1" type="checkbox" name="range3.class2" value="英语"/>
											<label for="L3-1">英语</label>
										</span>
										<span  class="radio">
											<input id="L3-2" type="checkbox" name="range3.class2" value="日语"/>
											<label for="L3-2">日语</label>
										</span>
										<span  class="radio">
											<input id="L3-21" type="checkbox" name="range3.class2" value="韩语"/>
											<label for="L3-21">韩语</label>
										</span>
										<span  class="radio">
											<input id="L3-22" type="checkbox" name="range3.class2" value="西班牙语"/>
											<label for="L3-22">西班牙语</label>
										</span>
										<span  class="radio">
											<input id="L3-23" type="checkbox" name="range3.class2" value="德语"/>
											<label for="L3-23">德语</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L3-3" type="checkbox" name="range3.class2" value="普通话"/>
											<label for="L3-3">普通话</label>
										</span>
										<span  class="radio">
											<input id="L3-4" type="checkbox" name="range3.class2" value="粤语"/>
											<label for="L3-4">粤语</label>
										</span>
										<span  class="radio">
											<input id="L3-5" type="checkbox" name="range3.class2" value="潮汕话"/>
											<label for="L3-5">潮汕话</label>
										</span>
										<span  class="radio">
											<input id="L3-6" type="checkbox" name="range3.class2" value="客家话"/>
											<label for="L3-6">客家话</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">乐器交流</div>
								<input type="hidden" name="range4.class1" value="乐器交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L4-1" type="checkbox" name="range4.class2" value="吉它"/>
											<label for="L4-1">吉它</label>
										</span>
										<span  class="radio">
											<input id="L4-2" type="checkbox" name="range4.class2" value="二胡"/>
											<label for="L4-2">二胡</label>
										</span>
										<span  class="radio">
											<input id="L4-3" type="checkbox" name="range4.class2" value="钢琴"/>
											<label for="L4-3">钢琴</label>
										</span>
										<span  class="radio">
											<input id="L4-4" type="checkbox" name="range4.class2" value="口琴"/>
											<label for="L4-4">口琴</label>
										</span>
										<span  class="radio">
											<input id="L4-5" type="checkbox" name="range4.class2" value="小提琴"/>
											<label for="L4-5">小提琴</label>
										</span>
										<br /><br />
										<span  class="radio">
											<input id="L4-51" type="checkbox" name="range4.class2" value="葫芦丝"/>
											<label for="L4-51">葫芦丝</label>
										</span>
										<span  class="radio">
											<input id="L4-52" type="checkbox" name="range4.class2" value="手风琴"/>
											<label for="L4-52">手风琴</label>
										</span>
										<span  class="radio">
											<input id="L4-53" type="checkbox" name="range4.class2" value="古筝"/>
											<label for="L4-53">古筝</label>
										</span>
										<span  class="radio">
											<input id="L4-54" type="checkbox" name="range4.class2" value="萨克斯风"/>
											<label for="L4-54">萨克斯风</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">兴趣交流</div>
								<input type="hidden" name="range5.class1" value="兴趣交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L5-1" type="checkbox" name="range5.class2" value="手语"/>
											<label for="L5-1">手语</label>
										</span>
										<span  class="radio">
											<input id="L5-2" type="checkbox" name="range5.class2" value="舞蹈"/>
											<label for="L5-2">舞蹈</label>
										</span>
										<span  class="radio">
											<input id="L5-21" type="checkbox" name="range5.class2" value="音乐"/>
											<label for="L5-21">音乐</label>
										</span>
										<span  class="radio">
											<input id="L5-22" type="checkbox" name="range5.class2" value="唱歌"/>
											<label for="L5-22">唱歌</label>
										</span>
										<span  class="radio">
											<input id="L5-3" type="checkbox" name="range5.class2" value="武术"/>
											<label for="L5-3">武术</label>
										</span>
										<span  class="radio">
											<input id="L5-4" type="checkbox" name="range5.class2" value="书法"/>
											<label for="L5-4">书法</label>
										</span>
										<span  class="radio">
											<input id="L5-5" type="checkbox" name="range5.class2" value="烹饪"/>
											<label for="L5-5">烹饪</label>
										</span>	
										<span  class="radio">
											<input id="L5-6" type="checkbox" name="range5.class2" value="手工"/>
											<label for="L5-6">手工</label>
										</span>		
										<br /><br />	
										<span  class="radio">
											<input id="L5-7" type="checkbox" name="range5.class2" value="旅游"/>
											<label for="L5-7">旅游</label>
										</span>		
										<span  class="radio">
											<input id="L5-8" type="checkbox" name="range5.class2" value="茶艺"/>
											<label for="L5-8">茶艺</label>
										</span>	
										<span  class="radio">
											<input id="L5-9" type="checkbox" name="range5.class2" value="盘发"/>
											<label for="L5-9">盘发</label>
										</span>		
										<span class="radio">
											<input id="L5-91" type="checkbox" name="range5.class2" value="压花"/>
											<label for="L5-91">压花</label>
										</span>		
										<span class="radio">
											<input id="L5-9-1" type="checkbox" name="range5.class2" value="播音主持"/>
											<label for="L5-9-1">播音主持</label>
										</span>		
										<span class="radio">
											<input id="L5-9-2" type="checkbox" name="range5.class2" value="摄影录像"/>
											<label for="L5-9-2">摄影录像</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">编织交流</div>
								<input type="hidden" name="range6.class1" value="编织交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L6-1" type="checkbox" name="range6.class2" value="编织围巾"/>
											<label for="L6-1">编织围巾</label>
										</span>
										<span  class="radio">
											<input id="L6-2" type="checkbox" name="range6.class2" value="编织毛衣"/>
											<label for="L6-2">编织毛衣</label>
										</span>
										<span  class="radio">
											<input id="L6-3" type="checkbox" name="range6.class2" value="十字绣"/>
											<label for="L6-3">十字绣</label>
										</span>
										<span  class="radio">
											<input id="L6-4" type="checkbox" name="range6.class2" value="中国结"/>
											<label for="L6-4">中国结</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">书刊借阅</div>
								<input type="hidden" name="range7.class1" value="书刊借阅"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L7-1" type="checkbox" name="range7.class2" value="专业书籍"/>
											<label for="L7-1">专业书籍</label>
										</span>
										<span  class="radio">
											<input id="L7-2" type="checkbox" name="range7.class2" value="大众书籍"/>
											<label for="L7-2">大众书籍</label>
										</span>
										<span  class="radio">
											<input id="L7-3" type="checkbox" name="range7.class2" value="杂志"/>
											<label for="L7-3">杂志</label>
										</span>
										<span  class="radio">
											<input id="L7-4" type="checkbox" name="range7.class2" value="报纸"/>
											<label for="L7-4">报纸</label>
										</span>
										<span  class="radio">
											<input id="L7-5" type="checkbox" name="range7.class2" value="光盘"/>
											<label for="L7-5">光盘</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">体育运动</div>
								<input type="hidden" name="range8.class1" value="体育运动"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L8-1" type="checkbox" name="range8.class2" value="晨跑"/>
											<label for="L8-1">晨跑</label>
										</span>
										<span  class="radio">
											<input id="L8-2" type="checkbox" name="range8.class2" value="晨练"/>
											<label for="L8-2">晨练</label>
										</span>
										<span  class="radio">
											<input id="L8-3" type="checkbox" name="range8.class2" value="跑步"/>
											<label for="L8-3">跑步</label>
										</span>
										<span class="radio">
											<input id="L8-4" type="checkbox" name="range8.class2" value="篮球"/>
											<label for="L8-4">篮球</label>
										</span>
										<span  class="radio">
											<input id="L8-5" type="checkbox" name="range8.class2" value="足球"/>
											<label for="L8-5">足球</label>
										</span>
										<span  class="radio">
											<input id="L8-6" type="checkbox" name="range8.class2" value="羽毛球"/>
											<label for="L8-6">羽毛球</label>
										</span>
										<span class="radio">
											<input id="L8-7" type="checkbox" name="range8.class2" value="排球"/>
											<label for="L8-7">排球</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L8-8" type="checkbox" name="range8.class2" value="毽球"/>
											<label for="L8-8">毽球</label>
										</span>
										<span  class="radio">
											<input id="L8-9" type="checkbox" name="range8.class2" value="乒乓球"/>
											<label for="L8-9">乒乓球</label>
										</span>
										<span class="radio">
											<input id="L8-10" type="checkbox" name="range8.class2" value="网球"/>
											<label for="L8-10">网球</label>
										</span>
										<span  class="radio">
											<input id="L8-11" type="checkbox" name="range8.class2" value="轮滑"/>
											<label for="L8-11">轮滑</label>
										</span>
										<span  class="radio">
											<input id="L8-12" type="checkbox" name="range8.class2" value="爬山"/>
											<label for="L8-12">爬山</label>
										</span>
										<span class="radio">
											<input id="L8-13" type="checkbox" name="range8.class2" value="游泳"/>
											<label for="L8-13">游泳</label>
										</span>
										<span class="radio">
											<input id="L8-1-1" type="checkbox" name="range8.class2" value="瑜伽"/>
											<label for="L8-1-1">瑜伽</label>
										</span>
										<br /><br />
										<span class="radio">
											<input id="L8-1-2" type="checkbox" name="range8.class2" value="太极扇"/>
											<label for="L8-1-2">太极扇</label>
										</span>
										<span class="radio">
											<input id="L8-1-3" type="checkbox" name="range8.class2" value="普拉提"/>
											<label for="L8-1-3">普拉提</label>
										</span>
										<span class="radio">
											<input id="L8-1-31" type="checkbox" name="range8.class2" value="按摩"/>
											<label for="L8-1-31">按摩</label>
										</span>
										<span class="radio">
											<input id="L8-1-4" type="checkbox" name="range8.class2" value="跆拳道"/>
											<label for="L8-1-4">跆拳道</label>
										</span>
										<span class="radio">
											<input id="L8-1-5" type="checkbox" name="range8.class2" value="台球"/>
											<label for="L8-1-5">台球</label>
										</span>
										<span class="radio">
											<input id="L8-1-6" type="checkbox" name="range8.class2" value="滑板"/>
											<label for="L8-1-6">滑板</label>
										</span>
										<span class="radio">
											<input id="L8-1-7" type="checkbox" name="range8.class2" value="橄榄球"/>
											<label for="L8-1-7">橄榄球</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">绘画交流</div>
								<input type="hidden" name="range9.class1" value="绘画交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L9-1" type="checkbox" name="range9.class2" value="卡通绘画"/>
											<label for="L9-1">卡通绘画</label>
										</span>
										<span  class="radio">
											<input id="L9-2" type="checkbox" name="range9.class2" value="平面制图"/>
											<label for="L9-2">平面制图</label>
										</span>
										<span  class="radio">
											<input id="L9-3" type="checkbox" name="range9.class2" value="素描手绘"/>
											<label for="L9-3">素描手绘</label>
										</span>
										<span  class="radio">
											<input id="L9-4" type="checkbox" name="range9.class2" value="水彩水粉"/>
											<label for="L9-4">水彩水粉</label>
										</span>
										<span  class="radio">
											<input id="L9-5" type="checkbox" name="range9.class2" value="标识设计"/>
											<label for="L9-5">标识设计</label>
										</span>
										<span  class="radio">
											<input id="L9-5" type="checkbox" name="range9.class2" value="油画"/>
											<label for="L9-5">油画</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">写作交流</div>
								<input type="hidden" name="range10.class1" value="写作交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L10-1" type="checkbox" name="range10.class2" value="新闻稿"/>
											<label for="L10-1">新闻稿</label>
										</span>
										<span class="radio">
											<input id="L10-11" type="checkbox" name="range10.class2" value="策划书"/>
											<label for="L10-11">策划书</label>
										</span>
										<span class="radio">
											<input id="L10-12" type="checkbox" name="range10.class2" value="公文"/>
											<label for="L10-12">公文</label>
										</span>
										<span class="radio">
											<input id="L10-13" type="checkbox" name="range10.class2" value="论文"/>
											<label for="L10-13">论文</label>
										</span>
										<br /><br />
										<span  class="radio">
											<input id="L10-2" type="checkbox" name="range10.class2" value="小说"/>
											<label for="L10-2">小说</label>
										</span>
										<span  class="radio">
											<input id="L10-3" type="checkbox" name="range10.class2" value="散文"/>
											<label for="L10-3">散文</label>
										</span>
										<span  class="radio">
											<input id="L10-4" type="checkbox" name="range10.class2" value="诗歌"/>
											<label for="L10-4">诗歌</label>
										</span>
										<span  class="radio">
											<input id="L10-5" type="checkbox" name="range10.class2" value="剧本"/>
											<label for="L10-5">剧本</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">软件技能</div>
								<input type="hidden" name="range11.class1" value="软件技能"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L11-1" type="checkbox" name="range11.class2" value="网页设计"/>
											<label for="L11-1">网页设计</label>
										</span>
										<span class="radio">
											<input id="L11-1" type="checkbox" name="range11.class2" value="视频制作"/>
											<label for="L11-1">视频制作</label>
										</span>
										<span class="radio">
											<input id="L11-1" type="checkbox" name="range11.class2" value="编程设计"/>
											<label for="L11-1">编程设计</label>
										</span>
										<span class="radio">
											<input id="L11-1" type="checkbox" name="range11.class2" value="会声会影"/>
											<label for="L11-1">会声会影</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L11-2" type="checkbox" name="range11.class2" value="Photoshop"/>
											<label for="L11-2">Photoshop</label>
										</span>
										<span  class="radio">
											<input id="L11-3" type="checkbox" name="range11.class2" value="CoreldRAW"/>
											<label for="L11-3">CoreldRAW</label>
										</span>
										<span  class="radio">
											<input id="L11-4" type="checkbox" name="range11.class2" value="Flash"/>
											<label for="L11-4">Flash</label>
										</span>
										<span  class="radio">
											<input id="L11-5" type="checkbox" name="range11.class2" value="CAD"/>
											<label for="L11-5">CAD</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L11-51" type="checkbox" name="range11.class2" value="PPT"/>
											<label for="L11-51">PPT</label>
										</span>
										<span  class="radio">
											<input id="L11-6" type="checkbox" name="range11.class2" value="Word"/>
											<label for="L11-6">Word</label>
										</span>
										<span  class="radio">
											<input id="L11-7" type="checkbox" name="range11.class2" value="Excel"/>
											<label for="L11-7">Excel</label>
										</span>
										<span  class="radio">
											<input id="L11-71" type="checkbox" name="range11.class2" value="Access"/>
											<label for="L11-71">Access</label>
										</span>
										<span  class="radio">
											<input id="L11-72" type="checkbox" name="range11.class2" value="Eviews"/>
											<label for="L11-72">Eviews</label>
										</span>
										<span  class="radio">
											<input id="L11-73" type="checkbox" name="range11.class2" value="Java"/>
											<label for="L11-73">Java</label>
										</span>
										<span  class="radio">
											<input id="L11-74" type="checkbox" name="range11.class2" value="C/C++"/>
											<label for="L11-74">C/C++</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">经验交流</div>
								<input type="hidden" name="range12.class1" value="经验交流"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L12-1" type="checkbox" name="range12.class2" value="专业解惑"/>
											<label for="L12-1">专业解惑</label>
										</span>
										<span  class="radio">
											<input id="L12-2" type="checkbox" name="range12.class2" value="就业解惑"/>
											<label for="L12-2">就业解惑</label>
										</span>
										<span  class="radio">
											<input id="L12-3" type="checkbox" name="range12.class2" value="人际解惑"/>
											<label for="L12-3">人际解惑</label>
										</span>
										<span  class="radio">
											<input id="L12-4" type="checkbox" name="range12.class2" value="心灵解惑"/>
											<label for="L12-4">心灵解惑</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L12-5" type="checkbox" name="range12.class2" value="减肥护肤"/>
											<label for="L12-5">减肥护肤</label>
										</span>
										<span  class="radio">
											<input id="L12-6" type="checkbox" name="range12.class2" value="化妆衣着"/>
											<label for="L12-6">化妆衣着</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">互助陪伴</div>
								<input type="hidden" name="range13.class1" value="互助陪伴"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L13-1" type="checkbox" name="range13.class2" value="陪练口语"/>
											<label for="L13-1">陪练口语</label>
										</span>
										<span  class="radio">
											<input id="L13-2" type="checkbox" name="range13.class2" value="陪同晨读"/>
											<label for="L13-2">陪同晨读</label>
										</span>
										<span  class="radio">
											<input id="L13-3" type="checkbox" name="range13.class2" value="陪同自习"/>
											<label for="L13-3">陪同自习</label>
										</span>
										<span  class="radio">
											<input id="L13-4" type="checkbox" name="range13.class2" value="陪同逛街"/>
											<label for="L13-4">陪同逛街</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L13-41" type="checkbox" name="range13.class2" value="陪同夜归"/>
											<label for="L13-41">陪同夜归</label>
										</span>
										<span  class="radio">
											<input id="L13-42" type="checkbox" name="range13.class2" value="学习帮扶"/>
											<label for="L13-42">学习帮扶</label>
										</span>
										<span  class="radio">
											<input id="L13-43" type="checkbox" name="range13.class2" value="结伴回家"/>
											<label for="L13-43">结伴回家</label>
										</span>
										<span  class="radio">
											<input id="L13-5" type="checkbox" name="range13.class2" value="朋辈倾诉"/>
											<label for="L13-5">朋辈倾诉</label>
										</span>
									</span>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">劳动帮忙</div>
								<input type="hidden" name="range14.class1" value="劳动帮忙"/>
								<div class="rowRight">
									<span class="emphasized">
										<span class="radio">
											<input id="L14-1" type="checkbox" name="range14.class2" value="帮忙借/还书"/>
											<label for="L14-1">帮忙借/还书</label>
										</span>
										<span  class="radio">
											<input id="L14-2" type="checkbox" name="range14.class2" value="帮忙搬运"/>
											<label for="L14-2">帮忙搬运</label>
										</span>
										<span  class="radio">
											<input id="L14-3" type="checkbox" name="range14.class2" value="修理电脑"/>
											<label for="L14-3">修理电脑</label>
										</span>
										<span  class="radio">
											<input id="L14-4" type="checkbox" name="range14.class2" value="修理手机"/>
											<label for="L14-4">修理手机</label>
										</span>
										<br />
										<br />
										<span  class="radio">
											<input id="L14-5" type="checkbox" name="range14.class2" value="修理耳机"/>
											<label for="L14-5">修理耳机</label>
										</span>
										<span  class="radio">
											<input id="L14-6" type="checkbox" name="range14.class2" value="电器维修"/>
											<label for="L14-6">电器维修</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">其它</div>
								<input type="hidden" name="range15.class1" value="其它"/>
								<div class="rowRight">
									<span class="emphasized">
										<span  class="radio">
											<input id="L15-1" type="checkbox" name="range15.class2" value="爱心领养"/>
											<label for="L15-1">爱心领养</label>
										</span>
										<span  class="radio">
											<input id="L15-2" type="checkbox" name="range15.class2" value="食物分享"/>
											<label for="L15-2">食物分享</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft">
								</div>
								<div class="rowRight">
									<input type="submit" value="嗯，填写完整了，更新吧！" class="button"/><br/>
									<span class="tips">
										<a href="/TimeBank/Feedback_view">
											(还有我们没有包括的项目？点击反馈跟我们建议，我们会及时响应您的建议的！)
										</a>
									</span>
								</div>
							</div>
						</fieldset>					
					</form>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/homepage.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!--设定上下文路径和全路径-->
<%
	request.setAttribute("path", request.getContextPath());

	request.setAttribute("statics", request.getContextPath()
			+ "/statics");
	
	/*point to the css theme*/
	request.setAttribute("css", request.getContextPath()
			+ "/statics/theme/default");
	
	/*point to the views*/
	request.setAttribute("view", request.getContextPath() + "/view");
	
	request.setAttribute("serverPath", request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath());
	response.setHeader("P3P", "CP=CAO PSA OUR");
%>


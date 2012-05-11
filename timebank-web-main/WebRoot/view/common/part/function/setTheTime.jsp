<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="one.theTime">
	<option value="1" <c:if test="${withdrawRecord.theTime == 1}">selected="selected"</c:if>>第01、02节[大约08:00-09:35]</option>
	<option value="2" <c:if test="${withdrawRecord.theTime == 2}">selected="selected"</c:if>>第03、04节[大约10:05-11:40]</option>
	<option value="3" <c:if test="${withdrawRecord.theTime == 3}">selected="selected"</c:if>>整个上午</option>
	<option value="4" <c:if test="${withdrawRecord.theTime == 4}">selected="selected"</c:if>>第05、06节[大约12:30-14:05]</option>
	<option value="5" <c:if test="${withdrawRecord.theTime == 5}">selected="selected"</c:if>>第07、08节[大约14:30-16:05]</option>
	<option value="6" <c:if test="${withdrawRecord.theTime == 6}">selected="selected"</c:if>>第09、10节[大约16:35-18:10]</option>
	<option value="7" <c:if test="${withdrawRecord.theTime == 7}">selected="selected"</c:if>>整个下午</option>
	<option value="8" <c:if test="${withdrawRecord.theTime == 8}">selected="selected"</c:if>>第11、12节[大约19:30-21:05]</option>
	<option value="9" <c:if test="${withdrawRecord.theTime == 9}">selected="selected"</c:if>>整个白天</option>
	<option value="10" <c:if test="${withdrawRecord.theTime == 10}">selected="selected"</c:if>>整个晚上</option>
	<option value="11" <c:if test="${withdrawRecord.theTime == 11}">selected="selected"</c:if>>一整天</option>
	<option value="12" <c:if test="${withdrawRecord.theTime == 12}">selected="selected"</c:if>>其它[在详细说明中描述]</option>
</select>
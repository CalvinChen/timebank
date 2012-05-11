<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty day1[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day1[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day1}" var="one">
					<span class="radio">
						${one.idleHour}
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
<c:if test="${!empty day2[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day2[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day2}" var="one">
					<span class="radio">
						${one.idleHour}
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
<c:if test="${!empty day3[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day3[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day3}" var="one">
					<span class="radio">
						${one.idleHour}
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
<c:if test="${!empty day4[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day4[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day4}" var="one">
					<span class="radio">
						${one.idleHour}
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
<c:if test="${!empty day5[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day5[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day5}" var="one">
					<span class="radio">
						${one.idleHour}
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
<c:if test="${!empty day6[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day6[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day6}" var="one">
					<span class="radio">
						${one.idleHour}
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
<c:if test="${!empty day7[1]}">
	<div class="oneRow clear">
		<div class="rowLeft emphasized">${day7[0].idleDay}</div>
		<div class="rowRight">
			<p class="emphasized">
				<c:forEach begin="1" items="${day7}" var="one">
					<span class="radio">
						${one.idleHour}
						
							
						
					</span>
				</c:forEach>
			</p>
			<hr/>
		</div>
	</div>
</c:if>
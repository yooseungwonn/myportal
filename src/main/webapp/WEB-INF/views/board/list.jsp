<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/board.css" />' />
</head>
<body>
<div id="container">

		<!-- header include -->
		<c:import url="/WEB-INF/views/includes/header.jsp">
			<c:param name="param1" value="value1" />
			<c:param name="param2" value="value2" />
		</c:import>

		<!-- navigation include -->
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />

		<div id="wrapper">
			<div id="content">

				<!-- Content -->
	<table border="1" width="480">
		<tr>
			<td colspan="6"><h3>게시판</h3></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>&nbsp;</th>
		</tr>
		
		<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.no }</td>
			<td><a href="<c:url value="/board/${vo.no }" />">${vo.title }</a></td>
			<td>${vo.userName }</td>
			<td>${vo.hit }</td>
			<td>${vo.regDate }</td>
			<td>
			<c:if test="${not empty authUser }">
				<c:if test="${authUser.no == vo.userNo }">			
			<a href ="<c:url value="/board/${vo.no }/modify"/>">수정</a>
			<a href ="<c:url value="/board/${vo.no }/delete"/>">삭제</a>
			</c:if>
			</c:if>
			</td>
		</tr>
		</c:forEach>
	
		<tr>
			<td colspan="6"><a href="<c:url value="/board/write"/> ">글쓰기</a></td>
		</tr>
	</table>
	</div>
	</div>
	<!-- footer include -->
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>

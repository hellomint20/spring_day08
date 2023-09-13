<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th> <th>이름</th> <th>파일명</th> <th>다운로드</th>
		</tr>
		<c:forEach var="f" items="${ list }">
			<tr>
				<td>${ f.id }</td> <td>${ f.name }</td> <td>${ f.imgName }</td>
				<td>
				<img src="download?file=${ f.imgName }" width="100" height="100"><br>
				<a href="download?file=${ f.imgName }">${ f.imgName }</a><br>
				<a href="delete?file=${ f.imgName }&id=${ f.id }">삭제</a> &nbsp;/&nbsp;
				<a href="modify?id=${ f.id }">수정</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="form">업로드 이동</a>
</body>
</html>
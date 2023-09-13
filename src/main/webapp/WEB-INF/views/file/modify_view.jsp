<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify" method="post" enctype="multipart/form-data">
		<input type="text" name="id" value="${ file.id }" readonly><br>
		<input type="text" name="name" value="${ file.name }" ><br>
		<img src="download?file=${ file.imgName }" width="100" height="100"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="수정">
	</form>
	<a href="form">업로드 이동</a>
</body>
</html>
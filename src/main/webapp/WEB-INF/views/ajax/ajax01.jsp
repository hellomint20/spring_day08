<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script> <!-- $문법 사용을 위해 -->
	<script type="text/javascript">
		function test(){
			$.ajax({ 
				url : "ajax01",
				type : "get",
				success : function(){ //성공적으로 통신되면 함수 실행됨
					$("#txt").html("성공");
				},
				error : () => {
					document.getElementById("txt").innerHTML="실패";
				}
			}); //fetch("ajax01");
		}
	</script>
</head>
<body>
	ajax01 page <br><br>
	
	<h1>111</h1> <h1>111</h1> <h1>111</h1>
	<h1>111</h1> <h1>111</h1> <h1>111</h1>
	<h1>111</h1> <h1>111</h1> <h1>111</h1>
	<button type="button" onclick="test()">클릭</button>
	<hr>
	<b id="txt"></b>
</body>
</html>
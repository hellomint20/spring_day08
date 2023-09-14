<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script> 
	<script type="text/javascript">
		function test(){
			let n = document.getElementById("name").value;
			let a = $("#age") .val();
			let form = { name : n, age : a}; //dto에 작성된 변수랑 key 이름이랑 같으면 값이 자동 주입됨
			$.ajax({
				url : "result03", type : "POST", //대소문자 구별 없음
				data : JSON.stringify( form ),//object type → String type으로 변경 / 서버로 전송할 데이터
				contentType : "application/json; charset=utf-8", //서버로 보낼 데이터 유형
				dataType : "json", //서버로 받을 리턴 타입 지정
				success : function( data ){
					console.log( "이름 : "+data.name )
					console.log( "나이 : "+data.age )
				}
			});
		}
	</script>
</head>
<body>
	name : <input type="text" id="name"><br>
	age : <input type="text" id="age"><br>
	<input type="button" onclick="test()" value="전송"><br>
</body>
</html>
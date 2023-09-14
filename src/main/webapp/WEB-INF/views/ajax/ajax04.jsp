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
			
			let frm = {}
			let arr = $("#frm").serializeArray(); //name 값을 갖고 옴
			console.log(arr)
			for( var i=0; i<arr.length; i++)
				frm[arr[i].name] = arr[i].value;
			console.log(frm);
			
			$.ajax({
				url : "result04", type : "POST", 
				data : JSON.stringify( frm ),
				contentType : "application/json; charset=utf-8",
				dataType : "json", 
				success : function( data ){
					console.log( "이름 : "+data.name )
					console.log( "나이 : "+data.age )
					console.log( "nick : "+data.nick )
				}
			});
		}
	</script>
</head>
<body>
	<form id="frm">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="text" name="pwd"><br>
		<input type="text" name="age"><br>
		<input type="text" name="addr"><br>
		<input type="button" onclick="test()" value="클릭"><br>
	</form>
</body>
</html>
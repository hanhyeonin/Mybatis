<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc2</title>
<style type="text/css">
main {
	padding-top : 100px;
	margin : auto;
	overflow: hidden;
}
div {
	width: 200px;
	height: 200px;
	border: 1px solid #689;
	padding: 50px;
	margin: 20px auto;
}
input[type=text],input[type=password]{
	border-radius: 4px; border: 2px solid #ccc;
	padding : 15px;
	margin-bottom: 25px
}
input[type=submit], input[type=button] {
	padding: 15px;
	margin: 15px 10px;
	background: #c69;
	color: white;
	border: none;
	cursor: pointer;
	width:35%;
}
div#fail {
	padding: 10px 50px;
	width: 200px;
    height: auto;
    background-color: rgba(233,0,0,0.3);
    margin: 10px auto;
    font-size: 0.7em;
    color: red;
    border-radius: 4px; border: 1px solid red;
}
</style>
</head>
<body>
<main>
<div id="fail"><span>계정 정보가 일치하지 않습니다.</span></div>
<div id="form">
	<form action="login.hrd" method="post">
		<input type="text" name="id" placeholder="아이디(이메일) 입력하세요.">
		<input type="password" name="password" placeholder="비밀번호 입력하세요.">
		<input type="submit" value="LOGIN">
		<input type="button" value="HOME" onclick = "location.href='./'">
	</form>
</div>
</main>
<script type="text/javascript">
	const div_fail = document.getElementById("fail")
	const div_form = document.getElementById("form")
	if('${fail}'==='y') {
		div_fail.style.display='block'
	}
	else {
		div_fail.style.display='none'
	}	
	
	
	
</script>

</body>
</html>
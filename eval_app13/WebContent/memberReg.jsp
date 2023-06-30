<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form name="frm" action="check" method="post">
	<input type="text" name="name" placeholder = "input name..."><br>
	<input type="text" name="id" placeholder = "input id...">
	<button class="check_id" data-init="0">id 중복확인</button><br>
	<input type="password" name="pw" placeholder = "input pw..."><br>
	<input type="password" name="check_pw" placeholder = "input pw..."><br>
	<input type="text" name="tel" placeholder = "input tel...">
	<button class="check_tel" data-init="0" data-init="0">tel 중복확인</button><br>
	<input type="text" name="addr" placeholder = "input addr..."><br>
	<button type="submit" class ="submit_btn">전송</button><br>
</form>

<script type="text/javascript">
	var id = document.querySelector("input[name='id']");
	var pw = document.querySelector("input[name='pw']");
	var tel = document.querySelector("input[name='tel']");
	
	var check_pw = document.querySelector("input[name='check_pw']");
	var check_id = document.querySelector(".check_id");
	var check_tel = document.querySelector(".check_tel");
	var submit_btn = document.querySelector(".submit_btn");
	
	
	var result_id = "";
	var result_tel = "";
	
	check_id.addEventListener("click",checkId);
	check_tel.addEventListener("click",checkTel);
	check_pw.addEventListener("blur",checkPw);
	submit_btn.addEventListener("click",checkInput);
	
	function checkId(e){
		e.preventDefault();
		check_id.dataset.init = 1;
		if(id.value.length == 0){
			alert("아이디를 입력해주세요.");
			id.focus();
			return;
		}
		
		var x = new XMLHttpRequest();
		x.onload = function(){
			result_id = this.responseText;
			if(result_id =="1"){
				alert("중복된 아이디입니다. 다른 아이디를 입력해주세요.");
			}else if(result_id == "0"){
				alert("사용가능한 아이디입니다.");
			}
		}
		x.open("POST","check",true);
		x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		x.send("id="+id.value);
	}
	
	function checkTel(e){
		e.preventDefault();
		check_tel.dataset.init = 1;
		if(id.value.length == 0){
			alert("전화번호를 입력해주세요.");
			id.focus();
			return;
		}
		
		var x = new XMLHttpRequest();
		x.onload = function(){
			result_tel = this.responseText;
			if(result_tel =="1"){
				alert("중복된 전화번호입니다. 사용하지 않은 전화번호를 입력하세요.");
			}else if(result_tel == "0"){
				alert("사용가능한 전화번호입니다.");
			}
		}
		x.open("POST","check",true);
		x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		x.send("tel="+tel.value);
	}
	
	function checkPw(){
		if(pw.value.length == 0){
			alert("비밀번호를 입력해주세요.");
			pw.focus();
			return;
		}
		else if(pw.value != check_pw.value){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
	}
	
	function checkInput(e){
		e.preventDefault();
		
		if(frm.name.value.length == 0){
			alert("이름을 입력해주세요.");
			frm.name.focus();
			return;
		}
		if(frm.id.value.length == 0){
			alert("아아디를 입력해주세요.");
			id.focus();
			return;
		}
		if(frm.pw.value.length == 0){
			alert("비밀번호를 입력해주세요.");
			pw.focus();
			return;
		}
		if(frm.tel.value.length == 0){
			alert("전화번호를 입력해주세요.");
			tel.focus();
			return;
		}
		if(frm.addr.value.length == 0){
			alert("주소를 입력해주세요.");
			addr.focus();
			return;
		}
		if(pw.value != check_pw.value){
			alert("비밀번호를 다시 입력해주세요.");
			return;
		}
		
		if(result_id == 1||check_id.getAttribute("data-init")== 0){
			alert("아이디 중복확인을 해주세요.");
			return;
		}
		if(result_tel == 1||check_tel.getAttribute("data-init")== 0){
			alert("전화번호 중복확인을 해주세요.");
			return;
		}
		frm.submit();
	}
	

</script>
</body>
</html>
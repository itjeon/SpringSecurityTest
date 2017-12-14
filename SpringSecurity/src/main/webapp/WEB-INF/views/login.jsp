<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
    
    <script type="text/javascript"> 
        function doLogin() {
            if(loginFrm.username.value == "") {
                alert("아이디를 입력해주세요.");
                return;
            }
            if(loginFrm.password.value == "") {
                alert("패스워드를 입력해주세요.");
                return;
            }
            
            loginFrm.submit();
        }
        
    </script>
</head>

<body>
<h1>
    Login  
</h1>
<form name="loginFrm" method="post" action="login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    id : <input type="text" name="username" /><br/>
    password : <input type="password" name="password" /><br/>
    <button type="button" onclick="doLogin()">로그인</button>
</form>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>

</body>
</html>

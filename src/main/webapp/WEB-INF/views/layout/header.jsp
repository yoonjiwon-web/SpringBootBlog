<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 스프링 시큐리티 로그인 인증. allow direct access > Object에 (스프링 시큐리티에서 정해진 규칙) 
	PrinciapDetail.java 가 여기서 principal 변수에 담긴다.
-->
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Jiwon 블로그</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- saveform.jsp에서 글쓰기 할때 bootstrap 사용하기 위함. -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>



</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">Jiwon</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">

			<c:choose>
				<c:when test="${empty principal}"> <!-- 스프링 시큐리티에서 authorize 가 안왔으면 -->
					<ul class="navbar-nav">
						<!-- 스프링 전통방식 로그인  
						<li class="nav-item"><a class="nav-link" href="/user/loginForm">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/joinForm">회원가입</a></li>-->
						<!-- 스프링 시큐리티 방식 로그인. 인증없이 들어가야되니깐 앞에 /auth/ 경로 붙이기 -->
						<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">  <!--스프링 시큐리티에서 authorize 가 왔으면  -->
						<li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<br />
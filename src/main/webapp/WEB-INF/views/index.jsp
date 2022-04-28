<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header 호출 -->
<%@ include file="layout/header.jsp"%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>  <!-- model > Board.java 에서의 getTitle() 호출 -->
				<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>

	<ul class="pagination justify-content-center">
		<!-- jstl 사용 -->
		<c:choose>
			<c:when test="${boards.first}"> <!-- 첫번째 페이지이면 Previous 버튼 클릭 안되게 disabled -->
				<li class="page-item disabled"><a class="page-link"
					href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last}"> <!-- 마지막 페이지이면 Next 버튼 클릭 안되게 disabled -->
				<li class="page-item disabled"><a class="page-link"
					href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</div>

<!-- footer 호출 -->
<%@ include file="layout/footer.jsp"%>
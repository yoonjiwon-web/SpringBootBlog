<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button> 
	<c:if test="${boardDetail.user.id == principal.user.id}"> <!-- 자기가 작성한 글만 수정/삭제가능 -->
		<a href="/board/${boardDetail.id }/updateform" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br /><br /><br />
	
	<div>
		글번호 : <span id="id"><i>${boardDetail.id }</i></span>
		작성자 : <span><i>${boardDetail.user.username }</i></span>
	</div>
	
	<div class="form-group">
		<h3>${boardDetail.title}</h3>
	</div>
	<hr />
	<div class="form-group">
		<div>
			${boardDetail.content }
		</div>
	</div> 
	<hr />
	
	<!-- 부트스트랩 card 디자인 사용 -->
	<div class="card">
	    <form>
	        <input type="hidden" id="userId" value="${principal.user.id}" />
		    <input type="hidden" id="boardId" value="${boardDetail.id}" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
	<br />
	
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${boardDetail.replys}">
			
				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${reply.user.username} &nbsp;</div>
						<c:if test="${reply.user.id eq principal.user.id}">
							<button onClick="index.replyDelete(${boardDetail.id}, ${reply.id})" class="badge">삭제</button>
						</c:if>
						
					</div>
				</li>
				
			</c:forEach>
		</ul>
	</div>
	
</div> 
 
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

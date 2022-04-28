<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<input type="hidden" id="id" value="${boardDetail.id }"/>
		<div class="form-group">
			<input value="${boardDetail.title }" type="text" class="form-control" placeholder="Enter Title" id="title">
		</div>
		
		<div class="form-group">
			<textarea class="form-control summernote" rows="5" cols="" id="content">${boardDetail.content }</textarea>
		</div> 
	</form>
	<button id="btn-update" class="btn btn-primary">게시글 수정</button>
</div>


	<script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>
    
    
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

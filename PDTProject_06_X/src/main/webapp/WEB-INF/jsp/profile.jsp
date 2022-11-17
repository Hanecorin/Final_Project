<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>profile.jsp</title>

<style type="text/css">
div#insertBoard {
	display: flex;
	justify-content: center;
}
</style>
</head>

<body>
	<h3>PROFILE</h3>
	<hr>
	<div id="Board">
		<form action="updateprofile" method="POST">
			<table border="1">
				<tr>
					<th width="200">ID</th>
					<th width="150">img</th>
					<th width="200">name</th>
				</tr>
				<tr>
					<td><input type="text" name="userId" value="${user.getUserId()}"
						readonly></td>
					<td><img src="${user.getImgUrl()}" name="userImg" width="100"
						height="120"></td>
					<td><input type="text" name="name" value="${user.getName()}"></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">수정하기Test</button>
		</form>
	</div>
	<br><hr><br>
	<table border="1" width="700">
		<tr>
			<th width="100">글번</th>
			<th width="150">작성자</th>
			<th width="150">이미지</th>
			<th width='300'>내용</th>
			<th width="100">작성일</th>
			<th width="100">수정일</th>
			<th width="150">키워드</th>
			<th width="100">로그인 세션정보</th>
			<th>좋아요</th>
			<th>댓글</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="postList" items="${postList}">
			<tr>
				<td>${postList.postId}</td>
				<td><a href="getuser?user=${postList.userId.getUserId()}">${postList.userId.getUserId()}</a></td>
				<td><img src="${postList.userId.getImgUrl()}" name="userImg"
					width="100" height="120"></td>
				<td align="left">${postList.text}</td>
				<td>${postList.createDate}</td>
				<td>${postList.updateDate}</td>
				<td>${postList.keyword}</td>
				<td>${sessionScope.user.userId}</td>
				<td><a
					href="ilike?userId=${sessionScope.user.userId}&postId=${postList.postId}">좋아요</a></td>
				<td><a href="goreply?postId=${postList.postId}">댓글보기</a></td>
				
				<c:if test="${sessionScope.user.userId == postList.userId.getUserId()}">
				<td><a href="goupdatepost?postId=${postList.postId}">수정하기</a></td>
				<td><a href="deletepost?postId=${postList.postId}&userId=${sessionScope.user.userId}">삭제하기</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<a href="gohome?userId=${sessionScope.user.userId}">홈으로 돌아가기</a>
	<br>
</body>
</html>

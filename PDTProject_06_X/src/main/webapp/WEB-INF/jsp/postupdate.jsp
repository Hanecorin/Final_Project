<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>

		<h3>Home</h3>

		<br>
		<hr>

		<a href="goprofile?user=${sessionScope.user.userId}">PROFILE 보기</a> <br>
		<hr>
		<form action="updatepost" method="POST">
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

				</tr>
				<tr>
					<td><input type="text" name="postId" value="${post.postId}"
						readonly>
					<td><a href="getuser?user=${post.userId.getUserId()}"><input
							type="text" name="userId" value="${post.userId.getUserId()}" readonly></a></td>
					<td><img src="${post.userId.getImgUrl()}" name="userImg"
						width="100" height="120"></td>
					<td><input type="text" name="text" value="${post.text}">
					</td>
					<td>${post.createDate}</td>
					<td>${post.updateDate}</td>
					<td><input type="text" name="keyword" value="${post.keyword}">
					<td>${sessionScope.user.userId}</td>
					<td><a
						href="ilike?userId=${sessionScope.user.userId}&postId=${post.postId}">좋아요</a></td>
					<td><a href="goreply?postId=${post.postId}">댓글보기</a></td>
				</tr>
			</table>
			<c:if test="${sessionScope.user.userId == post.userId.getUserId()}">
			<button type="submit" class="btn btn-primary">작성</button>
			</c:if>
		</form>
		<br> <a href="gowrite">게시글 등록</a> <br> <a href="logout">로그아웃</a>
	</center>
</body>
</html>

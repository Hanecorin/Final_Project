<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>

<h3>Home</h3>

<br><hr>

<a href="goprofile?user=${sessionScope.user.userId}">PROFILE 보기</a>
<br><hr>

<table border="1" width="700">
<tr>
	<th width="100">글번</th>
	<th width="150">작성자</th>
	<th width="150">이미지</th>
	<th width='300'>내용</th>
	<th width="100">작성일</th>
	<th width="100">수정일</th>
	<th width="150">키워드1</th>
	<th width="150">키워드2</th>
	<th width="150">키워드3</th>
	<th width="100">로그인 세션정보</th>
	<th>좋아요</th>
	<th>댓글</th>

</tr>
 
<c:forEach var="postList" items="${postList}">
	<tr>
		<td>${postList.postId}</td>
		<td><a href="getuser?user=${postList.userId.getUserId()}">${postList.userId.getUserId()}</a></td>
		<td><img src="${postList.userId.getImgUrl()}" name="userImg" width="100" height="120"></td>
		<td align="left">${postList.text}</td>
		<td>${postList.createDate}</td>
		<td>${postList.updateDate}</td>
		<td>${postList.keyword1}</td>
		<td>${postList.keyword2}</td>
		<td>${postList.keyword3}</td>
		<td>${sessionScope.user.userId}</td>
		<td><a href="ilike?userId=${sessionScope.user.userId}&postId=${postList.postId}">좋아요</a></td>
		<td><a href="goreply?postId=${postList.postId}">댓글보기</a></td>
	
	</tr>
</c:forEach>

</table>
<br>
<a href="gowrite">게시글 등록</a>
	<br>
<a href="logout">로그아웃</a>
<a href="getuserinform?userId=def@naver.com">데이터불러오기 </a>
</center>
</body>
</html>

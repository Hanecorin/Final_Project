<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글</title>
</head>
<body>
<center>

<h3>Reply</h3>

<br><hr><br>

<table border="1" width="700">
<tr>
	<th width="150">해당 글번호</th>
	<th width="150">작성자</th>
	<th width='300'>내용</th>
</tr>
 
<c:forEach var="replyList" items="${replyList}">
	<tr>
		<td>${replyList.postId.getPostId()}</td>
		<td><a href="getUser?userId=${replyList.userId.getUserId()}">${replyList.userId.getUserId()}</a></td>
		<td align="left">${replyList.text}</td>
	</tr>
</c:forEach>

</table>
<br>
<a href="gohome?userId=${sessionScope.user.userId}">홈으로 돌아가기</a>
<br>


<a href="goreplywrite?postId=${postId}">댓글쓰기</a>
<br>
</center>
</body>
</html>

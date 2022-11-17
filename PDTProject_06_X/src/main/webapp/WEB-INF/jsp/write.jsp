<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.html</title>

<style type="text/css">
div#insertBoard {
	display: flex;
	justify-content: center;
	/* ê°ë¡ ê¸°ì¤ì¼ë¡ ìì ììë¥¼ ê°ì´ë° ë°°ì¹ */
}
</style>
</head>

<body>
	<h3>Write here</h3>
	<hr>
	<div id="Board">
		<form action="write" method="POST">
			<table border="1">
				<tr>
					<th width="150">작성자</th>
					<th width="150">img</th>
					<th width="200">작성칸</th>
					<th width="200">keyword</th>
					<th width="200">keyword1</th>
					<th width="200">keyword2</th>
					<th width="200">keyword3</th>
					
				</tr>
				<tr>
					<td><input type="text" name="userId" value="${sessionScope.user.userId}" readonly></td>
					<td><img src="${sessionScope.user.imgUrl}" name="userImg" width="100" height="120"></td>
					<td align="center"><input type="text" width="500" name="text" /></td>
					<td align="center"><input type="text" width="1000" name="keyword" value="#안녕, #구름, #하늘" /></td>
					<td align="center"><input type="text" width="1000" name="keyword1" /></td>
					<td align="center"><input type="text" width="1000" name="keyword2" /></td>
					<td align="center"><input type="text" width="1000" name="keyword3" /></td>
					
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">작성</button>
		</form>
	</div>
</body>
</html>

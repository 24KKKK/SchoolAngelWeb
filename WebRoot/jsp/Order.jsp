<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写订单</title>
</head>
<body>

	<form name="form1" id="form1" method="post" action="servlet/SubmitServlet">

		<p>请输入菜品号：</p>
		<input type="text" name="foodnum" id="foodnum">
		<p>请输入楼号：</p>
		<input type="text" name="apartnum" id="apartnum">
		<p>请输入宿舍号：</p>
		<input type="text" name="dormitorynum" id="dormitorynum">
		<p>请输入姓名：</p>
		<input type="text" name="ordername" id="ordername"><br />
		<br /> <input type="submit" name="submit" value="提    交">
		
	</form>

</body>
</html>
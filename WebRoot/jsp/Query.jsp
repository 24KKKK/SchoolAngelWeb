<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
<form action="../servlet/QueryByFoodnum" method="post">
请输入菜品号<input style="width:50px" type="text" name="foodnum" id="foodnum">
<input type="submit" name="submitquerybyfoodnum" id="submitquerybyfoodnum" value="查询单个"><br /><br />
</form>

<form action="../servlet/QueryAll" method="post">
<input type="submit" name="submitqueryall" id="submitqueryall" value="查询全部">
</form>

</body>
</html>
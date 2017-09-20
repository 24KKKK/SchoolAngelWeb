<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<title>查询</title>
</head>
<body>
<!-- 根据菜品号进行查询 -->
<form action="../servlet/QueryByFoodnum" method="post">
请输入菜品号<input style="width:50px" type="text" name="foodnum" id="foodnum">
<input type="submit" name="submitquerybyfoodnum" id="submitquerybyfoodnum" value="查询单个"><br /><br />
</form>
<!-- 查询全部 -->
<form action="../servlet/QueryAll" method="post">
<input type="submit" name="submitqueryall" id="submitqueryall" value="查询今天全部"><br /><br />
</form>
<!-- 查询各菜品的数量 -->
<form action="../servlet/QueryCount" method="post">
<input type="submit" name="submitquerycount" id="submitquerycount" value="查询各菜品数量"><br /><br />
</form>
<!-- 负责人根据楼号查询本栋楼 -->
<form action="../servlet/QueryByApartnum" method="post">
请输入楼号<input style="width:50px" type="text" name="apartnum" id="apartnum">
<input type="submit" name="submitquerybyapartnum" id="submitquerybyapartnum" value="查询单个"><br /><br />
</form>

</body>
</html>
<%@page import="bean.Order"%>
<%@ page import="java.util.List"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<title>显示各菜品数量</title>
</head>
<body>

<br /><a href="../jsp/Query.jsp">返回上一页</a><br /><br />

<table>
	<tr>
		<th>菜品号</th>
		<th>数量</th>
	</tr>
    <%  
    Object obj = request.getAttribute("orderList");  
    List<Order> orderList = null;
    if(obj instanceof List){  
        orderList = (List<Order>)obj;  
    }  
    String foodnum = null;
    String count = null;
    if(orderList!=null){  
        for(Order order:orderList){  
             foodnum = order.getFoodNum(); 
             count = order.getCount();
            %>
            			<tr>
            				<td><%=foodnum %></td>
            				<td><%=count %></td>
            			</tr>  
            <%  
        }  
    }  
    else{
    	out.println("没有记录");
    }
    %>  
     
</table>
</body>
</html>
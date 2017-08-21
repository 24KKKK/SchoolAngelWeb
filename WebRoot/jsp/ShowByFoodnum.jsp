<%@page import="bean.Order"%>
<%@ page import="java.util.List"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据菜品号显示</title>
</head>
<body>
<table>
	<tr>
		<th>序号</th>
		<th>菜品号</th>
		<th>楼号</th>
		<th>宿舍号</th>
	</tr>
	

 
    <%  
    Object obj = request.getAttribute("orderList");  
    List<Order> orderList = null;
    if(obj instanceof List){  
        orderList = (List<Order>)obj;  
    }  
    String foodnum = null;
    String apartnum = null;
    String dormitorynum = null;
    int num = 1;
    if(orderList!=null){  
        for(Order order:orderList){  
             foodnum = order.getFoodNum(); 
             apartnum = order.getApartNum();
             dormitorynum = order.getDormitoryNum();
             
            %>
            
            	
            		
            			<tr>
            			<td><%=num++ %></td>
            				<td><%=foodnum %></td>
            				<td><%=apartnum %></td>
            				<td><%=dormitorynum %></td>
            			</tr>  
            		
            <%  
        }  
        
    }  
    %>  
     
</table>
</body>
</html>
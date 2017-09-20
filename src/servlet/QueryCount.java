package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBBean;
import bean.Order;
import config.CreateDate;
import config.Syso;

public class QueryCount extends HttpServlet {

	public QueryCount() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Syso.p("查询数量*************************************");
		PreparedStatement ps = null;
		//Connection conn = null;
		String submitQueryCount = request.getParameter("submitquerycount");
			if (submitQueryCount != null && !submitQueryCount.equals("")) {
				//int foodNum = Integer.parseInt(request.getParameter("foodnum"));
				List<Order> orderList = new ArrayList<Order>();
				String maxdate = CreateDate.getDate();
				String mindate = maxdate.substring(0, 10)+" 00:00:00";
				DBBean db = new DBBean();
				//Syso.p("要查询的foodnum为："+foodNum);
				String queryCountSql = "select foodnum '菜品号', count(*) '数量' from table_order where date <= "+"'"+maxdate+"'"+ " and date >="+"'"+mindate+"'"+" GROUP BY foodnum";
				//String queryCountSql = "SELECT foodnum '菜品号', count(*) '数量' from table_order where date <= '2017-08-15 21:27:43' and date >='2017-08-15 00:00:00' GROUP BY foodnum";
				Syso.p("queryCountSql="+queryCountSql);
				//ResultSet rs = db.executeQuery(queryAllSql);
				ResultSet rs = db.executeQuery(queryCountSql);
				try {
					while(rs.next()) {
						String fnum = rs.getString("菜品号");
						String count = rs.getString("数量");
						Order order = new Order(fnum,count);
						orderList.add(order);
					}
					request.setAttribute("orderList", orderList);
					request.getRequestDispatcher("../jsp/ShowQueryCount.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						db.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

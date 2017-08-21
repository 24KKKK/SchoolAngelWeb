package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

public class QueryByFoodnum extends HttpServlet {

	public QueryByFoodnum() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Syso.p("根据foodnum查询*************************************");
		request.setCharacterEncoding("utf-8");
		PreparedStatement ps = null;
		//Connection conn = null;
		String submitQueryByFoodnum = request.getParameter("submitquerybyfoodnum");
			if (submitQueryByFoodnum != null && !submitQueryByFoodnum.equals("")) {
				int foodNum = Integer.parseInt(request.getParameter("foodnum"));
				List<Order> orderList = new ArrayList<Order>();
				String maxdate = CreateDate.getDate();
				String mindate = maxdate.substring(0, 10)+" 00:00:00";
				DBBean db = new DBBean();
				Syso.p("要查询的foodnum为："+foodNum);
				//String queryByFoodnumSql = "select foodnum,apartnum,dormitorynum from table_order where foodnum = "+foodNum+" and date <= "+"'"+maxdate+"'"+ " and date >="+"'"+mindate+"'"+" order by apartnum desc";
				String queryByFoodnumSql = "select foodnum,apartnum,dormitorynum from table_order where foodnum = 5 and date <= '2017-08-15 21:27:43' and date >='2017-08-15 00:00:00' order by apartnum asc";
				Syso.p("queryByFoodnumSql="+queryByFoodnumSql);
				//ResultSet rs = db.executeQuery(queryByFoodnumSql);
				ResultSet rs = db.executeQuery(queryByFoodnumSql);
				try {
					while(rs.next()) {
						String fnum = rs.getString("foodnum");
						String anum = rs.getString("apartnum");
						String dnum = rs.getString("dormitorynum");
						Order order = new Order(fnum,anum,dnum);
						orderList.add(order);
					}
					request.setAttribute("orderList", orderList);
					request.getRequestDispatcher("../jsp/ShowByFoodnum.jsp").forward(request, response);
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

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

public class QueryByApartnum extends HttpServlet {

	public QueryByApartnum() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Syso.p("根据apartnum查询*************************************");
		request.setCharacterEncoding("utf-8");
		PreparedStatement ps = null;
		//Connection conn = null;
		String submitQueryByApartnum = request.getParameter("submitquerybyapartnum");
			if (submitQueryByApartnum != null && !submitQueryByApartnum.equals("")) {
				int apartNum = Integer.parseInt(request.getParameter("apartnum"));
				Syso.p("要查询的apartnum为："+apartNum);
				List<Order> orderList = new ArrayList<Order>();
				String maxdate = CreateDate.getDate();
				String mindate = maxdate.substring(0, 10)+" 00:00:00";
				DBBean db = new DBBean();
				String queryByApartnumSql = "select foodnum,apartnum,dormitorynum from table_order where apartnum = "+apartNum+" and date <= "+"'"+maxdate+"'"+ " and date >="+"'"+mindate+"'"+" order by foodnum asc";
				//String queryByApartnumSql = "select foodnum,apartnum,dormitorynum from table_order where apartnum = "+apartNum+" and date <= "+"'"+maxdate+"'"+ " and date >="+"'"+mindate+"'"+" order by foodnum asc";
				Syso.p("queryByApartnumSql="+queryByApartnumSql);
				//ResultSet rs = db.executeQuery(queryByFoodnumSql);
				ResultSet rs = db.executeQuery(queryByApartnumSql);
				try {
					while(rs.next()) {
						String fnum = rs.getString("foodnum");
						String anum = rs.getString("apartnum");
						String dnum = rs.getString("dormitorynum");
						Order order = new Order(fnum,anum,dnum);
						orderList.add(order);
					}
					request.setAttribute("orderList", orderList);
					request.getRequestDispatcher("../jsp/ShowByApartnum.jsp").forward(request, response);
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

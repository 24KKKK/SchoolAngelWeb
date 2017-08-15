package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBBean;

import config.CreateDate;
import config.Syso;

public class QueryByFoodnum extends HttpServlet {

	public QueryByFoodnum() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Syso.p("根据foodnum查询*************************************");
		String submitQueryByFoodnum = request.getParameter("submitquerybyfoodnum");
			if (submitQueryByFoodnum != null && !submitQueryByFoodnum.equals("")) {
				int foodNum = Integer.parseInt(request.getParameter("foodnum"));
				String date = CreateDate.getDate();
				DBBean db = new DBBean();
				Syso.p("要查询的foodnum为："+foodNum);
				String queryByFoodnumSql = "select foodnum,apartnum,dormitorynum from table_order where foodnum = "+foodNum+" and date <= "+"'"+date+"'"+" order by apartnum desc";
				Syso.p("queryByFoodnumSql="+queryByFoodnumSql);
				ResultSet rs = db.executeQuery(queryByFoodnumSql);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

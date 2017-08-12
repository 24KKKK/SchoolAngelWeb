package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBBean;

import config.CreateDate;
import config.Syso;

public class SubmitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubmitServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String submit = request.getParameter("submit");
		if(submit != null && !submit.equals("")) {
			int foodNum = Integer.parseInt(request.getParameter("foodnum"));
			int apartNum = Integer.parseInt(request.getParameter("apartnum"));
			int dormitoryNum = Integer.parseInt(request.getParameter("dormitorynum"));
			String orderName = request.getParameter("ordername");
			String date = CreateDate.getDate();
			Syso.p(foodNum+" "+apartNum+" "+dormitoryNum+" "+orderName+" "+date);
			
			DBBean db = new DBBean();
			String insertSql = "insert into table_order (foodnum,apartnum,dormitorynum,ordername,date) " +
					"values ("+foodNum+","+apartNum+","+dormitoryNum+","+"'"+orderName+"'"+","+"'"+date+"'"+")";
			Syso.p("数据插入sql:"+insertSql);
			int i = db.executeUpdate(insertSql);
			if (i == 1) {
				Syso.p("数据插入成功。");
				response.setHeader("refresh", "0;url=../WEB-INF/jsp/Success.jsp");
			} else {
				Syso.p("数据插入失败。");
				response.setHeader("refresh", "0;url=../WEB-INF/jsp/Fail.jsp");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
}

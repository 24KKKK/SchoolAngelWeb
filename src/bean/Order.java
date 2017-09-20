package bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private String foodNum;
	private String apartNum;
	private String dormitoryNum;
	private String orderName;
	private Date date;
	private String count;  //汇总人查询的各菜品数量
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order (String foodnum,String apartnum,String dormitorynum,String ordername,Date date) {
		super();
		this.foodNum = foodnum;
		this.apartNum = apartnum;
		this.dormitoryNum = dormitorynum;
		this.orderName = ordername;
		this.date = date;
	}
	
	//汇总人  查询单个和全部记录
	public Order (String foodnum,String apartnum,String dormitorynum) {
		super();
		this.foodNum = foodnum;
		this.apartNum = apartnum;
		this.dormitoryNum = dormitorynum;
	}
	
	//汇总人  查询各菜品数量
		public Order (String foodnum,String count) {
			super();
			this.foodNum = foodnum;
			this.count = count;
		}
	
	public String getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(String foodNum) {
		this.foodNum = foodNum;
	}
	public String getApartNum() {
		return apartNum;
	}
	public void setApartNum(String apartNum) {
		this.apartNum = apartNum;
	}
	public String getDormitoryNum() {
		return dormitoryNum;
	}
	public void setDormitoryNum(String dormitoryNum) {
		this.dormitoryNum = dormitoryNum;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
}

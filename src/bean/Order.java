package bean;

import java.util.Date;

public class Order {
	private String foodNum;
	private String apartNum;
	private String dormitoryNum;
	private String orderName;
	private Date date;
	
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
	
}

package in.foodPlaza.pojo;

public class Order {

	
	private int orderId;
	private String  custEmail;
	private  String orderStatus;
	private String orderDate;
	private int totalBill;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Order(String custEmail, String orderStatus, String orderDate, int totalBill) {
		super();
		this.custEmail = custEmail;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
	}





	public Order(int orderId, String custEmail, String orderStatus, String orderDate, int totalBill) {
		super();
		this.orderId = orderId;
		this.custEmail = custEmail;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
	}





	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custEmail=" + custEmail + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", totalBill=" + totalBill + "]";
	}
	
	
	
	
}

//select sum(foodprice*foodquantity) as total  from food_22377 f inner join cart_22377 c on f.foodid=c.foodid;


//create table order_22377(orderid int(20) primary key auto_increment,custemail varchar(20),orderstatus varchar(50) default 'processing',orderdate varchar(100),totalbill int(100));
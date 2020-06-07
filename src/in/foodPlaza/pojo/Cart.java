package in.foodPlaza.pojo;

public class Cart {

	private int cartId;
	private String custEmail;
	private int foodId;
	private int foodQuantity;
	private String foodName;
	private int foodPrice;
	private String foodtype;
	private String foodCategory;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String custEmail, int foodId) {
		super();
		this.custEmail = custEmail;
		this.foodId = foodId;
	}

	public Cart(int cartId, String custEmail, int foodQuantity) {
		super();
		this.cartId = cartId;
		this.custEmail = custEmail;
		this.foodQuantity = foodQuantity;
	}

	public Cart(int cartId, String custEmail, int foodId, int foodQuantity) {
		super();
		this.cartId = cartId;
		this.custEmail = custEmail;
		this.foodId = foodId;
		this.foodQuantity = foodQuantity;
	}

	public Cart(int cartId, String custEmail, int foodId, int foodQuantity, String foodName, int foodPrice,
			String foodtype, String foodCategory) {
		super();
		this.cartId = cartId;
		this.custEmail = custEmail;
		this.foodId = foodId;
		this.foodQuantity = foodQuantity;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodtype = foodtype;
		this.foodCategory = foodCategory;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", custEmail=" + custEmail + ", foodId=" + foodId + ", foodQuantity="
				+ foodQuantity + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodtype=" + foodtype
				+ ", foodCategory=" + foodCategory + "]";
	}

	

}

/*
 * create table cart_22377(cartid int(10) primary key auto_increment,custemail
 * varchar(50),foodid int(30),foodquantity int(40) default 1);
 */
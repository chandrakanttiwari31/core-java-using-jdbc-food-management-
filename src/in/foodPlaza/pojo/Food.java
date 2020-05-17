package in.foodPlaza.pojo;

public class Food {
	
	
	private int foodId;
	private String foodName;
	private String foodType;
	private String foodCategory;
	private double foodPrice;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(String foodName, String foodType, String foodCategory, double foodPrice) {
		super();
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCategory = foodCategory;
		this.foodPrice = foodPrice;
	}
	public Food(int foodId, String foodName, String foodType, String foodCategory, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCategory = foodCategory;
		this.foodPrice = foodPrice;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodCategory="
				+ foodCategory + ", foodPrice=" + foodPrice + "]";
	}
	

}




//create table food_22377 (foodid int primary key auto_increment,foodname varchar(30),foodtype varchar(30),
//foodcategory varchar(30),foodprice int(20));


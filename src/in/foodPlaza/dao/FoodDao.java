package in.foodPlaza.dao;

import java.util.List;

import in.foodPlaza.pojo.Food;

public interface FoodDao {

	
	boolean addFood(Food food);
	boolean updateFood(Food food);
	boolean deleteFood(int foodId);
	
	
	List<Food> showFoodList();
	
	
	Food searchFoodById(int foodId);
	List<Food> searchFoodByName(String foodName);
	List<Food> searcFoodByType(String foodType);
	List<Food> searchFoodByCategory(String foodCategory);
	
    
}
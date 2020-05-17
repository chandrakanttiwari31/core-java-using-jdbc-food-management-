package in.foodPlaza.test;

import java.util.List;
import java.util.Scanner;

import in.foodPlaza.dao.FoodDaoImpl;
import in.foodPlaza.pojo.Food;

public class FoodTest {

	
	
	public static void main(String[] args) {
		
		
		
		Food food =null;
		FoodDaoImpl fdi=new FoodDaoImpl() ;
		int foodId;
		 String foodName;
		 String foodType;
		 String foodCategory;
		 double foodPrice;
		 boolean result;
		 
		 Scanner sc=new Scanner(System.in);
		 
		 int choice;
		 char ch;
		 
		 do
		 {
			 
			 System.out.println("********************Foood Plaza*****************");
			 System.out.println("=================================================");
			 System.out.println(" 1. Add Food");
			 System.out.println(" 2. Update Food ");
			 System.out.println(" 3. DeleteFood");
			 System.out.println(" 4. Show Food List");
			 System.out.println(" 5. Search Food By Id");
			 System.out.println(" 6. Search Food By Name");
		     System.out.println(" 7. Search Food by Type");
		     System.out.println(" 8. Search food by category");
			 System.out.println("===================================================");
			 System.out.println("\n Enter Your Choice");
			 
			 choice=sc.nextInt();
			 
		 switch(choice)
		 {
		 
		 
		 case 1:
			 
			 System.out.println("**********Adding food process");
			 System.out.println("-------------------------------");
			 
			 System.out.println("enter food name");;
			 foodName=sc.next();
			 System.out.println("enter  food type");
			 foodType=sc.next();
			 System.out.println("enter food category");
			 foodCategory=sc.next();
			 System.out.println("enter food price");
			 foodPrice=sc.nextDouble();
			 
			 food=new Food(foodName, foodType, foodCategory, foodPrice);
			 result=fdi.addFood(food);
			 
			 if(result)
			 {
				 
				 
				 System.out.println("insert");
			 }
			 else
			 {
				 
				 System.out.println("not insert");
			 }
			 
			 
			 
			 
			 
			 break;
		 case 2:
			 break;
		 case 3:
			 
			 System.out.println("**********deleting operation*********");
			 System.out.println("--------------------------------------");
			 System.out.println("enter  food id");
			 
			 foodId=sc.nextInt();
			 result=fdi.deleteFood(foodId);
			 if(result)
				 System.out.println("delete  food successfully");
			 else
				 System.out.println("food not deleted");
			 
			 break;
		 case 4:
			 
			 System.out.println("***************Food List************");
			 System.out.println("=====================================");
			 
			 List<Food> foodlist=fdi.showFoodList();
			 if(!foodlist.isEmpty())
			 {
				 for(Food f:foodlist)
				 {
					 
					 System.out.println(f);
				 }
				 
			 }
			 else
			 {
				 
				 System.out.println("food list empty");
			 }
			 
			 
			 break;
		 case 5:
			 
			 
			 
			 System.out.println("************search food by id******");
			 System.out.println("----------------------------------------");
			 
			 System.out.println("enter food id");
             foodId=sc.nextInt();
             food=fdi.searchFoodById(foodId);
             
             if(food !=null)
             {
            	 System.out.println(food);
            	 
             }
             else
             {
            	 System.out.println("food notavailable");
             }
             
             

			 
			 break;
		 case 6:
			 
			 
			 System.out.println("====================Search by Food Name======================");
			 System.out.println("===============================================================");
			 
			 System.out.println("Enter  food name which you want to search");
			 foodName=sc.next();
			 
			 foodlist=   fdi.searchFoodByName(foodName);
			 if(!foodlist.isEmpty())
			 {
				 
				 System.out.println("food detail");
				 for(Food f1:foodlist)
				 {
				 System.out.println(foodlist);
			 }
				 System.out.println("==========================");
			 }
			 
			 else
				 System.out.println(" food  detail is not available for this food name");
			 break;
			 
		 case 7:
			 
			 System.out.println("====================Search by Food Type======================");
			 System.out.println("===============================================================");
			 
			 System.out.println("Enter  food Type which you want to search");
			 foodType=sc.next();
			 
			 foodlist=   fdi.searcFoodByType(foodType);
			 if(!foodlist.isEmpty())
			 {
				 
				 System.out.println("food detail");
				 for(Food f1:foodlist)
				 {
				 System.out.println(foodlist);
			 }
				 System.out.println("==========================");
			 }
			 
			 else
				 System.out.println(" food  detail is not available for this food type");
			 break;
			 
		 case 8:
			 
			 System.out.println("====================Search by Food Type======================");
			 System.out.println("===============================================================");
			 
			 System.out.println("Enter  Food Category which you want to search");
			 foodCategory=sc.next();
			 
			 foodlist=   fdi.searchFoodByCategory(foodCategory);
			 if(!foodlist.isEmpty())
			 {
				 
				 System.out.println("Food detail");
				 for(Food f1:foodlist)
				 {
				 System.out.println(foodlist);
			 }
				 System.out.println("==========================");
			 }
			 
			 else
				 System.out.println(" Food  detail is not available for this food Category");
			 break;
			 
		 default:
			 
			 System.out.println("please enter the choice from no 1 to 8");
		}//switch
	 
	 System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
	 ch=sc.next().charAt(0);	
	 
 }//do
		 
		 while(ch=='y'|| ch=='Y');
		 
		 System.out.println("*******************THANK YOU ************************");
 
			 
	}
}

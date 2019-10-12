package Restrorent;

public class FoodItemOpearations {

	public static void main(String[] args) {
		FoodItemList foodItemList = new FoodItemList();
		FoodItemDetails details1 = new FoodItemDetails("Apetizer", "samosa", 2.0);
		FoodItemDetails details2 = new FoodItemDetails("Apetizer", "Puff", 2.0);
		FoodItemDetails details3 = new FoodItemDetails("MainDish", "Dal", 12.0);
		FoodItemDetails details4 = new FoodItemDetails("MainDish", "Paneer", 13.0);
		FoodItemDetails details5 = new FoodItemDetails("Desert", "GulabJamun", 12.0);
		FoodItemDetails details6 = new FoodItemDetails("Desert", "rasgulla", 5.0);
		
		FoodItemDetails details7 = new FoodItemDetails("Apetizer", "samosa", 3.0);
		FoodItemDetails details8 = new FoodItemDetails("Apetizer", "springroll", 3.0);
		FoodItemDetails details9 = new FoodItemDetails("Apetizer", "springroll", 4.0);
		foodItemList.addNewFoodItemDetails(details1);
		foodItemList.addNewFoodItemDetails(details2);
		foodItemList.addNewFoodItemDetails(details3);
		foodItemList.addNewFoodItemDetails(details4);
		foodItemList.addNewFoodItemDetails(details5);
     	foodItemList.addNewFoodItemDetails(details6);
     	foodItemList.addNewFoodItemDetails(details8);
     	
	//	foodItemList.printFoodItemDetails();
//		foodItemList.printApetizerItemDetails();
//		foodItemList.printDesertItemDetails();
//		foodItemList.printMainMenuItemDetails();

	foodItemList.updateFoodItemDetails(details9);
		foodItemList.printFoodItemDetails();
	//	foodItemList.removeFoodItemDetails(details8);
	//	foodItemList.printFoodItemDetails();

	}

}

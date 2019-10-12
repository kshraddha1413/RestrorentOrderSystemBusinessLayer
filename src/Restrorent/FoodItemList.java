package Restrorent;

import java.util.ArrayList;

import Restrorent.FoodItemDetails;

public class FoodItemList {
	public static FoodItemList foodItemList = new FoodItemList();
	private static ArrayList<FoodItemDetails> foodList;

	public FoodItemList() {
		this.foodList = new ArrayList<FoodItemDetails>();
	}

	public boolean addNewFoodItem(FoodItemDetails details) {

		if (findFoodItem(details.getFoodItemName()) >= 0) {
			System.out.println("FoodItem is already on List");
			return false;
		}

		foodList.add(details);
		return true;

	}

	private int findFoodItem(String FoodItemName) {
		for (int i = 0; i < this.foodList.size(); i++) {
			FoodItemDetails details = this.foodList.get(i);
			if (details.getFoodItemName().equals(FoodItemName)) {
				return i;
			}
		}

		return -1;
	}

	public boolean updateFoodItem(FoodItemDetails oldDeatils, FoodItemDetails newDeatils) {
		int foundPosition = findFoodItem(oldDeatils);
		if (foundPosition < 0) {
			System.out.println(oldDeatils.getFoodItemName() + ", was not found.");
			return false;
		}

		foodList.set(foundPosition, newDeatils);
		System.out
				.println(oldDeatils.getFoodItemName() + ", is replaced with new price" + newDeatils.getFoodItemPrice());
		return true;
	}

	private int findFoodItem(FoodItemDetails details) {
		for (int i = 0; i < foodList.size(); i++) {
			if (details.getFoodItemName().equalsIgnoreCase(foodList.get(i).getFoodItemName())) {
				return i;
			}

		}

		return -1;
	}

	public boolean removeFoodItemDetails(FoodItemDetails details) {
		int foundPosition = findFoodItem(details);
		if (foundPosition < 0) {
			System.out.println(details.getFoodItemName() + ", was not found.");
			return false;
		}
		foodList.remove(foundPosition);
		System.out.println(details.getFoodItemName() + ", was deleted.");
		return true;
	}

	public void printFoodItemDetails() {
		System.out.println("FoodItems List");
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println((i + 1) + "." + foodList.get(i).getFoodItemType() + " -> "
					+ foodList.get(i).getFoodItemName() + " -> " + foodList.get(i).getFoodItemPrice());
		}

	}

	public FoodItemDetails queryFoodItemDeatils(String foodItemname) {
		int position = findFoodItem(foodItemname);
		if (position >= 0) {
			return this.foodList.get(position);
		}

		return null;
	}

	public void printApetizerItemDetails() {
		System.out.println("Apetizer List**********************");
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).getFoodItemType().equalsIgnoreCase("Apetizer")) {
				System.out.println((i + 1) + "." + this.foodList.get(i).getFoodItemType() + " -> "
						+ this.foodList.get(i).getFoodItemName() + " -> " + this.foodList.get(i).getFoodItemPrice());
			}
		}
	}

	public void printDesertItemDetails() {
		System.out.println("MainMenu List**********************");
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).getFoodItemType().equalsIgnoreCase("Desert")) {
				System.out.println((i + 1) + "." + this.foodList.get(i).getFoodItemType() + " -> "
						+ this.foodList.get(i).getFoodItemName() + " -> " + this.foodList.get(i).getFoodItemPrice());
			}
		}
	}

	public void printMainMenuItemDetails() {
		System.out.println("DesertItem List**********************");
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).getFoodItemType().equalsIgnoreCase("MainDish")) {
				System.out.println((i + 1) + "." + this.foodList.get(i).getFoodItemType() + " -> "
						+ this.foodList.get(i).getFoodItemName() + " -> " + this.foodList.get(i).getFoodItemPrice());
			}
		}
	}

	public static void addNewFoodItemDetails(FoodItemDetails details) {
		String foodItemType = details.getFoodItemType();
		String foodItemName = details.getFoodItemName();
		double foodItemPrice = details.getFoodItemPrice();

		FoodItemDetails details1 = FoodItemDetails.createFoodItem(foodItemType, foodItemName, foodItemPrice);
		if (foodItemList.addNewFoodItem(details1)) {
			System.out.println("New food item added: food type = " + foodItemType + "food Item name" + foodItemName
					+ "food item price" + foodItemPrice);
		} else {
			System.out.println("Cannot add, " + foodItemName + " already on list");
		}
	}

	public static void updateFoodItemDetails(FoodItemDetails details) {
		String foodItemName1 = details.getFoodItemName();
		FoodItemDetails existingContactRecord = foodItemList.queryFoodItemDeatils(foodItemName1);
		if (existingContactRecord == null) {
			System.out.println("Food Item not found.");
			return;
		}

		String foodItemType = details.getFoodItemType();
		String foodItemName = details.getFoodItemName();
		double foodItemPrice = details.getFoodItemPrice();
		FoodItemDetails details1 = FoodItemDetails.createFoodItem(foodItemType, foodItemName, foodItemPrice);
		if (foodItemList.updateFoodItem(existingContactRecord, details1)) {
			System.out.println("Successfully updated record");
		} else {
			System.out.println("Error updating record.");
		}

	}

	public static void removeFoodItemDetails(String foodItemName) {
		String name = foodItemName;
		FoodItemDetails existingContactRecord = foodItemList.queryFoodItemDeatils(name);
		if (existingContactRecord == null) {
			System.out.println("Food item not found.");
			return;
		}

		if (foodItemList.removeFoodItemDetails(existingContactRecord)) {
			System.out.println("Successfully deleted");
		} else {
			System.out.println("Error deleting food item");
		}
	}

}

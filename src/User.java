import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//This is still pretty basic, I plan to implement a ComboBox so that users can choose
// a specific dietary restriction, and have the user be able to enter their username, weight, etc.
//Currently, 'users.txt' is being used to save just the username of a user, if they add a new profile.
//I think it might be good to also store the weight, dietaryRestrictions, and
//other info in this .txt file

//Feel free to make any additions or modifications.
public class User {
	private int weight;
	private String username;
	private ArrayList<String> dietaryRestrictions;
	private ArrayList<Meal> userMeals;
	Meal meal = new Meal();

	public User() {
		weight = 0;
		username = "NO NAME";
		dietaryRestrictions = null;
		this.userMeals = null; 

	}

	public User(String username, int weight, ArrayList<String> dietaryRestrictions) {
		this.weight = weight;
		this.username = username;
		this.dietaryRestrictions = dietaryRestrictions;
		//we need to add user meals so that we can pull that data by user. 
		//this.userMeals = meals;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDietaryRestrictions(ArrayList<String> dietaryRestrictions) {
		this.dietaryRestrictions = dietaryRestrictions;
	}
	public void userMeals() {
		RecipeSelector.randomSelector(meal);
	}
	public int getWeight() {
		return weight;
	}

	public String getUsername() {
		return username;
	}

	public ArrayList<String> getDietaryRestrictions() {
		return dietaryRestrictions;
	}

	public ArrayList<String> getRestrictions(ArrayList<String> dietaryRestrictions) {

		//DietDecorator?
		System.out.println("Enter your dietary restrictions: ");

		return dietaryRestrictions;
	}

	public void getAmount() {

	}

	public static ArrayList<User> DefaultUsers() {
		ArrayList<String> restrictions = new ArrayList<>();
		ArrayList<User> users = new ArrayList<User>();
	
		try {
	        File file = new File("users.txt");
	        Scanner scanner = new Scanner(file);

	        while (scanner.hasNextLine()) {
	            String username = scanner.nextLine();
	            users.add(new User(username, 0, restrictions));
	        }
	      
	    } catch (FileNotFoundException e) {
	        System.out.println("users.txt file not found.");
	    }

	    return users;
	
	}
	
	private static ArrayList<User> users = new ArrayList<User>(User.DefaultUsers());

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(String username) {
    	users.add(new User(username, 0, new ArrayList<String>()));
    	User.saveUsersToFile(users, "users.txt");
    }
    
    public static void saveUsersToFile(ArrayList<User> users, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (User user : users) {
                writer.write(user.getUsername() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // no matching user found
    }
    public double getCarbs() {
    	double carbs = meal.getCarbs();
    	return carbs;
    }
    public double getProtein() {
    	double protein = meal.getProtein();
    	return protein;
    }
    public double getFat() {
    	double fat = meal.getFat();
    	return fat;
    }

	public String getInfo() {
		
		return String.format("Username: " + this.username +  "\n Weight: " + this.weight);
		
		
		
	}

    
}
import java.util.Scanner;
//import java.time.LocalDate;
//import java.time.Period;
import java.util.Random;

public class User{
    private int userId;
    private String userName;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String confirmPassword;
    private BirthDate birthDate;
    private boolean isAdmin;

    public User(int userId, String userName, String lastName, String firstName, String email, String password, String confirmPassword, BirthDate birthDate, boolean isAdmin){
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.birthDate = birthDate;
    }

    public User(String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // private as it is only used internally in this class
    private boolean isEmailValid(String email){
        //email regex pattern to check if the email has the correct pattern [a-z, A-Z, 0-9, +, _, ., -]@[a-z, A-Z, 0-9, -]
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if(email.matches(emailRegex)){
            return true;
        }

        return false;  
    }

    // static method to generate user id without creating an object of the class
    private static int generateUserId(){
        //generate user id 
        //use the current time in milliseconds and get the last 6 digits
        //then add a random number between 0 and 1000 to ensure even more uniqueness
        Random random = new Random();
        return (int)(System.currentTimeMillis() % 1000000) + random.nextInt(1000);
    }


    // Method to create an account, put on public to allow external access
    public void createAccount(){
        //create account
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter your username: ");
        userName = scanner.nextLine();
        System.out.println("Enter your email: ");
        email = scanner.nextLine();
        while(!isEmailValid(email)){
            System.out.println("Invalid email. Please enter a valid email: ");
            email = scanner.nextLine();
        }
        System.out.println("Enter your password: ");
        password = scanner.nextLine();
        System.out.println("Confirm your password: ");
        confirmPassword = scanner.nextLine();
        while(!confirmPassword.equals(password)){
            System.out.println("Passwords do not match. Please re-confirm your password: ");
            confirmPassword = scanner.nextLine();
        }

        System.out.println("Enter your birth date (yyyy-mm-dd): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine(); //consume the newline char
        birthDate = new BirthDate(day, month, year);

        if(isUnderage(birthDate)){
            System.out.println("You are underage. You cannot create an account.");
            return;
        }else{
            System.out.println("Account created successfully.");
        }

        System.out.println("Enter the admin key (Press Enter to skip if you are not an admin): ");
        String adminKey = scanner.nextLine();
        if(adminKey.equals("Password123")){
            isAdmin = true;
            System.out.println("Admin privilege granted.");
        }else{
            isAdmin = false;
        }

        userId = generateUserId();
        
        //next after successfully creating an account, write all information to a file

    }

    public void login(){
        //login
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username or email: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        
        //open file to read all user information and compare to the login input to validate user login
    }


    // method to update password when the user forget password, put on public to allow external access
    public void forgotPassword(){
        //forgot password
    }

    // method to check if user is admin, put on public to allow external access
    public boolean isAdmin(){
        return isAdmin;
    }

    //private as it is used internally in the class only
    private int calculateAge(BirthDate birthDate){
        //calculate age logic
        //get current date then convert the birthdate to LocalDate then calculate the time period between both date and convert it to years
        return 0; //should return age but 0 placeholder for now
    }

    public boolean isUnderage(BirthDate birthDate){
        return calculateAge(birthDate) < 18;
    }


}

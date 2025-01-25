public class UserManagement{
    private int userId;
    private String userName;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String confirmPassword;
    private BirthDate birthDate;
    private boolean isAdmin;

    public UserManagement(int userId, String userName, String lastName, String firstName, String email, String password, String confirmPassword, BirthDate birthDate, boolean isAdmin){
        this.userId = userId;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
    }

    public void createAccount(){
        //create account
    }

    public void login(){
        //login
    }

    public void forgotPassword(){
        //forgot password
    }

    public boolean isAdmin(){
        return isAdmin;
    }

    private int calculateAge(BirthDate birthDate){
        //calculate age logic
        return 0; //should return age but 0 placeholder for now
    }

    public boolean isUnderage(BirthDate birthDate){
        return calculateAge(birthDate) < 18;
    }


}

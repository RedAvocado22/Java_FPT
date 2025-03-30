package pe.users;

public class UserDTO {
    
    private int userID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
  public UserDTO() {
    }
  
     // Constructor có tham số username và password
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter & Setter
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
  
}

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dob;
    private String gender;
    private String address;

    
    public User(String username, String password, String firstName, String lastName, String email,
                String phone, String dob, String gender, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDob() { return dob; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }

    
    @Override
    public String toString() {
        return String.format("Username: %s, Password: %s, Name: %s %s, Email: %s, Phone: %s, DOB: %s, Gender: %s, Address: %s",
                username, password, firstName, lastName, email, phone, dob, gender, address);
    }
}

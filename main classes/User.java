

public  class User 
{
    private int ID ;
    private  long cellphone , UserISBN;
    static int counter= UserRegistration.Customer_ArrayList.size()+1;
    private String password, type, firstName, lastName, address, email;
    public User() {
        // You can initialize default values or leave it empty
        // For example:
        this.cellphone = 0;
        this.ID = 0;
        this.UserISBN = 0;
        this.password = "";
        this.type = "";
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.email = "";
    }
    public User(String password, String type, String firstName, String lastName, String address, int cellphone, String email,int UserISBN) 
    {
        this.UserISBN=UserISBN;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cellphone = cellphone;
        this.email = email;
        counter =counter+1;
        this.ID = counter;
    }
    public String toString() {
        return getID() + "," + getUserIsbn() + "," + getPassword() + "," + getPassword()+ "," +
               getFirstName() + "," + getLastName() + "," + getAddress() + "," + getEmail();
    }
//new
    public void display_user_details() 
    {
        //System.out.println("User Type: " + type);
        System.out.println("ID: " + ID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Cellphone: " + cellphone);
    }

    
    public int getID() 
    {
        return ID;
    }
    public long getUserIsbn()
    {
        return UserISBN;
    }
    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public long getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

   
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUserISBN(int userISBN) 
    {
        UserISBN = userISBN;
    }
}
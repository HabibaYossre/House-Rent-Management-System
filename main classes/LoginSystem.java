import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
public class LoginSystem 
{
    private static Scanner input = new Scanner(System.in);
    static String userTypeInput;
    static Customers current_c;
    static  brokers current_b =null;

    public static void login() throws IOException, FileNotFoundException, ClassNotFoundException 
    {
         System.out.println("------------------------------ Log In ------------------------------ ");
        System.out.println("Enter user type (c) for customer, (b) for broker,(a) for admin): ");
        userTypeInput = input.next().toLowerCase();

        switch (userTypeInput) 
        {
            case "c":
            case "C":
                loginCustomer();
                break;
            case "b":
            case "B":
                loginBroker();
                break;
            case "a":
            case "A":
                loginAdmin();
                break;
            default:
                System.out.println("Invalid user type.");
                login();
            }
        }
    

    private  static void loginCustomer() throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        customerExist(findCustumer());
    }
    private static void loginBroker() throws IOException, FileNotFoundException, ClassNotFoundException {
        brokerExist(findBroker());
    }

    private static void loginAdmin() throws FileNotFoundException, ClassNotFoundException, IOException {
        System.out.print("Enter username: ");
        String enteredUsername = input.next();
        System.out.print("Enter password: ");
        String enteredPassword = input.next();

        if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
            System.out.println("Admin login successful!");
            // Perform admin actions if needed
            Admin admin=new Admin();
            admin.Admin_main_function();

        } 
        else 
        {
            System.out.println("Invalid username or password for admin.");
            loginAdmin();

        }
    }

    private static  Customers findCustumer() {
        System.out.println("Enter email: ");
        String enteredEmail = input.next();

        for (Customers custumer : UserRegistration.Customer_ArrayList) {
            if (enteredEmail.equals(custumer.getEmail())) {
                return custumer;
            }
        }

        return null;
    }
    private static  brokers findBroker(){
        System.out.println("Enter email: ");
        String enteredEmail = input.next();

        for (brokers broker : UserRegistration.brocker_ArrayList) 
        {
            if (enteredEmail.equals(broker.getEmail())) {
                return broker;
            }
        }

        return null;
    }

    public static void customerExist(Customers customer) throws IOException, FileNotFoundException, ClassNotFoundException {
        if (customer != null) {
            System.out.println("Enter password: ");
            String Password = input.next();

            if (Password.equals(customer.getPassword())) {
                System.out.println("Login successful!");
                // Perform actions after successful login if needed
                current_c= customer;
                current_c.Customer_Main_Function() ;

            } else {
                // handle to break froom login
                System.out.println("Invalid password.");
                customerExist(customer);
            }
        } else {
            System.out.println("User not found.");
            login();
        }
    }
    public static void brokerExist(brokers broker) throws IOException, FileNotFoundException, ClassNotFoundException {
        if (broker != null) {
            System.out.println("Enter password: ");
            String Password = input.next();

            if (Password.equals(broker.getPassword())) 
            {
                System.out.println("Login successful!");
                // Perform actions after successful login if needed
                current_b = broker;  
                current_b.Broker_Main_Function();
                
            } 
            else 
            {
                // handle to break froom login
                System.out.println("Invalid password.");
                brokerExist(broker);
            }
        } else {
            System.out.println("User not found.");
            login();
        }

    }

}
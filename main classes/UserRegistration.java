import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserRegistration 
{
       public static ArrayList  <Requests> Request_ArrayList=new ArrayList<>();
       public static ArrayList <Customers> Customer_ArrayList=new ArrayList<>();
       public static ArrayList<brokers> brocker_ArrayList=new ArrayList<>();
       public static ArrayList<House> house_ArrayList=new ArrayList<>();
       public static ArrayList<deal> deal_ArrayList=new ArrayList<>(); 


    public static void Registration() throws FileNotFoundException, ClassNotFoundException, IOException 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------- Welcome to User Registration System -------------------");

        String userTypeInput;
        String userType;

        do {
            System.out.print("Enter user type (c for Customer / b for Broker): ");
            userTypeInput = input.nextLine();

            switch (userTypeInput) {
                case "c":
                case "C":
                    userType = "Customer";
                    break;
                case "b":
                case "B":
                    userType = "Broker";
                    break;
                default:
                    System.out.println("Invalid user type. Please enter a valid type.");
                    userType = null;
                    break;
            }
        } while (userType == null);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter address: ");
        String address = input.nextLine();
        String email;
        while (true) 
        {
            boolean f=false;
            System.out.println("Enter Email: ");
            email = input.nextLine();
            for (brokers myBrokers : UserRegistration.brocker_ArrayList) 
            {
                f=false;
                if((myBrokers.getEmail()).equals(email))
                {
                    System.out.println("This Email is already found in the system , Enter another .");
                    f=true;
                }
            }
            if(f==true)
            {
              continue;
            }
            for (Customers myCustomers : UserRegistration.Customer_ArrayList) 
            {
                f=false;
                if((myCustomers.getEmail()).equals(email))
                {
                    System.out.println("This Email is already found in the system , Enter another .");
                    f=true;
                    continue;
                }
            }
            if(f==true)
            {
              continue;
            }
            break;
                
        }
        System.out.print("Enter cellphone number: ");
        int cellphone = input.nextInt();

        System.out.print("Enter password: ");
        String password = input.next();
  
        System.out.print("Enter Your ISBN: ");
        int isbn=input.nextInt();

        if (userType.equals("Customer"))
        {
            Customers newCustomer= new Customers(password, userType,  firstName, lastName, address, cellphone, email,isbn);
            Customer_ArrayList.add(newCustomer);
            System.out.println("\nRegistration Successful!");
            System.out.println("User Details:");
            newCustomer.display_user_details();
            LoginSystem.login();
        }
    else 
        {
            brokers newBroker= new brokers(password, userType, firstName, lastName, address, cellphone, email,isbn);
            brocker_ArrayList.add(newBroker);
            System.out.println("\nRegistration Successful!");
            System.out.println("User Details:");
            newBroker.display_user_details();
            LoginSystem.login();
        }
        input.close();
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main 
{
    public static void main (String[] args) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        FileHandler.readCustomersFromFile("customer");
        FileHandler.readBrokerFromFile("Broker");
        UserRegistration.house_ArrayList = FileHandler.readHousesFromFile("House");
        UserRegistration.deal_ArrayList = FileHandler.readDealFromFile("Deal");
        UserRegistration.Request_ArrayList = FileHandler.readRequestsFromFile("Request");

        FileHandler.deleteFile("customer");
        FileHandler.deleteFile("Broker");
        FileHandler.deleteFile("House");
        FileHandler.deleteFile("Deal");
        FileHandler.deleteFile("Request");
        
    
        //call file----------->array

        /*UserRegistration.Request_ArrayList=(files.readArrayList_From_RequestFile("request"));
        UserRegistration.deal_ArrayList=(files.readArrayList_From_DealFile("Deals"));
        UserRegistration.Customer_ArrayList=(files.readArrayList_From_CustomersFile("Customers"));
        UserRegistration.brocker_ArrayList=(files.readArrayList_From_BrokersFile("Brokers"));
        UserRegistration.house_ArrayList=(files.readArrayList_From_HouseFile("Houses"));*/
        int choice;
        Scanner input =new Scanner(System.in) ;

        System.out.println("--------------------------------------Welcom TO House Mangement System--------------------------------------");
        System.out.println("1. Register ");
        System.out.println("2. Log in ");
        System.out.println("3.Exit");
        System.out.println("Enter choice");
        choice=input.nextInt();
        if (choice==1)
        {
        UserRegistration.Registration();
        }
        else if (choice==2)
        {
        LoginSystem.login();
        LoginSystem.current_b.getID();

        }
        else 
        {
         System.out.println("Invalid input please try again");
         main(args);
        }
        input.close();
        
    }
    
}
//import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Admin 
{
  // should be instanced only once (one admin for the system )
  Scanner input =new Scanner(System.in);
  boolean found=false;
  //private String useName;
  //private String Password;

  public void addBroker()
  {
      System.out.println("Enter Brocker First Name: ");
      String fristName = input.next();
      System.out.println("Enter Brocker Last Name: ");
      String lastName = input.next();
      System.out.println("Enter Brocker Address: ");
      String address = input.next();
      String email;
      while (true) 
      {
            boolean f=false;
            System.out.println("Enter Broker Email: ");
            email = input.next();
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
      System.out.println("Enter Brocker Password: ");
      String password = input.next();
      System.out.println("Enter Brocker Cellphone: ");
      int Acellphone = input.nextInt();
      System.out.println("Enter Brocker ISBN: ");     
      int brokerISBN=input.nextInt();
      brokers N_user= new brokers(password, "Broker" , fristName,lastName, address, Acellphone, email,brokerISBN);
      UserRegistration.brocker_ArrayList.add(N_user);
      System.out.println("Broker is added");
      System.out.println("------------------------------------------------------------");
  }
  public boolean removeBroker()
    {
        System.out.println("Please Enter Brocker ID you want to remove ");
        int removedID=input.nextInt();
        for (brokers b : UserRegistration.brocker_ArrayList) 
        {
            if(b.getID()==removedID)
            {
                UserRegistration.brocker_ArrayList.remove(b);
                System.out.println("Brocker is removed.");
                System.out.println("-----------------------------");
                return true;
            }
        }
        System.out.println("Invalid Brocker ID !!");
        removeBroker();
        return false;
    }
  public void addcustomer()
  {
      System.out.println("Enter Customer First Name: ");
       String fristName = input.next();
       System.out.println("Enter Customer Last Name: ");
       String lastName = input.next();
       System.out.println("Enter Customer Address: ");
       String address = input.next();
       String email;
       while (true) 
      {
            boolean f=false;
            System.out.println("Enter Customer Email: ");
            email = input.next();
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
       System.out.println("Enter Customer Password: ");
       String password = input.next();
       System.out.println("Enter Customer Cellphone: ");
      int Acellphone = input.nextInt();
      System.out.println("Enter Customer ISBN: ");     
      int customerISBN=input.nextInt();
      Customers  N_user= new Customers(password, "Customer", fristName,lastName, address,Acellphone, email,customerISBN);
      UserRegistration.Customer_ArrayList.add(N_user);
      System.out.println("Customer is added.");
      System.out.println("-------------------------------");
  }
  public boolean removeCustomer()
  {
        System.out.println("Please Enter User ID you want to remove ");
        int removedID=input.nextInt();
        
        for (Customers c : UserRegistration.Customer_ArrayList) 
        {
            if(c.getID()==removedID)
            {
              UserRegistration.Customer_ArrayList.remove(c);
              System.out.println("User is removed ");
              return true;
            }
        }
        System.out.println(" invalid User ID ");
        removeCustomer();
        return false;
  }
    
   void  viewall_users()
   {
    boolean found=false;
    System.out.println("-------------------------------- ALL CUSTOMERS IN THE SYSTEM --------------------------------");
    for (Customers c : UserRegistration.Customer_ArrayList)
    {
      if(UserRegistration.Customer_ArrayList.isEmpty()==false)
      { 
          System.out.println("ID: "+c.getID());
          System.out.println("First Name: "+c.getFirstName());
          System.out.println("Last Name: "+c.getLastName());
          System.out.println("Address: "+c.getAddress());
          System.out.println("Cellphone: "+c.getCellphone());
          System.out.println("Mail: "+ c.getEmail());
          found=true;
      }
     
    }
    if(found==false)
    {
        System.out.println("NO Customers in the System");
    }
    found=false;
          System.out.println("-------------------------------- ALL Brocker IN THE SYSTEM --------------------------------");
          for (brokers c : UserRegistration.brocker_ArrayList)
          {
            if(UserRegistration.brocker_ArrayList.isEmpty()==false)
            {
              found=true;
              System.out.println("ID: "+c.getID());
              System.out.println("First Name: "+c.getFirstName());
              System.out.println("Last Name: "+c.getLastName());
              System.out.println("Address: "+c.getAddress());
              System.out.println("Cellphone: "+c.getCellphone());
              System.out.println("Mail: "+ c.getEmail());
              System.out.println("---------------------------------------");
            }
          }
        if(found==false)
        {
        System.out.println("NO Customers in the System");
        }
    }
  
  public void Show_All_DoneDeals() 
  {
      System.out.println("Enter Day: ");
      int dd=input.nextInt();
      System.out.println("Enter Month: ");
      int m=input.nextInt();
      System.out.println("Enter Year: ");
      int y=input.nextInt();
      for (deal d : UserRegistration.deal_ArrayList) 
      {
        if((d.daydate==dd)&&(d.monthdate==m)&&(d.yeardate==y))
        {
          System.out.println("Deal ID = "+d.getID());
          System.out.println("Type = "+d.gettype());
          System.out.println("Deposit = "+d.getdeposit());
          System.out.println("Status = "+d.getstatus());
          System.out.println("--------------------------------");
          found=true;
        }
          
      }
      if(found==false)
      {
        System.out.println("NO Done Deals in this Date.");
      }
    
  }

  public void Admin_main_function() throws FileNotFoundException, ClassNotFoundException, IOException
  {
    System.out.println("1.Add Broker");
    System.out.println("2.Remove Broker");
    System.out.println("3.Add Customer");
    System.out.println("4.Remove Customer");
    System.out.println("5.View All Users");
    System.out.println("6.View All Done Requests at specific time");
    System.out.println("7.Exit");
    System.out.println("Enter Choice: ");
    int choice=input.nextInt();
                switch(choice)
                {
                    case 1:
                        addBroker();
                        Admin_main_function();
                        break;
                    case 2:
                        removeBroker();
                        Admin_main_function();
                        break;
                    case 3:
                        addcustomer();
                        Admin_main_function();
                        break;

                    case 4:
                        removeCustomer();
                        Admin_main_function();
                        break;

                    case 5:
                        viewall_users();
                        Admin_main_function();
                        break;
                    case 6:
                       Show_All_DoneDeals();
                       Admin_main_function();
                    break;
                     case 7:
                     FileHandler.writeCustomersToFile(UserRegistration.Customer_ArrayList,"customer");
                     FileHandler.writeBorkerToFile(UserRegistration.brocker_ArrayList, "Broker");
                     FileHandler.writeHouseToFile(UserRegistration.house_ArrayList, "House");
                     FileHandler.writeDealsToFile(UserRegistration.deal_ArrayList, "Deal");
                     FileHandler.writeRequestToFile(UserRegistration.Request_ArrayList, "Request");
                     System.exit(0);
                    break;
                    default:
                        System.out.println("Please,Enter valid choice!!"); 
                        Admin_main_function(); 
                }

  }
    
}
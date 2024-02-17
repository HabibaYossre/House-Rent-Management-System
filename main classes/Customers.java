import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
public class Customers extends User 
{
        private int choice;
        private int id; //we will take it from user in request function
        private int removedID;
        boolean IsFound=false;

        public Customers() {
            super();
        }
    public Customers(String password, String type, String firstName, String lastName, String address, int cellphone, String email,int CustomerIsbn) 
    {
        super(password,"Customer",firstName, lastName, address,cellphone,email,CustomerIsbn);
    }
    public void Edit_Customer_Information(Customers customer) throws FileNotFoundException, ClassNotFoundException, IOException
    { 
                Scanner input =new Scanner(System.in) ;
                System.out.println("What do you want to edit ?");
                System.out.println("1.First Name: "+getFirstName());
                System.out.println("2.Last Name: "+getLastName());
                System.out.println("3.Address: "+getAddress());
                System.out.println("4.Cellphone: "+getCellphone());
                System.out.println("5.Password: "+getPassword());
                System.out.println("6.Back to Main Page");
                System.out.println("Enter Your Choice");
                choice=input.nextInt();
                switch(choice)
                {
                    case 1:
                        System.out.println("Enter Your New First Name: ");
                        customer.setFirstName(input.next());
                        break;
                    case 2:
                        System.out.println("Enter Your New Last Name: ");
                        customer.setLastName(input.next());
                        break;
                    case 3:
                        System.out.println("Enter Your New Address: ");
                        customer.setAddress(input.next());
                        break;

                    case 4:
                        System.out.println("Enter Your New Cellphone: ");
                        customer.setCellphone(input.nextInt());
                        break;

                    case 5:
                        System.out.println("Enter Your New Password:");
                        customer.setPassword(input.next());
                        break;
                    case 6:
                        Customer_Main_Function();
                        break;
                    default:
                        System.out.println("Please,Enter valid choice!!"); 
                        Edit_Customer_Information(customer); 
                }
                input.close();
    }
    
    public void AvailableHouse_Rent()
    {
        for (House house : UserRegistration.house_ArrayList) 
        {
            if((house.getAvailableFor().equals("R"))||(house.getAvailableFor().equals("r")))
            {
                if(house.getHouse_state()==true)
                {
                    System.out.println("ID: "+house.getID());
                    System.out.println("Location: " + house.getLocation());
                    System.out.println("Area: " + house.getArea() + "square meters");
                    System.out.println("Deposit Value: $" + house.getDepositValue());
                    System.out.println("Total Price: $" + house.getTotalPrice());
                    System.out.println("Price Negotiable: " + house.getDepositValue());
                    System.out.println("----------------------------------------");
               }
                
            }
        }
    }
    
    public void AvailableHouse_Buy()
    {
        for (House house : UserRegistration.house_ArrayList) 
        {
            if((house.getAvailableFor().equals("S"))||(house.getAvailableFor().equals("s")))
                {
                   /*  if(house.getHouse_state()==true)
                    { */  
                        System.out.println("ID: "+house.getID());
                        System.out.println("Location: " + house.getLocation());
                        System.out.println("Area: " + house.getArea() + "square meters");
                        System.out.println("Deposit Value: $" + house.getDepositValue());
                        System.out.println("Total Price: $" + house.getTotalPrice());
                        System.out.println("Price Negotiable: " + house.getDepositValue());
                        System.out.println("Available for :"+house.getAvailableFor());
                        System.out.println("----------------------------------------------------");
                   // }
                   
                }
        }
    }

    public void Show_All_Available_Houses()
    {
    for (House house : UserRegistration.house_ArrayList) 
        {
            System.out.println("ID: "+house.getID());
                        System.out.println("Location: " + house.getLocation());
                        System.out.println("Area: " + house.getArea() + "square meters");
                        System.out.println("Deposit Value: $" + house.getDepositValue());
                        System.out.println("Total Price: $" + house.getTotalPrice());
                        System.out.println("Price Negotiable: " + house.getDepositValue());
                        System.out.println("----------------------------------------------------");}
       /*  System.out.println("Available Houses For Renting: ");
        AvailableHouse_Rent();
        System.out.println("Available Houses For Buying: ");
        AvailableHouse_Buy();*/
    }
    public Boolean Request_house()
    {
        Scanner input = new Scanner(System.in);
        boolean IsFound=false;
        System.out.println("1.Request for Buying House");
        System.out.println("2.Request for Renting House");
        choice=input.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("---------------------------------------------------");
                System.out.println("    This is available houses for buying:    ");
                System.out.println("---------------------------------------------------");
                AvailableHouse_Buy();
                System.out.println("Enter House ID You want to buy:");
                id=input.nextInt();

                for (House house: UserRegistration.house_ArrayList) 
                {
                    if(id==house.getID())//we find house id
                    {
                        if((house.getAvailableFor().equals("S"))||(house.getAvailableFor().equals("s")))
                        {
                            if(house.getHouse_state()==true)
                            {
                                house.setHouseState(false);
                                System.out.println("Enter Your ISBN ");
                                int ISBN=input.nextInt();
                                Requests request=new Requests(house.getBrokerID(),house.getID(),ISBN,"Buy",CurrentDate.dayNumber,CurrentDate.monthNumber,CurrentDate.yearNumber);
                                UserRegistration.Request_ArrayList.add(request);
                                System.out.println("Your Request is added.");
                                IsFound=true;
                                return true;
                            }
                            else
                            {
                                System.out.println("This House is not available for Buying Now!!");
                                Request_house();
                            }
                        }
                        else
                        {
                            System.out.println("This House is available for Renting only , Not Buying!!");
                            Request_house();
                        }
                        
                    }
                }
                        
                System.out.println("This House ID is not found");
                Request_house();
                input.close();
                return false;
            
            case 2:
                System.out.println("----------------------------------------");
                System.out.println("This is available houses for Renting:");
                System.out.println("----------------------------------------");
                AvailableHouse_Rent();
                System.out.println("Enter House ID You want to Rent:");
                id=input.nextInt();

                for (House house: UserRegistration.house_ArrayList) 
                {
                    if(id==house.getID()) //we find house id
                    {
                        if((house.getAvailableFor().equals("R"))||(house.getAvailableFor().equals("r")))
                        {   if (house.getHouse_state()==true) 
                            {
                                house.setHouseState(false);
                                System.out.println("Enter Your ISBN: ");
                                int ISBN=input.nextInt();
                                Requests request=new Requests(house.getBrokerID(),house.getID(),ISBN,"Rent",CurrentDate.dayNumber,CurrentDate.monthNumber,CurrentDate.yearNumber);
                                UserRegistration.Request_ArrayList.add(request);
                                System.out.println("Your Request is added ");
                                return true;
                                
                            }
                            else
                            {
                                System.out.println("This House is not available for Renting Now!!");
                                Request_house();
                            }
                        }
                            
                        else
                        {
                            System.out.println("This House avaliable for Buing only not Renting ,Please Enter another House ID!!");
                            Request_house();
                        }
                    }
                }
                System.out.println("This House ID is not found!!");
                Request_house();
            default:
            System.out.println("Enter Valid choice ,Please!!");
            Request_house();
        }
        input.close();
        return false;
    }
    public boolean UpdateRequest()
    { 
        Scanner input = new Scanner(System.in);
        // change his request buy / rent another house
        //1.change state of previous house
        //2.change state of new house
        System.out.println("Enter Your Request ID you want to change :");
        choice=input.nextInt();
        
        for (Requests request : UserRegistration.Request_ArrayList) 
        {
            
            if(request.getRequestId()==choice)
            {
                System.out.println("1.Buy another House");
                System.out.println("2.Rent another House");
                System.out.println("Enter Your Choice :");     
                choice=input.nextInt();
                switch(choice)
                {
                    case 1:
                    System.out.println("Enter House ID You want to Buy :");
                    id=input.nextInt();
                    for (House house : UserRegistration.house_ArrayList) 
                    {
                        if(id==house.getID())
                        {
                            if((house.getAvailableFor().equals("S"))||(house.getAvailableFor().equals("s")))
                            {
                                if(house.getHouse_state()==true)
                                {   //here we change date of request & request type 
                                    for (House myhouse : UserRegistration.house_ArrayList) 
                                        {
                                            if (myhouse.getID()==request.getHouseID()) //find previous house and change his state
                                            {
                                                myhouse.setHouseState(true);
                                            }
                                        }
                                    house.setHouseState(false);      //update new house state
                                    request.setBrockerID(house.getBrokerID());
                                    request.setHouseID(id);
                                    request.RequestType="Buy";
                                    request.day=CurrentDate.dayNumber;
                                    request.month=CurrentDate.monthNumber;
                                    request.year=CurrentDate.yearNumber;
                                    System.out.println("Your change is saved.");
                                    System.out.println("-----------------------------");
                                    return true;
                                }
                                else
                                {
                                    System.out.println("This House is not available for Buying Now!!");
                                    UpdateRequest();
                                }
                            }
                        }
                    }
                    break;
                    case 2:
                        System.out.print("Enter House ID You want to Rent :");
                        id=input.nextInt();
                        for (House house : UserRegistration.house_ArrayList) 
                        {
                            if(id==house.getID())
                            {
                                if((house.getAvailableFor().equals("R"))||(house.getAvailableFor().equals("r")))
                                {
                                    if(house.getHouse_state()==true)
                                    {   //here we change date of request & request type 
                                        for (House myhouse : UserRegistration.house_ArrayList) 
                                        {
                                            if (myhouse.getID()==request.getHouseID()) //find previous house and change his state
                                            {
                                                myhouse.setHouseState(true);
                                            }
                                        }
                                        request.setBrockerID(house.getBrokerID());
                                        //here we change date of request & request type
                                        house.setHouseState(false);//update new house state 
                                        request.setHouseID(id);
                                        request.RequestType="Rent";
                                        request.day=CurrentDate.dayNumber;
                                        request.month=CurrentDate.monthNumber;
                                        request.year=CurrentDate.yearNumber;
                                        System.out.println("Your change is saved.");
                                        System.out.println("-----------------------------");
                                        return true;
                                    }
                                    else
                                    {
                                        System.out.println("This House is not available for Buying Now!!");
                                        UpdateRequest();
                                    }
                            }
                        }
                    }
                    break;
                }
            }
        }
        input.close();
        return false;
    }
    public boolean RemoveRequest()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Request ID you want to remove it");
        removedID=input.nextInt();
        
        for (Requests request : UserRegistration.Request_ArrayList) 
        {
            if(request.getRequestId()==removedID)
            {
                for (House house : UserRegistration.house_ArrayList) 
                {
                    //we change house state 
                    if(house.getID()==request.getHouseID())
                    {
                        house.setHouseState(true);
                    }
                }
                UserRegistration.Request_ArrayList.remove(request);
                System.out.println("Your Request is deleted ");
                return true;
            }
        }
        System.out.println("Enter valid Request ID please!!");
        RemoveRequest();
        input.close();
        return false;
    
    }

    public boolean Show_CustomerRequests()
    {
        boolean found=false;
        for (Requests myRequests : UserRegistration.Request_ArrayList) 
        {
            if(myRequests.getCustomerIsbn()==LoginSystem.current_c.getUserIsbn())
            {
                System.out.println("------------------------------------------------------");
                System.out.println("Request ID: "+myRequests.getRequestId());
                System.out.println("Request Type: "+myRequests.RequestType);
                System.out.println("Customer ISBN: "+myRequests.getCustomerIsbn());
                System.out.println("House ID: "+myRequests.getHouseID());
                System.out.println("-------------------------------------------------------");
                found=true;
            }
        }
        if(found)
        {
            return true;
        }
        System.out.println("You Do not Have any Requests Now.");
        return false;
    }
    public void Customer_Main_Function() throws IOException, FileNotFoundException, ClassNotFoundException
    {
            Scanner input = new Scanner(System.in);
            int choice;
            System.out.println("1.Edit My Informatio");
            System.out.println("2.Show All Available Houses");
            System.out.println("3.Make A Request");
            System.out.println("4.Update A Request");
            System.out.println("5.Delete A Request");
            System.out.println("6.Show My Requests"); //do it later
            System.out.println("7.Exit");
            System.out.println("Enter Choice:");
            choice=input.nextInt();
            switch (choice) 
            {
                case 1:
                    Edit_Customer_Information(LoginSystem.current_c);
                    Customer_Main_Function();
                    break;
                
                case 2:
                    Show_All_Available_Houses();
                    Customer_Main_Function();
                    break;
    
                case 3:
                    Request_house();
                    Customer_Main_Function();
                    break;
    
                case 4:
                    UpdateRequest();
                    Customer_Main_Function();
                    break;
                
                case 5:
                    RemoveRequest();
                    Customer_Main_Function();
                    break;
                case 6:
                    Show_CustomerRequests();
                    Customer_Main_Function();
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
                    System.out.println("Invalid Choice");
                    Customer_Main_Function();
                    break;
        }
        input.close();
    }


}

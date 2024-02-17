import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class brokers extends User {
    Scanner input =new Scanner(System.in) ;
    boolean found=false;
    public brokers(String password, String type, String firstName, String lastName, String address, int cellphone, String email,int brokerISBN)
    {
        super(password, type, firstName, lastName, address,cellphone, email,brokerISBN);
    }
public brokers(){
    super();
}
public void addhouse()
{
    House house=new House();

    System.out.println("Enter House Location: ");
    house.setLocation(input.next());

    System.out.println("Enter House Area: ");
    house.setArea(input.nextInt());

     System.out.println("Enter House Deposit Value: ");
     house.setDepositValue(input.nextInt());

     while (true) 
    {
     System.out.println("Enter House ( R / r ): for rent or ( S / s ): for sell ");
     String s=input.next();
     if (s.equals("R")||s.equals("r")||s.equals("s")||s.equals("S"))
     {
        house.setAvailableFor(s);
        break;
     }
     else 
     {
        System.out.println("Invalid input please try again ");

     }
    }

    System.out.println("Enter House Total Price: ");
    house.setTotalPrice(input.nextDouble());

    while (true) 
    {
    System.out.println("Is House price Negotiable: ( T / F )");
     String s=input.next();
     if (s.equals("T")||s.equals("t")||s.equals("f")||s.equals("F"))
     {
        if (s.equals("T")||s.equals("t"))
        {
        house.setisPriceNegotiable(true);
       
        }
        else 
        {
        house.setisPriceNegotiable(false);
       
        }
        break;
     }
     else 
     {
        System.out.println("Invalid input please try again ");

     }
    }
    house.setBrockerID(LoginSystem.current_b.getID());
    UserRegistration.house_ArrayList.add(house);
    System.out.println("House is add.");
    System.out.println("----------------------------");
}
public boolean removehouse()
{
    // show avaliable houses;
    System.out.println("Enter House ID you want to remove:");
    int id=input.nextInt();
    for ( House house : UserRegistration.house_ArrayList) 
        {
        if(id==house.getID())
        {
            UserRegistration.house_ArrayList.remove(house);
            System.out.println("House is Removed");
            System.out.println("------------------------");
            return true;
        }
        
        }
    System.out.println("This House ID is not found!!");
    removehouse();
    return false;
}

public boolean Show_My_Requests()
{
    for (Requests requests : UserRegistration.Request_ArrayList) 
    {
        //-------------------how to check request broker id with current broker id
        if(LoginSystem.current_b.getID()==requests.getBrokerID())
        {
            System.out.println("Request ID: "+requests.getRequestId());
            System.out.println("Request Type: "+requests.RequestType);
            System.out.println("Customer ISBN: "+requests.getCustomerIsbn());
            System.out.println("House ID: "+requests.getHouseID());
            System.out.println("---------------------------------------------------------------------");
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

public void Show_My_Houses()
{
    boolean found=false;
    for (House house : UserRegistration.house_ArrayList) 
    {
        if(LoginSystem.current_b.getID()==house.getBrokerID())
        {
            house.displayInfo();
            found=true;
        }
    }
    if(found==false)
    {
        System.out.println("You Do Not have any Houses Now.");
    }
}
public void Add_Deals()
{
    //change Request to deal
    System.out.println("Enter Request ID ");
    int id=input.nextInt();
    System.out.println("enter your id");
    int i=input.nextInt();
    for(Requests request : UserRegistration.Request_ArrayList)
    {
        
        if(request.getBrokerID()==i && request.getRequestId()==id)//-------how to check request broker id with current broker id
        {
            System.out.println("Enter Deposit Value: ");
            int mydeposit=input.nextInt();
            deal myDeal =new deal(request.getRequestId(),CurrentDate.dayNumber,CurrentDate.monthNumber,CurrentDate.yearNumber,request.CustomerIsbn,LoginSystem.current_b.getID(),mydeposit,request.RequestType,"Done");
            UserRegistration.deal_ArrayList.add(myDeal);
            UserRegistration.Request_ArrayList.remove(request);
            System.out.println("Deal is Done");
            found=true;
        }
    }
    if(found==false)
    {
        System.out.println("This ID is not Found.");
        Add_Deals();
        
    }
}
public void donedeals()
{
    for (deal d : UserRegistration.deal_ArrayList) 
    {
        //-------how to check request broker id with current broker id
        if((d.getID())==LoginSystem.current_b.getID())
        {
            System.out.println("Deal ID :"+d.getID());
            System.out.println("Deal Date At day : "+d.daydate);
            System.out.println("Deal Date At month : "+d.monthdate);
            System.out.println("Deal Date At year : "+d.yeardate);
            System.out.println("Type :"+d.gettype());
            System.out.println("Deposit :"+d.getdeposit());
            System.out.println("Status : "+d.getstatus());
            System.out.println("-------------------------------------------------");
        }
    }
}
public void searchHouse()
{
    System.out.println("1.Search by Area");
    System.out.println("2.Search by Total Price");
    int choice=input.nextInt();
    switch (choice) 
    {
        case 1:
            System.out.println("Enter House Area:");
            double myarea=input.nextDouble();
            for (House house : UserRegistration.house_ArrayList) 
            {
                if(house.getArea()==myarea)
                {
                    System.out.println("House Location = "+house.getLocation());
                    System.out.println("House Area = "+house.getArea());
                    System.out.println("House Deposit Value = "+house.getDepositValue());
                    System.out.println("House Total Price = "+house.getTotalPrice());
                    System.out.println("House PriceNegotiable  = "+house.isPriceNegotiable());
                    System.out.println("----------------------------------------------------------");
                }
            }
        break;
        case 2:
            System.out.println("Enter House Total Price:");
            double myprice=input.nextDouble();
            for (House house : UserRegistration.house_ArrayList) 
            {
                if(house.getTotalPrice()==myprice)
                {
                    System.out.println("House Location = "+house.getLocation());
                    System.out.println("House Area = "+house.getArea());
                    System.out.println("House Deposit Value = "+house.getDepositValue());
                    System.out.println("House Total Price = "+house.getTotalPrice());
                    System.out.println("House PriceNegotiable  = "+house.isPriceNegotiable());
                    System.out.println("------------------------------------------------------------");
                }
            }
        break;

        default:
        System.out.println("Invalid Choice!!");
        searchHouse();
    }
    
}



public  void Broker_Main_Function() throws IOException, FileNotFoundException, ClassNotFoundException
{
        int choice;
        System.out.println("1.Add House");
        System.out.println("2.Remove House");
        System.out.println("3.Show Received Requests");
        System.out.println("4.Make Deal");
        System.out.println("5.Show My Houses");
        System.out.println("6.Search for House");
        System.out.println("7.Exit"); //log out
        System.out.println("Enter Choice:");
        choice=input.nextInt();
        switch (choice) 
        {
            case 1:
                addhouse();
                Broker_Main_Function();
                break;
            
            case 2:
                removehouse();
                Broker_Main_Function();
                break;

            case 3:
                Show_My_Requests();
                Broker_Main_Function();
                break;

            case 4:
                Add_Deals();
                Broker_Main_Function();
                break;
            
            case 5:
                Show_My_Houses();
                Broker_Main_Function();
                break;
            case 6:
                searchHouse();
                Broker_Main_Function();
                break;
            case 7:
                FileHandler.writeCustomersToFile(UserRegistration.Customer_ArrayList,"customer");
                FileHandler.writeBorkerToFile(UserRegistration.brocker_ArrayList, "Broker");
                FileHandler.writeHouseToFile(UserRegistration.house_ArrayList, "House");
                FileHandler.writeDealsToFile(UserRegistration.deal_ArrayList, "Deal");
                FileHandler.writeRequestToFile(UserRegistration.Request_ArrayList, "Request");
                System.out.println(LoginSystem.current_b.getID()); 
                System.exit(0);
                break;
            
            default:
                System.out.println("Enter Valid choice");
                Broker_Main_Function(); 
                break;
        }
}


}
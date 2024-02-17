//import java.util.ArrayList;

import java.util.Scanner;

public class Requests {
    public int day;
    public int month;
    public int year;

    private int isbn;
    public long  CustomerIsbn;
    private int HouseID;
    public int RequestID;
    public static int NumberOfRequests=0;
    public String RequestType;
    private int BrockerID;
    public Requests() {
        
        this.HouseID = 0; 
        this.RequestType = "Default"; 
        this.CustomerIsbn = 0; 
        this.day = 0; 
        this.month = 0; 
        this.year = 0;
        NumberOfRequests++;
        this.RequestID = NumberOfRequests;
    }
    public Requests(int BrockerID,int HouseID,long isbn, String RequestType,int day,int month,int year)
    {
        this.HouseID=HouseID;
        this.RequestType=RequestType;
        this.CustomerIsbn=isbn;
        this.day=day;
        this.month=month;
        this.year=year;
        for (House h :UserRegistration.house_ArrayList){
            if (h.getID()== HouseID){
                 this.BrockerID= h.getBrokerID();
                 break;
            }
        }  
        NumberOfRequests++;
        RequestID=NumberOfRequests;
    }
    public String toRString() {
        return RequestID + "," + CustomerIsbn + "," + HouseID + "," +
               BrockerID + "," + RequestType + "," + day + "," +
               month + "," + year;
    }
    //Setters
    public void setHouseID(int HouseID)
    {
        this.HouseID=HouseID;
    }
    public void setCustomerISBN(int isbn)
    {
        this.isbn=isbn;
    }
    public void setBrockerID(int BrockerID) 
    {
        this.BrockerID = BrockerID;
    }
    // Getters
    public long getCustomerIsbn()
    {
        return CustomerIsbn;
    }
    public int getHouseID()
    {
        return HouseID;
    }
    public int getRequestId()
    {
        return RequestID;
    }
    public int getBrokerID()
    {
        return BrockerID;
    }
   
    
    public static void checkDate(int day, int month,int year) throws WrongDate
        {
            if (day > 31 ||  month > 12 || year>24)
            throw new WrongDate("Incorrect date, please try again");
        }
   
    public boolean is_same_day(int day1,int month1,int year1, int day, int month , int year)
    {
        return year1==year&&month1==month&&day1==day;
    }
    
    public void view_request() throws WrongDate
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter day: ");
       int d = input.nextInt();
      System.out.println("Enter Month: ");
       int m =input.nextInt();
      System.out.println("Enter Year: ");
      int y =input.nextInt();
      checkDate (d,m,y);
      System.out.println("Request number"+" "+"Request id"+" "+"Request type" );
      for(Requests req : UserRegistration.Request_ArrayList)
      {
            if(req.day==d&&req.month==m&&req.year==y)
            {
                System.out.println("Request ID: "+req.getRequestId());
                System.out.println("Request Type: "+req.RequestType);
                System.out.println("Customer ISBN: "+req.getCustomerIsbn());
                System.out.println("House ID: "+req.HouseID);
                System.out.println("---------------------------------------------------------------------");
                
                
            }
    }
     input.close();    
    }
}

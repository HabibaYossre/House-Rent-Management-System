//import java.util.ArrayList;

import java.io.Serializable;

public class House 
{   
    private String location;
    private double area;
    private double depositValue;
    private String availableFor; 
    private double totalPrice;
    private boolean priceNegotiable;
    private int ID;
    public static int NumberOfHouses=0;
    private boolean HouseState;  // true : available for sell/rent ---false : it already bought or rented
    private int BrockerID;

    public House()
    {
        location=null;
        area=0;
        depositValue=0;
        availableFor= null;
        totalPrice =0;
        priceNegotiable= false;
        //IsRequested=false;   //0 : house is avaible for request
        NumberOfHouses++;
        ID=NumberOfHouses;
        HouseState=true;
    }
    public House(int BrockerID,String location, double area, double depositValue, String availableFor, double totalPrice, boolean priceNegotiable) {
        this.location = location;
        this.area = area;
        this.depositValue = depositValue;
        this.availableFor = availableFor;
        this.totalPrice = totalPrice;
        this.priceNegotiable = priceNegotiable;
        HouseState=true;
        NumberOfHouses++;
        ID=NumberOfHouses;
    }
    public String toHString() {
        return location + "," + area + "," + depositValue + "," +
               availableFor + "," + totalPrice + "," + priceNegotiable + "," +
               ID + "," + HouseState + "," + BrockerID;
    }
    //Setters
    public void setLocation(String location) 
    {
       this.location = location;
    }
    public void setHouseRentState(boolean HouseState) 
    {
        this.HouseState=HouseState;
    }
 
    public void setArea(double area) {
        this.area = area;
    }
    public void setDepositValue(double depositValue) {
       this.depositValue = depositValue;
    }
    public void setAvailableFor (String availableFor){
        this.availableFor=availableFor;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void setBrockerID(int BrockerID) 
    {
        this.BrockerID = BrockerID;
    }
    public void setisPriceNegotiable(boolean priceNegotiable) {
       this.priceNegotiable = priceNegotiable;
    }
    public void setID(int iD) {
         this.ID = iD;
     }
    public void setHouseState(boolean HouseState) 
    {
        this.HouseState = HouseState;
    }
    //Getters
   
    public String getLocation() {
        return location;
    }

    public int getBrokerID()
    {
        return BrockerID;
    }
    public double getArea() {
        return area;
    }
    public double getDepositValue() {
        return depositValue;
    }

    public String getAvailableFor ()
    {
        return availableFor;
    }
    public double getTotalPrice() 
    {
        return totalPrice;
    }

    public boolean isPriceNegotiable() 
    {
        return priceNegotiable;
    }
    public int getID() 
    {
        return ID;
    }
    public boolean getHouse_state()
    {
        return HouseState;
    }
    
    public void displayInfo() 
    {
        System.out.println("Location: " + getLocation());
        System.out.println("Area: " + getArea() + "square meters");
        System.out.println("Deposit Value: $" + getDepositValue());
        System.out.println("Available for Rent: " + getAvailableFor());
        System.out.println("Total Price: $" + getTotalPrice());
        System.out.println("Price Negotiable: " +  isPriceNegotiable());
        System.out.println("House ID: "+getID());
        System.out.println("House state: "+getHouse_state());
        System.out.println("-----------------------------------------------------");
    }
    
}

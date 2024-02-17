
public class deal 
{
  private int ID , deposit ;
  private long brokerISBN;
  private long  customerISBN;
  private String type ,status;
  public int daydate,monthdate,yeardate;
  public deal() {
    this.ID = 0; 
    this.customerISBN = 0; 
    this.brokerISBN = 0; 
    this.deposit = 0; 
    this.type = "Default"; 
    this.status = "Default"; 
    this.daydate = 0; 
    this.monthdate = 0; 
    this.yeardate = 0; 
}
    public deal(int ID,int daydate,int monthdate,int yeardate,long customerISBN,long brokerISBN,
    int deposit,String type,String status)
    {
      this.ID=ID;
      this .customerISBN =customerISBN;
      this.brokerISBN = brokerISBN;
      this.deposit=deposit;
      this.type=type;
      this.status=status;
      this.daydate=daydate;;
      this.monthdate=monthdate;
      this.yeardate=yeardate;
    }
   public String toString() {
      return getID() + ","  + getdeposit() + "," + getcustomerISBN() + "," +getbrokerISBN()  + ","+ gettype() + "," +  getstatus()+","+getdaydate()+","+getmonthdate()+","+getyeardate();
  }
    public int getID(){
    
        return ID;
    }
    
    public long getcustomerISBN()
       {
        return  customerISBN ;
       }
    public long getbrokerISBN(){
        return  brokerISBN ;
       }
    public int getdeposit(){
    
        return deposit;
    }
    public String gettype(){
        return  type ;
       }
    public String getstatus(){
        return  status ;
       }
     
    public void setID(int ID){
    this.ID=ID;
    
    }
    public int getdaydate(){
      return daydate;
  }
  public int getmonthdate(){
      return monthdate;
  }
  public int getyeardate(){
      return yeardate;
  }
public void setDaydate(int daydate) {
      this.daydate = daydate;
  }

  public void setMonthdate(int monthdate) {
      this.monthdate = monthdate;
  }

  public void setYeardate(int yeardate) {
      this.yeardate = yeardate;
  }
   
    public void setcustomerLSBN(long customerISBN){
    this. customerISBN= customerISBN;
    
    }
    public void setbrokerISBN(int brokerISBN){
    this.brokerISBN= brokerISBN;
    
    }
    public void setdeposit(int deposit){
    this.deposit=deposit;
    
    }
      public void settype(String type){
    this.type= type;
    
    }
        public void setstatus(String status){
    this. status= status;
    
    }
}
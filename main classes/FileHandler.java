/*import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public static void writeCustomersToFile(ArrayList<Customers> customers, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Customers customer : customers) {
                writer.println(customer.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeBorkerToFile(ArrayList<brokers> broker, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (brokers brroker : broker) {
                writer.println(brroker.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeHouseToFile(ArrayList<House> house, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (House housse : house) {
                writer.println(housse.toHString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 public static void writeDealsToFile(ArrayList<deal> Deal, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (deal deall : Deal) {
                writer.println(deall.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static void writeRequestToFile(ArrayList<Requests> request, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Requests Request : request) {
                writer.println(Request.toRString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void deleteFile(String filePath) {
        File fileToDelete = new File(filePath);
        if (fileToDelete.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Customers> readCustomersFromFile(String filePath) {
        ArrayList<Customers> customers = UserRegistration.Customer_ArrayList;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                Customers customer = new Customers();
                customer.setID(Integer.parseInt(data[0]));
                customer.setUserISBN(Integer.parseInt(data[1]));
                customer.setPassword(data[2]);
                customer.setType(data[3]);
                customer.setFirstName(data[4]);
                customer.setLastName(data[5]);
                customer.setAddress(data[6]);
                customer.setEmail(data[7]);

                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
        
    }
    public static ArrayList<brokers> readBrokerFromFile(String filePath) {
        ArrayList<brokers> b = UserRegistration.brocker_ArrayList;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                brokers customer = new brokers();
                customer.setID(Integer.parseInt(data[0]));
                customer.setUserISBN(Integer.parseInt(data[1]));
                customer.setPassword(data[2]);
                customer.setType(data[3]);
                customer.setFirstName(data[4]);
                customer.setLastName(data[5]);
                customer.setAddress(data[6]);
                customer.setEmail(data[7]);

                b.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return b;
        
    }
    public static ArrayList<Requests> readRequestsFromFile(String filePath) {
        ArrayList<Requests> requests = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                Requests request = new Requests();
                request.RequestID = Integer.parseInt(data[0]);
                request.CustomerIsbn = Integer.parseInt(data[1]);
                request.setHouseID(Integer.parseInt(data[2]));
                request.setBrockerID(Integer.parseInt(data[3])); 
                request.RequestType = data[4];
                request.day = Integer.parseInt(data[5]);
                request.month = Integer.parseInt(data[6]);
                request.year = Integer.parseInt(data[7]);

                requests.add(request);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return requests;
    }
    public static ArrayList<House> readHousesFromFile(String filePath) {
        ArrayList<House> houses = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                    House house = new House();
                    house.setLocation(data[0]);
                    house.setArea(Double.parseDouble(data[1]));
                    house.setDepositValue(Double.parseDouble(data[2]));
                    house.setAvailableFor(data[3]);
                    house.setTotalPrice(Double.parseDouble(data[4]));
                    house.setisPriceNegotiable(Boolean.parseBoolean(data[5]));
                    house.setID(Integer.parseInt(data[6]));
                    house.setHouseState(Boolean.parseBoolean(data[7]));
                    house.setBrockerID(Integer.parseInt(data[8]));
                    houses.add(house);
                
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error reading houses from file: " + filePath);
            e.printStackTrace();
        }
       System.out.println("house dreaded");
        return houses;
    }
    public static ArrayList<deal> readDealFromFile(String filePath) {
        ArrayList<deal> d = UserRegistration.deal_ArrayList;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                deal customer = new deal();
                customer.setID(Integer.parseInt(data[0]));
                customer.setcustomerLSBN(Integer.parseInt(data[1]));
                customer.setdeposit(Integer.parseInt(data[2]));
                customer.setbrokerISBN(Integer.parseInt(data[3]));
                customer.settype(data[4]);
                customer.setstatus(data[5]);
                customer.setDaydate(Integer.parseInt(data[6]));
                customer.setMonthdate(Integer.parseInt(data[7]));
                customer.setYeardate(Integer.parseInt(data[8]));

                d.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return d;

    }
}

/*import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {

    public static void writeCustomersToFile() {
         String filePath = "customer_data.dat";

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Customers c : UserRegistration.Customer_ArrayList){
             dataOutputStream.writeInt(c.getID());
             dataOutputStream.writeInt(c.getCellphone());
             dataOutputStream.writeInt(c.getUserIsbn());
             dataOutputStream.writeUTF(c.getAddress());
             dataOutputStream.writeUTF(c.getEmail());
             dataOutputStream.writeUTF(c.getFirstName());
             dataOutputStream.writeUTF(c.getLastName());
             dataOutputStream.writeUTF(c.getPassword());
             dataOutputStream.writeUTF(c.getType());
            //dataOutputStream.writeBoolean(true);
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readCustomersFromFile() {
        String filePath = "customer_data.dat";
    
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    int id = dataInputStream.readInt();
                    int cellphone = dataInputStream.readInt();
                    int userIsbn = dataInputStream.readInt();
                    String address = dataInputStream.readUTF();
                    String email = dataInputStream.readUTF();
                    String firstName = dataInputStream.readUTF();
                    String lastName = dataInputStream.readUTF();
                    String password = dataInputStream.readUTF();
                    String type = dataInputStream.readUTF();
    
                    Customers customer = new Customers(password, type, firstName, lastName, address, cellphone, email, userIsbn);
                    customer.setID(id);
    
                    // Add the read customer to the Customer_ArrayList
                    UserRegistration.Customer_ArrayList.add(customer);
                } catch (EOFException e) {
                    // End of file reached, exit the loop
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
    
            System.out.println("Data read from file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}*/


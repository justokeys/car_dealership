import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

    private static String file_Path = "src/main/resources/inventory.csv";

    public Dealership getDealerShip(){

        Dealership theDealership = null;

        try{
            BufferedReader inventoryFile = new BufferedReader(new FileReader(file_Path));
            String dealerInventoryFile = inventoryFile.readLine();

            if(dealerInventoryFile != null){
                String[] dealershipParts = dealerInventoryFile.split("\\|");
                String name = dealershipParts[0];
                String address = dealershipParts[1];
                String phone = dealershipParts[2];

                theDealership = new Dealership(name,address,phone);
            }
            String vehicleInfo;

            while((vehicleInfo = inventoryFile.readLine()) != null){


                Vehicle theVehicle = getVehicle(vehicleInfo);

                //add the vehicle to the inventory
                assert theDealership != null;
                theDealership.addVehicle(theVehicle);

            }

            inventoryFile.close();

        } catch (Exception e) {
            System.out.println("Error Reading file");

        }

        return theDealership;


    }

    private static Vehicle getVehicle(String vehicleInfo) {
        String[] vehicleParts = vehicleInfo.split("\\|");
        String vin = vehicleParts[0];
        int year = Integer.parseInt(vehicleParts[1]);
        String make = vehicleParts[2];
        String model = vehicleParts[3];
        String type = vehicleParts[4];
        String color = vehicleParts[5];
        int odometer = Integer.parseInt(vehicleParts[6]);
        double price = Double.parseDouble(vehicleParts[7]);

        //create the vehicle
        return new Vehicle(vin,year, make, model, type, color, odometer, price);
    }

    public void  saveDealership(Dealership dealership){

    }

}

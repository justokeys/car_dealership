import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public Scanner thescanner = new Scanner(System.in);

    public void processGetByPriceRequest(Dealership dealership){

        System.out.println("Whats is the min price?");
        double min = thescanner.nextDouble();
        System.out.println("Whats is the min price?");
       double max = thescanner.nextDouble();
        List<Vehicle> results = dealership.getVehiclesByPrice(min,max);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results){
            System.out.println(matchingVehicle.getYear() + " " + matchingVehicle.getMake() + " " + matchingVehicle.getModel() + " - $" + matchingVehicle.getPrice());
        }


    }

    public void processGetVehiclesByMakeModel(Dealership dealership){
        System.out.println("Whats is the make?");
        String make = thescanner.nextLine();
        System.out.println("Whats is the min model?");
        String model = thescanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByMakeModel(make,model);

        for (Vehicle matchingVehicle : results){
            System.out.println(matchingVehicle.toString());
        }





    }


}

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
        System.out.println("Whats is the model?");
        String model = thescanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByMakeModel(make,model);
        System.out.println(" ------ Matching result ------");

        for (Vehicle matchingVehicle : results){
            System.out.println(matchingVehicle.toString());
        }





    }

    public void processGetVehiclesByYear(Dealership dealership){

        System.out.println("Whats is the min price?");
        int min = thescanner.nextInt();
        System.out.println("Whats is the min price?");
         int max = thescanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByYear(min,max);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results){
            System.out.println(matchingVehicle.toString());
        }





    }

    public void processGetVehiclesByColor(Dealership dealership){

        System.out.println("What color are you looking for?");
        String color = thescanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByColor(color);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results){
            System.out.println(matchingVehicle.toString());
        }



    }

    public void processGetVehiclesByMileage(Dealership dealership){

        System.out.println("Whats is the min mileage?");
        int min = thescanner.nextInt();
        System.out.println("Whats is the max mileage?");
        int max = thescanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByMileage(min,max);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results){
            System.out.println(matchingVehicle.toString());
        }


    }


}

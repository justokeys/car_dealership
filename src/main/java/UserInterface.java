import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner thescanner = new Scanner(System.in);
    private  Dealership dealership;
    public void display() {

        this.init();



        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=================================");
            System.out.println("      Dealership Main Menu       ");
            System.out.println("=================================");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - Add vehicle");
            System.out.println("8 - Remove vehicle");
            System.out.println("99 - Quit");
            System.out.println("Enter your choice: ");

            int choice = thescanner.nextInt();
            thescanner.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest(dealership);
                    break;
                case 2:
                    processGetVehiclesByMakeModel(dealership);
                    break;
                case 3:
                    processGetVehiclesByYear(dealership);
                    break;
                case 4:
                    processGetVehiclesByColor(dealership);
                    break;
                case 5:
                    processGetVehiclesByMileage(dealership);
                    break;
                case 6:
                    processGetVehiclesByType(dealership);
                    break;
                case 7:
                    processedVehicleRequest(dealership);
                    break;
                case 8:
                    proccessRemoveVehicleRequest(dealership);
                    break;
                case 99:
                    isRunning = false;
                    System.out.println("Exiting the application... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

        private void init(){

        DealershipFileManager fileManager = new DealershipFileManager();

        this.dealership = fileManager.getdealerShip();
    }

    public void processGetByPriceRequest(Dealership dealership) {

        System.out.println("Whats is the min price?");
        double min = thescanner.nextDouble();
        System.out.println("Whats is the min price?");
        double max = thescanner.nextDouble();
        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results) {
            System.out.println(matchingVehicle.getYear() + " " + matchingVehicle.getMake() + " " + matchingVehicle.getModel() + " - $" + matchingVehicle.getPrice());
        }


    }

    public void processGetVehiclesByMakeModel(Dealership dealership) {
        System.out.println("Whats is the make?");
        String make = thescanner.nextLine();
        System.out.println("Whats is the model?");
        String model = thescanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        System.out.println(" ------ Matching result ------");

        for (Vehicle matchingVehicle : results) {
            System.out.println(matchingVehicle.toString());
        }


    }

    public void processGetVehiclesByYear(Dealership dealership) {

        System.out.println("Whats is the min price?");
        int min = thescanner.nextInt();
        System.out.println("Whats is the min price?");
        int max = thescanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByYear(min, max);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results) {
            System.out.println(matchingVehicle.toString());
        }


    }

    public void processGetVehiclesByColor(Dealership dealership) {

        System.out.println("What color are you looking for?");
        String color = thescanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByColor(color);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results) {
            System.out.println(matchingVehicle.toString());
        }


    }

    public void processGetVehiclesByMileage(Dealership dealership) {

        System.out.println("Whats is the min mileage?");
        int min = thescanner.nextInt();
        System.out.println("Whats is the max mileage?");
        int max = thescanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByMileage(min, max);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results) {
            System.out.println(matchingVehicle.toString());
        }


    }

    public void processGetVehiclesByType(Dealership dealership) {

        System.out.println("What color are you looking for?");
        String type = thescanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByType(type);

        System.out.println(" ------ Matching result ------");
        for (Vehicle matchingVehicle : results) {
            System.out.println(matchingVehicle.toString());
        }


    }

    public void processedVehicleRequest(Dealership dealership){
        System.out.print("Enter VIN: ");
        String vin = thescanner.nextLine();
        thescanner.nextLine();

        System.out.print("Enter year: ");
        int year = thescanner.nextInt();
        thescanner.nextLine();

        System.out.print("Enter make: ");
        String make = thescanner.nextLine();

        System.out.print("Enter model: ");
        String model = thescanner.nextLine();

        System.out.print("Enter type: ");
        String type = thescanner.nextLine();

        System.out.print("Enter color: ");
        String color = thescanner.nextLine();

        System.out.print("Enter mileage: ");
        int mileage = thescanner.nextInt();

        System.out.print("Enter price: ");
        double price = thescanner.nextDouble();

        Vehicle newV = new Vehicle(vin,year,make,model,type,color,mileage,price);
        dealership.addVehicle(newV);
        // got this from you Eric I was lost
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership);
        System.out.println("Success! new vehicle added.");

    }

    public void   proccessRemoveVehicleRequest(Dealership dealership){


        System.out.println("To remove vehicle enter vin :");
        String vin = thescanner.nextLine();

        boolean removed = dealership.removeVehicleByVin(vin);

        if (removed) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }




    }




}

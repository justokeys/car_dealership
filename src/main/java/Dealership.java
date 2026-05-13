import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> vehicleMatch = new ArrayList<>();
        for (Vehicle v : this.inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                vehicleMatch.add(v);
            }
        }

        return vehicleMatch;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> makeAndModelMatch = new ArrayList<>();
        for (Vehicle v : this.inventory){
            String vehicleMake = v.getMake();
            String vehicleModel = v.getMake();
            if(vehicleMake.toLowerCase().contains(make.toLowerCase()) && vehicleModel.toLowerCase().contains(model.toLowerCase())){
                makeAndModelMatch.add(v);

            }

        }

        return makeAndModelMatch;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> vehicleMatch = new ArrayList<>();
        for (Vehicle v : this.inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                vehicleMatch.add(v);
            }
        }

        return vehicleMatch;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> vehicleMatch= new ArrayList<>();
        for (Vehicle v : this.inventory){
            String vehicleMake = v.getColor();
            if(vehicleMake.toLowerCase().contains(color.toLowerCase())){
                vehicleMatch.add(v);

            }

        }

        return vehicleMatch;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> vehicleMatch = new ArrayList<>();
        for (Vehicle v : this.inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                vehicleMatch.add(v);
            }
        }

        return vehicleMatch;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> vehicleMatch= new ArrayList<>();
        for (Vehicle v : this.inventory){
            String type = v.getVehicleType();
            if(type.toLowerCase().contains(vehicleType.toLowerCase())){
                vehicleMatch.add(v);

            }

        }

        return vehicleMatch;
    }
    List<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }






}

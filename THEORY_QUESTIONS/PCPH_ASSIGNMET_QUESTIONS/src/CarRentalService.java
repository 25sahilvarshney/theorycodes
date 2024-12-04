import java.util.ArrayList;
import java.util.List;

class Car {
    private int carId;
    private String model;
    private String brand;
    private boolean isAvailable;

    // Constructor
    public Car(int carId, String model, String brand) {
        this.carId = carId;
        this.model = model;
        this.brand = brand;
        this.isAvailable = true; // Cars are available by default
    }

    // Getters
    public int getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to rent the car
    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Car " + model + " rented successfully.");
        } else {
            System.out.println("Car " + model + " is not available for rent.");
        }
    }

    // Method to return the car
    public void returnCar() {
        isAvailable = true;
        System.out.println("Car " + model + " returned successfully.");
    }

    @Override
    public String toString() {
        return "Car ID: " + carId + ", Model: " + model + ", Brand: " + brand + ", Available: " + isAvailable;
    }
}

public class CarRentalService {
    private List<Car> carList;

    public CarRentalService() {
        carList = new ArrayList<>();
    }

    // Method to add a car to the rental service
    public void addCar(Car car) {
        carList.add(car);
    }

    // Method to rent a car by carId
    public void rentCar(int carId) {
        for (Car car : carList) {
            if (car.getCarId() == carId) {
                car.rent();
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found.");
    }

    // Method to return a car by carId
    public void returnCar(int carId) {
        for (Car car : carList) {
            if (car.getCarId() == carId) {
                car.returnCar();
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found.");
    }

    // Method to list all available cars
    public void listAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : carList) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public static void main(String[] args) {
        CarRentalService rentalService = new CarRentalService();

        // Adding cars to the rental service
        rentalService.addCar(new Car(1, "Model S", "Tesla"));
        rentalService.addCar(new Car(2, "Civic", "Honda"));
        rentalService.addCar(new Car(3, "Mustang", "Ford"));

        // Listing available cars
        rentalService.listAvailableCars();

        // Renting a car
        rentalService.rentCar(1); // Rent Tesla Model S
        rentalService.rentCar(2); // Rent Honda Civic

        // Trying to rent the same car again
        rentalService.rentCar(1); // Should indicate it's not available

        // Listing available cars after renting
        rentalService.listAvailableCars();

        // Returning a car
        rentalService.returnCar(1); // Return Tesla Model S

        // Listing available cars after returning
        rentalService.listAvailableCars();
    }
}
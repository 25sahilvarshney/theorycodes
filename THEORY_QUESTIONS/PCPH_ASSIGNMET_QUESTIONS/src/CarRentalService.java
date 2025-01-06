import java.util.ArrayList;
import java.util.List;

class Car {
    private int carId;
    private String model;
    private String brand;
    private boolean isAvailable;
    public Car(int carId, String model, String brand) {
        this.carId = carId;
        this.model = model;
        this.brand = brand;
        this.isAvailable = true;
    }
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
    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Car " + model + " rented successfully.");
        } else {
            System.out.println("Car " + model + " is not available for rent.");
        }
    }
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
    public void addCar(Car car) {
        carList.add(car);
    }
    public void rentCar(int carId) {
        for (Car car : carList) {
            if (car.getCarId() == carId) {
                car.rent();
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found.");
    }
    public void returnCar(int carId) {
        for (Car car : carList) {
            if (car.getCarId() == carId) {
                car.returnCar();
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found.");
    }
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
        rentalService.addCar(new Car(1, "Model S", "Tesla"));
        rentalService.addCar(new Car(2, "Civic", "Honda"));
        rentalService.addCar(new Car(3, "Mustang", "Ford"));
        rentalService.listAvailableCars();
        rentalService.rentCar(1);
        rentalService.rentCar(2);
        rentalService.rentCar(1);
        rentalService.listAvailableCars();
        rentalService.returnCar(1);
        rentalService.listAvailableCars();
    }
}
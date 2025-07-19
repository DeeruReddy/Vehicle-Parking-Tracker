import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Car {
    private String licensePlate;
    private String model;
    private String color;
    private String owner;
    private LocalDateTime entryTime;

    public Car(String licensePlate, String model, String color, String owner, LocalDateTime entryTime) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.owner = owner;
        this.entryTime = entryTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return String.format("License: %s | Model: %s | Color: %s | Owner: %s | Parked At: %s",
                licensePlate, model, color, owner,
                entryTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

class ParkingSlot {
    private Car parkedCar;

    public boolean isOccupied() {
        return parkedCar != null;
    }

    public void parkCar(Car car) {
        this.parkedCar = car;
    }

    public Car removeCar() {
        Car car = this.parkedCar;
        this.parkedCar = null;
        return car;
    }

    public Car getParkedCar() {
        return parkedCar;
    }
}

public class ParkingSystem {
    private static final double RATE_PER_MINUTE = 40.0 / 60.0;
    private static ParkingSlot[] slots;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of parking slots: ");
        int totalSlots = sc.nextInt();
        sc.nextLine(); 

        slots = new ParkingSlot[totalSlots];
        for (int i = 0; i < totalSlots; i++) {
            slots[i] = new ParkingSlot();
        }

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Park a car");
            System.out.println("2. Remove a car");
            System.out.println("3. View parked cars");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    parkCar(sc);
                    break;
                case 2:
                    removeCar(sc);
                    break;
                case 3:
                    viewParkedCars();
                    break;
                case 4:
                    System.out.println("Exiting the parking system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void parkCar(Scanner sc) {
        int availableIndex = -1;

        for (int i = 0; i < slots.length; i++) {
            if (!slots[i].isOccupied()) {
                availableIndex = i;
                break;
            }
        }

        if (availableIndex == -1) {
            System.out.println("Sorry, no parking slots available.");
            return;
        }

        System.out.print("Enter the license plate number: ");
        String license = sc.nextLine();
        System.out.print("Enter the car model: ");
        String model = sc.nextLine();
        System.out.print("Enter the car color: ");
        String color = sc.nextLine();
        System.out.print("Enter the owner's name: ");
        String owner = sc.nextLine();

        LocalDateTime entryTime = LocalDateTime.now();
        Car car = new Car(license, model, color, owner, entryTime);
        slots[availableIndex].parkCar(car);

        System.out.println("✅ Car parked successfully at slot " + (availableIndex + 1));
    }

    public static void removeCar(Scanner sc) {
        System.out.print("Enter the license plate number of the car to remove: ");
        String plate = sc.nextLine();
        int foundIndex = -1;

        for (int i = 0; i < slots.length; i++) {
            Car car = slots[i].getParkedCar();
            if (car != null && car.getLicensePlate().equalsIgnoreCase(plate)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("❌ Car not found in the parking lot.");
            return;
        }

        Car car = slots[foundIndex].removeCar();
        LocalDateTime exitTime = LocalDateTime.now();

        Duration duration = Duration.between(car.getEntryTime(), exitTime);
        long minutes = duration.toMinutes();
        if (minutes == 0) minutes = 1; // atleast 1 minute charge for parking

        double fee = minutes * RATE_PER_MINUTE;

        System.out.println("✅ Car removed successfully from slot " + (foundIndex + 1));
        System.out.println("🕒 Parking Duration: " + minutes + " minute(s)");
        System.out.printf("💰 Parking Fee: ₹%.2f\n", fee);
    }

    public static void viewParkedCars() {
        boolean hasCars = false;
        for (int i = 0; i < slots.length; i++) {
            Car car = slots[i].getParkedCar();
            if (car != null) {
                System.out.println("Slot " + (i + 1) + ": " + car);
                hasCars = true;
            }
        }

        if (!hasCars) {
            System.out.println("There are no parked cars.");
        }
    }
}

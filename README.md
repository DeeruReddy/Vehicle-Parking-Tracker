# 🚗 Car Parking System (Mini Java Project)

Welcome to the **Car Parking System using Java!** 🎉  
This is a console-based Java application that helps manage car parking effectively by tracking parking availability, logging vehicle details, and accurately calculating parking fees based on real-time duration.

---

## Introduction

This system simulates the working of a basic car parking area. It uses modern **Java features and OOP principles** to provide a modular, extensible structure. The parking fee is calculated in **real-time** using the system clock — you’re charged based on **minutes parked** at the rate of **₹40/hour (₹0.67/minute)**.

Perfect for beginners and intermediate Java developers, this mini project showcases how fundamental programming concepts can be applied to a real-world scenario in a structured and meaningful way.

---

## Key Features

- **Car Details Captured**: License plate, model, color, and owner name
- **Object-Oriented Design**: Utilizes `Car` and `ParkingSlot` classes
- **Real-Time Parking Duration**: Accurate time tracked with `LocalDateTime`
- **Fee Calculation**: Charges ₹0.67 per minute (₹40 per hour)
- **Live Status View**: View all currently parked cars and their parking time
- **Interactive CLI Menu**: Intuitive menu with helpful prompts

---

## Technologies & Concepts Used

- Java 8+ (`java.time` API)
- Object-Oriented Programming
- Arrays for slot management
- Scanner for user input
- Duration & DateTime formatting
- Basic calculations (rounding, rate logic)

---

## How to Run the Program

### Using Terminal or Command Line

1. **Save the code** as `ParkingSystem.java`
2. **Compile the program**
   ```
   javac ParkingSystem.java
   ```
3. **Run the program**
   ```
   java ParkingSystem
   ```

---

## Sample Input & Output

```
Enter the total number of parking slots: 2

What would you like to do?
1. Park a car
2. Remove a car
3. View parked cars
4. Exit

Enter your choice: 1
Enter the license plate number: KA01AB1234
Enter the car model: Sedan Type - Honda City Plus
Enter the car color: White
Enter the owner's name: Deeraj
✅ Car parked successfully at slot 1

(After a few minutes...)

Enter your choice: 2
Enter the license plate number of the car to remove: KA01AB1234
✅ Car removed successfully from slot 1
Parking Duration: 1 minute(s)
Parking Fee: ₹0.67
```

---

## Structure

| Class        | Responsibility                                     |
|--------------|----------------------------------------------------|
| `Car`        | Stores car info: license, model, color, owner, entry time |
| `ParkingSlot`| Logic to park or remove a car from a slot          |
| `ParkingSystem` | Main program containing menu, logic, and calculations |

---

## Fee Calculation Logic

> **Rate per hour:** ₹40  
> **Fee per minute:** ₹40 / 60 = ₹0.6667, rounded to ₹0.67/min

- 1 minute  → ₹0.67  
- 15 minutes → ₹10.00  
- 60 minutes → ₹40.00  
- 90 minutes → ₹60.00  

> ⚠ Minimum charge applies for 1 minute even if car is removed instantly

---

## 🚀 Future Enhancements

Some planned future upgrades:

- **Persistent Storage** using files or lightweight database (like SQLite)  
- **Role-Based Login** for admin vs user access control  
- **GUI Integration** using JavaFX or Swing

---

## Author

**Deeraj Reddy**  
GitHub: [@DeeruReddy](https://github.com/DeeruReddy)

---

## License

This project is licensed under the [MIT License](LICENSE).  
Feel free to download, modify, and use it with attribution.

---

**Happy Coding! 👨‍💻**

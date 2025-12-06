˚ ☾⭒.˚Sleep Tight, Book Right⋆｡ﾟ☁︎｡⋆｡ ﾟ

            three-syur
             IT-2109
             
    DE TORRES, GIBSON JAKE 
    MACATANGAY, ARA NIRIZ
    YACO, RENDELEE CYRIL R.
             
₊˚🖇️✩ OVERVIEW‧ ₊˚📖

Sleep Tight, Book Right is a console-based Java application that serves
as a hotel room reservation and booking management system. The program
allows users to select floors, choose available rooms, and schedule
their bookings based on the day of the week.

The system enables tourists or customers to reserve a specific room
by inputting the preferred floor, room number, and weekday. The
application automatically checks for conflicts to ensure that no
duplicate bookings are made for the same room on the same day. Each
successful reservation displays a complete summary including the
tourist’s name, room details, booking day, and total fee.

An administrative panel is also included, allowing the admin to:

1. View all confirmed bookings.
2. Cancel existing reservations.
3. Monitor room availability across all floors.

This project demonstrates the application of Object-Oriented Programming
(OOP) principles such as encapsulation, inheritance, method overriding,
and modular class structure. It also utilizes ArrayLists for storing
bookings and ensures a clear, organized data flow in a terminal-based
environment.

Sleep Tight, Book Right aims to simulate a simple yet fully functional
hotel booking system suitable for learning and practicing OOP concepts
in Java.

🧩OOP Concepts Applied (Sleep Tight, Book Right)

🔒Encapsulation *ੈ✩‧₊˚

In *Sleep Tight, Book Right*, encapsulation is shown by keeping hotel-related data private inside classes such as `Hotel`, `Room`, and `Booking`. Important information like room rates, floor numbers, tourist names, and booking schedules is protected using private fields. These values cannot be modified directly from outside the class. Instead, the system uses getters and controlled methods to access and update the data. This prevents accidental changes to room rates or bookings and ensures that only valid, authorized operations can affect the hotel records.


🧬Inheritance✧₊⁺.˚୨ৎ

The system demonstrates inheritance through the relationship between `Hotel` and `Room`. The `Room` class extends the `Hotel` class, allowing it to inherit properties such as the hotel name and floor rates. This means all rooms automatically gain access to hotel information without rewriting the same code. The subclass (`Room`) can also add its own specific attributes, such as floor number, room number, and the corresponding room rate. This reduces redundancy and promotes cleaner code.

 🎭Polymorphism✩⋆☾⋆⁺₊✧

Polymorphism appears in the system through overridden and reusable methods. For example, the `showBookingSummary()` method displays booking details based on the specific booking object calling it. The system also shows different outputs for room availability depending on whether a room is already reserved or still open for booking. The program uses a `switch` expression to convert weekday numbers into weekday names, allowing the same method to produce different results depending on the input.


 🧱 Abstraction₊˚⊹ᰔ

Abstraction is applied by hiding complex booking validation and room-checking processes inside simple methods. The system internally handles tasks such as detecting duplicate bookings, scanning for available rooms, and validating floor or room selections. Instead of writing the logic repeatedly in the main program, methods like `isDuplicate()` and room-availability loops perform the detailed work behind the scenes. This keeps the menu system and user interface clean while the essential logic remains neatly organized inside the appropriate classes.


🧩Program Structure (Sleep Tight, Book Right) 𐙚⋆°.⋆♡




👤User Features (Tourist / Customer)


  View System Foreword
  
  Book a Room (Select Floor → Select Room Number → Select Weekday)
  
  View Room Rates per Floor
  
  View Booking Summary
  
  Check Room Availability by Day
  
  Manage Personal Booking (View Existing Reservation)
  
  Logout




👨‍💼Admin Features 𐙚⋆°｡⋆♡


  Login as Admin
  
  View All Bookings
  
  Cancel a Booking
  
  View Hotel Information (Floors, Rates, Rooms)
  
  Logout Admin Mode



 🛏️Hotel System Features ⋆ ˚｡⋆୨୧˚
 

  Display Hotel Information
  
  Floor Rates Overview
  
  Room Availability Checker
  
  Booking Conflict Detection (Prevents double-booking)
  
  Organized Weekly Scheduling System
  
  Safe Input Validation (Floors, Rooms, Days)


  

 ℹ️General System Options✧˖°.
 

  Help / Assistance
  
  User Guide (How to Book a Room)
  
  Importance of Reservation Scheduling
  
  Emergency Contact List (Hotel Staff, Front Desk Numbers)
  
  Developer / IT Support Contact
  
  Exit System



  

 📂Project Structure⋆｡‧˚ʚɞ˚‧｡⋆

|   File                               | Description|
| ------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------- |
| Main.java                            | Main Entry Point. Handles console UI, menus, navigation, booking process, and admin interface.                                        |
| Hotel.java                           | Stores hotel information, floor rates, and total floors. Provides methods to view hotel details.                                      |
| Room.java                            | Extends `Hotel`. Represents a specific room with floor number, room number, and corresponding room rate.                              |
| Booking.java                         | Manages booking details such as tourist name, floor, room number, and weekday. Shows booking summaries and detects booking conflicts. |
| Person.java (optional)               | Abstract Base Class. Can be used for different user roles like Admin or Tourist, enforcing attributes and `displayMenu()` structure.  |
| Admin.java (optional)                | Handles admin login, viewing, and cancelling bookings, and monitoring room availability.                                              |
| InputValidator.java.(optional)       | Utility class for validating user input (floor numbers, room numbers, weekdays).                                                      |


 💻Features ⋆𐙚 ̊.

👤User / Tourist Features 𐙚⋆°.⋆♡

View System Foreword: Displays the system introduction and purpose.
  Book a Room: Allows the user to select floor, room number, and weekday to reserve a room.
  View Room Rates per Floor: Shows daily rates for all floors.
  View Booking Summary: Displays details of current or past bookings.
  Check Room Availability: Displays available and booked rooms for a selected day.
  View Hotel Information: Displays hotel name, floors, and rates.
  Logout: Exits the user menu.

👨‍💼Admin Feature °❀⋆.ೃ࿔*
  Admin Login: Access the admin panel with credentials.
  View All Bookings: Shows all bookings in the system.
  Cancel a Booking: Allows the admin to remove a booking.
  Monitor Room Availability: Shows room availability across all floors and days.
  Logout Admin Mode: Exits admin panel.

 ℹ️System Features ❀⋆.ೃ࿔*:･

  Help / Assistance: Displays guidance on how to use the system.
  User Guide: Instructions for booking and managing reservations.
  Emergency Contacts: Displays hotel emergency numbers (e.g., Front Desk, Security).
  Developer Contact Form: For system issues or feedback.
  Exit System: Closes the application.


   
import java.util.ArrayList;
import java.util.Scanner;

// ===== ENCAPSULATION =====
class Hotel {
    private String hotelName;
    private double[] floorRates;

    public Hotel(String hotelName, double[] floorRates) {
        this.hotelName = hotelName;
        this.floorRates = floorRates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getRateForFloor(int floor) {
        return floorRates[floor - 1];
    }

    public int getTotalFloors() {
        return floorRates.length;
    }

    public void showHotelInfo() {
        System.out.println("\n===== HOTEL INFORMATION =====");
        System.out.println("Hotel: " + hotelName);
        for (int i = 0; i < floorRates.length; i++) {
            System.out.printf("Floor %d - %.2f per day (3 rooms)%n", (i + 1), floorRates[i]);
        }
    }
}

class Room extends Hotel {
    private int floor;
    private int roomNumber;
    private double roomRate;

    public Room(String hotelName, double[] floorRates, int floor, int roomNumber) {
        super(hotelName, floorRates);
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.roomRate = getRateForFloor(floor);
    }

    public int getFloor() { return floor; }
    public int getRoomNumber() { return roomNumber; }
    public double getRoomRate() { return roomRate; }
}

class Booking {
    String touristName;
    int weekday;
    Room bookedRoom;

    public Booking(String touristName, int weekday, Room bookedRoom) {
        this.touristName = touristName;
        this.weekday = weekday;
        this.bookedRoom = bookedRoom;
    }

    public double calculateTotalFee() {
        return bookedRoom.getRoomRate();
    }

    public String getWeekdayName() {
        return switch (weekday) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Unknown";
        };
    }

    public void showBookingSummary() {
        System.out.println("\n----- BOOKING SUMMARY -----");
        System.out.println("Tourist Name: " + touristName);
        System.out.println("Hotel Name: " + bookedRoom.getHotelName());
        System.out.println("Floor: " + bookedRoom.getFloor());
        System.out.println("Room Number: " + bookedRoom.getRoomNumber());
        System.out.println("Day: " + getWeekdayName());
        System.out.printf("Rate per Day: %.2f%n", bookedRoom.getRoomRate());
        System.out.printf("Total Fee: %.2f%n", calculateTotalFee());
    }

    public boolean isDuplicate(Booking other) {
        return this.bookedRoom.getFloor() == other.bookedRoom.getFloor()
                && this.bookedRoom.getRoomNumber() == other.bookedRoom.getRoomNumber()
                && this.weekday == other.weekday;
    }
}

// ===== MAIN CLASS =====
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double[] hotelRates = {1500, 1600, 1700, 1800, 1900, 2000, 2100};
        Hotel hotel = new Hotel("Grand Tower Hotel", hotelRates);

        ArrayList<Booking> bookings = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n============= MAIN MENU =============");
            System.out.println("|| [1] View Hotel Details          ||");
            System.out.println("|| [2] Book a Room                 ||");
            System.out.println("|| [3] View Available Rooms by Day ||");
            System.out.println("|| [4] Admin Login                 ||");
            System.out.println("|| [5] Exit                        ||");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {

                case 1 -> hotel.showHotelInfo();

                case 2 -> {
                    in.nextLine();
                    System.out.print("\nTourist Name: ");
                    String tname = in.nextLine();

                    System.out.print("Select Floor (1–7): ");
                    int floor = in.nextInt();

                    System.out.print("Select Room Number (1–3): ");
                    int roomNum = in.nextInt();

                    System.out.println("""
Select Weekday:
1 - Monday
2 - Tuesday
3 - Wednesday
4 - Thursday
5 - Friday
6 - Saturday
7 - Sunday
""");
                    System.out.print("Enter day (1-7): ");
                    int weekday = in.nextInt();

                    Room bookedRoom = new Room(hotel.getHotelName(), hotelRates, floor, roomNum);
                    Booking newBooking = new Booking(tname, weekday, bookedRoom);

                    boolean conflict = false;
                    for (Booking b : bookings) {
                        if (newBooking.isDuplicate(b)) {
                            conflict = true;
                            break;
                        }
                    }

                    if (conflict) {
                        System.out.println("Room already booked on that day!");
                    } else {
                        bookings.add(newBooking);
                        newBooking.showBookingSummary();
                        System.out.println("Booking added successfully.");
                    }
                }

                case 3 -> {
                    System.out.println("""
Select Weekday:
1 - Monday
2 - Tuesday
3 - Wednesday
4 - Thursday
5 - Friday
6 - Saturday
7 - Sunday
""");
                    System.out.print("Enter day: ");
                    int day = in.nextInt();

                    System.out.println("\n===== AVAILABLE ROOMS FOR DAY " + day + " =====");

                    for (int floor = 1; floor <= 7; floor++) {
                        for (int room = 1; room <= 3; room++) {
                            boolean booked = false;

                            for (Booking b : bookings) {
                                if (b.bookedRoom.getFloor() == floor &&
                                        b.bookedRoom.getRoomNumber() == room &&
                                        b.weekday == day) {
                                    booked = true;
                                    break;
                                }
                            }

                            if (booked) {
                                System.out.println("Floor " + floor + " Room " + room + " : BOOKED");
                            } else {
                                System.out.println("Floor " + floor + " Room " + room + " : Available");
                            }
                        }
                    }
                }

                // ===== ADMIN LOGIN =====
                case 4 -> {
                    in.nextLine();
                    System.out.print("\nEnter Admin Username: ");
                    String user = in.nextLine();

                    System.out.print("Enter Password: ");
                    String pass = in.nextLine();

                    if (user.equals("admin") && pass.equals("admin123")) {
                        System.out.println("\nLogin successful!");

                        int adminChoice;
                        do {
                            System.out.println("\n===== ADMIN MENU =====");
                            System.out.println("[1] View All Bookings");
                            System.out.println("[2] Cancel a Booking");
                            System.out.println("[3] Logout");
                            System.out.print("Enter choice: ");
                            adminChoice = in.nextInt();

                            switch (adminChoice) {

                                case 1 -> {
                                    if (bookings.isEmpty()) {
                                        System.out.println("\nNo bookings found.");
                                    } else {
                                        System.out.println("\n===== ALL BOOKINGS =====");
                                        for (Booking b : bookings) {
                                            b.showBookingSummary();
                                        }
                                    }
                                }

                                case 2 -> {
                                    if (bookings.isEmpty()) {
                                        System.out.println("\nNo bookings to cancel.");
                                        break;
                                    }

                                    System.out.println("\nSelect booking to cancel:");
                                    for (int i = 0; i < bookings.size(); i++) {
                                        Booking b = bookings.get(i);
                                        System.out.println((i + 1) + ") " + b.touristName + " - "
                                                + "Floor " + b.bookedRoom.getFloor()
                                                + " Room " + b.bookedRoom.getRoomNumber()
                                                + " (" + b.getWeekdayName() + ")");
                                    }

                                    System.out.print("Enter number: ");
                                    int cancelIndex = in.nextInt();

                                    if (cancelIndex >= 1 && cancelIndex <= bookings.size()) {
                                        bookings.remove(cancelIndex - 1);
                                        System.out.println("Booking cancelled.");
                                    } else {
                                        System.out.println("Invalid selection.");
                                    }
                                }

                                case 3 -> System.out.println("Logging out...");

                                default -> System.out.println("Invalid choice.");
                            }

                        } while (adminChoice != 3);

                    } else {
                        System.out.println("Invalid admin credentials.");
                    }
                }

                case 5 -> System.out.println("\nThank you for using the system!");

                default -> System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        in.close();
    }
}

𖨆𐀪𖠋 Author

|  Team Member            |          Student Email        |
| ----------------------- | ------------------------------|
| De Torres, Gibson Jake  | 24-09490@g.batstate-u.edu.ph  |
| Macatangay, Ara Niriz   | 24-060720@g.batstate-u.edu.ph |
| Yaco, Rendelee Cyril R. | 24-04120@g.batstate-u.edu.ph  |

𖡼.𖤣𖥧 Acknowledgement 𖤣𖥧𖡼.

We sincerely thank God for His guidance and strength, which have been our foundation in overcoming challenges and completing this project.
We are deeply grateful to our families for their constant support, understanding, and encouragement throughout this journey.
Our heartfelt appreciation goes to our instructor for the invaluable guidance, insightful feedback, and continuous support that greatly helped in the development of this system.
We also acknowledge our team members, whose dedication, collaboration, and creativity made this project possible. Each member’s contribution was essential to the successful completion of this system.
Finally, we extend our gratitude to everyone who supported us in any way. Your contributions have been truly appreciated.


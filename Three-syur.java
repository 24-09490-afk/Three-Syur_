import java.util.ArrayList;
import java.util.Scanner;

// ===== ENCAPSULATION =====
class Hotel {
    private String hotelName;
    private double standardRate;
    private double deluxeRate;

    public Hotel(String hotelName, double standardRate, double deluxeRate) {
        this.hotelName = hotelName;
        this.standardRate = standardRate;
        this.deluxeRate = deluxeRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getStandardRate() {
        return standardRate;
    }

    public double getDeluxeRate() {
        return deluxeRate;
    }

    // ===== ABSTRACTION =====
    public void showHotelInfo() {
        System.out.println("Hotel: " + hotelName);
        System.out.printf("1. Standard Room - %.2f per day%n", standardRate);
        System.out.printf("2. Deluxe Room   - %.2f per day%n", deluxeRate);
    }
}

// ===== INHERITANCE =====
class Room extends Hotel {
    private String roomType;
    private double roomRate;

    public Room(String hotelName, double standardRate, double deluxeRate, String roomType) {
        super(hotelName, standardRate, deluxeRate);
        this.roomType = roomType;
        this.roomRate = roomType.equalsIgnoreCase("Standard") ? standardRate : deluxeRate;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public String getRoomType() {
        return roomType;
    }
}

// ===== POLYMORPHISM =====
class Booking {
    private String touristName;
    private int days;
    private Room bookedRoom;

    public Booking(String touristName, int days, Room bookedRoom) {
        this.touristName = touristName;
        this.days = days;
        this.bookedRoom = bookedRoom;
    }

    public double calculateTotalFee() {
        return bookedRoom.getRoomRate() * days;
    }

    public void showBookingSummary() {
        System.out.println("\n----- BOOKING SUMMARY -----");
        System.out.println("Tourist Name: " + touristName);
        System.out.println("Hotel Name: " + bookedRoom.getHotelName());
        System.out.println("Room Type: " + bookedRoom.getRoomType());
        System.out.println("Days: " + days);
        System.out.printf("Rate per Day: %.2f%n", bookedRoom.getRoomRate());
        System.out.printf("Total Fee: %.2f%n", calculateTotalFee());
    }

    public boolean isDuplicate(Booking other) {
        return this.touristName.equalsIgnoreCase(other.touristName) &&
               this.bookedRoom.getHotelName().equalsIgnoreCase(other.bookedRoom.getHotelName()) &&
               this.bookedRoom.getRoomType().equalsIgnoreCase(other.bookedRoom.getRoomType());
    }
}

// ===== MAIN CLASS =====
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Create hotels
        Hotel h1 = new Hotel("Hotel 1", 1500.00, 2200.00);
        Hotel h2 = new Hotel("Hotel 2", 1300.00, 2000.00);
        Hotel h3 = new Hotel("Hotel 3", 1400.00, 2100.00);

        ArrayList<Booking> bookings = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("[1] View Hotel Details");
            System.out.println("[2] Book a Room");
            System.out.println("[3] View All Bookings");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n----- HOTEL INFORMATION MENU -----");
                    System.out.println("[1] Hotel 1");
                    System.out.println("[2] Hotel 2");
                    System.out.println("[3] Hotel 3");
                    System.out.print("Enter hotel code (1-3): ");
                    int view = in.nextInt();
                    switch (view) {
                        case 1 -> h1.showHotelInfo();
                        case 2 -> h2.showHotelInfo();
                        case 3 -> h3.showHotelInfo();
                        default -> System.out.println("Invalid hotel code!");
                    }
                }

                case 2 -> {
                    in.nextLine(); // clear buffer
                    System.out.print("\nTourist Name: ");
                    String tname = in.nextLine();

                    System.out.println("\nSelect a hotel to book:");
                    System.out.println("[1] Hotel 1");
                    System.out.println("[2] Hotel 2");
                    System.out.println("[3] Hotel 3");
                    System.out.print("Enter hotel code (1-3): ");
                    int hcode = in.nextInt();

                    Hotel selectedHotel;
                    switch (hcode) {
                        case 1 -> selectedHotel = h1;
                        case 2 -> selectedHotel = h2;
                        case 3 -> selectedHotel = h3;
                        default -> {
                            System.out.println("Invalid hotel code!");
                            continue;
                        }
                    }

                    System.out.print("Room Type (1 = Standard, 2 = Deluxe): ");
                    int rtype = in.nextInt();
                    System.out.print("Number of Days (1-7): ");
                    int tdays = in.nextInt();

                    if (tdays < 1 || tdays > 7 || (rtype != 1 && rtype != 2)) {
                        System.out.println("Invalid input! Days must be 1-7 and room type 1 or 2.");
                        break;
                    }

                    String roomType = (rtype == 1) ? "Standard" : "Deluxe";
                    Room bookedRoom = new Room(selectedHotel.getHotelName(),
                                               selectedHotel.getStandardRate(),
                                               selectedHotel.getDeluxeRate(),
                                               roomType);

                    Booking newBooking = new Booking(tname, tdays, bookedRoom);

                    boolean duplicate = false;
                    for (Booking b : bookings) {
                        if (newBooking.isDuplicate(b)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Duplicate booking detected! Booking not added.");
                    } else {
                        bookings.add(newBooking);
                        newBooking.showBookingSummary();
                        System.out.println("Booking successfully added.");
                    }
                }

                case 3 -> {
                    if (bookings.isEmpty()) {
                        System.out.println("\nNo bookings yet.");
                    } else {
                        System.out.println("\n===== ALL BOOKINGS =====");
                        for (Booking b : bookings) {
                            b.showBookingSummary();
                        }
                    }
                }

                case 4 -> System.out.println("\nThank you for using the Hotel Booking System. Goodbye!");

                default -> System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        in.close();
    }
}

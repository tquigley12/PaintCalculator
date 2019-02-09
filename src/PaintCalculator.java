
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator implements Serializable {

    private List<Room> roomList = new ArrayList<Room>();
    private Scanner keyboard;
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        new PaintCalculator();
    }

    public PaintCalculator() throws FileNotFoundException, IOException, ClassNotFoundException {
        keyboard = new Scanner(System.in);
        
        int option = 0;

        while (option != 5) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        writeFile();
                        break;
                    case 3:
                        readFile();
                        break;
                    case 4:
                        printRooms();
                        break;
                    case 5:
                        System.out.println("Goodbye");
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        }

    }

    private void writeFile() throws IOException {
        RoomWriter writer = new RoomWriter();
        writer.writeRoomFile("rooms.dat", roomList);
    }
    
    private void readFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        RoomReader reader = new RoomReader();
        roomList = reader.readRoomFile("rooms.dat");
    }
    
    private void printRooms() {
        if (roomList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Room room : roomList) {
            System.out.println(room.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Exit");
        System.out.println();
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            roomList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }
    }
    
}


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator implements Serializable {

    private List<Paintable> paintableList = new ArrayList<Paintable>();
    private Scanner keyboard;
    private static int roomCount = 0;
    
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
                        createShed();
                        break;
                    case 3:
                        writeFile();
                        break;
                    case 4:
                        readFile();
                        break;
                    case 5:
                        printRooms();
                        break;
                    case 6:
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
        writer.writeRoomFile("rooms.dat", paintableList);
    }
    
    private void readFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        RoomReader reader = new RoomReader();
        paintableList = reader.readRoomFile("rooms.dat");
    }
    
    private void printRooms() {
        if (paintableList.isEmpty()) {
            System.out.println("No rooms/ sheds yet");
        }

        for (Paintable room : paintableList) {
            System.out.println(room.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Add shed");
        System.out.println("3. Write rooms/ sheds to file");
        System.out.println("4. Read rooms/ sheds from file");
        System.out.println("5. View rooms/ sheds");
        System.out.println("6. Exit");
        System.out.println();
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the " + name + ": ");
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
            roomCount++;
            Room room = new Room(length, width, height, roomCount);
            paintableList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }
    }
    
    private void createShed() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            roomCount++;
            Shed shed = new Shed(length, width, height, roomCount);
            paintableList.add(shed);

            System.out.println("Shed successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create shed.");
        }
    }
    
}


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * The purpose of this class is to read Room objects from a List
 */

/**
 *
 * @author tquigley1
 */

public class RoomReader implements Serializable {

    static void readRoomFIle(String roomsdat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public RoomReader() {
    
    }
    
    public List<Room> readRoomFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
            List<Room> roomList = new ArrayList<Room>();
            boolean fileEnd = false;
            
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = null;
            
            try {
                // Allow the EOF Exception to happen
                while ((obj = ois.readObject()) != null ) {
                    Room room = (Room) obj;
                    roomList.add(room);
                }
            } catch (EOFException e) {
                fileEnd = true;
            }
            return roomList;
        }

}
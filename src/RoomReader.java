
import java.io.Serializable;
import java.util.List;

/*
 * The purpose of this class is to read Room objects from a List
 */

/**
 *
 * @author tquigley1
 */

public class RoomReader {
    
    public static List<Room> RoomReader {
        public static List<Room> readRoomFile(String fileName) {
            List<Room> list = new ArrayList<Room>();
            
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while (true) {
                try {
                    Object obj = ois.readObject();
                    Room room = (Room)obj;
                    list.add(room);
                } catch (EOFEXception eof)
        }
    }

    public List<Room> readRoomFile(String fileName) {
        return Room;
    }
    
}
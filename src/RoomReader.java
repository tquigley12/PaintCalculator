
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
    
    public List<Paintable> readRoomFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
            List<Paintable> paintableList = new ArrayList<Paintable>();
            
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = null;
            
            try {
                // Allow the EOF Exception to happen
                while ((obj = ois.readObject()) != null ) {
                    Paintable room = (Paintable) obj;
                    paintableList.add(room);
                }
            } catch (EOFException e) {
                // Do nothing
            }
            System.out.println("method readRoomFile was successful ");
            return paintableList;
        }

}
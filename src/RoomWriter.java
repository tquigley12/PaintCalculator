
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/*
 * The purpose of this class is to write Room objects to a List
 */

/**
 *
 * @author tquigley1
 */

public class RoomWriter {
    
    public RoomWriter() {
        
    }

    public void writeRoomFile(String fileName, List<Paintable> paintableList) throws FileNotFoundException, IOException {
        // create the binary ouptut objects.
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (Paintable room : paintableList) {
            oos.writeObject(room);
        }

    }

}
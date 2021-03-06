
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Paintable, Serializable {

    private ArrayList<Wall> wallList;
    private static final int SQUARE_FEET_PER_GALLON = 400;
    private int roomNum = 0;

    public Room(double length, double width, double height, int roomCount) throws BadWidthException, BadHeightException {
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
        roomNum = roomCount;
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }
    
    @Override
    public double getPremiumCost() {
        double premiumCost = 0.0;
        premiumCost = getArea() / SQUARE_FEET_PER_GALLON * PREMIUM_PAINT_COST_PER_GALLON;
        return premiumCost;
    }
    
    @Override
    public double getStandardCost() {
        double standardCost = 0.0;
        standardCost = getArea() / SQUARE_FEET_PER_GALLON * STANDARD_PAINT_COST_PER_GALLON;
        return standardCost;
    }
    
    @Override
    public String toString() {
        // return the room number and area in the toString
        String str = "Room number: " + roomNum + 
                     "\nArea: " + getArea();
        return str;
    }
    
}

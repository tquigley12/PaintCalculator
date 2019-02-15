
import java.io.Serializable;
import java.util.ArrayList;


public class Shed implements Paintable, Serializable {
    private ArrayList<Wall> outerWallList;
    private static final int SQUARE_FEET_PER_GALLON = 400;
    private int shedNum = 0;

    public Shed(double length, double width, double height, int roomCount) throws BadWidthException, BadHeightException {
        outerWallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        outerWallList.add(wallA);
        Wall wallB = new Wall(length, height);
        outerWallList.add(wallB);
        Wall wallC = new Wall(width, height);
        outerWallList.add(wallC);
        Wall wallD = new Wall(width, height);
        outerWallList.add(wallD);
        shedNum = roomCount;
    }
    
    public double getArea() {
        double area = 0;

        for (int i = 0; i < outerWallList.size(); i++) {
            Wall w = outerWallList.get(i);
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
        // return the shed number and area in the toString
        String str = "Shed number: " + shedNum + 
                     "\nArea: " + getArea();
        return str;
    }
    
}


package cs350f20task3;

//import java.util.*;

public class Coordinates{
	private double x;
	private double y;
	private final static double zerozero = 0.0001;
	
	//constructor
	public Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//add
	public Coordinates add(Coordinates coordinates) {
		return new Coordinates(coordinates.x + this.x, coordinates.y + this.y);
	}
	
	//calculateBearing
	public double calculateBearing(Coordinates coordinates) {
		double bx = coordinates.x - this.x;
		double by = coordinates.y - this.y;
		if(_bearing(bx)) {
			if(_bearing(by)) {
				return 0;
			}else if(by > 0) {
				return 0;
			}
			return 180;
		}
		double angleX = Math.toDegrees(Math.atan(by/bx));
		if(bx < 0) {
			angleX += 180;
		}
		double angleTop = 90 - angleX;
		if(angleTop < 0) {
			angleTop += 360;
		}
		return angleTop;
		//return (_bearing(this.x, this.y, coordinates.x, coordinates.y) + 360.0) * 360;
	}
	
	//the bearing helper method
	private static boolean _bearing(double distance) {
		return (Math.abs(distance) < zerozero);
	}
	
	//calculateDistance
	public double calculateDistance(Coordinates coordinates) {
		double x1 = Math.pow(this.x - coordinates.x, 2);
		double y2 = Math.pow(this.y - coordinates.y, 2);
		
		return Math.sqrt(x1 + y2);
		//return this.distance(coordinate.getX(), coordinate.getY());
	}
	
	//getX
	public double getX() {
		return this.x;
	}
	
	//getY
	public double getY() {
		return this.y;
	}

	//isNear
	public boolean isNear(Coordinates coordinates) {
		double x11 = Math.abs(this.x - coordinates.x);
		double y22 = Math.abs(this.y - coordinates.y);
		
		return (x11 < 0.01 && y22 < 0.01);
			//return this.calculateDistance(coordinates) < 0.01;
		}
	
	//Subtract
	public Coordinates subtract(Coordinates coordinates) {
		 return  new Coordinates(this.x - coordinates.getX(), this.y - coordinates.getY());
	}
	
	
	//toString = not required.
	/*public String toString() {
	}*/

}




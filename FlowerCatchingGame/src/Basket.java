
import java.util.*; 
import processing.*;
import processing.core.PApplet; 
public class Basket extends PApplet{
	float r;    // radius
	float x, y; // x and y location
	int count; 	// count of flowers intersected with 
	
	Basket(float rad) {
		r=rad; //make basket of radius that is passed in in FlowerCatchingGame
		x = 0;
		y = 0;
		count=0; 
	}

	void setLocation(float tempX, float tempY) {
		x = tempX;
		y = tempY;
	}

	void display() {		//display rectangular basket
		noStroke();	//no outline for basket
		fill(139,69,19);	//fill rect
		rect(x, y, 55, 55, 3, 6, 12, 18);	//display rect
	}

	boolean intersect(Flower f) {	//function returns T or F based on if basket intersects with flower
		float distance = dist(x, y, f.x, f.y); // Calculate distance
		if (distance < r + f.Cr) { 	// Compare distance to sum of radii
			count++; 	//add to count so later on can print out how many flowers caught 
			return true;
		} 
		else {
			return false;
		}
	}
}

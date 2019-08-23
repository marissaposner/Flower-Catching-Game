import java.util.*; 
import processing.core.*; 
public class FlowerCatchingGame extends PApplet{
	Basket basket;    // One catcher object
	Timer timer;        // One timer object
	ArrayList<Flower> flowers;   //declare array list of flowers
	int totalFlowers = 0; // total flowers made
	int flowerCount=0; 	//flowers caught count

	
	Flower flower;
	
	public void setup() {
		background(255);
		size(480, 270);
		
		flower = new Flower(this);
		//basket = new Basket(35); 	// Create basket with radius of 35
		//flowers = new ArrayList<Flower>();// create array list of flowers
		//timer = new Timer(100);    // Create a timer that goes off every 100 milliseconds
		//timer.start();             // Start timer
		
	}

	public void draw() {
		background(255);		
		flower.draw();
		
		// Set catcher location
		basket.setLocation(mouseX, mouseY); 
		// Display the catcher
		basket.display(); 

		// Check the timer
		if (!timer.isDone()) {
		
			// Initialize one flower
			//Flower f=new Flower(); 
			Flower f=new Flower(flower); 
			flowers.add(f); 
			// Increment totalFlowers
			totalFlowers++;
			// If we hit the end of the array
			if (totalFlowers >= flowers.size()) {
				totalFlowers = 0; // Start over
			}
			timer.start();
		}

		//Move and display all flowers
		for (int i = 0; i < 1000; i++ ) {	///1000 flowers
			flowers.get(i).move();
			flowers.get(i).display();
			if (basket.intersect(flowers.get(i))) {
				flowers.get(i).inBasket();
			}
		}
	} 
	
	
}
	

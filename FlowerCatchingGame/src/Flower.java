
import java.util.*; 
import processing.core.*;

public class Flower extends PApplet {
	float x, y;   // Variables for location of flower
	float speed;  // Speed of flower
	float Cr;     // Center radius of flower
	float petalR; //petal radius of flower
	float petalOffset; //offset petals from bud
	
	private FlowerCatchingGame app;

  public Flower(PApplet app) {
	  this.app = (FlowerCatchingGame) app;
    Cr = 8;                   // default center radius of 8
    petalR=10;				  //petal radius default=10
    x = random(width);       // Start at random x position on screen
    y = -(Cr+petalR)*4;       // Start a little above the flower
    speed = random(5, 10);    // Pick  random speed
    petalOffset=1; 				//set petal offset to 1
    this.img = app.loadImage(Flower.FLOWER_IMAGE_PATH);	// static variable so need Flower.
  }
  
  private final static String FLOWER_IMAGE_PATH = "flowerImage2.jpg";	//static bc same for all bjects
  
  public PImage img;
 
  
  public void draw() {
	  this.app.image(this.img, this.x, this.y);
  }
  
  public void move() {
    y += speed;	//move flower down screen by speed 
  }

  
  public boolean atBottom() {	// Check if it hits bottom
    if (y > height + (Cr+petalR)*4) { // check if we go below bottom 
      return true;
    } 
    else {
      return false;
    }
  }
  
  public void display() {	 // Display flower
	
    noStroke();		//no flower outline
    float petalX, petalY;	//petal size
    for (int i=0; i < 360; i = i + 90) {
        petalX = (Cr+petalOffset) * cos(radians(i));
        petalY = (Cr+petalOffset) * sin(radians(i));        
        fill(random(0,255), random(0,255), random(0,255));	//fill with random color
        ellipse(petalX, petalY, petalR, petalR);
        
      }
  }
  
  public void inBasket() {		// If drop is caught
    speed = 0; 	 // Stop it from moving by setting speed=0
    y = -1000;		// Set location to somewhere way off-screen so cant see it
  }
}
import java.util.*;
import processing.core.*;

public class Timer extends PApplet{

  int elapsedTime; 	// how long has passed
  int totalTime; 	// how long timer should go until

  Timer(int t) {
    totalTime = t;	//pass time in through func
  }
  
  public void start() {		// Start timer
    elapsedTime = millis();		//stores current time in millisecs
  }
  
  public boolean isDone() { 	//return true if all time has passed 	
    int passedTime = millis()- elapsedTime;		// Check how much time has passed
    if (passedTime > totalTime) {
      return true;
    } 
    else {
      return false;
    }
  }
}

package ev3.exercises;

import ev3.exercises.library.*;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;

public class ServoDemo
{
    public static void main(String[] args)
    {
    	int     button, angle = 0;
    	
        System.out.println("Servo Demo\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);   	// flash green led and
        Sound.beepSequenceUp();    	// make sound when ready.

        Button.waitForAnyPress();
        
        // create a motor object to control the motor we are using as a servo.
        EV3MediumRegulatedMotor servoMotor = new EV3MediumRegulatedMotor(MotorPort.C);

        // Motor object assumes it is at zero position when created, so robot must be in
        // it's starting configuration when you press the key to start (above).
        
        do
        {
            // Loop reading for any button press, quit on escape button.
            button = Button.waitForAnyPress();
        	
            // Process any other buttons.
       	    switch (button)
            {
                // Down button causes arm to move down until zero position.
                case Button.ID_DOWN:
                    if (angle >= 10)
                    {
                        servoMotor.rotate(-10);
                        angle -= 10;
                    }
        			
                    break;
        			
                // Up button causes arm to move up until it is at 160 degrees,
                // which we determined by testing is the max the arm can go.
                case Button.ID_UP:
                    if (angle < 160)
                    {
                        servoMotor.rotate(10);
                        angle += 10;
                    }
        			
                    break;
            }
        	
            // Display the current arm angle on the LCD.
            Lcd.clear(5);
            Lcd.print(5, "angle=%d", angle);
        	
        } while (!(button == Button.ID_ESCAPE));
        
        Button.waitForAnyPress();
        
        // free up motor resources.
        servoMotor.close();
        
        Sound.beepSequence();    // we are done.
    }
}

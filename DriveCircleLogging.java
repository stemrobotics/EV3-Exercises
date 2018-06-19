package ev3.exercises;

import java.io.IOException;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

// import our library package to make the Logging class available.
import ev3.exercises.library.*;

public class DriveCircleLogging 
{ 
    public static void main(String[] args) throws Exception
    {
        // These statements get logging started and writes the first log
        // message. Note that we added 'throws Exception' to the main
        // method above. This is required in case the setup fails.
        Logging.setup(DriveCircleLogging.class.getPackage(), false);
        Logging.log("Starting DriveCircleLogging");
        
        EV3TouchSensor sensor1 = new EV3TouchSensor(SensorPort.S1);
        SampleProvider touchSP = sensor1.getTouchMode();

        System.out.println("Drive Circle Logging\nand Stop\n");
        System.out.println("Press any key to start");
       
        Button.LEDPattern(4);    // flash green led and 
        Sound.beepSequenceUp();  // make sound when ready.
        
        // now we can log whatever information we want.
        Logging.log("waiting for key press");

        Button.waitForAnyPress();
   
        Logging.log("started");
        
       // create two motor objects to control the motors.
       UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
       UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

       // set motors to different power levels. Adjust to get a circle.
       motorA.setPower(70);
       motorB.setPower(30);

       // wait doing nothing for touch sensor to stop driving.
       while (!isTouched(touchSP)) {}

       Logging.log("sensor touched");
       
       // stop motors with brakes on.
       motorA.stop();
       motorB.stop();

       // free up resources.
       motorA.close();
       motorB.close();
       sensor1.close();

       // demonstrate using format specifiers to include variable values
       // in a log message.
       String s = "This is a test";
       int    i = 2;
       double d = 6.75;

       Logging.log("s=%s, i=%d, d=%f", s, i, d);

       Logging.log("done");
       
       Sound.beepSequence(); // we are done.
   }
   
   // method to read touch sensor and return true or false if touched.
   private static boolean isTouched(SampleProvider sp)
   {
       float [] sample = new float[sp.sampleSize()];
    
       sp.fetchSample(sample, 0);

       if (sample[0] == 0)
           return false;
       else
           return true;
   }
}

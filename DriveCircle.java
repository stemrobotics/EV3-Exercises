package ev3.exercises.driveCircle;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class DriveCircle 
{ 
    public static void main(String[] args)
    {
        EV3TouchSensor sensor1 = new EV3TouchSensor(SensorPort.S1);
        SampleProvider touchSP = sensor1.getTouchMode();

        System.out.println("Drive Circle\nand Stop\n");
        System.out.println("Press any key to start");
       
        Button.LEDPattern(4);    // flash green led and 
        Sound.beepSequenceUp();  // make sound when ready.

        Button.waitForAnyPress();
   
       // create two motor objects to control the motors.
       UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
       UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

       // set motors to different power levels. Adjust to get a circle.
       motorA.setPower(70);
       motorB.setPower(30);

       // wait doing nothing for touch sensor to stop driving.
       while (!isTouched(touchSP)) {}

       // stop motors with brakes on.
       motorA.stop();
       motorB.stop();

       // free up resources.
       motorA.close();
       motorB.close();
       sensor1.close();

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

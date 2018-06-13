package ev3.exercises;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class DriveForward
{
    public static void main(String[] args)
    {
        System.out.println("Drive Forward\nand Stop\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp();   // make sound when ready.

        Button.waitForAnyPress();

        // create two motor objects to control the motors.
        UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

        // set motors to 50% power.
        motorA.setPower(50);
        motorB.setPower(50);

        // wait 2 seconds.
        Delay.msDelay(2000);

        // stop motors with brakes on. 
        motorA.stop();
        motorB.stop();

        // free up motor resources. 
        motorA.close(); 
        motorB.close();
 
        Sound.beepSequence(); // we are done.
    }
}

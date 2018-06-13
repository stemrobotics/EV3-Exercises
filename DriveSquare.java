package ev3.exercises;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class DriveSquare
{
    public static void main(String[] args)
    {
        System.out.println("Drive in a Square\nand Stop\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp();   // make sound when ready.

        Button.waitForAnyPress();

        // create two motor objects to control the motors.
        UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

        for (i = 0; i < 4; i++)
        {
            // set motors to 50% power.
            motorA.setPower(50);
            motorB.setPower(50);

            // wait 2 seconds.
            Delay.msDelay(2000);

            // stop motors with brakes on. 
            motorA.stop();
            motorB.stop();

            // turn right by reversing the right motor.
            motorA.backward();
            motorB.forward();
 
            // make the turn.
            motorA.setPower(50);
            motorB.setPower(50);

            // adjust time to get a 90% turn.
            Delay.msDelay(1500);

            motorA.stop();
            motorB.stop();

            // set right motor back to forward motion.
            motorA.forward();
            motorB.forward();
        }

        // free up motor resources. 
        motorA.close(); 
        motorB.close();
 
        Sound.beepSequence(); // we are done.
    }
}

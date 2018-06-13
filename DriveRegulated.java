package ev3.exercises;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import ev3.projects.library.*;

public class DriveRegulated
{
    public static void main(String[] args)
    {
        System.out.println("Drive Regulated\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();
        
        // create two motor objects to control the motors.
        EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
        EV3LargeRegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
        
        // set motors to 500 degrees/second rotation.
        //motorA.setAcceleration(500);
        motorA.setSpeed(500);
        motorA.forward();    // starts rotation.

        //motorA.setAcceleration(500);
        motorB.setSpeed(500);
        motorB.forward();    // starts rotation.
        
        // wait 3 seconds.
        Delay.msDelay(3000);

        // stop motors with brakes on.
        motorA.stop();
        motorB.stop();

        Button.waitForAnyPress();

        // demonstrate rotate degrees with wait. One motor runs then other.
        motorA.rotate(360);
        motorB.rotate(360);

        Button.waitForAnyPress();

        // demonstrate rotate degrees without wait. Motors run together.
        motorA.rotate(360, true);
        motorB.rotate(360, true);

        Button.waitForAnyPress();

        // demonstrate rotate to target angle without wait.
        motorA.resetTachoCount();
        motorB.resetTachoCount();
        
        motorA.rotateTo(180, true);
        motorB.rotateTo(180, true);

        Button.waitForAnyPress();

        System.out.println("tach=" + motorA.getTachoCount());
        
        Button.waitForAnyPress();
        
        // free up motor resources.
        motorA.close();
        motorB.close();
        
        Sound.beepSequence();    // we are done.
    }
}

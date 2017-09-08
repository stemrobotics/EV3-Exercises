package ev3.projects.library;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.Gyroscope;
import lejos.robotics.SampleProvider;

public class GyroSensor implements Gyroscope
{
	EV3GyroSensor	sensor;
	SampleProvider	sp;
    float [] 		sample;
    int 			offset = 0;

    /**
     * Creates GyroSensor object. This is a wrapper class for EV3GyroSensor.
     * @param port SensorPort of EV3GyroSensor device.
     */
	public GyroSensor(Port port)
	{
		sensor = new EV3GyroSensor(port);
		sp = sensor.getAngleAndRateMode();
		sample = new float[sp.sampleSize()];
		sensor.reset();
	}

	/**
	 * Returns the underlying EV3GryoSensor object.
	 * @return Sensor object reference.
	 */
	public EV3GyroSensor getSensor()
	{
		return sensor;
	}

	/**
	 * Return the current angular velocity from the gyro.
	 * @return The angular velocity in degrees/second. Negative
	 * if turning right.
	 */
	public float getAngularVelocity()
	{
       sp.fetchSample(sample, 0);
  
       return sample[1];
	}

	/**
	 * Return the current accumulated angle from starting point from the gyro.
	 * @return The accumulated angle in degrees. Negative if turning right past zero.
	 */
	public int getAngle()
	{
       sp.fetchSample(sample, 0);
  
       return (int) sample[0] - offset;
	}

	/**
	 * Reset angle to zero.
	 */
	public void reset()
	{
       sp.fetchSample(sample, 0);
	       
       offset = (int) sample[0];
	}
	
	/**
	 * Recalibrate gyro and reset gyro angle to zero.
	 * May take several seconds to complete.
	 */
	public void resetGyro()
	{
		sensor.reset();
		
		offset = 0;
	}

	/**
	 * Release resources.
	 */
	public void close()
	{
		sensor.close();
	}

	/**
	 * Same as ResetGyro().
	 */
	@Override
	public void recalibrateOffset()
	{
		resetGyro();
	}
}

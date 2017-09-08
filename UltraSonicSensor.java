package ev3.exercises.library;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;

public class UltraSonicSensor implements RangeFinder
{
	EV3UltrasonicSensor sensor;
	SampleProvider		sp;
    	float [] 			sample;

    /**
     * Creates UltraSonicSensor object. This is a wrapper class for EV3UltrasonicSensor.
     * @param port SensorPort of EV3UltrasonicSensor device.
     */
	public UltraSonicSensor(Port port)
	{
		sensor = new EV3UltrasonicSensor(port);
		sp = sensor.getDistanceMode();
	    	sample = new float[sp.sampleSize()];
	}

	/**
	 * Returns the underlying EV3UltrasonicSensor object.
	 * @return Sensor object reference.
	 */
	public EV3UltrasonicSensor getSensor()
	{
		return sensor;
	}

	/**
	 * Get range (distance) to object detected by UltraSonic sensor.
	 * @return Distance in meters.
	 */
	@Override
	public float getRange()
	{
       		sp.fetchSample(sample, 0);

       		return sample[0];
	}

	/**
	 * Get range (distance) to object detected by UltraSonic sensor.
	 * @return Distance in meters. Only one distance value is returned.
	 */
	@Override
	public float[] getRanges()
	{
       		sp.fetchSample(sample, 0);

       		return sample;
	}
	
	/**
	 * Determine if UltraSonic sensor is enabled.
	 * @return True if enabled, false if not.
	 */
	public boolean isEnabled()
	{
		return sensor.isEnabled();
	}
	
	/**
	 * Enable UltraSonic sensor.
	 */
	public void enable()
	{
		sensor.enable();
	}
	
	/**
	 * Disable UltraSonic sensor.
	 */
	public void disable()
	{
		sensor.disable();
	}
	
	/**
	 * Release resources.
	 */
	public void close()
	{
		sensor.close();
	}
}

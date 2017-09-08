ackage ev3.projects.library;

import java.util.ArrayList;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.ColorDetector;
import lejos.robotics.ColorIdentifier;

public class ColorSensor implements ColorDetector, ColorIdentifier
{
	EV3ColorSensor	sensor;
	float[]		sample;

    	/**
     	* Creates ColorSensor object. This is a wrapper class for EV3ColorSensor.
     	* @param port SensorPort of EV3ColorSensor device.
     	*/
	public ColorSensor(Port port)
	{
		sensor = new EV3ColorSensor(port);
		setAmbientMode();
		setFloodLight(false);
	}

	/**
	 * Returns the underlying EV3ColorSensor object.
	 * @return Sensor object reference.
	 */
	public EV3ColorSensor getSensor()
	{
		return sensor;
	}
	
	/**
	 * Set color sensor to ambient light level mode.
	 */
	public void setAmbientMode()
	{
		sensor.setCurrentMode("Ambient");
		sample = new float[sensor.sampleSize()];
	}
	
	/**
	 * Set color sensor to RED light level mode.
	 */
	public void setRedMode()
	{
		sensor.setCurrentMode("Red");
		sample = new float[sensor.sampleSize()];
	}
	
	/**
	 * Set color sensor to color id mode.
	 */
	public void setColorIdMode()
	{
		sensor.setCurrentMode("ColorID");
		sample = new float[sensor.sampleSize()];
	}
	
	/**
	 * Set color sensor to RGB mode.
	 */
	public void setRGBMode()
	{
		sensor.setCurrentMode("RGB");
		sample = new float[sensor.sampleSize()];
	}

	/**
	 * Returns current detected color. Use with Color Id mode.
	 * @return Color id. Color ids are in the Color object.
	 */
	@Override
	public int getColorID()
	{
		sensor.fetchSample(sample, 0);
		
		return (int) sample[0];
	}

	/**
	 * Returns Color object with current detected color. Use with
	 * RGB mode and white light on target. Note that these values are
	 * the relative intensity of the reflected light of the primary colors.
	 * This is not the actual RGB value that would reproduce the color of
	 * the target surface.
	 * @return Color object with RGB intensity values of detected color.
	 */
	@Override
	public Color getColor()
	{
		sensor.fetchSample(sample, 0);
		
		return new Color((int)(sample[0] * 255), (int)(sample[1] * 255), (int)(sample[2] * 255));
	}

	/**
	 * Return ambient light level. Use with Ambient mode. Sensor led should be off.
	 * @return Light level as range 0 to 1.
	 */
	public float getAmbient()
	{
		sensor.fetchSample(sample, 0);
		
		return sample[0];
	}

	/**
	 * Return Red light level. Use with Red mode. Sensor led should be red.
	 * @return Light level as range 0 to 1.
	 */
	public float getRed()
	{
		sensor.fetchSample(sample, 0);
		
		return sample[0];
	}
	
	/**
	 * Release resources.
	 */
	public void close()
	{
		sensor.close();
	}

	/**
	 * Return current status of floodlight led.
	 * @return True if on, false if off.
	 */
	public boolean isFloodLightOn()
	{
		return sensor.isFloodlightOn();
	}

	/**
	 * Set floodlight led on/off with default color.
	 * @param on True to turn floodlight on, false to turn off.
	 */
	public void setFloodLight(boolean on)
	{
		sensor.setFloodlight(on);
	}
	
	/**
	 * Set floodlight default led color.
	 * @param color Color id value from Color object.
	 */
	public void setFloodLight(int color)
	{
		sensor.setFloodlight(color);
	}
	
	/**
	* Map color integer to name.
	* @param color Color id value.
	* @return String with color name.
	*/
	public static String colorName(int color)
	{
		switch (color)
		{
			case Color.NONE:
				return "None";
				
			case Color.BLACK:
				return "Black";
				
			case Color.BLUE:
				return "Blue";
				
			case Color.BROWN:
				return "Brown";
				
			case Color.CYAN:
				return "Cyan";
				
			case Color.DARK_GRAY:
				return "Dark Gray";
				
			case Color.GRAY:
				return "Gray";
				
			case Color.GREEN:
				return "Green";
				
			case Color.LIGHT_GRAY:
				return "Light Gray";
				
			case Color.MAGENTA:
				return "Magenta";
				
			case Color.ORANGE:
				return "Orange";
				
			case Color.PINK:
				return "Pink";
				
			case Color.RED:
				return "Red";
				
			case Color.WHITE:
				return "White";
				
			case Color.YELLOW:
				return "Yellow";
		}
		
		return "";
	}
}

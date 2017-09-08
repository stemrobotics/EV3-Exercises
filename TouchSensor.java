package ev3.exercises.library;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class TouchSensor
{
    EV3TouchSensor sensor;
    SampleProvider sp;

    /**
     * Creates TouchSensor object.
     * @param port SensorPort of Touch Sensor device.
     */
    public TouchSensor(Port port)
    {
        sensor = new EV3TouchSensor(port);
        sp = sensor.getTouchMode();
    }

    /**
     * Check state of Touch Sensor.
     * @return True if touched.
     */
    public boolean isTouched()
    {
       float [] sample = new float[sp.sampleSize()];

       sp.fetchSample(sample, 0);

       if (sample[0] == 0)
           return false;
       else
           return true;
    }

    /**
     * Release internal EV3TouchSensor.
     */
    public void close()
    {
        sensor.close();
    }
}

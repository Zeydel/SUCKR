package entities.sensors;

import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;

public class Gyro extends AbstractFilter{

	float[] sample;
	int offset;
	
	public Gyro(SampleProvider source) {
		super(source);
		sample = new float[sampleSize];
		offset = 0; 
	}
	
	public int angle() {
		super.fetchSample(sample, 0);
		return (int) sample[0] - offset;
	}
	
	public void reset() {
		super.fetchSample(sample,0);
		offset = (int) sample[0];
	}
}
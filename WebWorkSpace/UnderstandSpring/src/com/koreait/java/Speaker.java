package com.koreait.java;

public class Speaker {
	private String brand;
	private int maxVolume;
	private int currentVolume;
	
	public Speaker(int maxVolume) {
		super();
		this.brand = this.getClass().getSimpleName();
		this.maxVolume = maxVolume;
	}
	
	public int getMaxVolume() {
		return maxVolume;
	}
	
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void volumeUp() {
		if(currentVolume < maxVolume) currentVolume++;
		System.out.printf("%s - speaker : %d\n", brand, currentVolume);
	}
	
	public void volumeDown() {
		if(currentVolume > 0) currentVolume--;
		System.out.printf("%s - speaker : %d\n", brand, currentVolume);
	}

	@Override
	public String toString() {
		return String.format("%s", this.getClass().getSimpleName());
	}
}

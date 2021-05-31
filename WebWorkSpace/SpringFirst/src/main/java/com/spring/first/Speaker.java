package com.spring.first;

public class Speaker {
	private String brand;
	private int maxVolume;
	private int currentVolume;
	
	public Speaker(int maxVolume) {
		super();
		this.brand = this.getClass().getSimpleName();
		this.maxVolume = maxVolume;
		System.out.printf("-- %s 스피커 생성 --\n", this.brand);
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

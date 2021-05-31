package com.koreait.java;

public abstract class Tv { // 얘가 부모가 될꺼임
	private int inch;
	private int maxChannel;
	private int maxVolume;
	private int currentChannel;
	private int currentVolume;
	private String brand;
	private Speaker speaker;
	
	
	// 리턴 타입 없음, 클래스명과 이름이 같다.
	// 생성자는 오버로딩 가능
	// 다른생성자가 존재하지 않을때, 컴파일러가 기본 생성자는 자동으로 만들어준다.
	public Tv(String brand, int inch, int maxChannel, int maxVolume, Speaker speaker) {
		this.inch = inch;
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
		this.brand = brand;
		this.speaker = speaker;
	}
	
	public Tv(int inch, int maxChannel, int maxVolume, Speaker speaker) {
		this.inch = inch;
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
	}


	public int getCurrentChannel() {
		return currentChannel;
	}


	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}


	public int getCurrentVolume() {
		return currentVolume;
	}


	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}


	public int getInch() {
		return inch;
	}


	public int getMaxChannel() {
		return maxChannel;
	}


	public int getMaxVolume() {
		return maxVolume;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void channelUp() {
		if(currentChannel < maxChannel)
			currentChannel++;
		else
			currentChannel = 1;
		
		System.out.println("currentChannel : " + currentChannel);
	}
	
	public void channelDown() {
		if(currentChannel > 0)
			currentChannel--;
		else
			currentChannel = maxChannel;
		
		System.out.println("currentChannel : " + currentChannel);
	}
	
	public void volumeUp() {
		if(currentVolume < maxVolume) {
			currentVolume++;
			speaker.volumeUp();
		}
		System.out.println("currentVolume : " + currentVolume);
	}
	
	public void volumeDown() {
		if(currentVolume > 0) {
			currentVolume--;
			speaker.volumeDown();
		}
		System.out.println("currentVolume : " + currentVolume);
	}


	@Override
	public String toString() {
		return String.format("%s, %d인치, %d채널 ,%d볼륨", getBrand(), getInch(), getMaxChannel(), getMaxVolume());
	}

	public Speaker getSpeaker() {
		return speaker;
	}
	
}

package com.koreait.java;

public class TvTest {
	
	// 메인메소드
	public static void main(String[] args) {
		// Tv tv = new Tv();
		// new : heap 영역에 인스턴스를 생성(C++에서는 new 없이 스택 메모리 영역에 인스턴스 생성 가능하다더라)
		Tv lgtv = new LgTv(new AppleSpeaker(40));
		Tv samtv = new SamsungTv(new SonySpeaker(50));
		
		System.out.println(lgtv);
		System.out.println(samtv);
		
		Speaker sk = new AppleSpeaker(100);
		
		System.out.println(sk);
		
		for(int i = 0; i < 43; i++) {
			lgtv.channelUp();
		}
		
		for(int i = 0; i < 53; i++) {
			lgtv.volumeUp();
		}
		
		byte test = 1;
		for(int i = 0; i < 10000000; i++) {
			System.out.println(test++);
		}
		
	}
}

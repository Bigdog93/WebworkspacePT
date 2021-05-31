package com.koreait.spring;

import com.koreait.java.LgTv;
import com.koreait.java.SamsungTv;
import com.koreait.java.Speaker;
import com.koreait.java.Tv;

public class SpringTvTest {
	public static void main(String[] args) {
		Speaker s1 = SpeakerFactory.choiceSpeaker(args[0]);
		Speaker s2 = SpeakerFactory.choiceSpeaker(args[1]);
		
		Tv lgtv = new LgTv(s1);
		Tv samtv = new SamsungTv(s2);
		
		System.out.println(lgtv);
		System.out.println(samtv);
		
		for(int i = 0; i < 55; i++) {
			lgtv.volumeUp();
			samtv.volumeUp();
		}
	}
	
}

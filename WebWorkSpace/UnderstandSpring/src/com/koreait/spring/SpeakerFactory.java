package com.koreait.spring;

import com.koreait.java.AppleSpeaker;
import com.koreait.java.HamanSpeaker;
import com.koreait.java.SonySpeaker;
import com.koreait.java.Speaker;

public class SpeakerFactory {
	public static Speaker choiceSpeaker(String brand) {
		switch(brand) {
		case "apple":
			return new AppleSpeaker(30);
		case "sony" :
			return new SonySpeaker(40);
		case "haman" :
			return new HamanSpeaker(50);
		}
		return null;
	}
}

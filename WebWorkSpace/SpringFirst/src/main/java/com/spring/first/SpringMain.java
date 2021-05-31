package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring.xml");
		// 인터페이스						// 구현한 클래스		//classpath: src/main/resources, 뒤에 설정 파일의 경로
		MiTv tv1 = ctx.getBean("mitv", MiTv.class); // getBean(객체화할 친구의 xml설정의 id값, 리턴할 객체의 타입)
//		MiTv tv2 = ctx.getBean("mitv", MiTv.class); // 설정 따로 안하면 스프링은 무조건 싱글톤이다.(객체 하나밖에 안만듬)
		// 이렇게 getBean 안해도 객체화는 다 한다.(위에 new Class... 에서)
		// xml 설정 파일의 bean에서 lazy-init 속성값을 "true"로 설정해 놓으면 getBean할때에 객체화 시킨다.
		System.out.println("tv1 : " + tv1);
//		System.out.println("tv2 : " + tv2);
		tv1.volumeUp();
	}

}

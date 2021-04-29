package com.koreait.board;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private static List<BoardVO> list = new ArrayList<BoardVO>();
//	<> : 제네릭. 제약사항으로, 안에 특정 자료형만 넣게 할 수 있다.
//	제네릭을 주지 않으면 Object 타입으로 들어가고 나가기 때문에, 형변환을 항상 해줘야 한다.
	
	public static List<BoardVO> getlist() {
		return list;
		
	}
	
}

package com.koreait.board2;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private static List<BoardVO> list = new ArrayList<BoardVO>();

	public static List<BoardVO> getList() {
		return list;
	}

	public static void setList(List<BoardVO> list) {
		Database.list = list;
	}

	
	
}

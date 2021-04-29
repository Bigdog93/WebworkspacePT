package com.board.boardVO;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private static List<BoardVO> list = new ArrayList<BoardVO>();

	public static List<BoardVO> getList() {
		return list;
	}
}

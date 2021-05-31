package com.koreait.board9;

import java.io.File;

public class MyFileUtils {
	
	//폴더 삭제
	public static void delFolder(String path) {
		File folder = new File(path);
		while(folder.exists()) {
			File[] fileList = folder.listFiles(); // 경로안의 파일(과 폴더들)들을 File객체 배열타입으로 가져옴
			if(fileList == null) {
				return;
			}
			for (int j = 0; j < fileList.length; j++) {
				File f = fileList[j];				
				if(f.isDirectory()) { // 폴더라면, 재귀함수로 한번더 들어감
					delFolder(f.getPath());
				} else {
					f.delete();
				}
			}
			folder.delete();
		}
	}
}
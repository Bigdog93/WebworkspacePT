package testpack;

public class Test {

	public static void main(String[] args) {
		String str1 = "string";
		String str2 = "string";
		
		System.out.println(str1 == str2);
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}

}

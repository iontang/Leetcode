package src.jianzhiOffer.bc;

public class Four {
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer( "We Are Happy");
		System.out.println(replaceSpace(str));
	}
	
	public static String replaceSpace(StringBuffer str) {
//		char[] cArr = str.ch
		String result = "";
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)== ' ') {
				result +="%20";
			} else {
				result += str.charAt(i);
			}
//			System.out.println(str.charAt(i));
		}
		return result;
	}
}

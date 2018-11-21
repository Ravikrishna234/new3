import java.util.Scanner;
class longestsubstring {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		char[] c = s1.toCharArray();
		String str = "";
		String temp = "";
		String s2 = "";
		int i = 0;
		for(i = 0; i < s1.length() - 1; i++) {
			if(s1.charAt(i + 1) > s1.charAt(i)) {
 			 str += s1.charAt(i) + "";
 			 //System.out.print(str + "-" + s1.charAt(i) + "()");
 			 //System.out.println(str.length() + "*" + temp.length());

 			}
			 else if(temp.length() <= str.length()) {
			 	str += s1.charAt(i) + "";
			 	//System.out.print(str + "&&");
			 	temp = str;
			 	//System.out.println(temp.length() + " - " +str.length());
				str = s2;
			}
			//System.out.println(temp);i

		}if(temp.length() > str.length()) {
		//temp = str;
			System.out.println(temp);
		} else if(temp.length() < str.length()) {
			temp = str;
			System.out.println(temp + s1.charAt(i));
		}
		}
	}

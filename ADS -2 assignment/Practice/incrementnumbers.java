import java.util.*;
class incrementnumbers {
	public static void main(String[] args) {
	   Scanner s = new Scanner(System.in);
	   String s1 = s.nextLine();
	   String str = "";
	   for(int i = 0; i < s1.length(); i++) {
	   	str += (s1.charAt(i) - '0') + 1;
	   }
	   System.out.println(str);
	}
}
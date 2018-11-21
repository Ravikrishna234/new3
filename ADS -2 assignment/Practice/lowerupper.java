import java.util.*;
class lowerupper {
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	String s1 = s.nextLine();
	char[] c = s1.toCharArray();
	int n;
	for(int i = 0; i < s1.length(); i++) {
		if(Character.isLowerCase(s1.charAt(i))) {
			int c2 = s1.charAt(i) - 32;
			System.out.print((char)c2);
	  }
	  else {
	  	int c2 = s1.charAt(i) + 32;
	  	System.out.print((char)c2);
	  }
	}
	//System.out.print(s1.charAt(129));
	  //System.out.println(s2);
	  //System.out.println(Arrays.toString(c2));
	}
}
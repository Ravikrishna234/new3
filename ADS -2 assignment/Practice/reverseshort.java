import java.util.Scanner;
class reverseshort{
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String s = scan.nextLine();
	String str = "";
	for(int i = s.length() - 1; i > 0; i--){
		if(s.charAt(i) != s.charAt(i-1)){
			str += s.charAt(i);
		}
	}
	str += s.charAt(0);
	System.out.print(str);

	}
}
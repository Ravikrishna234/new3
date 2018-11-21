import java.util.Scanner;
class vowelsplit {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		int count = 0;
		String str = "";
		//boolean flag = false;
		String[] token = s1.split(" ");
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == ' ') {
				count++;
				str += " ";
			}
				if(count == 0) {
				if(s1.charAt(i) == 'a' || s1.charAt(i) == 'e' ||
					s1.charAt(i) == 'i' || s1.charAt(i) == 'o' || s1.charAt(i) == 'u') {
					str += '$';
				} else {
					str += s1.charAt(i) + "";
				}
		}
				else if(count == 1) {
				if(s1.charAt(i) != 'a' && s1.charAt(i) != 'e' &&
					s1.charAt(i) != 'i' && s1.charAt(i) != 'o' && s1.charAt(i) != 'u' && s1.charAt(i) != ' ') {
					str += "#";
				} else {
					str += s1.charAt(i) + "";
					//System.out.print(str + "-" + s1.charAt(i));
				}
			} else if(count == 2) {
				if(Character.isLowerCase(s1.charAt(i))) {
					int c2 = s1.charAt(i) - 32;
					str += (char)c2;
				} else {
					str += s1.charAt(i) + "";
				}
			}

		}
			System.out.print(str);

	}
}

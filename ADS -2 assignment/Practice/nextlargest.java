import java.util.Scanner;
class nextlargest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 0; i < n; i++) {
			int n1 = s.nextInt();
			int[] a = new int[n1];
			for(int j = 0; j < n1; j++) {
				a[j] = s.nextInt();
			}
			int j = 0;
			check(a);
		}
	}
	public static void check(int[] a) {
		String str = "";
		for(int i = 0; i < a.length; i++) {
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] > a[i]) {
					str += a[j] + " ";
					break;
				}
			}
		}
		System.out.println(str + "-1");
	}
}

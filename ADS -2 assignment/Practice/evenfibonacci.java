import java.util.*;
class evenfibonacci {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 0; i < n; i++) {
			long n1 = s.nextLong();
			long a = 0;
			long b = 1;
			long sum = 0;
			long c = a + b;
			while(c < n1) {
				//c = a + b;
				if(c % 2 == 0) {
					sum = sum + c;
				}
				c = a + b;
				a = b;
				b = c;

			}
			System.out.println(sum);
		}
	}
}
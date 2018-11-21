import java.util.Scanner;
class oddpath {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count = 0;
		for(int i = 0; i <= 100; i++) {
			//if(i%2!=0) {
				//System.out.print(i/2);
				if(count == n) {
					if(i%2!=0) {
				int temp = i/2;
				System.out.print(temp);
				break;
				} else {
				System.out.print(i);
				break;
			}
		}
			count++;
		}
	}
}
import java.util.*;
class subarraywithsum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = new int[50];
		int n = s.nextInt();
		int count = 0;
		int sum = 0;
		boolean flag = false;
		for(int it = 0; it < n; it++) {
					int n1 = s.nextInt();
		for(int i = 0; i < n1; i++) {
			if(count == 0) {
				sum = s.nextInt();
				//System.out.print(sum);
			}
			a[i] = s.nextInt();
			count++;
		}
		int currentsum = 0;
		int c = 0;
		for(int i = 0; i < n1; i++) {
			flag = false;
			currentsum = a[i];
			for(int j = i+1; j < n1; j++) {
				currentsum = currentsum + a[j];
				if(currentsum == sum) {
					if(c == 0) {
					System.out.println(i + " " + j--);
					c++;
				      }
				} else if(currentsum > sum) {
					break;
				}
			}
			}
		c = 0;
		count = 0;
	}
}
}
import java.util.*;
class missingnumberarray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int size = 0;
		int num = 0;
		int count = 0;
		boolean flag = true;
		for(int i = 0; i < n; i++) {
			int n1 = s.nextInt();
			int[] a = new int[100];
			for(int j = 0; j < n1 - 1; j++) {
			a[size] = s.nextInt();
			if(a[size] == ++count) {
				System.out.println(a[size] + "-" + count);
				flag = true;
			} else {
				flag = false;
				num = count;
				break;
			}
			size++;
			// if(size == n1 - 1) {
			// 	break;
			// }
		}
		count = 0;
		if(!flag) {
			System.out.println(num);
		}

		}
	}
}
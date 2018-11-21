import java.util.Scanner;
class largestprime {
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n1 = s.nextInt();
	for(int j = 0; j < n1; j++) {
	int n = s.nextInt();
	boolean x = false;
	int[] a = new int[n];
	int size = 0;
	x = checkprime(n);
	if(x) {
		System.out.println(n);
		return;
	}
	for(int i = 1; i < n; i++) {
		x = checkprime(i);
		if(n % i == 0) {
		a[size++] = i;
		}
	}
	int max = 0;
	for(int i = 0; i < size; i++) {
		if(a[i] > max) {
			max = a[i];
		}
	}
	System.out.println(max);
}
}
	public static boolean checkprime(int n) {

	boolean flag = false;
	int count = 0;
	for(int i = 1; i <= n; i++) {
	//count = 0;
	if(n % i == 0) {
	count++;
	}
	}
	if(count == 2)
		return true;
	return false;
}
}
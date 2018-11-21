import java.util.Scanner;
import java.util.Arrays;
class ikeyindexcounting {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();
		int[] a = new int[n1];
		for(int i = 0; i < n1; i++) {
			a[i] = s.nextInt();
		}
		int r = 26;
		int n = a.length;
		int[] aux = new int[26];
		System.out.println(a.length + "-");
		int[] count = new int[r + 1];
		for(int i = 0; i < n; i++) {
			count[a[i] + 1]++;
		}
	System.out.println(Arrays.toString(count));
		for(int i = 0; i < r; i++) {
			count[i + 1] += count[i]++;
		}
		System.out.println(Arrays.toString(count));
		for(int i = 0; i < n; i++) {
			aux[count[a[i]]++]= a[i];
		}
		System.out.println(Arrays.toString(aux));
		// int[] c = new int[5];
		// int[] d = new int[5];
		// for(int i = 0; i < 5; i++){
		// 	c[i] = a[i];
		// }
		// System.out.println(Arrays.toString(c));
		// for(int i = 0; i < 5; i++) {
		// 	d[i] = a[i];
		// }
		// System.out.println(Arrays.toString(d));
}

}
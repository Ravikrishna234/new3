import java.util.*;
class Octtodec {
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int num = s.nextInt();
	double sum = 0;
	int i = 0;
	double digit;
	while(num > 0) {
	digit = num % 10;
	sum = sum + (digit * Math.pow(8, i));
	//System.out.println(digit + " - " + sum + " + " + i);
	num = num/10;
	i++;
	}
	System.out.println(sum);
	}
}
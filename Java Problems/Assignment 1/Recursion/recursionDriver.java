package Recursion;
/*B1901898 - Fatima Binte Faiz Adreeta*/
public class recursionDriver {

	public static void main(String[] args) {
	
		
		System.out.println("power(3,5): "+ recursivePower(3,500));

	}
	//a
	public static double powerForLoop(double m, int n) {
		double value = 1;
		for(int i = 0; i<n; i++) {
			if(n==0) {
				value = 1;
			}
			else {
				value= value * m;
			}
		}
		return value;
	}
	//b
	public static double powerLoop(double m, int n) {
		if(n==0) {
			return 1;
		}
		else {
			return m*powerLoop(m, n-1);
		}
	}
	//c
	public static double recursivePower(double m, int n) {
		double value = 1;
		if(n==0) {
			value = 1;
		}
		else if(n>0 && n%2==1) {
			value = m *(recursivePower(m,(n-1)/2))*(recursivePower(m,(n-1)/2));
		}
		else if(n>0 && n%2==0) {
			value = (recursivePower(m, n/2))*(recursivePower(m, n/2));
		}
		return value;
	}
	
}



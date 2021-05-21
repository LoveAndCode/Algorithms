package inflearn.recursion;

public class Code06 {
	public static void main(String[] args) {
		int result = euclid(4,4);
		System.out.println("result = " + result);
	}

	public static int euclid(int m, int n) {
		if (m < n) {
			int tmp = m;
			m = n;
			m = tmp;
		}if(m % n == 0){
			return n;
		}else{
			return euclid(n, m%n);
		}
	}
}

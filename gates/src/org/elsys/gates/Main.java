package org.elsys.gates;

import java.util.Scanner;

public class Main {

	private static final int COUNT = 8;

	public static void main(String[] args) {
		Wire cIn = new Wire("Cin");
		Wire cOut = new Wire("Cout");
		
		Wire a[] = new Wire[COUNT];
		Wire b[] = new Wire[COUNT];
		Wire sum[] = new Wire[COUNT];

		for (int i = 0; i < COUNT; ++i) {
			a[i] = new Wire("a" + i);
			b[i] = new Wire("b" + i);
			sum[i] = new Wire("sum" + i);
		}

		Scanner scan = new Scanner(System.in);
	
		while (scan.hasNextInt()){
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			
			Gate gate = GateFactory.makeRippleCarryAdder(a, b, cIn, sum, cOut);
			
			intToWires(num1, a);
			intToWires(num2, b);
		}
		
		scan.close();

		System.out.print(wiresToInt(sum));
}
    
		public static void intToWires(int val, Wire[] w) {
			for (int i = 0; i < w.length; ++i) {
				int bit = 1 << i;
				w[i].setSignal((bit & val) != 0);
			}
		}
		
		public static int wiresToInt(Wire[] w) {
		int result = 0;
			for (int i = 0; i < w.length; ++i) {
				if (w[i].getSignal()) {
					int bit = 1 << i;
					result = result | bit;
				}
			}
			
		return result;
		
		}

}

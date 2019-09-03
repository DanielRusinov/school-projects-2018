package org.elsys.postfix;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.elsys.postfix.operations.CompositeOperation;
import org.elsys.postfix.operations.Cos;
import org.elsys.postfix.operations.Division;
import org.elsys.postfix.operations.Duplicate;
import org.elsys.postfix.operations.Minus;
import org.elsys.postfix.operations.Multipl;
import org.elsys.postfix.operations.Negate;
import org.elsys.postfix.operations.Operation;
import org.elsys.postfix.operations.Plus;
import org.elsys.postfix.operations.Rotation;
import org.elsys.postfix.operations.Sin;
import org.elsys.postfix.operations.Swap;
import org.elsys.postfix.operations.TernaryOperation;


public class Calculator {

	private Map<String, Operation> operations = new HashMap<>();

	private List<Double> stack = new LinkedList<>();

	private InputStream in;

	private PrintStream out;
	
	public Calculator(InputStream in, PrintStream out) {
		this.in = in;
		this.out = out;
		addOperation(new Negate(this, null));
		addOperation(new Duplicate(this, null));
		addOperation(new Sin(this, null));
		addOperation(new Cos(this, null));
		addOperation(new Plus(this, null));
		addOperation(new Minus(this, null));
		addOperation(new Multipl(this, null));
		addOperation(new Division(this, null));
		addOperation(new TernaryOperation(this, null));
		addOperation(new Swap(this, null));
		addOperation(new Rotation(this, null));
	}

	public void run() {
		String input;
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNext()) {
				out.print(stack.size() + ": ");
				input = scanner.next();
				
				if((input.substring(0, 1)).equals("\\") && !(input.equals("\\*-\\*"))) {
					newOperation(input.substring(1), scanner);
					
				} else if (isDouble(input)) {
					stack.add(Double.valueOf(input));

				} else {
					Operation operation = getOperation(input);
					if (operation != null) {
						operation.calculate();
					} else {
						throw new UnsupportedOperationException();
					}					
				}
			}
		}
	}

	private void newOperation(String str, Scanner scan) {
		CompositeOperation composite = new CompositeOperation(this, str);
	
		String input;
		
		while(scan.hasNext()){
			input = scan.next();
			
			if (isDouble(input)) {
				stack.add(Double.valueOf(input));
			} else if(input.equals("def")) {
				break;
			} else {
				composite.addOperation(this.getOperation(input));
			}
		}
		addOperation(composite);
	}
	
	private static boolean isDouble(String input) {
		try {
			Double.valueOf(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public void addOperation(Operation operation) {
		operations.put(operation.getToken(), operation);
	}

	public Operation getOperation(String token) {
		return operations.get(token);
	}

	public Double popValue() {
		if(stack.size() == 0) {
			throw new EmptyStackException();
		}
		
		int lastIndex = stack.size() - 1;
		Double value = stack.get(lastIndex);
		stack.remove(lastIndex);
		return value;
		
	}

	Double lastValue() {
		return stack.get(stack.size() - 1);
	}

	public void addValue(double value) {
		out.println(value);	
		stack.add(value);
	}

	int stackSize() {
		return stack.size();
	}
}

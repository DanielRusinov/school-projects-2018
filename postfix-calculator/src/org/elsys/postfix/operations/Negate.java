package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Negate extends UnaryOperation {

	public Negate(Calculator calculator, String token) {
		super(calculator, "neg");
	}
	
	@Override
	protected double doCalculate(double value) {
		return -value;
	}

}

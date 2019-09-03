package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Cos extends UnaryOperation {

	public Cos(Calculator calculator, String token) {
		super(calculator, "cos");
	}

	@Override
	protected double doCalculate(double value) {
		return Math.cos(value);
	}

}

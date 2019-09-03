package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Plus extends BinaryOperation {

	public Plus(Calculator calculator, String token) {
		super(calculator, "+");
	}

	@Override
	protected double doCalculator(double value1, double value2) {
		return value2 + value1;
	}

}

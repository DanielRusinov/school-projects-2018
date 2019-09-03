package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Duplicate extends AbstractOperation {

	public Duplicate(Calculator calculator, String token) {
		super(calculator, "dup");
	}

	@Override
	public void calculate() {
		double value = getCalculator().popValue();
		getCalculator().addValue(value);
		getCalculator().addValue(value);
	}

	
	
}

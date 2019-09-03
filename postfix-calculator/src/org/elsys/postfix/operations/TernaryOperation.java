package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class TernaryOperation extends AbstractOperation {

	public TernaryOperation(Calculator calculator, String token) {
		super(calculator, "\\*-\\*");

	}

	@Override
	public void calculate() {
		double value1 = getCalculator().popValue();
		double value2 = getCalculator().popValue();
		double value3 = getCalculator().popValue();
		
		double result = -(value1 * value2 * value3);
		
		getCalculator().addValue(result);
	}

}

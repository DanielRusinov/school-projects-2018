package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public abstract class BinaryOperation extends AbstractOperation {

	public BinaryOperation(Calculator calculator, String token) {
		super(calculator, token);
	}

	@Override
	public void calculate() {
			double value1 = getCalculator().popValue();
			double value2 = getCalculator().popValue();
			double result = doCalculator(value1, value2);
			getCalculator().addValue(result);		
	}
	
	protected abstract double doCalculator(double value1, double value2);

}

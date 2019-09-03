package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Swap extends AbstractOperation {

	public Swap(Calculator calculator, String token) {
		super(calculator, "swap");

	}

	@Override
	public void calculate() {
			double value1 = getCalculator().popValue();
			double value2 = getCalculator().popValue();
			
			getCalculator().addValue(value1);
			getCalculator().addValue(value2);
	}

}

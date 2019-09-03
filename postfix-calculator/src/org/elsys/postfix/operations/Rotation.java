package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Rotation extends AbstractOperation {

	public Rotation(Calculator calculator, String token) {
		super(calculator, "rot3");
	}

	@Override
	public void calculate() {
		double value1 = getCalculator().popValue();
		double value2 = getCalculator().popValue();
		double value3 = getCalculator().popValue();

		getCalculator().addValue(value1);
		getCalculator().addValue(value3);
		getCalculator().addValue(value2);
	}

}

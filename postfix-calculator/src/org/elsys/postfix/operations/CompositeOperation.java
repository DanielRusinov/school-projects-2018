package org.elsys.postfix.operations;

import java.util.ArrayList;
import java.util.List;

import org.elsys.postfix.Calculator;

public class CompositeOperation extends AbstractOperation {

	private List<Operation> operations = new ArrayList<Operation>();
	
	public CompositeOperation(Calculator calculator, String token) {
		super(calculator, token);
	}

	@Override
	public void calculate() {
		for(int i = 0; i < operations.size(); i++) {		
			operations.get(i).calculate();
		}
	}
	
	public void addOperation(Operation op) {
		operations.add(op);
	}

}

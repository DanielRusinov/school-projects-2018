package org.elsys.gates;

public abstract class NandFactory {

	public static Gate makeNotGate(Wire in, Wire out, String name) {
		
		NandGate gate = new NandGate(in, in, out, name);
		
		return gate;
	}

	public static Gate makeNotGate(Wire in, Wire out) {
		return makeNotGate(in, out, "NandNot");
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
		
		Wire out2 = new Wire(name);
		
		CompositeGate gate = new CompositeGate(name);
		
		NandGate nand1 = new NandGate(in1, in2, out2);
		gate.addGate(nand1);
		
		NandGate nand2 = new NandGate(out2, out2, out);
		gate.addGate(nand2);
		
		return gate;
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
		return makeAndGate(in1, in2, out, "NandAnd");
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
		
		Wire out1 = new Wire("out1");
		Wire out2 = new Wire("out2");
		
		CompositeGate gate = new CompositeGate(name);
		
		gate.addInput(in1);
		gate.addInput(in2);
		gate.addOutput(out);
		
		NandGate nand1 = new NandGate(in1, in1, out1);
		gate.addGate(nand1);
		
		NandGate nand2 = new NandGate(in2, in2, out2);
		gate.addGate(nand2);
		
		NandGate nand3 = new NandGate(out1, out2, out);
		gate.addGate(nand3);
		
		return gate;
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
		return makeOrGate(in1, in2, out, "NandOr");
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		
		Wire out1 = new Wire("out1");
		Wire out2 = new Wire("out2");
		Wire out3 = new Wire("out3");
		
		CompositeGate gate = new CompositeGate(name);
		
		gate.addInput(in1);
		gate.addInput(in2);
		gate.addOutput(out);
		
		NandGate nand1 = new NandGate(in1, in2, out1);
		gate.addGate(nand1);
		
		NandGate nand2 = new NandGate(in1, out1, out2);
		gate.addGate(nand2);
		
		NandGate nand3 = new NandGate(out1, in2, out3);
		gate.addGate(nand3);
		
		NandGate nand4 = new NandGate(out2, out3, out);
		gate.addGate(nand4);
		
		return gate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "NandXor");
	}

}

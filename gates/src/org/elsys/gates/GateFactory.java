package org.elsys.gates;

public abstract class GateFactory {

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate xorGate = new CompositeGate(name);

		xorGate.addInput(in1);
		xorGate.addInput(in2);
		xorGate.addOutput(out);

		Wire a = new Wire("xorA");
		Wire b = new Wire("xorB");
		Wire c = new Wire("xorC");

		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate1 = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate2 = new AndGate(a, c, out);

		xorGate.addGate(orGate);
		xorGate.addGate(andGate1);
		xorGate.addGate(notGate);
		xorGate.addGate(andGate2);

		return xorGate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "XorGate");
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c, String name) {
		
		CompositeGate gate = new CompositeGate(name);
		
		Gate xorGate = makeXorGate(a, b, s);
		gate.addGate(xorGate);
		
		Gate andGate = new AndGate(a, b, c);
		gate.addGate(andGate);		
		
		return gate;
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c) {
		return makeHalfAdder(a, b, s, c, "HalfAdder");
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut, String name) {
		
		CompositeGate gate = new CompositeGate(name);

		Wire HA1SUM = new Wire("HA1SUM");
		Wire HA1COUT = new Wire("HA1COUT");
		Wire HA2COUT = new Wire("HA2COUT");
		
		Gate halfAdder1 = makeHalfAdder(a, b, HA1SUM, HA1COUT);
		gate.addGate(halfAdder1);
		
		Gate halfAdder2 = makeHalfAdder(cIn, HA1SUM, sum, HA2COUT);
		gate.addGate(halfAdder2);
		
		Gate orGate = new OrGate(HA1COUT, HA2COUT, cOut);
		gate.addGate(orGate);
				
		return gate;
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut) {
		return makeFullAdder(a, b, cIn, sum, cOut, "FullAdder");
	}
	
	public static Gate makeRippleCarryAdder(Wire a[], Wire b[], Wire cIn, Wire sum[], Wire cOut) {
		assert a.length == b.length;
		assert a.length == sum.length;
		int count = a.length;
		
		CompositeGate gate = new CompositeGate("RippleCarryAdder");
		
		Wire in = cIn;
		Wire out = new Wire("out");
		
		for(int i = 0; i < count; i++){
			if(i == count - 1) out = cOut;
			Gate fullAdder = makeFullAdder(a[i], b[i], in, sum[i], out);
			gate.addGate(fullAdder);
			
			in = out;
			out = new Wire("out");
		}		
		
		return gate;
	}
}

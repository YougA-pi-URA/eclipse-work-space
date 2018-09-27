package mycalculator.function;

import mycalculator.utility.Register;

public class MemoryAction {

	public Register register;

	public MemoryAction(Register register, int status) {

		switch(status){
		case 0:	register.memory = Double.parseDouble(register.numberInfo);
				break;

		case 1:	register.regB = String.valueOf(register.memory);
				break;

		case 2:	register.memory = 0;
		}

		this.register = register;

	}

}

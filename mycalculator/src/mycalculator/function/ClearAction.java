package mycalculator.function;

import mycalculator.utility.Register;

public class ClearAction {

	public Register register = new Register();

	public ClearAction(Register register){

		if(register.regB.isEmpty() || register.regB == "0"){
			double memoryBackup = register.memory;
			register = new Register();
			register.memory = memoryBackup;
		}else{
			register.regB = "0";
			register.isZero = true;
			register.dotUsed = false;
		}

		this.register = register;

	}

}

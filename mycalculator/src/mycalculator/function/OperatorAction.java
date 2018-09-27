package mycalculator.function;

import mycalculator.utility.Register;

public class OperatorAction {

	public Register register;

	public OperatorAction(Register register, int status){

		double a, b;
		final int ERROR = 404;

		if(register.regA.isEmpty()){
			a = 0;
		}else{
			a = Double.parseDouble(register.regA);
		}
		try{

			b = Double.parseDouble(register.numberInfo);
		}catch(Exception e){
			b = 0;
		}

		switch(register.operationMode){
		case 0:	a = b;
				break;

		case 1:	a += b;
				break;

		case 2:	a -= b;
				break;

		case 3:	a *= b;
				break;

		case 4:	try{
					a /= b;
				}catch(Exception e){	//ゼロ分はcatchしない。 ==> a == infinity
					a = ERROR;
				}
				break;

		case 5:	try{
					register.remainder = a % b;
					a = (int) (a / b);
					register.remainderInfo = " あまり " + String.valueOf(register.remainder);
				}catch(Exception e){
					a =ERROR;
				}
				break;
		}

		if(register.operationMode != 5 || a == ERROR){
			register.remainderInfo = "";
			register.remainder = 0;
		}

		if(a != ERROR){

			switch(status){
			case 0:	register.operationMode = 0;
					register.operatorSymbol = "";
					break;

			case 1:	register.operationMode = 1;
					register.operatorSymbol = " ＋ ";
					break;

			case 2:	register.operationMode = 2;
					register.operatorSymbol = " － ";
					break;

			case 3:	register.operationMode = 3;
					register.operatorSymbol = " × ";
					break;

			case 4:	register.operationMode = 4;
					register.operatorSymbol = " ÷ ";
					break;

			case 5:	register.operationMode = 5;
					register.operatorSymbol = " ％ ";
					break;
			}

		}

		register.regA = String.valueOf(a);
		register.regB = "";
		register.isZero = true;
		register.dotUsed = false;

		this.register = register;
	}

}

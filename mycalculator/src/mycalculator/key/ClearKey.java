package mycalculator.key;

import mycalculator.utility.KeyAllocator;

public class ClearKey {

	public ClearKey(KeyAllocator allocator) {
		allocator.label = "CLR";
		allocator.functionId = 0;
		allocator.status = 0;
	}

}

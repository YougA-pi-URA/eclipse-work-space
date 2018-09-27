package mycalculator.key;

import mycalculator.utility.KeyAllocator;

public class PercentKey {

	public PercentKey(KeyAllocator allocator) {
		allocator.label = "%";
		allocator.functionId = 3;
		allocator.status = 1;
	}

}

package mycalculator.key;

import mycalculator.utility.KeyAllocator;

public class MemoryClearKey {

	public MemoryClearKey(KeyAllocator allocator) {
		allocator.label = "MC";
		allocator.functionId = 4;
		allocator.status = 2;
	}

}

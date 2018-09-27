package mycalculator.key;

import mycalculator.utility.KeyAllocator;

public class EqualKey {

	public EqualKey(KeyAllocator allocator) {
		allocator.label = "＝";
		allocator.functionId = 2;
		allocator.status = 0;
	}

}

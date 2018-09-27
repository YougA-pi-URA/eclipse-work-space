package mycalculator.config;

import mycalculator.key.ClearKey;
import mycalculator.key.DivisionKey;
import mycalculator.key.DotKey;
import mycalculator.key.EightKey;
import mycalculator.key.EqualKey;
import mycalculator.key.FiveKey;
import mycalculator.key.FourKey;
import mycalculator.key.MemoryClearKey;
import mycalculator.key.MemoryRecallKey;
import mycalculator.key.MemorySaveKey;
import mycalculator.key.MinusKey;
import mycalculator.key.MultiplicationKey;
import mycalculator.key.NineKey;
import mycalculator.key.OneKey;
import mycalculator.key.PercentKey;
import mycalculator.key.PlusKey;
import mycalculator.key.SevenKey;
import mycalculator.key.SignInversionKey;
import mycalculator.key.SixKey;
import mycalculator.key.SquareRootKey;
import mycalculator.key.ThreeKey;
import mycalculator.key.TwoKey;
import mycalculator.key.WithRemainderKey;
import mycalculator.key.ZeroKey;
import mycalculator.utility.KeyAllocator;

public class KeyAllocation {

	KeyAllocator allocator = new KeyAllocator();

	public void allocate(short keyId) {

		switch(keyId){
		case 0: new MemoryClearKey(allocator);
				break;

		case 1: new MemoryRecallKey(allocator);
				break;

		case 2: new MemorySaveKey(allocator);
				break;

		case 3: new ClearKey(allocator);
				break;

		case 4: new SquareRootKey(allocator);
				break;

		case 5: new PercentKey(allocator);
				break;

		case 6: new SignInversionKey(allocator);
				break;

		case 7: new WithRemainderKey(allocator);
				break;

		case 8: new SevenKey(allocator);
				break;

		case 9: new EightKey(allocator);
				break;

		case 10: new NineKey(allocator);
				break;

		case 11: new DivisionKey(allocator);
				break;

		case 12: new FourKey(allocator);
				break;

		case 13: new FiveKey(allocator);
				break;

		case 14: new SixKey(allocator);
				break;

		case 15: new MultiplicationKey(allocator);
				break;

		case 16: new OneKey(allocator);
				break;

		case 17: new TwoKey(allocator);
				break;

		case 18: new ThreeKey(allocator);
				break;

		case 19: new MinusKey(allocator);
				break;

		case 20: new ZeroKey(allocator);
				break;

		case 21: new DotKey(allocator);
				break;

		case 22: new EqualKey(allocator);
				break;

		case 23: new PlusKey(allocator);
				break;

		}

	}

}

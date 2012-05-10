package me.willynilly.argparse;

import java.util.HashMap;
import java.util.Map;

// TODO: provide help command

public class ArgumentParser {
	private final Map<String, Flag> flags = new HashMap<String, Flag>();

	public Namespace parseArgs(String[] arguments) {
		if(arguments == null) {
			throw new NullPointerException();
		}
		
		for(int head = 0; head < arguments.length; head++) {
			String argument = arguments[head];
			Flag flag = flags.get(argument);
			
			if(flag == null) {
				throw new IllegalArgumentException("unknown flag: " + argument);
			}
			
			int indexesConsumed = flag.process(arguments, head);
			head += indexesConsumed;
		}
		
		return new Namespace();
	}
	
	
}

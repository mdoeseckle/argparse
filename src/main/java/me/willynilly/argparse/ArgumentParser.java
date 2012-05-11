package me.willynilly.argparse;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {
	private final Map<String, Flag> flags = new HashMap<String, Flag>();
	
	public ArgumentParser() {
		HelpFlag helpFlag = new HelpFlag(true, "");
		flags.put("--help", helpFlag);
		flags.put("-h", helpFlag);
	}

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
			
			int indexesConsumed = flag.invoke(arguments, head);
			head += indexesConsumed;
		}
		
		return new Namespace();
	}
	
	
}

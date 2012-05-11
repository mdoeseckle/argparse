package me.willynilly.argparse;

import java.util.HashMap;
import java.util.Map;

// -h for usage
// -h, --help for argument help
// description for argument help

public class ArgumentParser {
	private final Map<String, Flag> flags = new HashMap<String, Flag>();
	private final HelpFlag helpFlag;
	
	public ArgumentParser() {
		this.helpFlag = new HelpFlag(true, "");
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

	public void addArgument(String flags, Parameter... parameters) {
		
	}
	
	
}

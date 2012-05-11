package me.willynilly.argparse;

import java.util.HashMap;
import java.util.Map;

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
		
		Map<String, Object> results = new HashMap<String, Object>();
		
		for(int head = 0; head < arguments.length; head++) {
			String argument = arguments[head].replaceFirst("-+", "");
			Flag flag = flags.get(argument);
			
			if(flag == null) {
				throw new IllegalArgumentException("unknown flag: " + argument);
			}
			
			int indexesConsumed = flag.invoke(arguments, head, results);
			head += indexesConsumed;
		}
		
		return new Namespace(results);
	}

	public void addArgument(String flags, Parameter... parameters) {
		if(parameters == null) throw new IllegalArgumentException("parameters cannot be a null object");
		
		String[] finalizedFlags = ArgumentHelper.parseFlags(flags);
		
		if(finalizedFlags.length == 0) throw new IllegalArgumentException("invalid format: flags must be a comma delimited list");
		
		int nargs = 0;
		String dest = ArgumentHelper.getDest(finalizedFlags);
		
		for(Parameter parameter : parameters) {
			switch(parameter.getType()) {
				case HELP:
					helpFlag.addHelp(String.format("[%s]", finalizedFlags[0]), flags, (String) parameter.getValue());
					break;
				case NARGS:
					nargs = (Integer) parameter.getValue();
					break;
				case DEST:
					dest = (String) parameter.getValue();
					break;
				default:
					throw new IllegalArgumentException("invalid parameter type: " + parameter.getType());
			}
		}
		
		switch(nargs) {
			case 0:
				for(String key : finalizedFlags) {
					this.flags.put(key, new BooleanFlag(dest));
				}
				break;
			case 1:
				break;
			default:
				throw new UnsupportedOperationException("currently only 0 or 1 arguments can be applied to a flag");
		}
		
	}
	
}

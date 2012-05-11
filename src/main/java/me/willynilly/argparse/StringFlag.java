package me.willynilly.argparse;

import java.util.Map;

final class StringFlag implements Flag {
	private final String dest;
	
	public StringFlag(String dest) {
		this.dest = dest;
	}
	
	@Override
	public int invoke(String[] arguments, int head, Map<String, Object> results) {
		String value = arguments[head + 1];
		
		if(value.startsWith("-"))
			throw new IllegalArgumentException("no argument specified for flag: " + arguments[head]);
		
		results.put(dest, value);
		return 1;
	}

}

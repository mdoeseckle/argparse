package me.willynilly.argparse;

import java.util.Map;

public class BooleanFlag implements Flag {
	private final String name;
	
	public BooleanFlag(String name) {
		this.name = name;
	}
	
	@Override
	public int invoke(String[] arguments, int head, Map<String, Object> results) {
		results.put(name, true);
		return 0;
	}

}

package me.willynilly.argparse;

import me.willynilly.argparse.Parameter.Type;

public class Parameters {

	public static Parameter create(Type type, Object value) {
		return new Parameter(type, value);
	}
	
	public static Parameter[] all(Parameter... parameters) {
		return parameters;
	}
	
}

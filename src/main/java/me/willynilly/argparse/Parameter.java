package me.willynilly.argparse;

public class Parameter {
	
	public enum Type {
		NARGS,
		HELP
	}
	
	private final Type type;
	private final Object value;
	
	Parameter(Type type, Object value) {
		this.type = type;
		this.value = value;
	}
	
	public Type getType() {
		return type;
	}
	
	public Object getValue() {
		return value;
	}

}

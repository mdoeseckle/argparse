package me.willynilly.argparse.utils;

import java.util.Iterator;

/**
 * Joins a list of items together into a string.
 * Modeled after Google Guava's Joiner object, so its not required as an external dependency.
 */
public class Joiner {
	private final String delimiter;
	
	private Joiner(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public static Joiner on(String delimiter) {
		return new Joiner(delimiter);
	}
	
	public String join(Object[] elements) {
		StringBuilder builder = new StringBuilder();
		
		for(int index = 0; index < elements.length; index++) {
			builder.append(elements[index].toString());
			if(index < elements.length - 1) 			
				builder.append(delimiter);
		}
		
		return builder.toString();
	}
	
	public String join(Iterable<?> elements) {
		StringBuilder builder = new StringBuilder();
		
		for(Iterator<?> iter = elements.iterator(); iter.hasNext(); ) {
			builder.append(iter.next().toString());
			if(iter.hasNext()) 			
				builder.append(delimiter);
		}
		
		return builder.toString();
	}

}
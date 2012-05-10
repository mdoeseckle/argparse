package me.willynilly.argparse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Basically, an immutable map
 *
 */
public class Namespace implements Map<String, String> {
	private final Map<String, String> contents;
	
	Namespace() {
		this.contents = new HashMap<String, String>();
	}
	
	Namespace(Map<String, String> contents) {
		this.contents = contents;
	}

	@Override
	public void clear() { 
		throw new UnsupportedOperationException("this object is immutable");
	}

	@Override
	public boolean containsKey(Object key) {
		return contents.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return contents.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return contents.entrySet();
	}

	@Override
	public String get(Object key) {
		return contents.get(key);
	}

	@Override
	public boolean isEmpty() {
		return contents.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return contents.keySet();
	}

	@Override
	public String put(String key, String value) {
		throw new UnsupportedOperationException("this object is immutable");
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		throw new UnsupportedOperationException("this object is immutable");
	}

	@Override
	public String remove(Object key) {
		throw new UnsupportedOperationException("this object is immutable");
	}

	@Override
	public int size() {
		return contents.size();
	}

	@Override
	public Collection<String> values() {
		return contents.values();
	}

}

package me.willynilly.argparse.utils;

public final class Triplet<T1, T2, T3> {
	
	public static <T1, T2, T3> Triplet<T1, T2, T3> create(T1 first, T2 second, T3 third) {
		return new Triplet<T1, T2, T3>(first, second, third);
	}
	
	private final T1 first;
	private final T2 second;
	private final T3 third;
	
	private Triplet(T1 first, T2 second, T3 third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public T1 first() {
		return first;
	}
	
	public T2 second() {
		return second;
	}
	
	public T3 third() {
		return third;
	}

}

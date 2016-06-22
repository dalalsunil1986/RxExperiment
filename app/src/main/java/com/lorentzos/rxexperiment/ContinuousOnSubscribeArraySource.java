package com.lorentzos.rxexperiment;

/**
 *
 */
public class ContinuousOnSubscribeArraySource<T> implements Continuous.OnSubscribe<T> {

	private final T[] array;

	public ContinuousOnSubscribeArraySource(T[] array) {
		this.array = array;
	}

	@SuppressWarnings("MethodCallInLoopCondition")
	@Override
	public void call(ContinuousSubscriber<? super T> s) {

		T[] a = array;
		int n = a.length;

		for (int i = 0; i < n && !s.isUnsubscribed(); i++) {
			T value = a[i];
			if (value == null) {
				throw new NullPointerException("The " + i + "th element is null");
			}
			s.onNext(value);
		}
	}

}

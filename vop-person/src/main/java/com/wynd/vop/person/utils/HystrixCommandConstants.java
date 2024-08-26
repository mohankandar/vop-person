package com.wynd.vop.person.utils;

/**
 * The Class HystrixCommandConstants.
 */
public final class HystrixCommandConstants {

	/** Person Service Thread Pool Group. */
	public static final String PERSON_SERVICE_GROUP_KEY = "PersonServiceGroup";

	/**
	 * Do not instantiate
	 */
	private HystrixCommandConstants() {
		throw new UnsupportedOperationException("HystrixCommandConstants is a static class. Do not instantiate it.");
	}
}
package com.divesoptserver37.domain.repository.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
	private static final AtomicLong id = new AtomicLong(1L);
	public static void init(Long initialSize) {
		id.addAndGet(initialSize);
	}
	public static long generate(){
		return id.getAndIncrement();
	}
}

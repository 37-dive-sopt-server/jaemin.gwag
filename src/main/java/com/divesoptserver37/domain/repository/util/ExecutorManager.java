package com.divesoptserver37.domain.repository.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorManager {
	private static final ExecutorService executor = Executors.newSingleThreadExecutor();

	private ExecutorManager() {}

	public static ExecutorService getExecutor() {
		return executor;
	}
	public static void shutdown() {
		executor.shutdown();
	}
}

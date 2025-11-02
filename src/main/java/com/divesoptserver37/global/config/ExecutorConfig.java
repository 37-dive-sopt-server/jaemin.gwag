package com.divesoptserver37.global.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {
	@Bean(destroyMethod = "shutdown")
	public ExecutorService fileSyncExecutor() {
		return Executors.newSingleThreadExecutor(r -> {
			Thread t = new Thread(r, "file-sync-thread");
			t.setDaemon(true);
			return t;
		});
	}
}

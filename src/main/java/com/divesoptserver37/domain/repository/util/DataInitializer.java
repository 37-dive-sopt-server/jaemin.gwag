package com.divesoptserver37.domain.repository.util;

import org.springframework.stereotype.Component;

import com.divesoptserver37.domain.repository.MemberRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
	private final MemberRepository memberRepository;

	public DataInitializer(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@PostConstruct
	public void init() {
		memberRepository.init();
	}
}

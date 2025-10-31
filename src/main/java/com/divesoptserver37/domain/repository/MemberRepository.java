package com.divesoptserver37.domain.repository;

import java.util.List;
import java.util.Optional;

import com.divesoptserver37.domain.entity.Member;

public interface MemberRepository {
	void init();
	Member save(Member member);
	Optional<Member> findById(Long id);
	List<Member> findAll();
	void deleteById(Long id);
	boolean existsByEmail(String email);
}

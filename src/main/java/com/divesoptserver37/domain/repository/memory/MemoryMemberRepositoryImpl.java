package com.divesoptserver37.domain.repository.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.divesoptserver37.domain.entity.Member;

@Repository
public class MemoryMemberRepositoryImpl implements MemoryMemberRepository {

	private static final Map<Long, Member> store = new HashMap<>();
	public void init(Map<Long, Member> storedData) {
		store.clear();
		store.putAll(storedData);
	}
	public Member save(Member member) {
		store.put(member.getId(), member);
		return member;
	}
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	public void deleteById(Long id) {
		store.remove(id);
	}
	public boolean existsByEmail(String email) {
		return store.values().stream()
			.anyMatch(member -> Objects.equals(member.getEmail(), email));
	}
}

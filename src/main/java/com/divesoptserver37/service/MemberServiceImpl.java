package com.divesoptserver37.service;

import java.util.List;
import java.util.Optional;

import com.divesoptserver37.domain.Member;
import com.divesoptserver37.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

	private MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	private static long sequence = 1L;

	public Long join(String name) {

		Member member = new Member(sequence++, name);
		memberRepository.save(member);
		return member.getId();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

	public List<Member> findAllMembers() {
		return memberRepository.findAll();
	}
}

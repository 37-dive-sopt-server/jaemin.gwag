package com.divesoptserver37.service;

import java.util.List;
import java.util.Optional;

import com.divesoptserver37.domain.Member;

public interface MemberService {


	Long join(String name);

	Optional<Member> findOne(Long memberId);

	List<Member> findAllMembers();
}

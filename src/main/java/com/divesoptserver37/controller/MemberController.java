package com.divesoptserver37.controller;

import java.util.List;
import java.util.Optional;

import com.divesoptserver37.domain.Member;
import com.divesoptserver37.service.MemberServiceImpl;

public class MemberController {

	private MemberServiceImpl memberServiceImpl = new MemberServiceImpl();

	public Long createMember(String name) {

		return memberServiceImpl.join(name);
	}

	public Optional<Member> findMemberById(Long id) {
		return memberServiceImpl.findOne(id);
	}

	public List<Member> getAllMembers() {
		return memberServiceImpl.findAllMembers();
	}
}


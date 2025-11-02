package com.divesoptserver37.domain.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.divesoptserver37.domain.dto.request.CreateMemberRequest;
import com.divesoptserver37.domain.dto.response.MemberInfoResponse;
import com.divesoptserver37.domain.entity.Gender;
import com.divesoptserver37.domain.entity.Member;
import com.divesoptserver37.domain.repository.memory.MemoryMemberRepository;
import com.divesoptserver37.domain.repository.util.IdGenerator;
import com.divesoptserver37.global.exception.BadRequestException;
import com.divesoptserver37.global.exception.NotFoundException;
import com.divesoptserver37.global.exception.code.ErrorCode;

@Service
public class MemberService {

	private final MemoryMemberRepository memberRepository;

	public MemberService(MemoryMemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void createMember(CreateMemberRequest createMemberRequest) {

		if(memberRepository.existsByEmail(createMemberRequest.email())) {
			throw new BadRequestException(ErrorCode.ALREADAY_EXIST_EMAIL);
		}

		Member newMember = Member.create(
			IdGenerator.generate(),
			createMemberRequest.name(),
			createMemberRequest.email(),
			createMemberRequest.birthday(),
			Gender.fromValue(createMemberRequest.gender())
		);

		memberRepository.save(newMember);
	}

	public MemberInfoResponse getMember(final Long userId){
		Member member = memberRepository.findById(userId)
			.orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND));

		return MemberInfoResponse.from(member);
	}

	public List<MemberInfoResponse> getMemberList() {
		List<Member> memberList = memberRepository.findAll();
		List<MemberInfoResponse> memberInfoResponseList = memberList.stream()
			.map(MemberInfoResponse::from)
			.toList();

		return memberInfoResponseList;
	}

	public void delete(final Long memberId) {
		if(!memberRepository.findById(memberId).isPresent()) {
			throw new NotFoundException(ErrorCode.USER_NOT_FOUND);
		}
		memberRepository.deleteById(memberId);
	}
}

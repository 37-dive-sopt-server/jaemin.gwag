package com.divesoptserver37.domain.member.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divesoptserver37.domain.member.dto.request.CreateMemberRequest;
import com.divesoptserver37.domain.member.dto.response.MemberInfoResponse;
import com.divesoptserver37.domain.member.entity.Gender;
import com.divesoptserver37.domain.member.entity.Member;
import com.divesoptserver37.domain.member.repository.MemberRepository;
import com.divesoptserver37.global.exception.BadRequestException;
import com.divesoptserver37.global.exception.NotFoundException;
import com.divesoptserver37.global.exception.code.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public void createMember(CreateMemberRequest createMemberRequest) {

		if(memberRepository.existsByEmail(createMemberRequest.email())) {
			throw new BadRequestException(ErrorCode.ALREADAY_EXIST_EMAIL);
		}

		Member newMember = Member.create(
			createMemberRequest.name(),
			createMemberRequest.email(),
			createMemberRequest.birthday(),
			Gender.fromValue(createMemberRequest.gender())
		);

		memberRepository.save(newMember);
	}

	public MemberInfoResponse getMember(final Long userId){
		Member member = getMemberById(userId);
		return MemberInfoResponse.from(member);
	}

	public List<MemberInfoResponse> getMemberList() {
		List<Member> memberList = memberRepository.findAll();
		List<MemberInfoResponse> memberInfoResponseList = memberList.stream()
			.map(MemberInfoResponse::from)
			.toList();

		return memberInfoResponseList;
	}

	@Transactional
	public void delete(final Long memberId) {
		if(!memberRepository.findById(memberId).isPresent()) {
			throw new NotFoundException(ErrorCode.USER_NOT_FOUND);
		}
		memberRepository.deleteById(memberId);
	}

	public Member getMemberById(final Long memberId) {
		return memberRepository.findById(memberId)
			.orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND));
	}
}

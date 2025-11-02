package com.divesoptserver37.domain.controller;

import static com.divesoptserver37.global.util.Validator.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divesoptserver37.domain.dto.request.CreateMemberRequest;
import com.divesoptserver37.domain.dto.response.MemberInfoResponse;
import com.divesoptserver37.domain.service.MemberService;
import com.divesoptserver37.global.exception.code.SuccessCode;
import com.divesoptserver37.global.exception.dto.SuccessResponse;
import com.divesoptserver37.global.util.Validator;

@RestController
@RequestMapping("/users")
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping
	public ResponseEntity<SuccessResponse<?>> createMember(
		@RequestBody CreateMemberRequest createMemberRequest
	) {
		validate(createMemberRequest);
		memberService.createMember(createMemberRequest);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));

	}

	@GetMapping("/{userId}")
	public ResponseEntity<SuccessResponse<MemberInfoResponse>> getMemberInfo(
		@PathVariable Long userId
	){
		MemberInfoResponse memberInfoResponse = memberService.getMember(userId);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, memberInfoResponse));
	}

	@GetMapping
	public ResponseEntity<SuccessResponse<?>> getMembers(
	){
		List<MemberInfoResponse> memberInfoResponseList = memberService.getMemberList();
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, memberInfoResponseList));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<SuccessResponse> deleteMember(
		@PathVariable Long userId
	) {
		memberService.delete(userId);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_DELETE));
	}


}


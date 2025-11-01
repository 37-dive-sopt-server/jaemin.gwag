package com.divesoptserver37.domain.dto.response;

import java.time.LocalDate;

import com.divesoptserver37.domain.entity.Gender;
import com.divesoptserver37.domain.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

public record MemberInfoResponse(
	Long id,
	String name,
	String email,
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
	LocalDate birthday,
	Gender gender
) {
	public static MemberInfoResponse from(Member member) {
		return new MemberInfoResponse(
			member.getId(),
			member.getName(),
			member.getEmail(),
			member.getBirthday(),
			member.getGender()
		);
	}
}

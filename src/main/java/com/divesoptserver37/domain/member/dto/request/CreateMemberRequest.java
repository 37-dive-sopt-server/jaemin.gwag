package com.divesoptserver37.domain.member.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreateMemberRequest(
	@NotNull(message = "이름은 필수 입력값입니다")
	String name,
	@NotNull(message = "이메일은 필수 입력값입니다")
	@Email
	String email,
	@NotNull(message = "생일은 필수 입력값입니다")
	LocalDate birthday,
	@NotNull(message = "성별은 필수 입력값입니다")
	String gender
) {
}

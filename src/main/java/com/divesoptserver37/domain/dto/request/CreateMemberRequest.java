package com.divesoptserver37.domain.dto.request;

import java.time.LocalDate;

public record CreateMemberRequest(
	String name,
	String email,
	LocalDate birthday,
	String gender
) {
}

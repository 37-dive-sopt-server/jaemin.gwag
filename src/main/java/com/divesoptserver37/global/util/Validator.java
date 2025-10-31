package com.divesoptserver37.global.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import com.divesoptserver37.domain.dto.request.CreateMemberRequest;

public class Validator {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z가-힣]{2,20}$"); // 2~20자 한글/영문만

	public static void validate(CreateMemberRequest request) {
		validateName(request.name());
		validateEmail(request.email());
		validateBirthday(request.birthday());
	}

	public static void validateName(String name) {
		if (name == null || !NAME_PATTERN.matcher(name).matches()) {
			throw new IllegalArgumentException("이름 형식이 올바르지 않습니다. (2~20자, 특수문자 불가)");
		}
	}

	public static void validateEmail(String email) {
		if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
		}
	}

	public static void validateBirthday(LocalDate birthday) {
		if (birthday == null) {
			throw new IllegalArgumentException("생년월일은 필수값입니다.");
		}

		if (birthday.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("미래 날짜는 입력할 수 없습니다.");
		}
		int age = Period.between(birthday, LocalDate.now()).getYears();
		if (age < 20) {
			throw new IllegalArgumentException("20세 미만은 가입할 수 없습니다.");
		}
	}


}

package com.divesoptserver37.domain.entity;

public enum Gender {
	MALE("남자"),
	FEMALE("여자");

	private final String value;

	Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Gender fromValue(String value) {
		for (Gender gender : Gender.values()) {
			if (gender.value.equalsIgnoreCase(value)) {
				return gender;
			}
		}
		throw new IllegalArgumentException("성별 값이 올바르지 않습니다. (M/F)");
	}
}

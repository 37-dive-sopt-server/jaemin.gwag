package com.divesoptserver37.domain.article.entity;

import com.divesoptserver37.global.exception.BadRequestException;
import com.divesoptserver37.global.exception.code.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Tag {
	CS("CS"),
	DB("데이터베이스"),
	SPRING("스프링"),
	ETC("기타");

	private final String value;

	public static Tag fromValue(String value) {
		for (Tag tag : Tag.values()) {
			if (tag.value.equalsIgnoreCase(value)) {
				return tag;
			}
		}
		throw new BadRequestException(ErrorCode.BAD_REQUEST_DATA);
	}

}

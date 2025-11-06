package com.divesoptserver37.domain.member.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private LocalDate birthday;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public Member(String name, String email, LocalDate birthday, Gender gender) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
	}

	public static Member create(String name, String email, LocalDate birthday, Gender gender) {
		return new Member(name, email, birthday, gender);
	}
}


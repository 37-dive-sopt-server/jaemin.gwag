package com.divesoptserver37.domain.article.entity;

import java.time.LocalDateTime;

import com.divesoptserver37.domain.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tag tag;

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Member.class)
	@JoinColumn(name = "memberId", nullable = false)
	private Member member;

	public Article(String title, String content, Tag tag, Member member) {
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.member = member;
	}

	public static Article create(String title, String content, Tag tag, Member member) {
		return new Article(title, content, tag, member);
	}
}

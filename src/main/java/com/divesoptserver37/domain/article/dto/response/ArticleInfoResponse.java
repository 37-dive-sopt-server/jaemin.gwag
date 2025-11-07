package com.divesoptserver37.domain.article.dto.response;

import java.time.LocalDateTime;

import com.divesoptserver37.domain.article.entity.Article;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

public record ArticleInfoResponse(
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String memberName,
	Long articleId,
	String title,
	String content,
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
	LocalDateTime createdAt
) {
	@Builder
	public static ArticleInfoResponse from(Article article) {
		final String name = (article.getMember() != null) ? article.getMember().getName() : null;
		return new ArticleInfoResponse(
			article.getMember().getName(),
			article.getId(),
			article.getTitle(),
			article.getContent(),
			article.getCreatedAt()
		);
	}
}

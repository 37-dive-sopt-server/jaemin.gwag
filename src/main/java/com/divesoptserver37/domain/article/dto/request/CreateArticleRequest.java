package com.divesoptserver37.domain.article.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateArticleRequest(
	@NotNull(message = "제목은 필수 입력값입니다")
	String title,
	@NotNull(message = "내용은 필수 입력값입니다")
	String content,
	@NotNull(message = "태그는 필수 입력값입니다")
	String tag
) {
}

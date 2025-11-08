package com.divesoptserver37.domain.article.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divesoptserver37.domain.article.dto.request.CreateArticleRequest;
import com.divesoptserver37.domain.article.dto.response.ArticleInfoResponse;
import com.divesoptserver37.domain.article.service.ArticleService;
import com.divesoptserver37.global.exception.code.SuccessCode;
import com.divesoptserver37.global.exception.dto.SuccessResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
	private final ArticleService articleService;

	@PostMapping
	public ResponseEntity<SuccessResponse<?>> createArticle(
		@RequestHeader Long memberId,
		@Valid @RequestBody CreateArticleRequest createArticleRequest
	){
		articleService.createArticle(memberId, createArticleRequest);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
	}

	@GetMapping("/{articleId}")
	public ResponseEntity<SuccessResponse<ArticleInfoResponse>> getArticle(
		@PathVariable Long articleId
	) {
		ArticleInfoResponse articleInfo = articleService.getArticle(articleId);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, articleInfo));
	}

	@GetMapping
	public ResponseEntity<SuccessResponse<?>> getArticles(){
		List<ArticleInfoResponse> articleInfoResponseList = articleService.getAllArticles();
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, articleInfoResponseList));
	}

	@GetMapping("/search")
	public ResponseEntity<SuccessResponse<?>> searchArticles(
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String title
	){
		List<ArticleInfoResponse> articleInfoResponseList = articleService.searchArticles(name, title);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, articleInfoResponseList));

	}
}

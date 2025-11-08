package com.divesoptserver37.domain.article.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divesoptserver37.domain.article.dto.request.CreateArticleRequest;
import com.divesoptserver37.domain.article.dto.response.ArticleInfoResponse;
import com.divesoptserver37.domain.article.entity.Article;
import com.divesoptserver37.domain.article.entity.Tag;
import com.divesoptserver37.domain.article.repository.ArticleRepository;
import com.divesoptserver37.domain.member.entity.Member;
import com.divesoptserver37.domain.member.service.MemberService;
import com.divesoptserver37.global.exception.BadRequestException;
import com.divesoptserver37.global.exception.NotFoundException;
import com.divesoptserver37.global.exception.code.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
	private final ArticleRepository articleRepository;
	private final MemberService memberService;

	@Transactional
	public void createArticle(Long memberId, CreateArticleRequest createArticleRequest) {
		Member member = memberService.getMemberById(memberId);

		if(articleRepository.existsByTitle(createArticleRequest.title())){
			throw new BadRequestException(ErrorCode.ALREADY_EXIST_TITLE);
		}

		Article newArticle = Article.create(
			createArticleRequest.title(),
			createArticleRequest.content(),
			Tag.fromValue(createArticleRequest.tag()),
			member
		);

		articleRepository.save(newArticle);
	}

	public ArticleInfoResponse getArticle(final Long articleId) {
		Article article = articleRepository.findById(articleId)
			.orElseThrow(() -> new NotFoundException(ErrorCode.DATA_NOT_FOUND));

		return ArticleInfoResponse.from(article);
	}

	public List<ArticleInfoResponse> getAllArticles() {
		List<Article> articles = articleRepository.findAll();
		return articles.stream()
			.map(ArticleInfoResponse::from)
			.toList();
	}

	public List<ArticleInfoResponse> searchArticles(final String title, final String name){
		List<Article> articleList = articleRepository.searchByTitleAndAuthor(title, name);
		return articleList.stream()
			.map(ArticleInfoResponse::from)
			.toList();
	}

}

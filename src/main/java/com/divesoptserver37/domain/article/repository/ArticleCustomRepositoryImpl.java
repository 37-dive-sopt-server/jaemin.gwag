package com.divesoptserver37.domain.article.repository;

import static com.divesoptserver37.domain.article.entity.QArticle.*;
import static com.divesoptserver37.domain.member.entity.QMember.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.divesoptserver37.domain.article.entity.Article;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ArticleCustomRepositoryImpl implements ArticleCustomRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Article> searchByTitleAndAuthor(String title, String name) {
		return queryFactory
			.selectFrom(article)
			.leftJoin(article.member, member).fetchJoin()
			.where(
				titleContain(title),
				authorContain(name)
			)
			.orderBy(article.createdAt.desc())
			.fetch();

	}

	private BooleanExpression titleContain(String title) {
		return (title == null || title.isBlank()) ? null : article.title.containsIgnoreCase(title);
	}

	private BooleanExpression authorContain(String name) {
		return (name == null || name.isBlank()) ? null : member.name.containsIgnoreCase(name);
	}
}

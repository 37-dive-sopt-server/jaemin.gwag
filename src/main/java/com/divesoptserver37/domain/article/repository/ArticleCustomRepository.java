package com.divesoptserver37.domain.article.repository;

import java.util.List;

import com.divesoptserver37.domain.article.entity.Article;

public interface ArticleCustomRepository {
	List<Article> searchByTitleAndAuthor(String title, String name);
}

package com.divesoptserver37.domain.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divesoptserver37.domain.article.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {
	boolean existsByTitle(String title);
}

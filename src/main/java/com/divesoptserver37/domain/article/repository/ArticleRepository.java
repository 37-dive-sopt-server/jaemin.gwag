package com.divesoptserver37.domain.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divesoptserver37.domain.article.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {
	boolean existsByTitle(String title);

	@EntityGraph(attributePaths = {"member"})
	List<Article> findAll();

	@EntityGraph(attributePaths = {"member"})
	Optional<Article> findById(Long id);
}

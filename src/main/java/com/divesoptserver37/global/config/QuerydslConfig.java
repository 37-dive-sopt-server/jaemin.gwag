package com.divesoptserver37.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

@Component
public class QuerydslConfig {
	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}
}

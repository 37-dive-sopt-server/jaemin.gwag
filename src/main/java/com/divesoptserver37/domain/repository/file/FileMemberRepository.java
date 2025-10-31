package com.divesoptserver37.domain.repository.file;

import java.util.Map;

import com.divesoptserver37.domain.entity.Member;

public interface FileMemberRepository {
	Map<Long, Member> load();
	void save(Member member);
	void deleteById(long id);
}

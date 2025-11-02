package com.divesoptserver37.domain.repository.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.divesoptserver37.domain.entity.Member;
import com.divesoptserver37.domain.repository.util.FileIOManager;

@Repository
public class FileMemberRepositoryImpl implements FileMemberRepository {
	private final FileIOManager fileIOManager;

	public FileMemberRepositoryImpl(FileIOManager fileIOManager) {
		this.fileIOManager = fileIOManager;
	}

	private List<Member> readMembers() {
		try (ObjectInputStream ois = fileIOManager.openObjectReader()) {
			if (ois == null) {
				return new ArrayList<>();
			}
			return (List<Member>)ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeMembers(List<Member> members) {
		try(ObjectOutputStream oos = fileIOManager.openObjectWriter()){
			oos.writeObject(members);
		} catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	public Map<Long, Member> load() {
		List<Member> members = readMembers();
		return members.stream()
			.collect(Collectors.toMap(Member::getId, member -> member));
	}

	public void save(Member member) {
		List<Member> members = readMembers();
		members.add(member);
		writeMembers(members);
	}

	public void deleteById(long id) {
		List<Member> members = readMembers();
		members.removeIf(member -> member.getId() == id);
		writeMembers(members);
	}
}

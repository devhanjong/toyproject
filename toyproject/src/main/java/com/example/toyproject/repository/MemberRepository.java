package com.example.toyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
	
	Member findByUid(String uid);

	Member findByUidAndUpw(String uid, String upw);
	
}
  
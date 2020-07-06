package com.example.toyproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.model.Member;
import com.example.toyproject.model.MemberRole;

@Repository
public interface MemberRoleRepository extends JpaRepository<Member, String>{
	
	List<MemberRole> findByUid(String uid);
	
	
}

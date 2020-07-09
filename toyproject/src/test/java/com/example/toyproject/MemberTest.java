package com.example.toyproject;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.Comment;
import com.example.toyproject.model.Member;
import com.example.toyproject.model.MemberRole;
import com.example.toyproject.repository.BoardRepository;
import com.example.toyproject.repository.CommentRepository;
import com.example.toyproject.repository.MemberRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
@Commit
public class MemberTest {
	@Autowired
	private MemberRepository mr;
	
	@Autowired
	private BoardRepository br;
	
	@Autowired
	PasswordEncoder pe;

	@Test
	public void testInsert() {
		for (int i = 0; i <= 100; i++) {
			Member member = new Member();
			member.setUid("user" + i);
			String pw = pe.encode("pw" + i);
			member.setUpw(pw);
			member.setUname("사용자" + i);
			member.setUemail("aa" + i + "@Email.com");

			MemberRole role = new MemberRole();
			if (i <= 80) {
				role.setRolename("BASIC");
			} else if (i <= 90) {
				role.setRolename("MANAGER");
			} else {
				role.setRolename("ADMIN");
			}
			member.setRoles(Arrays.asList(role));

			mr.save(member);
		}
	}

	@Test
	public void testInsert2() {
		Member mem = mr.findById("user31").get();
		for (int i = 0; i <= 100; i++) {
			Board board = new Board();
			board.setBbsId(i);
			board.setBbsTitle("title" + i);
			board.setMember(mem);
			board.setOFileName("origianl"+i);
			board.setSFileName("save"+i);
			board.setSFileURL("url"+ i+ ".png" );
			board.setViews(i);
			board.setBbsContent("content" + i);
			br.save(board);
		}
	}

	@Test
	public void testRead() {
		Optional<Member> result = mr.findById("user85");
		result.ifPresent(member -> log.info("member" + member));

	}

	@Test
	public void testRead2() {
    	Board board = br.findById(98L).get();
    	System.out.println("@$%@$^"+board);
    	 List<Comment> commentlist = cr.findByBoard(board);
    	 System.out.println("%^*%$*^"+ commentlist);
	}
	
}

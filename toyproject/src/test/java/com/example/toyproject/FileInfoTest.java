package com.example.toyproject;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.FileInfo;
import com.example.toyproject.model.Member;
import com.example.toyproject.model.MemberRole;
import com.example.toyproject.repository.BoardRepository;
import com.example.toyproject.repository.FileInfoRepository;
import com.example.toyproject.repository.MemberRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
@Commit
public class FileInfoTest {
	@Autowired
	private FileInfoRepository fr;
	
	@Autowired
	private BoardRepository br;
	
	@Autowired
	PasswordEncoder pe;

	@Test
	public void testInsert() {
		for (int i = 0; i <= 100; i++) {
			FileInfo fileinfo = new FileInfo();
			fileinfo.setFId(i);
			fileinfo.setFileName("filename" + i);
			fileinfo.setFileOriginalName("fileoriginalname" + i);
			fileinfo.setFileUrl("fielURL" +i);
			fr.save(fileinfo);
		}
	}

	



}

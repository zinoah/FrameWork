package edu.kh.comm.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MemberDAO;
import edu.kh.comm.member.model.dao.MyPageDAO;
import edu.kh.comm.member.model.vo.Member;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO dao;

	@Autowired 
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public int secession(Member loginMember) {
		
		
		int result = 0;

		
		// 비밀번호 확인
		String currentPw = dao.checkPw(loginMember);
		
		if(bcrypt.matches(loginMember.getMemberPw(), currentPw)) {
			result = dao.secession(loginMember);
		} else {
			result = 0;
		}
		
		return result;
	}
	
}

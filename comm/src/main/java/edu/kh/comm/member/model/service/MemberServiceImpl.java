package edu.kh.comm.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MemberDAO;
import edu.kh.comm.member.model.vo.Member;

@Service // 비즈니스 로직(데이터 가공, DB연결)을 처리하는 클래스임을 명시 + bean 등록 
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;

	/* Connection을 Service에서 얻어오는 이유
	 * 
	 * -Service 의 메서드 하나는 요청 처리하는 업무 단위
	 * -> 해당 업무가 끝난 후 트랜잭션을 번에 처리하기 위해서
	 * 어쩔수 없이 Connection을 Service에서 얻어올 수 밖에 없다
	 * 
	 * 
	 * */
	// 로그인 서비스 구현
	@Override
	public Member login(Member inputMember) {
		Member loginMember = dao.login(inputMember);
		return loginMember;
		
		// Connection을 얻어오거나 / 반환하거나
		// 트랜잭션처리를 하는 구문을 작성하지 않아도
		// Spring에서 제어를 하기때문에 Service 구문이간단해진다
	}
}

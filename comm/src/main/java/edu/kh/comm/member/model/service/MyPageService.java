package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.vo.Member;

public interface MyPageService {

	
	/** 회원 탈퇴 서비스
	 * @param loginMember
	 * @return result
	 */
	int secession(Member loginMember);

}

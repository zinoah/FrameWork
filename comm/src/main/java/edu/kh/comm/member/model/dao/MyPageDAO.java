package edu.kh.comm.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.member.model.vo.Member;
@Repository
public class MyPageDAO {
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(MyPageDAO.class);

	/** 비밀번호 확인 DAO
	 * @param loginMember
	 * @return
	 */
	public String checkPw(Member loginMember) {
		
		return sqlSession.selectOne("myPageMapper.checkPw", loginMember);
	}

	/** 회원탈퇴 DAO
	 * @param loginMember
	 * @return
	 */
	public int secession(Member loginMember) {
		
		return sqlSession.update("myPageMapper.secession", loginMember);
	}

}

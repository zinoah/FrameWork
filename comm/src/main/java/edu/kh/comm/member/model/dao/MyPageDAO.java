package edu.kh.comm.member.model.dao;

import java.util.Map;

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
	

	

	/** 회원 정보 수정 DAO
	 * @param paramMap
	 * @return result
	 */
	public int updateInfo(Map<String, Object> paramMap) {
		
		
		return sqlSession.update("myPageMapper.updateInfo", paramMap);
	}

	/** 현재 로그인한 회원의 암호화된 비밀번호 조회 DAO
	 * @param memberNo
	 * @return encPw
	 */
	public String selectEncPw(int memberNo) {
		
		return sqlSession.selectOne("myPageMapper.selectEncPw" , memberNo);
	}

	/** 비밀번호 변경 DAO
	 * @param paramMap
	 * @return result
	 */
	public int changePw(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("myPageMapper.changePw", paramMap);
	}

	/** 회원탈퇴 DAO
	 * @param memberNo
	 * @return
	 */
	public int secession(int memberNo) {
		
		return sqlSession.update("myPageMapper.secession", memberNo);
	}

	public int updateProfile(Map<String, Object> map) {
		return sqlSession.update("myPageMapper.updateProfile",map);
	}
}

package edu.kh.comm.common.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 런타임시 필요한 위치에 코드를 알아서 참여시킬 수 있도록 bean 등록 
@Aspect // 공통 관심사(특정 흐름 사이에 끼여서 수행할 코드)가 작성된 클래스임을 명시 
	// -> 해당 어노테이션이 작성된 클래스에는 
	// advice (끼어들어서 수행할 메서드)
	// pointcut ( advice가 끼어들어서 수행될 부분) 이 작성되어 있어야 한다. 
public class TestAspect {
	
	private Logger logger = LoggerFactory.getLogger(TestAspect.class);
	
	// joinpoint : advice 가 적용될 수 있는 지점 (후보)
	// pointcut : joinpoint 중에서 실제로 advice를 적용할 지점 선택 
	
	// ** Pointcut 작성방법 **
	// @Pointcut("execution([접근제한자] 반환형 패키지+클래스명.메서드명([매개변수]))")
	
		// * : 모든 | 아무 값
		// .. : 하위 | 아래  (하위 패키지)  | 0개 이상의 매개변수
	
	// edu.kh.comm.member 패키지 아래에 Impl로 끝나는 클래스의 모든 메서드(매개변수 관계없음) 
	//@Before("memberPointcout()")
	@Before("CommonPointcut.implPointcut()")
	public void start() {
		logger.info("--------------------------Service Start---------------------------");
	}
	
	@After("memberPointcout()")
	public void edn() {
		logger.info("--------------------------Service End---------------------------");
	}
	// pointcut을 작성해놓은 메서드
	// -> pointcout의 패턴이 작성되는 부분에 memberPointcut 메서드 이름을 작성하면 
	// @Pointcut에 작성된 패턴이 적용된다 
	@Pointcut("execution(* edu.kh.comm.member..*Impl.*(..))")
	public void memberPointcout() {}//내용 작성 X
}

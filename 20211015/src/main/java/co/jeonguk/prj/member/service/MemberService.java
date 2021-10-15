package co.jeonguk.prj.member.service;

public interface MemberService {
	MemberVO memberLogin(MemberVO vo);
	String encKey();		//암호화 키를 가져오는 메소드
}

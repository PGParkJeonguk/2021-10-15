package co.jeonguk.prj;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import co.jeonguk.prj.aes256.AES256;
import co.jeonguk.prj.hash.Password;
import co.jeonguk.prj.member.service.MemberService;
import co.jeonguk.prj.member.service.MemberVO;
import co.jeonguk.prj.member.serviceImpl.MemberServiceImpl;
import co.jeonguk.prj.queue.Queue;
import co.jeonguk.prj.stack.Stack;

public class MainApp {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		Scanner sc = new Scanner(System.in);
		
		Password enc = new Password();
		AES256 aes = new AES256();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		String encKey = memberDao.encKey();
		System.out.println("아이디를 입력하세요.");
		member.setId(sc.nextLine());
		System.out.println("패스워드를 입력하세요.");
		String password = sc.nextLine();	//입력된 패스워드를 암호화
		memberDao.memberLogin(member);
		member.setPassword(enc.sha512(password, encKey));
		
		
		
		
		
		member = memberDao.memberLogin(member);
		if(member.getName() != null) {
			System.out.println(aes.decrypt(member.getAuthor()));
			System.out.print(member.getName());
			System.out.println("님 환영합니다.");
		}else {
			System.out.println("아이디 또는 패스워드가 틀렸습니다.");
		}
		
		sc.close();
//			
		
//		Stack stack = new Stack();
//		stack.push('a');
//		stack.push('b');
//		stack.push('c');
//		
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		
//		Queue queue = new Queue();
//		queue.push(1);
//		queue.push(2);
//		queue.push(3);
//		queue.push(4);
//		queue.push(5);
//		
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		
//		queue.push(6);
//		queue.push(7);
//		
//		System.out.println(queue.get());
//		System.out.println(queue.get());
//		System.out.println(queue.get());
		
//		Password enc = new Password();
//		String password = "7892";
//		String enckey = "@#$123*&++_)548)*&";
//		System.out.println(enc.sha512(password, enckey));
		
//		AES256 aes256 = new AES256();
//		String encStr = aes256.encrypt("ADMIN");
//		System.out.println(encStr);
		
		
		
	}
}

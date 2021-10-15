package co.jeonguk.prj.stack;

public class Stack {
	private char[] stack = new char[10];		//문자스택
	private int top = -1;
	
	public void push(char c) {		//스택에 데이터 집어넣는 함수
		if(top > stack.length -1  ) {		//스택 꽉참
			System.out.println("스택이 꽉찼습니다.");	
		}else {
			stack[++top] = c;
		}
	}
	
	public char pop() {
		char data = ' ';
		if(top < 0) {
			System.out.println("스택이 비었습니다.");
		}else {
			data = stack[top--];
		}
		return data;
	}

		
	}


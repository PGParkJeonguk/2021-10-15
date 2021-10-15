package co.jeonguk.prj.queue;

public class Queue {
	private int[] queue = new int[10];
	private int rear = -1;
	private int front = -1;

	public void push(int n) {
		if (rear > queue.length - 1) {
			System.out.println("Queue의 데이터가 꽉 찼습니다.");
		} else {
			queue[++rear] = n;
		}
	}

	public int get() {
		if (front == rear || front > queue.length - 1) {
			System.out.println("Queue의 데이터가 비어있습니다.");
			return -1;
		} else {
			return queue[++front];
		}

	}

}

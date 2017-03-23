package a1;

public class AQueueTester {

	public static void main(String[] args) {
		AQueue<Integer> obj = new AQueue<Integer>(4);
		obj.enqueue(256);
		System.out.println(obj.toString());
		obj.enqueue(32);
		System.out.println(obj.toString());
		int temp=obj.dequeue();
		System.out.println(obj.toString());
		obj.enqueue(512);
		System.out.println(obj.toString());
		obj.enqueue(1024);
		System.out.println(obj.toString());
		obj.enqueue(2048);
		System.out.println(obj.toString());
		//obj.enqueue(4096);
		obj.dequeue();
		System.out.println(obj.toString());
		obj.dequeue();
		System.out.println(obj.toString());
		obj.dequeue();
		System.out.println(obj.toString());
		obj.dequeue();
		System.out.println(obj.toString());
		System.out.println(obj.front());
		System.out.println(obj.size());
		System.out.println(temp);
	}
}

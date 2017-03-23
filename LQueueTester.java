package a1;

public class LQueueTester {

	public static void main(String[] args) {
		LQueue<Integer> obj = new LQueue<Integer>();
		System.out.println(obj.size());
		
		obj.enqueue(45);
		System.out.println(obj.toString());
		System.out.println(obj.front());
		obj.enqueue(96);
		System.out.println(obj.toString());
		System.out.println(obj.size());
		obj.dequeue();
		System.out.println(obj.toString());
		System.out.println(obj.size());
		obj.enqueue(69);
		System.out.println(obj.toString());
		System.out.println(obj.size());
		obj.dequeue();
		System.out.println(obj.toString());
		System.out.println(obj.size());
		int temp = obj.dequeue();
		System.out.println(temp);
		System.out.println(obj.toString());
		System.out.println(obj.size());
	}

}

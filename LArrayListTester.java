package a1;

public class LArrayListTester {

	public static void main(String[] args) {
		//int size;
		LArrayList<Integer> obj = new LArrayList<Integer>();
		System.out.println(obj.toString());
		obj.add(0, 69);
		
		System.out.println(obj.toString());
		obj.add(1, 45);
		System.out.println(obj.toString());
		obj.add(2, 645);
		System.out.println(obj.toString());
		obj.add(1, 32);
		System.out.println(obj.toString());
		System.out.println(obj.size()+"\n");
		obj.set(3, 3);
		System.out.println(obj.toString());
		int b=obj.remove(0);
		System.out.println(obj.toString());
		System.out.println("The removed value was: " +b+"\n"+ obj.toString());
		obj.remove(1);
		System.out.println(obj.toString());
		obj.remove(0);
		System.out.println(obj.toString());
	}

}

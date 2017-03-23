package a1;

public class AArrayListTester {

	public static void main(String[] args) {
		
		AArrayList<Integer> obj = new AArrayList<Integer>(5);
		obj.add(0, 2);
		System.out.println(obj.toString());
		System.out.println(obj.size());
		obj.add(1, 69);
		System.out.println(obj.get(1));
		System.out.println(obj.toString());
		obj.add(2, 32);
		System.out.println(obj.toString());
		obj.add(3, 4);
		System.out.println(obj.toString());
		obj.add(0, 11);
		System.out.println(obj.toString());
		obj.add(4, 55);
		System.out.println(obj.toString());
		obj.add(5, 23);
		System.out.println(obj.toString());
		System.out.println(obj.size());
		obj.remove(1);
		System.out.println(obj.toString());
		obj.remove(4);
		System.out.println(obj.toString());
		obj.set(2, 96);
		System.out.println(obj.toString());
		System.out.println(obj.size());
	}

}

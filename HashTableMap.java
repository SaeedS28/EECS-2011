import java.util.Random;

public class HashTableMap<K, V> implements Map<K, V> {

	/**
	 * A concrete class which implements the Entry ADT
	 * @author Saad
	 *
	 */
	public static class EntryClass<K,V > implements Entry<K,V>{

		protected K key; //key for an entry
		protected V val; // value associated with the entry
		
		//Ctor
		
		/**
		 * Initializes a new key for the map
		 * 
		 * @param k the key
		 * @param v the value
		 */
		public EntryClass(K k, V v){
			this.key=k;
			this.val=v;
		}
		
		/**
		 * Sets a new value associated with an existing key.
		 * @param v the new value
		 * @return the old value
		 */
		public V setValue(V v){
			V old=this.getValue();
			this.val=v;
			return old;
		}
		
		public K getKey() {
			return key;
		}

		public V getValue() {
			return val;
		}
		
		public boolean equals(Object o){
			EntryClass<K,V> entry;
			if(this.getClass()==o.getClass()){
				entry=(EntryClass<K,V>) o;
			}
			else{
				return false;
			}
			return((entry.getKey()==this.getKey()) && (entry.getValue()==this.getValue()));
		}
		
		public String toString(){
			return("(" + this.key+","+this.val+")");
		}
	}
	
	protected Entry<K,V> avail=new EntryClass<K,V>(null,null);//An empty entry
	private static final int DEFAULT_CAPACITY=1000;//Default capacity of the map
	private static final int DEFAULT_PRIME=109345121;//default hash prime value
	protected int number=0;//size of the array
	protected int prime, capacity;
	protected Entry<K,V>[] bucket;//storage for the entry
	protected long scale, shift;
	
	//Ctors
	/**
	 * Default CTor which assigns everything a default value
	 */
	public HashTableMap(){
		this(DEFAULT_PRIME, DEFAULT_CAPACITY);
	}
	
	/**
	 * Initializes an object with a known map dimension
	 * @param cap the capacity
	 */
	public HashTableMap(int cap){
		this(DEFAULT_PRIME,cap);
	}
	
	/**
	 * Initializes the map with a known size and hashing value 
	 * @param primeb the hash prime value
	 * @param cap the capacity of the map
	 */
	public HashTableMap(int prime, int cap){
		this.prime=prime;
		this.capacity=cap;
		bucket=(Entry<K,V>[]) new Entry[capacity];
		Random random=new Random();
		scale=random.nextInt(this.prime-1)+1;
		shift=random.nextInt(this.prime);
	}
	
	@Override
	public int size() {
		return this.number;
	}

	@Override
	public boolean isEmpty() {
		return(this.number==0);
	}
	
	@Override
	public V get(K key) throws InvalidKeyException {
		int ret=findEntry(key);
		if(ret<0){
			return null;
		}
		return bucket[ret].getValue();
	}

	@Override
	public V put(K key, V value) throws InvalidKeyException {
		int probe=this.findEntry(key);
		if(probe>=0){
			return((EntryClass<K,V>)bucket[probe]).setValue(value);
		}
		if(this.number>=this.capacity/2){
			rehash();
			probe=findEntry(key);
		}
		bucket[-probe-1]=new EntryClass<K,V>(key,value);
		++this.number;
		return null;
	}

	@Override
	public V remove(K key) throws InvalidKeyException {
		int probe=findEntry(key);
		if(probe<0){
			return null;
		}
		V returnVal=bucket[probe].getValue();
		bucket[probe]=avail;
		--this.number;
		return returnVal;
	}

	@Override
	public Iterable<K> keySet() {
		NodePositionalList<K> keys=new NodePositionalList<K>();
		for(int i=0;i<this.capacity;i++){
			if((bucket[i]!=null)&&(bucket[i]!=avail)){
				keys.addLast(bucket[i].getKey());
			}
		}
		return keys;
	}

	@Override
	public Iterable<V> values() {
		NodePositionalList<V> vals=new NodePositionalList<V>();
		for(int i=0;i<this.capacity;i++){
			if((bucket[i]!=null)&&(bucket[i]!=avail)){
				vals.addLast(bucket[i].getValue());
			}
		}
		return vals;
	}

	@Override
	public Iterable<Entry<K,V>> entrySet() {
		NodePositionalList<Entry<K,V>> ent=new NodePositionalList<Entry<K,V>>();
		for(int i=0;i<this.capacity;i++){
			if((bucket[i]!=null)&&(bucket[i]!=avail)){
				ent.addLast(bucket[i]);
			}
		}
		return ent;
	}
	
	//Looks in the map for a particular entry. Returns -1 if not found.
	private int findEntry(K key) throws InvalidKeyException{
		int available=-1;
		this.checkKey(key);
		int i=hashValue(key);
		int j=i;
		
		do{
			Entry<K,V> e=bucket[i];
			if(e==null){
				if(available<0){
					available=i;
				}
				break;
			}
			if(key.equals(e.getKey())){
				return i;
			}
			if(e==this.avail){
				if(available<0){
					available=i;
				}
			}
			i=(i+1)%this.capacity;
		}while(i!=j);
		return -(available+1);
	}
	
	//Conputes the hash value for every key in the map.
	private int hashValue(K keys){
		return (int)((Math.abs(keys.hashCode()*this.scale+this.shift)%this.prime)%this.capacity);
	}
	
	//Rehashes the map once it runs out of space
	private void rehash(){
		this.capacity=2*capacity;
		Entry<K,V>[] temp=bucket;
		bucket=(Entry<K,V>[]) new Entry[capacity]; //makes a new storage with twice the space
		Random random=new Random();
		this.scale=random.nextInt(this.prime-1)+1;
		this.shift=random.nextInt(this.prime);
		for(int i=0;i<temp.length;i++){
			Entry<K,V> ent=temp[i];
			if((ent!=null)&&(ent!=this.avail)){
				int l=-1-findEntry(ent.getKey());
				bucket[l]=ent;
			}
		}
	}
	
	//Checks the the key for validity
	private void checkKey(K keys){
		if(keys==null){
			throw new InvalidKeyException("Error: null key");
		}
	}
}

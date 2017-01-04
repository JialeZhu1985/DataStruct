package hashmap;

import hashtable.MyHashSet;

public class MyHashMap<K, V> {
	public MyHashSet<KeyValue<K, V>> hashset;
	
	//构造方法
	public MyHashMap(int len) {
		hashset = new MyHashSet<>(len);
	}
	public MyHashMap() {
		this(10);
	}
	
	//添加映射，关键字相同时替换元素值
	public V put(K key, V value) {
		KeyValue<K, V> kv = new KeyValue<K, V>(key, value);
		if (!hashset.contains(kv)) {
			hashset.add(kv);
			
			return kv.value;			
		}
		else {
			hashset.remove(kv);
			hashset.add(kv);
			
			return kv.value;
		}	
	}
	
	//根据key获取value,key不存在时返回null
	public V get(K key) {
		return null;
	}
	
	class KeyValue<K, V> {
		public final K key;
		public V value;
		
		//构造方法
		public KeyValue(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		//计算hash值
		public int hash(K key) {
			return key.hashCode();
		}
		
		@Override
		public String toString() {
			return "(" + this.key.toString() + "," + this.value.toString() + ")";
		}
		
		@Override
		public boolean equals(Object obj) {
			KeyValue<K, V> kv = (KeyValue<K, V>)obj;
			return this.key.equals(kv.key);
		}
	}

}


package treemap;

public class SortedKeyValue<K extends Comparable<? super K>, V> implements Comparable<SortedKeyValue<K, V>> {
	public final K key;
	public V value = null;
	
	//构造方法
	public SortedKeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return this.key.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		SortedKeyValue<K, V> kv = (SortedKeyValue<K, V>)obj;
		return this.key.equals(kv.key);
	}
	
	@Override
	public int compareTo(SortedKeyValue<K, V> o) {
		return this.key.compareTo(o.key);
	}
	
	@Override
	public String toString() {
		return "(" + key.toString() + "," + value.toString() + ")";
	}

}

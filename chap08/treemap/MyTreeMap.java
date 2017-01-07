package treemap;

import binarysorttree.BinaryNode;
import binarysorttree.BinarySortTree;

public class MyTreeMap<K extends Comparable<? super K>, V> {
	BinarySortTree<SortedKeyValue<K, V>> set = null;
	
	//构造方法
	public MyTreeMap() {
		set = new BinarySortTree<SortedKeyValue<K, V>>();
	}
	
	//get与put
	public V get(K key) {
		SortedKeyValue<K, V> kv = new SortedKeyValue<K, V>(key, null);
		BinaryNode<SortedKeyValue<K, V>> res = set.search(kv);
		
		if (res == null)
			return null;
		else
			return res.data.value;
	}
	public V put(K key, V value) {
		SortedKeyValue<K, V> kv = new SortedKeyValue<K, V>(key, value);
		BinaryNode<SortedKeyValue<K, V>> res = set.search(kv);
		
		if (res == null) {	//不存在键值，直接添加
			set.add(kv);
			return value;
		} else {	//存在键值，替换
			res.data.value = value;
			return value;
		}
	}
	
	@Override
	public String toString() {
		return set.inOrder(set.root);
	}

}

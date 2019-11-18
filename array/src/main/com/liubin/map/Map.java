package main.com.liubin.map;
/**
* Title:Map.java
* @discription: 映射Map
* @author liubin@segi.com
* @created 2019-11-18 14:54
*/
public interface Map<K, V> {

	void add(K key, V value);

	V remove(K key);

	boolean contains(K key);

	V get(K key);

	void set(K key, V value);

	int getSize();

	boolean isEmpty();
}

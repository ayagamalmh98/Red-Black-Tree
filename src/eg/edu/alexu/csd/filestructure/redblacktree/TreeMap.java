package eg.edu.alexu.csd.filestructure.redblacktree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TreeMap<T extends Comparable<T>, V> implements ITreeMap<T, V> {
	
	private IRedBlackTree<T, V> RedBlackTree = new RedBlackTree<>();
    private int size = 0;

	@Override
	public Entry<T, V> ceilingEntry(T key) {
		if (key == null) 
			throw new NullPointerException();
		return null;
        
	}

	@Override
	public T ceilingKey(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		RedBlackTree.clear();
        size = 0;
	}

	@Override
	public boolean containsKey(T key) {
		 return RedBlackTree.contains(key);
	}

	@Override
	public boolean containsValue(V value) {
		if (value == null) 
			throw new NullPointerException();
        for (V v : values())
            if (v.equals(value))
                return true;
        return false;
	}

	@Override
	public Set<Entry<T, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<T, V> firstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T firstKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<T, V> floorEntry(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T floorKey(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entry<T, V>> headMap(T toKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entry<T, V>> headMap(T toKey, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<T> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<T, V> lastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T lastKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<T, V> pollFirstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<T, V> pollLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(T key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putAll(Map<T, V> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(T key) {
		if (key == null) 
			throw new NullPointerException();
        boolean deleted = RedBlackTree.delete(key);
        if (deleted) 
        	size--;
        return deleted;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}

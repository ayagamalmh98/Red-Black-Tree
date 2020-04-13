package eg.edu.alexu.csd.filestructure.redblacktree;

import java.util.*;
import java.util.Map.Entry;

import javax.management.RuntimeErrorException;

public class TreeMap <T extends Comparable<T>, V> implements ITreeMap<T, V>{
RedBlackTree<T,V> RBTree =new RedBlackTree<>();

    @Override
    public Entry<T, V> ceilingEntry(T key) {
        if (key == null)
            throw new RuntimeErrorException(null);
        Set<Map.Entry<T, V>> result=new LinkedHashSet<Map.Entry<T, V>>();
        inorderTraversal(RBTree.getRoot(),result);
        Iterator<Map.Entry<T, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<T, V> entry = it.next();
            if (entry.getKey().compareTo(key) > 0 || entry.getKey().compareTo(key) == 0) {
                return entry;
            }
        }
        return null;
        

    }


    private void inorderTraversal(INode<T,V> root, Set<Map.Entry<T, V>> result)
    {
        if (root.isNull())
            return;
        inorderTraversal(root.getLeftChild(), result);
        result.add(new AbstractMap.SimpleEntry<T,V>(root.getKey(), root.getValue()) );
        inorderTraversal(root.getRightChild(), result);
    }

    @Override
    public T ceilingKey(T key) {
        if (key == null) {
            throw new RuntimeErrorException(null);
        }
        Map.Entry<T, V> entry = ceilingEntry(key);
        return (T) entry.getKey();
    }

    @Override
    public void clear() {
        RBTree.clear();

    }

    @Override
    public boolean containsKey(T key) {
        if (key == null)
            throw new RuntimeErrorException(null);
       return RBTree.contains(key);
    }

    @Override
    public boolean containsValue(V value) {
        if (value == null)
            throw new RuntimeErrorException(null);
        Set<Map.Entry<T, V>> result=new LinkedHashSet<Map.Entry<T, V>>();
        inorderTraversal(RBTree.getRoot(),result);
        Iterator<Map.Entry<T, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<T, V> entry = it.next();
            if (entry.getValue().equals(value)    ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Entry<T, V>> entrySet() {
        Set<Map.Entry<T, V>> result= new LinkedHashSet<Map.Entry<T, V>>();
        inorderTraversal(RBTree.getRoot(),result);

        return result;
    }

    @Override
    public Entry<T, V> firstEntry() {
      if (RBTree.isEmpty())
        return null;
        Iterator<Map.Entry<T, V>> it = entrySet().iterator();
        return it.next();

    }

    @Override
    public T firstKey() {
        if (RBTree.isEmpty())
            return null;
        Map.Entry<T,V> entry=firstEntry();
        return entry.getKey();
    }

    @Override
    public Entry<T, V> floorEntry(T key) {
        if (key == null) {
            throw new RuntimeErrorException(null);
        }
        if (RBTree.isEmpty())
        return null;
        Set<Map.Entry<T, V>> result=new LinkedHashSet<Map.Entry<T, V>>();
        inorderTraversal(RBTree.getRoot(),result);
        Map.Entry<T, V> entry=null;
        Iterator<Map.Entry<T, V>> it = entrySet().iterator();
        Iterator<Map.Entry<T, V>> t=it;
        while (t.hasNext()) {
            entry = t.next();
            it=t;
            if (it.hasNext()) {
                if ((entry.getKey().compareTo(key) < 0 || entry.getKey().compareTo(key) == 0) && it.next().getKey().compareTo(key) > 0)
                    return entry;

            }
            if (!it.hasNext()) break;


        }
        return entry;
    }

    @Override
    public T floorKey(T key) {
        if (key == null)
            throw new RuntimeErrorException(null);
        if (RBTree.isEmpty())
            return null;
        Map.Entry<T, V> entry=floorEntry(key);
        return (T) entry.getKey();

    }

    @Override
    public V get(T key) {
        if (key == null)
            throw new RuntimeErrorException(null);
        if (RBTree.isEmpty())
            return null;
        INode<T,V> n=RBTree.find(key);
        return n.getValue();

    }

    @Override
    public ArrayList<Entry<T, V>> headMap(T toKey) {
        if (toKey == null)
            throw new RuntimeErrorException(null);
        ArrayList<Entry<T,V>> arr=new ArrayList<>();
        Set<Map.Entry<T, V>> result=new LinkedHashSet<Map.Entry<T, V>>();
        inorderTraversal(RBTree.getRoot(),result);
        Iterator<Map.Entry<T, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<T, V> entry = it.next();
            if (entry.getKey().compareTo(toKey) < 0 ) {
                arr.add(entry);
            }
        }
        return arr;
    }

    @Override
    public ArrayList<Entry<T, V>> headMap(T toKey, boolean inclusive) {
        if (toKey == null)
            throw new RuntimeErrorException(null);
        ArrayList<Entry<T,V>> arr=new ArrayList<>();
        Set<Map.Entry<T, V>> result=new LinkedHashSet<Map.Entry<T, V>>();
        inorderTraversal(RBTree.getRoot(),result);
        Iterator<Map.Entry<T, V>> it = entrySet().iterator();
        if (inclusive==true){
            while (it.hasNext()) {
                Map.Entry<T, V> entry = it.next();
                if (entry.getKey().compareTo(toKey) <= 0 ) {
                    arr.add(entry);
                }
            }

        }
        else
        { while (it.hasNext()) {
            Map.Entry<T, V> entry = it.next();
            if (entry.getKey().compareTo(toKey) < 0 ) {
                arr.add(entry);
            }
        }

        }
        return arr;
    }

    @Override
    public Set<T> keySet() {
        return null;
    }

    @Override
    public Entry<T, V> lastEntry() {
        return null;
    }

    @Override
    public T lastKey() {
        return null;
    }

    @Override
    public Entry<T, V> pollFirstEntry() {
        return null;
    }

    @Override
    public Entry<T, V> pollLastEntry() {
        return null;
    }

    @Override
    public void put(T key, V value) {
        if (key == null || value == null) {
            throw new RuntimeErrorException(null);
        }

       /* if (!RBTree.contains(key)) {
            size++;
        }

        */


        RBTree.insert(key, value);

    }

    @Override
    public void putAll(Map<T, V> map) {

    }

    @Override
    public boolean remove(T key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
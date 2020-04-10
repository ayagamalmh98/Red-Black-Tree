package eg.edu.alexu.csd.filestructure.redblacktree;

public class Node <T extends Comparable<T>, V> implements INode {
    public static final boolean RED = true;
    public static final boolean BLACK = false;
    private INode parent ;
    private INode rightChild ;
    private INode leftChild ;
    private T key ;
    private V value ;
    private boolean color ;




    @Override
    public void setParent(INode parent) {
        this.parent=parent;

    }

    @Override
    public INode getParent() {
        return parent;
    }

    @Override
    public void setLeftChild(INode leftChild) {
        this.leftChild=leftChild;

    }

    @Override
    public INode getLeftChild() {
        return leftChild;
    }

    @Override
    public void setRightChild(INode rightChild) {
        this.rightChild=rightChild;

    }

    @Override
    public INode getRightChild() {
        return rightChild;
    }

    @Override
    public Comparable getKey() {
        return key;
    }

    @Override
    public void setKey(Comparable key) {
        this.key= (T) key;

    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value= (V) value;

    }

    @Override
    public boolean getColor() {
        return color;
    }

    @Override
    public void setColor(boolean color) {
        this.color=color;

    }

    @Override
    public boolean isNull() {
        if (this.key == null)
            return true;
        return false;

    }
}

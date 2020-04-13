package eg.edu.alexu.csd.filestructure.redblacktree;

public class RedBlackTree<T extends Comparable<T>, V> implements IRedBlackTree<T, V> {

	private INode<T, V> nil = new Node<>();
	private INode<T, V> root = nil;

	@Override
	public INode<T, V> getRoot() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return root.isNull();
	}

	@Override
	public void clear() {
		root = nil;
	}

	@Override
	public V search(T key) {
		if (key == null) 
			throw new NullPointerException();
        INode<T,V> flag = root;
        while (flag != nil) {
            if (flag.getKey().compareTo(key) == 0)
                return flag.getValue();
            if (flag.getKey().compareTo(key) > 0)
                flag = flag.getLeftChild();
            else
                flag = flag.getRightChild();
        }
        return null;
	}

	@Override
	public boolean contains(T key) {
		if (key == null)
			throw new NullPointerException();
		if (search(key) != null)
			return true;
		return false;
	}

	@Override
	public void insert(T key, V value) {
		if (key == null || value == null) {
			throw new NullPointerException();
		}
		INode<T, V> Z = new Node<>();
		Z.setKey(key);
		Z.setValue(value);
		INode<T, V> Y = nil;
		INode<T, V> X = root;
		while (!X.isNull()) {
			Y = X;
			if (Z.getKey().compareTo(X.getKey()) == 0) {
				X.setValue(value);
				return;
			}
			if (Z.getKey().compareTo(X.getKey()) < 0) {
				X = X.getLeftChild();
			} else {
				X = X.getRightChild();
			}

		}
		Z.setParent(Y);
		if (Y == nil) {
			root = Z;
		} else if (Z.getKey().compareTo(Y.getKey()) < 0) {
			Y.setLeftChild(Z);
		} else {
			Y.setRightChild(Z);
		}
		Z.setLeftChild(nil);
		Z.setRightChild(nil);
		Z.setColor(true);
		InsertFixup(Z);

	}

	private void InsertFixup(INode<T, V> Z) {
		if(Z.getParent() == null) {
			Z.setColor(false);
		}
		while (Z.getParent().getColor()) {
			if (!Z.getParent().isNull() && !Z.getParent().getParent().isNull()) {
				if (Z.getParent() == Z.getParent().getParent().getLeftChild()) {
					INode<T, V> Y = Z.getParent().getParent().getRightChild();
					if (Y.getColor()) {
						Z.getParent().setColor(false);
						Y.setColor(false);
						Z.getParent().getParent().setColor(true);
						Z = Z.getParent().getParent();
					} else if (Z == Z.getParent().getRightChild()) {
						Z = Z.getParent();
						LeftRotate(Z);
					} else {
                        Z.getParent().setColor(false);
                        if (!Z.getParent().isNull() && !Z.getParent().getParent().isNull()) {
                            Z.getParent().getParent().setColor(true);
                            RightRotate(Z.getParent().getParent());
                        }
                    }
				} else {
					INode<T, V> Y = Z.getParent().getParent().getLeftChild();
					if (Y.getColor()) {
						Z.getParent().setColor(false);
						Y.setColor(false);
						Z.getParent().getParent().setColor(true);
						Z = Z.getParent().getParent();
					} else if (Z == Z.getParent().getLeftChild()) {
						Z = Z.getParent();
						RightRotate(Z);
					} else {
                        Z.getParent().setColor(false);
                        if (!Z.getParent().isNull() && !Z.getParent().getParent().isNull()) {
                            Z.getParent().getParent().setColor(true);
                            LeftRotate(Z.getParent().getParent());
                        }
                    }
				}

			} else
				break;
		}
		root.setColor(false);

	}

	private void LeftRotate(INode<T, V> P) {
		INode<T, V> X = P.getRightChild();
		P.setRightChild(X.getLeftChild());
		if (!X.getLeftChild().isNull()) {
			X.getLeftChild().setParent(P);
		}
		X.setParent(P.getParent());
		if (P.getParent().isNull())
			root = X;
		else if (P == P.getParent().getLeftChild())
			P.getParent().setLeftChild(X);
		else
			P.getParent().setRightChild(X);

		X.setLeftChild(P);
		P.setParent(X);
	}

	private void RightRotate(INode<T, V> G) {
		INode<T, V> Y = G.getLeftChild();
		G.setLeftChild(Y.getRightChild());
		if (!Y.getRightChild().isNull())
			Y.getRightChild().setParent(G);
		Y.setParent(G.getParent());
		if (G.getParent().isNull())
			root = Y;
		else if (G == G.getParent().getRightChild())
			G.getParent().setRightChild(Y);
		else
			G.getParent().setLeftChild(Y);
		Y.setRightChild(G);
		G.setParent(Y);
	}

	@Override
	public boolean delete(T key) {
		// TODO Auto-generated method stub
		return false;
	}

}

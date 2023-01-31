package tree;

import java.util.ArrayList;
import java.util.List;

public class GenericTree<T> extends Tree<T> {
	List<Tree<T>> children = new ArrayList<>();
	public GenericTree(T data) {
		setData(data);
	}

	public void addChild(GenericTree<T> child) {
		this.children.add(child);
	}
	
	public void removeChild(GenericTree<T> child) {
		this.children.remove(child);
	}
	
	@Override
	public List<Tree<T>> getChildren() {
		return children;
	}
}

package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, T> extends Tree<T> {
	private BinarySearchTree<K, T> leftChild;
	private BinarySearchTree<K, T> rightChild;
	private K key;


	private BinarySearchTree(K key, T data) {
		setKey(key);
		setData(data);
	}
	
	public BinarySearchTree() {
		this(null, null);
	}
	
	public K getKey() {
		return this.key;
	}
	
	protected void setKey(K key) {
		this.key = key;
	}
	
	public void add(K key, T data) {
		privateAdd(key, data);
	}

	private void privateAdd(K key, T data) {
		if (this.key == null){
			this.setData(data);
			this.setKey(key);
		}else {
			if(this.getKey().compareTo(key) > 0){
				if(this.hasLeftChild()){
					this.leftChild.add(key, data);
				}else {
					this.leftChild = new BinarySearchTree<>(key, data);
				}
			}else{
				if(this.hasRightChild()){
					this.rightChild.add(key, data);
				}else{
					this.rightChild = new BinarySearchTree<>(key, data);
				}
			}
		}
	}
	private boolean hasLeftChild(){
		return this.leftChild != null;
	}
	private boolean hasRightChild(){
		return this.rightChild != null;
	}

	public void remove(K key) {
		privateRemove(key);
	}

	private void privateRemove(K key){
		if(this.getKey().compareTo(key) == 0){
			this.setKey(null);
			this.setData(null);
			this.leftChild = null;
			this.rightChild = null;

			// Commented sections introduce a way to recursively null every children of the removed Tree Node, thus cleaning memory
			
			// this.leftChild.removeChildren();
			// this.rightChild.removeChildren();

		}else if(this.getKey().compareTo(key) > 0){
			this.leftChild.remove(key);
		}else if(this.getKey().compareTo(key) < 0){
			this.rightChild.remove(key);
		}else{
			return;
		}
	}
	// private void removeChildren(){
	// 	this.setKey(null);
	// 	this.setData(null);
	// 	if(this.hasLeftChild()){
	// 		this.leftChild.removeChildren();
	// 	}
	// 	if(this.hasRightChild()){
	// 		this.rightChild.removeChildren();
	// 	}
	// }
	
	public BinarySearchTree<K, T> getLeftSubtree() {
		return privateGetLeftSubtree();
	}

	public BinarySearchTree<K, T> privateGetLeftSubtree() {
		return this.leftChild;
	}
	
	public BinarySearchTree<K, T> getRightSubtree() {
		return privateGetRightSubtree();
	}
	
	public BinarySearchTree<K, T> privateGetRightSubtree() {
		return this.rightChild;
	}

	@Override
	public List<Tree<T>> getChildren() {
		List<Tree<T>> childrenList = new ArrayList<>();
		childrenList.add(leftChild);
		childrenList.add(rightChild);
		return childrenList;
	}

	public BinarySearchTree<K, T> find(K key) {
		if(this.key == null){
			return null;
		}else if(this.getChildren().size() == 0){
			return null;
		}else {
			K baseKey = this.key;
			if(baseKey.compareTo(key) == 0){
				return this;
			}else if(baseKey.compareTo(key) > 0){
				return this.getLeftSubtree().find(key);
			}else{
				return this.getRightSubtree().find(key);
			}
		}
	}
}

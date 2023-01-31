package tree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.function.Consumer;

import java.util.Stack;

import exception.HaveToBeImplementedException;

public abstract class Tree<T> {	
	public abstract List<Tree<T>> getChildren();
	private Tree<T> parent = null;
	private T data = null;

	public T getData() {
		return this.data;
	}
	
	protected void setData(T data) {
		this.data = data;
	}
	
	public Tree<T> getParent() {
		return this.parent;
	}
	
	protected void setParent(Tree<T> tree) {
		this.parent = tree;
	}
		
	public boolean isLeaf() {
		return this.getChildren().size() == 0;
	}
	
	public int getNumberOfNodes() {
		return getChildren().size();
	}

	public int getHeight() {
		if(this.isLeaf()){
			System.out.println(this.getChildren());
			return 1;
		}else {
			int maxHeight = 0;
			Iterator<Tree<T>> childrenIterator = getChildren().iterator();
			while(childrenIterator.hasNext()){
				Tree<T> children = childrenIterator.next();
				if(children != null){
					int childHeight = children.getHeight();
					if(childHeight > maxHeight) {
						maxHeight= childHeight;
					}
				}
			}
			return 1+ maxHeight;
		}
	}
	
	public void traverseLevelOrder(Consumer<T> visitingMethod) {
		Queue<Tree<T>> QueueOrdered = new LinkedList<>();
        QueueOrdered.add(this);
        while (!QueueOrdered.isEmpty()) {
            Tree<T> nextNode = QueueOrdered.remove();
            visitingMethod.accept(nextNode.getData());
            
            List<Tree<T>> childrenList = nextNode.getChildren();
            
            if(childrenList != null) {
                for (Tree<T> Tree : childrenList) {
                    QueueOrdered.add(Tree);
                }
            }
        }
	}
	
	public void traversePreOrderRecursively(Consumer<T> visitingMethod) {
		Iterator<Tree<T>> childrenIterator = this.getChildren().iterator();

		//Iterating starts at first index i guess, never used the class Iterator<T>
		while(childrenIterator.hasNext()){
			// Before going to the next node, accept visitingMethod if not already executed
			if(this.getData() != null){
				visitingMethod.accept(this.data);
			}
			
			// If the node has children, iterate throught them and call tree.traversePreOrderRecursively() for each of them until we hit a leaf node
			childrenIterator.next().traversePreOrderRecursively(visitingMethod);
			this.setData(null);
		}
		if(this.isLeaf()){
			// If the node is a leaf accept visiting method and null the data
			visitingMethod.accept(this.data);
			return;
		}
	}
	
	public void traversePostOrderIteratively(Consumer<T> visitingMethod) {
		// Since this is iterative, using stack is efficient
		Stack<Tree<T>> nodeStack = new Stack<>();
		
		// Starts from the root
		nodeStack.add(this);
		
		// Each time this is called, we traverse 1 level from the previous node
		while(!nodeStack.isEmpty()){
			Tree<T> currentNode = nodeStack.pop();

			// An Iterator that starts iterating from last element of children list to first element of children list
			
			// If current node doesn't have a child(ren) then carry out the visiting method, and null it to remove it from parent childrenList
			if(currentNode.isLeaf()){
				visitingMethod.accept(currentNode.data);
			} 
			// If current node has a child(ren) then add them to the stack in reverse order
			else {
				ListIterator<Tree<T>> childrenIterator = currentNode.getChildren().listIterator(currentNode.getChildren().size() );
				nodeStack.add(currentNode);
				while(childrenIterator.hasPrevious()){
					Tree<T> children = childrenIterator.previous();
					nodeStack.add(children);
					
					childrenIterator.remove();
				}
			}
		}
	}

	
}

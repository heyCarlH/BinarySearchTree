package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make them take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public boolean containsNode(String s) {
		if (s.compareTo(data) == 0) {
			return true;
		} else if (s.compareTo(data) < 0) {
			if (this.getLeft() == null) {
				return false;
			}
			return this.getLeft().containsNode(s);
		} else {
			if (this.getRight() == null) {
				return false;
			}
			return this.getRight().containsNode(s);
		}
	}

	public boolean insertNode(String s) {
		if (this.containsNode(s)) {
			return false;
		} else {
			if (s.compareTo(this.data) < 0) {
				if (this.left == null) {
					this.left = new BST_Node(s);
					return true;
				}
				return this.left.insertNode(s);
			} else if (s.compareTo(this.data) > 0) {
				if (this.right == null) {
					this.right = new BST_Node(s);
					return true;
				}
				return this.right.insertNode(s);
			} else {
				return false;
			}
		}
	}

	public boolean removeNode(String string, BST_Node previousNode) {
		BST_Node currentNode = this;
		while (currentNode != null) {
			if (string.compareTo(currentNode.getData()) < 0) {
				previousNode = currentNode;
				currentNode = currentNode.getLeft();
			} else if (string.compareTo(currentNode.getData()) > 0) {
				previousNode = currentNode;
				currentNode = currentNode.getRight();
			} else {
				if (currentNode.getLeft() == null // If the current node has no
													// child
						&& currentNode.getRight() == null) {
					if (currentNode == previousNode.getLeft()) { // If it's the
																	// left
																	// child of
																	// previous
																	// node
						previousNode.left = null;
					}
					if (currentNode == previousNode.getRight()) { // If it's the
																	// right
																	// child of
																	// previous
																	// node
						previousNode.right = null;
					}
				} else if (currentNode.getLeft() == null) { // If it has left
															// child
					if (currentNode == previousNode.getLeft()) {
						previousNode.left = currentNode.getRight();
					} else if (currentNode == previousNode.getRight()) {
						previousNode.right = currentNode.getRight();
					}
				} else if (currentNode.getRight() == null) { // If it has right
																// child
					if (currentNode == previousNode.getLeft()) {
						previousNode.left = currentNode.getLeft();
					} else if (currentNode == previousNode.getRight()) {
						previousNode.right = currentNode.getLeft();
					}
				} else {
					// If it has left and right children
					currentNode.data = currentNode.getRight().findMin()
							.getData();
					currentNode.getRight().removeNode(
							// Recursively remove the right minimum child
							currentNode.getRight().findMin().getData(),
							currentNode);

				}
				return true;
			}
		}
		return false;
	}

	public BST_Node findMin() {
		if (this.getLeft() == null) {
			return this;
		} else {
			return this.getLeft().findMin();
		}
	}

	public BST_Node findMax() {
		if (this.getRight() == null) {
			return this;
		} else {
			return this.getRight().findMax();
		}
	}

	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;
		if (this.getLeft() != null) {
			leftHeight = 1 + this.getLeft().getHeight();
		}
		if (this.getRight() != null) {
			rightHeight = 1 + this.getRight().getHeight();
		}
		return Math.max(leftHeight, rightHeight);
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: "
				+ ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}
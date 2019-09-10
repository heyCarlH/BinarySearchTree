package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		if (s == null) {
			return false;
		}
		if (this.empty()) {
			this.size++;
			this.root = new BST_Node(s);
			return true;
		}
		if (this.root.insertNode(s)) {
			this.size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(String s) {
		if (this.empty() || s == null) {
			return false;
		} else if (this.root.getData().equals(s)) {
			if (this.root.getLeft() == null) {
				this.root = this.root.getRight();
			} else if (this.root.getRight() == null) {
				this.root = this.root.getLeft();
			} else if (this.root.getLeft() == null
					& this.root.getRight() == null) {
				this.root = null;
			} else {
				String minimum = this.root.getRight().findMin().getData();
				this.root.data = minimum;
				this.root.getRight().removeNode(minimum, this.root);
			}
			this.size--;
			return true;
		} else {
			this.root.removeNode(s, null);
			this.size--;
			return true;
		}
	}

	@Override
	public String findMin() {
		if (this.empty()) {
			return null;
		} else {
			return this.root.findMin().getData();
		}
	}

	@Override
	public String findMax() {
		if (this.empty()) {
			return null;
		} else {
			return this.root.findMax().getData();
		}
	}

	@Override
	public boolean empty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		if (this.empty() || s == null) {
			return false;
		} else if (this.root.getData().equals(s)) {
			return true;
		} else {
			return this.root.containsNode(s);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int height() {
		if (this.empty()) {
			return -1;
		} else if (this.root.getLeft() == null && this.root.getRight() == null) {
			return 0;
		} else {
			return this.root.getHeight();
		}
	}

}
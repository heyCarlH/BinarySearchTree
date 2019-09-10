package BST_A2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AnotherBSTTest {

	@Test
	public void testFindMin() {
		BST tree = new BST();
		tree.insert("gg");
		tree.insert("dd");
		tree.insert("ss");
		tree.insert("ee");
		tree.insert("cc");
		tree.insert("zz");
		tree.insert("gg");
		tree.insert("bb");
		tree.insert("ff");
		tree.insert("aa");

		try {
			assertEquals("findMin returns wrong node", "aa", tree.findMin());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testFindMax() {
		BST tree = new BST();
		tree.insert("gg");
		tree.insert("dd");
		tree.insert("ss");
		tree.insert("ee");
		tree.insert("cc");
		tree.insert("zz");
		tree.insert("gg");
		tree.insert("bb");
		tree.insert("ff");
		tree.insert("aa");

		try {
			assertEquals("findMax returns wrong node", "zz", tree.findMax());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testContainsTrue() {
		BST tree = new BST();
		tree.insert("gg");
		tree.insert("dd");
		tree.insert("ss");
		tree.insert("ee");
		tree.insert("cc");
		tree.insert("zz");
		tree.insert("gg");
		tree.insert("bb");
		tree.insert("ff");
		tree.insert("aa");

		try {
			assertTrue("contains returns false", tree.contains("cc"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testContainsFalse() {
		BST tree = new BST();
		tree.insert("gg");
		tree.insert("dd");
		tree.insert("ss");
		tree.insert("ee");
		tree.insert("cc");
		tree.insert("zz");
		tree.insert("gg");
		tree.insert("bb");
		tree.insert("ff");
		tree.insert("aa");

		try {
			assertFalse("contains returns true", tree.contains("ad"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testEmptyTrue() {
		BST tree = new BST();

		try {
			assertTrue("empty returns false", tree.empty());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testEmptyFalse() {
		BST tree = new BST();

		tree.insert("h");

		try {
			assertFalse("empty returns true", tree.empty());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightInsertOnly() {
		BST tree = new BST();
		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");

		try {
			assertEquals("height returned wrong height", 5, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveLeaf() {
		BST tree = new BST();
		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");
		tree.remove("f");
		try {
			assertEquals("height returned wrong height", 4, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveOneChild() {
		BST tree = new BST();
		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");
		tree.remove("g");
		try {
			assertEquals("height returned wrong height", 4, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveTwoChildren() {
		BST tree = new BST();
		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");
		tree.remove("d");
		try {
			assertEquals("height returned wrong height", 4, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSizeInsertOnly() {
		BST tree = new BST();
		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");
		try {
			assertEquals("size returned wrong size", 8, tree.size());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSizeRemove() {
		BST tree = new BST();
		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");
		tree.remove("s");
		try {
			assertEquals("size returned wrong size", 7, tree.size());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		BST tree = new BST();

		try {
			assertTrue("insert returned false", tree.insert("a"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertTrue("insert returned false", tree.insert("d"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertTrue("insert returned false", tree.insert("c"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");

		try {
			assertEquals("inserted wrong node into spot", "s",
					tree.root.right.right.getData());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertEquals("inserted wrong node into spot", "g",
					tree.root.right.right.left.right.getData());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertFalse("insert returned true", tree.insert("a"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveNoChildren() {
		BST tree = new BST();

		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");

		try {
			assertTrue("remove no children case returned false",
					tree.remove("f"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertEquals("remove no children case didn't remove", null,
					tree.root.right.right.left.right.left);
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertTrue("remove 1 child case returned false", tree.remove("e"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertEquals("remove 1 child case didn't remove properly", "g",
					tree.root.right.right.left.getData());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveOneChild() {
		BST tree = new BST();

		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");

		try {
			assertTrue("remove 1 child case returned false", tree.remove("e"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertEquals("remove 1 child case didn't remove properly", "g",
					tree.root.right.right.left.getData());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveTwoChildren() {
		BST tree = new BST();

		tree.insert("a");
		tree.insert("d");
		tree.insert("s");
		tree.insert("e");
		tree.insert("c");
		tree.insert("g");
		tree.insert("b");
		tree.insert("f");

		try {
			assertTrue("remove 2 children case returned false",
					tree.remove("d"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}

		try {
			assertFalse("remove 2 children didn't remove properly",
					tree.contains("d"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}
}
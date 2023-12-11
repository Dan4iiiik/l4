package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    public static Map<Integer, String> hashMap = new LinkedHashMap<>();
    public static BSTNode nodeRoot;

    @BeforeAll
    static void testCase1() {
        hashMap.put(27, "Unique 27");
        hashMap.put(30, "Unique 30");
        hashMap.put(26, "Unique 26");
        hashMap.put(28, "Unique 28");
        hashMap.put(32, "Unique 32");
        hashMap.put(33, "Unique 33");
        hashMap.put(18, "Unique 18");
        hashMap.put(29, "Unique 29");
        hashMap.put(36, "Unique 36");
        hashMap.put(34, "Unique 34");
        hashMap.put(25, "Unique 25");
        hashMap.put(23, "Unique 23");
        hashMap.put(31, "Unique 31");
        hashMap.put(24, "Unique 24");
        hashMap.put(22, "Unique 22");
        hashMap.put(35, "Unique 35");
        hashMap.put(17, "Unique 17");
        hashMap.put(19, "Unique 19");
        hashMap.put(16, "Unique 16");
        hashMap.put(20, "Unique 20");
        hashMap.put(21, "Unique 21");
    }

    @Test
    void testCase2() {
        nodeRoot = new BSTNode(27, hashMap.get(27));
        for (int key : hashMap.keySet()) {
            String value = hashMap.get(key);
            nodeRoot.insert(nodeRoot, key, value);
        }

        int nodeCount = nodeRoot.countNodes(nodeRoot);
        assertEquals(hashMap.size(), nodeCount);
    }

    @Test
    void testCase3() {
        testCase2();

        BSTNode node;
        node = nodeRoot.search(nodeRoot, 25);
        assertEquals("Unique 25", node.getValue());

        node = nodeRoot.search(nodeRoot, 30);
        assertEquals("Unique 30", node.getValue());

        node = nodeRoot.search(nodeRoot, 35);
        assertEquals("Unique 35", node.getValue());

        node = nodeRoot.search(nodeRoot, 21);
        assertEquals("Unique 21", node.getValue());

        node = nodeRoot.search(nodeRoot, 8);
        assertNull(node);
    }

    @Test
    void testCase4() {
        BSTNode node;

        nodeRoot = new BSTNode(27, hashMap.get(27));
        for (int key : hashMap.keySet()) {
            if (key == 30) {
                continue;
            }
            String value = hashMap.get(key);
            nodeRoot.insert(nodeRoot, key, value);
        }
        assertEquals(hashMap.size() - 1, nodeRoot.countNodes(nodeRoot));

        nodeRoot.insert(nodeRoot, 30, "Unique 30");
        node = nodeRoot.search(nodeRoot, 30);
        assertEquals("Unique 30", node.getValue());

        nodeRoot.insert(nodeRoot, 35, "Unique 35 double");
        int nodeCount = nodeRoot.countNodes(nodeRoot);
        assertEquals(hashMap.size(), nodeCount);

        node = nodeRoot.search(nodeRoot, 35);
        assertEquals("Unique 35 double", node.getValue());
    }

    @Test
    void testCase5() {
        testCase2();

        BSTNode node;

        nodeRoot = nodeRoot.delete(nodeRoot, 16);
        assertEquals(hashMap.size() -1, nodeRoot.countNodes(nodeRoot));
        node = nodeRoot.search(nodeRoot, 16);
        assertNull(node);
    }
}
import java.util.PriorityQueue;

public class HuffmanTree {
    private HuffmanNode root;

    public HuffmanTree(byte[] data) {
        int[] frequencies = new int[256];
        for (byte b : data) {
            frequencies[b & 0xFF]++;
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                queue.add(new HuffmanNode((byte) i, frequencies[i]));
            }
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode((byte) 0, left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            queue.add(parent);
        }

        root = queue.poll();
    }

    public HuffmanNode getRoot() {
        return root;
    }
}

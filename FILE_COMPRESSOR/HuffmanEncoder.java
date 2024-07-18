import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    private HuffmanTree tree;
    private Map<Byte, String> huffmanCodes;

    public HuffmanEncoder(byte[] data) {
        this.tree = new HuffmanTree(data);
        this.huffmanCodes = new HashMap<>();
    }

    public void buildTree(byte[] data) {
        tree = new HuffmanTree(data);
    }

    public void generateCodes() {
        generateCodes(tree.getRoot(), "");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.data, code);
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public void compress(byte[] data, BitOutputStream bos) throws IOException {
        for (byte b : data) {
            String code = huffmanCodes.get(b);
            for (char c : code.toCharArray()) {
                bos.writeBit(c == '1');
            }
        }
        bos.flush();
    }
}

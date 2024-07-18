public class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    byte data;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(byte data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    public int compareTo(HuffmanNode o) {
        return this.frequency - o.frequency;
    }
}

import java.io.IOException;
import java.io.OutputStream;

public class BitOutputStream {
    private OutputStream out;
    private int currentByte;
    private int numBitsFilled;

    public BitOutputStream(OutputStream out) {
        this.out = out;
        this.currentByte = 0;
        this.numBitsFilled = 0;
    }

    public void writeBit(boolean bit) throws IOException {
        if (numBitsFilled == 8) {
            flush();
        }

        if (bit) {
            currentByte |= (1 << (7 - numBitsFilled));
        }
        numBitsFilled++;
    }

    public void flush() throws IOException {
        if (numBitsFilled > 0) {
            out.write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
    }

    public void close() throws IOException {
        flush();
        out.close();
    }
}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileZipper {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileZipper <input file> <output file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            FileInputStream fis = new FileInputStream(inputFile);
            byte[] inputBytes = fis.readAllBytes();
            fis.close();

            HuffmanEncoder encoder = new HuffmanEncoder(inputBytes);
            encoder.buildTree(inputBytes);
            encoder.generateCodes();

            FileOutputStream fos = new FileOutputStream(outputFile);
            BitOutputStream bos = new BitOutputStream(fos);
            encoder.compress(inputBytes, bos);
            bos.close();
            fos.close();

            System.out.println("File compressed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

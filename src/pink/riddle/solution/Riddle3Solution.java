package pink.riddle.solution;

import pink.workshop.solution.CBC;
import pink.workshop.FileUtils;

import java.nio.ByteBuffer;
import java.util.HexFormat;

public class Riddle3Solution {

  public static void main(String[] args) throws Exception {
    byte[] file = FileUtils.readFileAsBytes("Riddle3/encr.ypt");

    // The encryption key and IV is the same according to the task
    // Both are taken from the first 16 bytes of the file - and a PNG has always the following 16 bytes:
    byte[] keyAndIV = HexFormat.of().parseHex("89504E470D0A1A0A0000000D49484452");

    // Using ByteBuffer as the hint suggests. ByteBuffer makes it easy to split then join the two
    // arrays.
    ByteBuffer fileBytes = ByteBuffer.wrap(file);

    // Create an array for the bytes that need to be decrypted. The task says only 16 bytes were
    // encrypted.
    byte[] encryptedData = new byte[16];
    fileBytes.get(encryptedData, 0, encryptedData.length);
    // Decrypt using the key/IV
    byte[] decryptedData = CBC.decrypt(keyAndIV, keyAndIV, encryptedData);

    // Create a byte array with those bytes that were NOT encrypted
    byte[] original = new byte[file.length - 16];
    fileBytes.get(original, 0, original.length);

    // Concatenate the two arrays, then write to file as .png
    FileUtils.writeFile(
        ByteBuffer.allocate(decryptedData.length + original.length)
            .put(decryptedData)
            .put(original)
            .array(),
        "Riddle3/solvedit.png");
  }
}

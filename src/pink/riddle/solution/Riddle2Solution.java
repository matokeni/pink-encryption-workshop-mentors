package pink.riddle.solution;

import pink.workshop.solution.XOR;
import pink.workshop.FileUtils;

import java.nio.charset.StandardCharsets;

public class Riddle2Solution {

  public static void main(String[] args) {
    byte[] file = FileUtils.readFileAsBytes("Riddle2/Riddle2.png");

    // Read in the two other files
    byte[] plaintextData = FileUtils.readFileAsBytes("Riddle2/example.jpg");
    byte[] encryptedData = FileUtils.readFileAsBytes("Riddle2/example-encrypted.jpg");

    // Print out their XOR - the key should be visible as a repeating string: VeryPinkPassword
    System.out.println(new String(XOR.xor(plaintextData, encryptedData), StandardCharsets.UTF_8));

    // Now decrypt the other file with the key
    FileUtils.writeFile(XOR.xor(file, "VeryPinkPassword".getBytes()), "Riddle2/solvedit.png");
  }
}

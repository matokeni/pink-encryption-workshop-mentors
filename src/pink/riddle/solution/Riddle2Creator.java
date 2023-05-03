package pink.riddle.solution;

import pink.workshop.solution.XOR;
import pink.workshop.FileUtils;

public class Riddle2Creator {

  public static void main(String[] args) {
    byte[] file = FileUtils.readFileAsBytes("Riddle2/solution/Riddle2-solution.png");

    byte[] result = XOR.xor(file, "VeryPinkPassword".getBytes());

    FileUtils.writeFile(result, "Riddle2/Riddle2.png");
  }
}

package pink.riddle.solution;

import pink.workshop.solution.CBC;
import pink.workshop.FileUtils;

import java.nio.ByteBuffer;

import java.util.HexFormat;

public class Riddle3Creator {

  public static void main(String[] args) throws Exception {
    byte[] file = FileUtils.readFileAsBytes("Riddle3/solution/Riddle3.png");
    byte[] keys = HexFormat.of().parseHex("89504E470D0A1A0A0000000D49484452");

    ByteBuffer bb = ByteBuffer.wrap(file);
    byte[] data = new byte[16];
    bb.get(data, 0, data.length);

    byte[] encrypted = CBC.encrypt(keys, keys, data);

    byte[] original = new byte[file.length - 16];
    bb.get(original, 0, original.length);

    FileUtils.writeFile(
            ByteBuffer.allocate(encrypted.length + original.length)
                    .put(encrypted)
                    .put(original)
                    .array(),
            "Riddle3/encr.ypt");
  }
}

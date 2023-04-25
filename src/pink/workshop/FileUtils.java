package pink.workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
  /**
   * Reads the file content as a byte array
   *
   * @param filepath - for example: Riddle1/encr.ypt
   * @return byte array of the file content
   */
  public static byte[] readFileAsBytes(String filepath) {
    try {
      return Files.readAllBytes(Paths.get("resources/%s".formatted(filepath)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Writes the byte array to a file under the resources folder
   *
   * @param fileContent - byte array of the file content
   * @param filepath - for example: Riddle1/encr.ypt
   */
  public static void writeFile(byte[] fileContent, String filepath) {
    try {
      Files.write(Paths.get("resources/%s".formatted(filepath)), fileContent);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

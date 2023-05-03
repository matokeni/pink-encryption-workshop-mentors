package pink.riddle.solution;

import pink.workshop.solution.RSA;
import pink.workshop.FileUtils;

import java.security.*;

public class Riddle1Creator {

  public static void main(String[] args) throws Exception {
    // DON'T RUN THIS LINE AGAIN!! It will create new keys.
    // savingMyKeys();

    PublicKey publicKey = RSA.readPublicKey("Riddle1/public.key");
    byte[] file = FileUtils.readFileAsBytes("Riddle1/solution/secret-plaintext.txt");

    byte[] encryptedKey = RSA.encrypt(publicKey, file);
    FileUtils.writeFile(encryptedKey, "Riddle1/secret.txt");
  }

  private static void savingMyKeys() throws NoSuchAlgorithmException {
    KeyPair pair = RSA.generateKeys();
    PrivateKey privateKey = pair.getPrivate();
    PublicKey publicKey = pair.getPublic();

    FileUtils.writeFile(publicKey.getEncoded(), "Riddle1/public.key");
    FileUtils.writeFile(privateKey.getEncoded(), "Riddle1/private.key");
  }
}

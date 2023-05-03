package pink.riddle.solution;

import pink.workshop.solution.RSA;
import pink.workshop.FileUtils;

import java.security.PrivateKey;

public class Riddle1Solution {

  public static void main(String[] args) throws Exception {
    byte[] file = FileUtils.readFileAsBytes("Riddle1/secret.txt");

    // Realizing that the secret is encrypted with our own public key, we know that we can decrypt it
    // with our own private key too.
    // Read the private key file
    PrivateKey privateKey = RSA.readPrivateKey("Riddle1/private.key");

    // Decrypt with RSA
    byte[] decryptedKey = RSA.decrypt(privateKey, file);
    FileUtils.writeFile(decryptedKey, "Riddle1/solvedit.txt");
  }

  /*

  private void savingMyKeys() throws NoSuchAlgorithmException {
      KeyPair pair = CryptoUtils.generateRSAKeys();
      PrivateKey privateKey = pair.getPrivate();
      PublicKey publicKey = pair.getPublic();

      CryptoUtils.writeFile(publicKey.getEncoded(), "Riddle1/public.key");
      CryptoUtils.writeFile(privateKey.getEncoded(), "Riddle1/private.key");
  }

  */
}

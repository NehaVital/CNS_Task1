import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Caesercipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String ptext, int cserkey) {
        String ctext = "";
        for (int i = 0; i < ptext.length(); i++) {
            int plainnumeric = ALPHABET.indexOf(ptext.charAt(i));
            int ciphernumeric = (plainnumeric + cserkey) % 26;
            char cipherchar = ALPHABET.charAt(ciphernumeric);
            ctext += cipherchar;
        }
        return ctext;
    }

    public static String decrypt(String ctext, int cserkey) {
        String ptext = "";
        for (int i = 0; i < ctext.length(); i++) {
            int ciphernumeric = ALPHABET.indexOf(ctext.charAt(i));
            int plainnumeric = (ciphernumeric - cserkey) % 26;

            // Ensure plainnumeric is non-negative
            if (plainnumeric < 0) {
                plainnumeric = ALPHABET.length() + plainnumeric;
            }

            char plainchar = ALPHABET.charAt(plainnumeric);
            ptext += plainchar;
        }
        return ptext;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the PLAIN TEXT for Encryption: ");
        String plaintext = br.readLine();
        System.out.println("Enter the CAESERKEY between 0 and 25:");
        String key = br.readLine();
        int cserkey = Integer.parseInt(key);

        System.out.println("ENCRYPTION");
        String ciphertext = encrypt(plaintext, cserkey);
        System.out.println("CIPHER TEXT: " + ciphertext);

        System.out.println("DECRYPTION");
        String decryptedText = decrypt(ciphertext, cserkey);
        System.out.println("PLAIN TEXT: " + decryptedText);
    }
}

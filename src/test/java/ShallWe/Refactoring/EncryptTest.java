package ShallWe.Refactoring;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EncryptTest {

//    @Test
//    public void checkEncrypt(){
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        encryptor.setProvider(new BouncyCastleProvider());
//        encryptor.setPoolSize(2);
//        encryptor.setPassword("xoxo");
//        encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC");
//
//        String plainText = "암호화 할 문자";
//        String encryptedText = encryptor.encrypt(plainText);
//        String decryptedText = encryptor.decrypt(encryptedText);
//        System.out.println("Enc:"+encryptedText+", Dec:"+decryptedText);
//    }

}

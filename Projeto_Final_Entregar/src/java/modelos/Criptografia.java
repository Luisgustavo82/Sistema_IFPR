package modelos;

import com.sun.istack.internal.logging.Logger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;


public class Criptografia {
    
    public static String criptografarMD5 (String senha) {
        MessageDigest md5;
        BigInteger senhaCriptografada = null;
        
        Logger logger = Logger.getLogger (Criptografia.class);
        
        try {
            md5 = MessageDigest.getInstance ("MD5");
            md5.reset();
            md5.update (senha.getBytes(), 0, senha.length());
            senhaCriptografada = new BigInteger (1, md5.digest());
        } catch (NoSuchAlgorithmException ex) {
            logger.log(Level.SEVERE, ex.toString(),ex);
        }
        
        return senhaCriptografada.toString();
    }
    
}
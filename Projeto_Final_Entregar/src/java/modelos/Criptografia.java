package modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import static modelos.Usuario.dados;
        
public class Criptografia {

  public static final String ALGORITHM = "RSA";

  /**
   * Local da chave privada no sistema de arquivos.
   */
  public static final String PATH_CHAVE_PRIVADA = "F:/faculdade_2020/Projeto_Final_Entregar/Sistema_IFPR/Projeto_Final_Entregar/keys/private.key";

  /**
   * Local da chave pública no sistema de arquivos.
   */
  public static final String PATH_CHAVE_PUBLICA = "F:/faculdade_2020/Projeto_Final_Entregar/Sistema_IFPR/Projeto_Final_Entregar/keys/public.key";

  /**
   * Gera a chave que contém um par de chave Privada e Pública usando 1025 bytes.
   * Armazena o conjunto de chaves nos arquivos private.key e public.key
   */
  public static void geraChave() {
    try {
      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
      keyGen.initialize(1024);
      final KeyPair key = keyGen.generateKeyPair();

      File chavePrivadaFile = new File(PATH_CHAVE_PRIVADA);
      File chavePublicaFile = new File(PATH_CHAVE_PUBLICA);

      // Cria os arquivos para armazenar a chave Privada e a chave Publica
      if (chavePrivadaFile.getParentFile() != null) {
        chavePrivadaFile.getParentFile().mkdirs();
      }

      chavePrivadaFile.createNewFile();

      if (chavePublicaFile.getParentFile() != null) {
        chavePublicaFile.getParentFile().mkdirs();
      }

      chavePublicaFile.createNewFile();

        try ( // Salva a Chave Pública no arquivo
                ObjectOutputStream chavePublicaOS = new ObjectOutputStream(
                        new FileOutputStream(chavePublicaFile))) {
            chavePublicaOS.writeObject(key.getPublic());
        }

        try ( // Salva a Chave Privada no arquivo
                ObjectOutputStream chavePrivadaOS = new ObjectOutputStream(
                        new FileOutputStream(chavePrivadaFile))) {
            chavePrivadaOS.writeObject(key.getPrivate());
        }
    } catch (IOException | NoSuchAlgorithmException e) {
    }

  }

  /**
   * Verifica se o par de chaves Pública e Privada já foram geradas.
     * @return 
   */
  public static boolean verificaSeExisteChavesNoSO() {

    File chavePrivada = new File(PATH_CHAVE_PRIVADA);
    File chavePublica = new File(PATH_CHAVE_PUBLICA);

    return chavePrivada.exists() && chavePublica.exists();
  }

  /**
   * Criptografa o texto puro usando chave pública.
     * @param texto
     * @param chave
     * @return 
   */
  public static byte[] criptografa(String texto, PublicKey chave) {
    byte[] cipherText = null;

    try {
      final Cipher cipher = Cipher.getInstance(ALGORITHM);
      // Criptografa o texto puro usando a chave Púlica
      cipher.init(Cipher.ENCRYPT_MODE, chave);
      cipherText = cipher.doFinal(texto.getBytes());
    } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
    }

    return cipherText;
  }

  /**
   * Decriptografa o texto puro usando chave privada.
     * @param texto
     * @param chave
     * @return 
   */
  public static String decriptografa(byte[] texto, PrivateKey chave) {
    byte[] dectyptedText = null;

    try {
      final Cipher cipher = Cipher.getInstance(ALGORITHM);
      // Decriptografa o texto puro usando a chave Privada
      cipher.init(Cipher.DECRYPT_MODE, chave);
      dectyptedText = cipher.doFinal(texto);

    } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
    }

    return new String(dectyptedText);
  }

  /**
   * Testa o Algoritmo
     * @param args
   */
  public static void main(String[] args) {

    try {

      // Verifica se já existe um par de chaves, caso contrário gera-se as chaves..
      if (!verificaSeExisteChavesNoSO()) {
       // Método responsável por gerar um par de chaves usando o algoritmo RSA e
       // armazena as chaves nos seus respectivos arquivos.
        geraChave();
      }

      final String msgOriginal = ArrayList<Usuario.senha>;
      ObjectInputStream inputStream = null;

      // Criptografa a Mensagem usando a Chave Pública
      inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PUBLICA));
      final PublicKey chavePublica = (PublicKey) inputStream.readObject();
      final byte[] textoCriptografado = criptografa(msgOriginal, chavePublica);

      // Decriptografa a Mensagem usando a Chave Pirvada
      inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PRIVADA));
      final PrivateKey chavePrivada = (PrivateKey) inputStream.readObject();
      final String textoPuro = decriptografa(textoCriptografado, chavePrivada);

      // Imprime o texto original, o texto criptografado e
      // o texto descriptografado.
      System.out.println("Mensagem Original: " + msgOriginal);
      System.out.println("Mensagem Criptografada: " +Arrays.toString(textoCriptografado));
      System.out.println("Mensagem Decriptografada: " + textoPuro);

    } catch (IOException | ClassNotFoundException e) {
    }
  }
}
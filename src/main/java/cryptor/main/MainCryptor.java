package cryptor.main;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class MainCryptor {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Digite o texta para encriptar");
		String entrada = scanner.nextLine();
		
		//Algorítimos de critografia simetricos
		//AES, RC2, RC5, IDEA, BLOWFISH
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
			SecretKey secretKey = keyGenerator.generateKey();
			Cipher cipher;
			cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] senhaCriptografada = cipher.doFinal(entrada.getBytes());
			System.out.println("Saída de texto encriptado: "+senhaCriptografada );
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] senhaDecriptografada = cipher.doFinal(senhaCriptografada);
			System.out.println("Saída de texto claro: "+new String(senhaDecriptografada));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Programa Finalizado!");
	}

}

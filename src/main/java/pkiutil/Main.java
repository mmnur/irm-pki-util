package pkiutil;

import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Main
{
	public static void main(String[] args)
	{
		try {
			/*
			TreeSet<String> algorithms = new TreeSet<String>();
			for (Provider provider : Security.getProviders())
			    for (Service service : provider.getServices())
			        if (service.getType().equals("Signature"))
			            algorithms.add(service.getAlgorithm());
			for (String algorithm : algorithms)
			    System.out.println(algorithm);
			
			System.out.println();
			System.out.println();
			*/
			if(args[0].equalsIgnoreCase("-genkey") == true) {
				KeyPair kp;
				try {
					kp = PkiUtil.generateKeyPair();
					System.out.println("Public key:");
					System.out.println(PkiUtil.getStringFormat(kp.getPublic()));
					System.out.println("Private key:");
					System.out.println(PkiUtil.getStringFormat(kp.getPrivate()));
				} catch (IrmCryptographyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(args[0].equalsIgnoreCase("-sign") == true) {
				if(args[1].equalsIgnoreCase("-pt") == true) {
					String text = args[2];
					if(args[3].equalsIgnoreCase("-k") == true) {
						String key = args[4];
						PrivateKey privateKey = PkiUtil.rebuildPrivateKey(key);
						String signature = PkiUtil.sign(text, privateKey);
						System.out.println();
						System.out.println("Signature: ");
						System.out.println(signature);
						System.out.println();
					}
				}
			}
			
			if(args[0].equalsIgnoreCase("-verify") == true) {
				if(args[1].equalsIgnoreCase("-s") == true) {
					String signature = args[2];
					if(args[3].equalsIgnoreCase("-pt") == true) {
						String text = args[4];
						if(args[5].equalsIgnoreCase("-k") == true) {
							String key = args[6];
							PublicKey publicKey = PkiUtil.rebuildPublicKey(key);
							if (PkiUtil.verify(text, signature, publicKey)) {
								System.out.println("Verification successful");
							}
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();			
			System.out.println("Usage: ");
			System.out.println("pkiutil -genkey");
			System.out.println("pkiutil -sign -pt <plaindata> -k <private_key>");
			System.out.println("pkiutil -verify -s <signature> -pt <plaindata> -k <public_key>");			
		}

	}

}

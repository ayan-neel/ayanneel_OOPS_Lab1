package com.gl.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CredentialService {
	
	private  ArrayList<List<String>>passwordBucket= new ArrayList<List<String>>();
	
	public CredentialService()
	{
		passwordBucket.add(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
		passwordBucket.add(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
		passwordBucket.add(Arrays.asList("1","2","3","4","5","6","7","8","9","0"));
		passwordBucket.add(Arrays.asList("@","#","$","&"));
		
	}
	public  String generatePassword()
	{
		String  password="";
		Random random = new Random();
		for(int i=0;i<8;i++) {
			List<String> selectedBucket=passwordBucket.get(random.nextInt(0, passwordBucket.size()));
			password+=selectedBucket.get(random.nextInt(0,selectedBucket.size()));	
		}
		return password;
			
	}
	public String generateEmailAddress(String firstName,String lastName,String department)
	{
		String emailId="";
		emailId+=firstName+"."+lastName+"@"+department+"."+"abc.com";
		emailId=emailId.toLowerCase();
		return emailId;
		
		
	}
	public static void main(String [] args)
	{
		CredentialService cs = new CredentialService();
		System.out.println("Generated email: "+cs.generateEmailAddress("Ayan","Medhi", "Technical"));
		System.out.println("Generated password: "+cs.generatePassword());
	}
	public void showCredentials(String firstName,String emailId,String password)
	{
		String message="Dear %s your generated credentials are as follows\nEmail-----> %s\nPassword---->%s";
		String formattedMessage = String.format(message,firstName,emailId,password);
		System.out.println(formattedMessage);
	}
}

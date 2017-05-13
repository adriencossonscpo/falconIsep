package com.falcon.avisep.ldap;
import com.falcon.avisep.ldap.LDAPObject;
import com.falcon.avisep.ldap.LDAPAccess;

class TestLDAP
{
	public static void main(String[] args)
	{
		LDAPAccess access = new LDAPAccess();
		try {
			//Enter login and password Here
		LDAPObject test = access.LDAPget("spedro", "Simaopedro0903@gmail.com1992");
		if (test == null)
		{
			System.out.println("login invalide");
			System.exit(1);
		}
		
		System.out.println(test.toString()+ ""+test.mail);
		System.exit(0);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}
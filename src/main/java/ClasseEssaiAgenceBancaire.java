

import tps.banque.AgenceBancaire;
import tps.banque.Compte;
import tps.banque.exception.*;

public class ClasseEssaiAgenceBancaire {
	public static void main (String[] argv ) throws Exception{
		AgenceBancaire monAg;
		monAg = new AgenceBancaire("Agence", "Toulouse");
		monAg.afficher();
		monAg.getNbComptes();
		Compte compte1 = new Compte ("0101", "prop1");
		Compte compte2 = new Compte ("0202", "prop2");
		Compte compte3 = new Compte ("0303", "prop2");
		
		try {
			monAg.addCompte(compte1);
			monAg.addCompte(compte2);
			monAg.addCompte(compte3);
			
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		monAg.afficher();
		Compte compte = monAg.getCompte("9999");
		if (compte == null) {
			System.out.println("Le compte n'existe pas");
		}
		// 10) le résulat est null car le compte 9999 n'existe pas
		
		// question one shot:
		
		Compte c = monAg.getCompte("0101");
		if (c != null) {
		    c.afficher();
		    c.deposer (1000);
		}
		
		c = monAg.getCompte("0101");
		if (c != null) {
		    c.afficher();
		}
		
		Compte tabCompte[] = monAg.getComptesDe("prop2");
		for(int i = 0; i < tabCompte.length; i++) {
			tabCompte[i].afficher();
		}
		
		compte2.deposer(2000);
		compte3.deposer(3000);
		
		for(int i = 0; i < tabCompte.length; i++) {
			tabCompte[i].afficher();
		}
		// 14) Les transactions ont bien été faites sur les comptes
		
		Compte[] tc = monAg.getComptesDe("ABSENT");
		for(int i = 0; i < tc.length; i++) {
			tc[i].afficher();
		}
		
		try {
			c = null;
			monAg.addCompte(c);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		
		monAg.removeCompte("0202");
		monAg.removeCompte("9999"); // Le compte n'existe pas donc le programme lève une exception
		
		Compte compte4 = new Compte ("0101", "prop99");
		try {
			monAg.addCompte(compte4);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
	}
}

import tps.banque.Compte;
import tps.banque.exception.CompteException;

public class ClasseEssaiCompte {
	
	public static void mainExo1(String[] argv) throws Exception {
		Compte cUn = null;
		cUn = new Compte("010101", "Lepoisson Benoit");
		try {
			cUn.deposer(100);
			cUn.retirer(20);
		} catch (CompteException e) {
			System.out.println("Probleme de solde");
		}	
		cUn.getNumCompte();
		cUn.getProprietaire();
		cUn.soldeCompte();	
		
		cUn.afficher();
	}


	// 7) Le montant du débit est de 0
	// 8) Il se passe la meme chose pour le crédit
	// 9) si je remplace la méthode afficher il affiche la meme chose qu'avec la fonction afficher
	// 10) Cette instruction affiche l'identifiant mémoire
	// 12) le résultat est le meme
	// 13) le compte est affiché normalement, on voit son numéro, son propriétaire, le debit, le credit et le nombre d'opération qui a été effectuée
	
	public static void main (String[] argv) throws Exception {
		Compte cUn = null;
		Compte cDeux;
		cDeux = new Compte("020202", "Marie");
		
		Compte cTrois;
		Compte cQuatre;
		
		cDeux = cUn;
		cTrois = cUn;
		cQuatre = cUn;
		
		try {
			cDeux.deposer(0);
		} catch (CompteException e) {
			System.out.println(e);
		}
		cUn.afficher();
		cDeux.afficher();
	
	}
	// 3) Le compte 1 ne possede pas de numero et de proprietaire acr on la initialiser sans parametres
	// 5) Quand j'essaie de retirer -100 a cUn une exception est levée donc les debits et credits ne sont pas appliqués
	// 6) Quand j'essaie de déposer -100 a cDeux une exception est levée cependant le débit de cUn a été effectué
	// 8) On en conclu que cUn et cDeux on la meme adresse memoire
	// 12) Je constate que tous les comptes ont les memes caractéristiques*
	// 13) Ils possedent la meme adresse memoire  ont peut donc en conclure que affecter un compte a un autre les lie. 
	// Par conséquent lorsqu'on en modifie l'autre est modifié aussi
	// 14) Je pense que les valuers modifiés dans cTrois et cQuatre vont etre affecté à tous les comptes
	// 15) Les valeurs modifier dans cTrois et cQuatre ont été affecté aussi à cUn et cDeux car ils sont liés 
	// 16) Je n'y arrive pas. Je n'y arrive pas car j'ai perdu l'adresse mémoire du compte de Marie
	// 18) Il y a une erreur qui dit que cDeux est null
	// 19) Il y a le meme erreur qui apparait mais normalement je devrais avoir les valeurs de cUn à null
	// 20) J'ai toujours l'erreur ùais je devrais avoir les meme valeurs pour cUn et cDeux
	
	// 2.3.3) 2) en 1, le nom affiché sera Marie et en 2, le nom affiché sera Jean
	
	
	
}

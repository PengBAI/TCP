import java.util.ArrayList;

public class TCPSyncronize extends Thread {

	private static ArrayList<String> labelEvenement = new ArrayList<String>();

	/* mettre en place un compteur d��v�nements */
	public synchronized void compteurEvenements() {
		labelEvenement.add(String.valueOf(super.getId()));
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			System.out
					.println("InterruptedException TCPSyncronize.compteurEvenements");
		}
	}

	/* L�affichage du compteur d��v�nements */
	public void affichageCompteur() {
		System.out.println(labelEvenement);
	}

}

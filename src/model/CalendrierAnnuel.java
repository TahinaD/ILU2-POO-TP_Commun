package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = new Mois[12];
	
	public CalendrierAnnuel() {
		String[] nomMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
		int[] nbJours = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int i = 0; i < 12; i++) {
			calendrier[i] = new Mois(nomMois[i], nbJours[i]);
		}
	}
	
	private static class Mois {
		private String nom;
		private boolean[] jours;
		
		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
			for (int i = 0; i < nbJours; i++)
				jours[i] = true;
		}
		
		private boolean estLibre(int jour) {
			return jours[jour];
		}
		
		private void reserver(int jour) {
			if (!jours[jour])
				throw new IllegalStateException();
			else
				jours[jour] = false;
		}
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		if (estLibre(jour, mois)) {
			calendrier[mois-1].reserver(jour-1);
			return true;
		}
		return false;
	}
}

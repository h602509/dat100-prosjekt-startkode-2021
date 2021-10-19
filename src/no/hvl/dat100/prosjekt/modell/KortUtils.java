package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.Spill;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {

		Kort[] temp = samling.getSamling();

		for (int i = 0; i < samling.getAntalKort() - 1; i++) {
			int a = temp[i].compareTo(temp[i + 1]);

			if (a > 0) {
				Kort t = temp[i];
				temp[i] = temp[i + 1];
				temp[i + 1] = t;
				i = 0;
			}
		}
	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < samling.getAntalKort(); j++) {

				int maks = samling.getAntalKort() - 1; // antall i samling - 1
				int min = 1;
				double random = Math.random() * (maks - min) + min;
				int randomPlass = (int) random;

				Kort[] kort = samling.getSamling();
				if (j != randomPlass) {
					Kort temp = kort[j];
					kort[j] = kort[randomPlass];
					kort[randomPlass] = temp;
				}
			}
		}
	}

	public static void flytt(KortSamling samlingFra, KortSamling samlingTil) {

		while (0 < samlingFra.getAntalKort()) {

			samlingTil.leggTil(samlingFra.taSiste());

		}
	}

}

package fr.mowitnow.tondeuse;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class TondeuseTests {

	private String[] fichier = { "5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA" };

	private static Tondeuse tondeuse1;
	private static Tondeuse tondeuse2;
	private static String fileName;

	// Tondeuse tondeuse = Tondeuse();

	@BeforeClass
	public static void beforeClass() {
		fileName = "/tmp/tondeuse.txt";
		Tondeuse.maxX = 5;
		Tondeuse.maxY = 5;
		tondeuse1 = new Tondeuse(1, 2, "N");
		tondeuse2 = new Tondeuse(3, 3, "E");
	}

	@Test
	public void tondeuse_retourne_bonne_valeur() {
		tondeuse1.move(fichier[2]);
		assertTrue(tondeuse1.getX().equals(1));
		assertTrue(tondeuse1.getY().equals(3));
		assertTrue(tondeuse1.getDirection().equals("N"));

		tondeuse2.move(fichier[4]);
		assertTrue(tondeuse2.getX().equals(5));
		assertTrue(tondeuse2.getY().equals(1));
		assertTrue(tondeuse2.getDirection().equals("E"));

	}
	
	@Test
	public void file_exist() {
		String resultatAttendu= "/tmp/tondeuse.txt";
		String resultat = ReaderFile.getExistFile(fileName);
		
		assertTrue(resultatAttendu.equals(resultat));
	}
	
	@Test
	public void file_is_no_exist() {
		
		String resultat = ReaderFile.getExistFile("/tmp/tondeu.txt");
		
		assertNull(resultat);
	}
	
	@Test
	public void readFile_retourne_bonne_valeur() {
		List<String> resultatAttendu = Arrays.asList("1 3 N",  "5 1 E");
		List<String> resultat=ReaderFile.readOneLine(fileName);
		
		assertTrue(resultatAttendu.containsAll(resultat));

	}
}

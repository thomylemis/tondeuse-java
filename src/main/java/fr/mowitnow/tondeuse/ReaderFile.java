package fr.mowitnow.tondeuse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.mowitnow.tondeuse.enums.DirectEnum;

public class ReaderFile {
	private static Logger logger = LoggerFactory.getLogger(ReaderFile.class);
	private final static String MESSAGE_ERREUR= "Erreur lors de la lecture du fichier : ";

	public static List<String> readOneLine(String filename) {
		List<String> resultats = new ArrayList<String>();
		String nameFile = getExistFile(filename);
		
		if (nameFile == null || nameFile.isEmpty()) {
			return resultats;
		}
		try (BufferedReader bReader = new BufferedReader(new FileReader(nameFile))) {
			String str = bReader.readLine();
			if (str != null) {
				String[] maxPosition = str.split("\\s+");
				if (maxPosition == null || maxPosition.length < 2) {
					return resultats;
				}
				Tondeuse.setMaxX(Integer.parseInt(maxPosition[0]));
				Tondeuse.setMaxY(Integer.parseInt(maxPosition[1]));
			}

			while ((str = bReader.readLine()) != null) {
				Tondeuse tondeuse = new Tondeuse();
				String[] position = str.split("\\s+");
				if (position == null || position.length < 3) {
					return resultats;
				}
				tondeuse.setX(Integer.parseInt(position[0]));
				tondeuse.setY(Integer.parseInt(position[1]));
				if (!DirectEnum.verifyDirection(position[2])) {
					str = bReader.readLine();
					continue;
				}
				tondeuse.setDirection(position[2]);
				if ((str = bReader.readLine()) != null) {
					resultats.add(tondeuse.move(str));
				}
			}
		} catch (Exception e) {
			logger.error(MESSAGE_ERREUR + filename);
		}
		return resultats;
	}

	public static String getExistFile(String filename) {
		String filePath = null;
		try {
			Path path = FileSystems.getDefault().getPath(filename);
			if (path.toFile().isFile()) {
				return path.toString();
			}
		} catch (Exception e) {
			logger.error(MESSAGE_ERREUR+ filename);
		}

		return filePath;
	}

}

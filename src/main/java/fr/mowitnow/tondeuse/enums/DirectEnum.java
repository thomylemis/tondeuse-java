package fr.mowitnow.tondeuse.enums;

public enum DirectEnum {
	/** direction Nord */
	N,
	/** direction Sud */
	S,
	/** direction OuEst */
	W,
	/** direction Est */
	E;

	public static boolean verifyDirection(String name) {
		for (DirectEnum value : DirectEnum.values()) {
			if (value.name().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
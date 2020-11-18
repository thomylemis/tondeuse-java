package fr.mowitnow.tondeuse.enums;

public enum CommandEnum {
	
	/** commande Avancée */
	A('A'),
	/** commande Tourné à gauche */
	G('G'),
	/** commande Tourné à droite */
	D('D');
	
	private final char asChar;
	 
	CommandEnum(char asChar) {
        this.asChar = asChar;
    }
	
	public static boolean verifyCommande(char name) {
		for (CommandEnum value : CommandEnum.values()) {
			if (value.asChar==name) {
				return true;
			}
		}
		return false;
	}

}

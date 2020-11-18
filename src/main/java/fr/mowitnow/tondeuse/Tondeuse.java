package fr.mowitnow.tondeuse;

import fr.mowitnow.tondeuse.enums.CommandEnum;
import fr.mowitnow.tondeuse.enums.DirectEnum;

public class Tondeuse {

	public static Integer maxX;
	public static Integer maxY;

	private Integer x;
	private Integer y;

	private String direction;

	public Tondeuse() {
	}

	public Tondeuse(Integer x, Integer y, String direct) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direct;
	}

	public static Integer getMaxX() {
		return maxX;
	}

	public static void setMaxX(Integer maxX) {
		Tondeuse.maxX = maxX;
	}

	public static Integer getMaxY() {
		return maxY;
	}

	public static void setMaxY(Integer maxY) {
		Tondeuse.maxY = maxY;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String move(String cmds) {

		cmds.chars().forEach(is -> {
			char cmd = (char) is;
			if (!CommandEnum.verifyCommande(cmd)) {
				return;
			}
			if (!DirectEnum.verifyDirection(this.getDirection())) {
				return;
			}
			DirectEnum direction = DirectEnum.valueOf(this.getDirection());
			switch (direction) {
			case N:
				directionNordAction(cmd);
				break;

			case S:
				directionSudAction(cmd);
				break;

			case W:
				directionOuEstAction(cmd);
				break;

			case E:
				directionEstAction(cmd);
				break;

			default:
				break;
			}
		});

		return String.format("%d %d %s", this.getX(), this.getY(), this.getDirection());
	}

	private void directionNordAction(char cmd) {
		if ((cmd == CommandEnum.A.name().charAt(0)) && (this.getY() + 1 > maxY)) {
			return;
		}
		if (cmd == CommandEnum.A.name().charAt(0)) {
			this.setY(this.getY() + 1);
		}
		if (cmd == CommandEnum.G.name().charAt(0)) {
			this.setDirection(DirectEnum.W.name());
		}
		if (cmd == CommandEnum.D.name().charAt(0)) {
			this.setDirection(DirectEnum.E.name());
		}

	}

	private void directionSudAction(char cmd) {
		if ((cmd == CommandEnum.A.name().charAt(0)) && (this.getY() - 1 < 0)) {
			return;
		}
		if (cmd == CommandEnum.A.name().charAt(0)) {
			this.setY(this.getY() - 1);
		}
		if (cmd == CommandEnum.G.name().charAt(0)) {
			this.setDirection(DirectEnum.E.name());
		}
		if (cmd == CommandEnum.D.name().charAt(0)) {
			this.setDirection(DirectEnum.W.name());
		}
	}

	private void directionEstAction(char cmd) {
		if ((cmd == CommandEnum.A.name().charAt(0)) && (this.getX() + 1 > maxX)) {
			return;
		}
		if (cmd == CommandEnum.A.name().charAt(0)) {
			this.setX(this.getX() + 1);
		}
		if (cmd == CommandEnum.G.name().charAt(0)) {
			this.setDirection(DirectEnum.N.name());
		}
		if (cmd == CommandEnum.D.name().charAt(0)) {
			this.setDirection(DirectEnum.S.name());
		}
	}

	private void directionOuEstAction(char cmd) {
		if ((cmd == CommandEnum.A.name().charAt(0)) && (this.getX() - 1 < 0)) {
			return;
		}
		if (cmd == CommandEnum.A.name().charAt(0)) {
			this.setX(this.getX() - 1);
		}
		if (cmd == CommandEnum.G.name().charAt(0)) {
			this.setDirection(DirectEnum.S.name());
		}
		if (cmd == CommandEnum.D.name().charAt(0)) {
			this.setDirection(DirectEnum.N.name());
		}

	}

}

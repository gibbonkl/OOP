package fellowship;

public class Wizard extends Person {

	Wizard(String name) {
		super(name);
	}

	@Override
	public String breed() {
		return "Wizard";
	}

}

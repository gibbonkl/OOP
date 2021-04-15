package fellowship;

public class Human extends Person {

	Human(String name) {
		super(name);
	}

	@Override
	public String breed() {
		return "Human";
	}

}

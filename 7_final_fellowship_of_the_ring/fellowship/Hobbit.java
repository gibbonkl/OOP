package fellowship;

public class Hobbit extends Person {

	Hobbit(String name) {
		super(name);
	}

	@Override
	public String breed() {
		return "Hobbit";
	}

}

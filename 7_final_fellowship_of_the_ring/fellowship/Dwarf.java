package fellowship;

public class Dwarf extends Person {

	Dwarf(String name) {
		super(name);
	}

	@Override
	public String breed() {
		return "Dwarf";
	}

}

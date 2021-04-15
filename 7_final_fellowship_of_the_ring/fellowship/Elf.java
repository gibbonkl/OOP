package fellowship;

public class Elf extends Person {

	Elf(String name) {
		super(name);
	}

	@Override
	public String breed() {
		return "Elf";
	}

}

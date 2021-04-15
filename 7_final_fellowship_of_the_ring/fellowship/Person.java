package fellowship;

public abstract class Person {

	private String name;
	private Fellowship fellowship;
	private boolean isAlive = true;

	public Person(String name) {
		this.name = name;
	}

	public String name() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public boolean equals(Person person) {
		return this.name == person.toString();
	}

	public Fellowship fellowship() {
		return this.fellowship;
	}

	public void setFellowship(Fellowship fellowship) {
		this.fellowship = fellowship;
	}

	public boolean isMemberOfAFellowship() {
		if (fellowship() != null)
			return true;
		return false;
	}

	public boolean isMemberOfTheFellowship(Fellowship fellowship) {
		if (this.fellowship() == (fellowship))
			return true;
		return false;
	}

	public void join(Fellowship fellowship) {
		if (isAlive == false)
			return;
		fellowship.signUp(this);
	}

	public abstract String breed();

	public void left() {
		this.fellowship().cancel(this);
		this.setFellowship(null);
	}

	public void die() {
		this.left();
		this.isAlive = false;
	}

	public boolean isFellowOf(Person person) {
		if (this.fellowship() == person.fellowship())
			return true;
		return false;
	}

	public void fellow(Person person) {
		this.setFellowship(person.fellowship());
	}

}

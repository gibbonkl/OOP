package fellowship;

public class Member {

	private Person member;

	public Member(Person person, Fellowship fellowship) {
		this.member = person;
		this.member.setFellowship(fellowship);
	}

	public Person person() {
		return this.member;
	}

	public String getBreed() {
		return this.member.breed();
	}

}

package fellowship;

public class Fellowship {

	private String fellowshipName;
	private List<Member> members = new List();

	public Fellowship(String name) {
		this.fellowshipName = name;
	}

	public int count() {
		return this.members.count();
	}

	public boolean hasNoMembers() {
		if (this.members.count() == 0)
			return true;
		return false;
	}

	public boolean hasMembers() {
		return !this.hasNoMembers();
	}

	@Override
	public String toString() {
		return "Fellowship " + this.fellowshipName;
	}

	public Member member(int i) {
		if (i < 1 || i > this.members.count())
			return null;
		return this.members.get(i - 1);
	}

	public Member lastMember() {
		return this.member(this.count());
	}

	public void signUp(Person person) {
		if (person.isMemberOfAFellowship())
			return;
		this.members.append(new Member(person, this));
	}

	public int count(String breed) {
		int count = 0;
		for (int i = 0; i < this.count(); i++) {
			if (this.members.get(i).getBreed().equals(breed)) {
				count++;
			}
		}

		return count;
	}

	public boolean has(String breed) {
		if (this.count(breed) > 0)
			return true;
		return false;
	}

	public void signUp(Person p1, Person p2) {
		this.signUp(p1);
		this.signUp(p2);
	}

	public void signUp(Person p1, Person p2, Person p3) {
		this.signUp(p1, p2);
		this.signUp(p3);
	}

	public void cancel(Person person) {

		for (int i = 0; i < this.count(); i++) {
			if (this.members.get(i).person().equals(person)) {
				this.members.remove(this.members.get(i));
				person.setFellowship(null);
			}
		}
	}

	public void dissolve() {
		this.members = new List();
	}
}

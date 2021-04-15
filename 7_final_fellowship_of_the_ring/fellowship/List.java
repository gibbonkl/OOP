package fellowship;

public class List<T> {

	private Object[] olist = new Object[5];

	public int count() {
		int counter = 0;
		for (int i = 0; i < this.olist.length; i++) {
			if (this.olist[i] != null) {
				counter++;
			}
		}
		return counter;
	}

	public T get(int i) {
		rearrange();
		return (T) this.olist[i];
	}

	public void append(T o) {
		rearrange();
		Object[] auxlist = new Object[this.olist.length + 5];
		System.arraycopy(this.olist, 0, auxlist, 0, this.olist.length);
		auxlist[this.olist.length] = o;
		this.olist = auxlist;
	}

	public int indexOf(T o) {
		rearrange();
		for (int j = 0; j < this.olist.length; j++) {
			if (get(j) == o)
				return j;
		}
		return -1;
	}

	public boolean delete(int i) {
		if (this.olist[i] != null) {
			this.olist[i] = null;
			return true;
		}
		return false;
	}

	public boolean remove(T o) {
		return delete(indexOf(o));
	}

	public void rearrange() {
		Object auxlist[] = new Object[this.olist.length];
		int j = 0;
		for (int i = 0; i < this.olist.length; i++) {
			if (this.olist[i] != null) {
				auxlist[j] = this.olist[i];
				j++;
			}
		}
		this.olist = auxlist;
	}

}
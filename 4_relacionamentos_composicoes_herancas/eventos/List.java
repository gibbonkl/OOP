import java.util.Arrays;
public class List {
	
	private Object [] olist = new Object[5];
	
	//System.arraycopy(source, 3, destination, 2, 5)
	//java.util.Arrays.copyOf(int[] original,int newLength)

	public int count() {
		int counter = 0;
		for (int i=0; i<this.olist.length; i++) {
			if (this.olist[i] != null) {
				counter++;
			}
		}
		return counter;
	}

	public boolean isEmpty() {
		if (count() == 0) {
			return true;
		} else return false;
	}

	public Object get(int i) {	
		rearrange();
		return this.olist[i];
	}

	public void append(Object o) {
		rearrange();
		//Object [] auxlist = Arrays.copyOf(this.olist, this.olist.length+5);
		Object [] auxlist = new Object [this.olist.length+5];
		System.arraycopy(this.olist, 0, auxlist, 0, this.olist.length);
		auxlist [this.olist.length] = o;	
		this.olist = auxlist;
	}

	public int indexOf(Object o) {
		rearrange();
		for (int j=0; j<this.olist.length; j++) {
			if (get(j) == o) return j;
	}
		return -1;
	}

	public boolean has(Object o) {
		if (indexOf(o) != -1) {
			return true;
		}
		return false;
	}

	public boolean delete(int i) {
		if (this.olist[i] !=null) {
			this.olist[i] = null;
			return true;
		}
		return false;
	}

	public boolean remove(Object o) {	
		return delete(indexOf(o));
	}

	public void reset() {
		rearrange();
		for (int i=0; i<this.olist.length; i++) {
			delete(i);
			//if (this.olist[i] != null) {
			//	this.olist[i] = null;
			//}
		}
	}

	public void prepend(Object o) {
		rearrange();
		Object [] auxlist = new Object [this.olist.length + 5]	;
		auxlist[0] = o;
		System.arraycopy(this.olist, 0, auxlist, 1, olist.length);
		this.olist = auxlist;
	}

	public void insert(Object o, int i) {
		rearrange();
		if (i < 0 || i > this.olist.length || (get(i) == null && i != count())) return;
		if (get(i) == null && i == count()) {
			this.olist[count()] = o;
			return;
		}
		Object [] auxlist = new Object [this.olist.length + 5]	;
		auxlist[i] = o;
		System.arraycopy(this.olist, 0, auxlist, 0, i);
		System.arraycopy(this.olist, i, auxlist, i+1, this.olist.length - 1);
		this.olist = auxlist;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		List other = (List) obj;
		if (!Arrays.deepEquals(this.olist, other.olist))
			return false;
		return true;
	}

	public void rearrange() {
		Object auxlist [] = new Object [this.olist.length];
		int j = 0;
		for (int i=0; i<this.olist.length; i++) {
			if (this.olist[i] != null) {
				auxlist[j] = this.olist[i];
				j++;
			}
		}
		this.olist = auxlist;
	}

}

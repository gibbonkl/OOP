package persistencia;

import java.util.List;

public abstract class AbstractDAO<T> {

	protected String url = "jdbc:postgresql://localhost/siamelhorado";
	protected String user = "postgres";
	protected String password = "postgres";

	public abstract void insert(T pessoa);

	public abstract T select(int id);

	public abstract List<T> select();

	public abstract void delete(int id);

}

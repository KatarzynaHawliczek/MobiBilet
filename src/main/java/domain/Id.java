package domain;

public abstract class Id implements IHaveId {

	protected Long id;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

}

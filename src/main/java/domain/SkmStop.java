package domain;

public class SkmStop extends Id {

	private String name;
	private Integer distanceToGdanskSrodmiescie;

	public Integer getDistanceToGdanskSrodmiescie() {

		return distanceToGdanskSrodmiescie;
	}

	public void setDistanceToGdanskSrodmiescie(Integer distanceToGdanskSrodmiescie) {

		this.distanceToGdanskSrodmiescie = distanceToGdanskSrodmiescie;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Override
	public String toString() {

		return name;
	}

}

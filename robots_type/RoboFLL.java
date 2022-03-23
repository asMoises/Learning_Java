package robots_type;

public class RoboFLL extends Robot {

	private int arms;

	public RoboFLL(String name, String category, Double weight, int arms) {
		super(name, category, weight);
		this.arms = arms;
	}

	public int isArms() {
		return arms;
	}

	public void setArms(int arms) {
		this.arms = arms;
	}

	@Override
	public String repot() {
		String arms;

		if (this.arms == 1) {
			arms = "Arms OK!";
		} else {
			arms = "No Arms";
		}

		return "Name: " + getName() + ", Category: " + getCategory() + "Weight: "
				+ String.format("%.2f", getWeight()) + ", Arms: " + arms;
	}
}

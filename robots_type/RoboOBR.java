package robots_type;

public class RoboOBR extends Robot {

	private String model;

	public RoboOBR(String name, String category, Double weight, String model) {
		super(name, category, weight);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String repot() {
		return "Name: " + getName() + ", Category: " + getCategory() + "Weight: "
				+ String.format("%.2f", getWeight()) + ", Model: " + model;
	}

}

package robots_type;

public class Robot {

	private String name;
	private String category;
	private Double weight;

	public Robot(String name, String category, Double weight) {
		this.name = name;
		this.category = category;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String repot() {
		return "Name: " + name + ", Category: " + category + "Weight: " + String.format("%.2f", weight);
	}

}

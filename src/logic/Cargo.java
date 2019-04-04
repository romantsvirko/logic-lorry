package logic;

public class Cargo {
	
    private int cargoId;
	
	private String name;
	
	private String weight;
	
	public String getName() {
		return name;
	}
	
	public void setName(String nname) {
		this.name = name;
	}
	
	public String getWeight() {
		return weight;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
		
    public int getCargoId() {
        return cargoId;
    }
 
    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

}

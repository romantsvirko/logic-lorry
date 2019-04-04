package logic;

public class Lorry {
	
	private int lorryId;
	
	private String carBrand;
	
	private String nomberOfLorry;
	
	private String tonnage;
	
	private int routeId;
	
	private int cargoId;
	
	public int getLorryId() {
		return lorryId;
	}
	
	public void setLorryId(int lorryId) {
		this.lorryId = lorryId;
	}
	
	public String getCarBrand() {
		return carBrand;
	}
	
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	
	public String getNomberOfLorry() {
		return nomberOfLorry;
	}
	
	public void setNomberOfLorry(String nomberOfLorry) {
		this.nomberOfLorry = nomberOfLorry;
	}
	
	public String getTonnage() {
		return tonnage;
	}
	
	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}
	
	public int getRouteId() {
        return routeId;
    }
 
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
    
    public int getCargoId() {
        return cargoId;
    }
 
    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

}

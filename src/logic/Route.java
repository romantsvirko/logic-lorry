package logic;

public class Route {

    private int routeId;
	
	private String numberOfWaybill;
	
	private String placeOfLoading;
	
	private String unloadingPoint;
	
	private int mileage;
	
	private int cargoId;
	
	public int getRouteId() {
		return routeId;
	}
	
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public String getNumberOfWaybill() {
		return numberOfWaybill;
	}
	
	public void setNumberOfWaybill(String numberOfWaybill) {
		this.numberOfWaybill = numberOfWaybill;
	}
	
	public String getPlaceOfLoading() {
		return placeOfLoading;
	}
	
	public void setPlaceOfLoading(String placeOfLoading) {
		this.placeOfLoading = placeOfLoading;
	}
	
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	
	public int getMileage() {
        return mileage;
    }
 
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    public int getCargoId() {
        return cargoId;
    }
 
    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

}

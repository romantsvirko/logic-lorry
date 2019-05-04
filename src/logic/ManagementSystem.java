package logic;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ManagementSystem {
	private List<Lorry> lorries;
	private List<Route> routes;
	private List<Cargo> cargos;
	private Collection<Driver> drivers;
		
	private static ManagementSystem instance;
	
	private ManagementSystem( ) {
		loadDrivers();
		loadLorries();
		loadRoutes();
		loadCargos();
	}
	
	public static synchronized ManagementSystem getInstance() {
		if (instance == null) {
			instance = new ManagementSystem();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream("out.txt"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return;
		}
		
		ManagementSystem ms = ManagementSystem.getInstance();
		
		printString("Full list of lorries");
		printString("********************");
		List<Lorry> allLorries = ms.getLorries();
		for (Lorry li : allLorries) {
			printString(li);
		}
		printString();
		
		printString("Full list of routes");
		printString("********************");
		List<Route> allRoutes = ms.getRoutes();
		for (Route ri : allRoutes) {
			printString(ri);
		}
		printString();
		
		printString("Full list of cargos");
		printString("********************");
		List<Cargo> allCargos = ms.getCargos();
		for (Cargo ci : allCargos) {
			printString(ci);
		}
		printString();
		
		printString("Full list of drivers");
		printString("********************");
		Collection<Driver> allDrivers = ms.getAllDrivers();
		for (Driver di : allDrivers) {
			printString(di);
		}
		printString();
		
		printString("List of drivers from lorries");
		printString("**************************");
		List<Lorry> lorries = ms.getLorries();
		for (Lorry li : lorries) {
			printString("--->> Lorry:" + li.getNumberOfLorry());
			Collection<Driver> drivers = ms.getDriversFromLorry(li, 3536);
			for (Driver di : drivers) {
				printString(di);
			}
		}
		printString();
		
		printString("List of drivers from routes");
		printString("**************************");
		List<Route> routes = ms.getRoutes();
		for (Route ri : routes) {
			printString("--->> Route:" + ri.getRouteId());
			Collection<Driver> drivers = ms.getDriversFromRoute(ri, 32);
			for (Driver di : drivers) {
				printString(di);
			}
		}
		printString();
		
		printString("List of lorries from routes");
		printString("**************************");
		routes = ms.getRoutes();
		for (Route ri : routes) {
			printString("--->> Route:" + ri.getRouteId());
			TreeSet<Lorry> alllorries = ms.getLorriesFromRoute(ri, 32);
			for (Lorry li : alllorries) {
				printString(li);
			}
		}
		printString();
		
		printString("List of cargos from lorries");
		printString("**************************");
		lorries = ms.getLorries();
		for (Lorry li : lorries) {
			printString("--->> Lorry:" + li.getNumberOfLorry());
			TreeSet<Cargo> cargos = ms.getCargosFromLorry(li, 32);
			for (Cargo ci : cargos) {
				printString(ci);
			}
		}
		printString();
		
		Driver d = new Driver();
		d.setDriverId(7);
		d.setFirstName("Peter");
		d.setSurName("Jackson");
		d.setPatronymic("Well");
		d.setSex('M');
		Calendar c = Calendar.getInstance();
		c.set(1989, 5, 29);
		d.setDateOfBirth(c.getTime());
		d.setLorryId(5);
		d.setWorkExperience(15);
		printString("Add driver:" + d);
		printString("***********");
		ms.insertDriver(d);
		printString("--->> Full list of driver after added");
		allDrivers = ms.getAllDrivers();
		for(Driver di : allDrivers) {
			printString(di);
		}
		printString();
		
		d = new Driver();
		d.setDriverId(7);
		d.setFirstName("Peter");
		d.setSurName("Big");
		d.setPatronymic("Well");
		d.setSex('M');
		c = Calendar.getInstance();
		c.set(1989, 5, 29);
		d.setDateOfBirth(c.getTime());
		d.setLorryId(5);
		d.setWorkExperience(15);
		printString("Corecting date of driver:" + d);
		printString("*************************");
		ms.updateDriver(d);
		printString("--->> Full list of driver after correcting");
		allDrivers = ms.getAllDrivers();
		for(Driver di : allDrivers) {
			printString(di);
		}
		printString();
		
		printString("Delete driver:" + d);
		printString("**************");
		ms.deleteDriver(d);
		printString("--->> Full list of driver after delete");
		allDrivers = ms.getAllDrivers();
		for(Driver di : allDrivers) {
			printString(di);
		}
		printString();
		
		Lorry l1 = lorries.get(0);
		Lorry l2 = lorries.get(1);
		printString("Move drivers from first lorry to second");
		printString("**************************************");
		ms.moveDriversToLorry(l1, 2001, l2, 2002);
		printString("--->> Full list of driver after moving");
		allDrivers = ms.getAllDrivers();
		for(Driver di : allDrivers) {
			printString(di);
		}
		printString();
		
		printString("Remove drivers from lorry:" + l2 + "in 2001 year");
		printString("**************************");
		ms.removeDriversFromLorry(l2, 2001);
		printString("--->> Full list of driver after removing");
		allDrivers = ms.getAllDrivers();
		for(Iterator<Driver> i = allDrivers.iterator();i.hasNext();) {
			printString(i.next());
		}
		printString();
		
		Route r1 = routes.get(0);
		Route r2 = routes.get(1);
		printString("Move drivers from first route to second");
		printString("***************************************");
		ms.moveDriversToRoute(r1, 1, r2, 2);
		printString("--->> Full list of driver after moving");
		allDrivers = ms.getAllDrivers();
		for(Driver di : allDrivers) {
			printString(di);
		}
		printString();
		
		printString("Remove drivers from route:" + r2 + "with id 2");
		printString("**************************");
		ms.removeDriversFromRoute(r2, 2);
		printString("--->> Full list of driver after removing");
		allDrivers = ms.getAllDrivers();
		for(Iterator<Driver> i = allDrivers.iterator();i.hasNext();) {
			printString(i.next());
		}
		printString();
		
		printString("Move lorries from first route to second");
		printString("***************************************");
		ms.moveLorriesToRoute(r1, 2001, r2, 2002);
		printString("--->> Full list of lorries after moving");
		allLorries = ms.getLorries();
		for(Lorry li : allLorries) {
			printString(li);
		}
		printString();
		
		printString("Remove lorries from route:" + r2 + "in 2001 year");
		printString("**************************");
		ms.removeLorriesFromRoute(r2, 2001);
		printString("--->> Full list of lorry after removing");
		allLorries = ms.getLorries();
		for(Iterator<Lorry> i = allLorries.iterator();i.hasNext();) {
			printString(i.next());
		}
		printString();
		
		l1 = lorries.get(0);
		l2 = lorries.get(1);
		printString("Move cargos from first lorry to second");
		printString("**************************************");
		ms.moveCargosToLorry(l1, 2001, l2, 2002);
		printString("--->> Full list of cargo after moving");
		allCargos = ms.getCargos();
		for(Cargo ci : allCargos) {
			printString(ci);
		}
		printString();
		
		printString("Remove cargos from lorry:" + l2 + "in 2001 year");
		printString("*************************");
		ms.removeCargosFromLorry(l2, 2001);
		printString("--->> Full list of cargo after removing");
		allCargos = ms.getCargos();
		for(Iterator<Cargo> i = allCargos.iterator();i.hasNext();) {
			printString(i.next());
		}
		printString();
	}
	public void loadLorries() {
		if(lorries == null) {
			lorries = (List<Lorry>) new ArrayList<Lorry>();
		} else {
			lorries.clear();
		}
		Lorry l = null;
		
		l = new Lorry();
		l.setLorryId(1);
		l.setCarBrand("Mercedes");
		l.setNumberOfLorry("3535TT");
		l.setTonnage("20000 kl");
		l.setRouteId(2);
		l.setCargoId(1);
		
		l = new Lorry();
		l.setLorryId(2);
		l.setCarBrand("Volvo");
		l.setNumberOfLorry("4545AA");
		l.setTonnage("15000 kl");
		l.setRouteId(1);
		l.setCargoId(2);
	}
	
	public void loadRoutes() {
		if(routes == null) {
			routes = new ArrayList<Route>();
		} else {
			routes.clear();
		}
		Route r = null;
		
		r = new Route();
		r.setRouteId(1);
		r.setNumberOfWaybill("AB834567");
		r.setPlaceOfLoading("Mozyr");
		r.setUnloadingPoint("Minsk");
		r.setMileage(260);
		r.setCargoId(1);
		
		r = new Route();
		r.setRouteId(2);
		r.setNumberOfWaybill("AB834565");
		r.setPlaceOfLoading("Mozyr");
		r.setUnloadingPoint("Gomel");
		r.setMileage(120);
		r.setCargoId(2);
	}
	
	public void loadCargos() {
		if(cargos == null) {
			cargos = new ArrayList<Cargo>();
		} else {
			cargos.clear();
		}
		Cargo c = null;
		
		c = new Cargo();
		c.setCargoId(1);
		c.setName("Computers");
		c.setWeight("1500kg");
		
		c = new Cargo();
		c.setCargoId(2);
		c.setName("Furniture");
		c.setWeight("3200kg");
	}
	
	public void loadDrivers() {
		if (drivers == null) {
			drivers = new TreeSet<Driver>();
		} else {
			drivers.clear();
		}
		
		Driver d = null;
		Calendar c = Calendar.getInstance();
		
		d = new Driver();
		d.setDriverId(1);
		d.setFirstName("Frank");
		d.setSurName("Litle");
		d.setPatronymic("Be");
		d.setSex('M');
		c.set(1995, 8, 25);
		d.setDateOfBirth(c.getTime());
		d.setLorryId(2);
		d.setWorkExperience(32);
		drivers.add(d);
		
		d = new Driver();
		d.setDriverId(2);
		d.setFirstName("Kim");
		d.setSurName("Litle");
		d.setPatronymic("Fock");
		d.setSex('W');
		c.set(1988, 5, 17);
		d.setDateOfBirth(c.getTime());
		d.setLorryId(2);
		d.setWorkExperience(18);
		drivers.add(d);
		
		d = new Driver();
		d.setDriverId(3);
		d.setFirstName("Fredy");
		d.setSurName("Hight");
		d.setPatronymic("Wood");
		d.setSex('M');
		c.set(1999, 12, 31);
		d.setDateOfBirth(c.getTime());
		d.setLorryId(1);
		d.setWorkExperience(32);
		drivers.add(d);
		
		d = new Driver();
		d.setDriverId(4);
		d.setFirstName("Kristy");
		d.setSurName("Green");
		d.setPatronymic("Free");
		d.setSex('W');
		c.set(1200, 6, 18);
		d.setDateOfBirth(c.getTime());
		d.setLorryId(1);
		d.setWorkExperience(19);
		drivers.add(d);
	}
	
	public List<Lorry> getLorries() {
		return lorries;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public Collection<Driver> getAllDrivers() {
		return drivers;
	}
	
	public Collection<Driver> getDriversFromLorry(Lorry lorry, int year) {
		Collection<Driver> l = new TreeSet<Driver>();
		for (Driver di : drivers) {
			if (di.getLorryId() == lorry.getLorryId() && di.getWorkExperience() == year) {
				l.add(di); 
			}
	    }
	    return l;
	}
	
	public void moveDriversToLorry(Lorry oldLorry, int oldYear, Lorry newLorry, int newYear) {
	    for (Driver di : drivers) {
	    	if (di.getLorryId() == oldLorry.getLorryId() && di.getWorkExperience() == oldYear) {
	    		di.setLorryId(newLorry.getLorryId());
	    		di.setWorkExperience(newYear);
	    	}
	    }
	}
	
	public void removeDriversFromLorry(Lorry lorry, int year) {
		Collection<Driver> tmp = new TreeSet<Driver>();
		for (Driver di : drivers) {
			if (di.getLorryId() != lorry.getLorryId() || di.getWorkExperience() != year) {
                tmp.add(di);				
			}
		}
		drivers = tmp;
	}
	
	public Collection<Driver> getDriversFromRoute(Route route, int year) {
		Collection<Driver> r = new TreeSet<Driver>();
		for (Driver di : drivers) {
			if (di.getLorryId() == route.getRouteId() && di.getWorkExperience() == year) {
				r.add(di);
			}
		}
		return r;
	}
		
	public void moveDriversToRoute(Route oldRoute, int oldYear, Route newRoute, int newYear) {
		for (Driver di : drivers) {
			if (di.getLorryId() == oldRoute.getRouteId() && di.getWorkExperience() == oldYear) {
				di.setLorryId(newRoute.getRouteId());
				di.setWorkExperience(newYear);
			}
		}
	}
	
	public void removeDriversFromRoute(Route route, int year) {
		Collection<Driver> tmp = new TreeSet<Driver>();
		for (Driver di : drivers) {
			if (di.getLorryId() != route.getRouteId() || di.getWorkExperience() != year) {
				tmp.add(di);
			}
		}
		drivers = tmp;
	}
	
	public TreeSet<Lorry> getLorriesFromRoute(Route route, int id) {
		TreeSet<Lorry> r = new TreeSet<Lorry>();
		for (Lorry li : lorries) {
			if (li.getLorryId() == route.getRouteId() && li.getRouteId() == id) {
				r.add(li);
			}
		}
		return r;
	}
	
	public void moveLorriesToRoute(Route oldRoute, int oldYear, Route newRoute, int newYear) {
		for (Lorry li : lorries) {
			if (li.getLorryId() == oldRoute.getRouteId() && li.getRouteId() == oldYear) {
				li.setLorryId(newRoute.getRouteId());
				li.setRouteId(newYear);
			}
		}
	}
	
	public void removeLorriesFromRoute(Route route, int id) {
		List<Lorry> tmp = new ArrayList<Lorry>();
		for (Lorry li : lorries) {
			if (li.getLorryId() != route.getRouteId() || li.getRouteId() != id) {
				tmp.add(li);
			}
		}
		lorries = tmp;
	}
	
	public TreeSet<Cargo> getCargosFromLorry(Lorry lorry, int id) {
		TreeSet<Cargo> l = new TreeSet<Cargo>();
		for (Cargo ci : cargos) {
			if (ci.getCargoId() == lorry.getRouteId() && ci.getCargoId() == id) {
				l.add(ci);
			}
		}
		return l;
	}
	
	public void moveCargosToLorry(Lorry oldLorry, int oldYear, Lorry newLorry, int newYear) {
		for (Cargo ci : cargos) {
			if (ci.getCargoId() == oldLorry.getRouteId() && ci.getCargoId() == oldYear) {
				ci.setCargoId(newLorry.getCargoId());
				ci.setCargoId(newYear);
			}
		}
	}
	
	public void removeCargosFromLorry(Lorry lorry, int id) {
		List<Cargo> tmp = new ArrayList<Cargo>();
		for (Cargo ci : cargos) {
			if (ci.getCargoId() != lorry.getCargoId() || ci.getCargoId() != id) {
				tmp.add(ci);
			}
		}
		cargos = tmp;
	}
	
	public void insertDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public void updateDriver(Driver driver) {
		Driver updDriver = null;
		for (Driver di : drivers) {
			if (di.getDriverId() == driver.getDriverId()) {
				updDriver = di;
				break;
			}
		}
		updDriver.setFirstName(driver.getFirstName());
		updDriver.setPatronymic(driver.getPatronymic());
		updDriver.setSurName(driver.getSurName());
		updDriver.setSex(driver.getSex());
		updDriver.setDateOfBirth(driver.getDateOfBirth());
		updDriver.setLorryId(driver.getLorryId());
		updDriver.setWorkExperience(driver.getWorkExperience());
	}
	
	public void deleteDriver(Driver driver) {
		Driver delDriver = null;
		for (Driver di : drivers) {
			if (di.getDriverId() == driver.getDriverId()) {
				delDriver = di;
				break;
			}
		}
		drivers.remove(delDriver);
	}
	
	public static void printString(Object s) {
		try {
			System.out.println(new String(s.toString().getBytes("windows-1251"), "windows-1251"));
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void printString() {
		System.out.println();
	}
}

	





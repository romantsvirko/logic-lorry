package logic;

import java.text.Collator;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Driver implements Comporable  {

	private int driverId;
	
	private String firstName;
	
	private String surName;
	
	private String patronymic;
	
	private Date dateOfBirth;
	
	private char sex;
	
	private int lorryId;
	
	private int workExperience;
	
	public int getDriverId() {
		return driverId;
	}
	
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public void setPatronymic(String patronimic) {
		this.patronymic = patronimic;
	}
	
	public Date getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public char getSex() {
    	return sex;
    }
    
    public void setSex(char sex) {
    	this.sex = sex;
    }
    
    public int getLorryId() {
    	return lorryId;
    }
    
    public void setLorryId(int lorryId) {
    	this.lorryId = lorryId;
    }
    
    public int getWorkExperience() {
    	return workExperience;
    }
    
    public void setWorkExperience(int workExperience) {
    	this.workExperience = workExperience;
    }
    
    public String toString() {
        return surName + " " + firstName + " " + patronymic + ", "
                + DateFormat.getDateInstance(DateFormat.SHORT).format(dateOfBirth)
                + ", lorry ID=" + lorryId + " work experience:" + workExperience;
    }
 
    public int compareTo(Object obj) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }

	
}
